/*******************************************************************************
 * Copyright (c) 2010, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.mylyn.docs.intent.bridge.modelingbot.ui;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.modelingBot.ModelingBot;
import org.eclipse.emf.eef.modelingBot.Scenario;
import org.eclipse.emf.eef.modelingBot.validation.ModelingBotValidationUtils;
import org.eclipse.mylyn.docs.intent.client.ui.editor.IntentEditorDocument;
import org.eclipse.mylyn.docs.intent.client.ui.editor.annotation.IntentAnnotation;
import org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.AbstractIntentFix;
import org.eclipse.mylyn.docs.intent.client.ui.logger.IntentUiLogger;
import org.eclipse.mylyn.docs.intent.collab.handlers.adapters.IntentCommand;
import org.eclipse.mylyn.docs.intent.collab.handlers.adapters.RepositoryAdapter;
import org.eclipse.mylyn.docs.intent.core.modelingunit.ExternalContentReference;
import org.eclipse.mylyn.docs.intent.core.modelingunit.ModelingUnit;
import org.eclipse.mylyn.docs.intent.core.modelingunit.ModelingUnitFactory;
import org.eclipse.swt.graphics.Image;

/**
 * @author <a href="mailto:alex.lagarde@obeo.fr">Alex Lagarde</a>
 */
public class CreateJavaTestFromModelingBotQuickFix extends AbstractIntentFix {

	/**
	 * Default constructor.
	 * 
	 * @param annotation
	 */
	public CreateJavaTestFromModelingBotQuickFix(IntentAnnotation annotation) {
		super(annotation);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.AbstractIntentFix#applyFix(org.eclipse.mylyn.docs.intent.collab.handlers.adapters.RepositoryAdapter,
	 *      org.eclipse.mylyn.docs.intent.client.ui.editor.IntentEditorDocument)
	 */
	@Override
	protected void applyFix(RepositoryAdapter repositoryAdapter, IntentEditorDocument document) {
		if (syncAnnotation.getCompilationStatus().getTarget() instanceof ExternalContentReference) {
			// Step 1: getting scenarios from currently focused instruction
			final ExternalContentReference instruction = (ExternalContentReference)syncAnnotation
					.getCompilationStatus().getTarget();
			Iterable<Scenario> scenarios = Sets.newLinkedHashSet();
			if (instruction.getExternalContent() instanceof ModelingBot) {
				scenarios = Iterables.filter(((ModelingBot)instruction.getExternalContent()).getSequences(),
						Scenario.class);
			} else if (instruction.getExternalContent() instanceof Scenario)
				scenarios = Lists.newArrayList((Scenario)instruction.getExternalContent());

			// Step 2: generate junit tests for each scenario
			final Collection<String> createdTestsPath = Sets.newLinkedHashSet();
			for (Scenario scenario : scenarios) {
				createdTestsPath.addAll(createJUnitTestForScenario(instruction, scenario));
			}

			// Step 3: generated @ref for each created test
			if (scenarios.iterator().hasNext()) {
				repositoryAdapter.execute(new IntentCommand() {

					public void execute() {
						if (instruction.eContainer() instanceof ModelingUnit) {
							ModelingUnit modelingUnit = (ModelingUnit)instruction.eContainer();
							for (String createdTestPath : createdTestsPath) {
								ExternalContentReference testReferenceInstruction = ModelingUnitFactory.eINSTANCE
										.createExternalContentReference();
								testReferenceInstruction.setUri(createdTestPath);
								modelingUnit.getInstructions().add(testReferenceInstruction);
							}
						}
					}
				});
			}
			document.reloadFromAST();
		}
	}

	/**
	 * Creates the test file allowing to test the given {@link Scenario}
	 * 
	 * @param scenario
	 *            the {@link Scenario} to test
	 * @return the pathes of the created tests
	 */
	private Collection<? extends String> createJUnitTestForScenario(ExternalContentReference instruction,
			Scenario scenario) {
		Collection<String> createdTestPath = Sets.newLinkedHashSet();
		// Step 1: Create the corresponding java test file
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(ModelingBotValidationUtils.getProjectName(EcoreUtil.getURI(scenario)));
		String expectedTestPath = ModelingBotValidationUtils.getExpectedPath(project, scenario);
		String testSuitePath = "src/" + project.getName().replace(".", "/") + "/ScenariosTestSuite.java";
		File testFile = new File(ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/"
				+ project.getName() + "/" + expectedTestPath);
		File testSuiteFile = new File(ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/"
				+ project.getName() + "/" + testSuitePath);
		boolean fileWasCreated = false;
		Throwable cause = null;
		if (!testFile.exists()) {
			try {
				ArrayList<File> parentFiles = Lists.newArrayList();
				File parentFile = testFile.getParentFile();
				while (parentFile != null && !parentFile.exists()) {
					parentFiles.add(0, parentFile);
					parentFile = parentFile.getParentFile();
				}
				for (File parentFileToCreate : parentFiles) {
					parentFileToCreate.mkdir();
				}
				if (testFile.createNewFile()) {
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
					IFile iFile = project.getFile(expectedTestPath);

					// Step 2: set test file content
					String javaFileContent = getScenarioTestFileContent(scenario,
							URI.createURI(instruction.getUri().toString()), expectedTestPath);
					iFile.setContents(new ByteArrayInputStream(javaFileContent.getBytes()), true, true,
							new NullProgressMonitor());
					fileWasCreated = true;
					createdTestPath.add(project.getName() + "/" + expectedTestPath);
				}

				// Step 3: create test suite if needed
				if (!testSuiteFile.exists()) {
					if (testSuiteFile.createNewFile()) {
						project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
						IFile iFile = project.getFile(testSuitePath);
						String testSuiteContent = getTestSuiteFileContent(testSuitePath);
						iFile.setContents(new ByteArrayInputStream(testSuiteContent.getBytes()), true, true,
								new NullProgressMonitor());
						createdTestPath.add(project.getName() + "/" + expectedTestPath);
					}
				}

				// Step 4: add test to test suite
				addTestToTestSuite(project, testSuitePath, expectedTestPath);
			} catch (IOException e) {
				cause = e;
			} catch (CoreException e) {
				cause = e;
			}
		}
		if (!fileWasCreated) {
			IntentUiLogger.logError("Could not create the java test corresponding to the new scenario "
					+ scenario.getName() + ".", cause);
		}
		return createdTestPath;
	}

	/**
	 * Returns the content of the test file allowing to test the given {@link Scenario}.
	 * 
	 * @param scenario
	 *            the {@link Scenario} to test
	 * @param intentURI
	 *            the intent {@link URI} of the scenario
	 * @param filePath
	 *            the filePath
	 * @return the content of the test file allowing to test the given {@link Scenario}
	 */
	private String getScenarioTestFileContent(Scenario scenario, URI intentURI, String filePath) {
		String packageName = filePath.replace("src/", "").replace(".java", "").replace("/", ".");
		packageName = packageName.substring(0, packageName.lastIndexOf(".")).toLowerCase();
		String className = scenario.getName().replace(" ", "");
		className = className.substring(0, 1).toUpperCase() + className.substring(1) + "Test";
		StringBuilder content = new StringBuilder();

		content.append("package " + packageName + ";");
		content.append("\n/**");
		content.append("\n* Tests the '" + scenario.getName() + "' Scenario.");
		content.append("\n*/");
		content.append("\npublic class " + className
				+ " extends org.eclipse.emf.eef.modelingBot.testcase.AbstractComposedModelingBotTestCase {");
		content.append("\n\tpublic void testModelingBot() throws Exception {");
		content.append("\n\t\tbot.runModelingBot(\"" + intentURI.toString() + "\");");
		content.append("\n\t}");
		content.append("\n}");
		return content.toString();
	}

	/**
	 * Returns the initial content of the scenario test suite.
	 * 
	 * @param testSuitePath
	 *            the testSuitePath
	 * @return the initial content of the scenario test suite.
	 */
	private String getTestSuiteFileContent(String testSuitePath) {
		String packageName = testSuitePath.replace("src/", "").replace(".java", "").replace("/", ".");
		packageName = packageName.substring(0, packageName.lastIndexOf(".")).toLowerCase();
		String className = "ScenariosTestSuite";
		StringBuilder content = new StringBuilder();
		content.append("package " + packageName + ";");
		content.append("\nimport junit.framework.Test;");
		content.append("\nimport junit.framework.TestCase;");
		content.append("\nimport junit.framework.TestSuite;\n");
		content.append("\n/**");
		content.append("\n* Launches all the defined Scenarios.");
		content.append("\n*/");
		content.append("\npublic class " + className + " extends TestCase {");
		content.append("\n\tpublic static Test suite() {");
		content.append("\n\t\tTestSuite suite = new TestSuite(" + className + ".class.getName());");
		content.append("\n\t\treturn suite;");
		content.append("\n\t}");
		content.append("\n}");
		return content.toString();
	}

	/**
	 * Adds the given test to the given test suite.
	 * 
	 * @param project
	 *            the {@link IProject} containing the test and test suite
	 * @param testSuitePath
	 *            the path of the test suite to modify
	 * @param testToAddPath
	 *            the path of the test to add to the test suite
	 * @throws CoreException
	 *             if issues occur while trying to modify file
	 * @throws IOException
	 *             if issues occur while trying to modify file
	 */
	private void addTestToTestSuite(IProject project, String testSuitePath, String testToAddPath)
			throws CoreException, IOException {
		IFile iFile = project.getFile(testSuitePath);
		InputStream in = iFile.getContents();
		InputStreamReader is = new InputStreamReader(in);
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(is);
		String read = br.readLine();

		while (read != null) {
			// System.out.println(read);
			sb.append("\n" + read);
			read = br.readLine();
		}
		String createdTestClass = testToAddPath.replace(".java", "").replace("src/", "").replace("/", ".");
		String testSuiteContent = sb
				.toString()
				.replace("return suite;",
						"suite.addTestSuite(" + createdTestClass + ".class);\n\t\treturn suite;").trim();
		iFile.setContents(new ByteArrayInputStream(testSuiteContent.getBytes()), true, true,
				new NullProgressMonitor());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.text.contentassist.ICompletionProposal#getDisplayString()
	 */
	public String getDisplayString() {
		return "Generate Junit test for this scenario";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.AbstractIntentFix#getImage()
	 */
	@Override
	public Image getImage() {
		// Could be overidden
		return super.getImage();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.mylyn.docs.intent.client.ui.editor.quickfix.AbstractIntentFix#getAdditionalProposalInfo()
	 */
	@Override
	public String getAdditionalProposalInfo() {
		return "additional infos";
	}

}

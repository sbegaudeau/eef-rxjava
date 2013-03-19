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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
import org.eclipse.mylyn.docs.intent.collab.handlers.adapters.RepositoryAdapter;
import org.eclipse.mylyn.docs.intent.core.modelingunit.ExternalContentReference;
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
			ExternalContentReference instruction = (ExternalContentReference)syncAnnotation
					.getCompilationStatus().getTarget();
			Iterable<Scenario> scenarios = Sets.newLinkedHashSet();
			if (instruction.getExternalContent() instanceof ModelingBot) {
				scenarios = Iterables.filter(((ModelingBot)instruction.getExternalContent()).getSequences(),
						Scenario.class);
			} else if (instruction.getExternalContent() instanceof Scenario)
				scenarios = Lists.newArrayList((Scenario)instruction.getExternalContent());

			// Step 2: generate junit tests for each scenario
			for (Scenario scenario : scenarios) {
				createJUnitTestForScenario(instruction, scenario);
			}

			// Step 3: set document dirty
			if (scenarios.iterator().hasNext()) {
				document.set(document.get() + " ");
			}
		}
	}

	/**
	 * Creates the test file allowing to test the given {@link Scenario}
	 * 
	 * @param scenario
	 *            the {@link Scenario} to test
	 */
	private void createJUnitTestForScenario(ExternalContentReference instruction, Scenario scenario) {
		// Step 1: Create the corresponding java test file
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.getProject(ModelingBotValidationUtils.getProjectName(EcoreUtil.getURI(scenario)));
		String expectedPath = ModelingBotValidationUtils.getExpectedPath(project, scenario);
		File file = new File(ResourcesPlugin.getWorkspace().getRoot().getLocation() + "/" + project.getName()
				+ "/" + expectedPath);

		boolean fileWasCreated = false;
		Throwable cause = null;
		if (!file.exists()) {
			try {
				ArrayList<File> parentFiles = Lists.newArrayList();
				File parentFile = file.getParentFile();
				while (parentFile != null && !parentFile.exists()) {
					parentFiles.add(0, parentFile);
					parentFile = parentFile.getParentFile();
				}
				for (File parentFileToCreate : parentFiles) {
					parentFileToCreate.mkdir();
				}
				if (file.createNewFile()) {
					project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
					IFile iFile = project.getFile(expectedPath);

					// Step 2: set test file content
					String javaFileContent = getScenarioTestFileContent(scenario,
							URI.createURI(instruction.getUri().toString()), expectedPath);
					iFile.setContents(new ByteArrayInputStream(javaFileContent.getBytes()), true, true,
							new NullProgressMonitor());
					fileWasCreated = true;
				}
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
		// TODO remove *.java and improve class name
		String packageName = filePath.replace("src/", "").replace(".java", "").replace("/", ".");
		packageName = packageName.substring(0, packageName.lastIndexOf(".")).toLowerCase();
		String className = scenario.getName().replace(" ", "");
		className = className.substring(0, 1).toUpperCase() + className.substring(1) + "Test";
		StringBuilder content = new StringBuilder();

		content.append("package " + packageName + ";");
		content.append("\npublic class " + className
				+ " extends org.eclipse.emf.eef.modelingBot.testcase.AbstractComposedModelingBotTestCase {");
		content.append("\n\tpublic void testModelingBot() throws Exception {");
		content.append("\n\t\tbot.runModelingBot(\"" + intentURI.toString() + "\");");
		content.append("\n\t}");
		content.append("\n}");
		return content.toString();
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

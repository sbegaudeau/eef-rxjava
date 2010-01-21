/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.samples.conference.tests.junit.properties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.eef.runtime.EEFRuntimePlugin;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsResourceUtils;
import org.eclipse.emf.samples.conference.ConferencePackage;
import org.eclipse.emf.samples.conference.providers.ConferenceMessages;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
/**
 * TestCase for Topic
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class TopicPropertiesTestCase extends SWTBotEEFTestCase {
	
	/**
	 *  The project that contains models for tests 
	 */
	protected static final String TESTS_PROJECT_NAME = "org.eclipse.emf.examples.eef.tests.junit";
	
	/**
	 *  The folder that contains the input models for tests 
	 */
	protected static final String INPUT_MODEL_FOLDER = "input";
	
	/**
	 *  The folder that contains the expected models for tests 
	 */	 
	protected static final String EXPECTED_MODEL_FOLDER = "expected";
	
	/**
	 * The input model
	 */
	protected static final String INPUT_MODEL_NAME = "input.conference";
	
	/**
	 * The expected model
	 */
	protected static final String EXPECTED_MODEL_NAME = "expected.conference";
	
	/**
	 * The test project
	 */
	private IProject testProject;
	
	/**
	 * The workspace folder containing the input model 
	 */
	private IFolder modelFolder;
	
	/**
	 * The expectedModel 
	 */
	protected Resource expectedModel;
	
	/**
	 * The ResourceSet where to operate
	 */
	protected AdapterFactoryEditingDomain editingDomain = new AdapterFactoryEditingDomain(EEFRuntimePlugin.getDefault().getAdapterFactory(), new BasicCommandStack());
	
	/**
	 * The EClass of the type to edit
	 */
	private EClass topicMetaClass = ConferencePackage.eINSTANCE.getTopic();
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#initWorkspaceForTests()
	 */
	protected void initWorkspaceForTests() throws CoreException, IOException {
		List<String> names = new ArrayList<String>();
		names.add(INPUT_MODEL_FOLDER);
		testProject = EEFTestsResourceUtils.createTestProject(TESTS_PROJECT_NAME, names);
		modelFolder = testProject.getFolder(INPUT_MODEL_FOLDER);
	}

	/**
	 * Import the input model
	 * @throws CoreException error during model import
	 * @throws IOException error during model import
	 */
	protected void initializeInputModel() throws CoreException, IOException  {
		EEFTestsResourceUtils.importModel(TESTS_PROJECT_NAME, "models/" + INPUT_MODEL_FOLDER + "/" + INPUT_MODEL_NAME, modelFolder);
		URI fileURI = URI.createPlatformResourceURI(TESTS_PROJECT_NAME + "/" + INPUT_MODEL_FOLDER + "/" + INPUT_MODEL_NAME, true);
		Resource activeResource = editingDomain.getResourceSet().getResource(fileURI, true);
		bot.defineActiveModel(activeResource);
	}
	
	/**
	 * Delete the test models
	 * @throws CoreException error during model deleting
	 */
	protected void deleteModels() throws CoreException {
		IFile inputFile = EEFTestsResourceUtils.workspaceFile(bot.getActiveResource());
		bot.unloadActiveModel();
		NullProgressMonitor monitor = new NullProgressMonitor();
		inputFile.delete(true, true, monitor);
		IFile expectedFile = EEFTestsResourceUtils.workspaceFile(expectedModel);
		expectedModel.unload();
		expectedFile.delete(true, true, monitor);
		testProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForTopicDescription() throws InputModelInvalidException, IOException {
		// Create the resource for the expected model
		URI fileURI = URI.createPlatformResourceURI(TESTS_PROJECT_NAME + "/" + EXPECTED_MODEL_FOLDER + "/" + EXPECTED_MODEL_NAME, true);
		expectedModel = editingDomain.getResourceSet().createResource(fileURI);
		
		// Create the expected model content by applying the attempted command on a copy of the input model content
		expectedModel.getContents().addAll(EcoreUtil.copyAll(bot.getActiveResource().getContents()));
		EObject topic = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, topicMetaClass);
		if (topic == null)
			throw new InputModelInvalidException("The input model doesn't contain enough instance of " + topicMetaClass.getName() + " EClass");
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, topic, ConferencePackage.eINSTANCE.getTopic_Description(), "value2"));
		editingDomain.getCommandStack().execute(cc);
		expectedModel.save(Collections.EMPTY_MAP);
	}
	/**
	 * Test the editor properties :
	 * - init the input model
	 * - calculate the expected model
	 * - initialize the model editor
	 * - change the properties in the editor properties
	 * - compare the expected and the real model : if they are equals the test pass
	 * - delete the models
	 */	
	public void testEditTopicDescription() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		// Create the expected model
		initializeExpectedModelForTopicDescription();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the Topic element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), topicMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException("The input model doesn't contain enough instance of " + topicMetaClass.getName() + " EClass");
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the description feature of the Topic element 
		bot.editPropertyTextFeature(propertiesView, ConferenceMessages.TopicPropertiesEditionPart_DescriptionLabel, "value2", bot.selectNode(modelEditor, firstInstanceOf));	
		
		// Save the changement
		bot.finalizeEdition(modelEditor);
		
		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);
		
		// Delete the input model
		deleteModels();
	
	}
	


}

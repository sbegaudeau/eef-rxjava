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
import java.util.Collections;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.emf.samples.conference.ConferencePackage;
import org.eclipse.emf.samples.conference.providers.ConferenceMessages;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
/**
 * TestCase for Person
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class PersonPropertiesTestCase extends SWTBotEEFTestCase {
	
	/**
	 * The EClass of the type to edit
	 */
	private EClass personMetaClass = ConferencePackage.eINSTANCE.getPerson();

	/**
	 * Updated value of the feature
	 */
	private static final String UPDATED_VALUE = "value2";
	
	/**{@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelName()
	 */
	protected String getExpectedModelName() {
		return "expected.conference";
	}
	/**{@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getInputModelFolder()
	 */
	protected String getInputModelFolder() {
		return "input";
	}

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getInputModelName()
	 */
	protected String getInputModelName() {
		return "input.conference";
	}

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getTestsProjectName()
	 */
	protected String getTestsProjectName() {
		return "org.eclipse.emf.examples.eef.tests.junit";
	}
	
	/**
	 *  The project that contains models for tests 
	 */
	/**{@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelFolder()
	 */
	protected String getExpectedModelFolder() {
		return "expected";
	}
	
	/**{@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getImportModelsFolder()
	 */
	protected String getImportModelsFolder() {
		return  "models";
	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForPersonFirstname() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject person = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, personMetaClass);
		if (person == null)
			throw new InputModelInvalidException(personMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, person, ConferencePackage.eINSTANCE.getPerson_Firstname(), UPDATED_VALUE));
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
	public void testEditPersonFirstname() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		// Create the expected model
		initializeExpectedModelForPersonFirstname();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the Person element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), personMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(personMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the firstname feature of the Person element 
		bot.editPropertyTextFeature(propertiesView, ConferenceMessages.PersonPropertiesEditionPart_FirstnameLabel, UPDATED_VALUE, bot.selectNode(modelEditor, firstInstanceOf));	
		
		// Save the changement
		bot.finalizeEdition(modelEditor);
		
		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);
		
		// Delete the input model
		deleteModels();
	
	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForPersonLastname() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject person = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, personMetaClass);
		if (person == null)
			throw new InputModelInvalidException(personMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, person, ConferencePackage.eINSTANCE.getPerson_Lastname(), UPDATED_VALUE));
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
	public void testEditPersonLastname() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		// Create the expected model
		initializeExpectedModelForPersonLastname();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the Person element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), personMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(personMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the lastname feature of the Person element 
		bot.editPropertyTextFeature(propertiesView, ConferenceMessages.PersonPropertiesEditionPart_LastnameLabel, UPDATED_VALUE, bot.selectNode(modelEditor, firstInstanceOf));	
		
		// Save the changement
		bot.finalizeEdition(modelEditor);
		
		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);
		
		// Delete the input model
		deleteModels();
	
	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForPersonEclipseCommiter() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject person = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, personMetaClass);
		if (person == null)
			throw new InputModelInvalidException(personMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		Boolean oldValue = (Boolean)person.eGet(ConferencePackage.eINSTANCE.getPerson_EclipseCommiter());
		cc.append(SetCommand.create(editingDomain, person, ConferencePackage.eINSTANCE.getPerson_EclipseCommiter(), !oldValue));
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
	public void testEditPersonEclipseCommiter() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		// Create the expected model
		initializeExpectedModelForPersonEclipseCommiter();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the Person element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), personMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(personMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the eclipseCommiter feature of the Person element 
		bot.editPropertyCheckboxFeature(propertiesView, ConferenceMessages.PersonPropertiesEditionPart_EclipseCommiterLabel, bot.selectNode(modelEditor, firstInstanceOf));	
		
		// Save the changement
		bot.finalizeEdition(modelEditor);
		
		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);
		
		// Delete the input model
		deleteModels();
	
	}
	/**
	 * Create the expected model from the input model
	 * @throws InputModelInvalidException error during expected model initialization
	 * @throws IOException error during expected model serialization
	 */
	protected void initializeExpectedModelForPersonIsRegistered() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject person = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, personMetaClass);
		if (person == null)
			throw new InputModelInvalidException(personMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		Boolean oldValue = (Boolean)person.eGet(ConferencePackage.eINSTANCE.getPerson_IsRegistered());
		cc.append(SetCommand.create(editingDomain, person, ConferencePackage.eINSTANCE.getPerson_IsRegistered(), !oldValue));
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
	public void testEditPersonIsRegistered() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		// Create the expected model
		initializeExpectedModelForPersonIsRegistered();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the Person element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), personMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(personMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the isRegistered feature of the Person element 
		bot.editPropertyCheckboxFeature(propertiesView, ConferenceMessages.PersonPropertiesEditionPart_IsRegisteredLabel, bot.selectNode(modelEditor, firstInstanceOf));	
		
		// Save the changement
		bot.finalizeEdition(modelEditor);
		
		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);
		
		// Delete the input model
		deleteModels();
	
	}
		// FIXME : define 'additionnalMethodsForWidgets' (from widgetTest.mtl) for case (Text - EString) 

		// FIXME : define 'additionnalMethodsForWidgets' (from widgetTest.mtl) for case (Text - EString) 

		// FIXME : define 'additionnalMethodsForWidgets' (from widgetTest.mtl) for case (Checkbox - EBoolean) 

		// FIXME : define 'additionnalMethodsForWidgets' (from widgetTest.mtl) for case (Checkbox - EBoolean) 



}

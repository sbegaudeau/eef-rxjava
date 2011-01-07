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
package org.eclipse.emf.samples.conference.tests.junit;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.exceptions.WidgetInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.emf.samples.conference.ConferencePackage;
import org.eclipse.emf.samples.conference.Person;
import org.eclipse.emf.samples.conference.Site;
import org.eclipse.emf.samples.conference.Talk;
import org.eclipse.emf.samples.conference.Topic;
import org.eclipse.emf.samples.conference.parts.ConferenceViewsRepository;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
/**
 * TestCase for Conference
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class ConferenceTestCase extends SWTBotEEFTestCase {

	/**
	 * The EClass of the type to edit
	 */
	private EClass conferenceMetaClass = ConferencePackage.eINSTANCE.getConference();

	/**
	 * The type to edit
	 */
	private EObject conference;

	/**
	 * The EClass of the reference to edit
	 */
	private EClass siteMetaClass = ConferencePackage.eINSTANCE.getSite();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass topicMetaClass = ConferencePackage.eINSTANCE.getTopic();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass talkMetaClass = ConferencePackage.eINSTANCE.getTalk();

	/**
	 * The EClass of the reference to edit
	 */
	private EClass personMetaClass = ConferencePackage.eINSTANCE.getPerson();
	/**
	 * The eObjects list contained in widgets
	 */
	private List allInstancesOf;
	/**
	 * Updated value of the feature
	 */
	private static final String UPDATED_VALUE = "value2";

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelName()
	 */
	protected String getExpectedModelName() {
		return "expected.conference";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getInputModelFolder()
	 */
	protected String getInputModelFolder() {
		return "input";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getInputModelName()
	 */
	protected String getInputModelName() {
		return "input.conference";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getTestsProjectName()
	 */
	protected String getTestsProjectName() {
		return "org.eclipse.emf.examples.eef.tests.junit";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelFolder()
	 */
	protected String getExpectedModelFolder() {
		// The project that contains models for tests
		return "expected";
	}

	/**
	 * {@inheritDoc}
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
	protected void initializeExpectedModelForConferencePlace() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				cc.append(SetCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Place(), UPDATED_VALUE));
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
	public void testEditConferencePlace() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForConferencePlace();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Localisation");

		// Change value of the place feature of the Conference element 
				bot.editTextFeature(wizardShell, ConferenceViewsRepository.Localisation.place, UPDATED_VALUE);

		// Save the modification
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
	protected void initializeExpectedModelForConferenceSites() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		EClass siteMetaClass = ConferencePackage.eINSTANCE.getSite();
		EObject site = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, siteMetaClass);
		if (site == null)
			throw new InputModelInvalidException(siteMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		cc.append(AddCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Sites(), EcoreUtil.copy(site)));
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
	public void testEditConferenceSites() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForConferenceSites();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Localisation");

		// Change value of the sites feature of the Conference element 
		editAdvancedTableCompositionsitesFeature(wizardShell);

		// Save the modification
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
	protected void initializeRemoveExpectedModelForConferenceSites() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		List eGet = (List)conference.eGet(ConferencePackage.eINSTANCE.getConference_Sites());
		if (eGet.size() == 0)
			throw new InputModelInvalidException("Model is invalid");
		EObject firstInstanceOf = (EObject) eGet.get(0);
		cc.append(RemoveCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Sites(), firstInstanceOf));
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
	public void testRemoveConferenceSites() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForConferenceSites();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Localisation");

		// Change value of the sites feature of the Conference element 
				bot.removeAdvancedTableCompositionFeature(wizardShell, ConferenceViewsRepository.Localisation.sites);

		// Save the modification
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
	protected void initializeExpectedModelForConferenceName() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				cc.append(SetCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Name(), UPDATED_VALUE));
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
	public void testEditConferenceName() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForConferenceName();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Base");

		// Change value of the name feature of the Conference element 
				bot.editTextFeature(wizardShell, ConferenceViewsRepository.Conference_.Properties.name, UPDATED_VALUE);

		// Save the modification
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
	protected void initializeExpectedModelForConferenceOverview() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				cc.append(SetCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Overview(), UPDATED_VALUE));
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
	public void testEditConferenceOverview() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForConferenceOverview();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Base");

		// Change value of the overview feature of the Conference element 
				bot.editTextFeature(wizardShell, ConferenceViewsRepository.Conference_.Properties.overview, UPDATED_VALUE);

		// Save the modification
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
	protected void initializeExpectedModelForConferenceParticipants() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		EClass personMetaClass = ConferencePackage.eINSTANCE.getPerson();
		EObject person = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, personMetaClass);
		if (person == null)
			throw new InputModelInvalidException(personMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		cc.append(AddCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Participants(), EcoreUtil.copy(person)));
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
	public void testEditConferenceParticipants() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForConferenceParticipants();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Participants");

		// Change value of the participants feature of the Conference element 
		editAdvancedTableCompositionparticipantsFeature(wizardShell);

		// Save the modification
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
	protected void initializeRemoveExpectedModelForConferenceParticipants() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		List eGet = (List)conference.eGet(ConferencePackage.eINSTANCE.getConference_Participants());
		if (eGet.size() == 0)
			throw new InputModelInvalidException("Model is invalid");
		EObject firstInstanceOf = (EObject) eGet.get(0);
		cc.append(RemoveCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Participants(), firstInstanceOf));
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
	public void testRemoveConferenceParticipants() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForConferenceParticipants();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Participants");

		// Change value of the participants feature of the Conference element 
				bot.removeAdvancedTableCompositionFeature(wizardShell, ConferenceViewsRepository.Participants.participants_);

		// Save the modification
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
	protected void initializeExpectedModelForConferenceTalks() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		EClass talkMetaClass = ConferencePackage.eINSTANCE.getTalk();
		EObject talk = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, talkMetaClass);
		if (talk == null)
			throw new InputModelInvalidException(talkMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		cc.append(AddCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Talks(), EcoreUtil.copy(talk)));
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
	public void testEditConferenceTalks() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForConferenceTalks();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Talks_and_Topics");

		// Change value of the talks feature of the Conference element 
		editAdvancedTableCompositiontalksFeature(wizardShell);

		// Save the modification
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
	protected void initializeRemoveExpectedModelForConferenceTalks() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		List eGet = (List)conference.eGet(ConferencePackage.eINSTANCE.getConference_Talks());
		if (eGet.size() == 0)
			throw new InputModelInvalidException("Model is invalid");
		EObject firstInstanceOf = (EObject) eGet.get(0);
		cc.append(RemoveCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Talks(), firstInstanceOf));
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
	public void testRemoveConferenceTalks() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForConferenceTalks();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Talks_and_Topics");

		// Change value of the talks feature of the Conference element 
				bot.removeAdvancedTableCompositionFeature(wizardShell, ConferenceViewsRepository.TalksAndTopics.talks);

		// Save the modification
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
	protected void initializeExpectedModelForConferenceTopics() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		EClass topicMetaClass = ConferencePackage.eINSTANCE.getTopic();
		EObject topic = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, topicMetaClass);
		if (topic == null)
			throw new InputModelInvalidException(topicMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		cc.append(AddCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Topics(), EcoreUtil.copy(topic)));
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
	public void testEditConferenceTopics() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeExpectedModelForConferenceTopics();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Talks_and_Topics");

		// Change value of the topics feature of the Conference element 
		editAdvancedTableCompositiontopicsFeature(wizardShell);

		// Save the modification
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
	protected void initializeRemoveExpectedModelForConferenceTopics() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject conference = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		List eGet = (List)conference.eGet(ConferencePackage.eINSTANCE.getConference_Topics());
		if (eGet.size() == 0)
			throw new InputModelInvalidException("Model is invalid");
		EObject firstInstanceOf = (EObject) eGet.get(0);
		cc.append(RemoveCommand.create(editingDomain, conference, ConferencePackage.eINSTANCE.getConference_Topics(), firstInstanceOf));
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
	public void testRemoveConferenceTopics() throws Exception {

		// Import the input model
		initializeInputModel();

		conference = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (conference == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		// Create the expected model
		initializeRemoveExpectedModelForConferenceTopics();

		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();

		// Open the EEF wizard (by double click) to edit the Conference element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), conferenceMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(conferenceMetaClass.getName());

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, conferenceMetaClass, firstInstanceOf, "Talks_and_Topics");

		// Change value of the topics feature of the Conference element 
				bot.removeAdvancedTableCompositionFeature(wizardShell, ConferenceViewsRepository.TalksAndTopics.topics);

		// Save the modification
		bot.finalizeEdition(modelEditor);

		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);

		// Delete the input model
		deleteModels();

	}


	/**
	 * Edit the feature in the table composition
	 */
	protected void editAdvancedTableCompositionForsitesFeature() throws WidgetInvalidException {
		EClass siteMetaClass = ConferencePackage.eINSTANCE.getSite();
		SWTBotShell shellTable = bot.shell(siteMetaClass.getName());
		bot.activateShell(shellTable);
		Site site = (Site) EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), siteMetaClass);
		bot.sleep(500);
		// Change value of the documentation feature of the documentation element 
				bot.editEEFText(ConferenceViewsRepository.Site.Properties.documentation, site.getDocumentation());
		bot.sleep(500);
		// Change value of the name feature of the name element 
				bot.editEEFText(ConferenceViewsRepository.Site.Properties.name, site.getName());
		bot.closeShellWithFinishButton(shellTable);
	}
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositionsitesFeature(SWTBotShell wizardShell) throws WidgetInvalidException {
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.addButtonAdvancedTableComposition(ConferenceViewsRepository.Localisation.sites).click();
		editAdvancedTableCompositionForsitesFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}




	/**
	 * Edit the feature in the table composition
	 */
	protected void editAdvancedTableCompositionForparticipantsFeature() throws WidgetInvalidException {
		EClass personMetaClass = ConferencePackage.eINSTANCE.getPerson();
		SWTBotShell shellTable = bot.shell(personMetaClass.getName());
		bot.activateShell(shellTable);
		Person person = (Person) EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), personMetaClass);
		bot.sleep(500);
		// Change value of the firstname feature of the firstname element 
				bot.editEEFText(ConferenceViewsRepository.Person.Identity.firstname, person.getFirstname());
		bot.sleep(500);
		// Change value of the lastname feature of the lastname element 
				bot.editEEFText(ConferenceViewsRepository.Person.Identity.lastname, person.getLastname());
		bot.sleep(500);
		// Change value of the age feature of the age element 
				bot.editEEFText(ConferenceViewsRepository.Person.Identity.age, person.getAge());
		bot.sleep(500);
		// Change value of the eclipseCommiter feature of the eclipseCommiter element 
				bot.editCheckBox(ConferenceViewsRepository.Person.EclipseStatus.eclipseCommiter, person.isEclipseCommiter());
		bot.sleep(500);
		// Change value of the assists feature of the assists element 
		bot.editAdvancedReferencesTableValues(ConferenceViewsRepository.Presence.Talks.assists, person.getAssists());
		bot.sleep(500);
		// Change value of the gender feature of the gender element 
				bot.editEMFComboViewer(ConferenceViewsRepository.Person.Identity.gender, person.getGender());
		bot.sleep(500);
		// Change value of the isRegistered feature of the isRegistered element 
				bot.editCheckBox(ConferenceViewsRepository.Person.EclipseStatus.isRegistered, person.isIsRegistered());
		bot.closeShellWithFinishButton(shellTable);
	}
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositionparticipantsFeature(SWTBotShell wizardShell) throws WidgetInvalidException {
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.addButtonAdvancedTableComposition(ConferenceViewsRepository.Participants.participants_).click();
		editAdvancedTableCompositionForparticipantsFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}
	/**
	 * Edit the feature in the table composition
	 */
	protected void editAdvancedTableCompositionFortalksFeature() throws WidgetInvalidException {
		EClass talkMetaClass = ConferencePackage.eINSTANCE.getTalk();
		SWTBotShell shellTable = bot.shell(talkMetaClass.getName());
		bot.activateShell(shellTable);
		Talk talk = (Talk) EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), talkMetaClass);
		bot.sleep(500);
		// Change value of the title feature of the title element 
				bot.editEEFText(ConferenceViewsRepository.Talk.Properties.title_, talk.getTitle());
		bot.sleep(500);
		// Change value of the topic feature of the topic element 
		if (talk.getTopic() != null) {
			allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, topicMetaClass);
			bot.editEObjectFlatComboViewer(ConferenceViewsRepository.Talk.Properties.topic, allInstancesOf.indexOf(talk.getTopic()));
		}
		bot.sleep(500);
		// Change value of the type feature of the type element 
				bot.editEMFComboViewer(ConferenceViewsRepository.Talk.Properties.type, talk.getType());
		bot.sleep(500);
		// Change value of the presenter feature of the presenter element 
		if (talk.getPresenter() != null) {
			allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, personMetaClass);
			bot.editEObjectFlatComboViewer(ConferenceViewsRepository.Talk.Properties.presenter, allInstancesOf.indexOf(talk.getPresenter()));
		}
		bot.sleep(500);
		// Change value of the creator feature of the creator element 
		if (talk.getCreator() != null) {
			allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, personMetaClass);
			bot.editEObjectFlatComboViewer(ConferenceViewsRepository.Talk.Properties.creator, allInstancesOf.indexOf(talk.getCreator()));
		}
		bot.sleep(500);
		// Change value of the documentation feature of the documentation element 
				bot.editEEFText(ConferenceViewsRepository.Talk.Properties.documentation, talk.getDocumentation());
		bot.closeShellWithFinishButton(shellTable);
	}
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositiontalksFeature(SWTBotShell wizardShell) throws WidgetInvalidException {
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.addButtonAdvancedTableComposition(ConferenceViewsRepository.TalksAndTopics.talks).click();
		editAdvancedTableCompositionFortalksFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}
	/**
	 * Edit the feature in the table composition
	 */
	protected void editAdvancedTableCompositionFortopicsFeature() throws WidgetInvalidException {
		EClass topicMetaClass = ConferencePackage.eINSTANCE.getTopic();
		SWTBotShell shellTable = bot.shell(topicMetaClass.getName());
		bot.activateShell(shellTable);
		Topic topic = (Topic) EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), topicMetaClass);
		bot.sleep(500);
		// Change value of the description feature of the description element 
				bot.editEEFText(ConferenceViewsRepository.Topic.Properties.description, topic.getDescription());
		bot.sleep(500);
		// Change value of the references feature of the references element 
				bot.editMultiValuedEditor(ConferenceViewsRepository.Topic.Properties.references, topic.getReferences());
		bot.sleep(500);
		// Change value of the documentation feature of the documentation element 
				bot.editEEFText(ConferenceViewsRepository.Topic.Properties.documentation, topic.getDocumentation());
		bot.closeShellWithFinishButton(shellTable);
	}
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositiontopicsFeature(SWTBotShell wizardShell) throws WidgetInvalidException {
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.addButtonAdvancedTableComposition(ConferenceViewsRepository.TalksAndTopics.topics).click();
		editAdvancedTableCompositionFortopicsFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}


}

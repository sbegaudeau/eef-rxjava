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
package org.eclipse.emf.eef.eefnr.tests.junit.properties;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.Sample;
import org.eclipse.emf.eef.eefnr.TotalSample;
import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.emf.eef.runtime.tests.utils.UIConstants;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
/**
 * TestCase for TotalSample
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class TotalSamplePropertiesTestCase extends SWTBotEEFTestCase {
	
	/**
	 * The EClass of the type to edit
	 */
	private EClass totalSampleMetaClass = EefnrPackage.eINSTANCE.getTotalSample();

	/**
	 * The type to edit
	 */
	private EObject totalSample;
	
	/**
	 * The enum value for the enum class radioRequiredProperty
	 */
	private Object enumValueForRadioRequiredProperty;		
	/**
	 * The enum value for the enum class radioOptionalProperty
	 */
	private Object enumValueForRadioOptionalProperty;		
	/**
	 * The enum value for the enum class emfcomboviewerRequiredProperty
	 */
	private Object enumValueForEmfcomboviewerRequiredProperty;		
	/**
	 * The enum value for the enum class emfcomboviewerOptionalProperty
	 */
	private Object enumValueForEmfcomboviewerOptionalProperty;		
	
	/**
	 * Updated value of the feature
	 */
	private static final String UPDATED_VALUE = "value2";
	
	/**{@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getExpectedModelName()
	 */
	protected String getExpectedModelName() {
		return "expected.eefnr";
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
		return "input.eefnr";
	}

	/**{@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getTestsProjectName()
	 */
	protected String getTestsProjectName() {
		return "org.eclipse.emf.eef.tests.nonreg.junit";
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
	protected void initializeExpectedModelForTotalSampleTextRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextRequiredProperty(), UPDATED_VALUE));
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
	public void testEditTotalSampleTextRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForTotalSampleTextRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the textRequiredProperty feature of the TotalSample element 
		bot.editPropertyTextFeature(propertiesView, EefnrMessages.TotalSamplePropertiesEditionPart_TextRequiredPropertyLabel, UPDATED_VALUE, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleTextOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextOptionalProperty(), UPDATED_VALUE));
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
	public void testEditTotalSampleTextOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForTotalSampleTextOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the textOptionalProperty feature of the TotalSample element 
		bot.editPropertyTextFeature(propertiesView, EefnrMessages.TotalSamplePropertiesEditionPart_TextOptionalPropertyLabel, UPDATED_VALUE, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleCheckboxRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		Boolean oldValue = (Boolean)totalSample.eGet(EefnrPackage.eINSTANCE.getTotalSample_CheckboxRequiredProperty());
		cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_CheckboxRequiredProperty(), !oldValue));
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
	public void testEditTotalSampleCheckboxRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForTotalSampleCheckboxRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the checkboxRequiredProperty feature of the TotalSample element 
		bot.editPropertyCheckboxFeature(propertiesView, EefnrMessages.TotalSamplePropertiesEditionPart_CheckboxRequiredPropertyLabel, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleCheckboxOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		Boolean oldValue = (Boolean)totalSample.eGet(EefnrPackage.eINSTANCE.getTotalSample_CheckboxOptionalProperty());
		cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_CheckboxOptionalProperty(), !oldValue));
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
	public void testEditTotalSampleCheckboxOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForTotalSampleCheckboxOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the checkboxOptionalProperty feature of the TotalSample element 
		bot.editPropertyCheckboxFeature(propertiesView, EefnrMessages.TotalSamplePropertiesEditionPart_CheckboxOptionalPropertyLabel, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleTextareaRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextareaRequiredProperty(), UPDATED_VALUE));
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
	public void testEditTotalSampleTextareaRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForTotalSampleTextareaRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the textareaRequiredProperty feature of the TotalSample element 
		bot.editPropertyTextFeature(propertiesView, EefnrMessages.TotalSamplePropertiesEditionPart_TextareaRequiredPropertyLabel, UPDATED_VALUE, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleTextareaOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TextareaOptionalProperty(), UPDATED_VALUE));
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
	public void testEditTotalSampleTextareaOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForTotalSampleTextareaOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the textareaOptionalProperty feature of the TotalSample element 
		bot.editPropertyTextFeature(propertiesView, EefnrMessages.TotalSamplePropertiesEditionPart_TextareaOptionalPropertyLabel, UPDATED_VALUE, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleRadioRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_RadioRequiredProperty(), EefnrPackage.eINSTANCE.getENUM_SAMPLE().getEEnumLiteralByLiteral(enumValueForRadioRequiredProperty.toString()).getInstance()));
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
	public void testEditTotalSampleRadioRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		enumValueForRadioRequiredProperty = bot.changeEnumLiteralValue(EefnrPackage.eINSTANCE.getENUM_SAMPLE(), ((TotalSample)totalSample).getRadioRequiredProperty().getLiteral());
				
		// Create the expected model
		initializeExpectedModelForTotalSampleRadioRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the radioRequiredProperty feature of the TotalSample element 
		bot.editPropertyEMFComboViewerFeature(propertiesView, enumValueForRadioRequiredProperty, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleRadioOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_RadioOptionalProperty(), EefnrPackage.eINSTANCE.getENUM_SAMPLE().getEEnumLiteralByLiteral(enumValueForRadioOptionalProperty.toString()).getInstance()));
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
	public void testEditTotalSampleRadioOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		enumValueForRadioOptionalProperty = bot.changeEnumLiteralValue(EefnrPackage.eINSTANCE.getENUM_SAMPLE(), ((TotalSample)totalSample).getRadioOptionalProperty().getLiteral());
				
		// Create the expected model
		initializeExpectedModelForTotalSampleRadioOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the radioOptionalProperty feature of the TotalSample element 
		bot.editPropertyEMFComboViewerFeature(propertiesView, enumValueForRadioOptionalProperty, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleEmfcomboviewerRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerRequiredProperty(), EefnrPackage.eINSTANCE.getENUM_SAMPLE().getEEnumLiteralByLiteral(enumValueForEmfcomboviewerRequiredProperty.toString()).getInstance()));
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
	public void testEditTotalSampleEmfcomboviewerRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		enumValueForEmfcomboviewerRequiredProperty = bot.changeEnumLiteralValue(EefnrPackage.eINSTANCE.getENUM_SAMPLE(), ((TotalSample)totalSample).getEmfcomboviewerRequiredProperty().getLiteral());
				
		// Create the expected model
		initializeExpectedModelForTotalSampleEmfcomboviewerRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the emfcomboviewerRequiredProperty feature of the TotalSample element 
		bot.editPropertyEMFComboViewerFeature(propertiesView, enumValueForEmfcomboviewerRequiredProperty, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleEmfcomboviewerOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_EmfcomboviewerOptionalProperty(), EefnrPackage.eINSTANCE.getENUM_SAMPLE().getEEnumLiteralByLiteral(enumValueForEmfcomboviewerOptionalProperty.toString()).getInstance()));
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
	public void testEditTotalSampleEmfcomboviewerOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		enumValueForEmfcomboviewerOptionalProperty = bot.changeEnumLiteralValue(EefnrPackage.eINSTANCE.getENUM_SAMPLE(), ((TotalSample)totalSample).getEmfcomboviewerOptionalProperty().getLiteral());
				
		// Create the expected model
		initializeExpectedModelForTotalSampleEmfcomboviewerOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the emfcomboviewerOptionalProperty feature of the TotalSample element 
		bot.editPropertyEMFComboViewerFeature(propertiesView, enumValueForEmfcomboviewerOptionalProperty, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleTablecompositionRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		EObject sample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, sampleMetaClass);
		if (sample == null)
			throw new InputModelInvalidException(sampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionRequiredProperty(), EcoreUtil.copy(sample)));
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
	public void testEditTotalSampleTablecompositionRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForTotalSampleTablecompositionRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the tablecompositionRequiredProperty feature of the TotalSample element
		editAdvancedTableCompositiontablecompositionRequiredPropertyFeature(propertiesView, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleTablecompositionOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		EObject sample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, sampleMetaClass);
		if (sample == null)
			throw new InputModelInvalidException(sampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_TablecompositionOptionalProperty(), EcoreUtil.copy(sample)));
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
	public void testEditTotalSampleTablecompositionOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForTotalSampleTablecompositionOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the tablecompositionOptionalProperty feature of the TotalSample element
		editAdvancedTableCompositiontablecompositionOptionalPropertyFeature(propertiesView, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleAdvancedtablecompositionRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		EObject sample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, sampleMetaClass);
		if (sample == null)
			throw new InputModelInvalidException(sampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionRequiredProperty(), EcoreUtil.copy(sample)));
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
	public void testEditTotalSampleAdvancedtablecompositionRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForTotalSampleAdvancedtablecompositionRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the advancedtablecompositionRequiredProperty feature of the TotalSample element
		editAdvancedTableCompositionadvancedtablecompositionRequiredPropertyFeature(propertiesView, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void initializeExpectedModelForTotalSampleAdvancedtablecompositionOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		EObject sample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, sampleMetaClass);
		if (sample == null)
			throw new InputModelInvalidException(sampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(AddCommand.create(editingDomain, totalSample, EefnrPackage.eINSTANCE.getTotalSample_AdvancedtablecompositionOptionalProperty(), EcoreUtil.copy(sample)));
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
	public void testEditTotalSampleAdvancedtablecompositionOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		totalSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForTotalSampleAdvancedtablecompositionOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF properties view to edit the TotalSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the advancedtablecompositionOptionalProperty feature of the TotalSample element
		editAdvancedTableCompositionadvancedtablecompositionOptionalPropertyFeature(propertiesView, bot.selectNode(modelEditor, firstInstanceOf));	
		
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

		// FIXME : define 'additionnalMethodsForWidgets' (from widgetTest.mtl) for case (Text - EString) 

		// FIXME : define 'additionnalMethodsForWidgets' (from widgetTest.mtl) for case (Text - EString) 

		// FIXME : define 'additionnalMethodsForWidgets' (from widgetTest.mtl) for case (EMFComboViewer - ENUM_SAMPLE) 

		// FIXME : define 'additionnalMethodsForWidgets' (from widgetTest.mtl) for case (EMFComboViewer - ENUM_SAMPLE) 

		// FIXME : define 'additionnalMethodsForWidgets' (from widgetTest.mtl) for case (EMFComboViewer - ENUM_SAMPLE) 

		// FIXME : define 'additionnalMethodsForWidgets' (from widgetTest.mtl) for case (EMFComboViewer - ENUM_SAMPLE) 

	/**
	 * Edit the feature in the table composition
	 */
	protected void editAdvancedTableCompositionFortablecompositionRequiredPropertyFeature() {
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		SWTBotShell shellTable = bot.shell(sampleMetaClass.getName());
		bot.activateShell(shellTable);
		Sample sample = (Sample) EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, sampleMetaClass);
		bot.closeShellWithFinishButton(shellTable);
	}	
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositiontablecompositionRequiredPropertyFeature(SWTBotView propertyView, SWTBotTreeItem selectNode) {
		SWTBot propertyBot = propertyView.bot();
		propertyBot.buttonWithTooltip(UIConstants.TABLE_COMPOSITION_ADD_A_NEW_ELEMENT_BUTTON).click();
		editAdvancedTableCompositionFortablecompositionRequiredPropertyFeature();
		selectNode.select();
	}
	/**
	 * Edit the feature in the table composition
	 */
	protected void editAdvancedTableCompositionFortablecompositionOptionalPropertyFeature() {
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		SWTBotShell shellTable = bot.shell(sampleMetaClass.getName());
		bot.activateShell(shellTable);
		Sample sample = (Sample) EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, sampleMetaClass);
		bot.closeShellWithFinishButton(shellTable);
	}	
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositiontablecompositionOptionalPropertyFeature(SWTBotView propertyView, SWTBotTreeItem selectNode) {
		SWTBot propertyBot = propertyView.bot();
		propertyBot.buttonWithTooltip(UIConstants.TABLE_COMPOSITION_ADD_A_NEW_ELEMENT_BUTTON).click();
		editAdvancedTableCompositionFortablecompositionOptionalPropertyFeature();
		selectNode.select();
	}
	/**
	 * Edit the feature in the table composition
	 */
	protected void editAdvancedTableCompositionForadvancedtablecompositionRequiredPropertyFeature() {
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		SWTBotShell shellTable = bot.shell(sampleMetaClass.getName());
		bot.activateShell(shellTable);
		Sample sample = (Sample) EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, sampleMetaClass);
		bot.closeShellWithFinishButton(shellTable);
	}	
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositionadvancedtablecompositionRequiredPropertyFeature(SWTBotView propertyView, SWTBotTreeItem selectNode) {
		SWTBot propertyBot = propertyView.bot();
		propertyBot.buttonWithTooltip(UIConstants.TABLE_COMPOSITION_ADD_A_NEW_ELEMENT_BUTTON).click();
		editAdvancedTableCompositionForadvancedtablecompositionRequiredPropertyFeature();
		selectNode.select();
	}
	/**
	 * Edit the feature in the table composition
	 */
	protected void editAdvancedTableCompositionForadvancedtablecompositionOptionalPropertyFeature() {
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		SWTBotShell shellTable = bot.shell(sampleMetaClass.getName());
		bot.activateShell(shellTable);
		Sample sample = (Sample) EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, sampleMetaClass);
		bot.closeShellWithFinishButton(shellTable);
	}	
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositionadvancedtablecompositionOptionalPropertyFeature(SWTBotView propertyView, SWTBotTreeItem selectNode) {
		SWTBot propertyBot = propertyView.bot();
		propertyBot.buttonWithTooltip(UIConstants.TABLE_COMPOSITION_ADD_A_NEW_ELEMENT_BUTTON).click();
		editAdvancedTableCompositionForadvancedtablecompositionOptionalPropertyFeature();
		selectNode.select();
	}


}

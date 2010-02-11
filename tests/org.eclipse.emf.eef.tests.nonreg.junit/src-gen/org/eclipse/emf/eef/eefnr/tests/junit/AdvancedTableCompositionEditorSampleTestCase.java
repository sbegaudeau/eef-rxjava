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
package org.eclipse.emf.eef.eefnr.tests.junit;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TotalSample;
import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.exceptions.WidgetInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.emf.eef.runtime.ui.utils.EEFRuntimeUIMessages;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
/**
 * TestCase for AdvancedTableCompositionEditorSample
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class AdvancedTableCompositionEditorSampleTestCase extends SWTBotEEFTestCase {
	
	/**
	 * The EClass of the type to edit
	 */
	private EClass advancedTableCompositionEditorSampleMetaClass = EefnrPackage.eINSTANCE.getAdvancedTableCompositionEditorSample();

	/**
	 * The type to edit
	 */
	private EObject advancedTableCompositionEditorSample;
	/**
	 * The EClass of the reference to edit
	 */
	private EClass totalSampleMetaClass = EefnrPackage.eINSTANCE.getTotalSample();	
	/**
	 * The eObjects list contained in widgets
	 */
	private List allInstancesOf;
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
	protected void initializeExpectedModelForAdvancedTableCompositionEditorSampleAdvancedtablecompositionRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject advancedTableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, advancedTableCompositionEditorSampleMetaClass);
		if (advancedTableCompositionEditorSample == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
		EClass totalSampleMetaClass = EefnrPackage.eINSTANCE.getTotalSample();
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(AddCommand.create(editingDomain, advancedTableCompositionEditorSample, EefnrPackage.eINSTANCE.getAdvancedTableCompositionEditorSample_AdvancedtablecompositionRequiredProperty(), EcoreUtil.copy(totalSample)));
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
	public void testEditAdvancedTableCompositionEditorSampleAdvancedtablecompositionRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		advancedTableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedTableCompositionEditorSampleMetaClass);
		if (advancedTableCompositionEditorSample == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
	
		// Create the expected model
		initializeExpectedModelForAdvancedTableCompositionEditorSampleAdvancedtablecompositionRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the AdvancedTableCompositionEditorSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedTableCompositionEditorSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, advancedTableCompositionEditorSampleMetaClass, firstInstanceOf, "Base");
		
		// Change value of the advancedtablecompositionRequiredProperty feature of the AdvancedTableCompositionEditorSample element 
		editAdvancedTableCompositionadvancedtablecompositionRequiredPropertyFeature(wizardShell);	
		
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
	protected void initializeRemoveExpectedModelForAdvancedTableCompositionEditorSampleAdvancedtablecompositionRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject advancedTableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, advancedTableCompositionEditorSampleMetaClass);
		if (advancedTableCompositionEditorSample == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		allInstancesOf = ((AdvancedTableCompositionEditorSample)advancedTableCompositionEditorSample).getAdvancedtablecompositionRequiredProperty();
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(allInstancesOf, totalSampleMetaClass);
		cc.append(RemoveCommand.create(editingDomain, advancedTableCompositionEditorSample, EefnrPackage.eINSTANCE.getAdvancedTableCompositionEditorSample_AdvancedtablecompositionRequiredProperty(), firstInstanceOf));
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
	public void testRemoveAdvancedTableCompositionEditorSampleAdvancedtablecompositionRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		advancedTableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedTableCompositionEditorSampleMetaClass);
		if (advancedTableCompositionEditorSample == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
	
		// Create the expected model
		initializeRemoveExpectedModelForAdvancedTableCompositionEditorSampleAdvancedtablecompositionRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the AdvancedTableCompositionEditorSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedTableCompositionEditorSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, advancedTableCompositionEditorSampleMetaClass, firstInstanceOf, "Base");
		
		// Change value of the advancedtablecompositionRequiredProperty feature of the AdvancedTableCompositionEditorSample element 
		bot.removeAdvancedTableCompositionFeature(wizardShell, 0);	
		
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
	protected void initializeExpectedModelForAdvancedTableCompositionEditorSampleAdvancedtablecompositionOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject advancedTableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, advancedTableCompositionEditorSampleMetaClass);
		if (advancedTableCompositionEditorSample == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
		EClass totalSampleMetaClass = EefnrPackage.eINSTANCE.getTotalSample();
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(AddCommand.create(editingDomain, advancedTableCompositionEditorSample, EefnrPackage.eINSTANCE.getAdvancedTableCompositionEditorSample_AdvancedtablecompositionOptionalProperty(), EcoreUtil.copy(totalSample)));
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
	public void testEditAdvancedTableCompositionEditorSampleAdvancedtablecompositionOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		advancedTableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedTableCompositionEditorSampleMetaClass);
		if (advancedTableCompositionEditorSample == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
	
		// Create the expected model
		initializeExpectedModelForAdvancedTableCompositionEditorSampleAdvancedtablecompositionOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the AdvancedTableCompositionEditorSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedTableCompositionEditorSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, advancedTableCompositionEditorSampleMetaClass, firstInstanceOf, "Base");
		
		// Change value of the advancedtablecompositionOptionalProperty feature of the AdvancedTableCompositionEditorSample element 
		editAdvancedTableCompositionadvancedtablecompositionOptionalPropertyFeature(wizardShell);	
		
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
	protected void initializeRemoveExpectedModelForAdvancedTableCompositionEditorSampleAdvancedtablecompositionOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject advancedTableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, advancedTableCompositionEditorSampleMetaClass);
		if (advancedTableCompositionEditorSample == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		allInstancesOf = ((AdvancedTableCompositionEditorSample)advancedTableCompositionEditorSample).getAdvancedtablecompositionOptionalProperty();
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(allInstancesOf, totalSampleMetaClass);
		cc.append(RemoveCommand.create(editingDomain, advancedTableCompositionEditorSample, EefnrPackage.eINSTANCE.getAdvancedTableCompositionEditorSample_AdvancedtablecompositionOptionalProperty(), firstInstanceOf));
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
	public void testRemoveAdvancedTableCompositionEditorSampleAdvancedtablecompositionOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		advancedTableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedTableCompositionEditorSampleMetaClass);
		if (advancedTableCompositionEditorSample == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
	
		// Create the expected model
		initializeRemoveExpectedModelForAdvancedTableCompositionEditorSampleAdvancedtablecompositionOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the AdvancedTableCompositionEditorSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedTableCompositionEditorSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(advancedTableCompositionEditorSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, advancedTableCompositionEditorSampleMetaClass, firstInstanceOf, "Base");
		
		// Change value of the advancedtablecompositionOptionalProperty feature of the AdvancedTableCompositionEditorSample element 
		bot.removeAdvancedTableCompositionFeature(wizardShell, 1);	
		
		// Save the changement
		bot.finalizeEdition(modelEditor);
		
		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);
		
		// Delete the input model
		deleteModels();
	
	}	
	/**
	 * Edit the feature in the table composition
	 */
	protected void editAdvancedTableCompositionForadvancedtablecompositionRequiredPropertyFeature() throws WidgetInvalidException {
		EClass totalSampleMetaClass = EefnrPackage.eINSTANCE.getTotalSample();
		SWTBotShell shellTable = bot.shell(totalSampleMetaClass.getName());
		bot.activateShell(shellTable);
		TotalSample totalSample = (TotalSample) EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		bot.sleep(500);
		// Change value of the textRequiredProperty feature of the textRequiredProperty element 
		bot.editTextWithLabel(EefnrMessages.TotalSamplePropertiesEditionPart_TextRequiredPropertyLabel, totalSample.getTextRequiredProperty());
		bot.sleep(500);
		// Change value of the textOptionalProperty feature of the textOptionalProperty element 
		bot.editTextWithLabel(EefnrMessages.TotalSamplePropertiesEditionPart_TextOptionalPropertyLabel, totalSample.getTextOptionalProperty());
		bot.sleep(500);
		// Change value of the checkboxRequiredProperty feature of the checkboxRequiredProperty element 
		bot.editCheckBox(EefnrMessages.TotalSamplePropertiesEditionPart_CheckboxRequiredPropertyLabel, totalSample.isCheckboxRequiredProperty());
		bot.sleep(500);
		// Change value of the checkboxOptionalProperty feature of the checkboxOptionalProperty element 
		bot.editCheckBox(EefnrMessages.TotalSamplePropertiesEditionPart_CheckboxOptionalPropertyLabel, totalSample.isCheckboxOptionalProperty());
		bot.sleep(500);
		// Change value of the textareaRequiredProperty feature of the textareaRequiredProperty element 
		bot.editTextWithLabel(EefnrMessages.TotalSamplePropertiesEditionPart_TextareaRequiredPropertyLabel, totalSample.getTextareaRequiredProperty());
		bot.sleep(500);
		// Change value of the textareaOptionalProperty feature of the textareaOptionalProperty element 
		bot.editTextWithLabel(EefnrMessages.TotalSamplePropertiesEditionPart_TextareaOptionalPropertyLabel, totalSample.getTextareaOptionalProperty());
		bot.sleep(500);
		// Change value of the radioRequiredProperty feature of the radioRequiredProperty element 
		bot.editEMFComboViewer(EefnrMessages.TotalSamplePropertiesEditionPart_RadioRequiredPropertyLabel, totalSample.getRadioRequiredProperty());
		bot.sleep(500);
		// Change value of the radioOptionalProperty feature of the radioOptionalProperty element 
		bot.editEMFComboViewer(EefnrMessages.TotalSamplePropertiesEditionPart_RadioOptionalPropertyLabel, totalSample.getRadioOptionalProperty());
		bot.sleep(500);
		// Change value of the eobjectflatcomboviewerRequiredProperty feature of the eobjectflatcomboviewerRequiredProperty element 
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
		bot.editEObjectFlatComboViewer(0, allInstancesOf.indexOf(totalSample.getEobjectflatcomboviewerRequiredProperty()));
		bot.sleep(500);
		// Change value of the eobjectflatcomboviewerOptionalProperty feature of the eobjectflatcomboviewerOptionalProperty element 
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
		bot.editEObjectFlatComboViewer(1, allInstancesOf.indexOf(totalSample.getEobjectflatcomboviewerOptionalProperty()));
		bot.sleep(500);
		// Change value of the referencestableRequiredProperty feature of the referencestableRequiredProperty element 
		bot.editAdvancedReferencesTable(0, totalSample.getReferencestableRequiredProperty());
		bot.sleep(500);
		// Change value of the referencestableOptionalProperty feature of the referencestableOptionalProperty element 
		bot.editAdvancedReferencesTable(1, totalSample.getReferencestableOptionalProperty());
		bot.sleep(500);
		// Change value of the emfcomboviewerRequiredProperty feature of the emfcomboviewerRequiredProperty element 
		bot.editEMFComboViewer(EefnrMessages.TotalSamplePropertiesEditionPart_EmfcomboviewerRequiredPropertyLabel, totalSample.getEmfcomboviewerRequiredProperty());
		bot.sleep(500);
		// Change value of the emfcomboviewerOptionalProperty feature of the emfcomboviewerOptionalProperty element 
		bot.editEMFComboViewer(EefnrMessages.TotalSamplePropertiesEditionPart_EmfcomboviewerOptionalPropertyLabel, totalSample.getEmfcomboviewerOptionalProperty());
		bot.sleep(500);
		// Change value of the multivaluededitorRequiredProperty feature of the multivaluededitorRequiredProperty element 
		bot.editMultiValuedEditor(EefnrMessages.TotalSamplePropertiesEditionPart_MultivaluededitorRequiredPropertyLabel, totalSample.getMultivaluededitorRequiredProperty());
		bot.sleep(500);
		// Change value of the multivaluededitorOptionalProperty feature of the multivaluededitorOptionalProperty element 
		bot.editMultiValuedEditor(EefnrMessages.TotalSamplePropertiesEditionPart_MultivaluededitorOptionalPropertyLabel, totalSample.getMultivaluededitorOptionalProperty());
		bot.sleep(500);
		// Change value of the advancedreferencestableRequiredProperty feature of the advancedreferencestableRequiredProperty element 
		bot.editAdvancedReferencesTable(2, totalSample.getAdvancedreferencestableRequiredProperty());
		bot.sleep(500);
		// Change value of the advancedreferencestableOptionalProperty feature of the advancedreferencestableOptionalProperty element 
		bot.editAdvancedReferencesTable(3, totalSample.getAdvancedreferencestableOptionalProperty());
		bot.sleep(500);
		// Change value of the advancedeobjectflatcomboviewerRequiredPropery feature of the advancedeobjectflatcomboviewerRequiredPropery element 
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
		bot.editEObjectFlatComboViewer(2, allInstancesOf.indexOf(totalSample.getAdvancedeobjectflatcomboviewerRequiredPropery()));
		bot.sleep(500);
		// Change value of the advancedeobjectflatcomboviewerOptionalPropery feature of the advancedeobjectflatcomboviewerOptionalPropery element 
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
		bot.editEObjectFlatComboViewer(3, allInstancesOf.indexOf(totalSample.getAdvancedeobjectflatcomboviewerOptionalPropery()));
		bot.closeShellWithFinishButton(shellTable);
	}	
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositionadvancedtablecompositionRequiredPropertyFeature(SWTBotShell wizardShell) throws WidgetInvalidException {
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.buttonWithTooltip(EEFRuntimeUIMessages.ReferencesTable_add_tooltip).click();
		editAdvancedTableCompositionForadvancedtablecompositionRequiredPropertyFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}
	/**
	 * Edit the feature in the table composition
	 */
	protected void editAdvancedTableCompositionForadvancedtablecompositionOptionalPropertyFeature() throws WidgetInvalidException {
		EClass totalSampleMetaClass = EefnrPackage.eINSTANCE.getTotalSample();
		SWTBotShell shellTable = bot.shell(totalSampleMetaClass.getName());
		bot.activateShell(shellTable);
		TotalSample totalSample = (TotalSample) EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), totalSampleMetaClass);
		bot.sleep(500);
		// Change value of the textRequiredProperty feature of the textRequiredProperty element 
		bot.editTextWithLabel(EefnrMessages.TotalSamplePropertiesEditionPart_TextRequiredPropertyLabel, totalSample.getTextRequiredProperty());
		bot.sleep(500);
		// Change value of the textOptionalProperty feature of the textOptionalProperty element 
		bot.editTextWithLabel(EefnrMessages.TotalSamplePropertiesEditionPart_TextOptionalPropertyLabel, totalSample.getTextOptionalProperty());
		bot.sleep(500);
		// Change value of the checkboxRequiredProperty feature of the checkboxRequiredProperty element 
		bot.editCheckBox(EefnrMessages.TotalSamplePropertiesEditionPart_CheckboxRequiredPropertyLabel, totalSample.isCheckboxRequiredProperty());
		bot.sleep(500);
		// Change value of the checkboxOptionalProperty feature of the checkboxOptionalProperty element 
		bot.editCheckBox(EefnrMessages.TotalSamplePropertiesEditionPart_CheckboxOptionalPropertyLabel, totalSample.isCheckboxOptionalProperty());
		bot.sleep(500);
		// Change value of the textareaRequiredProperty feature of the textareaRequiredProperty element 
		bot.editTextWithLabel(EefnrMessages.TotalSamplePropertiesEditionPart_TextareaRequiredPropertyLabel, totalSample.getTextareaRequiredProperty());
		bot.sleep(500);
		// Change value of the textareaOptionalProperty feature of the textareaOptionalProperty element 
		bot.editTextWithLabel(EefnrMessages.TotalSamplePropertiesEditionPart_TextareaOptionalPropertyLabel, totalSample.getTextareaOptionalProperty());
		bot.sleep(500);
		// Change value of the radioRequiredProperty feature of the radioRequiredProperty element 
		bot.editEMFComboViewer(EefnrMessages.TotalSamplePropertiesEditionPart_RadioRequiredPropertyLabel, totalSample.getRadioRequiredProperty());
		bot.sleep(500);
		// Change value of the radioOptionalProperty feature of the radioOptionalProperty element 
		bot.editEMFComboViewer(EefnrMessages.TotalSamplePropertiesEditionPart_RadioOptionalPropertyLabel, totalSample.getRadioOptionalProperty());
		bot.sleep(500);
		// Change value of the eobjectflatcomboviewerRequiredProperty feature of the eobjectflatcomboviewerRequiredProperty element 
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
		bot.editEObjectFlatComboViewer(0, allInstancesOf.indexOf(totalSample.getEobjectflatcomboviewerRequiredProperty()));
		bot.sleep(500);
		// Change value of the eobjectflatcomboviewerOptionalProperty feature of the eobjectflatcomboviewerOptionalProperty element 
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
		bot.editEObjectFlatComboViewer(1, allInstancesOf.indexOf(totalSample.getEobjectflatcomboviewerOptionalProperty()));
		bot.sleep(500);
		// Change value of the referencestableRequiredProperty feature of the referencestableRequiredProperty element 
		bot.editAdvancedReferencesTable(0, totalSample.getReferencestableRequiredProperty());
		bot.sleep(500);
		// Change value of the referencestableOptionalProperty feature of the referencestableOptionalProperty element 
		bot.editAdvancedReferencesTable(1, totalSample.getReferencestableOptionalProperty());
		bot.sleep(500);
		// Change value of the emfcomboviewerRequiredProperty feature of the emfcomboviewerRequiredProperty element 
		bot.editEMFComboViewer(EefnrMessages.TotalSamplePropertiesEditionPart_EmfcomboviewerRequiredPropertyLabel, totalSample.getEmfcomboviewerRequiredProperty());
		bot.sleep(500);
		// Change value of the emfcomboviewerOptionalProperty feature of the emfcomboviewerOptionalProperty element 
		bot.editEMFComboViewer(EefnrMessages.TotalSamplePropertiesEditionPart_EmfcomboviewerOptionalPropertyLabel, totalSample.getEmfcomboviewerOptionalProperty());
		bot.sleep(500);
		// Change value of the multivaluededitorRequiredProperty feature of the multivaluededitorRequiredProperty element 
		bot.editMultiValuedEditor(EefnrMessages.TotalSamplePropertiesEditionPart_MultivaluededitorRequiredPropertyLabel, totalSample.getMultivaluededitorRequiredProperty());
		bot.sleep(500);
		// Change value of the multivaluededitorOptionalProperty feature of the multivaluededitorOptionalProperty element 
		bot.editMultiValuedEditor(EefnrMessages.TotalSamplePropertiesEditionPart_MultivaluededitorOptionalPropertyLabel, totalSample.getMultivaluededitorOptionalProperty());
		bot.sleep(500);
		// Change value of the advancedreferencestableRequiredProperty feature of the advancedreferencestableRequiredProperty element 
		bot.editAdvancedReferencesTable(2, totalSample.getAdvancedreferencestableRequiredProperty());
		bot.sleep(500);
		// Change value of the advancedreferencestableOptionalProperty feature of the advancedreferencestableOptionalProperty element 
		bot.editAdvancedReferencesTable(3, totalSample.getAdvancedreferencestableOptionalProperty());
		bot.sleep(500);
		// Change value of the advancedeobjectflatcomboviewerRequiredPropery feature of the advancedeobjectflatcomboviewerRequiredPropery element 
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
		bot.editEObjectFlatComboViewer(2, allInstancesOf.indexOf(totalSample.getAdvancedeobjectflatcomboviewerRequiredPropery()));
		bot.sleep(500);
		// Change value of the advancedeobjectflatcomboviewerOptionalPropery feature of the advancedeobjectflatcomboviewerOptionalPropery element 
		allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
		bot.editEObjectFlatComboViewer(3, allInstancesOf.indexOf(totalSample.getAdvancedeobjectflatcomboviewerOptionalPropery()));
		bot.closeShellWithFinishButton(shellTable);
	}	
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositionadvancedtablecompositionOptionalPropertyFeature(SWTBotShell wizardShell) throws WidgetInvalidException {
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.buttonWithTooltip(EEFRuntimeUIMessages.ReferencesTable_add_tooltip).click();
		editAdvancedTableCompositionForadvancedtablecompositionOptionalPropertyFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}


}

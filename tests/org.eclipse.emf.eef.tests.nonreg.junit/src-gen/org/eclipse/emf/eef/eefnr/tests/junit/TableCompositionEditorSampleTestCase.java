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
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TableCompositionEditorSample;
import org.eclipse.emf.eef.eefnr.TotalSample;
import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.exceptions.WidgetInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
/**
 * TestCase for TableCompositionEditorSample
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class TableCompositionEditorSampleTestCase extends SWTBotEEFTestCase {
	
	/**
	 * The EClass of the type to edit
	 */
	private EClass tableCompositionEditorSampleMetaClass = EefnrPackage.eINSTANCE.getTableCompositionEditorSample();

	/**
	 * The type to edit
	 */
	private EObject tableCompositionEditorSample;
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
	protected void initializeExpectedModelForTableCompositionEditorSampleTablecompositionRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		EClass totalSampleMetaClass = EefnrPackage.eINSTANCE.getTotalSample();
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(AddCommand.create(editingDomain, tableCompositionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionEditorSample_TablecompositionRequiredProperty(), EcoreUtil.copy(totalSample)));
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
	public void testEditTableCompositionEditorSampleTablecompositionRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
	
		// Create the expected model
		initializeExpectedModelForTableCompositionEditorSampleTablecompositionRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the TableCompositionEditorSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), tableCompositionEditorSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, tableCompositionEditorSampleMetaClass, firstInstanceOf);
		
		// Change value of the tablecompositionRequiredProperty feature of the TableCompositionEditorSample element 
		editTableCompositiontablecompositionRequiredPropertyFeature(wizardShell);	
		
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
	protected void initializeRemoveExpectedModelForTableCompositionEditorSampleTablecompositionRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		allInstancesOf = ((TableCompositionEditorSample)tableCompositionEditorSample).getTablecompositionRequiredProperty();
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(allInstancesOf, totalSampleMetaClass);
		cc.append(RemoveCommand.create(editingDomain, tableCompositionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionEditorSample_TablecompositionRequiredProperty(), firstInstanceOf));
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
	public void testRemoveTableCompositionEditorSampleTablecompositionRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
	
		// Create the expected model
		initializeRemoveExpectedModelForTableCompositionEditorSampleTablecompositionRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the TableCompositionEditorSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), tableCompositionEditorSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, tableCompositionEditorSampleMetaClass, firstInstanceOf);
		
		// Change value of the tablecompositionRequiredProperty feature of the TableCompositionEditorSample element 
		bot.removeTableCompositionFeature(wizardShell, 0, EefnrMessages.PropertiesEditionPart_RemoveTableViewerLabel);	
		
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
	protected void initializeExpectedModelForTableCompositionEditorSampleTablecompositionOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		EClass totalSampleMetaClass = EefnrPackage.eINSTANCE.getTotalSample();
		EObject totalSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		if (totalSample == null)
			throw new InputModelInvalidException(totalSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(AddCommand.create(editingDomain, tableCompositionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionEditorSample_TablecompositionOptionalProperty(), EcoreUtil.copy(totalSample)));
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
	public void testEditTableCompositionEditorSampleTablecompositionOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
	
		// Create the expected model
		initializeExpectedModelForTableCompositionEditorSampleTablecompositionOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the TableCompositionEditorSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), tableCompositionEditorSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, tableCompositionEditorSampleMetaClass, firstInstanceOf);
		
		// Change value of the tablecompositionOptionalProperty feature of the TableCompositionEditorSample element 
		editTableCompositiontablecompositionOptionalPropertyFeature(wizardShell);	
		
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
	protected void initializeRemoveExpectedModelForTableCompositionEditorSampleTablecompositionOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		allInstancesOf = ((TableCompositionEditorSample)tableCompositionEditorSample).getTablecompositionOptionalProperty();
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(allInstancesOf, totalSampleMetaClass);
		cc.append(RemoveCommand.create(editingDomain, tableCompositionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionEditorSample_TablecompositionOptionalProperty(), firstInstanceOf));
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
	public void testRemoveTableCompositionEditorSampleTablecompositionOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
	
		// Create the expected model
		initializeRemoveExpectedModelForTableCompositionEditorSampleTablecompositionOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the TableCompositionEditorSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), tableCompositionEditorSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, tableCompositionEditorSampleMetaClass, firstInstanceOf);
		
		// Change value of the tablecompositionOptionalProperty feature of the TableCompositionEditorSample element 
		bot.removeTableCompositionFeature(wizardShell, 1, EefnrMessages.PropertiesEditionPart_RemoveTableViewerLabel);	
		
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
	protected void editTableCompositionFortablecompositionRequiredPropertyFeature() throws WidgetInvalidException {
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
	protected void editTableCompositiontablecompositionRequiredPropertyFeature(SWTBotShell wizardShell) throws WidgetInvalidException{
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.button(EefnrMessages.PropertiesEditionPart_AddTableViewerLabel).click();
		editTableCompositionFortablecompositionRequiredPropertyFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}
	/**
	 * Edit the feature in the table composition
	 */
	protected void editTableCompositionFortablecompositionOptionalPropertyFeature() throws WidgetInvalidException {
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
	protected void editTableCompositiontablecompositionOptionalPropertyFeature(SWTBotShell wizardShell) throws WidgetInvalidException{
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.button(EefnrMessages.PropertiesEditionPart_AddTableViewerLabel).click();
		editTableCompositionFortablecompositionOptionalPropertyFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}


}

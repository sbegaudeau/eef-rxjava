/*******************************************************************************
 * Copyright (c) 2009 - 2010 Obeo.
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
import org.eclipse.emf.eef.eefnr.Sample;
import org.eclipse.emf.eef.eefnr.TableCompositionEditorSample;
import org.eclipse.emf.eef.eefnr.parts.EefnrViewsRepository;
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
	private EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
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
		return "expected.eefnr";
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
		return "input.eefnr";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase#getTestsProjectName()
	 */
	protected String getTestsProjectName() {
		return "org.eclipse.emf.eef.tests.nonreg.junit";
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
	protected void initializeExpectedModelForTableCompositionEditorSampleTablecompositionRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		EObject sample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, sampleMetaClass);
		if (sample == null)
			throw new InputModelInvalidException(sampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		cc.append(AddCommand.create(editingDomain, tableCompositionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionEditorSample_TablecompositionRequiredProperty(), EcoreUtil.copy(sample)));
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

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, tableCompositionEditorSampleMetaClass, firstInstanceOf, null);

		// Change value of the tablecompositionRequiredProperty feature of the TableCompositionEditorSample element 
		editTableCompositiontablecompositionRequiredPropertyFeature(wizardShell);

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
	protected void initializeRemoveExpectedModelForTableCompositionEditorSampleTablecompositionRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = ((TableCompositionEditorSample)tableCompositionEditorSample).getTablecompositionRequiredProperty();
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(allInstancesOf, sampleMetaClass);
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

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, tableCompositionEditorSampleMetaClass, firstInstanceOf, null);

		// Change value of the tablecompositionRequiredProperty feature of the TableCompositionEditorSample element 
		bot.removeTableCompositionFeature(wizardShell, EefnrViewsRepository.TableCompositionEditorSample.Properties.tablecompositionRequiredProperty);

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
	protected void initializeExpectedModelForTableCompositionEditorSampleTablecompositionOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		EObject sample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, sampleMetaClass);
		if (sample == null)
			throw new InputModelInvalidException(sampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		cc.append(AddCommand.create(editingDomain, tableCompositionEditorSample, EefnrPackage.eINSTANCE.getTableCompositionEditorSample_TablecompositionOptionalProperty(), EcoreUtil.copy(sample)));
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

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, tableCompositionEditorSampleMetaClass, firstInstanceOf, null);

		// Change value of the tablecompositionOptionalProperty feature of the TableCompositionEditorSample element 
		editTableCompositiontablecompositionOptionalPropertyFeature(wizardShell);

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
	protected void initializeRemoveExpectedModelForTableCompositionEditorSampleTablecompositionOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject tableCompositionEditorSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, tableCompositionEditorSampleMetaClass);
		if (tableCompositionEditorSample == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		allInstancesOf = ((TableCompositionEditorSample)tableCompositionEditorSample).getTablecompositionOptionalProperty();
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(allInstancesOf, sampleMetaClass);
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

		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, tableCompositionEditorSampleMetaClass, firstInstanceOf, null);

		// Change value of the tablecompositionOptionalProperty feature of the TableCompositionEditorSample element 
		bot.removeTableCompositionFeature(wizardShell, EefnrViewsRepository.TableCompositionEditorSample.Properties.tablecompositionOptionalProperty);

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
	protected void editTableCompositionFortablecompositionRequiredPropertyFeature() throws WidgetInvalidException {
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		SWTBotShell shellTable = bot.shell(sampleMetaClass.getName());
		bot.activateShell(shellTable);
		Sample sample = (Sample) EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), sampleMetaClass);
		bot.sleep(500);
		// Change value of the textRequiredProperty feature of the textRequiredProperty element 
				bot.editEEFText(EefnrViewsRepository.Sample.Properties.textRequiredProperty, sample.getTextRequiredProperty());
		bot.sleep(500);
		// Change value of the textOptionalProperty feature of the textOptionalProperty element 
				bot.editEEFText(EefnrViewsRepository.Sample.Properties.textOptionalProperty, sample.getTextOptionalProperty());
		bot.closeShellWithFinishButton(shellTable);
	}
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editTableCompositiontablecompositionRequiredPropertyFeature(SWTBotShell wizardShell) throws WidgetInvalidException{
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.addButtonTableComposition(EefnrViewsRepository.TableCompositionEditorSample.Properties.tablecompositionRequiredProperty).click();
		editTableCompositionFortablecompositionRequiredPropertyFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}
	/**
	 * Edit the feature in the table composition
	 */
	protected void editTableCompositionFortablecompositionOptionalPropertyFeature() throws WidgetInvalidException {
		EClass sampleMetaClass = EefnrPackage.eINSTANCE.getSample();
		SWTBotShell shellTable = bot.shell(sampleMetaClass.getName());
		bot.activateShell(shellTable);
		Sample sample = (Sample) EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), sampleMetaClass);
		bot.sleep(500);
		// Change value of the textRequiredProperty feature of the textRequiredProperty element 
				bot.editEEFText(EefnrViewsRepository.Sample.Properties.textRequiredProperty, sample.getTextRequiredProperty());
		bot.sleep(500);
		// Change value of the textOptionalProperty feature of the textOptionalProperty element 
				bot.editEEFText(EefnrViewsRepository.Sample.Properties.textOptionalProperty, sample.getTextOptionalProperty());
		bot.closeShellWithFinishButton(shellTable);
	}
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editTableCompositiontablecompositionOptionalPropertyFeature(SWTBotShell wizardShell) throws WidgetInvalidException{
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.addButtonTableComposition(EefnrViewsRepository.TableCompositionEditorSample.Properties.tablecompositionOptionalProperty).click();
		editTableCompositionFortablecompositionOptionalPropertyFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}


}

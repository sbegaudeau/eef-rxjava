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
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TotalSample;
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
 * TestCase for TableCompositionEditorSample
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class TableCompositionEditorSamplePropertiesTestCase extends SWTBotEEFTestCase {
	
	/**
	 * The EClass of the type to edit
	 */
	private EClass tableCompositionEditorSampleMetaClass = EefnrPackage.eINSTANCE.getTableCompositionEditorSample();

	/**
	 * The type to edit
	 */
	private EObject tableCompositionEditorSample;
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
		
		// Open the EEF properties view to edit the TableCompositionEditorSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), tableCompositionEditorSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the tablecompositionRequiredProperty feature of the TableCompositionEditorSample element
		editTableCompositiontablecompositionRequiredPropertyFeature(propertiesView, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
		
		// Open the EEF properties view to edit the TableCompositionEditorSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), tableCompositionEditorSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(tableCompositionEditorSampleMetaClass.getName());
		
		SWTBotView propertiesView = bot.prepareLiveEditing(modelEditor, firstInstanceOf);
		
		// Change value of the tablecompositionOptionalProperty feature of the TableCompositionEditorSample element
		editTableCompositiontablecompositionOptionalPropertyFeature(propertiesView, bot.selectNode(modelEditor, firstInstanceOf));	
		
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
	protected void editTableCompositionFortablecompositionRequiredPropertyFeature() {
		EClass totalSampleMetaClass = EefnrPackage.eINSTANCE.getTotalSample();
		SWTBotShell shellTable = bot.shell(totalSampleMetaClass.getName());
		bot.activateShell(shellTable);
		TotalSample totalSample = (TotalSample) EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		bot.closeShellWithFinishButton(shellTable);
	}	
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editTableCompositiontablecompositionRequiredPropertyFeature(SWTBotView propertyView, SWTBotTreeItem selectNode) {
		SWTBot propertyBot = propertyView.bot();
		propertyBot.button(UIConstants.ADD_BUTTON).click();
		editTableCompositionFortablecompositionRequiredPropertyFeature();
		selectNode.select();
	}
	/**
	 * Edit the feature in the table composition
	 */
	protected void editTableCompositionFortablecompositionOptionalPropertyFeature() {
		EClass totalSampleMetaClass = EefnrPackage.eINSTANCE.getTotalSample();
		SWTBotShell shellTable = bot.shell(totalSampleMetaClass.getName());
		bot.activateShell(shellTable);
		TotalSample totalSample = (TotalSample) EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, totalSampleMetaClass);
		bot.closeShellWithFinishButton(shellTable);
	}	
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editTableCompositiontablecompositionOptionalPropertyFeature(SWTBotView propertyView, SWTBotTreeItem selectNode) {
		SWTBot propertyBot = propertyView.bot();
		propertyBot.button(UIConstants.ADD_BUTTON).click();
		editTableCompositionFortablecompositionOptionalPropertyFeature();
		selectNode.select();
	}


}

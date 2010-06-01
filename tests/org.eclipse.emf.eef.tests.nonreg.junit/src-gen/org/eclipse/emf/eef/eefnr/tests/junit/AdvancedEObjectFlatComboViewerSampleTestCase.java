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
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.eef.eefnr.AdvancedEObjectFlatComboViewerSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
/**
 * TestCase for AdvancedEObjectFlatComboViewerSample
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class AdvancedEObjectFlatComboViewerSampleTestCase extends SWTBotEEFTestCase {

	/**
	 * The EClass of the type to edit
	 */
	private EClass advancedEObjectFlatComboViewerSampleMetaClass = EefnrPackage.eINSTANCE.getAdvancedEObjectFlatComboViewerSample();

	/**
	 * The type to edit
	 */
	private EObject advancedEObjectFlatComboViewerSample;
	/**
	 * The reference value for the reference class advancedeobjectflatcomboviewerOptionalProperty
	 */
	private Object referenceValueForAdvancedeobjectflatcomboviewerOptionalProperty;
	/**
	 * The reference value for the reference class advancedeobjectflatcomboviewerRequiredProperty
	 */
	private Object referenceValueForAdvancedeobjectflatcomboviewerRequiredProperty;
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
	protected void initializeExpectedModelForAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject advancedEObjectFlatComboViewerSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, advancedEObjectFlatComboViewerSampleMetaClass);
		if (advancedEObjectFlatComboViewerSample == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
				referenceValueForAdvancedeobjectflatcomboviewerRequiredProperty = bot.changeReferenceValue(allInstancesOf, ((AdvancedEObjectFlatComboViewerSample)advancedEObjectFlatComboViewerSample).getAdvancedeobjectflatcomboviewerRequiredProperty());
				cc.append(SetCommand.create(editingDomain, advancedEObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getAdvancedEObjectFlatComboViewerSample_AdvancedeobjectflatcomboviewerRequiredProperty(), referenceValueForAdvancedeobjectflatcomboviewerRequiredProperty));
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
	public void testEditAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		advancedEObjectFlatComboViewerSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedEObjectFlatComboViewerSampleMetaClass);
		if (advancedEObjectFlatComboViewerSample == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
	
		// Create the expected model
		initializeExpectedModelForAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the AdvancedEObjectFlatComboViewerSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedEObjectFlatComboViewerSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, advancedEObjectFlatComboViewerSampleMetaClass, firstInstanceOf, "Base");
		
		// Change value of the advancedeobjectflatcomboviewerRequiredProperty feature of the AdvancedEObjectFlatComboViewerSample element 
				bot.editAdvancedEObjectFlatComboViewerFeature(wizardShell, 0, referenceValueForAdvancedeobjectflatcomboviewerRequiredProperty);
		
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
	protected void initializeRemoveExpectedModelForAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerRequiredProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject advancedEObjectFlatComboViewerSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, advancedEObjectFlatComboViewerSampleMetaClass);
		if (advancedEObjectFlatComboViewerSample == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
				cc.append(SetCommand.create(editingDomain, advancedEObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getAdvancedEObjectFlatComboViewerSample_AdvancedeobjectflatcomboviewerRequiredProperty(), null));
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
	public void testRemoveAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerRequiredProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		advancedEObjectFlatComboViewerSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedEObjectFlatComboViewerSampleMetaClass);
		if (advancedEObjectFlatComboViewerSample == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
	
		// Create the expected model
		initializeRemoveExpectedModelForAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerRequiredProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the AdvancedEObjectFlatComboViewerSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedEObjectFlatComboViewerSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, advancedEObjectFlatComboViewerSampleMetaClass, firstInstanceOf, "Base");
		
		// Change value of the advancedeobjectflatcomboviewerRequiredProperty feature of the AdvancedEObjectFlatComboViewerSample element 
				bot.removeAdvancedEObjectFlatComboViewerFeature(wizardShell, 0);
		
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
	protected void initializeExpectedModelForAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject advancedEObjectFlatComboViewerSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, advancedEObjectFlatComboViewerSampleMetaClass);
		if (advancedEObjectFlatComboViewerSample == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
				referenceValueForAdvancedeobjectflatcomboviewerOptionalProperty = bot.changeReferenceValue(allInstancesOf, ((AdvancedEObjectFlatComboViewerSample)advancedEObjectFlatComboViewerSample).getAdvancedeobjectflatcomboviewerOptionalProperty());
				cc.append(SetCommand.create(editingDomain, advancedEObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getAdvancedEObjectFlatComboViewerSample_AdvancedeobjectflatcomboviewerOptionalProperty(), referenceValueForAdvancedeobjectflatcomboviewerOptionalProperty));
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
	public void testEditAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		advancedEObjectFlatComboViewerSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedEObjectFlatComboViewerSampleMetaClass);
		if (advancedEObjectFlatComboViewerSample == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
	
		// Create the expected model
		initializeExpectedModelForAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the AdvancedEObjectFlatComboViewerSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedEObjectFlatComboViewerSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, advancedEObjectFlatComboViewerSampleMetaClass, firstInstanceOf, "Base");
		
		// Change value of the advancedeobjectflatcomboviewerOptionalProperty feature of the AdvancedEObjectFlatComboViewerSample element 
				bot.editAdvancedEObjectFlatComboViewerFeature(wizardShell, 1, referenceValueForAdvancedeobjectflatcomboviewerOptionalProperty);
		
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
	protected void initializeRemoveExpectedModelForAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerOptionalProperty() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject advancedEObjectFlatComboViewerSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, advancedEObjectFlatComboViewerSampleMetaClass);
		if (advancedEObjectFlatComboViewerSample == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
				allInstancesOf = EEFTestsModelsUtils.getAllInstancesOf(expectedModel, totalSampleMetaClass);
				cc.append(SetCommand.create(editingDomain, advancedEObjectFlatComboViewerSample, EefnrPackage.eINSTANCE.getAdvancedEObjectFlatComboViewerSample_AdvancedeobjectflatcomboviewerOptionalProperty(), null));
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
	public void testRemoveAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerOptionalProperty() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		advancedEObjectFlatComboViewerSample = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedEObjectFlatComboViewerSampleMetaClass);
		if (advancedEObjectFlatComboViewerSample == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
	
		// Create the expected model
		initializeRemoveExpectedModelForAdvancedEObjectFlatComboViewerSampleAdvancedeobjectflatcomboviewerOptionalProperty();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the AdvancedEObjectFlatComboViewerSample element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), advancedEObjectFlatComboViewerSampleMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(advancedEObjectFlatComboViewerSampleMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, advancedEObjectFlatComboViewerSampleMetaClass, firstInstanceOf, "Base");
		
		// Change value of the advancedeobjectflatcomboviewerOptionalProperty feature of the AdvancedEObjectFlatComboViewerSample element 
				bot.removeAdvancedEObjectFlatComboViewerFeature(wizardShell, 1);
		
		// Save the changement
		bot.finalizeEdition(modelEditor);
		
		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);
		
		// Delete the input model
		deleteModels();
	
	}






}

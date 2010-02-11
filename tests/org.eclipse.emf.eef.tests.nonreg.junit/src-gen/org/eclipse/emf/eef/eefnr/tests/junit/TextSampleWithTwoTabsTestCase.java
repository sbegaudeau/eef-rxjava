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

import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.providers.EefnrMessages;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
/**
 * TestCase for TextSampleWithTwoTabs
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class TextSampleWithTwoTabsTestCase extends SWTBotEEFTestCase {
	
	/**
	 * The EClass of the type to edit
	 */
	private EClass textSampleWithTwoTabsMetaClass = EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs();

	/**
	 * The type to edit
	 */
	private EObject textSampleWithTwoTabs;
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
	protected void initializeExpectedModelForTextSampleWithTwoTabsTextOptionalPropertyInFirstTab() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject textSampleWithTwoTabs = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, textSampleWithTwoTabsMetaClass);
		if (textSampleWithTwoTabs == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, textSampleWithTwoTabs, EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs_TextOptionalPropertyInFirstTab(), UPDATED_VALUE));
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
	public void testEditTextSampleWithTwoTabsTextOptionalPropertyInFirstTab() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		textSampleWithTwoTabs = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), textSampleWithTwoTabsMetaClass);
		if (textSampleWithTwoTabs == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
	
		// Create the expected model
		initializeExpectedModelForTextSampleWithTwoTabsTextOptionalPropertyInFirstTab();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the TextSampleWithTwoTabs element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), textSampleWithTwoTabsMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, textSampleWithTwoTabsMetaClass, firstInstanceOf, "TextSampleFirstTab");
		
		// Change value of the textOptionalPropertyInFirstTab feature of the TextSampleWithTwoTabs element 
		bot.editTextFeature(wizardShell, EefnrMessages.TextSampleFirstTabPropertiesEditionPart_TextOptionalPropertyInFirstTabLabel, UPDATED_VALUE);	
		
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
	protected void initializeExpectedModelForTextSampleWithTwoTabsTextRequiredPropertyInFirstTab() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject textSampleWithTwoTabs = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, textSampleWithTwoTabsMetaClass);
		if (textSampleWithTwoTabs == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, textSampleWithTwoTabs, EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs_TextRequiredPropertyInFirstTab(), UPDATED_VALUE));
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
	public void testEditTextSampleWithTwoTabsTextRequiredPropertyInFirstTab() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		textSampleWithTwoTabs = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), textSampleWithTwoTabsMetaClass);
		if (textSampleWithTwoTabs == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
	
		// Create the expected model
		initializeExpectedModelForTextSampleWithTwoTabsTextRequiredPropertyInFirstTab();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the TextSampleWithTwoTabs element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), textSampleWithTwoTabsMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, textSampleWithTwoTabsMetaClass, firstInstanceOf, "TextSampleFirstTab");
		
		// Change value of the textRequiredPropertyInFirstTab feature of the TextSampleWithTwoTabs element 
		bot.editTextFeature(wizardShell, EefnrMessages.TextSampleFirstTabPropertiesEditionPart_TextRequiredPropertyInFirstTabLabel, UPDATED_VALUE);	
		
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
	protected void initializeExpectedModelForTextSampleWithTwoTabsTextOptionalPropertyInSecondTab() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject textSampleWithTwoTabs = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, textSampleWithTwoTabsMetaClass);
		if (textSampleWithTwoTabs == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, textSampleWithTwoTabs, EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs_TextOptionalPropertyInSecondTab(), UPDATED_VALUE));
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
	public void testEditTextSampleWithTwoTabsTextOptionalPropertyInSecondTab() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		textSampleWithTwoTabs = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), textSampleWithTwoTabsMetaClass);
		if (textSampleWithTwoTabs == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
	
		// Create the expected model
		initializeExpectedModelForTextSampleWithTwoTabsTextOptionalPropertyInSecondTab();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the TextSampleWithTwoTabs element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), textSampleWithTwoTabsMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, textSampleWithTwoTabsMetaClass, firstInstanceOf, "TextSampleSecondTab");
		
		// Change value of the textOptionalPropertyInSecondTab feature of the TextSampleWithTwoTabs element 
		bot.editTextFeature(wizardShell, EefnrMessages.TextSampleSecondTabPropertiesEditionPart_TextOptionalPropertyInSecondTabLabel, UPDATED_VALUE);	
		
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
	protected void initializeExpectedModelForTextSampleWithTwoTabsTextRequiredPropertyInSecondTab() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		EObject textSampleWithTwoTabs = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, textSampleWithTwoTabsMetaClass);
		if (textSampleWithTwoTabs == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(SetCommand.create(editingDomain, textSampleWithTwoTabs, EefnrPackage.eINSTANCE.getTextSampleWithTwoTabs_TextRequiredPropertyInSecondTab(), UPDATED_VALUE));
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
	public void testEditTextSampleWithTwoTabsTextRequiredPropertyInSecondTab() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		textSampleWithTwoTabs = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), textSampleWithTwoTabsMetaClass);
		if (textSampleWithTwoTabs == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
	
		// Create the expected model
		initializeExpectedModelForTextSampleWithTwoTabsTextRequiredPropertyInSecondTab();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the TextSampleWithTwoTabs element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), textSampleWithTwoTabsMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(textSampleWithTwoTabsMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, textSampleWithTwoTabsMetaClass, firstInstanceOf, "TextSampleSecondTab");
		
		// Change value of the textRequiredPropertyInSecondTab feature of the TextSampleWithTwoTabs element 
		bot.editTextFeature(wizardShell, EefnrMessages.TextSampleSecondTabPropertiesEditionPart_TextRequiredPropertyInSecondTabLabel, UPDATED_VALUE);	
		
		// Save the changement
		bot.finalizeEdition(modelEditor);
		
		// Compare real model with expected model
		assertExpectedModelReached(expectedModel);
		
		// Delete the input model
		deleteModels();
	
	}










}

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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.eef.eefnr.AbstractSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.runtime.tests.SWTBotEEFTestCase;
import org.eclipse.emf.eef.runtime.tests.exceptions.InputModelInvalidException;
import org.eclipse.emf.eef.runtime.tests.utils.EEFTestsModelsUtils;
import org.eclipse.emf.eef.runtime.tests.utils.UIConstants;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
/**
 * TestCase for Root
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class RootTestCase extends SWTBotEEFTestCase {
	
	/**
	 * The EClass of the type to edit
	 */
	private EClass rootMetaClass = EefnrPackage.eINSTANCE.getRoot();

	/**
	 * The type to edit
	 */
	private EObject root;
	
	
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
	protected void initializeExpectedModelForRootSamples() throws InputModelInvalidException, IOException {
		// Create the expected model content by applying the attempted command on a copy of the input model content
		createExpectedModel();
		
		EObject root = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, rootMetaClass);
		if (root == null)
			throw new InputModelInvalidException(rootMetaClass.getName());
		EClass abstractSampleMetaClass = EefnrPackage.eINSTANCE.getAbstractSample();
		EObject abstractSample = EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, abstractSampleMetaClass);
		if (abstractSample == null)
			throw new InputModelInvalidException(abstractSampleMetaClass.getName());
		CompoundCommand cc = new CompoundCommand();
		
		cc.append(AddCommand.create(editingDomain, root, EefnrPackage.eINSTANCE.getRoot_Samples(), EcoreUtil.copy(abstractSample)));
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
	public void testEditRootSamples() throws Exception {
		
		// Import the input model
		initializeInputModel();
		
		root = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), rootMetaClass);
		if (root == null)
			throw new InputModelInvalidException(rootMetaClass.getName());
		
				
		// Create the expected model
		initializeExpectedModelForRootSamples();
		
		// Open the input model with the treeview editor
		SWTBotEditor modelEditor = bot.openActiveModel();
		
		// Open the EEF wizard (by double click) to edit the Root element
		EObject firstInstanceOf = EEFTestsModelsUtils.getFirstInstanceOf(bot.getActiveResource(), rootMetaClass);
		if (firstInstanceOf == null)
			throw new InputModelInvalidException(rootMetaClass.getName());
		
		SWTBotShell wizardShell = bot.prepareBatchEditing(modelEditor, rootMetaClass, firstInstanceOf);
		
		// Change value of the samples feature of the Root element 
		editAdvancedTableCompositionsamplesFeature(wizardShell);	
		
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
	protected void editAdvancedTableCompositionForsamplesFeature() {
		EClass abstractSampleMetaClass = EefnrPackage.eINSTANCE.getAbstractSample();
		SWTBotShell shellTable = bot.shell(abstractSampleMetaClass.getName());
		bot.activateShell(shellTable);
		AbstractSample abstractSample = (AbstractSample) EEFTestsModelsUtils.getFirstInstanceOf(expectedModel, abstractSampleMetaClass);
		bot.closeShellWithFinishButton(shellTable);
	}	
	/**
	 * Edit the table composition
	 * @param wizardShell
	 */
	protected void editAdvancedTableCompositionsamplesFeature(SWTBotShell wizardShell) {
		bot.activateShell(wizardShell);
		bot.sleep(500);
		bot.buttonWithTooltip(UIConstants.TABLE_COMPOSITION_ADD_A_NEW_ELEMENT_BUTTON).click();
		editAdvancedTableCompositionForsamplesFeature();
		bot.closeShellWithFinishButton(wizardShell);
	}


}

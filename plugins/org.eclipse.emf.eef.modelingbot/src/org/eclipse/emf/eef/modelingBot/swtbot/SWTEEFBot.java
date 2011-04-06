/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

package org.eclipse.emf.eef.modelingBot.swtbot;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.extended.editor.ReferenceableObject;
import org.eclipse.emf.eef.modelingBot.IModelingBot;
import org.eclipse.emf.eef.modelingBot.interpreter.EEFInterpreter;
import org.eclipse.emf.eef.modelingBot.interpreter.ModelingBotInterpreter;
import org.eclipse.emf.eef.modelingBot.utils.UIConstants;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.internal.ide.IDEWorkbenchMessages;

/**
 * @author nlepine
 *
 */
public class SWTEEFBot extends SWTWorkbenchBot implements IModelingBot {
	
	private ModelingBotInterpreter interpreter;
	

	public SWTEEFBot() {
		super();
		interpreter = new EEFInterpreter();
	}

	public void openPropertiesView() {
		menu(UIConstants.WINDOW_MENU).menu(UIConstants.SHOW_VIEW_MENU).menu(UIConstants.OTHER_MENU).click();

		SWTBotShell shell = shell(UIConstants.SHOW_VIEW_MENU);
		activateShell(shell);

		SWTBotTree viewSelectionTree = tree();
		viewSelectionTree.expandNode(UIConstants.GENERAL_MENU).select(UIConstants.PROPERTIES_VIEW_NAME);
		button(UIConstants.OK_BUTTON).click();
		waitUntil(Conditions.shellCloses(shell));
	}

	public void openJavaPerspective() {
		menu(UIConstants.WINDOW_MENU).menu(UIConstants.OPEN_PERSPECTIVE_MENU).menu(UIConstants.OTHER_MENU)
				.click();
		SWTBotShell openPerspectiveShell = shell(UIConstants.OPEN_PERSPECTIVE_MENU);
		activateShell(openPerspectiveShell);

		try {
			table().select(UIConstants.JAVA_LABEL);
		} catch (IllegalArgumentException e) {
			table().select(UIConstants.JAVA_DEFAULT_LABEL);
		}
		button(UIConstants.OK_BUTTON).click();
	}
	
	/**
	 * @param shell
	 */
	public void activateShell(SWTBotShell shell) {
		shell.activate();
	}

	/**
	 * This method close the welcome page if we use the workspace of test for the first time
	 */
	public void closeWelcomePage() {
		try {
			viewByTitle(UIConstants.WELCOME_LABEL).close();
		} catch (WidgetNotFoundException e) {
			// do nothing
		}
	}

	public void createProject(String projectName) {
		menu(UIConstants.FILE_MENU).menu("Project...").click();
		SWTBotShell openProjectShell = shell("New Project");
		activateShell(openProjectShell);

		tree().expandNode("General").select("Project");
		button("Next >").click();
		text().setText(projectName);
		button(UIConstants.FINISH_BUTTON).click();
	}

	public void openProject(String projectName) {
		// TODO Auto-generated method stub
		
	}

	public void closeProject(String projectName) {
		// TODO Auto-generated method stub
		
	}

	public void removeProject(String projectName) {
		// TODO Auto-generated method stub
		
	}

	public void openPerspective(String name) {
		// TODO Auto-generated method stub
		
	}

	public void openEEFEditor(String path) {
		// TODO Auto-generated method stub
		
	}

	public void closeEditor(String path) {
		// TODO Auto-generated method stub
		
	}

	public void save(String path) {
		// TODO Auto-generated method stub
		
	}

	public void add(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature) {
		// TODO Auto-generated method stub
		
	}

	public void remove(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature) {
		// TODO Auto-generated method stub
		
	}

	public void set(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature, String value) {
		// TODO Auto-generated method stub
		
	}
	
	public void set(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature, ReferenceableObject value) {
		// TODO Auto-generated method stub
		
	}

	public void unset(PropertiesEditionElement propertiesEditionElement,
			ReferenceableObject referenceableObject,
			EStructuralFeature eContainingFeature) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.eef.modelingBot.IModelingBot#runModelingBot(java.lang.String)
	 */
	public void runModelingBot(String path) throws CoreException,
			IOException {
			interpreter.runModelingBot(path, this);
	}


	public void createModel(String path, String modelName, EClass root) {
		String[] split = modelName.split("\\.");
		String extension = split[split.length-1];
		
		// select folder to create the model
		//TODO  faire rec avec folder
		SWTBotTree wizardTree = viewByTitle(UIConstants.PACKAGE_EXPLORER_VIEW_NAME).bot().tree();
		wizardTree.expandNode(path).select();
		
		menu(UIConstants.FILE_MENU).menu(UIConstants.OTHER_MENU).click();
		SWTBotShell newFileShell = shell("New");
		activateShell(newFileShell);

		text().setText(extension + " Model");
		SWTBotTreeItem[] allItems = tree().getAllItems();
		SWTBotTreeItem item = getItem(allItems, toU1Case(extension) + " Model");
		assertNotNull("The model "+toU1Case(extension) + " Model" +" can not be created.", item);
		item.select();
		button("Next >").click();
		
		textWithLabel(IDEWorkbenchMessages.WizardNewFileCreationPage_fileLabel).setText(modelName);
		button("Next >").click();
		assertNotNull("The class "+ root.toString() + " can not be loaded", root.getName());
		
		comboBox().setSelection(root.getName());
		button(UIConstants.FINISH_BUTTON).click();
		
	}
	
	private SWTBotTreeItem getItem(SWTBotTreeItem[] allItems, String string) {
		for (int i = 0; i < allItems.length; i++) {
			SWTBotTreeItem swtBotTreeItem = allItems[i];
			if (swtBotTreeItem.getText().equals(string)) {
				return swtBotTreeItem;
			}
			SWTBotTreeItem item = getItem(swtBotTreeItem.getItems(), string);
			if (item != null) {
				return item;
			}
		}
		return null;
		
	}

	public String toU1Case(String from) {
		String ret = ""; //$NON-NLS-1$
        if (from.length() > 0) {
                StringBuilder sb = new StringBuilder(from.length());
                sb.append(Character.toUpperCase(from.charAt(0))).append(from.substring(1));
                ret = sb.toString();
        }
        return ret;
	}

}

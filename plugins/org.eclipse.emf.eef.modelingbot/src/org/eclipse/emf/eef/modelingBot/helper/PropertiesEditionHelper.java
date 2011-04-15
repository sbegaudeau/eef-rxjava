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
package org.eclipse.emf.eef.modelingBot.helper;

import static org.junit.Assert.assertFalse;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.modelingBot.SequenceType;
import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class PropertiesEditionHelper {
	
	/**
	 * SWT EEF Bot
	 */
	private SWTEEFBot bot;

	/**
	 * Create a PropertiesEditionHelper
	 * @param bot SWTEEFBot
	 */
	public PropertiesEditionHelper(SWTEEFBot bot) {
		this.bot = bot;
	}

	/**
	 * Update a feature.
	 * @param selectNode
	 * @param propertiesEditionElement
	 * @param value
	 * @param sequenceType
	 */
	public void updateFeature(SWTBotTreeItem selectNode, PropertiesEditionElement propertiesEditionElement, String value, SequenceType sequenceType) {
		if(!propertiesEditionElement.getViews().isEmpty()) {
			ElementEditor elementEditor = propertiesEditionElement.getViews().get(0);
			if (elementEditor.getRepresentation().getName().equals("Text")) {
				updateText(selectNode, elementEditor, value, sequenceType);
			}
		}
		
	}

	/**
	 * Update widget text
	 * @param selectNode
	 * @param elementEditor
	 * @param value
	 * @param sequenceType
	 */
	private void updateText(SWTBotTreeItem selectNode, ElementEditor elementEditor, String value, SequenceType sequenceType) {
		if (sequenceType.equals(SequenceType.DETAILS_PAGE)) {
			updateText(elementEditor, value);
		} else if (sequenceType.equals(SequenceType.WIZARD)) {
			if (selectNode!=null) {
				selectNode.doubleClick();
			}
			updateText(elementEditor, value);
		}
	}

	/**
	 * @param elementEditor
	 * @param value
	 */
	private void updateText(ElementEditor elementEditor, String value) {
		SWTBotHelper.waitAllUiEvents();
		SWTBotText textWithLabel = bot.textWithLabel(StringHelper.toU1Case(elementEditor.getName())+" : ");
		textWithLabel.setText(value);
		SWTBotHelper.pressEnterKey(textWithLabel.widget);
		SWTBotHelper.sendFocusLost(textWithLabel.widget);
		SWTBotHelper.waitAllUiEvents();
	}

	public void setBot(SWTEEFBot bot) {
		this.bot = bot;
	}

	public void addFeature(SWTBotTreeItem selectNode,
			PropertiesEditionElement propertiesEditionElement,
			SequenceType sequenceType) {
		assertFalse(propertiesEditionElement.getViews().isEmpty());
		ElementEditor elementEditor = propertiesEditionElement.getViews().get(0);
		if (sequenceType.equals(SequenceType.DETAILS_PAGE)) {
			bot.addButtonAdvancedTableComposition(elementEditor.getQualifiedIdentifier()).click();
		} else if (sequenceType.equals(SequenceType.WIZARD)) {
			bot.addButtonAdvancedTableComposition(elementEditor.getQualifiedIdentifier()).click();
		}
		
	}

	public void removeFeature(EObject remove,
			PropertiesEditionElement propertiesEditionElement,
			SequenceType sequenceType) {
		assertFalse(propertiesEditionElement.getViews().isEmpty());
		ElementEditor elementEditor = propertiesEditionElement.getViews().get(0);
		if (sequenceType.equals(SequenceType.DETAILS_PAGE)) {
			removeFeature(remove, elementEditor);
		} else if (sequenceType.equals(SequenceType.WIZARD)) {
			removeFeature(remove, elementEditor);
		}
	}

	private void removeFeature(EObject remove, ElementEditor elementEditor) {
		bot.selectInTableWithId(org.eclipse.emf.eef.runtime.ui.UIConstants.EEF_WIDGET_ID_KEY, elementEditor.getQualifiedIdentifier(), remove);
		bot.removeButtonAdvancedTableComposition(elementEditor.getQualifiedIdentifier()).click();
	}

}

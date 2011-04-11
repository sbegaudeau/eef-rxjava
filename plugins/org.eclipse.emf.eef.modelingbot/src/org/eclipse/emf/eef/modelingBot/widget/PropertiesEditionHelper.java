package org.eclipse.emf.eef.modelingBot.widget;

import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.modelingBot.SequenceType;
import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;
import org.eclipse.emf.eef.modelingBot.utils.SWTBotUtils;
import org.eclipse.emf.eef.modelingBot.utils.StringUtils;
import org.eclipse.emf.eef.modelingBot.utils.UIConstants;
import org.eclipse.emf.eef.views.ElementEditor;
import org.eclipse.emf.eef.views.ViewsRepository;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

public class PropertiesEditionHelper {
	
	private SWTEEFBot bot;
	private SWTBotEditor editor;

	public PropertiesEditionHelper(SWTEEFBot bot) {
		this.bot = bot;
	}

	public void updateFeature(SWTBotTreeItem selectNode, PropertiesEditionElement propertiesEditionElement, String value, SequenceType sequenceType) {
		if(!propertiesEditionElement.getViews().isEmpty()) {
			ElementEditor elementEditor = propertiesEditionElement.getViews().get(0);
			if (elementEditor.getRepresentation().getName().equals("Text")) {
				updateText(selectNode, elementEditor, value, sequenceType);
			}
		}
		
	}

	public void updateText(SWTBotTreeItem selectNode, ElementEditor elementEditor, String value, SequenceType sequenceType) {
		if (sequenceType.equals(SequenceType.DETAILS_PAGE)) {
			updateText(elementEditor, value);
		} else if (sequenceType.equals(SequenceType.WIZARD)) {
			if (selectNode!=null) {
				selectNode.doubleClick();
			}
//			SWTBotShell shell = bot.shells()[bot.shells().length-1];
//			bot.activateShell(shell);
			updateText(elementEditor, value);
//			bot.button(UIConstants.FINISH_BUTTON).click();
		}
	}

	private void updateText(ElementEditor elementEditor, String value) {
		SWTBotUtils.waitAllUiEvents();
		SWTBotText textWithLabel = bot.textWithLabel(StringUtils.toU1Case(elementEditor.getName())+" : ");
		textWithLabel.setText(value);
		SWTBotUtils.pressEnterKey(textWithLabel.widget);
		SWTBotUtils.sendFocusLost(textWithLabel.widget);
		SWTBotUtils.waitAllUiEvents();
	}

	public void setBot(SWTEEFBot swteefBot) {
		this.bot = bot;
	}

	public void setEditor(SWTBotEditor editor) {
		this.editor = editor;
	}

	public void addFeature(SWTBotTreeItem selectNode,
			PropertiesEditionElement propertiesEditionElement,
			SequenceType sequenceType) {
		assertFalse(propertiesEditionElement.getViews().isEmpty());
		ElementEditor elementEditor = propertiesEditionElement.getViews().get(0);
		if (sequenceType.equals(SequenceType.DETAILS_PAGE)) {
			bot.addButtonAdvancedTableComposition(elementEditor.getQualifiedIdentifier()).click();
//			bot.button(UIConstants.FINISH_BUTTON).click();
		} else if (sequenceType.equals(SequenceType.WIZARD)) {
//			selectNode.doubleClick();
			bot.addButtonAdvancedTableComposition(elementEditor.getQualifiedIdentifier()).click();
//			bot.button(UIConstants.FINISH_BUTTON).click();
		}
		
	}

}

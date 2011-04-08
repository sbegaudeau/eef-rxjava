package org.eclipse.emf.eef.modelingBot.widget;

import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.modelingBot.swtbot.SWTEEFBot;
import org.eclipse.emf.eef.modelingBot.utils.StringUtils;
import org.eclipse.emf.eef.views.ElementEditor;

public class PropertiesEditionHelper {
	
	private SWTEEFBot bot;

	public PropertiesEditionHelper(SWTEEFBot bot) {
		this.bot = bot;
	}

	public void updateFeature(PropertiesEditionElement propertiesEditionElement, String value) {
		if(!propertiesEditionElement.getViews().isEmpty()) {
			ElementEditor elementEditor = propertiesEditionElement.getViews().get(0);
			if (elementEditor.getRepresentation().getName().equals("Text")) {
				updateText(elementEditor, value);
			}
		}
		
	}

	public void updateText(ElementEditor elementEditor, String value) {
		bot.textWithLabel(StringUtils.toU1Case(elementEditor.getName())+" : ").setText(value);
	}


}

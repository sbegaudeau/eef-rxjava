/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.mapping.settings.providers;

import org.eclipse.osgi.util.NLS;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class SettingsMessages extends NLS {
	
	private static final String BUNDLE_NAME = "org.eclipse.emf.eef.mapping.settings.providers.settingsMessages"; //$NON-NLS-1$


	
	public static String Settings_ReadOnly;

	
	public static String Settings_Part_Title;


	
	public static String SettingsPropertiesEditionPart_ModelLabel;


	
	public static String PropertiesEditionPart_DocumentationLabel;

	
	public static String PropertiesEditionPart_IntegerValueMessage;

	
	public static String PropertiesEditionPart_FloatValueMessage;

	
	public static String PropertiesEditionPart_ShortValueMessage;

	
	public static String PropertiesEditionPart_LongValueMessage;

	
	public static String PropertiesEditionPart_ByteValueMessage;

	
	public static String PropertiesEditionPart_BigIntegerValueMessage;

	
	public static String PropertiesEditionPart_BigDecimalValueMessage;

	
	public static String PropertiesEditionPart_DoubleValueMessage;

	
	public static String PropertiesEditionPart_PropertiesGroupLabel;

	
	public static String PropertiesEditionPart_RequiredFeatureMessage;

	
	public static String PropertiesEditionPart_AddTableViewerLabel;

	
	public static String PropertiesEditionPart_EditTableViewerLabel;

	
	public static String PropertiesEditionPart_RemoveTableViewerLabel;

	
	public static String PropertiesEditionPart_AddListViewerLabel;

	
	public static String PropertiesEditionPart_RemoveListViewerLabel;

	// Start of user code for additionnal NLS Constants
	
	// End of user code

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, SettingsMessages.class);
	}

	
	private SettingsMessages() {
		//protect instanciation
	}
}

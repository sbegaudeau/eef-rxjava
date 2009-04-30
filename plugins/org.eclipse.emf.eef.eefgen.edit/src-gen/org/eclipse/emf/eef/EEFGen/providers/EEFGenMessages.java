/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: EEFGenMessages.java,v 1.1 2009/04/30 17:12:36 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.providers;

import org.eclipse.osgi.util.NLS;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EEFGenMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.emf.eef.EEFGen.providers.EEFGenMessages"; //$NON-NLS-1$

	public static String GenActivationPropertiesEditionPart_ActivationGroupLabel;

	public static String GenParametersPropertiesEditionPart_ParametersGroupLabel;

	public static String GenParametersPropertiesEditionPart_LegalGroupLabel;

	public static String GenReferencesPropertiesEditionPart_ReferencesGroupLabel;

	public static String GenEditionContext_ReadOnly;
	
	public static String GenParametersPropertiesEditionPart_BasePackageLabel;
			
	public static String GenParametersPropertiesEditionPart_GenDirectoryLabel;
			
	public static String GenActivationPropertiesEditionPart_SwtViewsLabel;
			
	public static String GenActivationPropertiesEditionPart_FormViewsLabel;
			
	public static String GenActivationPropertiesEditionPart_DescriptorsGenericPropertiesViewsLabel;
			
	public static String GenActivationPropertiesEditionPart_GmfPropertiesViewsLabel;
			
	public static String GenParametersPropertiesEditionPart_DescriptorsContributorIDLabel;
			
	public static String GenParametersPropertiesEditionPart_HelpStrategyLabel;
			
	public static String GenReferencesPropertiesEditionPart_PropertiesEditionContextLabel;
			
	public static String GenParametersPropertiesEditionPart_AuthorLabel;
			
	public static String GenParametersPropertiesEditionPart_LicenseLabel;
			
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
		NLS.initializeMessages(BUNDLE_NAME, EEFGenMessages.class);
	}

	private EEFGenMessages() {
		//protect instanciation
	}
}	

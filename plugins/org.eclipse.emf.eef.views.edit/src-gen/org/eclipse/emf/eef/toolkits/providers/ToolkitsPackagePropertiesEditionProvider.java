/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.toolkits.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ToolkitsPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 * 
	 */
	public ToolkitsPackagePropertiesEditionProvider() {
		super();
		append(createToolkitPropertiesEditionProvider());
		append(createWidgetPropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Toolkit instances.
	 * 
	 */
	protected ToolkitPropertiesEditionProvider toolkitPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Toolkit
	 * 
	 */
	public ToolkitPropertiesEditionProvider createToolkitPropertiesEditionProvider() {
		if (toolkitPropertiesEditionProvider == null)
			toolkitPropertiesEditionProvider = new ToolkitPropertiesEditionProvider();
		return toolkitPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Widget instances.
	 * 
	 */
	protected WidgetPropertiesEditionProvider widgetPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Widget
	 * 
	 */
	public WidgetPropertiesEditionProvider createWidgetPropertiesEditionProvider() {
		if (widgetPropertiesEditionProvider == null)
			widgetPropertiesEditionProvider = new WidgetPropertiesEditionProvider();
		return widgetPropertiesEditionProvider;
	}

}

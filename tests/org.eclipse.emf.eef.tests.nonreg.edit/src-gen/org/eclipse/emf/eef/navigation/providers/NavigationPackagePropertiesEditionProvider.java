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
package org.eclipse.emf.eef.navigation.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class NavigationPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 * 
	 */
	public NavigationPackagePropertiesEditionProvider() {
		super();
		append(createDeferedFlatReferencesTableSampleEditorPropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DeferedFlatReferenceTableEditorSample instances.
	 * 
	 */
	protected DeferedFlatReferencesTableSampleEditorPropertiesEditionProvider deferedFlatReferencesTableSampleEditorPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DeferedFlatReferenceTableEditorSample
	 * 
	 */
	public DeferedFlatReferencesTableSampleEditorPropertiesEditionProvider createDeferedFlatReferencesTableSampleEditorPropertiesEditionProvider() {
		if (deferedFlatReferencesTableSampleEditorPropertiesEditionProvider == null)
			deferedFlatReferencesTableSampleEditorPropertiesEditionProvider = new DeferedFlatReferencesTableSampleEditorPropertiesEditionProvider();
		return deferedFlatReferencesTableSampleEditorPropertiesEditionProvider;
	}

}

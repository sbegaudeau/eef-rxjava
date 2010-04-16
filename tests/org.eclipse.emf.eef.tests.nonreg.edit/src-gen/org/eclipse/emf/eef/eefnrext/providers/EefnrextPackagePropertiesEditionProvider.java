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
package org.eclipse.emf.eef.eefnrext.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class EefnrextPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 * 
	 */
	public EefnrextPackagePropertiesEditionProvider() {
		super();
		append(createTableCompositionTargetExtensionEditorSamplePropertiesEditionProvider());
		append(createCheckBoxExtendedEditorSamplePropertiesEditionProvider());
		append(createFlatReferenceExtendedEditorSamplePropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TableCompositionTargetExtensionEditorSample instances.
	 * 
	 */
	protected TableCompositionTargetExtensionEditorSamplePropertiesEditionProvider tableCompositionTargetExtensionEditorSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TableCompositionTargetExtensionEditorSample
	 * 
	 */
	public TableCompositionTargetExtensionEditorSamplePropertiesEditionProvider createTableCompositionTargetExtensionEditorSamplePropertiesEditionProvider() {
		if (tableCompositionTargetExtensionEditorSamplePropertiesEditionProvider == null)
			tableCompositionTargetExtensionEditorSamplePropertiesEditionProvider = new TableCompositionTargetExtensionEditorSamplePropertiesEditionProvider();
		return tableCompositionTargetExtensionEditorSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CheckBoxExtendedEditorSample instances.
	 * 
	 */
	protected CheckBoxExtendedEditorSamplePropertiesEditionProvider checkBoxExtendedEditorSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CheckBoxExtendedEditorSample
	 * 
	 */
	public CheckBoxExtendedEditorSamplePropertiesEditionProvider createCheckBoxExtendedEditorSamplePropertiesEditionProvider() {
		if (checkBoxExtendedEditorSamplePropertiesEditionProvider == null)
			checkBoxExtendedEditorSamplePropertiesEditionProvider = new CheckBoxExtendedEditorSamplePropertiesEditionProvider();
		return checkBoxExtendedEditorSamplePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * FlatReferenceExtendedEditorSample instances.
	 * 
	 */
	protected FlatReferenceExtendedEditorSamplePropertiesEditionProvider flatReferenceExtendedEditorSamplePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a FlatReferenceExtendedEditorSample
	 * 
	 */
	public FlatReferenceExtendedEditorSamplePropertiesEditionProvider createFlatReferenceExtendedEditorSamplePropertiesEditionProvider() {
		if (flatReferenceExtendedEditorSamplePropertiesEditionProvider == null)
			flatReferenceExtendedEditorSamplePropertiesEditionProvider = new FlatReferenceExtendedEditorSamplePropertiesEditionProvider();
		return flatReferenceExtendedEditorSamplePropertiesEditionProvider;
	}

}

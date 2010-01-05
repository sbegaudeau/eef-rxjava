/**
 *  Copyright (c) 2008-2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.views.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ViewsPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 */
	public ViewsPackagePropertiesEditionProvider() {
		super();
		append(createDocumentedElementPropertiesEditionProvider());
		append(createViewsRepositoryPropertiesEditionProvider());
		append(createViewPropertiesEditionProvider());
		append(createElementEditorPropertiesEditionProvider());
		append(createCategoryPropertiesEditionProvider());
		append(createContainerPropertiesEditionProvider());
		append(createCustomElementEditorPropertiesEditionProvider());
		append(createCustomViewPropertiesEditionProvider());
		append(createViewReferencePropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DocumentedElement instances.
	 */
	protected DocumentedElementPropertiesEditionProvider documentedElementPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DocumentedElement
	 */
	public DocumentedElementPropertiesEditionProvider createDocumentedElementPropertiesEditionProvider() {
		if (documentedElementPropertiesEditionProvider == null)
			documentedElementPropertiesEditionProvider = new DocumentedElementPropertiesEditionProvider();
		return documentedElementPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ViewsRepository instances.
	 */
	protected ViewsRepositoryPropertiesEditionProvider viewsRepositoryPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ViewsRepository
	 */
	public ViewsRepositoryPropertiesEditionProvider createViewsRepositoryPropertiesEditionProvider() {
		if (viewsRepositoryPropertiesEditionProvider == null)
			viewsRepositoryPropertiesEditionProvider = new ViewsRepositoryPropertiesEditionProvider();
		return viewsRepositoryPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * View instances.
	 */
	protected ViewPropertiesEditionProvider viewPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a View
	 */
	public ViewPropertiesEditionProvider createViewPropertiesEditionProvider() {
		if (viewPropertiesEditionProvider == null)
			viewPropertiesEditionProvider = new ViewPropertiesEditionProvider();
		return viewPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ElementEditor instances.
	 */
	protected ElementEditorPropertiesEditionProvider elementEditorPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ElementEditor
	 */
	public ElementEditorPropertiesEditionProvider createElementEditorPropertiesEditionProvider() {
		if (elementEditorPropertiesEditionProvider == null)
			elementEditorPropertiesEditionProvider = new ElementEditorPropertiesEditionProvider();
		return elementEditorPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Category instances.
	 */
	protected CategoryPropertiesEditionProvider categoryPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Category
	 */
	public CategoryPropertiesEditionProvider createCategoryPropertiesEditionProvider() {
		if (categoryPropertiesEditionProvider == null)
			categoryPropertiesEditionProvider = new CategoryPropertiesEditionProvider();
		return categoryPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Container instances.
	 */
	protected ContainerPropertiesEditionProvider containerPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Container
	 */
	public ContainerPropertiesEditionProvider createContainerPropertiesEditionProvider() {
		if (containerPropertiesEditionProvider == null)
			containerPropertiesEditionProvider = new ContainerPropertiesEditionProvider();
		return containerPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CustomElementEditor instances.
	 */
	protected CustomElementEditorPropertiesEditionProvider customElementEditorPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CustomElementEditor
	 */
	public CustomElementEditorPropertiesEditionProvider createCustomElementEditorPropertiesEditionProvider() {
		if (customElementEditorPropertiesEditionProvider == null)
			customElementEditorPropertiesEditionProvider = new CustomElementEditorPropertiesEditionProvider();
		return customElementEditorPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CustomView instances.
	 */
	protected CustomViewPropertiesEditionProvider customViewPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CustomView
	 */
	public CustomViewPropertiesEditionProvider createCustomViewPropertiesEditionProvider() {
		if (customViewPropertiesEditionProvider == null)
			customViewPropertiesEditionProvider = new CustomViewPropertiesEditionProvider();
		return customViewPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ViewReference instances.
	 */
	protected ViewReferencePropertiesEditionProvider viewReferencePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ViewReference
	 */
	public ViewReferencePropertiesEditionProvider createViewReferencePropertiesEditionProvider() {
		if (viewReferencePropertiesEditionProvider == null)
			viewReferencePropertiesEditionProvider = new ViewReferencePropertiesEditionProvider();
		return viewReferencePropertiesEditionProvider;
	}

}

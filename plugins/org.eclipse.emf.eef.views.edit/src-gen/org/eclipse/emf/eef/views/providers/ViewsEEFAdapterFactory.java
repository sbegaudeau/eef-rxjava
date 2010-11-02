/**
 *  Copyright (c) 2008 - 2010 Obeo.
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.views.util.ViewsAdapterFactory;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ViewsEEFAdapterFactory extends ViewsAdapterFactory {


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Views#createDocumentedElementAdapter()
	 * 
	 */
	public Adapter createDocumentedElementAdapter() {
		return new DocumentedElementPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Views#createViewsRepositoryAdapter()
	 * 
	 */
	public Adapter createViewsRepositoryAdapter() {
		return new ViewsRepositoryPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Views#createViewAdapter()
	 * 
	 */
	public Adapter createViewAdapter() {
		return new ViewPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Views#createElementEditorAdapter()
	 * 
	 */
	public Adapter createElementEditorAdapter() {
		return new ElementEditorPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Views#createCategoryAdapter()
	 * 
	 */
	public Adapter createCategoryAdapter() {
		return new CategoryPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Views#createContainerAdapter()
	 * 
	 */
	public Adapter createContainerAdapter() {
		return new ContainerPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Views#createCustomElementEditorAdapter()
	 * 
	 */
	public Adapter createCustomElementEditorAdapter() {
		return new CustomElementEditorPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Views#createCustomViewAdapter()
	 * 
	 */
	public Adapter createCustomViewAdapter() {
		return new CustomViewPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Views#createViewReferenceAdapter()
	 * 
	 */
	public Adapter createViewReferenceAdapter() {
		return new ViewReferencePropertiesEditionProvider();
	}

}

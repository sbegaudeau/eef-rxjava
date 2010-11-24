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
package org.eclipse.emf.eef.mapping.providers;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.mapping.filters.util.FiltersAdapterFactory;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class FiltersEEFAdapterFactory extends FiltersAdapterFactory {


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.mapping.util.Filters#createBindingFilterAdapter()
	 * 
	 */
	public Adapter createBindingFilterAdapter() {
		return new FilterPropertiesPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.mapping.util.Filters#createOnlyReferenceTypeFilterAdapter()
	 * 
	 */
	public Adapter createOnlyReferenceTypeFilterAdapter() {
		return new OnlyReferenceTypeFilterPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.mapping.util.Filters#createOCLFilterAdapter()
	 * 
	 */
	public Adapter createOCLFilterAdapter() {
		return new OCLFilterPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.mapping.util.Filters#createJavaExpressionFilterAdapter()
	 * 
	 */
	public Adapter createJavaExpressionFilterAdapter() {
		return new JavaExpressionFilterPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.mapping.util.Filters#createJavaDeclarationFilterAdapter()
	 * 
	 */
	public Adapter createJavaDeclarationFilterAdapter() {
		return new JavaDeclarationFilterPropertiesEditionProvider();
	}

}

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
import org.eclipse.emf.eef.mapping.util.MappingAdapterFactory;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class MappingEEFAdapterFactory extends MappingAdapterFactory {


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Mapping#createDocumentedElementAdapter()
	 * 
	 */
	public Adapter createDocumentedElementAdapter() {
		return new DocumentedElementPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Mapping#createEMFElementBindingAdapter()
	 * 
	 */
	public Adapter createEMFElementBindingAdapter() {
		return new EMFElementBindingPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Mapping#createEMFPropertyBindingAdapter()
	 * 
	 */
	public Adapter createEMFPropertyBindingAdapter() {
		return new EMFPropertyBindingPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Mapping#createStandardElementBindingAdapter()
	 * 
	 */
	public Adapter createStandardElementBindingAdapter() {
		return new StandardElementBindingPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Mapping#createStandardPropertyBindingAdapter()
	 * 
	 */
	public Adapter createStandardPropertyBindingAdapter() {
		return new StandardPropertyBindingPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Mapping#createCategoryAdapter()
	 * 
	 */
	public Adapter createCategoryAdapter() {
		return new CategoryPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Mapping#createElementBindingReferenceAdapter()
	 * 
	 */
	public Adapter createElementBindingReferenceAdapter() {
		return new ElementBindingReferencePropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Mapping#createEMFMultiPropertiesBindingAdapter()
	 * 
	 */
	public Adapter createEMFMultiPropertiesBindingAdapter() {
		return new EMFMultiPropertiesBindingPropertiesEditionProvider();
	}

}

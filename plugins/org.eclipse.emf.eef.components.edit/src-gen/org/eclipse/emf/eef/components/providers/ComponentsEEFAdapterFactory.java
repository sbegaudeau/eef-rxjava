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
package org.eclipse.emf.eef.components.providers;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.components.util.ComponentsAdapterFactory;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class ComponentsEEFAdapterFactory extends ComponentsAdapterFactory {


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Components#createPropertiesEditionContextAdapter()
	 * 
	 */
	public Adapter createPropertiesEditionContextAdapter() {
		return new PropertiesEditionContextPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Components#createPropertiesEditionComponentAdapter()
	 * 
	 */
	public Adapter createPropertiesEditionComponentAdapter() {
		return new PropertiesEditionComponentPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Components#createPropertiesEditionElementAdapter()
	 * 
	 */
	public Adapter createPropertiesEditionElementAdapter() {
		return new PropertiesEditionElementPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.util.Components#createPropertiesMultiEditionElementAdapter()
	 * 
	 */
	public Adapter createPropertiesMultiEditionElementAdapter() {
		return new PropertiesMultiEditionElementPropertiesEditionProvider();
	}

}

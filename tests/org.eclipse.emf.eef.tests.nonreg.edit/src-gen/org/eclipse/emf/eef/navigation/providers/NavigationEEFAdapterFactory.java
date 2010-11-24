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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.eef.eefnr.navigation.util.NavigationAdapterFactory;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class NavigationEEFAdapterFactory extends NavigationAdapterFactory {


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.Navigation#createDeferedFlatReferenceTableEditorSampleAdapter()
	 * 
	 */
	public Adapter createDeferedFlatReferenceTableEditorSampleAdapter() {
		return new DeferedFlatReferencesTableSampleEditorPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.Navigation#createDeferedReferenceTableEditorSampleAdapter()
	 * 
	 */
	public Adapter createDeferedReferenceTableEditorSampleAdapter() {
		return new DeferedReferencesTableSampleEditorPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.Navigation#createOwnerAdapter()
	 * 
	 */
	public Adapter createOwnerAdapter() {
		return new OwnerPropertiesEditionProvider();
	}


	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.eefnr.util.Navigation#createSubtypeAdapter()
	 * 
	 */
	public Adapter createSubtypeAdapter() {
		return new SubtypePropertiesEditionProvider();
	}

}

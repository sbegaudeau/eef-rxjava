/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.providers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProviderFactory;

/**
 * A default implementation of the {@link IPropertiesEditionProviderFactory}
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class StandardPropertiesEditionProviderFactory implements IPropertiesEditionProviderFactory {

	/**
	 * List of managed providers.
	 */
	private List editPropertiesProviders;

	/**
	 * Default constructor.
	 */
	public StandardPropertiesEditionProviderFactory() {
		editPropertiesProviders = new ArrayList();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProviderFactory#getProvider(org.eclipse.emf.ecore.EObject)
	 */
	public IPropertiesEditionProvider getProvider(EObject eObject) {
		for (Iterator iter = editPropertiesProviders.iterator(); iter.hasNext();) {
			IPropertiesEditionProvider editPropertiesProvider = (IPropertiesEditionProvider)iter.next();
			if (editPropertiesProvider.provides(eObject))
				return editPropertiesProvider;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProviderFactory#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		for (Iterator iter = editPropertiesProviders.iterator(); iter.hasNext();) {
			IPropertiesEditionProvider editPropertiesProvider = (IPropertiesEditionProvider)iter.next();
			if (editPropertiesProvider.provides(eObject))
				return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProviderFactory#register(org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider)
	 */
	public void register(IPropertiesEditionProvider editPropertiesProvider) {
		editPropertiesProviders.add(editPropertiesProvider);
	}

}

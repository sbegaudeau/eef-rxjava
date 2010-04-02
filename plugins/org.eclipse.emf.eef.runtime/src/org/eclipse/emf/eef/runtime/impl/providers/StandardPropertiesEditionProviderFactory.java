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
	private List<IPropertiesEditionProvider> editPropertiesProviders;

	/**
	 * Default constructor.
	 */
	public StandardPropertiesEditionProviderFactory() {
		editPropertiesProviders = new ArrayList<IPropertiesEditionProvider>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProviderFactory#getProvider(org.eclipse.emf.ecore.EObject)
	 */
	public IPropertiesEditionProvider getProvider(EObject eObject) {
		for (IPropertiesEditionProvider editPropertiesProvider : editPropertiesProviders) {
			if (editPropertiesProvider.provides(eObject))
				return editPropertiesProvider;
		}
		return null;
	}

	/**
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProviderFactory#getProvider(org.eclipse.emf.ecore.EObject, java.lang.Class)
	 */
	public IPropertiesEditionProvider getProvider(EObject eObject, java.lang.Class refinement) {
    for (IPropertiesEditionProvider editPropertiesProvider : editPropertiesProviders) {
      if (editPropertiesProvider.provides(eObject, refinement))
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
		for (IPropertiesEditionProvider editPropertiesProvider : editPropertiesProviders) {
			if (editPropertiesProvider.provides(eObject))
				return true;
		}
		return false;
	}

	/**
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProviderFactory#provides(org.eclipse.emf.ecore.EObject, java.lang.Class)
	 */
	public boolean provides(EObject eObject, java.lang.Class refinement) {
    for (IPropertiesEditionProvider editPropertiesProvider : editPropertiesProviders) {
      if (editPropertiesProvider.provides(eObject, refinement))
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

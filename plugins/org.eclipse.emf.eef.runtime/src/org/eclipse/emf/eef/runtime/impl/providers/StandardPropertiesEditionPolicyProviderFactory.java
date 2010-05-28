/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
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
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class StandardPropertiesEditionPolicyProviderFactory implements IPropertiesEditionPolicyProviderFactory {

	/**
	 * List of managed providers.
	 */
	private List<IPropertiesEditionPolicyProvider> editPropertiesPolicyProviders;

	/**
	 * Default constructor.
	 */
	public StandardPropertiesEditionPolicyProviderFactory() {
		super();
		editPropertiesPolicyProviders = new ArrayList<IPropertiesEditionPolicyProvider>();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory#getProvider(org.eclipse.emf.ecore.EObject)
	 */
	public IPropertiesEditionPolicyProvider getProvider(EObject eObject) {
		for (IPropertiesEditionPolicyProvider editPropertiesPolicyProvider : editPropertiesPolicyProviders) {
			if (editPropertiesPolicyProvider.provides(eObject))
				return editPropertiesPolicyProvider;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		for (IPropertiesEditionPolicyProvider editPropertiesPolicyProvider : editPropertiesPolicyProviders) {
			if (editPropertiesPolicyProvider.provides(eObject))
				return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory#register(org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider)
	 */
	public void register(IPropertiesEditionPolicyProvider editPropertiesPolicyProvider) {
		editPropertiesPolicyProviders.add(editPropertiesPolicyProvider);
	}

}

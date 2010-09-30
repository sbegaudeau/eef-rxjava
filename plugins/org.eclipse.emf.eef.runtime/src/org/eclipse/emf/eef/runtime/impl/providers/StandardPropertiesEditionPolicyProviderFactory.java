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

import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyProvider;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class StandardPropertiesEditionPolicyProviderFactory implements IPropertiesEditionPolicyProviderFactory {

	/**
	 * List of managed providers.
	 */
	private List<PropertiesEditingPolicyProvider> editPropertiesPolicyProviders;

	/**
	 * Default constructor.
	 */
	public StandardPropertiesEditionPolicyProviderFactory() {
		super();
		editPropertiesPolicyProviders = new ArrayList<PropertiesEditingPolicyProvider>();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory#getProvider(org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext)
	 */
	public PropertiesEditingPolicyProvider getProvider(IPropertiesEditionContext context) {
		for (PropertiesEditingPolicyProvider editPropertiesPolicyProvider : editPropertiesPolicyProviders) {
			if (editPropertiesPolicyProvider.provides(context))
				return editPropertiesPolicyProvider;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory#provides(org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext)
	 */
	public boolean provides(IPropertiesEditionContext context) {
		for (PropertiesEditingPolicyProvider editPropertiesPolicyProvider : editPropertiesPolicyProviders) {
			if (editPropertiesPolicyProvider.provides(context))
				return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProviderFactory#register(org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyProvider)
	 */
	public void register(PropertiesEditingPolicyProvider editPropertiesPolicyProvider) {
		editPropertiesPolicyProviders.add(editPropertiesPolicyProvider);
	}

}

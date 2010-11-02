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
package org.eclipse.emf.eef.runtime.api.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyProvider;

/**
 * Defines the {@link IEditPropertiesProvider} factories interface.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public interface IPropertiesEditionPolicyProviderFactory {

	/**
	 * Indicates whether this provider provides the specified {@link EObject}.
	 * 
	 * @param context
	 *            the {@link PropertiesEditingContext} to provide
	 * @return <code>true</code> if this provider provides the given context; <code>false</code> otherwise.
	 */
	public abstract boolean provides(PropertiesEditingContext context);

	/**
	 * Register a new {@link PropertiesEditingPolicyProvider} in the factory.
	 * 
	 * @param provider
	 */
	public abstract void register(PropertiesEditingPolicyProvider provider);

	/**
	 * Provides a {@link PropertiesEditingPolicyProvider} for the specified context.
	 * 
	 * @param context
	 *            the context to process
	 * @return the {@link PropertiesEditingPolicyProvider} for the specified context.
	 */
	public abstract PropertiesEditingPolicyProvider getProvider(PropertiesEditingContext context);

}

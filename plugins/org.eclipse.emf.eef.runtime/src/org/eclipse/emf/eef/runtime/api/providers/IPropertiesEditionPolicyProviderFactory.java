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

/**
 * Defines the {@link IEditPropertiesProvider} factories interface.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public interface IPropertiesEditionPolicyProviderFactory {

	/**
	 * Indicates whether this provider provides the specified {@link EObject}.
	 * 
	 * @param eObject
	 *            the {@link EObject} to provide
	 * @return <code>true</code> if this provider provides the eObject; <code>false</code> otherwise.
	 */
	public abstract boolean provides(EObject eObject);

	/**
	 * Register a new {@link IPropertiesEditionPolicyProvider} in the factory.
	 * 
	 * @param editPropertiesPolicyProvider
	 */
	public abstract void register(IPropertiesEditionPolicyProvider editPropertiesPolicyProvider);

	/**
	 * Provides a {@link IPropertiesEditionPolicyProvider} for the specified eObject.
	 * 
	 * @param eObject
	 *            the eObject to edit
	 * @return the {@link IPropertiesEditionPolicyProvider} for the specified eObject.
	 */
	public abstract IPropertiesEditionPolicyProvider getProvider(EObject eObject);

}

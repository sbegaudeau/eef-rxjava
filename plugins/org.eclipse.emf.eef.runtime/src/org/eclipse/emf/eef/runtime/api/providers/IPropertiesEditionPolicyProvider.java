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
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public interface IPropertiesEditionPolicyProvider {

	/**
	 * Defines if the current provider can define an EditionPolicy for the given EObject.
	 * 
	 * @param eObject
	 *            the eObject to provide.
	 * @return <code>true</code> if this provider can provide for the given EObject.
	 */
	public boolean provides(EObject eObject);

	/**
	 * Provides a {@link IPropertiesEditionPolicy} to edition the properties of the given EObject.
	 * 
	 * @param eObject
	 *            the eObject to provide.
	 * @return a edition policy to edit the properties of the given EObject.
	 */
	public IPropertiesEditionPolicy getEditionPolicy(EObject eObject);

}

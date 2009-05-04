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
package org.eclipse.emf.eef.runtime.api.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

/**
 * Interface to implement by {@link IPropertiesEditionComponent} providers.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public interface IPropertiesEditionProvider {

	/**
	 * Indicates whether this provider provides the specified {@link EObject}.
	 * 
	 * @param eObject
	 *            the {@link EObject} to provide
	 * @return <code>true</code> if this provider provides the eObject; <code>false</code> otherwise.
	 */
	public abstract boolean provides(EObject eObject);

	/**
	 * Returns a stateful {@link IPropertiesEditionComponent} able to edit the specified eObject.
	 * 
	 * @param eObject
	 *            the {@link EObject} to edit
	 * @param mode
	 *            the editing mode
	 * @return the edition component
	 */
	public abstract IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String mode);

	/**
	 * Returns a stateful {@link IPropertiesEditionComponent} able to edit the specified eObject for a
	 * specific part.
	 * 
	 * @param eObject
	 *            the {@link EObject} to edit
	 * @param mode
	 *            the editing mode
	 * @param param
	 *            the given part
	 * @return the edition component
	 */
	public abstract IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String mode,
			String part);

}

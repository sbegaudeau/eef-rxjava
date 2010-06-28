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
package org.eclipse.emf.eef.runtime.api.policies;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a> A interface that allows to specify a
 *         behavior to edit properties of an eObject. This behavior is parameterized by an
 *         {@link IPropertiesEditionContext}.
 */
public interface IPropertiesEditionPolicy {

	/**
	 * Send a request to obtain a command to edit a EObject.
	 * 
	 * @param propertiesEditionContext
	 *            the edition context.
	 * @return the {@link Command} to update the edited {@link EObject}.
	 */
	public abstract Command getPropertiesEditionCommand(IPropertiesEditionContext propertiesEditionContext);

	/**
	 * Send a request to obtain EObject updating.
	 * 
	 * @param propertiesEditionContext
	 *            the edition context.
	 * @return the updated {@link EObject}.
	 */
	public abstract void getPropertiesEditionObject(IPropertiesEditionContext propertiesEditionContext);

}

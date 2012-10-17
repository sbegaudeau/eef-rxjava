/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.api.notify;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

/**
 * Listener on Properties Edition Component : activated on
 * org.eclipse.emf.eef.runtime
 * .impl.components.SinglePartPropertiesEditingComponent.activate() and dispose
 * on org.eclipse.emf.eef.runtime.impl.components.
 * SinglePartPropertiesEditingComponent.dispose()
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public interface IPropertiesEditionComponentListener {

	/**
	 * @param component IPropertiesEditionComponent
	 * 
	 * Activate the listener
	 */
	void activate(IPropertiesEditionComponent component);

	/**
	 * @param component IPropertiesEditionComponent
	 * 
	 * Dispose the listener
	 */
	void deactivate(IPropertiesEditionComponent component);

}

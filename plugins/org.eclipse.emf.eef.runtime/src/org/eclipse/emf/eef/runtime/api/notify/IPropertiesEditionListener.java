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
package org.eclipse.emf.eef.runtime.api.notify;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public interface IPropertiesEditionListener {

	/**
	 * Specify that a feature value has changed
	 * 
	 * @param event
	 *            the object
	 */
	void firePropertiesChanged(IPropertiesEditionEvent event);

}

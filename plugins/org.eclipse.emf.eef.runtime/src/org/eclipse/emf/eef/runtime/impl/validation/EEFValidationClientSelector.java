/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: EEFValidationClientSelector.java,v 1.1 2009/05/04 09:37:33 sbouchet Exp $
 */
package org.eclipse.emf.eef.runtime.impl.validation;

import org.eclipse.emf.validation.model.IClientSelector;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class EEFValidationClientSelector implements IClientSelector {

	public boolean selects(Object object) {
		return true;
	}

}

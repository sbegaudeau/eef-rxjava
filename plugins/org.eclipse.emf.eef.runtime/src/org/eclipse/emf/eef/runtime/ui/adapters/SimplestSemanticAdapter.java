/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.ui.adapters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.adapters.SemanticAdapter;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public final class SimplestSemanticAdapter implements SemanticAdapter {

	private EObject target;

	public SimplestSemanticAdapter(EObject target) {
		super();
		this.target = target;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.adapters.SemanticAdapter#getEObject()
	 */
	public EObject getEObject() {
		return target;
	}

}
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
package org.eclipse.emf.eef.runtime.impl.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EReferencePropertiesEditionContext extends EObjectPropertiesEditionContext {

	/**
	 * the EReference to edit
	 */
	protected EReference eReference;

	/**
	 * @param propertiesEditionComponent
	 * @param eReference
	 * @param resourceSet
	 */
	public EReferencePropertiesEditionContext(IPropertiesEditionComponent propertiesEditionComponent, EObject eObject, EReference eReference, ResourceSet resourceSet) {
		super(propertiesEditionComponent, eObject, resourceSet);
		this.eReference = eReference;
	}

	/**
	 * @return the eReference
	 */
	public EReference getEReference() {
		return eReference;
	}
}

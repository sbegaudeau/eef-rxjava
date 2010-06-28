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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class DomainPropertiesEditionContext extends EObjectPropertiesEditionContext {

	/**
	 * The domain where edit the EObject
	 */
	protected EditingDomain editingDomain;
	
	/**
	 * @param editComponent
	 * @param eObject
	 */
	public DomainPropertiesEditionContext(IPropertiesEditionComponent editionComponent, EditingDomain domain,
			EObject eObject) {
		super(editionComponent, eObject, domain.getResourceSet());
		this.editingDomain = domain;
	}

	/**
	 * @param editComponent
	 * @param eObject
	 */
	public DomainPropertiesEditionContext(IPropertiesEditionComponent editionComponent, EditingDomain domain,
			EObject eObject, ResourceSet resourceSet) {
		super(editionComponent, eObject, resourceSet);
		this.editingDomain = domain;
	}

	/**
	 * @return the editingDomain
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

}

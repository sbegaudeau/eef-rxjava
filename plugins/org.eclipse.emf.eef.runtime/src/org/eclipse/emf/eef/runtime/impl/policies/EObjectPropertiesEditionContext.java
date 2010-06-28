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
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class EObjectPropertiesEditionContext implements IPropertiesEditionContext {

	/**
	 * the source EditionComponent
	 */
	protected IPropertiesEditionComponent propertiesEditionComponent;

	/**
	 * the EObject to edit
	 */
	protected EObject eObject;

	/**
	 * The ResourceSet where the EObject is located
	 */
	protected ResourceSet resourceSet;

	/**
	 * TODO
	 */
	protected ChangeRecorder changeRecorder;


	/**
	 * @return the changeRecorder
	 */
	public ChangeRecorder getChangeRecorder() {
		return changeRecorder;
	}

	/**
	 * @param eObject
	 * @param resourceSet
	 */
	public EObjectPropertiesEditionContext(IPropertiesEditionComponent propertiesEditionComponent,
			EObject eObject, ResourceSet resourceSet) {
		this.propertiesEditionComponent = propertiesEditionComponent;
		this.eObject = eObject;
		this.resourceSet = resourceSet;
		this.changeRecorder = new ChangeRecorder(resourceSet);
	}

	/**
	 * @return the propertiesEditionComponent
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent() {
		return propertiesEditionComponent;
	}

	/**
	 * @return the eObject
	 */
	public EObject getEObject() {
		return eObject;
	}

	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

}

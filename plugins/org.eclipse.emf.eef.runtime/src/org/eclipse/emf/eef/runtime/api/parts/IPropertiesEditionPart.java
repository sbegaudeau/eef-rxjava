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
package org.eclipse.emf.eef.runtime.api.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener;
import org.eclipse.swt.widgets.Composite;

/**
 * A interface for part of element edition.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public interface IPropertiesEditionPart extends IPropertiesEditionListener {

	/**
	 * Getter for the view
	 * 
	 * @return the part view
	 */
	public Composite getFigure();

	/**
	 * Initialize the part with the specified eObject in the specified ResourceSet.
	 * 
	 * @param eObject
	 *            the eObject for the initialization
	 * @param allResources
	 *            the resourceSet for the initialization
	 */
	public abstract void initComponent(EObject eObject, ResourceSet allResources);

	/**
	 * Initialize the part with the specified eObject.
	 * 
	 * @param eObject
	 *            the eObject for the initialization
	 */
	public void initComponent(EObject eObject);
}

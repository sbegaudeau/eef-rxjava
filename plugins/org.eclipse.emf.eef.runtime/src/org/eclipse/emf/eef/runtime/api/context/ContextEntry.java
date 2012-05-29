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
package org.eclipse.emf.eef.runtime.api.context;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

/**
 * Element that store a navigation step in a properties edition context.
 * 
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ContextEntry {

	/**
	 * The element edited at this step.
	 */
	private EObject element;

	/**
	 * The component that edited the element at this step.
	 */
	private IPropertiesEditionComponent propertiesEditionComponent;

	/**
	 * Parameterized constructors.
	 * 
	 * @param element
	 *            the edited element
	 * @param propertiesEditionComponent
	 *            the edition Component
	 */
	public ContextEntry(EObject element, IPropertiesEditionComponent propertiesEditionComponent) {
		this.element = element;
		this.propertiesEditionComponent = propertiesEditionComponent;
	}

	/**
	 * Returns the edited element.
	 * 
	 * @return the edited element
	 */
	public EObject getElement() {
		return element;
	}

	/**
	 * Returns the edition component.
	 * 
	 * @return the propertiesEditionComponent
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent() {
		return propertiesEditionComponent;
	}

}

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
package org.eclipse.emf.eef.components;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEF Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.components.EEFElement#getHelpID <em>Help ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.components.ComponentsPackage#getEEFElement()
 * @model abstract="true"
 * @generated
 */
public interface EEFElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Help ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Help ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Help ID</em>' attribute.
	 * @see #setHelpID(String)
	 * @see org.eclipse.emf.eef.components.ComponentsPackage#getEEFElement_HelpID()
	 * @model
	 * @generated
	 */
	String getHelpID();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.components.EEFElement#getHelpID <em>Help ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Help ID</em>' attribute.
	 * @see #getHelpID()
	 * @generated
	 */
	void setHelpID(String value);

} // EEFElement

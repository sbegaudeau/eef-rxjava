/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.modelingBot.EclipseActions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open Perspective</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EclipseActions.OpenPerspective#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsPackage#getOpenPerspective()
 * @model
 * @generated
 */
public interface OpenPerspective extends EclipseAction {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsPackage#getOpenPerspective_Type()
	 * @model
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.EclipseActions.OpenPerspective#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // OpenPerspective

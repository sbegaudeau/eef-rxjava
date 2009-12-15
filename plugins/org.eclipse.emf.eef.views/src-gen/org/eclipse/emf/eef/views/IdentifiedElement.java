/**
 *  Copyright (c) 2008 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: IdentifiedElement.java,v 1.3 2009/12/15 23:05:34 glefur Exp $
 */
package org.eclipse.emf.eef.views;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identified Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.views.IdentifiedElement#getQualifiedIdentifier <em>Qualified Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.views.ViewsPackage#getIdentifiedElement()
 * @model abstract="true"
 * @generated
 */
public interface IdentifiedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Qualified Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Identifier</em>' attribute.
	 * @see #setQualifiedIdentifier(String)
	 * @see org.eclipse.emf.eef.views.ViewsPackage#getIdentifiedElement_QualifiedIdentifier()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getQualifiedIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.views.IdentifiedElement#getQualifiedIdentifier <em>Qualified Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Identifier</em>' attribute.
	 * @see #getQualifiedIdentifier()
	 * @generated
	 */
	void setQualifiedIdentifier(String value);

} // IdentifiedElement

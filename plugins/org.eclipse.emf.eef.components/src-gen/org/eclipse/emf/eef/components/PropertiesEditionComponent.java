/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.components;

import org.eclipse.emf.eef.mapping.EMFElementBinding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Properties Edition Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.components.PropertiesEditionComponent#isExplicit <em>Explicit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.components.ComponentsPackage#getPropertiesEditionComponent()
 * @model
 * @generated
 */
public interface PropertiesEditionComponent extends EMFElementBinding, EEFElement {
	/**
	 * Returns the value of the '<em><b>Explicit</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Explicit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Explicit</em>' attribute.
	 * @see #setExplicit(boolean)
	 * @see org.eclipse.emf.eef.components.ComponentsPackage#getPropertiesEditionComponent_Explicit()
	 * @model default="true"
	 * @generated
	 */
	boolean isExplicit();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.components.PropertiesEditionComponent#isExplicit <em>Explicit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Explicit</em>' attribute.
	 * @see #isExplicit()
	 * @generated
	 */
	void setExplicit(boolean value);

} // PropertiesEditionComponent

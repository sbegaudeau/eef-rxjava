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
package org.eclipse.emf.eef.mapping;

import org.eclipse.emf.eef.views.DocumentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Binding Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.mapping.ElementBindingReference#getBinding <em>Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.mapping.MappingPackage#getElementBindingReference()
 * @model
 * @generated
 */
public interface ElementBindingReference extends DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Binding</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' reference.
	 * @see #setBinding(AbstractElementBinding)
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getElementBindingReference_Binding()
	 * @model required="true"
	 * @generated
	 */
	AbstractElementBinding getBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.ElementBindingReference#getBinding <em>Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(AbstractElementBinding value);

} // ElementBindingReference

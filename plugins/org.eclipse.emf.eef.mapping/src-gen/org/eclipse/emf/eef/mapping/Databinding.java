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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Databinding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.mapping.Databinding#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.Databinding#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.mapping.MappingPackage#getDatabinding()
 * @model
 * @generated
 */
public interface Databinding extends DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.mapping.AbstractElementBinding}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.eef.mapping.AbstractElementBinding#getDatabinding <em>Databinding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getDatabinding_Bindings()
	 * @see org.eclipse.emf.eef.mapping.AbstractElementBinding#getDatabinding
	 * @model opposite="databinding" containment="true"
	 * @generated
	 */
	EList<AbstractElementBinding> getBindings();

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.mapping.Category}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.eef.mapping.Category#getDatabinding <em>Databinding</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getDatabinding_Categories()
	 * @see org.eclipse.emf.eef.mapping.Category#getDatabinding
	 * @model opposite="databinding" containment="true"
	 * @generated
	 */
	EList<Category> getCategories();

} // Databinding

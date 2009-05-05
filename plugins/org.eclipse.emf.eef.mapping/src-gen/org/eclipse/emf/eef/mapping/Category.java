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
 * $Id: Category.java,v 1.2 2009/05/05 12:06:54 sbouchet Exp $
 */
package org.eclipse.emf.eef.mapping;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.mapping.Category#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.Category#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.Category#getDatabinding <em>Databinding</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.Category#getCategories <em>Categories</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.mapping.MappingPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getCategory_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.Category#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.mapping.AbstractElementBinding}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.eef.mapping.AbstractElementBinding#getCategory <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getCategory_Bindings()
	 * @see org.eclipse.emf.eef.mapping.AbstractElementBinding#getCategory
	 * @model opposite="category" containment="true"
	 * @generated
	 */
	EList<AbstractElementBinding> getBindings();

	/**
	 * Returns the value of the '<em><b>Databinding</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.eef.mapping.Databinding#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Databinding</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Databinding</em>' container reference.
	 * @see #setDatabinding(Databinding)
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getCategory_Databinding()
	 * @see org.eclipse.emf.eef.mapping.Databinding#getCategories
	 * @model opposite="categories" transient="false"
	 * @generated
	 */
	Databinding getDatabinding();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.Category#getDatabinding <em>Databinding</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Databinding</em>' container reference.
	 * @see #getDatabinding()
	 * @generated
	 */
	void setDatabinding(Databinding value);

	/**
	 * Returns the value of the '<em><b>Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.mapping.Category}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' containment reference list.
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getCategory_Categories()
	 * @model containment="true"
	 * @generated
	 */
	EList<Category> getCategories();

} // Category

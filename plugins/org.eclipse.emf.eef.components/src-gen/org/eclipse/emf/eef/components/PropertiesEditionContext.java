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
 * $Id: PropertiesEditionContext.java,v 1.2 2009/09/10 09:18:17 sbouchet Exp $
 */
package org.eclipse.emf.eef.components;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

import org.eclipse.emf.eef.mapping.Databinding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Properties Edition Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.components.PropertiesEditionContext#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.components.ComponentsPackage#getPropertiesEditionContext()
 * @model
 * @generated
 */
public interface PropertiesEditionContext extends Databinding {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' reference.
	 * @see #setModel(GenPackage)
	 * @see org.eclipse.emf.eef.components.ComponentsPackage#getPropertiesEditionContext_Model()
	 * @model required="true"
	 * @generated
	 */
	GenPackage getModel();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.components.PropertiesEditionContext#getModel <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(GenPackage value);

} // PropertiesEditionContext

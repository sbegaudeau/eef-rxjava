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
 * A representation of the model object '<em><b>Model Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.mapping.ModelProperty#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.ModelProperty#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.mapping.MappingPackage#getModelProperty()
 * @model abstract="true"
 * @generated
 */
public interface ModelProperty extends DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Binding</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.eef.mapping.StandardPropertyBinding#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' reference.
	 * @see #setBinding(StandardPropertyBinding)
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getModelProperty_Binding()
	 * @see org.eclipse.emf.eef.mapping.StandardPropertyBinding#getModel
	 * @model opposite="model"
	 * @generated
	 */
	StandardPropertyBinding getBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.ModelProperty#getBinding <em>Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(StandardPropertyBinding value);

	/**
	 * Returns the value of the '<em><b>Model Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.eef.mapping.ModelElement#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Element</em>' container reference.
	 * @see #setModelElement(ModelElement)
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getModelProperty_ModelElement()
	 * @see org.eclipse.emf.eef.mapping.ModelElement#getProperties
	 * @model opposite="properties" transient="false"
	 * @generated
	 */
	ModelElement getModelElement();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.ModelProperty#getModelElement <em>Model Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Element</em>' container reference.
	 * @see #getModelElement()
	 * @generated
	 */
	void setModelElement(ModelElement value);

} // ModelProperty

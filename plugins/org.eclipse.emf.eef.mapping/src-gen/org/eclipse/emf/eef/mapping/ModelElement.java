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
import org.eclipse.emf.eef.views.DocumentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.mapping.ModelElement#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.ModelElement#getSubElements <em>Sub Elements</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.ModelElement#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.ModelElement#getSuperElement <em>Super Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.mapping.MappingPackage#getModelElement()
 * @model abstract="true"
 * @generated
 */
public interface ModelElement extends DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.mapping.ModelProperty}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.eef.mapping.ModelProperty#getModelElement <em>Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference list.
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getModelElement_Properties()
	 * @see org.eclipse.emf.eef.mapping.ModelProperty#getModelElement
	 * @model opposite="modelElement" containment="true"
	 * @generated
	 */
	EList<ModelProperty> getProperties();

	/**
	 * Returns the value of the '<em><b>Sub Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.mapping.ModelElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.eef.mapping.ModelElement#getSuperElement <em>Super Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Elements</em>' containment reference list.
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getModelElement_SubElements()
	 * @see org.eclipse.emf.eef.mapping.ModelElement#getSuperElement
	 * @model opposite="superElement" containment="true"
	 * @generated
	 */
	EList<ModelElement> getSubElements();

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.eef.mapping.StandardElementBinding#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' reference.
	 * @see #setBinding(StandardElementBinding)
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getModelElement_Binding()
	 * @see org.eclipse.emf.eef.mapping.StandardElementBinding#getModel
	 * @model opposite="model"
	 * @generated
	 */
	StandardElementBinding getBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.ModelElement#getBinding <em>Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' reference.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(StandardElementBinding value);

	/**
	 * Returns the value of the '<em><b>Super Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.eef.mapping.ModelElement#getSubElements <em>Sub Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Element</em>' container reference.
	 * @see #setSuperElement(ModelElement)
	 * @see org.eclipse.emf.eef.mapping.MappingPackage#getModelElement_SuperElement()
	 * @see org.eclipse.emf.eef.mapping.ModelElement#getSubElements
	 * @model opposite="subElements" transient="false"
	 * @generated
	 */
	ModelElement getSuperElement();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.ModelElement#getSuperElement <em>Super Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Element</em>' container reference.
	 * @see #getSuperElement()
	 * @generated
	 */
	void setSuperElement(ModelElement value);

} // ModelElement

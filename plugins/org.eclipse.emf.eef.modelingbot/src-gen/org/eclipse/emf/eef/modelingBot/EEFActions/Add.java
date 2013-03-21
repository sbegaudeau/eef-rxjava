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
package org.eclipse.emf.eef.modelingBot.EEFActions;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.Add#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.Add#getTypeURI <em>Type URI</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.Add#getComputedType <em>Computed Type</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.Add#getEContainingFeature <em>EContaining Feature</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.Add#getEContainingFeatureURI <em>EContaining Feature URI</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.Add#getComputedEContainingFeature <em>Computed EContaining Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getAdd()
 * @model
 * @generated
 */
public interface Add extends EditAction {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getAdd_Type()
	 * @model
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.EEFActions.Add#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type URI</em>' attribute.
	 * @see #setTypeURI(String)
	 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getAdd_TypeURI()
	 * @model
	 * @generated
	 */
	String getTypeURI();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.EEFActions.Add#getTypeURI <em>Type URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type URI</em>' attribute.
	 * @see #getTypeURI()
	 * @generated
	 */
	void setTypeURI(String value);

	/**
	 * Returns the value of the '<em><b>Computed Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computed Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computed Type</em>' reference.
	 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getAdd_ComputedType()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EClass getComputedType();

	/**
	 * Returns the value of the '<em><b>EContaining Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EContaining Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EContaining Feature</em>' reference.
	 * @see #setEContainingFeature(EStructuralFeature)
	 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getAdd_EContainingFeature()
	 * @model
	 * @generated
	 */
	EStructuralFeature getEContainingFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.EEFActions.Add#getEContainingFeature <em>EContaining Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EContaining Feature</em>' reference.
	 * @see #getEContainingFeature()
	 * @generated
	 */
	void setEContainingFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>EContaining Feature URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EContaining Feature URI</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EContaining Feature URI</em>' attribute.
	 * @see #setEContainingFeatureURI(String)
	 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getAdd_EContainingFeatureURI()
	 * @model
	 * @generated
	 */
	String getEContainingFeatureURI();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.EEFActions.Add#getEContainingFeatureURI <em>EContaining Feature URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EContaining Feature URI</em>' attribute.
	 * @see #getEContainingFeatureURI()
	 * @generated
	 */
	void setEContainingFeatureURI(String value);

	/**
	 * Returns the value of the '<em><b>Computed EContaining Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computed EContaining Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computed EContaining Feature</em>' reference.
	 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getAdd_ComputedEContainingFeature()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EStructuralFeature getComputedEContainingFeature();
} // Add

/**
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.htm
 * Contributors: Obeo - initial API and implementation
 */
package org.eclipse.eef;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEF Select Style Customization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents a style customization applied on a combo widget.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.eef.EEFSelectStyleCustomization#getStyle <em>Style</em>}</li>
 * </ul>
 *
 * @see org.eclipse.eef.EefPackage#getEEFSelectStyleCustomization()
 * @model
 * @generated
 */
public interface EEFSelectStyleCustomization extends EEFStyleCustomization {
	/**
	 * Returns the value of the '<em><b>Style</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines the style.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Style</em>' containment reference.
	 * @see #setStyle(EEFSelectStyle)
	 * @see org.eclipse.eef.EefPackage#getEEFSelectStyleCustomization_Style()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EEFSelectStyle getStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFSelectStyleCustomization#getStyle <em>Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' containment reference.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(EEFSelectStyle value);

} // EEFSelectStyleCustomization
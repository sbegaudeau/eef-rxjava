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
 * A representation of the model object '<em><b>EEF Checkbox Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Represents a style that can be applied on checkbox widgets.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.eef.EEFCheckboxStyle#getBackgroundColorExpression <em>Background Color Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFCheckboxStyle#getForegroundColorExpression <em>Foreground Color Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.eef.EefPackage#getEEFCheckboxStyle()
 * @model
 * @generated
 */
public interface EEFCheckboxStyle extends EEFStyle {
	/**
	 * Returns the value of the '<em><b>Background Color Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Background Color Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Color Expression</em>' attribute.
	 * @see #setBackgroundColorExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFCheckboxStyle_BackgroundColorExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getBackgroundColorExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFCheckboxStyle#getBackgroundColorExpression <em>Background Color Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Color Expression</em>' attribute.
	 * @see #getBackgroundColorExpression()
	 * @generated
	 */
	void setBackgroundColorExpression(String value);

	/**
	 * Returns the value of the '<em><b>Foreground Color Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Foreground Color Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Foreground Color Expression</em>' attribute.
	 * @see #setForegroundColorExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFCheckboxStyle_ForegroundColorExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getForegroundColorExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFCheckboxStyle#getForegroundColorExpression <em>Foreground Color Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Foreground Color Expression</em>' attribute.
	 * @see #getForegroundColorExpression()
	 * @generated
	 */
	void setForegroundColorExpression(String value);

} // EEFCheckboxStyle
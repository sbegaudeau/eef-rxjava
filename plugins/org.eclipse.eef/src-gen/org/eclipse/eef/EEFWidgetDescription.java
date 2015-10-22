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
 * A representation of the model object '<em><b>EEF Widget Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Graphical element.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.eef.EEFWidgetDescription#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFWidgetDescription#getLabelExpression <em>Label Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFWidgetDescription#getLabelStyle <em>Label Style</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFWidgetDescription#getTooltipExpression <em>Tooltip Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFWidgetDescription#getHelpExpression <em>Help Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.EEFWidgetDescription#getValidationExpression <em>Validation Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.eef.EefPackage#getEEFWidgetDescription()
 * @model abstract="true"
 * @generated
 */
public interface EEFWidgetDescription extends ContextableElement {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Used to identify a specific widget.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see org.eclipse.eef.EefPackage#getEEFWidgetDescription_Identifier()
	 * @model required="true"
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFWidgetDescription#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

	/**
	 * Returns the value of the '<em><b>Label Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The label of the Widget visible by the end-users.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Label Expression</em>' attribute.
	 * @see #setLabelExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFWidgetDescription_LabelExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getLabelExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFWidgetDescription#getLabelExpression <em>Label Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Expression</em>' attribute.
	 * @see #getLabelExpression()
	 * @generated
	 */
	void setLabelExpression(String value);

	/**
	 * Returns the value of the '<em><b>Label Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The style of the label.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Label Style</em>' reference.
	 * @see #setLabelStyle(EEFLabelStyle)
	 * @see org.eclipse.eef.EefPackage#getEEFWidgetDescription_LabelStyle()
	 * @model
	 * @generated
	 */
	EEFLabelStyle getLabelStyle();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFWidgetDescription#getLabelStyle <em>Label Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Style</em>' reference.
	 * @see #getLabelStyle()
	 * @generated
	 */
	void setLabelStyle(EEFLabelStyle value);

	/**
	 * Returns the value of the '<em><b>Tooltip Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The tooltip of the Widget visible by the end-users.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tooltip Expression</em>' attribute.
	 * @see #setTooltipExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFWidgetDescription_TooltipExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getTooltipExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFWidgetDescription#getTooltipExpression <em>Tooltip Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tooltip Expression</em>' attribute.
	 * @see #getTooltipExpression()
	 * @generated
	 */
	void setTooltipExpression(String value);

	/**
	 * Returns the value of the '<em><b>Help Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The help of the Widget visible by the end-users.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Help Expression</em>' attribute.
	 * @see #setHelpExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFWidgetDescription_HelpExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getHelpExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFWidgetDescription#getHelpExpression <em>Help Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Help Expression</em>' attribute.
	 * @see #getHelpExpression()
	 * @generated
	 */
	void setHelpExpression(String value);

	/**
	 * Returns the value of the '<em><b>Validation Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Defines if the widget value is valid or not.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validation Expression</em>' attribute.
	 * @see #setValidationExpression(String)
	 * @see org.eclipse.eef.EefPackage#getEEFWidgetDescription_ValidationExpression()
	 * @model dataType="org.eclipse.eef.Expression"
	 * @generated
	 */
	String getValidationExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.eef.EEFWidgetDescription#getValidationExpression <em>Validation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation Expression</em>' attribute.
	 * @see #getValidationExpression()
	 * @generated
	 */
	void setValidationExpression(String value);

} // EEFWidgetDescription

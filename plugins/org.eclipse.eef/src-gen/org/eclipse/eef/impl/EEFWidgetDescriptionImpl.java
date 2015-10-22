/**
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.htm
 * Contributors: Obeo - initial API and implementation
 */
package org.eclipse.eef.impl;

import org.eclipse.eef.EEFLabelStyle;
import org.eclipse.eef.EEFWidgetDescription;
import org.eclipse.eef.EefPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EEF Widget Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.eef.impl.EEFWidgetDescriptionImpl#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFWidgetDescriptionImpl#getLabelExpression <em>Label Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFWidgetDescriptionImpl#getLabelStyle <em>Label Style</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFWidgetDescriptionImpl#getTooltipExpression <em>Tooltip Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFWidgetDescriptionImpl#getHelpExpression <em>Help Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFWidgetDescriptionImpl#getValidationExpression <em>Validation Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class EEFWidgetDescriptionImpl extends ContextableElementImpl implements EEFWidgetDescription {
	/**
	 * The default value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String IDENTIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdentifier() <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String identifier = IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabelExpression() <em>Label Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabelExpression() <em>Label Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelExpression()
	 * @generated
	 * @ordered
	 */
	protected String labelExpression = LABEL_EXPRESSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLabelStyle() <em>Label Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelStyle()
	 * @generated
	 * @ordered
	 */
	protected EEFLabelStyle labelStyle;

	/**
	 * The default value of the '{@link #getTooltipExpression() <em>Tooltip Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltipExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String TOOLTIP_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTooltipExpression() <em>Tooltip Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTooltipExpression()
	 * @generated
	 * @ordered
	 */
	protected String tooltipExpression = TOOLTIP_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getHelpExpression() <em>Help Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelpExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String HELP_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHelpExpression() <em>Help Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelpExpression()
	 * @generated
	 * @ordered
	 */
	protected String helpExpression = HELP_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getValidationExpression() <em>Validation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String VALIDATION_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValidationExpression() <em>Validation Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationExpression()
	 * @generated
	 * @ordered
	 */
	protected String validationExpression = VALIDATION_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EEFWidgetDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefPackage.Literals.EEF_WIDGET_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIdentifier(String newIdentifier) {
		String oldIdentifier = identifier;
		identifier = newIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_WIDGET_DESCRIPTION__IDENTIFIER, oldIdentifier, identifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLabelExpression() {
		return labelExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLabelExpression(String newLabelExpression) {
		String oldLabelExpression = labelExpression;
		labelExpression = newLabelExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_EXPRESSION, oldLabelExpression,
					labelExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEFLabelStyle getLabelStyle() {
		if (labelStyle != null && labelStyle.eIsProxy()) {
			InternalEObject oldLabelStyle = (InternalEObject) labelStyle;
			labelStyle = (EEFLabelStyle) eResolveProxy(oldLabelStyle);
			if (labelStyle != oldLabelStyle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_STYLE, oldLabelStyle,
							labelStyle));
			}
		}
		return labelStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEFLabelStyle basicGetLabelStyle() {
		return labelStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLabelStyle(EEFLabelStyle newLabelStyle) {
		EEFLabelStyle oldLabelStyle = labelStyle;
		labelStyle = newLabelStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_STYLE, oldLabelStyle, labelStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTooltipExpression() {
		return tooltipExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTooltipExpression(String newTooltipExpression) {
		String oldTooltipExpression = tooltipExpression;
		tooltipExpression = newTooltipExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_WIDGET_DESCRIPTION__TOOLTIP_EXPRESSION, oldTooltipExpression,
					tooltipExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHelpExpression() {
		return helpExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHelpExpression(String newHelpExpression) {
		String oldHelpExpression = helpExpression;
		helpExpression = newHelpExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_WIDGET_DESCRIPTION__HELP_EXPRESSION, oldHelpExpression,
					helpExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValidationExpression() {
		return validationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValidationExpression(String newValidationExpression) {
		String oldValidationExpression = validationExpression;
		validationExpression = newValidationExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_WIDGET_DESCRIPTION__VALIDATION_EXPRESSION, oldValidationExpression,
					validationExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EefPackage.EEF_WIDGET_DESCRIPTION__IDENTIFIER:
			return getIdentifier();
		case EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_EXPRESSION:
			return getLabelExpression();
		case EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_STYLE:
			if (resolve)
				return getLabelStyle();
			return basicGetLabelStyle();
		case EefPackage.EEF_WIDGET_DESCRIPTION__TOOLTIP_EXPRESSION:
			return getTooltipExpression();
		case EefPackage.EEF_WIDGET_DESCRIPTION__HELP_EXPRESSION:
			return getHelpExpression();
		case EefPackage.EEF_WIDGET_DESCRIPTION__VALIDATION_EXPRESSION:
			return getValidationExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case EefPackage.EEF_WIDGET_DESCRIPTION__IDENTIFIER:
			setIdentifier((String) newValue);
			return;
		case EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_EXPRESSION:
			setLabelExpression((String) newValue);
			return;
		case EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_STYLE:
			setLabelStyle((EEFLabelStyle) newValue);
			return;
		case EefPackage.EEF_WIDGET_DESCRIPTION__TOOLTIP_EXPRESSION:
			setTooltipExpression((String) newValue);
			return;
		case EefPackage.EEF_WIDGET_DESCRIPTION__HELP_EXPRESSION:
			setHelpExpression((String) newValue);
			return;
		case EefPackage.EEF_WIDGET_DESCRIPTION__VALIDATION_EXPRESSION:
			setValidationExpression((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case EefPackage.EEF_WIDGET_DESCRIPTION__IDENTIFIER:
			setIdentifier(IDENTIFIER_EDEFAULT);
			return;
		case EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_EXPRESSION:
			setLabelExpression(LABEL_EXPRESSION_EDEFAULT);
			return;
		case EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_STYLE:
			setLabelStyle((EEFLabelStyle) null);
			return;
		case EefPackage.EEF_WIDGET_DESCRIPTION__TOOLTIP_EXPRESSION:
			setTooltipExpression(TOOLTIP_EXPRESSION_EDEFAULT);
			return;
		case EefPackage.EEF_WIDGET_DESCRIPTION__HELP_EXPRESSION:
			setHelpExpression(HELP_EXPRESSION_EDEFAULT);
			return;
		case EefPackage.EEF_WIDGET_DESCRIPTION__VALIDATION_EXPRESSION:
			setValidationExpression(VALIDATION_EXPRESSION_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case EefPackage.EEF_WIDGET_DESCRIPTION__IDENTIFIER:
			return IDENTIFIER_EDEFAULT == null ? identifier != null : !IDENTIFIER_EDEFAULT.equals(identifier);
		case EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_EXPRESSION:
			return LABEL_EXPRESSION_EDEFAULT == null ? labelExpression != null : !LABEL_EXPRESSION_EDEFAULT.equals(labelExpression);
		case EefPackage.EEF_WIDGET_DESCRIPTION__LABEL_STYLE:
			return labelStyle != null;
		case EefPackage.EEF_WIDGET_DESCRIPTION__TOOLTIP_EXPRESSION:
			return TOOLTIP_EXPRESSION_EDEFAULT == null ? tooltipExpression != null : !TOOLTIP_EXPRESSION_EDEFAULT.equals(tooltipExpression);
		case EefPackage.EEF_WIDGET_DESCRIPTION__HELP_EXPRESSION:
			return HELP_EXPRESSION_EDEFAULT == null ? helpExpression != null : !HELP_EXPRESSION_EDEFAULT.equals(helpExpression);
		case EefPackage.EEF_WIDGET_DESCRIPTION__VALIDATION_EXPRESSION:
			return VALIDATION_EXPRESSION_EDEFAULT == null ? validationExpression != null
					: !VALIDATION_EXPRESSION_EDEFAULT.equals(validationExpression);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (identifier: "); //$NON-NLS-1$
		result.append(identifier);
		result.append(", labelExpression: "); //$NON-NLS-1$
		result.append(labelExpression);
		result.append(", tooltipExpression: "); //$NON-NLS-1$
		result.append(tooltipExpression);
		result.append(", helpExpression: "); //$NON-NLS-1$
		result.append(helpExpression);
		result.append(", validationExpression: "); //$NON-NLS-1$
		result.append(validationExpression);
		result.append(')');
		return result.toString();
	}

} //EEFWidgetDescriptionImpl

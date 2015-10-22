/**
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.htm
 * Contributors: Obeo - initial API and implementation
 */
package org.eclipse.eef.impl;

import org.eclipse.eef.EEFColumnStyle;
import org.eclipse.eef.EefPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EEF Column Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.eef.impl.EEFColumnStyleImpl#getBackgroundColorExpression <em>Background Color Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFColumnStyleImpl#getForegroundColorExpression <em>Foreground Color Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFColumnStyleImpl#getHeaderBackgroundColorExpression <em>Header Background Color Expression</em>}</li>
 *   <li>{@link org.eclipse.eef.impl.EEFColumnStyleImpl#getHeaderForegroundColorExpression <em>Header Foreground Color Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EEFColumnStyleImpl extends EEFStyleImpl implements EEFColumnStyle {
	/**
	 * The default value of the '{@link #getBackgroundColorExpression() <em>Background Color Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColorExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String BACKGROUND_COLOR_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBackgroundColorExpression() <em>Background Color Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColorExpression()
	 * @generated
	 * @ordered
	 */
	protected String backgroundColorExpression = BACKGROUND_COLOR_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getForegroundColorExpression() <em>Foreground Color Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColorExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String FOREGROUND_COLOR_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForegroundColorExpression() <em>Foreground Color Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColorExpression()
	 * @generated
	 * @ordered
	 */
	protected String foregroundColorExpression = FOREGROUND_COLOR_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeaderBackgroundColorExpression() <em>Header Background Color Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderBackgroundColorExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String HEADER_BACKGROUND_COLOR_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeaderBackgroundColorExpression() <em>Header Background Color Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderBackgroundColorExpression()
	 * @generated
	 * @ordered
	 */
	protected String headerBackgroundColorExpression = HEADER_BACKGROUND_COLOR_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeaderForegroundColorExpression() <em>Header Foreground Color Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderForegroundColorExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String HEADER_FOREGROUND_COLOR_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHeaderForegroundColorExpression() <em>Header Foreground Color Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeaderForegroundColorExpression()
	 * @generated
	 * @ordered
	 */
	protected String headerForegroundColorExpression = HEADER_FOREGROUND_COLOR_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EEFColumnStyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefPackage.Literals.EEF_COLUMN_STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBackgroundColorExpression() {
		return backgroundColorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBackgroundColorExpression(String newBackgroundColorExpression) {
		String oldBackgroundColorExpression = backgroundColorExpression;
		backgroundColorExpression = newBackgroundColorExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_COLUMN_STYLE__BACKGROUND_COLOR_EXPRESSION,
					oldBackgroundColorExpression, backgroundColorExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getForegroundColorExpression() {
		return foregroundColorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForegroundColorExpression(String newForegroundColorExpression) {
		String oldForegroundColorExpression = foregroundColorExpression;
		foregroundColorExpression = newForegroundColorExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_COLUMN_STYLE__FOREGROUND_COLOR_EXPRESSION,
					oldForegroundColorExpression, foregroundColorExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHeaderBackgroundColorExpression() {
		return headerBackgroundColorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeaderBackgroundColorExpression(String newHeaderBackgroundColorExpression) {
		String oldHeaderBackgroundColorExpression = headerBackgroundColorExpression;
		headerBackgroundColorExpression = newHeaderBackgroundColorExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_COLUMN_STYLE__HEADER_BACKGROUND_COLOR_EXPRESSION,
					oldHeaderBackgroundColorExpression, headerBackgroundColorExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHeaderForegroundColorExpression() {
		return headerForegroundColorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeaderForegroundColorExpression(String newHeaderForegroundColorExpression) {
		String oldHeaderForegroundColorExpression = headerForegroundColorExpression;
		headerForegroundColorExpression = newHeaderForegroundColorExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_COLUMN_STYLE__HEADER_FOREGROUND_COLOR_EXPRESSION,
					oldHeaderForegroundColorExpression, headerForegroundColorExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EefPackage.EEF_COLUMN_STYLE__BACKGROUND_COLOR_EXPRESSION:
			return getBackgroundColorExpression();
		case EefPackage.EEF_COLUMN_STYLE__FOREGROUND_COLOR_EXPRESSION:
			return getForegroundColorExpression();
		case EefPackage.EEF_COLUMN_STYLE__HEADER_BACKGROUND_COLOR_EXPRESSION:
			return getHeaderBackgroundColorExpression();
		case EefPackage.EEF_COLUMN_STYLE__HEADER_FOREGROUND_COLOR_EXPRESSION:
			return getHeaderForegroundColorExpression();
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
		case EefPackage.EEF_COLUMN_STYLE__BACKGROUND_COLOR_EXPRESSION:
			setBackgroundColorExpression((String) newValue);
			return;
		case EefPackage.EEF_COLUMN_STYLE__FOREGROUND_COLOR_EXPRESSION:
			setForegroundColorExpression((String) newValue);
			return;
		case EefPackage.EEF_COLUMN_STYLE__HEADER_BACKGROUND_COLOR_EXPRESSION:
			setHeaderBackgroundColorExpression((String) newValue);
			return;
		case EefPackage.EEF_COLUMN_STYLE__HEADER_FOREGROUND_COLOR_EXPRESSION:
			setHeaderForegroundColorExpression((String) newValue);
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
		case EefPackage.EEF_COLUMN_STYLE__BACKGROUND_COLOR_EXPRESSION:
			setBackgroundColorExpression(BACKGROUND_COLOR_EXPRESSION_EDEFAULT);
			return;
		case EefPackage.EEF_COLUMN_STYLE__FOREGROUND_COLOR_EXPRESSION:
			setForegroundColorExpression(FOREGROUND_COLOR_EXPRESSION_EDEFAULT);
			return;
		case EefPackage.EEF_COLUMN_STYLE__HEADER_BACKGROUND_COLOR_EXPRESSION:
			setHeaderBackgroundColorExpression(HEADER_BACKGROUND_COLOR_EXPRESSION_EDEFAULT);
			return;
		case EefPackage.EEF_COLUMN_STYLE__HEADER_FOREGROUND_COLOR_EXPRESSION:
			setHeaderForegroundColorExpression(HEADER_FOREGROUND_COLOR_EXPRESSION_EDEFAULT);
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
		case EefPackage.EEF_COLUMN_STYLE__BACKGROUND_COLOR_EXPRESSION:
			return BACKGROUND_COLOR_EXPRESSION_EDEFAULT == null ? backgroundColorExpression != null
					: !BACKGROUND_COLOR_EXPRESSION_EDEFAULT.equals(backgroundColorExpression);
		case EefPackage.EEF_COLUMN_STYLE__FOREGROUND_COLOR_EXPRESSION:
			return FOREGROUND_COLOR_EXPRESSION_EDEFAULT == null ? foregroundColorExpression != null
					: !FOREGROUND_COLOR_EXPRESSION_EDEFAULT.equals(foregroundColorExpression);
		case EefPackage.EEF_COLUMN_STYLE__HEADER_BACKGROUND_COLOR_EXPRESSION:
			return HEADER_BACKGROUND_COLOR_EXPRESSION_EDEFAULT == null ? headerBackgroundColorExpression != null
					: !HEADER_BACKGROUND_COLOR_EXPRESSION_EDEFAULT.equals(headerBackgroundColorExpression);
		case EefPackage.EEF_COLUMN_STYLE__HEADER_FOREGROUND_COLOR_EXPRESSION:
			return HEADER_FOREGROUND_COLOR_EXPRESSION_EDEFAULT == null ? headerForegroundColorExpression != null
					: !HEADER_FOREGROUND_COLOR_EXPRESSION_EDEFAULT.equals(headerForegroundColorExpression);
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
		result.append(" (backgroundColorExpression: "); //$NON-NLS-1$
		result.append(backgroundColorExpression);
		result.append(", foregroundColorExpression: "); //$NON-NLS-1$
		result.append(foregroundColorExpression);
		result.append(", headerBackgroundColorExpression: "); //$NON-NLS-1$
		result.append(headerBackgroundColorExpression);
		result.append(", headerForegroundColorExpression: "); //$NON-NLS-1$
		result.append(headerForegroundColorExpression);
		result.append(')');
		return result.toString();
	}

} //EEFColumnStyleImpl

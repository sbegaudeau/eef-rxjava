/**
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.htm
 * Contributors: Obeo - initial API and implementation
 */
package org.eclipse.eef.impl;

import org.eclipse.eef.EEFTableStyle;
import org.eclipse.eef.EEFTableStyleCustomization;
import org.eclipse.eef.EefPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EEF Table Style Customization</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.eef.impl.EEFTableStyleCustomizationImpl#getStyle <em>Style</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EEFTableStyleCustomizationImpl extends EEFStyleCustomizationImpl implements EEFTableStyleCustomization {
	/**
	 * The cached value of the '{@link #getStyle() <em>Style</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected EEFTableStyle style;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EEFTableStyleCustomizationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefPackage.Literals.EEF_TABLE_STYLE_CUSTOMIZATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEFTableStyle getStyle() {
		if (style != null && style.eIsProxy()) {
			InternalEObject oldStyle = (InternalEObject) style;
			style = (EEFTableStyle) eResolveProxy(oldStyle);
			if (style != oldStyle) {
				InternalEObject newStyle = (InternalEObject) style;
				NotificationChain msgs = oldStyle.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE, null,
						null);
				if (newStyle.eInternalContainer() == null) {
					msgs = newStyle.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE, oldStyle, style));
			}
		}
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEFTableStyle basicGetStyle() {
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStyle(EEFTableStyle newStyle, NotificationChain msgs) {
		EEFTableStyle oldStyle = style;
		style = newStyle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE, oldStyle,
					newStyle);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStyle(EEFTableStyle newStyle) {
		if (newStyle != style) {
			NotificationChain msgs = null;
			if (style != null)
				msgs = ((InternalEObject) style).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE, null,
						msgs);
			if (newStyle != null)
				msgs = ((InternalEObject) newStyle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE, null,
						msgs);
			msgs = basicSetStyle(newStyle, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE, newStyle, newStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE:
			return basicSetStyle(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE:
			if (resolve)
				return getStyle();
			return basicGetStyle();
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
		case EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE:
			setStyle((EEFTableStyle) newValue);
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
		case EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE:
			setStyle((EEFTableStyle) null);
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
		case EefPackage.EEF_TABLE_STYLE_CUSTOMIZATION__STYLE:
			return style != null;
		}
		return super.eIsSet(featureID);
	}

} //EEFTableStyleCustomizationImpl
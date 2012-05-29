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
package org.eclipse.emf.eef.modelingBot.EEFActions.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage;
import org.eclipse.emf.eef.modelingBot.EEFActions.SetAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.SetAttributeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.SetAttributeImpl#getEContainingFeature <em>EContaining Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetAttributeImpl extends EditActionImpl implements SetAttribute {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEContainingFeature() <em>EContaining Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEContainingFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature eContainingFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetAttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EEFActionsPackage.Literals.SET_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.SET_ATTRIBUTE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getEContainingFeature() {
		if (eContainingFeature != null && eContainingFeature.eIsProxy()) {
			InternalEObject oldEContainingFeature = (InternalEObject)eContainingFeature;
			eContainingFeature = (EStructuralFeature)eResolveProxy(oldEContainingFeature);
			if (eContainingFeature != oldEContainingFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE, oldEContainingFeature, eContainingFeature));
			}
		}
		return eContainingFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetEContainingFeature() {
		return eContainingFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEContainingFeature(EStructuralFeature newEContainingFeature) {
		EStructuralFeature oldEContainingFeature = eContainingFeature;
		eContainingFeature = newEContainingFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE, oldEContainingFeature, eContainingFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EEFActionsPackage.SET_ATTRIBUTE__VALUE:
				return getValue();
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE:
				if (resolve) return getEContainingFeature();
				return basicGetEContainingFeature();
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
			case EEFActionsPackage.SET_ATTRIBUTE__VALUE:
				setValue((String)newValue);
				return;
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE:
				setEContainingFeature((EStructuralFeature)newValue);
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
			case EEFActionsPackage.SET_ATTRIBUTE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE:
				setEContainingFeature((EStructuralFeature)null);
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
			case EEFActionsPackage.SET_ATTRIBUTE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE:
				return eContainingFeature != null;
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
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //SetAttributeImpl

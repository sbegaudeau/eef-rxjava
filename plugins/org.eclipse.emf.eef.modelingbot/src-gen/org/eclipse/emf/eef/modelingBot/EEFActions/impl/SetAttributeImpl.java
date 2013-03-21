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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage;
import org.eclipse.emf.eef.modelingBot.EEFActions.SetAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.SetAttributeImpl#getValues <em>Values</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.SetAttributeImpl#getEContainingFeature <em>EContaining Feature</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.SetAttributeImpl#getEContainingFeatureURI <em>EContaining Feature URI</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.SetAttributeImpl#getComputedEContainingFeature <em>Computed EContaining Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetAttributeImpl extends EditActionImpl implements SetAttribute {
	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<String> values;

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
	 * The default value of the '{@link #getEContainingFeatureURI() <em>EContaining Feature URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEContainingFeatureURI()
	 * @generated
	 * @ordered
	 */
	protected static final String ECONTAINING_FEATURE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEContainingFeatureURI() <em>EContaining Feature URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEContainingFeatureURI()
	 * @generated
	 * @ordered
	 */
	protected String eContainingFeatureURI = ECONTAINING_FEATURE_URI_EDEFAULT;

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
	public EList<String> getValues() {
		if (values == null) {
			values = new EDataTypeUniqueEList<String>(String.class, this, EEFActionsPackage.SET_ATTRIBUTE__VALUES);
		}
		return values;
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
	public String getEContainingFeatureURI() {
		return eContainingFeatureURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEContainingFeatureURI(String newEContainingFeatureURI) {
		String oldEContainingFeatureURI = eContainingFeatureURI;
		eContainingFeatureURI = newEContainingFeatureURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE_URI, oldEContainingFeatureURI, eContainingFeatureURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getComputedEContainingFeature() {
		EStructuralFeature computedEContainingFeature = basicGetComputedEContainingFeature();
		return computedEContainingFeature != null && computedEContainingFeature.eIsProxy() ? (EStructuralFeature)eResolveProxy((InternalEObject)computedEContainingFeature) : computedEContainingFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetComputedEContainingFeature() {
		// TODO: implement this method to return the 'Computed EContaining Feature' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EEFActionsPackage.SET_ATTRIBUTE__VALUES:
				return getValues();
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE:
				if (resolve) return getEContainingFeature();
				return basicGetEContainingFeature();
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE_URI:
				return getEContainingFeatureURI();
			case EEFActionsPackage.SET_ATTRIBUTE__COMPUTED_ECONTAINING_FEATURE:
				if (resolve) return getComputedEContainingFeature();
				return basicGetComputedEContainingFeature();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EEFActionsPackage.SET_ATTRIBUTE__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends String>)newValue);
				return;
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE:
				setEContainingFeature((EStructuralFeature)newValue);
				return;
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE_URI:
				setEContainingFeatureURI((String)newValue);
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
			case EEFActionsPackage.SET_ATTRIBUTE__VALUES:
				getValues().clear();
				return;
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE:
				setEContainingFeature((EStructuralFeature)null);
				return;
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE_URI:
				setEContainingFeatureURI(ECONTAINING_FEATURE_URI_EDEFAULT);
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
			case EEFActionsPackage.SET_ATTRIBUTE__VALUES:
				return values != null && !values.isEmpty();
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE:
				return eContainingFeature != null;
			case EEFActionsPackage.SET_ATTRIBUTE__ECONTAINING_FEATURE_URI:
				return ECONTAINING_FEATURE_URI_EDEFAULT == null ? eContainingFeatureURI != null : !ECONTAINING_FEATURE_URI_EDEFAULT.equals(eContainingFeatureURI);
			case EEFActionsPackage.SET_ATTRIBUTE__COMPUTED_ECONTAINING_FEATURE:
				return basicGetComputedEContainingFeature() != null;
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
		result.append(" (values: ");
		result.append(values);
		result.append(", eContainingFeatureURI: ");
		result.append(eContainingFeatureURI);
		result.append(')');
		return result.toString();
	}

} //SetAttributeImpl

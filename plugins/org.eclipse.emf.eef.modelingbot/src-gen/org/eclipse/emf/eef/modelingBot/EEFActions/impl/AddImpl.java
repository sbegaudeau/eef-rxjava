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
import org.eclipse.emf.eef.modelingBot.EEFActions.Add;
import org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage;
import org.eclipse.emf.eef.modelingBot.helper.EMFHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.AddImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.AddImpl#getTypeURI <em>Type URI</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.AddImpl#getComputedType <em>Computed Type</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.AddImpl#getEContainingFeature <em>EContaining Feature</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.AddImpl#getEContainingFeatureURI <em>EContaining Feature URI</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.AddImpl#getComputedEContainingFeature <em>Computed EContaining Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddImpl extends EditActionImpl implements Add {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClass type;

	/**
	 * The default value of the '{@link #getTypeURI() <em>Type URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeURI()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeURI() <em>Type URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeURI()
	 * @generated
	 * @ordered
	 */
	protected String typeURI = TYPE_URI_EDEFAULT;

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
	protected AddImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EEFActionsPackage.Literals.ADD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EClass)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EEFActionsPackage.ADD__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EClass newType) {
		EClass oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.ADD__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeURI() {
		return typeURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeURI(String newTypeURI) {
		String oldTypeURI = typeURI;
		typeURI = newTypeURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.ADD__TYPE_URI, oldTypeURI, typeURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputedType() {
		EClass computedType = basicGetComputedType();
		return computedType != null && computedType.eIsProxy() ? (EClass)eResolveProxy((InternalEObject)computedType) : computedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClass basicGetComputedType() {
		return EMFHelper.computeEObject(this, EEFActionsPackage.Literals.ADD__TYPE, EEFActionsPackage.Literals.ADD__TYPE_URI);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EEFActionsPackage.ADD__ECONTAINING_FEATURE, oldEContainingFeature, eContainingFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.ADD__ECONTAINING_FEATURE, oldEContainingFeature, eContainingFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.ADD__ECONTAINING_FEATURE_URI, oldEContainingFeatureURI, eContainingFeatureURI));
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
	 * @generated NOT
	 */
	public EStructuralFeature basicGetComputedEContainingFeature() {
		return EMFHelper.computeEObject(this, EEFActionsPackage.Literals.ADD__ECONTAINING_FEATURE, EEFActionsPackage.Literals.ADD__ECONTAINING_FEATURE_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EEFActionsPackage.ADD__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case EEFActionsPackage.ADD__TYPE_URI:
				return getTypeURI();
			case EEFActionsPackage.ADD__COMPUTED_TYPE:
				if (resolve) return getComputedType();
				return basicGetComputedType();
			case EEFActionsPackage.ADD__ECONTAINING_FEATURE:
				if (resolve) return getEContainingFeature();
				return basicGetEContainingFeature();
			case EEFActionsPackage.ADD__ECONTAINING_FEATURE_URI:
				return getEContainingFeatureURI();
			case EEFActionsPackage.ADD__COMPUTED_ECONTAINING_FEATURE:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EEFActionsPackage.ADD__TYPE:
				setType((EClass)newValue);
				return;
			case EEFActionsPackage.ADD__TYPE_URI:
				setTypeURI((String)newValue);
				return;
			case EEFActionsPackage.ADD__ECONTAINING_FEATURE:
				setEContainingFeature((EStructuralFeature)newValue);
				return;
			case EEFActionsPackage.ADD__ECONTAINING_FEATURE_URI:
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
			case EEFActionsPackage.ADD__TYPE:
				setType((EClass)null);
				return;
			case EEFActionsPackage.ADD__TYPE_URI:
				setTypeURI(TYPE_URI_EDEFAULT);
				return;
			case EEFActionsPackage.ADD__ECONTAINING_FEATURE:
				setEContainingFeature((EStructuralFeature)null);
				return;
			case EEFActionsPackage.ADD__ECONTAINING_FEATURE_URI:
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
			case EEFActionsPackage.ADD__TYPE:
				return type != null;
			case EEFActionsPackage.ADD__TYPE_URI:
				return TYPE_URI_EDEFAULT == null ? typeURI != null : !TYPE_URI_EDEFAULT.equals(typeURI);
			case EEFActionsPackage.ADD__COMPUTED_TYPE:
				return basicGetComputedType() != null;
			case EEFActionsPackage.ADD__ECONTAINING_FEATURE:
				return eContainingFeature != null;
			case EEFActionsPackage.ADD__ECONTAINING_FEATURE_URI:
				return ECONTAINING_FEATURE_URI_EDEFAULT == null ? eContainingFeatureURI != null : !ECONTAINING_FEATURE_URI_EDEFAULT.equals(eContainingFeatureURI);
			case EEFActionsPackage.ADD__COMPUTED_ECONTAINING_FEATURE:
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
		result.append(" (typeURI: ");
		result.append(typeURI);
		result.append(", eContainingFeatureURI: ");
		result.append(eContainingFeatureURI);
		result.append(')');
		return result.toString();
	}

} //AddImpl

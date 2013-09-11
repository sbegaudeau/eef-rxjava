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
package org.eclipse.emf.eef.modelingBot.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.eef.extended.editor.ReferenceableObject;
import org.eclipse.emf.eef.modelingBot.ModelingBotPackage;
import org.eclipse.emf.eef.modelingBot.Wizard;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wizard</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.impl.WizardImpl#getReferenceableObject <em>Referenceable Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WizardImpl extends SequenceImpl implements Wizard {
	/**
	 * The cached value of the '{@link #getReferenceableObject() <em>Referenceable Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceableObject()
	 * @generated
	 * @ordered
	 */
	protected ReferenceableObject referenceableObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WizardImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelingBotPackage.Literals.WIZARD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceableObject getReferenceableObject() {
		if (referenceableObject != null && referenceableObject.eIsProxy()) {
			InternalEObject oldReferenceableObject = (InternalEObject)referenceableObject;
			referenceableObject = (ReferenceableObject)eResolveProxy(oldReferenceableObject);
			if (referenceableObject != oldReferenceableObject) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelingBotPackage.WIZARD__REFERENCEABLE_OBJECT, oldReferenceableObject, referenceableObject));
			}
		}
		return referenceableObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceableObject basicGetReferenceableObject() {
		return referenceableObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferenceableObject(ReferenceableObject newReferenceableObject) {
		ReferenceableObject oldReferenceableObject = referenceableObject;
		referenceableObject = newReferenceableObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelingBotPackage.WIZARD__REFERENCEABLE_OBJECT, oldReferenceableObject, referenceableObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelingBotPackage.WIZARD__REFERENCEABLE_OBJECT:
				if (resolve) return getReferenceableObject();
				return basicGetReferenceableObject();
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
			case ModelingBotPackage.WIZARD__REFERENCEABLE_OBJECT:
				setReferenceableObject((ReferenceableObject)newValue);
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
			case ModelingBotPackage.WIZARD__REFERENCEABLE_OBJECT:
				setReferenceableObject((ReferenceableObject)null);
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
			case ModelingBotPackage.WIZARD__REFERENCEABLE_OBJECT:
				return referenceableObject != null;
		}
		return super.eIsSet(featureID);
	}

} //WizardImpl

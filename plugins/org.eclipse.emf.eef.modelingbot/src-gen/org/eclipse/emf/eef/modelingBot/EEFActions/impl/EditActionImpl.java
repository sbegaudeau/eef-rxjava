/**
 * <copyright>
 * </copyright>
 *
 * $Id: EditActionImpl.java,v 1.1 2011/04/06 13:07:28 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot.EEFActions.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.eef.components.PropertiesEditionElement;

import org.eclipse.emf.eef.extended.editor.ReferenceableObject;

import org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage;
import org.eclipse.emf.eef.modelingBot.EEFActions.EditAction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edit Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.EditActionImpl#getPropertiesEditionElement <em>Properties Edition Element</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.EditActionImpl#getReferenceableObject <em>Referenceable Object</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.EditActionImpl#getEContainingFeature <em>EContaining Feature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class EditActionImpl extends EEFActionImpl implements EditAction {
	/**
	 * The cached value of the '{@link #getPropertiesEditionElement() <em>Properties Edition Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertiesEditionElement()
	 * @generated
	 * @ordered
	 */
	protected PropertiesEditionElement propertiesEditionElement;

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
	protected EditActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EEFActionsPackage.Literals.EDIT_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesEditionElement getPropertiesEditionElement() {
		if (propertiesEditionElement != null && propertiesEditionElement.eIsProxy()) {
			InternalEObject oldPropertiesEditionElement = (InternalEObject)propertiesEditionElement;
			propertiesEditionElement = (PropertiesEditionElement)eResolveProxy(oldPropertiesEditionElement);
			if (propertiesEditionElement != oldPropertiesEditionElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EEFActionsPackage.EDIT_ACTION__PROPERTIES_EDITION_ELEMENT, oldPropertiesEditionElement, propertiesEditionElement));
			}
		}
		return propertiesEditionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesEditionElement basicGetPropertiesEditionElement() {
		return propertiesEditionElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertiesEditionElement(PropertiesEditionElement newPropertiesEditionElement) {
		PropertiesEditionElement oldPropertiesEditionElement = propertiesEditionElement;
		propertiesEditionElement = newPropertiesEditionElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.EDIT_ACTION__PROPERTIES_EDITION_ELEMENT, oldPropertiesEditionElement, propertiesEditionElement));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EEFActionsPackage.EDIT_ACTION__REFERENCEABLE_OBJECT, oldReferenceableObject, referenceableObject));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.EDIT_ACTION__REFERENCEABLE_OBJECT, oldReferenceableObject, referenceableObject));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EEFActionsPackage.EDIT_ACTION__ECONTAINING_FEATURE, oldEContainingFeature, eContainingFeature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.EDIT_ACTION__ECONTAINING_FEATURE, oldEContainingFeature, eContainingFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EEFActionsPackage.EDIT_ACTION__PROPERTIES_EDITION_ELEMENT:
				if (resolve) return getPropertiesEditionElement();
				return basicGetPropertiesEditionElement();
			case EEFActionsPackage.EDIT_ACTION__REFERENCEABLE_OBJECT:
				if (resolve) return getReferenceableObject();
				return basicGetReferenceableObject();
			case EEFActionsPackage.EDIT_ACTION__ECONTAINING_FEATURE:
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
			case EEFActionsPackage.EDIT_ACTION__PROPERTIES_EDITION_ELEMENT:
				setPropertiesEditionElement((PropertiesEditionElement)newValue);
				return;
			case EEFActionsPackage.EDIT_ACTION__REFERENCEABLE_OBJECT:
				setReferenceableObject((ReferenceableObject)newValue);
				return;
			case EEFActionsPackage.EDIT_ACTION__ECONTAINING_FEATURE:
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
			case EEFActionsPackage.EDIT_ACTION__PROPERTIES_EDITION_ELEMENT:
				setPropertiesEditionElement((PropertiesEditionElement)null);
				return;
			case EEFActionsPackage.EDIT_ACTION__REFERENCEABLE_OBJECT:
				setReferenceableObject((ReferenceableObject)null);
				return;
			case EEFActionsPackage.EDIT_ACTION__ECONTAINING_FEATURE:
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
			case EEFActionsPackage.EDIT_ACTION__PROPERTIES_EDITION_ELEMENT:
				return propertiesEditionElement != null;
			case EEFActionsPackage.EDIT_ACTION__REFERENCEABLE_OBJECT:
				return referenceableObject != null;
			case EEFActionsPackage.EDIT_ACTION__ECONTAINING_FEATURE:
				return eContainingFeature != null;
		}
		return super.eIsSet(featureID);
	}

} //EditActionImpl

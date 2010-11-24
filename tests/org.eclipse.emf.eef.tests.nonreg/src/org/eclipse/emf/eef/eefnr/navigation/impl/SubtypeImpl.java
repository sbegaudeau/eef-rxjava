/**
 * <copyright>
 * </copyright>
 *
 * $Id: SubtypeImpl.java,v 1.1 2010/11/24 21:50:53 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.navigation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;
import org.eclipse.emf.eef.eefnr.navigation.Subtype;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subtype</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.SubtypeImpl#isSpecialisedElement <em>Specialised Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubtypeImpl extends OwnerImpl implements Subtype {
	/**
	 * The default value of the '{@link #isSpecialisedElement() <em>Specialised Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpecialisedElement()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SPECIALISED_ELEMENT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSpecialisedElement() <em>Specialised Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSpecialisedElement()
	 * @generated
	 * @ordered
	 */
	protected boolean specialisedElement = SPECIALISED_ELEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubtypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NavigationPackage.Literals.SUBTYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSpecialisedElement() {
		return specialisedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSpecialisedElement(boolean newSpecialisedElement) {
		boolean oldSpecialisedElement = specialisedElement;
		specialisedElement = newSpecialisedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.SUBTYPE__SPECIALISED_ELEMENT, oldSpecialisedElement, specialisedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NavigationPackage.SUBTYPE__SPECIALISED_ELEMENT:
				return isSpecialisedElement();
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
			case NavigationPackage.SUBTYPE__SPECIALISED_ELEMENT:
				setSpecialisedElement((Boolean)newValue);
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
			case NavigationPackage.SUBTYPE__SPECIALISED_ELEMENT:
				setSpecialisedElement(SPECIALISED_ELEMENT_EDEFAULT);
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
			case NavigationPackage.SUBTYPE__SPECIALISED_ELEMENT:
				return specialisedElement != SPECIALISED_ELEMENT_EDEFAULT;
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
		result.append(" (specialisedElement: ");
		result.append(specialisedElement);
		result.append(')');
		return result.toString();
	}

} //SubtypeImpl

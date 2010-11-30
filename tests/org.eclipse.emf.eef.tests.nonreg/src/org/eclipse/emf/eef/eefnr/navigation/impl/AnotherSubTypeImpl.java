/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnotherSubTypeImpl.java,v 1.1 2010/11/30 08:23:18 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.navigation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.eef.eefnr.navigation.AnotherSubType;
import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Another Sub Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.AnotherSubTypeImpl#isAnotherSpecialisation <em>Another Specialisation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnotherSubTypeImpl extends SubtypeImpl implements AnotherSubType {
	/**
	 * The default value of the '{@link #isAnotherSpecialisation() <em>Another Specialisation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnotherSpecialisation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANOTHER_SPECIALISATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAnotherSpecialisation() <em>Another Specialisation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnotherSpecialisation()
	 * @generated
	 * @ordered
	 */
	protected boolean anotherSpecialisation = ANOTHER_SPECIALISATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnotherSubTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NavigationPackage.Literals.ANOTHER_SUB_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAnotherSpecialisation() {
		return anotherSpecialisation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnotherSpecialisation(boolean newAnotherSpecialisation) {
		boolean oldAnotherSpecialisation = anotherSpecialisation;
		anotherSpecialisation = newAnotherSpecialisation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.ANOTHER_SUB_TYPE__ANOTHER_SPECIALISATION, oldAnotherSpecialisation, anotherSpecialisation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NavigationPackage.ANOTHER_SUB_TYPE__ANOTHER_SPECIALISATION:
				return isAnotherSpecialisation();
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
			case NavigationPackage.ANOTHER_SUB_TYPE__ANOTHER_SPECIALISATION:
				setAnotherSpecialisation((Boolean)newValue);
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
			case NavigationPackage.ANOTHER_SUB_TYPE__ANOTHER_SPECIALISATION:
				setAnotherSpecialisation(ANOTHER_SPECIALISATION_EDEFAULT);
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
			case NavigationPackage.ANOTHER_SUB_TYPE__ANOTHER_SPECIALISATION:
				return anotherSpecialisation != ANOTHER_SPECIALISATION_EDEFAULT;
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
		result.append(" (anotherSpecialisation: ");
		result.append(anotherSpecialisation);
		result.append(')');
		return result.toString();
	}

} //AnotherSubTypeImpl

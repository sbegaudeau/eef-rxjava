/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.eefnr.navigation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.eef.eefnr.impl.NamedElementImpl;

import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;
import org.eclipse.emf.eef.eefnr.navigation.SecondModelNavigation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Second Model Navigation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.SecondModelNavigationImpl#isFilter3 <em>Filter3</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.SecondModelNavigationImpl#isFilter4 <em>Filter4</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SecondModelNavigationImpl extends NamedElementImpl implements SecondModelNavigation {
	/**
	 * The default value of the '{@link #isFilter3() <em>Filter3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilter3()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILTER3_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isFilter3() <em>Filter3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilter3()
	 * @generated
	 * @ordered
	 */
	protected boolean filter3 = FILTER3_EDEFAULT;
	/**
	 * The default value of the '{@link #isFilter4() <em>Filter4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilter4()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILTER4_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isFilter4() <em>Filter4</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilter4()
	 * @generated
	 * @ordered
	 */
	protected boolean filter4 = FILTER4_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SecondModelNavigationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NavigationPackage.Literals.SECOND_MODEL_NAVIGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFilter3() {
		return filter3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter3(boolean newFilter3) {
		boolean oldFilter3 = filter3;
		filter3 = newFilter3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.SECOND_MODEL_NAVIGATION__FILTER3, oldFilter3, filter3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFilter4() {
		return filter4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter4(boolean newFilter4) {
		boolean oldFilter4 = filter4;
		filter4 = newFilter4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.SECOND_MODEL_NAVIGATION__FILTER4, oldFilter4, filter4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NavigationPackage.SECOND_MODEL_NAVIGATION__FILTER3:
				return isFilter3();
			case NavigationPackage.SECOND_MODEL_NAVIGATION__FILTER4:
				return isFilter4();
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
			case NavigationPackage.SECOND_MODEL_NAVIGATION__FILTER3:
				setFilter3((Boolean)newValue);
				return;
			case NavigationPackage.SECOND_MODEL_NAVIGATION__FILTER4:
				setFilter4((Boolean)newValue);
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
			case NavigationPackage.SECOND_MODEL_NAVIGATION__FILTER3:
				setFilter3(FILTER3_EDEFAULT);
				return;
			case NavigationPackage.SECOND_MODEL_NAVIGATION__FILTER4:
				setFilter4(FILTER4_EDEFAULT);
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
			case NavigationPackage.SECOND_MODEL_NAVIGATION__FILTER3:
				return filter3 != FILTER3_EDEFAULT;
			case NavigationPackage.SECOND_MODEL_NAVIGATION__FILTER4:
				return filter4 != FILTER4_EDEFAULT;
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
		result.append(" (filter3: ");
		result.append(filter3);
		result.append(", filter4: ");
		result.append(filter4);
		result.append(')');
		return result.toString();
	}

} //SecondModelNavigationImpl

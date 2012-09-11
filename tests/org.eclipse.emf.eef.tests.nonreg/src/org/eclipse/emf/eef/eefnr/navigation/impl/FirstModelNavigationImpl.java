/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.eefnr.navigation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.eef.eefnr.impl.NamedElementImpl;

import org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation;
import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;
import org.eclipse.emf.eef.eefnr.navigation.SecondModelNavigation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>First Model Navigation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.FirstModelNavigationImpl#getSecondModelNavigation <em>Second Model Navigation</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.FirstModelNavigationImpl#getSeveralSecondModelNavigation <em>Several Second Model Navigation</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.FirstModelNavigationImpl#isFilter1 <em>Filter1</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.FirstModelNavigationImpl#isFilter2 <em>Filter2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FirstModelNavigationImpl extends NamedElementImpl implements FirstModelNavigation {
	/**
	 * The cached value of the '{@link #getSecondModelNavigation() <em>Second Model Navigation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondModelNavigation()
	 * @generated
	 * @ordered
	 */
	protected SecondModelNavigation secondModelNavigation;

	/**
	 * The cached value of the '{@link #getSeveralSecondModelNavigation() <em>Several Second Model Navigation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeveralSecondModelNavigation()
	 * @generated
	 * @ordered
	 */
	protected EList<SecondModelNavigation> severalSecondModelNavigation;

	/**
	 * The default value of the '{@link #isFilter1() <em>Filter1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilter1()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILTER1_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFilter1() <em>Filter1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilter1()
	 * @generated
	 * @ordered
	 */
	protected boolean filter1 = FILTER1_EDEFAULT;

	/**
	 * The default value of the '{@link #isFilter2() <em>Filter2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilter2()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILTER2_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFilter2() <em>Filter2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilter2()
	 * @generated
	 * @ordered
	 */
	protected boolean filter2 = FILTER2_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FirstModelNavigationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NavigationPackage.Literals.FIRST_MODEL_NAVIGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SecondModelNavigation getSecondModelNavigation() {
		return secondModelNavigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondModelNavigation(SecondModelNavigation newSecondModelNavigation, NotificationChain msgs) {
		SecondModelNavigation oldSecondModelNavigation = secondModelNavigation;
		secondModelNavigation = newSecondModelNavigation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NavigationPackage.FIRST_MODEL_NAVIGATION__SECOND_MODEL_NAVIGATION, oldSecondModelNavigation, newSecondModelNavigation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondModelNavigation(SecondModelNavigation newSecondModelNavigation) {
		if (newSecondModelNavigation != secondModelNavigation) {
			NotificationChain msgs = null;
			if (secondModelNavigation != null)
				msgs = ((InternalEObject)secondModelNavigation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.FIRST_MODEL_NAVIGATION__SECOND_MODEL_NAVIGATION, null, msgs);
			if (newSecondModelNavigation != null)
				msgs = ((InternalEObject)newSecondModelNavigation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.FIRST_MODEL_NAVIGATION__SECOND_MODEL_NAVIGATION, null, msgs);
			msgs = basicSetSecondModelNavigation(newSecondModelNavigation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.FIRST_MODEL_NAVIGATION__SECOND_MODEL_NAVIGATION, newSecondModelNavigation, newSecondModelNavigation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SecondModelNavigation> getSeveralSecondModelNavigation() {
		if (severalSecondModelNavigation == null) {
			severalSecondModelNavigation = new EObjectContainmentEList<SecondModelNavigation>(SecondModelNavigation.class, this, NavigationPackage.FIRST_MODEL_NAVIGATION__SEVERAL_SECOND_MODEL_NAVIGATION);
		}
		return severalSecondModelNavigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFilter1() {
		return filter1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter1(boolean newFilter1) {
		boolean oldFilter1 = filter1;
		filter1 = newFilter1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.FIRST_MODEL_NAVIGATION__FILTER1, oldFilter1, filter1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFilter2() {
		return filter2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter2(boolean newFilter2) {
		boolean oldFilter2 = filter2;
		filter2 = newFilter2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.FIRST_MODEL_NAVIGATION__FILTER2, oldFilter2, filter2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NavigationPackage.FIRST_MODEL_NAVIGATION__SECOND_MODEL_NAVIGATION:
				return basicSetSecondModelNavigation(null, msgs);
			case NavigationPackage.FIRST_MODEL_NAVIGATION__SEVERAL_SECOND_MODEL_NAVIGATION:
				return ((InternalEList<?>)getSeveralSecondModelNavigation()).basicRemove(otherEnd, msgs);
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
			case NavigationPackage.FIRST_MODEL_NAVIGATION__SECOND_MODEL_NAVIGATION:
				return getSecondModelNavigation();
			case NavigationPackage.FIRST_MODEL_NAVIGATION__SEVERAL_SECOND_MODEL_NAVIGATION:
				return getSeveralSecondModelNavigation();
			case NavigationPackage.FIRST_MODEL_NAVIGATION__FILTER1:
				return isFilter1();
			case NavigationPackage.FIRST_MODEL_NAVIGATION__FILTER2:
				return isFilter2();
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
			case NavigationPackage.FIRST_MODEL_NAVIGATION__SECOND_MODEL_NAVIGATION:
				setSecondModelNavigation((SecondModelNavigation)newValue);
				return;
			case NavigationPackage.FIRST_MODEL_NAVIGATION__SEVERAL_SECOND_MODEL_NAVIGATION:
				getSeveralSecondModelNavigation().clear();
				getSeveralSecondModelNavigation().addAll((Collection<? extends SecondModelNavigation>)newValue);
				return;
			case NavigationPackage.FIRST_MODEL_NAVIGATION__FILTER1:
				setFilter1((Boolean)newValue);
				return;
			case NavigationPackage.FIRST_MODEL_NAVIGATION__FILTER2:
				setFilter2((Boolean)newValue);
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
			case NavigationPackage.FIRST_MODEL_NAVIGATION__SECOND_MODEL_NAVIGATION:
				setSecondModelNavigation((SecondModelNavigation)null);
				return;
			case NavigationPackage.FIRST_MODEL_NAVIGATION__SEVERAL_SECOND_MODEL_NAVIGATION:
				getSeveralSecondModelNavigation().clear();
				return;
			case NavigationPackage.FIRST_MODEL_NAVIGATION__FILTER1:
				setFilter1(FILTER1_EDEFAULT);
				return;
			case NavigationPackage.FIRST_MODEL_NAVIGATION__FILTER2:
				setFilter2(FILTER2_EDEFAULT);
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
			case NavigationPackage.FIRST_MODEL_NAVIGATION__SECOND_MODEL_NAVIGATION:
				return secondModelNavigation != null;
			case NavigationPackage.FIRST_MODEL_NAVIGATION__SEVERAL_SECOND_MODEL_NAVIGATION:
				return severalSecondModelNavigation != null && !severalSecondModelNavigation.isEmpty();
			case NavigationPackage.FIRST_MODEL_NAVIGATION__FILTER1:
				return filter1 != FILTER1_EDEFAULT;
			case NavigationPackage.FIRST_MODEL_NAVIGATION__FILTER2:
				return filter2 != FILTER2_EDEFAULT;
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
		result.append(" (filter1: ");
		result.append(filter1);
		result.append(", filter2: ");
		result.append(filter2);
		result.append(')');
		return result.toString();
	}

} //FirstModelNavigationImpl

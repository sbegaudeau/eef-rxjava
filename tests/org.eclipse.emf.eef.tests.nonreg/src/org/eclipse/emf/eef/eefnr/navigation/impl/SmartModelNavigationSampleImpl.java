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
import org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Smart Model Navigation Sample</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.SmartModelNavigationSampleImpl#getFirstModelNavigation <em>First Model Navigation</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.SmartModelNavigationSampleImpl#getSeveralFirstModelNavigation <em>Several First Model Navigation</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.SmartModelNavigationSampleImpl#getFirstModelNavigation2 <em>First Model Navigation2</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.SmartModelNavigationSampleImpl#getSeveralFirstModelNavigation2 <em>Several First Model Navigation2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SmartModelNavigationSampleImpl extends NamedElementImpl implements SmartModelNavigationSample {
	/**
	 * The cached value of the '{@link #getFirstModelNavigation() <em>First Model Navigation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstModelNavigation()
	 * @generated
	 * @ordered
	 */
	protected FirstModelNavigation firstModelNavigation;

	/**
	 * The cached value of the '{@link #getSeveralFirstModelNavigation() <em>Several First Model Navigation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeveralFirstModelNavigation()
	 * @generated
	 * @ordered
	 */
	protected EList<FirstModelNavigation> severalFirstModelNavigation;

	/**
	 * The cached value of the '{@link #getFirstModelNavigation2() <em>First Model Navigation2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstModelNavigation2()
	 * @generated
	 * @ordered
	 */
	protected FirstModelNavigation firstModelNavigation2;

	/**
	 * The cached value of the '{@link #getSeveralFirstModelNavigation2() <em>Several First Model Navigation2</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeveralFirstModelNavigation2()
	 * @generated
	 * @ordered
	 */
	protected EList<FirstModelNavigation> severalFirstModelNavigation2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SmartModelNavigationSampleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NavigationPackage.Literals.SMART_MODEL_NAVIGATION_SAMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FirstModelNavigation getFirstModelNavigation() {
		return firstModelNavigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstModelNavigation(FirstModelNavigation newFirstModelNavigation, NotificationChain msgs) {
		FirstModelNavigation oldFirstModelNavigation = firstModelNavigation;
		firstModelNavigation = newFirstModelNavigation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION, oldFirstModelNavigation, newFirstModelNavigation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstModelNavigation(FirstModelNavigation newFirstModelNavigation) {
		if (newFirstModelNavigation != firstModelNavigation) {
			NotificationChain msgs = null;
			if (firstModelNavigation != null)
				msgs = ((InternalEObject)firstModelNavigation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION, null, msgs);
			if (newFirstModelNavigation != null)
				msgs = ((InternalEObject)newFirstModelNavigation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION, null, msgs);
			msgs = basicSetFirstModelNavigation(newFirstModelNavigation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION, newFirstModelNavigation, newFirstModelNavigation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FirstModelNavigation> getSeveralFirstModelNavigation() {
		if (severalFirstModelNavigation == null) {
			severalFirstModelNavigation = new EObjectContainmentEList<FirstModelNavigation>(FirstModelNavigation.class, this, NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION);
		}
		return severalFirstModelNavigation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FirstModelNavigation getFirstModelNavigation2() {
		return firstModelNavigation2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstModelNavigation2(FirstModelNavigation newFirstModelNavigation2, NotificationChain msgs) {
		FirstModelNavigation oldFirstModelNavigation2 = firstModelNavigation2;
		firstModelNavigation2 = newFirstModelNavigation2;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2, oldFirstModelNavigation2, newFirstModelNavigation2);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstModelNavigation2(FirstModelNavigation newFirstModelNavigation2) {
		if (newFirstModelNavigation2 != firstModelNavigation2) {
			NotificationChain msgs = null;
			if (firstModelNavigation2 != null)
				msgs = ((InternalEObject)firstModelNavigation2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2, null, msgs);
			if (newFirstModelNavigation2 != null)
				msgs = ((InternalEObject)newFirstModelNavigation2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2, null, msgs);
			msgs = basicSetFirstModelNavigation2(newFirstModelNavigation2, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2, newFirstModelNavigation2, newFirstModelNavigation2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FirstModelNavigation> getSeveralFirstModelNavigation2() {
		if (severalFirstModelNavigation2 == null) {
			severalFirstModelNavigation2 = new EObjectContainmentEList<FirstModelNavigation>(FirstModelNavigation.class, this, NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2);
		}
		return severalFirstModelNavigation2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION:
				return basicSetFirstModelNavigation(null, msgs);
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION:
				return ((InternalEList<?>)getSeveralFirstModelNavigation()).basicRemove(otherEnd, msgs);
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2:
				return basicSetFirstModelNavigation2(null, msgs);
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2:
				return ((InternalEList<?>)getSeveralFirstModelNavigation2()).basicRemove(otherEnd, msgs);
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
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION:
				return getFirstModelNavigation();
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION:
				return getSeveralFirstModelNavigation();
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2:
				return getFirstModelNavigation2();
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2:
				return getSeveralFirstModelNavigation2();
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
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION:
				setFirstModelNavigation((FirstModelNavigation)newValue);
				return;
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION:
				getSeveralFirstModelNavigation().clear();
				getSeveralFirstModelNavigation().addAll((Collection<? extends FirstModelNavigation>)newValue);
				return;
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2:
				setFirstModelNavigation2((FirstModelNavigation)newValue);
				return;
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2:
				getSeveralFirstModelNavigation2().clear();
				getSeveralFirstModelNavigation2().addAll((Collection<? extends FirstModelNavigation>)newValue);
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
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION:
				setFirstModelNavigation((FirstModelNavigation)null);
				return;
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION:
				getSeveralFirstModelNavigation().clear();
				return;
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2:
				setFirstModelNavigation2((FirstModelNavigation)null);
				return;
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2:
				getSeveralFirstModelNavigation2().clear();
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
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION:
				return firstModelNavigation != null;
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION:
				return severalFirstModelNavigation != null && !severalFirstModelNavigation.isEmpty();
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__FIRST_MODEL_NAVIGATION2:
				return firstModelNavigation2 != null;
			case NavigationPackage.SMART_MODEL_NAVIGATION_SAMPLE__SEVERAL_FIRST_MODEL_NAVIGATION2:
				return severalFirstModelNavigation2 != null && !severalFirstModelNavigation2.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SmartModelNavigationSampleImpl

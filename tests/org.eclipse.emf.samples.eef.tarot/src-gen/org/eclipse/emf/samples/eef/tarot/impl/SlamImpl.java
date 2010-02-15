/**
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 * 
 *
 * $Id: SlamImpl.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.samples.eef.tarot.Slam;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Slam</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.SlamImpl#isAnnounced <em>Announced</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.SlamImpl#isAchieved <em>Achieved</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SlamImpl extends BonusImpl implements Slam {
	/**
	 * The default value of the '{@link #isAnnounced() <em>Announced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnnounced()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ANNOUNCED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAnnounced() <em>Announced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAnnounced()
	 * @generated
	 * @ordered
	 */
	protected boolean announced = ANNOUNCED_EDEFAULT;

	/**
	 * The default value of the '{@link #isAchieved() <em>Achieved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAchieved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACHIEVED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAchieved() <em>Achieved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAchieved()
	 * @generated
	 * @ordered
	 */
	protected boolean achieved = ACHIEVED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SlamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TarotPackage.Literals.SLAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAnnounced() {
		return announced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAnnounced(boolean newAnnounced) {
		boolean oldAnnounced = announced;
		announced = newAnnounced;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TarotPackage.SLAM__ANNOUNCED, oldAnnounced, announced));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAchieved() {
		return achieved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAchieved(boolean newAchieved) {
		boolean oldAchieved = achieved;
		achieved = newAchieved;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TarotPackage.SLAM__ACHIEVED, oldAchieved, achieved));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TarotPackage.SLAM__ANNOUNCED:
				return isAnnounced();
			case TarotPackage.SLAM__ACHIEVED:
				return isAchieved();
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
			case TarotPackage.SLAM__ANNOUNCED:
				setAnnounced((Boolean)newValue);
				return;
			case TarotPackage.SLAM__ACHIEVED:
				setAchieved((Boolean)newValue);
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
			case TarotPackage.SLAM__ANNOUNCED:
				setAnnounced(ANNOUNCED_EDEFAULT);
				return;
			case TarotPackage.SLAM__ACHIEVED:
				setAchieved(ACHIEVED_EDEFAULT);
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
			case TarotPackage.SLAM__ANNOUNCED:
				return announced != ANNOUNCED_EDEFAULT;
			case TarotPackage.SLAM__ACHIEVED:
				return achieved != ACHIEVED_EDEFAULT;
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
		result.append(" (announced: ");
		result.append(announced);
		result.append(", achieved: ");
		result.append(achieved);
		result.append(')');
		return result.toString();
	}

} //SlamImpl

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
 * $Id: BonusImpl.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.samples.eef.tarot.Bonus;
import org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bonus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.BonusImpl#getSide <em>Side</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class BonusImpl extends EObjectImpl implements Bonus {
	/**
	 * The default value of the '{@link #getSide() <em>Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSide()
	 * @generated
	 * @ordered
	 */
	protected static final PLAYER_SIDE SIDE_EDEFAULT = PLAYER_SIDE.ATTACK;
	/**
	 * The cached value of the '{@link #getSide() <em>Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSide()
	 * @generated
	 * @ordered
	 */
	protected PLAYER_SIDE side = SIDE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BonusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TarotPackage.Literals.BONUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PLAYER_SIDE getSide() {
		return side;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSide(PLAYER_SIDE newSide) {
		PLAYER_SIDE oldSide = side;
		side = newSide == null ? SIDE_EDEFAULT : newSide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TarotPackage.BONUS__SIDE, oldSide, side));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TarotPackage.BONUS__SIDE:
				return getSide();
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
			case TarotPackage.BONUS__SIDE:
				setSide((PLAYER_SIDE)newValue);
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
			case TarotPackage.BONUS__SIDE:
				setSide(SIDE_EDEFAULT);
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
			case TarotPackage.BONUS__SIDE:
				return side != SIDE_EDEFAULT;
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
		result.append(" (side: ");
		result.append(side);
		result.append(')');
		return result.toString();
	}

} //BonusImpl

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
 * $Id: MisereImpl.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.samples.eef.tarot.Misere;
import org.eclipse.emf.samples.eef.tarot.Player;
import org.eclipse.emf.samples.eef.tarot.TarotPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Misere</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.impl.MisereImpl#getDeclarer <em>Declarer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MisereImpl extends ScoreEntryImpl implements Misere {
	/**
	 * The cached value of the '{@link #getDeclarer() <em>Declarer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclarer()
	 * @generated
	 * @ordered
	 */
	protected Player declarer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MisereImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TarotPackage.Literals.MISERE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player getDeclarer() {
		if (declarer != null && declarer.eIsProxy()) {
			InternalEObject oldDeclarer = (InternalEObject)declarer;
			declarer = (Player)eResolveProxy(oldDeclarer);
			if (declarer != oldDeclarer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TarotPackage.MISERE__DECLARER, oldDeclarer, declarer));
			}
		}
		return declarer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player basicGetDeclarer() {
		return declarer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclarer(Player newDeclarer) {
		Player oldDeclarer = declarer;
		declarer = newDeclarer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TarotPackage.MISERE__DECLARER, oldDeclarer, declarer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TarotPackage.MISERE__DECLARER:
				if (resolve) return getDeclarer();
				return basicGetDeclarer();
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
			case TarotPackage.MISERE__DECLARER:
				setDeclarer((Player)newValue);
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
			case TarotPackage.MISERE__DECLARER:
				setDeclarer((Player)null);
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
			case TarotPackage.MISERE__DECLARER:
				return declarer != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.samples.eef.tarot.impl.ScoreEntryImpl#score(org.eclipse.emf.samples.eef.tarot.Player)
	 */
	public int score(Player player) {
		int score;
		int playersCount = getGame().getPlayers().size();
		if (player.equals(getDeclarer())) 
			score = 10 * (playersCount - 1);
		else
			score = -10;
		return score;
	}
	
	

} //MisereImpl

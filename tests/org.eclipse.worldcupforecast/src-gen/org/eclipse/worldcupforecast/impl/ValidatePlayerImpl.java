/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *       Obeo - initial API and implementation
 */
package org.eclipse.worldcupforecast.impl;

import org.eclipse.worldcupforecast.ForecastDay;
import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.ValidatePlayer;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validate Player</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.ValidatePlayerImpl#getPlayer <em>Player</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.ValidatePlayerImpl#getForecastDays <em>Forecast Days</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValidatePlayerImpl extends EObjectImpl implements ValidatePlayer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getPlayer() <em>Player</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayer()
	 * @generated
	 * @ordered
	 */
	protected Player player;

	/**
	 * The cached value of the '{@link #getForecastDays() <em>Forecast Days</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForecastDays()
	 * @generated
	 * @ordered
	 */
	protected EList<ForecastDay> forecastDays;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValidatePlayerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.VALIDATE_PLAYER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player getPlayer() {
		if (player != null && player.eIsProxy()) {
			InternalEObject oldPlayer = (InternalEObject)player;
			player = (Player)eResolveProxy(oldPlayer);
			if (player != oldPlayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorldcupforecastPackage.VALIDATE_PLAYER__PLAYER, oldPlayer, player));
			}
		}
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player basicGetPlayer() {
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayer(Player newPlayer) {
		Player oldPlayer = player;
		player = newPlayer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.VALIDATE_PLAYER__PLAYER, oldPlayer, player));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ForecastDay> getForecastDays() {
		if (forecastDays == null) {
			forecastDays = new EObjectContainmentEList.Resolving<ForecastDay>(ForecastDay.class, this, WorldcupforecastPackage.VALIDATE_PLAYER__FORECAST_DAYS);
		}
		return forecastDays;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorldcupforecastPackage.VALIDATE_PLAYER__FORECAST_DAYS:
				return ((InternalEList<?>)getForecastDays()).basicRemove(otherEnd, msgs);
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
			case WorldcupforecastPackage.VALIDATE_PLAYER__PLAYER:
				if (resolve) return getPlayer();
				return basicGetPlayer();
			case WorldcupforecastPackage.VALIDATE_PLAYER__FORECAST_DAYS:
				return getForecastDays();
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
			case WorldcupforecastPackage.VALIDATE_PLAYER__PLAYER:
				setPlayer((Player)newValue);
				return;
			case WorldcupforecastPackage.VALIDATE_PLAYER__FORECAST_DAYS:
				getForecastDays().clear();
				getForecastDays().addAll((Collection<? extends ForecastDay>)newValue);
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
			case WorldcupforecastPackage.VALIDATE_PLAYER__PLAYER:
				setPlayer((Player)null);
				return;
			case WorldcupforecastPackage.VALIDATE_PLAYER__FORECAST_DAYS:
				getForecastDays().clear();
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
			case WorldcupforecastPackage.VALIDATE_PLAYER__PLAYER:
				return player != null;
			case WorldcupforecastPackage.VALIDATE_PLAYER__FORECAST_DAYS:
				return forecastDays != null && !forecastDays.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ValidatePlayerImpl

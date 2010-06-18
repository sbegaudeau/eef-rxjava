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

import org.eclipse.worldcupforecast.MatchDay;
import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.ValidatePlayer;
import org.eclipse.worldcupforecast.WorldCupForecast;
import org.eclipse.worldcupforecast.WorldCupGroup;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>World Cup Forecast</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.WorldCupForecastImpl#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.WorldCupForecastImpl#getPlayers <em>Players</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.WorldCupForecastImpl#getMatchDays <em>Match Days</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.WorldCupForecastImpl#getValidatePlayers <em>Validate Players</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorldCupForecastImpl extends EObjectImpl implements WorldCupForecast {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getGroups() <em>Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<WorldCupGroup> groups;

	/**
	 * The cached value of the '{@link #getPlayers() <em>Players</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayers()
	 * @generated
	 * @ordered
	 */
	protected EList<Player> players;

	/**
	 * The cached value of the '{@link #getMatchDays() <em>Match Days</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatchDays()
	 * @generated
	 * @ordered
	 */
	protected EList<MatchDay> matchDays;

	/**
	 * The cached value of the '{@link #getValidatePlayers() <em>Validate Players</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidatePlayers()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidatePlayer> validatePlayers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorldCupForecastImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.WORLD_CUP_FORECAST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<WorldCupGroup> getGroups() {
		if (groups == null) {
			groups = new EObjectContainmentEList.Resolving<WorldCupGroup>(WorldCupGroup.class, this, WorldcupforecastPackage.WORLD_CUP_FORECAST__GROUPS);
		}
		return groups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Player> getPlayers() {
		if (players == null) {
			players = new EObjectContainmentEList.Resolving<Player>(Player.class, this, WorldcupforecastPackage.WORLD_CUP_FORECAST__PLAYERS);
		}
		return players;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MatchDay> getMatchDays() {
		if (matchDays == null) {
			matchDays = new EObjectContainmentEList.Resolving<MatchDay>(MatchDay.class, this, WorldcupforecastPackage.WORLD_CUP_FORECAST__MATCH_DAYS);
		}
		return matchDays;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValidatePlayer> getValidatePlayers() {
		if (validatePlayers == null) {
			validatePlayers = new EObjectContainmentEList.Resolving<ValidatePlayer>(ValidatePlayer.class, this, WorldcupforecastPackage.WORLD_CUP_FORECAST__VALIDATE_PLAYERS);
		}
		return validatePlayers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__GROUPS:
				return ((InternalEList<?>)getGroups()).basicRemove(otherEnd, msgs);
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__PLAYERS:
				return ((InternalEList<?>)getPlayers()).basicRemove(otherEnd, msgs);
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__MATCH_DAYS:
				return ((InternalEList<?>)getMatchDays()).basicRemove(otherEnd, msgs);
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__VALIDATE_PLAYERS:
				return ((InternalEList<?>)getValidatePlayers()).basicRemove(otherEnd, msgs);
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
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__GROUPS:
				return getGroups();
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__PLAYERS:
				return getPlayers();
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__MATCH_DAYS:
				return getMatchDays();
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__VALIDATE_PLAYERS:
				return getValidatePlayers();
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
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__GROUPS:
				getGroups().clear();
				getGroups().addAll((Collection<? extends WorldCupGroup>)newValue);
				return;
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__PLAYERS:
				getPlayers().clear();
				getPlayers().addAll((Collection<? extends Player>)newValue);
				return;
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__MATCH_DAYS:
				getMatchDays().clear();
				getMatchDays().addAll((Collection<? extends MatchDay>)newValue);
				return;
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__VALIDATE_PLAYERS:
				getValidatePlayers().clear();
				getValidatePlayers().addAll((Collection<? extends ValidatePlayer>)newValue);
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
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__GROUPS:
				getGroups().clear();
				return;
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__PLAYERS:
				getPlayers().clear();
				return;
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__MATCH_DAYS:
				getMatchDays().clear();
				return;
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__VALIDATE_PLAYERS:
				getValidatePlayers().clear();
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
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__GROUPS:
				return groups != null && !groups.isEmpty();
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__PLAYERS:
				return players != null && !players.isEmpty();
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__MATCH_DAYS:
				return matchDays != null && !matchDays.isEmpty();
			case WorldcupforecastPackage.WORLD_CUP_FORECAST__VALIDATE_PLAYERS:
				return validatePlayers != null && !validatePlayers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //WorldCupForecastImpl

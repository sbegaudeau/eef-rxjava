/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.worldcupforecast.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.worldcupforecast.RoundOfSixteenMatch;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldCupGroup;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.helper.MatchHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Round Of Sixteen Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.RoundOfSixteenMatchImpl#getTeam1WinnerOfGroup <em>Team1 Winner Of Group</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.RoundOfSixteenMatchImpl#getTeam2RunnerUpOfGroup <em>Team2 Runner Up Of Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoundOfSixteenMatchImpl extends KnockoutStageMatchImpl implements RoundOfSixteenMatch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getTeam1WinnerOfGroup() <em>Team1 Winner Of Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam1WinnerOfGroup()
	 * @generated
	 * @ordered
	 */
	protected WorldCupGroup team1WinnerOfGroup;

	/**
	 * The cached value of the '{@link #getTeam2RunnerUpOfGroup() <em>Team2 Runner Up Of Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam2RunnerUpOfGroup()
	 * @generated
	 * @ordered
	 */
	protected WorldCupGroup team2RunnerUpOfGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoundOfSixteenMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.ROUND_OF_SIXTEEN_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldCupGroup getTeam1WinnerOfGroup() {
		if (team1WinnerOfGroup != null && team1WinnerOfGroup.eIsProxy()) {
			InternalEObject oldTeam1WinnerOfGroup = (InternalEObject)team1WinnerOfGroup;
			team1WinnerOfGroup = (WorldCupGroup)eResolveProxy(oldTeam1WinnerOfGroup);
			if (team1WinnerOfGroup != oldTeam1WinnerOfGroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM1_WINNER_OF_GROUP, oldTeam1WinnerOfGroup, team1WinnerOfGroup));
			}
		}
		return team1WinnerOfGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldCupGroup basicGetTeam1WinnerOfGroup() {
		return team1WinnerOfGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeam1WinnerOfGroup(WorldCupGroup newTeam1WinnerOfGroup) {
		WorldCupGroup oldTeam1WinnerOfGroup = team1WinnerOfGroup;
		team1WinnerOfGroup = newTeam1WinnerOfGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM1_WINNER_OF_GROUP, oldTeam1WinnerOfGroup, team1WinnerOfGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldCupGroup getTeam2RunnerUpOfGroup() {
		if (team2RunnerUpOfGroup != null && team2RunnerUpOfGroup.eIsProxy()) {
			InternalEObject oldTeam2RunnerUpOfGroup = (InternalEObject)team2RunnerUpOfGroup;
			team2RunnerUpOfGroup = (WorldCupGroup)eResolveProxy(oldTeam2RunnerUpOfGroup);
			if (team2RunnerUpOfGroup != oldTeam2RunnerUpOfGroup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM2_RUNNER_UP_OF_GROUP, oldTeam2RunnerUpOfGroup, team2RunnerUpOfGroup));
			}
		}
		return team2RunnerUpOfGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldCupGroup basicGetTeam2RunnerUpOfGroup() {
		return team2RunnerUpOfGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeam2RunnerUpOfGroup(WorldCupGroup newTeam2RunnerUpOfGroup) {
		WorldCupGroup oldTeam2RunnerUpOfGroup = team2RunnerUpOfGroup;
		team2RunnerUpOfGroup = newTeam2RunnerUpOfGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM2_RUNNER_UP_OF_GROUP, oldTeam2RunnerUpOfGroup, team2RunnerUpOfGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM1_WINNER_OF_GROUP:
				if (resolve) return getTeam1WinnerOfGroup();
				return basicGetTeam1WinnerOfGroup();
			case WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM2_RUNNER_UP_OF_GROUP:
				if (resolve) return getTeam2RunnerUpOfGroup();
				return basicGetTeam2RunnerUpOfGroup();
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
			case WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM1_WINNER_OF_GROUP:
				setTeam1WinnerOfGroup((WorldCupGroup)newValue);
				return;
			case WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM2_RUNNER_UP_OF_GROUP:
				setTeam2RunnerUpOfGroup((WorldCupGroup)newValue);
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
			case WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM1_WINNER_OF_GROUP:
				setTeam1WinnerOfGroup((WorldCupGroup)null);
				return;
			case WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM2_RUNNER_UP_OF_GROUP:
				setTeam2RunnerUpOfGroup((WorldCupGroup)null);
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
			case WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM1_WINNER_OF_GROUP:
				return team1WinnerOfGroup != null;
			case WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH__TEAM2_RUNNER_UP_OF_GROUP:
				return team2RunnerUpOfGroup != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Team basicGetCalculatedTeam1() {
		return MatchHelper.getCalculatedTeam1(RoundOfSixteenMatchImpl.this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Team basicGetCalculatedTeam2() {
		return MatchHelper.getCalculatedTeam2(RoundOfSixteenMatchImpl.this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setCalculatedTeam1(Team newCalculatedTeam1) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setCalculatedTeam2(Team newCalculatedTeam2) {
		// TODO Auto-generated method stub
		
	}

} //RoundOfSixteenMatchImpl

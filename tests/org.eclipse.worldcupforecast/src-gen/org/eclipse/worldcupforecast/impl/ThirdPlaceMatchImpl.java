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

import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.ThirdPlaceMatch;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.helper.MatchHelper;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Third Place Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.ThirdPlaceMatchImpl#getTeam1LooserOfMatch <em>Team1 Looser Of Match</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.ThirdPlaceMatchImpl#getTeam2LooserOfMatch <em>Team2 Looser Of Match</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThirdPlaceMatchImpl extends KnockoutStageMatchImpl implements ThirdPlaceMatch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getTeam1LooserOfMatch() <em>Team1 Looser Of Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam1LooserOfMatch()
	 * @generated
	 * @ordered
	 */
	protected Match team1LooserOfMatch;

	/**
	 * The cached value of the '{@link #getTeam2LooserOfMatch() <em>Team2 Looser Of Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam2LooserOfMatch()
	 * @generated
	 * @ordered
	 */
	protected Match team2LooserOfMatch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThirdPlaceMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.THIRD_PLACE_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match getTeam1LooserOfMatch() {
		if (team1LooserOfMatch != null && team1LooserOfMatch.eIsProxy()) {
			InternalEObject oldTeam1LooserOfMatch = (InternalEObject)team1LooserOfMatch;
			team1LooserOfMatch = (Match)eResolveProxy(oldTeam1LooserOfMatch);
			if (team1LooserOfMatch != oldTeam1LooserOfMatch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM1_LOOSER_OF_MATCH, oldTeam1LooserOfMatch, team1LooserOfMatch));
			}
		}
		return team1LooserOfMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match basicGetTeam1LooserOfMatch() {
		return team1LooserOfMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeam1LooserOfMatch(Match newTeam1LooserOfMatch) {
		Match oldTeam1LooserOfMatch = team1LooserOfMatch;
		team1LooserOfMatch = newTeam1LooserOfMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM1_LOOSER_OF_MATCH, oldTeam1LooserOfMatch, team1LooserOfMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match getTeam2LooserOfMatch() {
		if (team2LooserOfMatch != null && team2LooserOfMatch.eIsProxy()) {
			InternalEObject oldTeam2LooserOfMatch = (InternalEObject)team2LooserOfMatch;
			team2LooserOfMatch = (Match)eResolveProxy(oldTeam2LooserOfMatch);
			if (team2LooserOfMatch != oldTeam2LooserOfMatch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM2_LOOSER_OF_MATCH, oldTeam2LooserOfMatch, team2LooserOfMatch));
			}
		}
		return team2LooserOfMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match basicGetTeam2LooserOfMatch() {
		return team2LooserOfMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeam2LooserOfMatch(Match newTeam2LooserOfMatch) {
		Match oldTeam2LooserOfMatch = team2LooserOfMatch;
		team2LooserOfMatch = newTeam2LooserOfMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM2_LOOSER_OF_MATCH, oldTeam2LooserOfMatch, team2LooserOfMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM1_LOOSER_OF_MATCH:
				if (resolve) return getTeam1LooserOfMatch();
				return basicGetTeam1LooserOfMatch();
			case WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM2_LOOSER_OF_MATCH:
				if (resolve) return getTeam2LooserOfMatch();
				return basicGetTeam2LooserOfMatch();
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
			case WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM1_LOOSER_OF_MATCH:
				setTeam1LooserOfMatch((Match)newValue);
				return;
			case WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM2_LOOSER_OF_MATCH:
				setTeam2LooserOfMatch((Match)newValue);
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
			case WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM1_LOOSER_OF_MATCH:
				setTeam1LooserOfMatch((Match)null);
				return;
			case WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM2_LOOSER_OF_MATCH:
				setTeam2LooserOfMatch((Match)null);
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
			case WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM1_LOOSER_OF_MATCH:
				return team1LooserOfMatch != null;
			case WorldcupforecastPackage.THIRD_PLACE_MATCH__TEAM2_LOOSER_OF_MATCH:
				return team2LooserOfMatch != null;
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
		return MatchHelper.getCalculatedTeam1(ThirdPlaceMatchImpl.this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Team basicGetCalculatedTeam2() {
		return MatchHelper.getCalculatedTeam2(ThirdPlaceMatchImpl.this);
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

} //ThirdPlaceMatchImpl

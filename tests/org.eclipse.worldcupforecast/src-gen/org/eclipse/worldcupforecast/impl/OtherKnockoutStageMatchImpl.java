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

import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.MatchType;
import org.eclipse.worldcupforecast.OtherKnockoutStageMatch;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.helper.MatchHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Other Knockout Stage Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.OtherKnockoutStageMatchImpl#getTeam1WinnerOfMatch <em>Team1 Winner Of Match</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.OtherKnockoutStageMatchImpl#getTeam2WinnerOfMatch <em>Team2 Winner Of Match</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.OtherKnockoutStageMatchImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OtherKnockoutStageMatchImpl extends KnockoutStageMatchImpl implements OtherKnockoutStageMatch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getTeam1WinnerOfMatch() <em>Team1 Winner Of Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam1WinnerOfMatch()
	 * @generated
	 * @ordered
	 */
	protected Match team1WinnerOfMatch;

	/**
	 * The cached value of the '{@link #getTeam2WinnerOfMatch() <em>Team2 Winner Of Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTeam2WinnerOfMatch()
	 * @generated
	 * @ordered
	 */
	protected Match team2WinnerOfMatch;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final MatchType TYPE_EDEFAULT = MatchType.QUARTER_FINAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected MatchType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OtherKnockoutStageMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.OTHER_KNOCKOUT_STAGE_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match getTeam1WinnerOfMatch() {
		if (team1WinnerOfMatch != null && team1WinnerOfMatch.eIsProxy()) {
			InternalEObject oldTeam1WinnerOfMatch = (InternalEObject)team1WinnerOfMatch;
			team1WinnerOfMatch = (Match)eResolveProxy(oldTeam1WinnerOfMatch);
			if (team1WinnerOfMatch != oldTeam1WinnerOfMatch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM1_WINNER_OF_MATCH, oldTeam1WinnerOfMatch, team1WinnerOfMatch));
			}
		}
		return team1WinnerOfMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match basicGetTeam1WinnerOfMatch() {
		return team1WinnerOfMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeam1WinnerOfMatch(Match newTeam1WinnerOfMatch) {
		Match oldTeam1WinnerOfMatch = team1WinnerOfMatch;
		team1WinnerOfMatch = newTeam1WinnerOfMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM1_WINNER_OF_MATCH, oldTeam1WinnerOfMatch, team1WinnerOfMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match getTeam2WinnerOfMatch() {
		if (team2WinnerOfMatch != null && team2WinnerOfMatch.eIsProxy()) {
			InternalEObject oldTeam2WinnerOfMatch = (InternalEObject)team2WinnerOfMatch;
			team2WinnerOfMatch = (Match)eResolveProxy(oldTeam2WinnerOfMatch);
			if (team2WinnerOfMatch != oldTeam2WinnerOfMatch) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM2_WINNER_OF_MATCH, oldTeam2WinnerOfMatch, team2WinnerOfMatch));
			}
		}
		return team2WinnerOfMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Match basicGetTeam2WinnerOfMatch() {
		return team2WinnerOfMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTeam2WinnerOfMatch(Match newTeam2WinnerOfMatch) {
		Match oldTeam2WinnerOfMatch = team2WinnerOfMatch;
		team2WinnerOfMatch = newTeam2WinnerOfMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM2_WINNER_OF_MATCH, oldTeam2WinnerOfMatch, team2WinnerOfMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(MatchType newType) {
		MatchType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM1_WINNER_OF_MATCH:
				if (resolve) return getTeam1WinnerOfMatch();
				return basicGetTeam1WinnerOfMatch();
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM2_WINNER_OF_MATCH:
				if (resolve) return getTeam2WinnerOfMatch();
				return basicGetTeam2WinnerOfMatch();
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TYPE:
				return getType();
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
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM1_WINNER_OF_MATCH:
				setTeam1WinnerOfMatch((Match)newValue);
				return;
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM2_WINNER_OF_MATCH:
				setTeam2WinnerOfMatch((Match)newValue);
				return;
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TYPE:
				setType((MatchType)newValue);
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
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM1_WINNER_OF_MATCH:
				setTeam1WinnerOfMatch((Match)null);
				return;
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM2_WINNER_OF_MATCH:
				setTeam2WinnerOfMatch((Match)null);
				return;
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TYPE:
				setType(TYPE_EDEFAULT);
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
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM1_WINNER_OF_MATCH:
				return team1WinnerOfMatch != null;
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TEAM2_WINNER_OF_MATCH:
				return team2WinnerOfMatch != null;
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Team basicGetCalculatedTeam1() {
		return MatchHelper.getCalculatedTeam1(OtherKnockoutStageMatchImpl.this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Team basicGetCalculatedTeam2() {
		return MatchHelper.getCalculatedTeam2(OtherKnockoutStageMatchImpl.this);
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

} //OtherKnockoutStageMatchImpl

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

import org.eclipse.worldcupforecast.FinalScore;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.helper.FinalScoreHelper;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Final Score</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.FinalScoreImpl#getPenaltyScoreTeam1 <em>Penalty Score Team1</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.FinalScoreImpl#getPenaltyScoreTeam2 <em>Penalty Score Team2</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.FinalScoreImpl#getWinner <em>Winner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FinalScoreImpl extends ScoreImpl implements FinalScore {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getPenaltyScoreTeam1() <em>Penalty Score Team1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenaltyScoreTeam1()
	 * @generated
	 * @ordered
	 */
	protected static final int PENALTY_SCORE_TEAM1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPenaltyScoreTeam1() <em>Penalty Score Team1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenaltyScoreTeam1()
	 * @generated
	 * @ordered
	 */
	protected int penaltyScoreTeam1 = PENALTY_SCORE_TEAM1_EDEFAULT;

	/**
	 * The default value of the '{@link #getPenaltyScoreTeam2() <em>Penalty Score Team2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenaltyScoreTeam2()
	 * @generated
	 * @ordered
	 */
	protected static final int PENALTY_SCORE_TEAM2_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getPenaltyScoreTeam2() <em>Penalty Score Team2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPenaltyScoreTeam2()
	 * @generated
	 * @ordered
	 */
	protected int penaltyScoreTeam2 = PENALTY_SCORE_TEAM2_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FinalScoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.FINAL_SCORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPenaltyScoreTeam1() {
		return penaltyScoreTeam1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPenaltyScoreTeam1(int newPenaltyScoreTeam1) {
		int oldPenaltyScoreTeam1 = penaltyScoreTeam1;
		penaltyScoreTeam1 = newPenaltyScoreTeam1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.FINAL_SCORE__PENALTY_SCORE_TEAM1, oldPenaltyScoreTeam1, penaltyScoreTeam1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPenaltyScoreTeam2() {
		return penaltyScoreTeam2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPenaltyScoreTeam2(int newPenaltyScoreTeam2) {
		int oldPenaltyScoreTeam2 = penaltyScoreTeam2;
		penaltyScoreTeam2 = newPenaltyScoreTeam2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.FINAL_SCORE__PENALTY_SCORE_TEAM2, oldPenaltyScoreTeam2, penaltyScoreTeam2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team getWinner() {
		Team winner = basicGetWinner();
		return winner != null && winner.eIsProxy() ? (Team)eResolveProxy((InternalEObject)winner) : winner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Team basicGetWinner() {
		return FinalScoreHelper.getWinner(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorldcupforecastPackage.FINAL_SCORE__PENALTY_SCORE_TEAM1:
				return getPenaltyScoreTeam1();
			case WorldcupforecastPackage.FINAL_SCORE__PENALTY_SCORE_TEAM2:
				return getPenaltyScoreTeam2();
			case WorldcupforecastPackage.FINAL_SCORE__WINNER:
				if (resolve) return getWinner();
				return basicGetWinner();
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
			case WorldcupforecastPackage.FINAL_SCORE__PENALTY_SCORE_TEAM1:
				setPenaltyScoreTeam1((Integer)newValue);
				return;
			case WorldcupforecastPackage.FINAL_SCORE__PENALTY_SCORE_TEAM2:
				setPenaltyScoreTeam2((Integer)newValue);
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
			case WorldcupforecastPackage.FINAL_SCORE__PENALTY_SCORE_TEAM1:
				setPenaltyScoreTeam1(PENALTY_SCORE_TEAM1_EDEFAULT);
				return;
			case WorldcupforecastPackage.FINAL_SCORE__PENALTY_SCORE_TEAM2:
				setPenaltyScoreTeam2(PENALTY_SCORE_TEAM2_EDEFAULT);
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
			case WorldcupforecastPackage.FINAL_SCORE__PENALTY_SCORE_TEAM1:
				return penaltyScoreTeam1 != PENALTY_SCORE_TEAM1_EDEFAULT;
			case WorldcupforecastPackage.FINAL_SCORE__PENALTY_SCORE_TEAM2:
				return penaltyScoreTeam2 != PENALTY_SCORE_TEAM2_EDEFAULT;
			case WorldcupforecastPackage.FINAL_SCORE__WINNER:
				return basicGetWinner() != null;
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
		result.append(" (penaltyScoreTeam1: ");
		result.append(penaltyScoreTeam1);
		result.append(", penaltyScoreTeam2: ");
		result.append(penaltyScoreTeam2);
		result.append(')');
		return result.toString();
	}

} //FinalScoreImpl

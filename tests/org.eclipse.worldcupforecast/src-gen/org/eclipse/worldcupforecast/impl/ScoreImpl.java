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

import org.eclipse.worldcupforecast.Score;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Score</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.ScoreImpl#getScoreTeam1 <em>Score Team1</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.ScoreImpl#getScoreTeam2 <em>Score Team2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ScoreImpl extends EObjectImpl implements Score {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getScoreTeam1() <em>Score Team1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScoreTeam1()
	 * @generated
	 * @ordered
	 */
	protected static final int SCORE_TEAM1_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getScoreTeam1() <em>Score Team1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScoreTeam1()
	 * @generated
	 * @ordered
	 */
	protected int scoreTeam1 = SCORE_TEAM1_EDEFAULT;

	/**
	 * The default value of the '{@link #getScoreTeam2() <em>Score Team2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScoreTeam2()
	 * @generated
	 * @ordered
	 */
	protected static final int SCORE_TEAM2_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getScoreTeam2() <em>Score Team2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScoreTeam2()
	 * @generated
	 * @ordered
	 */
	protected int scoreTeam2 = SCORE_TEAM2_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScoreImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.SCORE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getScoreTeam1() {
		return scoreTeam1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScoreTeam1(int newScoreTeam1) {
		int oldScoreTeam1 = scoreTeam1;
		scoreTeam1 = newScoreTeam1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.SCORE__SCORE_TEAM1, oldScoreTeam1, scoreTeam1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getScoreTeam2() {
		return scoreTeam2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScoreTeam2(int newScoreTeam2) {
		int oldScoreTeam2 = scoreTeam2;
		scoreTeam2 = newScoreTeam2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.SCORE__SCORE_TEAM2, oldScoreTeam2, scoreTeam2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorldcupforecastPackage.SCORE__SCORE_TEAM1:
				return getScoreTeam1();
			case WorldcupforecastPackage.SCORE__SCORE_TEAM2:
				return getScoreTeam2();
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
			case WorldcupforecastPackage.SCORE__SCORE_TEAM1:
				setScoreTeam1((Integer)newValue);
				return;
			case WorldcupforecastPackage.SCORE__SCORE_TEAM2:
				setScoreTeam2((Integer)newValue);
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
			case WorldcupforecastPackage.SCORE__SCORE_TEAM1:
				setScoreTeam1(SCORE_TEAM1_EDEFAULT);
				return;
			case WorldcupforecastPackage.SCORE__SCORE_TEAM2:
				setScoreTeam2(SCORE_TEAM2_EDEFAULT);
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
			case WorldcupforecastPackage.SCORE__SCORE_TEAM1:
				return scoreTeam1 != SCORE_TEAM1_EDEFAULT;
			case WorldcupforecastPackage.SCORE__SCORE_TEAM2:
				return scoreTeam2 != SCORE_TEAM2_EDEFAULT;
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
		result.append(" (scoreTeam1: ");
		result.append(scoreTeam1);
		result.append(", scoreTeam2: ");
		result.append(scoreTeam2);
		result.append(')');
		return result.toString();
	}

} //ScoreImpl

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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.worldcupforecast.FinalScore;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.MatchImpl#getHours <em>Hours</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.MatchImpl#getMinutes <em>Minutes</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.MatchImpl#getCoefficient <em>Coefficient</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.MatchImpl#getScore <em>Score</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.MatchImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.MatchImpl#getTeam1 <em>Team1</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.MatchImpl#getTeam2 <em>Team2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class MatchImpl extends EObjectImpl implements Match {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The default value of the '{@link #getHours() <em>Hours</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHours()
	 * @generated
	 * @ordered
	 */
	protected static final int HOURS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHours() <em>Hours</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHours()
	 * @generated
	 * @ordered
	 */
	protected int hours = HOURS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinutes() <em>Minutes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinutes()
	 * @generated
	 * @ordered
	 */
	protected static final int MINUTES_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinutes() <em>Minutes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinutes()
	 * @generated
	 * @ordered
	 */
	protected int minutes = MINUTES_EDEFAULT;

	/**
	 * The default value of the '{@link #getCoefficient() <em>Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoefficient()
	 * @generated
	 * @ordered
	 */
	protected static final int COEFFICIENT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getCoefficient() <em>Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoefficient()
	 * @generated
	 * @ordered
	 */
	protected int coefficient = COEFFICIENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getScore() <em>Score</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScore()
	 * @generated
	 * @ordered
	 */
	protected FinalScore score;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHours() {
		return hours;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHours(int newHours) {
		int oldHours = hours;
		hours = newHours;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.MATCH__HOURS, oldHours, hours));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinutes() {
		return minutes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinutes(int newMinutes) {
		int oldMinutes = minutes;
		minutes = newMinutes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.MATCH__MINUTES, oldMinutes, minutes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCoefficient() {
		return coefficient;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoefficient(int newCoefficient) {
		int oldCoefficient = coefficient;
		coefficient = newCoefficient;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.MATCH__COEFFICIENT, oldCoefficient, coefficient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalScore getScore() {
		if (score != null && score.eIsProxy()) {
			InternalEObject oldScore = (InternalEObject)score;
			score = (FinalScore)eResolveProxy(oldScore);
			if (score != oldScore) {
				InternalEObject newScore = (InternalEObject)score;
				NotificationChain msgs = oldScore.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorldcupforecastPackage.MATCH__SCORE, null, null);
				if (newScore.eInternalContainer() == null) {
					msgs = newScore.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorldcupforecastPackage.MATCH__SCORE, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorldcupforecastPackage.MATCH__SCORE, oldScore, score));
			}
		}
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalScore basicGetScore() {
		return score;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScore(FinalScore newScore, NotificationChain msgs) {
		FinalScore oldScore = score;
		score = newScore;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.MATCH__SCORE, oldScore, newScore);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScore(FinalScore newScore) {
		if (newScore != score) {
			NotificationChain msgs = null;
			if (score != null)
				msgs = ((InternalEObject)score).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorldcupforecastPackage.MATCH__SCORE, null, msgs);
			if (newScore != null)
				msgs = ((InternalEObject)newScore).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorldcupforecastPackage.MATCH__SCORE, null, msgs);
			msgs = basicSetScore(newScore, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.MATCH__SCORE, newScore, newScore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		Team team1 = getTeam1();
		Team team2 = getTeam2();
		if(team1 != null && team2 != null) {
			return team1.getName() + " - " + team2.getName();
		}
		return "";
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Team getTeam1() {
		Team team1 = basicGetTeam1();
		return team1 != null && team1.eIsProxy() ? (Team)eResolveProxy((InternalEObject)team1) : team1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract Team basicGetTeam1();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void setTeam1(Team newTeam1);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Team getTeam2() {
		Team team2 = basicGetTeam2();
		return team2 != null && team2.eIsProxy() ? (Team)eResolveProxy((InternalEObject)team2) : team2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract Team basicGetTeam2();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void setTeam2(Team newTeam2);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorldcupforecastPackage.MATCH__SCORE:
				return basicSetScore(null, msgs);
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
			case WorldcupforecastPackage.MATCH__HOURS:
				return getHours();
			case WorldcupforecastPackage.MATCH__MINUTES:
				return getMinutes();
			case WorldcupforecastPackage.MATCH__COEFFICIENT:
				return getCoefficient();
			case WorldcupforecastPackage.MATCH__SCORE:
				if (resolve) return getScore();
				return basicGetScore();
			case WorldcupforecastPackage.MATCH__NAME:
				return getName();
			case WorldcupforecastPackage.MATCH__TEAM1:
				if (resolve) return getTeam1();
				return basicGetTeam1();
			case WorldcupforecastPackage.MATCH__TEAM2:
				if (resolve) return getTeam2();
				return basicGetTeam2();
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
			case WorldcupforecastPackage.MATCH__HOURS:
				setHours((Integer)newValue);
				return;
			case WorldcupforecastPackage.MATCH__MINUTES:
				setMinutes((Integer)newValue);
				return;
			case WorldcupforecastPackage.MATCH__COEFFICIENT:
				setCoefficient((Integer)newValue);
				return;
			case WorldcupforecastPackage.MATCH__SCORE:
				setScore((FinalScore)newValue);
				return;
			case WorldcupforecastPackage.MATCH__TEAM1:
				setTeam1((Team)newValue);
				return;
			case WorldcupforecastPackage.MATCH__TEAM2:
				setTeam2((Team)newValue);
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
			case WorldcupforecastPackage.MATCH__HOURS:
				setHours(HOURS_EDEFAULT);
				return;
			case WorldcupforecastPackage.MATCH__MINUTES:
				setMinutes(MINUTES_EDEFAULT);
				return;
			case WorldcupforecastPackage.MATCH__COEFFICIENT:
				setCoefficient(COEFFICIENT_EDEFAULT);
				return;
			case WorldcupforecastPackage.MATCH__SCORE:
				setScore((FinalScore)null);
				return;
			case WorldcupforecastPackage.MATCH__TEAM1:
				setTeam1((Team)null);
				return;
			case WorldcupforecastPackage.MATCH__TEAM2:
				setTeam2((Team)null);
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
			case WorldcupforecastPackage.MATCH__HOURS:
				return hours != HOURS_EDEFAULT;
			case WorldcupforecastPackage.MATCH__MINUTES:
				return minutes != MINUTES_EDEFAULT;
			case WorldcupforecastPackage.MATCH__COEFFICIENT:
				return coefficient != COEFFICIENT_EDEFAULT;
			case WorldcupforecastPackage.MATCH__SCORE:
				return score != null;
			case WorldcupforecastPackage.MATCH__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case WorldcupforecastPackage.MATCH__TEAM1:
				return basicGetTeam1() != null;
			case WorldcupforecastPackage.MATCH__TEAM2:
				return basicGetTeam2() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		result.append(" (hours: ");
		result.append(hours);
		result.append(", minutes: ");
		result.append(minutes);
		result.append(", coefficient: ");
		result.append(coefficient);
		result.append(')');
		return result.toString();
	}

} //MatchImpl

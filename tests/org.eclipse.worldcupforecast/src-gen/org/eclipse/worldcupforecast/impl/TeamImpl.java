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

import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;
import org.eclipse.worldcupforecast.helper.TeamHelper;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Team</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.TeamImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.TeamImpl#getPics <em>Pics</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.TeamImpl#getPoints <em>Points</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.TeamImpl#getGoalsFor <em>Goals For</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.TeamImpl#getGoalsAgainst <em>Goals Against</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.TeamImpl#getGoalDifference <em>Goal Difference</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.TeamImpl#getPlayed <em>Played</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TeamImpl extends EObjectImpl implements Team {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

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
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPics() <em>Pics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPics()
	 * @generated
	 * @ordered
	 */
	protected static final String PICS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPics() <em>Pics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPics()
	 * @generated
	 * @ordered
	 */
	protected String pics = PICS_EDEFAULT;

	/**
	 * The default value of the '{@link #getPoints() <em>Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPoints()
	 * @generated
	 * @ordered
	 */
	protected static final int POINTS_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getGoalsFor() <em>Goals For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalsFor()
	 * @generated
	 * @ordered
	 */
	protected static final int GOALS_FOR_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getGoalsAgainst() <em>Goals Against</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalsAgainst()
	 * @generated
	 * @ordered
	 */
	protected static final int GOALS_AGAINST_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getGoalDifference() <em>Goal Difference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoalDifference()
	 * @generated
	 * @ordered
	 */
	protected static final int GOAL_DIFFERENCE_EDEFAULT = 0;

	/**
	 * The default value of the '{@link #getPlayed() <em>Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlayed()
	 * @generated
	 * @ordered
	 */
	protected static final int PLAYED_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TeamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.TEAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.TEAM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPics() {
		return pics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPics(String newPics) {
		String oldPics = pics;
		pics = newPics;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.TEAM__PICS, oldPics, pics));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getPoints() {
		return TeamHelper.getNumberOfPoints(TeamImpl.this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setPoints(int newPoints) {
		// TODO: implement this method to set the 'Points' attribute
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getGoalsFor() {
		return TeamHelper.getGoalsFor(TeamImpl.this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGoalsFor(int newGoalsFor) {
		// TODO: implement this method to set the 'Goals For' attribute
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getGoalsAgainst() {
		return TeamHelper.getGoalsAgainst(TeamImpl.this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGoalsAgainst(int newGoalsAgainst) {
		// TODO: implement this method to set the 'Goals Against' attribute
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getGoalDifference() {
		return TeamHelper.getGoalDifference(TeamImpl.this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setGoalDifference(int newGoalDifference) {
		// TODO: implement this method to set the 'Goal Difference' attribute
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPlayed() {
		// TODO: implement this method to return the 'Played' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlayed(int newPlayed) {
		// TODO: implement this method to set the 'Played' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorldcupforecastPackage.TEAM__NAME:
				return getName();
			case WorldcupforecastPackage.TEAM__PICS:
				return getPics();
			case WorldcupforecastPackage.TEAM__POINTS:
				return getPoints();
			case WorldcupforecastPackage.TEAM__GOALS_FOR:
				return getGoalsFor();
			case WorldcupforecastPackage.TEAM__GOALS_AGAINST:
				return getGoalsAgainst();
			case WorldcupforecastPackage.TEAM__GOAL_DIFFERENCE:
				return getGoalDifference();
			case WorldcupforecastPackage.TEAM__PLAYED:
				return getPlayed();
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
			case WorldcupforecastPackage.TEAM__NAME:
				setName((String)newValue);
				return;
			case WorldcupforecastPackage.TEAM__PICS:
				setPics((String)newValue);
				return;
			case WorldcupforecastPackage.TEAM__POINTS:
				setPoints((Integer)newValue);
				return;
			case WorldcupforecastPackage.TEAM__GOALS_FOR:
				setGoalsFor((Integer)newValue);
				return;
			case WorldcupforecastPackage.TEAM__GOALS_AGAINST:
				setGoalsAgainst((Integer)newValue);
				return;
			case WorldcupforecastPackage.TEAM__GOAL_DIFFERENCE:
				setGoalDifference((Integer)newValue);
				return;
			case WorldcupforecastPackage.TEAM__PLAYED:
				setPlayed((Integer)newValue);
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
			case WorldcupforecastPackage.TEAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WorldcupforecastPackage.TEAM__PICS:
				setPics(PICS_EDEFAULT);
				return;
			case WorldcupforecastPackage.TEAM__POINTS:
				setPoints(POINTS_EDEFAULT);
				return;
			case WorldcupforecastPackage.TEAM__GOALS_FOR:
				setGoalsFor(GOALS_FOR_EDEFAULT);
				return;
			case WorldcupforecastPackage.TEAM__GOALS_AGAINST:
				setGoalsAgainst(GOALS_AGAINST_EDEFAULT);
				return;
			case WorldcupforecastPackage.TEAM__GOAL_DIFFERENCE:
				setGoalDifference(GOAL_DIFFERENCE_EDEFAULT);
				return;
			case WorldcupforecastPackage.TEAM__PLAYED:
				setPlayed(PLAYED_EDEFAULT);
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
			case WorldcupforecastPackage.TEAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WorldcupforecastPackage.TEAM__PICS:
				return PICS_EDEFAULT == null ? pics != null : !PICS_EDEFAULT.equals(pics);
			case WorldcupforecastPackage.TEAM__POINTS:
				return getPoints() != POINTS_EDEFAULT;
			case WorldcupforecastPackage.TEAM__GOALS_FOR:
				return getGoalsFor() != GOALS_FOR_EDEFAULT;
			case WorldcupforecastPackage.TEAM__GOALS_AGAINST:
				return getGoalsAgainst() != GOALS_AGAINST_EDEFAULT;
			case WorldcupforecastPackage.TEAM__GOAL_DIFFERENCE:
				return getGoalDifference() != GOAL_DIFFERENCE_EDEFAULT;
			case WorldcupforecastPackage.TEAM__PLAYED:
				return getPlayed() != PLAYED_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", pics: ");
		result.append(pics);
		result.append(')');
		return result.toString();
	}

} //TeamImpl

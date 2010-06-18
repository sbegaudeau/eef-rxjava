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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.worldcupforecast.GroupStageMatch;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Group Stage Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.GroupStageMatchImpl#getManualTeam1 <em>Manual Team1</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.GroupStageMatchImpl#getManualTeam2 <em>Manual Team2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GroupStageMatchImpl extends MatchImpl implements GroupStageMatch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The cached value of the '{@link #getManualTeam1() <em>Manual Team1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManualTeam1()
	 * @generated
	 * @ordered
	 */
	protected Team manualTeam1;

	/**
	 * The cached value of the '{@link #getManualTeam2() <em>Manual Team2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManualTeam2()
	 * @generated
	 * @ordered
	 */
	protected Team manualTeam2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GroupStageMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.GROUP_STAGE_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team getManualTeam1() {
		if (manualTeam1 != null && manualTeam1.eIsProxy()) {
			InternalEObject oldManualTeam1 = (InternalEObject)manualTeam1;
			manualTeam1 = (Team)eResolveProxy(oldManualTeam1);
			if (manualTeam1 != oldManualTeam1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM1, oldManualTeam1, manualTeam1));
			}
		}
		return manualTeam1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team basicGetManualTeam1() {
		return manualTeam1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManualTeam1(Team newManualTeam1) {
		Team oldManualTeam1 = manualTeam1;
		manualTeam1 = newManualTeam1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM1, oldManualTeam1, manualTeam1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team getManualTeam2() {
		if (manualTeam2 != null && manualTeam2.eIsProxy()) {
			InternalEObject oldManualTeam2 = (InternalEObject)manualTeam2;
			manualTeam2 = (Team)eResolveProxy(oldManualTeam2);
			if (manualTeam2 != oldManualTeam2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM2, oldManualTeam2, manualTeam2));
			}
		}
		return manualTeam2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team basicGetManualTeam2() {
		return manualTeam2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManualTeam2(Team newManualTeam2) {
		Team oldManualTeam2 = manualTeam2;
		manualTeam2 = newManualTeam2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM2, oldManualTeam2, manualTeam2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM1:
				if (resolve) return getManualTeam1();
				return basicGetManualTeam1();
			case WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM2:
				if (resolve) return getManualTeam2();
				return basicGetManualTeam2();
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
			case WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM1:
				setManualTeam1((Team)newValue);
				return;
			case WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM2:
				setManualTeam2((Team)newValue);
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
			case WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM1:
				setManualTeam1((Team)null);
				return;
			case WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM2:
				setManualTeam2((Team)null);
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
			case WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM1:
				return manualTeam1 != null;
			case WorldcupforecastPackage.GROUP_STAGE_MATCH__MANUAL_TEAM2:
				return manualTeam2 != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Team basicGetTeam1() {
		return getManualTeam1();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Team basicGetTeam2() {
		return getManualTeam2();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setTeam1(Team newTeam1) {
		setManualTeam1(newTeam1);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setTeam2(Team newTeam2) {
		setManualTeam2(newTeam2);
		
	}

} //GroupStageMatchImpl

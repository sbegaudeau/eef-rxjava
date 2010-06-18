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

import org.eclipse.worldcupforecast.KnockoutStageMatch;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Knockout Stage Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.impl.KnockoutStageMatchImpl#getCalculatedTeam1 <em>Calculated Team1</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.impl.KnockoutStageMatchImpl#getCalculatedTeam2 <em>Calculated Team2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class KnockoutStageMatchImpl extends MatchImpl implements KnockoutStageMatch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KnockoutStageMatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorldcupforecastPackage.Literals.KNOCKOUT_STAGE_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team getCalculatedTeam1() {
		Team calculatedTeam1 = basicGetCalculatedTeam1();
		return calculatedTeam1 != null && calculatedTeam1.eIsProxy() ? (Team)eResolveProxy((InternalEObject)calculatedTeam1) : calculatedTeam1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract Team basicGetCalculatedTeam1();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void setCalculatedTeam1(Team newCalculatedTeam1);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team getCalculatedTeam2() {
		Team calculatedTeam2 = basicGetCalculatedTeam2();
		return calculatedTeam2 != null && calculatedTeam2.eIsProxy() ? (Team)eResolveProxy((InternalEObject)calculatedTeam2) : calculatedTeam2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract Team basicGetCalculatedTeam2();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void setCalculatedTeam2(Team newCalculatedTeam2);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case WorldcupforecastPackage.KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1:
				if (resolve) return getCalculatedTeam1();
				return basicGetCalculatedTeam1();
			case WorldcupforecastPackage.KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2:
				if (resolve) return getCalculatedTeam2();
				return basicGetCalculatedTeam2();
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
			case WorldcupforecastPackage.KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1:
				setCalculatedTeam1((Team)newValue);
				return;
			case WorldcupforecastPackage.KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2:
				setCalculatedTeam2((Team)newValue);
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
			case WorldcupforecastPackage.KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1:
				setCalculatedTeam1((Team)null);
				return;
			case WorldcupforecastPackage.KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2:
				setCalculatedTeam2((Team)null);
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
			case WorldcupforecastPackage.KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1:
				return basicGetCalculatedTeam1() != null;
			case WorldcupforecastPackage.KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2:
				return basicGetCalculatedTeam2() != null;
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
		return getCalculatedTeam1();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Team basicGetTeam2() {
		return getCalculatedTeam2();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setTeam1(Team newTeam1) {
		setCalculatedTeam1(newTeam1);
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void setTeam2(Team newTeam2) {
		setCalculatedTeam2(newTeam2);
		
	}

} //KnockoutStageMatchImpl

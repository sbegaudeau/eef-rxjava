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

import org.eclipse.worldcupforecast.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorldcupforecastFactoryImpl extends EFactoryImpl implements WorldcupforecastFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WorldcupforecastFactory init() {
		try {
			WorldcupforecastFactory theWorldcupforecastFactory = (WorldcupforecastFactory)EPackage.Registry.INSTANCE.getEFactory("http://wwww.obeo.fr/dsl/worldcupforecast/1.0.0"); 
			if (theWorldcupforecastFactory != null) {
				return theWorldcupforecastFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WorldcupforecastFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldcupforecastFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WorldcupforecastPackage.WORLD_CUP_FORECAST: return createWorldCupForecast();
			case WorldcupforecastPackage.FORECAST: return createForecast();
			case WorldcupforecastPackage.TEAM: return createTeam();
			case WorldcupforecastPackage.WORLD_CUP_GROUP: return createWorldCupGroup();
			case WorldcupforecastPackage.PLAYER: return createPlayer();
			case WorldcupforecastPackage.VALIDATE_PLAYER: return createValidatePlayer();
			case WorldcupforecastPackage.FINAL_SCORE: return createFinalScore();
			case WorldcupforecastPackage.MATCH_DAY: return createMatchDay();
			case WorldcupforecastPackage.FORECAST_DAY: return createForecastDay();
			case WorldcupforecastPackage.GROUP_STAGE_MATCH: return createGroupStageMatch();
			case WorldcupforecastPackage.OTHER_KNOCKOUT_STAGE_MATCH: return createOtherKnockoutStageMatch();
			case WorldcupforecastPackage.THIRD_PLACE_MATCH: return createThirdPlaceMatch();
			case WorldcupforecastPackage.ROUND_OF_SIXTEEN_MATCH: return createRoundOfSixteenMatch();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case WorldcupforecastPackage.MATCH_TYPE:
				return createMatchTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case WorldcupforecastPackage.MATCH_TYPE:
				return convertMatchTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldCupForecast createWorldCupForecast() {
		WorldCupForecastImpl worldCupForecast = new WorldCupForecastImpl();
		return worldCupForecast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Forecast createForecast() {
		ForecastImpl forecast = new ForecastImpl();
		return forecast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Team createTeam() {
		TeamImpl team = new TeamImpl();
		return team;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldCupGroup createWorldCupGroup() {
		WorldCupGroupImpl worldCupGroup = new WorldCupGroupImpl();
		return worldCupGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Player createPlayer() {
		PlayerImpl player = new PlayerImpl();
		return player;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValidatePlayer createValidatePlayer() {
		ValidatePlayerImpl validatePlayer = new ValidatePlayerImpl();
		return validatePlayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalScore createFinalScore() {
		FinalScoreImpl finalScore = new FinalScoreImpl();
		return finalScore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchDay createMatchDay() {
		MatchDayImpl matchDay = new MatchDayImpl();
		return matchDay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForecastDay createForecastDay() {
		ForecastDayImpl forecastDay = new ForecastDayImpl();
		return forecastDay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GroupStageMatch createGroupStageMatch() {
		GroupStageMatchImpl groupStageMatch = new GroupStageMatchImpl();
		return groupStageMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OtherKnockoutStageMatch createOtherKnockoutStageMatch() {
		OtherKnockoutStageMatchImpl otherKnockoutStageMatch = new OtherKnockoutStageMatchImpl();
		return otherKnockoutStageMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThirdPlaceMatch createThirdPlaceMatch() {
		ThirdPlaceMatchImpl thirdPlaceMatch = new ThirdPlaceMatchImpl();
		return thirdPlaceMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoundOfSixteenMatch createRoundOfSixteenMatch() {
		RoundOfSixteenMatchImpl roundOfSixteenMatch = new RoundOfSixteenMatchImpl();
		return roundOfSixteenMatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchType createMatchTypeFromString(EDataType eDataType, String initialValue) {
		MatchType result = MatchType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMatchTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldcupforecastPackage getWorldcupforecastPackage() {
		return (WorldcupforecastPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static WorldcupforecastPackage getPackage() {
		return WorldcupforecastPackage.eINSTANCE;
	}

} //WorldcupforecastFactoryImpl

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

import org.eclipse.worldcupforecast.Day;
import org.eclipse.worldcupforecast.FinalScore;
import org.eclipse.worldcupforecast.Forecast;
import org.eclipse.worldcupforecast.ForecastDay;
import org.eclipse.worldcupforecast.GroupStageMatch;
import org.eclipse.worldcupforecast.KnockoutStageMatch;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.MatchDay;
import org.eclipse.worldcupforecast.MatchType;
import org.eclipse.worldcupforecast.OtherKnockoutStageMatch;
import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.RoundOfSixteenMatch;
import org.eclipse.worldcupforecast.Score;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.ThirdPlaceMatch;
import org.eclipse.worldcupforecast.ValidatePlayer;
import org.eclipse.worldcupforecast.WorldCupForecast;
import org.eclipse.worldcupforecast.WorldCupGroup;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.WorldcupforecastPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorldcupforecastPackageImpl extends EPackageImpl implements WorldcupforecastPackage {
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
	private EClass worldCupForecastEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forecastEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass teamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass worldCupGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass playerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validatePlayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finalScoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchDayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forecastDayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupStageMatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherKnockoutStageMatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass thirdPlaceMatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass roundOfSixteenMatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass knockoutStageMatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum matchTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private WorldcupforecastPackageImpl() {
		super(eNS_URI, WorldcupforecastFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link WorldcupforecastPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static WorldcupforecastPackage init() {
		if (isInited) return (WorldcupforecastPackage)EPackage.Registry.INSTANCE.getEPackage(WorldcupforecastPackage.eNS_URI);

		// Obtain or create and register package
		WorldcupforecastPackageImpl theWorldcupforecastPackage = (WorldcupforecastPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WorldcupforecastPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WorldcupforecastPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theWorldcupforecastPackage.createPackageContents();

		// Initialize created meta-data
		theWorldcupforecastPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theWorldcupforecastPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(WorldcupforecastPackage.eNS_URI, theWorldcupforecastPackage);
		return theWorldcupforecastPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorldCupForecast() {
		return worldCupForecastEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorldCupForecast_Groups() {
		return (EReference)worldCupForecastEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorldCupForecast_Players() {
		return (EReference)worldCupForecastEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorldCupForecast_MatchDays() {
		return (EReference)worldCupForecastEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorldCupForecast_ValidatePlayers() {
		return (EReference)worldCupForecastEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForecast() {
		return forecastEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForecast_Match() {
		return (EReference)forecastEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForecast_Winner() {
		return (EReference)forecastEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForecast_Score() {
		return (EAttribute)forecastEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatch() {
		return matchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatch_Hours() {
		return (EAttribute)matchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatch_Minutes() {
		return (EAttribute)matchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatch_Coefficient() {
		return (EAttribute)matchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatch_Score() {
		return (EReference)matchEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMatch_Name() {
		return (EAttribute)matchEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatch_Team1() {
		return (EReference)matchEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatch_Team2() {
		return (EReference)matchEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScore() {
		return scoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScore_ScoreTeam1() {
		return (EAttribute)scoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScore_ScoreTeam2() {
		return (EAttribute)scoreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTeam() {
		return teamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTeam_Name() {
		return (EAttribute)teamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTeam_Pics() {
		return (EAttribute)teamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTeam_Points() {
		return (EAttribute)teamEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTeam_GoalsFor() {
		return (EAttribute)teamEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTeam_GoalsAgainst() {
		return (EAttribute)teamEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTeam_GoalDifference() {
		return (EAttribute)teamEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTeam_Played() {
		return (EAttribute)teamEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWorldCupGroup() {
		return worldCupGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWorldCupGroup_Teams() {
		return (EReference)worldCupGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWorldCupGroup_Name() {
		return (EAttribute)worldCupGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlayer() {
		return playerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlayer_ForecastDays() {
		return (EReference)playerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlayer_Score() {
		return (EAttribute)playerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlayer_Name() {
		return (EAttribute)playerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValidatePlayer() {
		return validatePlayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidatePlayer_Player() {
		return (EReference)validatePlayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getValidatePlayer_ForecastDays() {
		return (EReference)validatePlayerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFinalScore() {
		return finalScoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFinalScore_PenaltyScoreTeam1() {
		return (EAttribute)finalScoreEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFinalScore_PenaltyScoreTeam2() {
		return (EAttribute)finalScoreEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFinalScore_Winner() {
		return (EReference)finalScoreEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchDay() {
		return matchDayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchDay_Matches() {
		return (EReference)matchDayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForecastDay() {
		return forecastDayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForecastDay_Forecasts() {
		return (EReference)forecastDayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDay() {
		return dayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDay_Date() {
		return (EAttribute)dayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroupStageMatch() {
		return groupStageMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupStageMatch_ManualTeam1() {
		return (EReference)groupStageMatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGroupStageMatch_ManualTeam2() {
		return (EReference)groupStageMatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOtherKnockoutStageMatch() {
		return otherKnockoutStageMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOtherKnockoutStageMatch_Team1WinnerOfMatch() {
		return (EReference)otherKnockoutStageMatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOtherKnockoutStageMatch_Team2WinnerOfMatch() {
		return (EReference)otherKnockoutStageMatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOtherKnockoutStageMatch_Type() {
		return (EAttribute)otherKnockoutStageMatchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThirdPlaceMatch() {
		return thirdPlaceMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThirdPlaceMatch_Team1LooserOfMatch() {
		return (EReference)thirdPlaceMatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getThirdPlaceMatch_Team2LooserOfMatch() {
		return (EReference)thirdPlaceMatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoundOfSixteenMatch() {
		return roundOfSixteenMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoundOfSixteenMatch_Team1WinnerOfGroup() {
		return (EReference)roundOfSixteenMatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRoundOfSixteenMatch_Team2RunnerUpOfGroup() {
		return (EReference)roundOfSixteenMatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKnockoutStageMatch() {
		return knockoutStageMatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKnockoutStageMatch_CalculatedTeam1() {
		return (EReference)knockoutStageMatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKnockoutStageMatch_CalculatedTeam2() {
		return (EReference)knockoutStageMatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMatchType() {
		return matchTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorldcupforecastFactory getWorldcupforecastFactory() {
		return (WorldcupforecastFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		worldCupForecastEClass = createEClass(WORLD_CUP_FORECAST);
		createEReference(worldCupForecastEClass, WORLD_CUP_FORECAST__GROUPS);
		createEReference(worldCupForecastEClass, WORLD_CUP_FORECAST__PLAYERS);
		createEReference(worldCupForecastEClass, WORLD_CUP_FORECAST__MATCH_DAYS);
		createEReference(worldCupForecastEClass, WORLD_CUP_FORECAST__VALIDATE_PLAYERS);

		forecastEClass = createEClass(FORECAST);
		createEReference(forecastEClass, FORECAST__MATCH);
		createEReference(forecastEClass, FORECAST__WINNER);
		createEAttribute(forecastEClass, FORECAST__SCORE);

		matchEClass = createEClass(MATCH);
		createEAttribute(matchEClass, MATCH__HOURS);
		createEAttribute(matchEClass, MATCH__MINUTES);
		createEAttribute(matchEClass, MATCH__COEFFICIENT);
		createEReference(matchEClass, MATCH__SCORE);
		createEAttribute(matchEClass, MATCH__NAME);
		createEReference(matchEClass, MATCH__TEAM1);
		createEReference(matchEClass, MATCH__TEAM2);

		scoreEClass = createEClass(SCORE);
		createEAttribute(scoreEClass, SCORE__SCORE_TEAM1);
		createEAttribute(scoreEClass, SCORE__SCORE_TEAM2);

		teamEClass = createEClass(TEAM);
		createEAttribute(teamEClass, TEAM__NAME);
		createEAttribute(teamEClass, TEAM__PICS);
		createEAttribute(teamEClass, TEAM__POINTS);
		createEAttribute(teamEClass, TEAM__GOALS_FOR);
		createEAttribute(teamEClass, TEAM__GOALS_AGAINST);
		createEAttribute(teamEClass, TEAM__GOAL_DIFFERENCE);
		createEAttribute(teamEClass, TEAM__PLAYED);

		worldCupGroupEClass = createEClass(WORLD_CUP_GROUP);
		createEReference(worldCupGroupEClass, WORLD_CUP_GROUP__TEAMS);
		createEAttribute(worldCupGroupEClass, WORLD_CUP_GROUP__NAME);

		playerEClass = createEClass(PLAYER);
		createEReference(playerEClass, PLAYER__FORECAST_DAYS);
		createEAttribute(playerEClass, PLAYER__SCORE);
		createEAttribute(playerEClass, PLAYER__NAME);

		validatePlayerEClass = createEClass(VALIDATE_PLAYER);
		createEReference(validatePlayerEClass, VALIDATE_PLAYER__PLAYER);
		createEReference(validatePlayerEClass, VALIDATE_PLAYER__FORECAST_DAYS);

		finalScoreEClass = createEClass(FINAL_SCORE);
		createEAttribute(finalScoreEClass, FINAL_SCORE__PENALTY_SCORE_TEAM1);
		createEAttribute(finalScoreEClass, FINAL_SCORE__PENALTY_SCORE_TEAM2);
		createEReference(finalScoreEClass, FINAL_SCORE__WINNER);

		matchDayEClass = createEClass(MATCH_DAY);
		createEReference(matchDayEClass, MATCH_DAY__MATCHES);

		forecastDayEClass = createEClass(FORECAST_DAY);
		createEReference(forecastDayEClass, FORECAST_DAY__FORECASTS);

		dayEClass = createEClass(DAY);
		createEAttribute(dayEClass, DAY__DATE);

		groupStageMatchEClass = createEClass(GROUP_STAGE_MATCH);
		createEReference(groupStageMatchEClass, GROUP_STAGE_MATCH__MANUAL_TEAM1);
		createEReference(groupStageMatchEClass, GROUP_STAGE_MATCH__MANUAL_TEAM2);

		otherKnockoutStageMatchEClass = createEClass(OTHER_KNOCKOUT_STAGE_MATCH);
		createEReference(otherKnockoutStageMatchEClass, OTHER_KNOCKOUT_STAGE_MATCH__TEAM1_WINNER_OF_MATCH);
		createEReference(otherKnockoutStageMatchEClass, OTHER_KNOCKOUT_STAGE_MATCH__TEAM2_WINNER_OF_MATCH);
		createEAttribute(otherKnockoutStageMatchEClass, OTHER_KNOCKOUT_STAGE_MATCH__TYPE);

		thirdPlaceMatchEClass = createEClass(THIRD_PLACE_MATCH);
		createEReference(thirdPlaceMatchEClass, THIRD_PLACE_MATCH__TEAM1_LOOSER_OF_MATCH);
		createEReference(thirdPlaceMatchEClass, THIRD_PLACE_MATCH__TEAM2_LOOSER_OF_MATCH);

		roundOfSixteenMatchEClass = createEClass(ROUND_OF_SIXTEEN_MATCH);
		createEReference(roundOfSixteenMatchEClass, ROUND_OF_SIXTEEN_MATCH__TEAM1_WINNER_OF_GROUP);
		createEReference(roundOfSixteenMatchEClass, ROUND_OF_SIXTEEN_MATCH__TEAM2_RUNNER_UP_OF_GROUP);

		knockoutStageMatchEClass = createEClass(KNOCKOUT_STAGE_MATCH);
		createEReference(knockoutStageMatchEClass, KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1);
		createEReference(knockoutStageMatchEClass, KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2);

		// Create enums
		matchTypeEEnum = createEEnum(MATCH_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		forecastEClass.getESuperTypes().add(this.getScore());
		finalScoreEClass.getESuperTypes().add(this.getScore());
		matchDayEClass.getESuperTypes().add(this.getDay());
		forecastDayEClass.getESuperTypes().add(this.getDay());
		groupStageMatchEClass.getESuperTypes().add(this.getMatch());
		otherKnockoutStageMatchEClass.getESuperTypes().add(this.getKnockoutStageMatch());
		thirdPlaceMatchEClass.getESuperTypes().add(this.getKnockoutStageMatch());
		roundOfSixteenMatchEClass.getESuperTypes().add(this.getKnockoutStageMatch());
		knockoutStageMatchEClass.getESuperTypes().add(this.getMatch());

		// Initialize classes and features; add operations and parameters
		initEClass(worldCupForecastEClass, WorldCupForecast.class, "WorldCupForecast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorldCupForecast_Groups(), this.getWorldCupGroup(), null, "groups", null, 0, -1, WorldCupForecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorldCupForecast_Players(), this.getPlayer(), null, "players", null, 0, -1, WorldCupForecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorldCupForecast_MatchDays(), this.getMatchDay(), null, "matchDays", null, 0, -1, WorldCupForecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWorldCupForecast_ValidatePlayers(), this.getValidatePlayer(), null, "validatePlayers", null, 0, -1, WorldCupForecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forecastEClass, Forecast.class, "Forecast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForecast_Match(), this.getMatch(), null, "match", null, 1, 1, Forecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForecast_Winner(), this.getTeam(), null, "winner", null, 0, 1, Forecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForecast_Score(), ecorePackage.getEInt(), "score", null, 0, 1, Forecast.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(matchEClass, Match.class, "Match", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMatch_Hours(), ecorePackage.getEInt(), "hours", null, 1, 1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatch_Minutes(), ecorePackage.getEInt(), "minutes", null, 1, 1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatch_Coefficient(), ecorePackage.getEInt(), "coefficient", "1", 0, 1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMatch_Score(), this.getFinalScore(), null, "score", null, 0, 1, Match.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMatch_Name(), ecorePackage.getEString(), "name", null, 0, 1, Match.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMatch_Team1(), this.getTeam(), null, "team1", null, 1, 1, Match.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getMatch_Team2(), this.getTeam(), null, "team2", null, 1, 1, Match.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(scoreEClass, Score.class, "Score", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScore_ScoreTeam1(), ecorePackage.getEInt(), "scoreTeam1", null, 0, 1, Score.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getScore_ScoreTeam2(), ecorePackage.getEInt(), "scoreTeam2", null, 0, 1, Score.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(teamEClass, Team.class, "Team", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTeam_Name(), ecorePackage.getEString(), "name", null, 1, 1, Team.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeam_Pics(), ecorePackage.getEString(), "pics", null, 0, 1, Team.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeam_Points(), ecorePackage.getEInt(), "points", null, 0, 1, Team.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeam_GoalsFor(), ecorePackage.getEInt(), "goalsFor", null, 0, 1, Team.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeam_GoalsAgainst(), ecorePackage.getEInt(), "goalsAgainst", null, 0, 1, Team.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeam_GoalDifference(), ecorePackage.getEInt(), "goalDifference", null, 0, 1, Team.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTeam_Played(), ecorePackage.getEInt(), "played", null, 0, 1, Team.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(worldCupGroupEClass, WorldCupGroup.class, "WorldCupGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWorldCupGroup_Teams(), this.getTeam(), null, "teams", null, 0, 4, WorldCupGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWorldCupGroup_Name(), ecorePackage.getEString(), "name", null, 1, 1, WorldCupGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(playerEClass, Player.class, "Player", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlayer_ForecastDays(), this.getForecastDay(), null, "forecastDays", null, 0, -1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlayer_Score(), ecorePackage.getEInt(), "score", null, 1, 1, Player.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlayer_Name(), ecorePackage.getEString(), "name", null, 1, 1, Player.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(playerEClass, ecorePackage.getEInt(), "goodForecastNumber", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(playerEClass, ecorePackage.getEInt(), "perfectForecastsNumber", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(validatePlayerEClass, ValidatePlayer.class, "ValidatePlayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidatePlayer_Player(), this.getPlayer(), null, "player", null, 1, 1, ValidatePlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidatePlayer_ForecastDays(), this.getForecastDay(), null, "forecastDays", null, 0, -1, ValidatePlayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(finalScoreEClass, FinalScore.class, "FinalScore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFinalScore_PenaltyScoreTeam1(), ecorePackage.getEInt(), "penaltyScoreTeam1", null, 0, 1, FinalScore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFinalScore_PenaltyScoreTeam2(), ecorePackage.getEInt(), "penaltyScoreTeam2", null, 0, 1, FinalScore.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFinalScore_Winner(), this.getTeam(), null, "winner", null, 0, 1, FinalScore.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(matchDayEClass, MatchDay.class, "MatchDay", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMatchDay_Matches(), this.getMatch(), null, "matches", null, 0, -1, MatchDay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forecastDayEClass, ForecastDay.class, "ForecastDay", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForecastDay_Forecasts(), this.getForecast(), null, "forecasts", null, 0, -1, ForecastDay.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dayEClass, Day.class, "Day", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDay_Date(), ecorePackage.getEString(), "date", null, 1, 1, Day.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(groupStageMatchEClass, GroupStageMatch.class, "GroupStageMatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGroupStageMatch_ManualTeam1(), this.getTeam(), null, "manualTeam1", null, 1, 1, GroupStageMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGroupStageMatch_ManualTeam2(), this.getTeam(), null, "manualTeam2", null, 1, 1, GroupStageMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(otherKnockoutStageMatchEClass, OtherKnockoutStageMatch.class, "OtherKnockoutStageMatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOtherKnockoutStageMatch_Team1WinnerOfMatch(), this.getMatch(), null, "team1WinnerOfMatch", null, 1, 1, OtherKnockoutStageMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOtherKnockoutStageMatch_Team2WinnerOfMatch(), this.getMatch(), null, "team2WinnerOfMatch", null, 1, 1, OtherKnockoutStageMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOtherKnockoutStageMatch_Type(), this.getMatchType(), "type", null, 1, 1, OtherKnockoutStageMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(thirdPlaceMatchEClass, ThirdPlaceMatch.class, "ThirdPlaceMatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getThirdPlaceMatch_Team1LooserOfMatch(), this.getMatch(), null, "team1LooserOfMatch", null, 1, 1, ThirdPlaceMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getThirdPlaceMatch_Team2LooserOfMatch(), this.getMatch(), null, "team2LooserOfMatch", null, 1, 1, ThirdPlaceMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roundOfSixteenMatchEClass, RoundOfSixteenMatch.class, "RoundOfSixteenMatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRoundOfSixteenMatch_Team1WinnerOfGroup(), this.getWorldCupGroup(), null, "team1WinnerOfGroup", null, 1, 1, RoundOfSixteenMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRoundOfSixteenMatch_Team2RunnerUpOfGroup(), this.getWorldCupGroup(), null, "team2RunnerUpOfGroup", null, 1, 1, RoundOfSixteenMatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(knockoutStageMatchEClass, KnockoutStageMatch.class, "KnockoutStageMatch", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKnockoutStageMatch_CalculatedTeam1(), this.getTeam(), null, "calculatedTeam1", null, 1, 1, KnockoutStageMatch.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getKnockoutStageMatch_CalculatedTeam2(), this.getTeam(), null, "calculatedTeam2", null, 1, 1, KnockoutStageMatch.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(matchTypeEEnum, MatchType.class, "MatchType");
		addEEnumLiteral(matchTypeEEnum, MatchType.QUARTER_FINAL);
		addEEnumLiteral(matchTypeEEnum, MatchType.SEMI_FINAL);
		addEEnumLiteral(matchTypeEEnum, MatchType.FINAL);

		// Create resource
		createResource(eNS_URI);
	}

} //WorldcupforecastPackageImpl

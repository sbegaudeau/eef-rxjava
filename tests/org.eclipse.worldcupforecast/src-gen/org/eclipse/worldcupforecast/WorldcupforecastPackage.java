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
package org.eclipse.worldcupforecast;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.worldcupforecast.WorldcupforecastFactory
 * @model kind="package"
 * @generated
 */
public interface WorldcupforecastPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "worldcupforecast";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://wwww.obeo.fr/dsl/worldcupforecast/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "worldcupforecast";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorldcupforecastPackage eINSTANCE = org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.WorldCupForecastImpl <em>World Cup Forecast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.WorldCupForecastImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getWorldCupForecast()
	 * @generated
	 */
	int WORLD_CUP_FORECAST = 0;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_CUP_FORECAST__GROUPS = 0;

	/**
	 * The feature id for the '<em><b>Players</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_CUP_FORECAST__PLAYERS = 1;

	/**
	 * The feature id for the '<em><b>Match Days</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_CUP_FORECAST__MATCH_DAYS = 2;

	/**
	 * The feature id for the '<em><b>Validate Players</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_CUP_FORECAST__VALIDATE_PLAYERS = 3;

	/**
	 * The number of structural features of the '<em>World Cup Forecast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_CUP_FORECAST_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.ScoreImpl <em>Score</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.ScoreImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getScore()
	 * @generated
	 */
	int SCORE = 3;

	/**
	 * The feature id for the '<em><b>Score Team1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__SCORE_TEAM1 = 0;

	/**
	 * The feature id for the '<em><b>Score Team2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE__SCORE_TEAM2 = 1;

	/**
	 * The number of structural features of the '<em>Score</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.ForecastImpl <em>Forecast</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.ForecastImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getForecast()
	 * @generated
	 */
	int FORECAST = 1;

	/**
	 * The feature id for the '<em><b>Score Team1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORECAST__SCORE_TEAM1 = SCORE__SCORE_TEAM1;

	/**
	 * The feature id for the '<em><b>Score Team2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORECAST__SCORE_TEAM2 = SCORE__SCORE_TEAM2;

	/**
	 * The feature id for the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORECAST__MATCH = SCORE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Winner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORECAST__WINNER = SCORE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORECAST__SCORE = SCORE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Forecast</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORECAST_FEATURE_COUNT = SCORE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.MatchImpl <em>Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.MatchImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getMatch()
	 * @generated
	 */
	int MATCH = 2;

	/**
	 * The feature id for the '<em><b>Hours</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__HOURS = 0;

	/**
	 * The feature id for the '<em><b>Minutes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__MINUTES = 1;

	/**
	 * The feature id for the '<em><b>Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__COEFFICIENT = 2;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__SCORE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__NAME = 4;

	/**
	 * The feature id for the '<em><b>Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__TEAM1 = 5;

	/**
	 * The feature id for the '<em><b>Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH__TEAM2 = 6;

	/**
	 * The number of structural features of the '<em>Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.TeamImpl <em>Team</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.TeamImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getTeam()
	 * @generated
	 */
	int TEAM = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Pics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__PICS = 1;

	/**
	 * The feature id for the '<em><b>Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__POINTS = 2;

	/**
	 * The feature id for the '<em><b>Goals For</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__GOALS_FOR = 3;

	/**
	 * The feature id for the '<em><b>Goals Against</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__GOALS_AGAINST = 4;

	/**
	 * The feature id for the '<em><b>Goal Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__GOAL_DIFFERENCE = 5;

	/**
	 * The feature id for the '<em><b>Played</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM__PLAYED = 6;

	/**
	 * The number of structural features of the '<em>Team</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEAM_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.WorldCupGroupImpl <em>World Cup Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.WorldCupGroupImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getWorldCupGroup()
	 * @generated
	 */
	int WORLD_CUP_GROUP = 5;

	/**
	 * The feature id for the '<em><b>Teams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_CUP_GROUP__TEAMS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_CUP_GROUP__NAME = 1;

	/**
	 * The number of structural features of the '<em>World Cup Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORLD_CUP_GROUP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.PlayerImpl <em>Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.PlayerImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getPlayer()
	 * @generated
	 */
	int PLAYER = 6;

	/**
	 * The feature id for the '<em><b>Forecast Days</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__FORECAST_DAYS = 0;

	/**
	 * The feature id for the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__SCORE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER__NAME = 2;

	/**
	 * The number of structural features of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.ValidatePlayerImpl <em>Validate Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.ValidatePlayerImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getValidatePlayer()
	 * @generated
	 */
	int VALIDATE_PLAYER = 7;

	/**
	 * The feature id for the '<em><b>Player</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_PLAYER__PLAYER = 0;

	/**
	 * The feature id for the '<em><b>Forecast Days</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_PLAYER__FORECAST_DAYS = 1;

	/**
	 * The number of structural features of the '<em>Validate Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATE_PLAYER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.FinalScoreImpl <em>Final Score</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.FinalScoreImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getFinalScore()
	 * @generated
	 */
	int FINAL_SCORE = 8;

	/**
	 * The feature id for the '<em><b>Score Team1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_SCORE__SCORE_TEAM1 = SCORE__SCORE_TEAM1;

	/**
	 * The feature id for the '<em><b>Score Team2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_SCORE__SCORE_TEAM2 = SCORE__SCORE_TEAM2;

	/**
	 * The feature id for the '<em><b>Penalty Score Team1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_SCORE__PENALTY_SCORE_TEAM1 = SCORE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Penalty Score Team2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_SCORE__PENALTY_SCORE_TEAM2 = SCORE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Winner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_SCORE__WINNER = SCORE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Final Score</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_SCORE_FEATURE_COUNT = SCORE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.DayImpl <em>Day</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.DayImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getDay()
	 * @generated
	 */
	int DAY = 11;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAY__DATE = 0;

	/**
	 * The number of structural features of the '<em>Day</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DAY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.MatchDayImpl <em>Match Day</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.MatchDayImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getMatchDay()
	 * @generated
	 */
	int MATCH_DAY = 9;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_DAY__DATE = DAY__DATE;

	/**
	 * The feature id for the '<em><b>Matches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_DAY__MATCHES = DAY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Match Day</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MATCH_DAY_FEATURE_COUNT = DAY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.ForecastDayImpl <em>Forecast Day</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.ForecastDayImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getForecastDay()
	 * @generated
	 */
	int FORECAST_DAY = 10;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORECAST_DAY__DATE = DAY__DATE;

	/**
	 * The feature id for the '<em><b>Forecasts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORECAST_DAY__FORECASTS = DAY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Forecast Day</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORECAST_DAY_FEATURE_COUNT = DAY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.GroupStageMatchImpl <em>Group Stage Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.GroupStageMatchImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getGroupStageMatch()
	 * @generated
	 */
	int GROUP_STAGE_MATCH = 12;

	/**
	 * The feature id for the '<em><b>Hours</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_STAGE_MATCH__HOURS = MATCH__HOURS;

	/**
	 * The feature id for the '<em><b>Minutes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_STAGE_MATCH__MINUTES = MATCH__MINUTES;

	/**
	 * The feature id for the '<em><b>Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_STAGE_MATCH__COEFFICIENT = MATCH__COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_STAGE_MATCH__SCORE = MATCH__SCORE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_STAGE_MATCH__NAME = MATCH__NAME;

	/**
	 * The feature id for the '<em><b>Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_STAGE_MATCH__TEAM1 = MATCH__TEAM1;

	/**
	 * The feature id for the '<em><b>Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_STAGE_MATCH__TEAM2 = MATCH__TEAM2;

	/**
	 * The feature id for the '<em><b>Manual Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_STAGE_MATCH__MANUAL_TEAM1 = MATCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Manual Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_STAGE_MATCH__MANUAL_TEAM2 = MATCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Group Stage Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_STAGE_MATCH_FEATURE_COUNT = MATCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.KnockoutStageMatchImpl <em>Knockout Stage Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.KnockoutStageMatchImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getKnockoutStageMatch()
	 * @generated
	 */
	int KNOCKOUT_STAGE_MATCH = 16;

	/**
	 * The feature id for the '<em><b>Hours</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOCKOUT_STAGE_MATCH__HOURS = MATCH__HOURS;

	/**
	 * The feature id for the '<em><b>Minutes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOCKOUT_STAGE_MATCH__MINUTES = MATCH__MINUTES;

	/**
	 * The feature id for the '<em><b>Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOCKOUT_STAGE_MATCH__COEFFICIENT = MATCH__COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOCKOUT_STAGE_MATCH__SCORE = MATCH__SCORE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOCKOUT_STAGE_MATCH__NAME = MATCH__NAME;

	/**
	 * The feature id for the '<em><b>Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOCKOUT_STAGE_MATCH__TEAM1 = MATCH__TEAM1;

	/**
	 * The feature id for the '<em><b>Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOCKOUT_STAGE_MATCH__TEAM2 = MATCH__TEAM2;

	/**
	 * The feature id for the '<em><b>Calculated Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1 = MATCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Calculated Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2 = MATCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Knockout Stage Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KNOCKOUT_STAGE_MATCH_FEATURE_COUNT = MATCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.OtherKnockoutStageMatchImpl <em>Other Knockout Stage Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.OtherKnockoutStageMatchImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getOtherKnockoutStageMatch()
	 * @generated
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH = 13;

	/**
	 * The feature id for the '<em><b>Hours</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__HOURS = KNOCKOUT_STAGE_MATCH__HOURS;

	/**
	 * The feature id for the '<em><b>Minutes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__MINUTES = KNOCKOUT_STAGE_MATCH__MINUTES;

	/**
	 * The feature id for the '<em><b>Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__COEFFICIENT = KNOCKOUT_STAGE_MATCH__COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__SCORE = KNOCKOUT_STAGE_MATCH__SCORE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__NAME = KNOCKOUT_STAGE_MATCH__NAME;

	/**
	 * The feature id for the '<em><b>Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__TEAM1 = KNOCKOUT_STAGE_MATCH__TEAM1;

	/**
	 * The feature id for the '<em><b>Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__TEAM2 = KNOCKOUT_STAGE_MATCH__TEAM2;

	/**
	 * The feature id for the '<em><b>Calculated Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1 = KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1;

	/**
	 * The feature id for the '<em><b>Calculated Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2 = KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2;

	/**
	 * The feature id for the '<em><b>Team1 Winner Of Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__TEAM1_WINNER_OF_MATCH = KNOCKOUT_STAGE_MATCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Team2 Winner Of Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__TEAM2_WINNER_OF_MATCH = KNOCKOUT_STAGE_MATCH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH__TYPE = KNOCKOUT_STAGE_MATCH_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Other Knockout Stage Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OTHER_KNOCKOUT_STAGE_MATCH_FEATURE_COUNT = KNOCKOUT_STAGE_MATCH_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.ThirdPlaceMatchImpl <em>Third Place Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.ThirdPlaceMatchImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getThirdPlaceMatch()
	 * @generated
	 */
	int THIRD_PLACE_MATCH = 14;

	/**
	 * The feature id for the '<em><b>Hours</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__HOURS = KNOCKOUT_STAGE_MATCH__HOURS;

	/**
	 * The feature id for the '<em><b>Minutes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__MINUTES = KNOCKOUT_STAGE_MATCH__MINUTES;

	/**
	 * The feature id for the '<em><b>Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__COEFFICIENT = KNOCKOUT_STAGE_MATCH__COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__SCORE = KNOCKOUT_STAGE_MATCH__SCORE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__NAME = KNOCKOUT_STAGE_MATCH__NAME;

	/**
	 * The feature id for the '<em><b>Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__TEAM1 = KNOCKOUT_STAGE_MATCH__TEAM1;

	/**
	 * The feature id for the '<em><b>Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__TEAM2 = KNOCKOUT_STAGE_MATCH__TEAM2;

	/**
	 * The feature id for the '<em><b>Calculated Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__CALCULATED_TEAM1 = KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1;

	/**
	 * The feature id for the '<em><b>Calculated Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__CALCULATED_TEAM2 = KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2;

	/**
	 * The feature id for the '<em><b>Team1 Looser Of Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__TEAM1_LOOSER_OF_MATCH = KNOCKOUT_STAGE_MATCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Team2 Looser Of Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH__TEAM2_LOOSER_OF_MATCH = KNOCKOUT_STAGE_MATCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Third Place Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THIRD_PLACE_MATCH_FEATURE_COUNT = KNOCKOUT_STAGE_MATCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.impl.RoundOfSixteenMatchImpl <em>Round Of Sixteen Match</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.impl.RoundOfSixteenMatchImpl
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getRoundOfSixteenMatch()
	 * @generated
	 */
	int ROUND_OF_SIXTEEN_MATCH = 15;

	/**
	 * The feature id for the '<em><b>Hours</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__HOURS = KNOCKOUT_STAGE_MATCH__HOURS;

	/**
	 * The feature id for the '<em><b>Minutes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__MINUTES = KNOCKOUT_STAGE_MATCH__MINUTES;

	/**
	 * The feature id for the '<em><b>Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__COEFFICIENT = KNOCKOUT_STAGE_MATCH__COEFFICIENT;

	/**
	 * The feature id for the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__SCORE = KNOCKOUT_STAGE_MATCH__SCORE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__NAME = KNOCKOUT_STAGE_MATCH__NAME;

	/**
	 * The feature id for the '<em><b>Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__TEAM1 = KNOCKOUT_STAGE_MATCH__TEAM1;

	/**
	 * The feature id for the '<em><b>Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__TEAM2 = KNOCKOUT_STAGE_MATCH__TEAM2;

	/**
	 * The feature id for the '<em><b>Calculated Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__CALCULATED_TEAM1 = KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1;

	/**
	 * The feature id for the '<em><b>Calculated Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__CALCULATED_TEAM2 = KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2;

	/**
	 * The feature id for the '<em><b>Team1 Winner Of Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__TEAM1_WINNER_OF_GROUP = KNOCKOUT_STAGE_MATCH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Team2 Runner Up Of Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH__TEAM2_RUNNER_UP_OF_GROUP = KNOCKOUT_STAGE_MATCH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Round Of Sixteen Match</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUND_OF_SIXTEEN_MATCH_FEATURE_COUNT = KNOCKOUT_STAGE_MATCH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.worldcupforecast.MatchType <em>Match Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.worldcupforecast.MatchType
	 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getMatchType()
	 * @generated
	 */
	int MATCH_TYPE = 17;


	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.WorldCupForecast <em>World Cup Forecast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>World Cup Forecast</em>'.
	 * @see org.eclipse.worldcupforecast.WorldCupForecast
	 * @generated
	 */
	EClass getWorldCupForecast();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.worldcupforecast.WorldCupForecast#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see org.eclipse.worldcupforecast.WorldCupForecast#getGroups()
	 * @see #getWorldCupForecast()
	 * @generated
	 */
	EReference getWorldCupForecast_Groups();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.worldcupforecast.WorldCupForecast#getPlayers <em>Players</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Players</em>'.
	 * @see org.eclipse.worldcupforecast.WorldCupForecast#getPlayers()
	 * @see #getWorldCupForecast()
	 * @generated
	 */
	EReference getWorldCupForecast_Players();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.worldcupforecast.WorldCupForecast#getMatchDays <em>Match Days</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Match Days</em>'.
	 * @see org.eclipse.worldcupforecast.WorldCupForecast#getMatchDays()
	 * @see #getWorldCupForecast()
	 * @generated
	 */
	EReference getWorldCupForecast_MatchDays();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.worldcupforecast.WorldCupForecast#getValidatePlayers <em>Validate Players</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Validate Players</em>'.
	 * @see org.eclipse.worldcupforecast.WorldCupForecast#getValidatePlayers()
	 * @see #getWorldCupForecast()
	 * @generated
	 */
	EReference getWorldCupForecast_ValidatePlayers();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.Forecast <em>Forecast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Forecast</em>'.
	 * @see org.eclipse.worldcupforecast.Forecast
	 * @generated
	 */
	EClass getForecast();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.Forecast#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Match</em>'.
	 * @see org.eclipse.worldcupforecast.Forecast#getMatch()
	 * @see #getForecast()
	 * @generated
	 */
	EReference getForecast_Match();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.Forecast#getWinner <em>Winner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Winner</em>'.
	 * @see org.eclipse.worldcupforecast.Forecast#getWinner()
	 * @see #getForecast()
	 * @generated
	 */
	EReference getForecast_Winner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Forecast#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see org.eclipse.worldcupforecast.Forecast#getScore()
	 * @see #getForecast()
	 * @generated
	 */
	EAttribute getForecast_Score();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.Match <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match</em>'.
	 * @see org.eclipse.worldcupforecast.Match
	 * @generated
	 */
	EClass getMatch();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Match#getHours <em>Hours</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hours</em>'.
	 * @see org.eclipse.worldcupforecast.Match#getHours()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Hours();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Match#getMinutes <em>Minutes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minutes</em>'.
	 * @see org.eclipse.worldcupforecast.Match#getMinutes()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Minutes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Match#getCoefficient <em>Coefficient</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coefficient</em>'.
	 * @see org.eclipse.worldcupforecast.Match#getCoefficient()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Coefficient();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.worldcupforecast.Match#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Score</em>'.
	 * @see org.eclipse.worldcupforecast.Match#getScore()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Score();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Match#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.worldcupforecast.Match#getName()
	 * @see #getMatch()
	 * @generated
	 */
	EAttribute getMatch_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.Match#getTeam1 <em>Team1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Team1</em>'.
	 * @see org.eclipse.worldcupforecast.Match#getTeam1()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Team1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.Match#getTeam2 <em>Team2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Team2</em>'.
	 * @see org.eclipse.worldcupforecast.Match#getTeam2()
	 * @see #getMatch()
	 * @generated
	 */
	EReference getMatch_Team2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.Score <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Score</em>'.
	 * @see org.eclipse.worldcupforecast.Score
	 * @generated
	 */
	EClass getScore();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Score#getScoreTeam1 <em>Score Team1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score Team1</em>'.
	 * @see org.eclipse.worldcupforecast.Score#getScoreTeam1()
	 * @see #getScore()
	 * @generated
	 */
	EAttribute getScore_ScoreTeam1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Score#getScoreTeam2 <em>Score Team2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score Team2</em>'.
	 * @see org.eclipse.worldcupforecast.Score#getScoreTeam2()
	 * @see #getScore()
	 * @generated
	 */
	EAttribute getScore_ScoreTeam2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.Team <em>Team</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Team</em>'.
	 * @see org.eclipse.worldcupforecast.Team
	 * @generated
	 */
	EClass getTeam();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Team#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.worldcupforecast.Team#getName()
	 * @see #getTeam()
	 * @generated
	 */
	EAttribute getTeam_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Team#getPics <em>Pics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pics</em>'.
	 * @see org.eclipse.worldcupforecast.Team#getPics()
	 * @see #getTeam()
	 * @generated
	 */
	EAttribute getTeam_Pics();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Team#getPoints <em>Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Points</em>'.
	 * @see org.eclipse.worldcupforecast.Team#getPoints()
	 * @see #getTeam()
	 * @generated
	 */
	EAttribute getTeam_Points();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Team#getGoalsFor <em>Goals For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goals For</em>'.
	 * @see org.eclipse.worldcupforecast.Team#getGoalsFor()
	 * @see #getTeam()
	 * @generated
	 */
	EAttribute getTeam_GoalsFor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Team#getGoalsAgainst <em>Goals Against</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goals Against</em>'.
	 * @see org.eclipse.worldcupforecast.Team#getGoalsAgainst()
	 * @see #getTeam()
	 * @generated
	 */
	EAttribute getTeam_GoalsAgainst();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Team#getGoalDifference <em>Goal Difference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goal Difference</em>'.
	 * @see org.eclipse.worldcupforecast.Team#getGoalDifference()
	 * @see #getTeam()
	 * @generated
	 */
	EAttribute getTeam_GoalDifference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Team#getPlayed <em>Played</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Played</em>'.
	 * @see org.eclipse.worldcupforecast.Team#getPlayed()
	 * @see #getTeam()
	 * @generated
	 */
	EAttribute getTeam_Played();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.WorldCupGroup <em>World Cup Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>World Cup Group</em>'.
	 * @see org.eclipse.worldcupforecast.WorldCupGroup
	 * @generated
	 */
	EClass getWorldCupGroup();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.worldcupforecast.WorldCupGroup#getTeams <em>Teams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Teams</em>'.
	 * @see org.eclipse.worldcupforecast.WorldCupGroup#getTeams()
	 * @see #getWorldCupGroup()
	 * @generated
	 */
	EReference getWorldCupGroup_Teams();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.WorldCupGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.worldcupforecast.WorldCupGroup#getName()
	 * @see #getWorldCupGroup()
	 * @generated
	 */
	EAttribute getWorldCupGroup_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Player</em>'.
	 * @see org.eclipse.worldcupforecast.Player
	 * @generated
	 */
	EClass getPlayer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.worldcupforecast.Player#getForecastDays <em>Forecast Days</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forecast Days</em>'.
	 * @see org.eclipse.worldcupforecast.Player#getForecastDays()
	 * @see #getPlayer()
	 * @generated
	 */
	EReference getPlayer_ForecastDays();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Player#getScore <em>Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Score</em>'.
	 * @see org.eclipse.worldcupforecast.Player#getScore()
	 * @see #getPlayer()
	 * @generated
	 */
	EAttribute getPlayer_Score();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Player#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.worldcupforecast.Player#getName()
	 * @see #getPlayer()
	 * @generated
	 */
	EAttribute getPlayer_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.ValidatePlayer <em>Validate Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validate Player</em>'.
	 * @see org.eclipse.worldcupforecast.ValidatePlayer
	 * @generated
	 */
	EClass getValidatePlayer();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.ValidatePlayer#getPlayer <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Player</em>'.
	 * @see org.eclipse.worldcupforecast.ValidatePlayer#getPlayer()
	 * @see #getValidatePlayer()
	 * @generated
	 */
	EReference getValidatePlayer_Player();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.worldcupforecast.ValidatePlayer#getForecastDays <em>Forecast Days</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forecast Days</em>'.
	 * @see org.eclipse.worldcupforecast.ValidatePlayer#getForecastDays()
	 * @see #getValidatePlayer()
	 * @generated
	 */
	EReference getValidatePlayer_ForecastDays();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.FinalScore <em>Final Score</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final Score</em>'.
	 * @see org.eclipse.worldcupforecast.FinalScore
	 * @generated
	 */
	EClass getFinalScore();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.FinalScore#getPenaltyScoreTeam1 <em>Penalty Score Team1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Penalty Score Team1</em>'.
	 * @see org.eclipse.worldcupforecast.FinalScore#getPenaltyScoreTeam1()
	 * @see #getFinalScore()
	 * @generated
	 */
	EAttribute getFinalScore_PenaltyScoreTeam1();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.FinalScore#getPenaltyScoreTeam2 <em>Penalty Score Team2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Penalty Score Team2</em>'.
	 * @see org.eclipse.worldcupforecast.FinalScore#getPenaltyScoreTeam2()
	 * @see #getFinalScore()
	 * @generated
	 */
	EAttribute getFinalScore_PenaltyScoreTeam2();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.FinalScore#getWinner <em>Winner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Winner</em>'.
	 * @see org.eclipse.worldcupforecast.FinalScore#getWinner()
	 * @see #getFinalScore()
	 * @generated
	 */
	EReference getFinalScore_Winner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.MatchDay <em>Match Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Match Day</em>'.
	 * @see org.eclipse.worldcupforecast.MatchDay
	 * @generated
	 */
	EClass getMatchDay();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.worldcupforecast.MatchDay#getMatches <em>Matches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Matches</em>'.
	 * @see org.eclipse.worldcupforecast.MatchDay#getMatches()
	 * @see #getMatchDay()
	 * @generated
	 */
	EReference getMatchDay_Matches();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.ForecastDay <em>Forecast Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Forecast Day</em>'.
	 * @see org.eclipse.worldcupforecast.ForecastDay
	 * @generated
	 */
	EClass getForecastDay();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.worldcupforecast.ForecastDay#getForecasts <em>Forecasts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Forecasts</em>'.
	 * @see org.eclipse.worldcupforecast.ForecastDay#getForecasts()
	 * @see #getForecastDay()
	 * @generated
	 */
	EReference getForecastDay_Forecasts();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.Day <em>Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Day</em>'.
	 * @see org.eclipse.worldcupforecast.Day
	 * @generated
	 */
	EClass getDay();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.Day#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.worldcupforecast.Day#getDate()
	 * @see #getDay()
	 * @generated
	 */
	EAttribute getDay_Date();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.GroupStageMatch <em>Group Stage Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group Stage Match</em>'.
	 * @see org.eclipse.worldcupforecast.GroupStageMatch
	 * @generated
	 */
	EClass getGroupStageMatch();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.GroupStageMatch#getManualTeam1 <em>Manual Team1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Manual Team1</em>'.
	 * @see org.eclipse.worldcupforecast.GroupStageMatch#getManualTeam1()
	 * @see #getGroupStageMatch()
	 * @generated
	 */
	EReference getGroupStageMatch_ManualTeam1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.GroupStageMatch#getManualTeam2 <em>Manual Team2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Manual Team2</em>'.
	 * @see org.eclipse.worldcupforecast.GroupStageMatch#getManualTeam2()
	 * @see #getGroupStageMatch()
	 * @generated
	 */
	EReference getGroupStageMatch_ManualTeam2();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch <em>Other Knockout Stage Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Other Knockout Stage Match</em>'.
	 * @see org.eclipse.worldcupforecast.OtherKnockoutStageMatch
	 * @generated
	 */
	EClass getOtherKnockoutStageMatch();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getTeam1WinnerOfMatch <em>Team1 Winner Of Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Team1 Winner Of Match</em>'.
	 * @see org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getTeam1WinnerOfMatch()
	 * @see #getOtherKnockoutStageMatch()
	 * @generated
	 */
	EReference getOtherKnockoutStageMatch_Team1WinnerOfMatch();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getTeam2WinnerOfMatch <em>Team2 Winner Of Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Team2 Winner Of Match</em>'.
	 * @see org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getTeam2WinnerOfMatch()
	 * @see #getOtherKnockoutStageMatch()
	 * @generated
	 */
	EReference getOtherKnockoutStageMatch_Team2WinnerOfMatch();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getType()
	 * @see #getOtherKnockoutStageMatch()
	 * @generated
	 */
	EAttribute getOtherKnockoutStageMatch_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.ThirdPlaceMatch <em>Third Place Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Third Place Match</em>'.
	 * @see org.eclipse.worldcupforecast.ThirdPlaceMatch
	 * @generated
	 */
	EClass getThirdPlaceMatch();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.ThirdPlaceMatch#getTeam1LooserOfMatch <em>Team1 Looser Of Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Team1 Looser Of Match</em>'.
	 * @see org.eclipse.worldcupforecast.ThirdPlaceMatch#getTeam1LooserOfMatch()
	 * @see #getThirdPlaceMatch()
	 * @generated
	 */
	EReference getThirdPlaceMatch_Team1LooserOfMatch();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.ThirdPlaceMatch#getTeam2LooserOfMatch <em>Team2 Looser Of Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Team2 Looser Of Match</em>'.
	 * @see org.eclipse.worldcupforecast.ThirdPlaceMatch#getTeam2LooserOfMatch()
	 * @see #getThirdPlaceMatch()
	 * @generated
	 */
	EReference getThirdPlaceMatch_Team2LooserOfMatch();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.RoundOfSixteenMatch <em>Round Of Sixteen Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Round Of Sixteen Match</em>'.
	 * @see org.eclipse.worldcupforecast.RoundOfSixteenMatch
	 * @generated
	 */
	EClass getRoundOfSixteenMatch();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.RoundOfSixteenMatch#getTeam1WinnerOfGroup <em>Team1 Winner Of Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Team1 Winner Of Group</em>'.
	 * @see org.eclipse.worldcupforecast.RoundOfSixteenMatch#getTeam1WinnerOfGroup()
	 * @see #getRoundOfSixteenMatch()
	 * @generated
	 */
	EReference getRoundOfSixteenMatch_Team1WinnerOfGroup();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.RoundOfSixteenMatch#getTeam2RunnerUpOfGroup <em>Team2 Runner Up Of Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Team2 Runner Up Of Group</em>'.
	 * @see org.eclipse.worldcupforecast.RoundOfSixteenMatch#getTeam2RunnerUpOfGroup()
	 * @see #getRoundOfSixteenMatch()
	 * @generated
	 */
	EReference getRoundOfSixteenMatch_Team2RunnerUpOfGroup();

	/**
	 * Returns the meta object for class '{@link org.eclipse.worldcupforecast.KnockoutStageMatch <em>Knockout Stage Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Knockout Stage Match</em>'.
	 * @see org.eclipse.worldcupforecast.KnockoutStageMatch
	 * @generated
	 */
	EClass getKnockoutStageMatch();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.KnockoutStageMatch#getCalculatedTeam1 <em>Calculated Team1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Calculated Team1</em>'.
	 * @see org.eclipse.worldcupforecast.KnockoutStageMatch#getCalculatedTeam1()
	 * @see #getKnockoutStageMatch()
	 * @generated
	 */
	EReference getKnockoutStageMatch_CalculatedTeam1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.worldcupforecast.KnockoutStageMatch#getCalculatedTeam2 <em>Calculated Team2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Calculated Team2</em>'.
	 * @see org.eclipse.worldcupforecast.KnockoutStageMatch#getCalculatedTeam2()
	 * @see #getKnockoutStageMatch()
	 * @generated
	 */
	EReference getKnockoutStageMatch_CalculatedTeam2();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.worldcupforecast.MatchType <em>Match Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Match Type</em>'.
	 * @see org.eclipse.worldcupforecast.MatchType
	 * @generated
	 */
	EEnum getMatchType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WorldcupforecastFactory getWorldcupforecastFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.WorldCupForecastImpl <em>World Cup Forecast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.WorldCupForecastImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getWorldCupForecast()
		 * @generated
		 */
		EClass WORLD_CUP_FORECAST = eINSTANCE.getWorldCupForecast();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORLD_CUP_FORECAST__GROUPS = eINSTANCE.getWorldCupForecast_Groups();

		/**
		 * The meta object literal for the '<em><b>Players</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORLD_CUP_FORECAST__PLAYERS = eINSTANCE.getWorldCupForecast_Players();

		/**
		 * The meta object literal for the '<em><b>Match Days</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORLD_CUP_FORECAST__MATCH_DAYS = eINSTANCE.getWorldCupForecast_MatchDays();

		/**
		 * The meta object literal for the '<em><b>Validate Players</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORLD_CUP_FORECAST__VALIDATE_PLAYERS = eINSTANCE.getWorldCupForecast_ValidatePlayers();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.ForecastImpl <em>Forecast</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.ForecastImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getForecast()
		 * @generated
		 */
		EClass FORECAST = eINSTANCE.getForecast();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORECAST__MATCH = eINSTANCE.getForecast_Match();

		/**
		 * The meta object literal for the '<em><b>Winner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORECAST__WINNER = eINSTANCE.getForecast_Winner();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FORECAST__SCORE = eINSTANCE.getForecast_Score();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.MatchImpl <em>Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.MatchImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getMatch()
		 * @generated
		 */
		EClass MATCH = eINSTANCE.getMatch();

		/**
		 * The meta object literal for the '<em><b>Hours</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__HOURS = eINSTANCE.getMatch_Hours();

		/**
		 * The meta object literal for the '<em><b>Minutes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__MINUTES = eINSTANCE.getMatch_Minutes();

		/**
		 * The meta object literal for the '<em><b>Coefficient</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__COEFFICIENT = eINSTANCE.getMatch_Coefficient();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__SCORE = eINSTANCE.getMatch_Score();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MATCH__NAME = eINSTANCE.getMatch_Name();

		/**
		 * The meta object literal for the '<em><b>Team1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__TEAM1 = eINSTANCE.getMatch_Team1();

		/**
		 * The meta object literal for the '<em><b>Team2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH__TEAM2 = eINSTANCE.getMatch_Team2();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.ScoreImpl <em>Score</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.ScoreImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getScore()
		 * @generated
		 */
		EClass SCORE = eINSTANCE.getScore();

		/**
		 * The meta object literal for the '<em><b>Score Team1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE__SCORE_TEAM1 = eINSTANCE.getScore_ScoreTeam1();

		/**
		 * The meta object literal for the '<em><b>Score Team2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCORE__SCORE_TEAM2 = eINSTANCE.getScore_ScoreTeam2();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.TeamImpl <em>Team</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.TeamImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getTeam()
		 * @generated
		 */
		EClass TEAM = eINSTANCE.getTeam();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM__NAME = eINSTANCE.getTeam_Name();

		/**
		 * The meta object literal for the '<em><b>Pics</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM__PICS = eINSTANCE.getTeam_Pics();

		/**
		 * The meta object literal for the '<em><b>Points</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM__POINTS = eINSTANCE.getTeam_Points();

		/**
		 * The meta object literal for the '<em><b>Goals For</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM__GOALS_FOR = eINSTANCE.getTeam_GoalsFor();

		/**
		 * The meta object literal for the '<em><b>Goals Against</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM__GOALS_AGAINST = eINSTANCE.getTeam_GoalsAgainst();

		/**
		 * The meta object literal for the '<em><b>Goal Difference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM__GOAL_DIFFERENCE = eINSTANCE.getTeam_GoalDifference();

		/**
		 * The meta object literal for the '<em><b>Played</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEAM__PLAYED = eINSTANCE.getTeam_Played();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.WorldCupGroupImpl <em>World Cup Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.WorldCupGroupImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getWorldCupGroup()
		 * @generated
		 */
		EClass WORLD_CUP_GROUP = eINSTANCE.getWorldCupGroup();

		/**
		 * The meta object literal for the '<em><b>Teams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WORLD_CUP_GROUP__TEAMS = eINSTANCE.getWorldCupGroup_Teams();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WORLD_CUP_GROUP__NAME = eINSTANCE.getWorldCupGroup_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.PlayerImpl <em>Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.PlayerImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getPlayer()
		 * @generated
		 */
		EClass PLAYER = eINSTANCE.getPlayer();

		/**
		 * The meta object literal for the '<em><b>Forecast Days</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYER__FORECAST_DAYS = eINSTANCE.getPlayer_ForecastDays();

		/**
		 * The meta object literal for the '<em><b>Score</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAYER__SCORE = eINSTANCE.getPlayer_Score();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAYER__NAME = eINSTANCE.getPlayer_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.ValidatePlayerImpl <em>Validate Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.ValidatePlayerImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getValidatePlayer()
		 * @generated
		 */
		EClass VALIDATE_PLAYER = eINSTANCE.getValidatePlayer();

		/**
		 * The meta object literal for the '<em><b>Player</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATE_PLAYER__PLAYER = eINSTANCE.getValidatePlayer_Player();

		/**
		 * The meta object literal for the '<em><b>Forecast Days</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATE_PLAYER__FORECAST_DAYS = eINSTANCE.getValidatePlayer_ForecastDays();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.FinalScoreImpl <em>Final Score</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.FinalScoreImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getFinalScore()
		 * @generated
		 */
		EClass FINAL_SCORE = eINSTANCE.getFinalScore();

		/**
		 * The meta object literal for the '<em><b>Penalty Score Team1</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FINAL_SCORE__PENALTY_SCORE_TEAM1 = eINSTANCE.getFinalScore_PenaltyScoreTeam1();

		/**
		 * The meta object literal for the '<em><b>Penalty Score Team2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FINAL_SCORE__PENALTY_SCORE_TEAM2 = eINSTANCE.getFinalScore_PenaltyScoreTeam2();

		/**
		 * The meta object literal for the '<em><b>Winner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FINAL_SCORE__WINNER = eINSTANCE.getFinalScore_Winner();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.MatchDayImpl <em>Match Day</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.MatchDayImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getMatchDay()
		 * @generated
		 */
		EClass MATCH_DAY = eINSTANCE.getMatchDay();

		/**
		 * The meta object literal for the '<em><b>Matches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MATCH_DAY__MATCHES = eINSTANCE.getMatchDay_Matches();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.ForecastDayImpl <em>Forecast Day</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.ForecastDayImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getForecastDay()
		 * @generated
		 */
		EClass FORECAST_DAY = eINSTANCE.getForecastDay();

		/**
		 * The meta object literal for the '<em><b>Forecasts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORECAST_DAY__FORECASTS = eINSTANCE.getForecastDay_Forecasts();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.DayImpl <em>Day</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.DayImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getDay()
		 * @generated
		 */
		EClass DAY = eINSTANCE.getDay();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DAY__DATE = eINSTANCE.getDay_Date();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.GroupStageMatchImpl <em>Group Stage Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.GroupStageMatchImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getGroupStageMatch()
		 * @generated
		 */
		EClass GROUP_STAGE_MATCH = eINSTANCE.getGroupStageMatch();

		/**
		 * The meta object literal for the '<em><b>Manual Team1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP_STAGE_MATCH__MANUAL_TEAM1 = eINSTANCE.getGroupStageMatch_ManualTeam1();

		/**
		 * The meta object literal for the '<em><b>Manual Team2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP_STAGE_MATCH__MANUAL_TEAM2 = eINSTANCE.getGroupStageMatch_ManualTeam2();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.OtherKnockoutStageMatchImpl <em>Other Knockout Stage Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.OtherKnockoutStageMatchImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getOtherKnockoutStageMatch()
		 * @generated
		 */
		EClass OTHER_KNOCKOUT_STAGE_MATCH = eINSTANCE.getOtherKnockoutStageMatch();

		/**
		 * The meta object literal for the '<em><b>Team1 Winner Of Match</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OTHER_KNOCKOUT_STAGE_MATCH__TEAM1_WINNER_OF_MATCH = eINSTANCE.getOtherKnockoutStageMatch_Team1WinnerOfMatch();

		/**
		 * The meta object literal for the '<em><b>Team2 Winner Of Match</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OTHER_KNOCKOUT_STAGE_MATCH__TEAM2_WINNER_OF_MATCH = eINSTANCE.getOtherKnockoutStageMatch_Team2WinnerOfMatch();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OTHER_KNOCKOUT_STAGE_MATCH__TYPE = eINSTANCE.getOtherKnockoutStageMatch_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.ThirdPlaceMatchImpl <em>Third Place Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.ThirdPlaceMatchImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getThirdPlaceMatch()
		 * @generated
		 */
		EClass THIRD_PLACE_MATCH = eINSTANCE.getThirdPlaceMatch();

		/**
		 * The meta object literal for the '<em><b>Team1 Looser Of Match</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THIRD_PLACE_MATCH__TEAM1_LOOSER_OF_MATCH = eINSTANCE.getThirdPlaceMatch_Team1LooserOfMatch();

		/**
		 * The meta object literal for the '<em><b>Team2 Looser Of Match</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference THIRD_PLACE_MATCH__TEAM2_LOOSER_OF_MATCH = eINSTANCE.getThirdPlaceMatch_Team2LooserOfMatch();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.RoundOfSixteenMatchImpl <em>Round Of Sixteen Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.RoundOfSixteenMatchImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getRoundOfSixteenMatch()
		 * @generated
		 */
		EClass ROUND_OF_SIXTEEN_MATCH = eINSTANCE.getRoundOfSixteenMatch();

		/**
		 * The meta object literal for the '<em><b>Team1 Winner Of Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND_OF_SIXTEEN_MATCH__TEAM1_WINNER_OF_GROUP = eINSTANCE.getRoundOfSixteenMatch_Team1WinnerOfGroup();

		/**
		 * The meta object literal for the '<em><b>Team2 Runner Up Of Group</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUND_OF_SIXTEEN_MATCH__TEAM2_RUNNER_UP_OF_GROUP = eINSTANCE.getRoundOfSixteenMatch_Team2RunnerUpOfGroup();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.impl.KnockoutStageMatchImpl <em>Knockout Stage Match</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.impl.KnockoutStageMatchImpl
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getKnockoutStageMatch()
		 * @generated
		 */
		EClass KNOCKOUT_STAGE_MATCH = eINSTANCE.getKnockoutStageMatch();

		/**
		 * The meta object literal for the '<em><b>Calculated Team1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM1 = eINSTANCE.getKnockoutStageMatch_CalculatedTeam1();

		/**
		 * The meta object literal for the '<em><b>Calculated Team2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KNOCKOUT_STAGE_MATCH__CALCULATED_TEAM2 = eINSTANCE.getKnockoutStageMatch_CalculatedTeam2();

		/**
		 * The meta object literal for the '{@link org.eclipse.worldcupforecast.MatchType <em>Match Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.worldcupforecast.MatchType
		 * @see org.eclipse.worldcupforecast.impl.WorldcupforecastPackageImpl#getMatchType()
		 * @generated
		 */
		EEnum MATCH_TYPE = eINSTANCE.getMatchType();

	}

} //WorldcupforecastPackage

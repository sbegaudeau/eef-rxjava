/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *       Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.eclipse.worldcupforecast.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * 
 * 
 */
public class WorldcupforecastPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 * 
	 */
	public WorldcupforecastPackagePropertiesEditionProvider() {
		super();
		append(createForecastPropertiesEditionProvider());
		append(createTeamPropertiesEditionProvider());
		append(createWorldCupGroupPropertiesEditionProvider());
		append(createPlayerPropertiesEditionProvider());
		append(createFinalScorePropertiesEditionProvider());
		append(createMatchDayPropertiesEditionProvider());
		append(createForecastDayPropertiesEditionProvider());
		append(createWorldCupForecastPropertiesEditionProvider());
		append(createGroupStageMatchPropertiesEditionProvider());
		append(createOtherKnockoutStageMatchPropertiesEditionProvider());
		append(createRoundOfSixteenMatchPropertiesEditionProvider());
		append(createThirdPlaceMatchPropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Forecast instances.
	 * 
	 */
	protected ForecastPropertiesEditionProvider forecastPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Forecast
	 * 
	 */
	public ForecastPropertiesEditionProvider createForecastPropertiesEditionProvider() {
		if (forecastPropertiesEditionProvider == null)
			forecastPropertiesEditionProvider = new ForecastPropertiesEditionProvider();
		return forecastPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Team instances.
	 * 
	 */
	protected TeamPropertiesEditionProvider teamPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Team
	 * 
	 */
	public TeamPropertiesEditionProvider createTeamPropertiesEditionProvider() {
		if (teamPropertiesEditionProvider == null)
			teamPropertiesEditionProvider = new TeamPropertiesEditionProvider();
		return teamPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * WorldCupGroup instances.
	 * 
	 */
	protected WorldCupGroupPropertiesEditionProvider worldCupGroupPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a WorldCupGroup
	 * 
	 */
	public WorldCupGroupPropertiesEditionProvider createWorldCupGroupPropertiesEditionProvider() {
		if (worldCupGroupPropertiesEditionProvider == null)
			worldCupGroupPropertiesEditionProvider = new WorldCupGroupPropertiesEditionProvider();
		return worldCupGroupPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Player instances.
	 * 
	 */
	protected PlayerPropertiesEditionProvider playerPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Player
	 * 
	 */
	public PlayerPropertiesEditionProvider createPlayerPropertiesEditionProvider() {
		if (playerPropertiesEditionProvider == null)
			playerPropertiesEditionProvider = new PlayerPropertiesEditionProvider();
		return playerPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * FinalScore instances.
	 * 
	 */
	protected FinalScorePropertiesEditionProvider finalScorePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a FinalScore
	 * 
	 */
	public FinalScorePropertiesEditionProvider createFinalScorePropertiesEditionProvider() {
		if (finalScorePropertiesEditionProvider == null)
			finalScorePropertiesEditionProvider = new FinalScorePropertiesEditionProvider();
		return finalScorePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * MatchDay instances.
	 * 
	 */
	protected MatchDayPropertiesEditionProvider matchDayPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a MatchDay
	 * 
	 */
	public MatchDayPropertiesEditionProvider createMatchDayPropertiesEditionProvider() {
		if (matchDayPropertiesEditionProvider == null)
			matchDayPropertiesEditionProvider = new MatchDayPropertiesEditionProvider();
		return matchDayPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ForecastDay instances.
	 * 
	 */
	protected ForecastDayPropertiesEditionProvider forecastDayPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ForecastDay
	 * 
	 */
	public ForecastDayPropertiesEditionProvider createForecastDayPropertiesEditionProvider() {
		if (forecastDayPropertiesEditionProvider == null)
			forecastDayPropertiesEditionProvider = new ForecastDayPropertiesEditionProvider();
		return forecastDayPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * WorldCupForecast instances.
	 * 
	 */
	protected WorldCupForecastPropertiesEditionProvider worldCupForecastPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a WorldCupForecast
	 * 
	 */
	public WorldCupForecastPropertiesEditionProvider createWorldCupForecastPropertiesEditionProvider() {
		if (worldCupForecastPropertiesEditionProvider == null)
			worldCupForecastPropertiesEditionProvider = new WorldCupForecastPropertiesEditionProvider();
		return worldCupForecastPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * GroupStageMatch instances.
	 * 
	 */
	protected GroupStageMatchPropertiesEditionProvider groupStageMatchPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a GroupStageMatch
	 * 
	 */
	public GroupStageMatchPropertiesEditionProvider createGroupStageMatchPropertiesEditionProvider() {
		if (groupStageMatchPropertiesEditionProvider == null)
			groupStageMatchPropertiesEditionProvider = new GroupStageMatchPropertiesEditionProvider();
		return groupStageMatchPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * OtherKnockoutStageMatch instances.
	 * 
	 */
	protected OtherKnockoutStageMatchPropertiesEditionProvider otherKnockoutStageMatchPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a OtherKnockoutStageMatch
	 * 
	 */
	public OtherKnockoutStageMatchPropertiesEditionProvider createOtherKnockoutStageMatchPropertiesEditionProvider() {
		if (otherKnockoutStageMatchPropertiesEditionProvider == null)
			otherKnockoutStageMatchPropertiesEditionProvider = new OtherKnockoutStageMatchPropertiesEditionProvider();
		return otherKnockoutStageMatchPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * RoundOfSixteenMatch instances.
	 * 
	 */
	protected RoundOfSixteenMatchPropertiesEditionProvider roundOfSixteenMatchPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a RoundOfSixteenMatch
	 * 
	 */
	public RoundOfSixteenMatchPropertiesEditionProvider createRoundOfSixteenMatchPropertiesEditionProvider() {
		if (roundOfSixteenMatchPropertiesEditionProvider == null)
			roundOfSixteenMatchPropertiesEditionProvider = new RoundOfSixteenMatchPropertiesEditionProvider();
		return roundOfSixteenMatchPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ThirdPlaceMatch instances.
	 * 
	 */
	protected ThirdPlaceMatchPropertiesEditionProvider thirdPlaceMatchPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ThirdPlaceMatch
	 * 
	 */
	public ThirdPlaceMatchPropertiesEditionProvider createThirdPlaceMatchPropertiesEditionProvider() {
		if (thirdPlaceMatchPropertiesEditionProvider == null)
			thirdPlaceMatchPropertiesEditionProvider = new ThirdPlaceMatchPropertiesEditionProvider();
		return thirdPlaceMatchPropertiesEditionProvider;
	}

}

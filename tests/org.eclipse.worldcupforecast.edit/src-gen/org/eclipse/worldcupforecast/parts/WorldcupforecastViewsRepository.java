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
package org.eclipse.worldcupforecast.parts;

/**
 * 
 * 
 */
public class WorldcupforecastViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * Forecast view descriptor
	 * 
	 */
	public static class Forecast {
		
		public static String match = "worldcupforecast::Forecast::match";
		
	
		
		public static String scoreTeam1 = "worldcupforecast::Forecast::scoreTeam1";
		
		
		public static String scoreTeam2 = "worldcupforecast::Forecast::scoreTeam2";
		
		
		public static String winner = "worldcupforecast::Forecast::winner";
		
	
		
		public static String score = "worldcupforecast::Forecast::score";
		
	
	}

	/**
	 * Team view descriptor
	 * 
	 */
	public static class Team {
		
		public static String name = "worldcupforecast::Team::name";
		
		
		public static String pics = "worldcupforecast::Team::pics";
		
	
		
		public static String points = "worldcupforecast::Team::Points";
		
		
		public static String goalsFor = "worldcupforecast::Team::Goals For";
		
		
		public static String goalsAgainst = "worldcupforecast::Team::Goals Against";
		
		
		public static String goalDifference = "worldcupforecast::Team::Goal Difference";
		
	
	}

	/**
	 * FinalScore view descriptor
	 * 
	 */
	public static class FinalScore {
		
		public static String scoreTeam1 = "worldcupforecast::FinalScore::scoreTeam1";
		
		
		public static String scoreTeam2 = "worldcupforecast::FinalScore::scoreTeam2";
		
		
		public static String penaltyScoreTeam1 = "worldcupforecast::FinalScore::penaltyScoreTeam1";
		
		
		public static String penaltyScoreTeam2 = "worldcupforecast::FinalScore::penaltyScoreTeam2";
		
	
	}

	/**
	 * MatchDay view descriptor
	 * 
	 */
	public static class MatchDay {
		
		public static String date = "worldcupforecast::MatchDay::date";
		
		
		public static String matches = "worldcupforecast::MatchDay::matches";
		
	
	}

	/**
	 * ForecastDay view descriptor
	 * 
	 */
	public static class ForecastDay {
		
		public static String date = "worldcupforecast::ForecastDay::date";
		
		
		public static String forecasts = "worldcupforecast::ForecastDay::forecasts";
		
	
	}

	/**
	 * WorldCupGroup view descriptor
	 * 
	 */
	public static class WorldCupGroup {
		
		public static String name = "worldcupforecast::WorldCupGroup::name";
		
		
		public static String teams = "worldcupforecast::WorldCupGroup::teams";
		
	
	}

	/**
	 * WorldCupForecastGroup view descriptor
	 * 
	 */
	public static class WorldCupForecastGroup {
	
	public static String group = "worldcupforecast::WorldCupForecastGroup::group";
	
	}

	/**
	 * WorldCupForecastPLayer view descriptor
	 * 
	 */
	public static class WorldCupForecastPLayer {
	
	public static String player = "worldcupforecast::WorldCupForecastPLayer::player";
	
	}

	/**
	 * WorldCupForecastMatchDay view descriptor
	 * 
	 */
	public static class WorldCupForecastMatchDay {
	
	public static String game = "worldcupforecast::WorldCupForecastMatchDay::game";
	
	}

	/**
	 * Player view descriptor
	 * 
	 */
	public static class Player {
	
	public static String name = "worldcupforecast::Player::name";
	
	
	public static String score = "worldcupforecast::Player::score";
	
	}

	/**
	 * GroupeStageMatch view descriptor
	 * 
	 */
	public static class GroupeStageMatch {
		
		public static String hours = "worldcupforecast::GroupeStageMatch::hours";
		
		
		public static String minutes = "worldcupforecast::GroupeStageMatch::minutes";
		
		
		public static String coefficient = "worldcupforecast::GroupeStageMatch::coefficient";
		
		
		public static String team1 = "worldcupforecast::GroupeStageMatch::Team 1";
		
		
		public static String team2 = "worldcupforecast::GroupeStageMatch::Team 2";
		
	
	}

	/**
	 * OtherKnockoutStageGame view descriptor
	 * 
	 */
	public static class OtherKnockoutStageGame {
		
		public static String hours = "worldcupforecast::OtherKnockoutStageGame::hours";
		
		
		public static String minutes = "worldcupforecast::OtherKnockoutStageGame::minutes";
		
		
		public static String coefficient = "worldcupforecast::OtherKnockoutStageGame::coefficient";
		
		
		public static String team1WinnerOfMatch = "worldcupforecast::OtherKnockoutStageGame::Team1 winner of match";
		
		
		public static String team2WinnerOfMatch = "worldcupforecast::OtherKnockoutStageGame::Team2 winner of match";
		
		
		public static String team1 = "worldcupforecast::OtherKnockoutStageGame::Team 1";
		
		
		public static String team2 = "worldcupforecast::OtherKnockoutStageGame::Team 2";
		
		
		public static String type = "worldcupforecast::OtherKnockoutStageGame::Type";
		
	
	}

	/**
	 * WorldCupForecastPlayersRating view descriptor
	 * 
	 */
	public static class WorldCupForecastPlayersRating {
	
	public static String rating = "worldcupforecast::WorldCupForecastPlayersRating::rating";
	
	}

	/**
	 * RoundOfSixteenMatch view descriptor
	 * 
	 */
	public static class RoundOfSixteenMatch {
		
		public static String hours = "worldcupforecast::RoundOfSixteenMatch::hours";
		
		
		public static String minutes = "worldcupforecast::RoundOfSixteenMatch::minutes";
		
		
		public static String coefficient = "worldcupforecast::RoundOfSixteenMatch::coefficient";
		
		
		public static String team1WinnerOfGroup = "worldcupforecast::RoundOfSixteenMatch::Team1 winner of group";
		
		
		public static String team2RunnerupOfGroup = "worldcupforecast::RoundOfSixteenMatch::Team2 runner-up of group";
		
		
		public static String team1 = "worldcupforecast::RoundOfSixteenMatch::Team 1";
		
		
		public static String team2 = "worldcupforecast::RoundOfSixteenMatch::Team 2";
		
	
	}

	/**
	 * ThirdPlaceMatch view descriptor
	 * 
	 */
	public static class ThirdPlaceMatch {
		
		public static String hours = "worldcupforecast::ThirdPlaceMatch::hours";
		
		
		public static String minutes = "worldcupforecast::ThirdPlaceMatch::minutes";
		
		
		public static String coefficient = "worldcupforecast::ThirdPlaceMatch::coefficient";
		
		
		public static String team1LooserOfMatch = "worldcupforecast::ThirdPlaceMatch::Team1 looser of match";
		
		
		public static String team2LooserOfMatch = "worldcupforecast::ThirdPlaceMatch::Team2 looser of match";
		
		
		public static String team1 = "worldcupforecast::ThirdPlaceMatch::Team 1";
		
		
		public static String team2 = "worldcupforecast::ThirdPlaceMatch::Team 2";
		
		
		public static String type = "worldcupforecast::ThirdPlaceMatch::Type";
		
	
	}

}

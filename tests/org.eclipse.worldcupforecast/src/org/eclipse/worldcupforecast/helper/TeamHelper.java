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
package org.eclipse.worldcupforecast.helper;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.worldcupforecast.FinalScore;
import org.eclipse.worldcupforecast.GroupStageMatch;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.MatchDay;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldCupForecast;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class TeamHelper {
	
	
	public static int VICTORY_POINTS = 3;
	
	public static int DRAW_POINTS = 1;
	
	public static int SHUTOUT_POINTS = 0;
	
	
	/**
	 * 
	 * @param team
	 * @return the number of points (3 for victory, 1 for draw or 0)
	 */
	public static int getNumberOfPoints(Team team) {
		WorldCupForecast root = (WorldCupForecast) EcoreUtil.getRootContainer(team);
		int score = 0;
		for(MatchDay matchDay : root.getMatchDays()) {
			
			for(Match match : matchDay.getMatches()) {
				
				score += calculatePoints(team, match);
			}
		}
		return score;
	}

	private static int calculatePoints(Team team, Match match) {
		if(match instanceof GroupStageMatch) {
			Team team1 = match.getTeam1();
			Team team2 = match.getTeam2();
			
			if((team1 != null && team2 != null) && (team1.equals(team) || team2.equals(team))) {
				FinalScore finalScore = match.getScore();
				
				if(finalScore != null) {
					
					Team winner = finalScore.getWinner();
					
					if(winner == null) {
						return DRAW_POINTS;
					}
					else {
						if(winner.equals(team)) {
							return VICTORY_POINTS;
						}
						else {
							return SHUTOUT_POINTS;
						}
					}
				}
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @param team
	 * @return
	 */
	public static int getGoalsFor(Team team) {
		int goalsFor = 0;
		
		WorldCupForecast root = (WorldCupForecast) EcoreUtil.getRootContainer(team);
		for(MatchDay matchDay : root.getMatchDays()) {
			
			for(Match match : matchDay.getMatches()) {
				
				goalsFor += calculateGoalsFor(team, match);
			}
		}
		
		return goalsFor;
	}
	
	/**
	 * 
	 * @param team
	 * @param match
	 * @return
	 */
	private static int calculateGoalsFor(Team team, Match match) {
		if(match instanceof GroupStageMatch) {
			Team team1 = match.getTeam1();
			Team team2 = match.getTeam2();
			
			if((team1 != null && team2 != null) && (team1.equals(team) || team2.equals(team))) {
				
				FinalScore finalScore = match.getScore();
				
				if(finalScore != null) {
					
					if(team1.equals(team))
						return finalScore.getScoreTeam1();
					else
						return finalScore.getScoreTeam2();
				}
			}
		}
		return 0;
	}
	
	

	/**
	 * 
	 * @param team
	 * @return
	 */
	public static int getGoalsAgainst(Team team) {
		int goalsAgainst = 0;
		
		WorldCupForecast root = (WorldCupForecast) EcoreUtil.getRootContainer(team);
		for(MatchDay matchDay : root.getMatchDays()) {
			
			for(Match match : matchDay.getMatches()) {
				
				goalsAgainst += calculateGoalsAgainst(team, match);
			}
		}
		
		return goalsAgainst;
	}
	
	/**
	 * 
	 * @param team
	 * @param match
	 * @return
	 */
	private static int calculateGoalsAgainst(Team team, Match match) {
		if(match instanceof GroupStageMatch) {
			Team team1 = match.getTeam1();
			Team team2 = match.getTeam2();
			
			if((team1 != null && team2 != null) && (team1.equals(team) || team2.equals(team))) {
				
				FinalScore finalScore = match.getScore();
				
				if(finalScore != null) {
					
					if(team1.equals(team))
						return finalScore.getScoreTeam2();
					else
						return finalScore.getScoreTeam1();
				}
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @param team
	 * @return
	 */
	public static int getGoalDifference(Team team) {
		
		return getGoalsFor(team) - getGoalsAgainst(team);
	}
}

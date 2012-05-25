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
package org.eclipse.worldcupforecast.helper;

import org.eclipse.worldcupforecast.FinalScore;
import org.eclipse.worldcupforecast.Forecast;
import org.eclipse.worldcupforecast.GroupStageMatch;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.Team;

/**
 * Forecast helper class
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ForecastHelper {

	/**
	 * provide the forecast score from the game final score and game coefficient
	 * @param  the forecast
	 * @return the forecast score
	 */
	
	public static int GOOD_WINNER_POINTS = 2;
	public static int GOOD_SCORE_FOR_ONE_TEAM_POINTS = 1;
	
	public static int forecastScore(Forecast forecast) {
		
		int totalScore = 0;
		Match currentGame = forecast.getMatch();
		if(currentGame != null) {
			FinalScore finalScore = currentGame.getScore();
			if(finalScore != null) {
				
				//begin score calculate
				//calculate good winner
				if(hasGoodWinner(finalScore,forecast)) {
					totalScore += GOOD_WINNER_POINTS;
				}
				
				//calculate good team1 score
				if(finalScore.getScoreTeam1() == forecast.getScoreTeam1()) {
					totalScore += GOOD_SCORE_FOR_ONE_TEAM_POINTS;
				}
				
				//calculate good team2 score
				if(finalScore.getScoreTeam2() == forecast.getScoreTeam2()) {
					totalScore += GOOD_SCORE_FOR_ONE_TEAM_POINTS;
				}
				return totalScore * currentGame.getCoefficient();
			}
		}
		return totalScore;
	}
	
	/**
	 * provide the forecast winner team. In case of draw on "knockout stage" game, return the team declared as winner by the player
	 * @param forecast
	 * @return the winner or null whether draw
	 */
	public static Team getForecastWinner(Forecast forecast) {	

		//team 1 win
		if(forecast.getScoreTeam1() > forecast.getScoreTeam2()) {
			return forecast.getMatch().getTeam1();
		}
		
		//team 2 win
		else if(forecast.getScoreTeam1() < forecast.getScoreTeam2()) {
			return forecast.getMatch().getTeam2();
		}
		
		//draw on regular time
		else {
			//in case of group stage game, there is no winner
			if(forecast.getMatch() instanceof GroupStageMatch) {
				return null;
			}
			
			else {
				return forecast.getWinner();
			}
		}
	}
	
	/**
	 * compare whether winner from final score match the forecast winner
	 * @param finalScore
	 * @param forecast
	 * @return
	 */
	public static boolean hasGoodWinner(FinalScore finalScore, Forecast forecast) {
		
		Team finalScoreWinner = finalScore.getWinner();
		
		if(finalScoreWinner != null) {
			return finalScore.getWinner().equals(ForecastHelper.getForecastWinner(forecast));
		}
		return getForecastWinner(forecast) == null;
		
	}
}

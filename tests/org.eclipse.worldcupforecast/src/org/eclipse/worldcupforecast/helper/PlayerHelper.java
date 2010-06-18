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


import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.worldcupforecast.FinalScore;
import org.eclipse.worldcupforecast.Forecast;
import org.eclipse.worldcupforecast.ForecastDay;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.ValidatePlayer;
import org.eclipse.worldcupforecast.WorldCupForecast;
import org.eclipse.worldcupforecast.utils.WorldCupForecastHelper;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PlayerHelper {
	
	/**
	 * 
	 * @param player
	 * @return player total score
	 */
	public static int getTotalScore(Player player) {
		int totalScore = 0;
		if(getValidatePlayer(player) != null) {
			for(ForecastDay forecastDay : getValidatePlayer(player).getForecastDays()) {
				
				for(Forecast forecast : forecastDay.getForecasts()) {
					totalScore += forecast.getScore();
	
				}
			}
		}
		return totalScore;
	}
	
	public static int getGoodWinnerForecastNumber(Player player) {
		int result = 0;
		if(getValidatePlayer(player) != null) {
			for(ForecastDay forecastDay : getValidatePlayer(player).getForecastDays()) {
				
				for(Forecast forecast : forecastDay.getForecasts()) {
					Match game = forecast.getMatch();
					if(game != null) {
						FinalScore score = game.getScore();
						if(score != null) {
							if(ForecastHelper.hasGoodWinner(score, forecast)) {
								result += 1;
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	public static Float getGoodWinnerForecastNumberPercent(Player player) {	
		
		int forecastsNumber = 0;
		if(getValidatePlayer(player) != null) {
			for(ForecastDay forecastDay : getValidatePlayer(player).getForecastDays()) {
				if(forecastDay != null) {
					for(Forecast forecast : forecastDay.getForecasts()) {
						if(forecast != null) {
							if(forecast.getMatch() != null) {
								if(forecast.getMatch().getScore() != null) {
									forecastsNumber += 1;
								}
							}
							
						}
					}
				}
			}
		
		}
		if(forecastsNumber > 0) {
			return new Float((((float) player.goodForecastNumber()) / forecastsNumber) * 100);
		}
		else
			return new Float(0);
	
	}
	
	
	
	public static int getPerfectForecastNumber(Player player) {
		int result = 0;
		if(getValidatePlayer(player) != null) {
			for(ForecastDay forecastDay : getValidatePlayer(player).getForecastDays()) {
				
				for(Forecast forecast : forecastDay.getForecasts()) {
					Match game = forecast.getMatch();
					if(game != null) {
						if((forecast.getScore() / game.getCoefficient()) == ((ForecastHelper.GOOD_SCORE_FOR_ONE_TEAM_POINTS * 2) + ForecastHelper.GOOD_WINNER_POINTS)) {
							result += 1;
						}
					}
				}
			}
		}
		return result;
	}
	
	
	public static Float getPerfectForecastNumberPercent(Player player) {
	
		int forecastsNumber = 0;
		if(getValidatePlayer(player) != null) {
			for(ForecastDay forecastDay : getValidatePlayer(player).getForecastDays()) {
				if(forecastDay != null) {
					for(Forecast forecast : forecastDay.getForecasts()) {
						if(forecast != null) {
							if(forecast.getMatch() != null) {
								if(forecast.getMatch().getScore() != null) {
									forecastsNumber += 1;
								}
							}
							
						}
					}
				}
			}
		}
		if(forecastsNumber > 0) {
			return new Float((((float) player.perfectForecastsNumber()) / forecastsNumber) * 100);
		}
		else
			return new Float(0);
	
}
	
	

	
	private static ValidatePlayer getValidatePlayer(Player player) {
		Resource resource = player.eResource();
		if(resource != null) {
			WorldCupForecast worldCupForecast = WorldCupForecastHelper.findFirstWorldCupForecastInstance(resource.getResourceSet());
			
			for(ValidatePlayer validatePlayer : worldCupForecast.getValidatePlayers()) {
				Player player2 = validatePlayer.getPlayer();
				if(player2.getName().equals(player.getName())) {
					return validatePlayer;
				}
			}
		}
		return null;
	}
}

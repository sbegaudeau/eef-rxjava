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

import java.util.List;

import org.eclipse.worldcupforecast.FinalScore;
import org.eclipse.worldcupforecast.GroupStageMatch;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.OtherKnockoutStageMatch;
import org.eclipse.worldcupforecast.RoundOfSixteenMatch;
import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.ThirdPlaceMatch;
import org.eclipse.worldcupforecast.WorldCupGroup;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class MatchHelper {

	/**
	 * 
	 * @param match
	 * @return
	 */
	public static Team getCalculatedTeam1(OtherKnockoutStageMatch match) {
		Match matchTemp = match.getTeam1WinnerOfMatch();
		if(matchTemp != null) {
			FinalScore finalScore = matchTemp.getScore();
			if(finalScore != null) {
				return finalScore.getWinner();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param match
	 * @return
	 */
	public static Team getCalculatedTeam2(OtherKnockoutStageMatch match) {
		Match matchTemp = match.getTeam2WinnerOfMatch();
		if(matchTemp != null) {
			FinalScore finalScore = matchTemp.getScore();
			if(finalScore != null) {
				return finalScore.getWinner();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param match
	 * @return
	 */
	public static Team getCalculatedTeam1(ThirdPlaceMatch match) {
		Match matchTemp = match.getTeam1LooserOfMatch();
		return getMatchLooser(matchTemp);
	}

	private static Team getMatchLooser(Match match) {
		if(match != null) {
			FinalScore finalScore = match.getScore();
			if(finalScore != null) {
				Team team = match.getTeam1();
				if(team != null) {
					Team winner = finalScore.getWinner();
					if(winner != null) {
						if(team.equals(winner)) {
							return match.getTeam2();
						}
						return team;
					}
				}
				//return finalScore.getWinner();
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param match
	 * @return
	 */
	public static Team getCalculatedTeam2(ThirdPlaceMatch match) {
		Match matchTemp = match.getTeam2LooserOfMatch();
		return getMatchLooser(matchTemp);
	}
	
	/**
	 * 
	 * @param match
	 * @return
	 */
	public static Team getCalculatedTeam1(RoundOfSixteenMatch match) {
		WorldCupGroup group = match.getTeam1WinnerOfGroup();
		if(group != null) {
			List<Team> teams = GroupHelper.getSortedTeamList(group);
			if(teams.size() > 0) {
				return teams.get(teams.size() - 1);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param match
	 * @return
	 */
	public static Team getCalculatedTeam2(RoundOfSixteenMatch match) {
		WorldCupGroup group = match.getTeam2RunnerUpOfGroup();
		if(group != null) {
			List<Team> teams = GroupHelper.getSortedTeamList(group);
			if(teams.size() > 1) {
				return teams.get(teams.size() - 2);
			}
		}
		return null;
	}
	
	public static WorldCupGroup getMatchGroup(GroupStageMatch match) {
		
		Team team = match.getTeam1();
		if(team != null) {
			if((WorldCupGroup) team.eContainer() instanceof WorldCupGroup) {
				return (WorldCupGroup) team.eContainer();
			}
		}
		
		return null;
	}
	
}

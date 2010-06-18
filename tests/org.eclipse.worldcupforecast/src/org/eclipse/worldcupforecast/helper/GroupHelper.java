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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.worldcupforecast.Team;
import org.eclipse.worldcupforecast.WorldCupGroup;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class GroupHelper {

	
	public static void sort(List<Team> list) {
		Collections.sort(list, new Comparator<Team>() {

			public int compare(Team o1, Team o2) {
				return GroupHelper.compare(o1, o2);
			}
			
		});
	}
	
	/**
	 * Sort the teams as the World Cup rule for groups rank
	 * @param group
	 */
	public static List<Team> getSortedTeamList(WorldCupGroup group) {
		List<Team> teams = new ArrayList<Team>();
		for(Team team : group.getTeams()) {
			teams.add(team);
		}
		Collections.sort(teams, new Comparator<Team>() {

			public int compare(Team o1, Team o2) {
				return GroupHelper.compare(o1, o2);
			}
			
		});
		return teams;
	}
	
	/**
	 * 
	 * @param team1
	 * @param team2
	 * @return -1, 0 or 1 as team1 is lesser than team2, or team1 equals to team2 or team1 is greater than team2
	 */
	public static int compare(Team team1, Team team2) {
		
		if(team1.getPoints() > team2.getPoints()) {
			return 1;
		}
		else if(team1.getPoints() < team2.getPoints()) {
			return -1;
		}
		else {
			if(team1.getGoalDifference() > team2.getGoalDifference()) {
				return 1;
			}
			else if(team1.getGoalDifference() < team2.getGoalDifference()) {
				return -1;
			}
			else {
				if(team1.getGoalsFor() > team2.getGoalsFor()) {
					return 1;
				}
				else if(team1.getGoalsFor() < team2.getGoalsFor()) {
					return -1;
				}
				return 0;
			}
		}
	}
	
	/**
	 * 
	 * @param group
	 * @return the winner of the group
	 */
	public static Team getGroupWinnerTeam(WorldCupGroup group) {
		getSortedTeamList(group);
		return group.getTeams().get(0);
	}
	
	/**
	 * 
	 * @param group
	 * @return the runner-up of the group
	 */
	public static Team getGroupRunnerUpTeam(WorldCupGroup group) {
		getSortedTeamList(group);
		return group.getTeams().get(1);
	}
}

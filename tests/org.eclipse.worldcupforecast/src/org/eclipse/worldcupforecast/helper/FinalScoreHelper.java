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
import org.eclipse.worldcupforecast.GroupStageMatch;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.Team;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class FinalScoreHelper {
	
	/**
	 * provide the winner from finalscore
	 * @param finalScore
	 * @return the winner or null whether draw
	 */
	public static Team getWinner(FinalScore finalScore) {
		Match game = (Match)finalScore.eContainer();
		//team 1 win
		if(finalScore.getScoreTeam1() > finalScore.getScoreTeam2()) {
			return game.getTeam1();
		}
		
		//team 2 win
		else if(finalScore.getScoreTeam1() < finalScore.getScoreTeam2()) {
			return game.getTeam2();
		}
		
		//draw on regular time
		else {
			
			//no penalty during group stage
			if(game instanceof GroupStageMatch) {
				return null;
			}
			else {
				//team 1 win
				if(finalScore.getPenaltyScoreTeam1() > finalScore.getPenaltyScoreTeam2()) {
					return game.getTeam1();
				}
				
				//team 2 win
				else {
					return game.getTeam2();
				}
			}
		}
	}
}

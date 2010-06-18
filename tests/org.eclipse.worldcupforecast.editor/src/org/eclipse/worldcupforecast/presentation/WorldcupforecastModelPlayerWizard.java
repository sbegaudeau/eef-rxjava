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
package org.eclipse.worldcupforecast.presentation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.worldcupforecast.Forecast;
import org.eclipse.worldcupforecast.ForecastDay;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.MatchDay;
import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.WorldCupForecast;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.utils.Urls;
import org.eclipse.worldcupforecast.utils.WorldCupForecastHelper;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class WorldcupforecastModelPlayerWizard extends
		WorldcupforecastModelWizard {
	
	private Player player;
	private WorldCupForecast worldCupForecast;

	@Override
	protected EObject createInitialModel() {
		EClass eClass = (EClass)worldcupforecastPackage.getEClassifier(worldcupforecastPackage.getPlayer().getName());
		EObject rootObject = worldcupforecastFactory.create(eClass);
		
		if(rootObject instanceof Player) {
			player = (Player) rootObject;
			player.setName(initialObjectCreationPage.getNicknameField());
			try {
				ResourceSetImpl rset = new ResourceSetImpl();
				rset.createResource(URI.createURI(Urls.URL_Model));
				rset.getResource(URI.createURI(Urls.URL_Model), true);
				worldCupForecast = WorldCupForecastHelper.findFirstWorldCupForecastInstance(rset);
				initPlayer(getShell());
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		return rootObject;
	}
	
	private void initPlayer(Shell shell) {
		
			      
		for(MatchDay matchDay : worldCupForecast.getMatchDays()) {
			ForecastDay currentPlayerForecastDay = WorldcupforecastFactory.eINSTANCE.createForecastDay();
			currentPlayerForecastDay.setDate(matchDay.getDate());
			
			for(Match match : matchDay.getMatches()) {
				Forecast currentGameForecast = createForecast(match);
				currentPlayerForecastDay.getForecasts().add(currentGameForecast);
				player.getForecastDays().add(currentPlayerForecastDay);
			}
		}

	}
	

	/**
	 * provide new default forecast from game
	 * @param match
	 * @return new forecast
	 */
	private Forecast createForecast(Match match) {
		Forecast currentGameForecast = WorldcupforecastFactory.eINSTANCE.createForecast();
		currentGameForecast.setMatch(match);
		currentGameForecast.setWinner(null);
		currentGameForecast.setScoreTeam1(0);
		currentGameForecast.setScoreTeam2(0);
		return currentGameForecast;
	}
}

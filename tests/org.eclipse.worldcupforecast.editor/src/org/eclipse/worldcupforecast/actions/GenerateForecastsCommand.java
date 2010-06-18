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
package org.eclipse.worldcupforecast.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.worldcupforecast.Forecast;
import org.eclipse.worldcupforecast.ForecastDay;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.MatchDay;
import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.ValidatePlayer;
import org.eclipse.worldcupforecast.WorldCupForecast;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class GenerateForecastsCommand implements Command {
	
	private Shell shell;
	
	private Player player;
	
	private WorldCupForecast worldCupForecast;
	
	private boolean canExecute = false;

	private String directoryPath;

	private String forcastDayFolder;

	private ResourceSet resourceSet;
	
	public GenerateForecastsCommand(Shell shell, Player player) {
		this.shell = shell;
		this.player = player;
		this.canExecute = true;
	}

	public boolean canExecute() {
		return canExecute;
	}

	public boolean canUndo() {
		// TODO Auto-generated method stub
		return false;
	}

	public Command chain(Command command) {
		// TODO Auto-generated method stub
		return null;
	}

	public void dispose() {
		// TODO Auto-generated method stub

	}

	public void execute() {
		
		
		resourceSet = player.eResource().getResourceSet();
		worldCupForecast = (WorldCupForecast) EcoreUtil.getRootContainer(player);
		
		DirectoryDialog selectedDirectory = new DirectoryDialog(shell);
		directoryPath = selectedDirectory.open();
		forcastDayFolder = "players";

		
		
		
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		   try {
			dialog.run(true, true, new IRunnableWithProgress() {

			    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			      monitor.beginTask("Generate Forecats for all players", worldCupForecast.getPlayers().size());
			      
			      
			      
			      for(Player player : worldCupForecast.getPlayers()) {
			    	  	ValidatePlayer validatePlayer = WorldcupforecastFactory.eINSTANCE.createValidatePlayer();
			    	  	validatePlayer.setPlayer(player);
						worldCupForecast.getValidatePlayers().add(validatePlayer);
						for(MatchDay matchDay : worldCupForecast.getMatchDays()) {
							ForecastDay currentPlayerForecastDay = WorldcupforecastFactory.eINSTANCE.createForecastDay();
							currentPlayerForecastDay.setDate(matchDay.getDate());
							
							for(Match match : matchDay.getMatches()) {
								Forecast currentGameForecast = createForecast(match);
								currentPlayerForecastDay.getForecasts().add(currentGameForecast);
								player.getForecastDays().add(currentPlayerForecastDay);
							}
							
						}
						
						String fullPlayerPath = directoryPath + "/" + forcastDayFolder + "/" + player.getName() + ".worldcupforecast";			
						//we export in file resource the new forecast day for current player
						exportPlayer(resourceSet, player,
								fullPlayerPath);
						
						monitor.worked(1);
						
						if(monitor.isCanceled()) {
					        break;
					    }
					}
			      
			       
			       /*if(monitor.isCanceled()) {
			        break;
			       }*/
			      //Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An error occured during fr.pe.ing.acropole.migration.", e));

			      monitor.done();
			    }
			   });
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		

	}
	/**
	 * export player to specified path
	 * @param resourceSet
	 * @param
	 * @param
	 */
	private void exportPlayer(ResourceSet resourceSet,
			Player currentPlayer, String fullForecastPath) {
		URI forecastURI = URI.createFileURI(fullForecastPath);		
		Resource resource = resourceSet.createResource(forecastURI);
		
		resource.getContents().add(currentPlayer);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			MessageDialog.openError(shell, "Save error", "Cannot save file " + fullForecastPath);
			e.printStackTrace();
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

	public Collection<?> getAffectedObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<?> getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	public void redo() {
		// TODO Auto-generated method stub

	}

	public void undo() {
		// TODO Auto-generated method stub

	}

}

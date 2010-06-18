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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.worldcupforecast.Forecast;
import org.eclipse.worldcupforecast.ForecastDay;
import org.eclipse.worldcupforecast.Match;
import org.eclipse.worldcupforecast.MatchDay;
import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.ValidatePlayer;
import org.eclipse.worldcupforecast.WorldCupForecast;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ValidateForecastsCommand implements Command {
	
	private Shell shell;
	private boolean canExecute = false;
	private MatchDay matchDay;
	private Resource gameDayResource;
	private ResourceSet resourceSet;
	private WorldCupForecast worldCupForecast;

	public ValidateForecastsCommand(Shell shell, MatchDay matchDay) {
		this.shell = shell;
		this.matchDay = matchDay;
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
		gameDayResource = matchDay.eResource();
		resourceSet = gameDayResource.getResourceSet();
		
		worldCupForecast = (WorldCupForecast) EcoreUtil.getRootContainer(matchDay);
		
		
		
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
	   try {
			dialog.run(true, true, new IRunnableWithProgress() {
	
			    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			    	
			    	monitor.beginTask("Forecast Validation", worldCupForecast.getPlayers().size());
		
					for(Player player : worldCupForecast.getPlayers()) {
						
						if(player != null) {
			
							EList<ForecastDay> currentPlayerForecastDays = player.getForecastDays();
							
							ForecastDay currentPlayerForecastDay = null;
							
							//research of forecastDay which match with matchDay
							for(ForecastDay forecastDay : currentPlayerForecastDays) {

								if(compareForecastDayMatchDay(forecastDay,matchDay)) {
									currentPlayerForecastDay = forecastDay;
								}
							}
							if(currentPlayerForecastDay != null) {
								URI fileURI = currentPlayerForecastDay.eResource().getURI();
								try {
									Resource currentPlayerResource = resourceSet.getResource(fileURI, true);

									for(ValidatePlayer validatePlayer : worldCupForecast.getValidatePlayers()) {
										if(validatePlayer.getPlayer().equals(player)) {
											validatePlayer.getForecastDays().add(currentPlayerForecastDay);
											player.getForecastDays().remove(currentPlayerForecastDay);
										}
									}
									
									currentPlayerResource.save(Collections.EMPTY_MAP);
									gameDayResource.save(Collections.EMPTY_MAP);
								
								}
								catch (IOException e) {
								// TODO Auto-generated catch block
									e.printStackTrace();
								}
								catch (Exception e) {
									e.printStackTrace();
									//MessageDialog.openError(shell, "Cannot open forecast day",e.getMessage());
								}
							}
							
						}
						monitor.worked(1);
						
						if(monitor.isCanceled()) {
					        break;
					    }
					}
					monitor.done();
			    }
			});
	   } 
	   catch (InvocationTargetException e) {
		   e.printStackTrace();
	   } 
	   catch (InterruptedException e) {
		   e.printStackTrace();
	   }
	}
	
	public boolean compareForecastDayMatchDay(ForecastDay forecastDay, MatchDay matchDay) {
		if(forecastDay.getForecasts().size() == matchDay.getMatches().size()) {
			boolean matchFound = false;
			for(Match match : matchDay.getMatches()) {
				for(Forecast forecast : forecastDay.getForecasts()) {
					Match forecastMatch = forecast.getMatch();
					if (match.getName().equals(forecastMatch.getName()) && match.getHours() == forecastMatch.getHours()) {
						matchFound = true;
						break;
					}
				}
				if(matchFound) {
					matchFound = false;
				}
				else {
					return false;
				}
			}
			return true;
		}
		return false;
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

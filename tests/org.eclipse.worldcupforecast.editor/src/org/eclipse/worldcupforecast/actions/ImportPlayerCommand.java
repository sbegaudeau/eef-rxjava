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
package org.eclipse.worldcupforecast.actions;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.ValidatePlayer;
import org.eclipse.worldcupforecast.WorldCupForecast;
import org.eclipse.worldcupforecast.WorldcupforecastFactory;
import org.eclipse.worldcupforecast.utils.WorldCupForecastHelper;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ImportPlayerCommand implements Command {
	
	private Shell shell;
	
	private File[] list;
	
	private boolean canExecute = false;


	private ResourceSet resourceSet;

	
	public ImportPlayerCommand(File[] list, Shell shell, ResourceSet resourceSet) {
		this.shell =shell;
		this.list =list;
		this.resourceSet = resourceSet;
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
		
		
	
		
		
		
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
		   try {
			dialog.run(true, true, new IRunnableWithProgress() {

			    public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
			      monitor.beginTask("Generate Forecats for all players", list.length);
			      
			      for(File file : list) {
						//Resource resource = new ResourceImpl(URI.createFileURI(file.getPath()));
						//if(resource != null) {
						boolean containPlayer = false;
						Resource resourcePlayer = resourceSet.getResource(URI.createFileURI(file.getPath()), true);
						Player currentPlayer = WorldCupForecastHelper.findFirstPlayerInstance(resourcePlayer);
						WorldCupForecast worldCupForecast = WorldCupForecastHelper.findFirstWorldCupForecastInstance(resourceSet);
						
						
						for(Player playerFromMainModel : worldCupForecast.getPlayers()) {
							if(playerFromMainModel.getName().equals(currentPlayer.getName())) {
								containPlayer = true;
								break;
							}
						}
						
						if(!containPlayer) {
							worldCupForecast.getPlayers().add(currentPlayer);
							ValidatePlayer validatePlayer = WorldcupforecastFactory.eINSTANCE.createValidatePlayer();
							validatePlayer.setPlayer(currentPlayer);
							worldCupForecast.getValidatePlayers().add(validatePlayer);
						}
						if(monitor.isCanceled()) {
						   break;
						 }
						monitor.worked(1);
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
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		

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

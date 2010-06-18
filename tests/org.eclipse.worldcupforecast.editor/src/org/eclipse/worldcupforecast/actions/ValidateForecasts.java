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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import org.eclipse.worldcupforecast.MatchDay;
import org.eclipse.worldcupforecast.presentation.WorldcupforecastEditor;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ValidateForecasts implements IObjectActionDelegate {

	private Shell shell;
	private EditingDomain editingDomain;
	
	private MatchDay matchDay;
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		editingDomain = ((WorldcupforecastEditor)targetPart).getEditingDomain();
		shell = targetPart.getSite().getShell();
		
		
	}

	public void run(IAction action) {
		editingDomain.getCommandStack().execute(new ValidateForecastsCommand(shell, matchDay));
		
	}

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection sSelection = (StructuredSelection) selection;
			matchDay = (MatchDay) sSelection.getFirstElement();
		}
		
	}
	
	

}

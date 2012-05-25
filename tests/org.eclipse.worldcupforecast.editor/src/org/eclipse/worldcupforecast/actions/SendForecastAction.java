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

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.FileStoreEditorInput;

import org.eclipse.worldcupforecast.Player;
import org.eclipse.worldcupforecast.presentation.WorldcupforecastEditor;
import org.eclipse.worldcupforecast.send.SendResultUtil;
import org.eclipse.worldcupforecast.utils.WorldCupForecastHelper;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class SendForecastAction extends WorkbenchWindowActionDelegate {

	public void run(IAction action) {
		IEditorPart editorPart =  getWindow().getActivePage().getActiveEditor();
		if(editorPart instanceof WorldcupforecastEditor) {
			try {
				ResourceSet resourceSet = ((WorldcupforecastEditor) editorPart).getEditingDomain().getResourceSet();
				if(resourceSet != null ) {
					Player player = WorldCupForecastHelper.findFirstPlayerInstance(resourceSet);
					
					if(editorPart.getEditorInput() instanceof FileStoreEditorInput) {
						FileStoreEditorInput editorInput = (FileStoreEditorInput) editorPart.getEditorInput();
						
						Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getSite().getShell();
						
						Display display = shell.getDisplay();
						Shell shell2 = new Shell(display);
						
						SendResultUtil.sendDialog(shell2, player.getName() , new File(editorInput.getURI()));
					
					}
					if(editorPart.getEditorInput() instanceof URIEditorInput) {
						URIEditorInput editorInput = (URIEditorInput) editorPart.getEditorInput();
						
						Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor().getSite().getShell();
						
						Display display = shell.getDisplay();
						Shell shell2 = new Shell(display);
						
						SendResultUtil.sendDialog(shell2, player.getName() , new File(editorInput.getURI().toFileString()));
					}
					
					
				}
			}
			catch (Exception e) {
				e.getStackTrace();
			}
		}
		
	}

}

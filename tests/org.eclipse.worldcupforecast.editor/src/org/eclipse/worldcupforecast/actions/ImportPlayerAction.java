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

import java.io.File;
import java.io.FilenameFilter;

import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.IEditorPart;

import org.eclipse.worldcupforecast.presentation.WorldcupforecastEditor;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class ImportPlayerAction extends WorkbenchWindowActionDelegate {

	private String directoryPath;

	public void run(IAction action) {
		IEditorPart editorPart =  getWindow().getActivePage().getActiveEditor();
		if(editorPart instanceof WorldcupforecastEditor) {
			try {
				ResourceSet resourceSet = ((WorldcupforecastEditor) editorPart).getEditingDomain().getResourceSet();
				if(resourceSet != null ) {
				
					DirectoryDialog selectedDirectory = new DirectoryDialog(getWindow().getShell());
					directoryPath = selectedDirectory.open();
					File dir = new File(directoryPath);
					
					FilenameFilter filter = new FilenameFilter() {
					    public boolean accept(File dir, String name) {
					        return name.endsWith(".worldcupforecast");
					    }
					};
						
					((WorldcupforecastEditor)editorPart).getEditingDomain().getCommandStack().execute(new ImportPlayerCommand(dir.listFiles(filter), getWindow().getShell(),resourceSet));
				//}
				
				/*if(resourceSet.getResource(URI.createFileURI(file.getPath()), true) != null) {
					WorldCupForecastHelper.findFirstPlayerInstance(resourceSet)
				}*/
				}
			}
			catch (Exception e) {
				e.getStackTrace();
			}
		}

	}
}

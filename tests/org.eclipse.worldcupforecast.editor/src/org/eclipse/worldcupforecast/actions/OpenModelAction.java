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


import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.PartInitException;

import org.eclipse.worldcupforecast.utils.Urls;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class OpenModelAction extends WorkbenchWindowActionDelegate {

	public static String ID = "org.eclipse.worldcupforecast.presentation.OpenModelAction"; //$NON-NLS-1$

	public void run(IAction action) {

		URI uri = URI
				.createURI(Urls.URL_Model);
		URIEditorInput editorInput = new URIEditorInput(uri);
		if (editorInput != null) {

			IWorkbench workbench = PlatformUI.getWorkbench();
			IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
					.getActivePage();
			try {
				page.openEditor(editorInput, workbench
						.getEditorRegistry()
						.getDefaultEditor(uri.lastSegment()).getId());
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

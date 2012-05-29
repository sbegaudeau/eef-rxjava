/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.modelingBot.edit.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.eef.modelingBot.provider.MbotEditPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.part.FileEditorInput;

/**
 * The Open with interactive EEF editor action handler.
 * 
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class OpenWithEEFHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			final ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
			if (!selection.isEmpty() && selection instanceof IStructuredSelection
					&& ((IStructuredSelection)selection).getFirstElement() instanceof IFile) {
				HandlerUtil
						.getActiveWorkbenchWindowChecked(event)
						.getActivePage()
						.openEditor(new FileEditorInput((IFile)((IStructuredSelection)selection).getFirstElement()),
								MbotEditPlugin.INTERACTIVE_EEF_EDITOR_ID);
			}
		} catch (PartInitException e) {
			final Status status = new Status(IStatus.ERROR, MbotEditPlugin.INTERACTIVE_EEF_EDITOR_ID, e.getMessage());
			MbotEditPlugin.getPlugin().getLog().log(status);
		}
		return null;
	}

}

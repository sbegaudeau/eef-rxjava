/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.ui.initializer.actions;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.eef.codegen.EEFCodegenPlugin;
import org.eclipse.emf.eef.codegen.core.initializer.AbstractPropertiesInitializer;
import org.eclipse.emf.eef.codegen.core.initializer.EEFEditorInitializer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class InitializeEEFEditorAction implements IObjectActionDelegate {

	private Shell shell;

	private URI modelURI;

	private IFile selectedFile = null;

	/**
	 * 
	 */
	public InitializeEEFEditorAction() {
		super();
	}

	/**
	 * {@inheritDoc]
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		if (selectedFile != null) {
			try {
				modelURI = URI.createURI("platform:/resource" + selectedFile.getFullPath());
				IContainer container = selectedFile.getParent();
				AbstractPropertiesInitializer initializer = new EEFEditorInitializer(selectedFile);
				initializer.initialize(modelURI, container);
				container.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
			} catch (Exception e) {
				EEFCodegenPlugin.getDefault().logError(e);
			}
			
		}

	}

	/**
	 * {@inheritDoc]
	 * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action.IAction, org.eclipse.jface.viewers.ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection sSelection = (StructuredSelection)selection;
			if (sSelection.getFirstElement() instanceof IFile) {
				this.selectedFile = (IFile)sSelection.getFirstElement();
			}

		}
	}

	/**
	 * {@inheritDoc]
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	
	
}

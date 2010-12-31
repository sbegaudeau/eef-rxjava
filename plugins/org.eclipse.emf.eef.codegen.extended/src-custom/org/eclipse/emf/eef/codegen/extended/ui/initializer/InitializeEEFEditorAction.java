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
package org.eclipse.emf.eef.codegen.extended.ui.initializer;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.codegen.EEFCodegenPlugin;
import org.eclipse.emf.eef.codegen.core.initializer.AbstractPropertiesInitializer;
import org.eclipse.emf.eef.codegen.core.util.EMFHelper;
import org.eclipse.emf.eef.codegen.extended.initializer.EEFEditorInitializer;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class InitializeEEFEditorAction implements IObjectActionDelegate, IEditorActionDelegate {

	private URI modelURI;

	private IFile selectedFile = null;

	private IWorkbenchPartSite activeSite;

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
				AbstractPropertiesInitializer initializer = new EEFEditorInitializer(selectedFile, activeSite);
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
			Object selectedElement = sSelection.getFirstElement();
			if (selectedElement instanceof IFile) {
				this.selectedFile = (IFile)selectedElement;
			} else if (selectedElement instanceof IAdaptable) {
				EObject eObject = (EObject) ((IAdaptable)selectedElement).getAdapter(EObject.class);
				if (eObject != null) {
					// We use the ability of a GMF EditPart to be adapted into the semantic EObject
					if (eObject.eResource().getURI().fileExtension().equals("ecore")) {
						IFile associatedFile = EMFHelper.associatedFile(eObject);
						if (associatedFile.isAccessible()) {
							this.selectedFile = associatedFile;
						}
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc]
	 * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action.IAction, org.eclipse.ui.IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		this.activeSite = targetPart.getSite();
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.ui.IEditorActionDelegate#setActiveEditor(org.eclipse.jface.action.IAction, org.eclipse.ui.IEditorPart)
	 */
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		if (targetEditor != null) {
			this.activeSite = targetEditor.getSite();
		}
	}

}

/*******************************************************************************
 * Copyright (c) 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - Initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.ecore.ui.launcher;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.eef.codegen.ecore.EMFCodegenPlugin;
import org.eclipse.emf.eef.codegen.flow.Workflow;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public abstract class GenerateEMFCodeAction implements IObjectActionDelegate {

	private LinkedHashSet<IFile> selectedFiles;

	protected Shell shell;

	protected List<GenModel> emfGenModels;

	protected IWorkspace workspace = ResourcesPlugin.getWorkspace();

	public GenerateEMFCodeAction() {
		selectedFiles = new LinkedHashSet<IFile>();
		emfGenModels = new ArrayList<GenModel>();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(IAction action) {
		try {
			if (selectedFiles != null) {
				emfGenModels = initEMFGenModel();

				if (emfGenModels != null) {
					final Workflow flow = initEMFGenFlow();
					flow.prepare();
					IRunnableWithProgress runnable = new IRunnableWithProgress() {

						public void run(IProgressMonitor monitor) throws InvocationTargetException,
								InterruptedException {
							flow.execute(monitor);
							monitor.done();
							selectedFiles.clear();
						}

					};
					new ProgressMonitorDialog(shell).run(true, true, runnable);
				}
			}
		} catch (InvocationTargetException e) {
			EMFCodegenPlugin.getDefault().logError(e);
		} catch (InterruptedException e) {
			EMFCodegenPlugin.getDefault().logWarning(e);
		} catch (IOException e) {
			EMFCodegenPlugin.getDefault().logError(e);
		}
	}

	/**
	 * @return the flow to execute in order to generate EMF code.
	 */
	protected abstract Workflow initEMFGenFlow();
	
	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection sSelection = (StructuredSelection)selection;
			this.selectedFiles.clear();
			for (Object selectedElement : sSelection.toList()) {
				if (selectedElement instanceof IFile) {
					this.selectedFiles.add((IFile)selectedElement);
				}
			}

		}
	}

	protected List<GenModel> initEMFGenModel() throws IOException {
		emfGenModels.clear();
		if (!selectedFiles.isEmpty()) {
			ResourceSet resourceSet = new ResourceSetImpl();
			for (IFile selectedFile : selectedFiles) {
				URI modelURI = URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true);
				String fileExtension = modelURI.fileExtension();
				if (fileExtension == null || fileExtension.length() == 0) {
					fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
				}
				final Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
				final Object resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
				if (resourceFactory != null) {
					resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
							.put(fileExtension, resourceFactory);
				} else {
					resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
							.put(fileExtension, new XMIResourceFactoryImpl());
				}
				Resource res = resourceSet.createResource(modelURI);
				res.load(Collections.EMPTY_MAP);
				EcoreUtil.resolveAll(resourceSet);
				if (res.getContents().size() > 0) {
					EObject object = res.getContents().get(0);
					if (object instanceof GenModel) {
						emfGenModels.add((GenModel)object);
					}
				}
			}
		}
		return emfGenModels;
	}

	protected IProject extractProject(String sPath) {
		IPath path = new Path(sPath);
		return workspace.getRoot().getProject(path.segment(0));
	}

}

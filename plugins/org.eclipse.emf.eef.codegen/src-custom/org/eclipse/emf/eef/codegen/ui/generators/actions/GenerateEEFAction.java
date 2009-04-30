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
package org.eclipse.emf.eef.codegen.ui.generators.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.codegen.EEFCodegenPlugin;
import org.eclipse.emf.eef.codegen.ui.generators.common.GenerateAll;
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
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class GenerateEEFAction implements IObjectActionDelegate {

	private Shell shell;
	private URI modelURI;
	private IFile selectedFile;
	private GenEditionContext gec;
	
	/**
	 * Constructor for Action1.
	 */
	public GenerateEEFAction() {
		super();
		selectedFile = null;
		gec = null;
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
			if (selectedFile != null) {
				modelURI = URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true);
				final IContainer target = getGenContainer();
				final String basePackage = getBasePackage();
				final URI pecModelURI = getGenEditionContext().getPropertiesEditionContext().eResource().getURI(); 
				if (target != null) {
					IRunnableWithProgress runnable = new IRunnableWithProgress() {

						public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
							try {
								monitor.beginTask("Generating EEF Architecture", 14);
								List<Object> arguments = new ArrayList<Object>();
								arguments.add(basePackage);
								GenerateAll generator = new GenerateAll(pecModelURI, target.getLocation().toFile(), arguments, gec);
								generator.doGenerate(monitor);
								target.refreshLocal(IResource.DEPTH_INFINITE, monitor);
								monitor.worked(1);
							} catch (IOException e) {
								EEFCodegenPlugin.getDefault().logError(e);
							} catch (CoreException e) {
								EEFCodegenPlugin.getDefault().logError(e);
							}
							finally {
								monitor.done();
								selectedFile = null;
								gec = null;
							}
						}

					};
					new ProgressMonitorDialog(shell).run(true, true, runnable);
				}
			}
		} catch (InvocationTargetException e) {
			EEFCodegenPlugin.getDefault().logError(e);
		} catch (InterruptedException e) {
			EEFCodegenPlugin.getDefault().logError(e);
		} catch (IOException e) {
			EEFCodegenPlugin.getDefault().logError(e);
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof StructuredSelection) {
			StructuredSelection sSelection = (StructuredSelection) selection;
			if (sSelection.getFirstElement() instanceof IFile) {
				this.selectedFile = (IFile) sSelection.getFirstElement();
			}
			
		}
	}
	
	private GenEditionContext getGenEditionContext() throws IOException {
		if (gec != null)
			return gec;
		else {
			ResourceSet resourceSet = new ResourceSetImpl();
			String fileExtension = modelURI.fileExtension();
			if (fileExtension == null || fileExtension.length() == 0) {
				fileExtension = Resource.Factory.Registry.DEFAULT_EXTENSION;
			}
			final Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
			final Object resourceFactory = registry.getExtensionToFactoryMap().get(fileExtension);
			if (resourceFactory != null) {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension, resourceFactory);
			} else {
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(fileExtension, new XMIResourceFactoryImpl());
			}
			Resource res = resourceSet.createResource(modelURI);
			res.load(Collections.EMPTY_MAP);
			EcoreUtil.resolveAll(resourceSet);
			if (res.getContents().size() > 0) {
				EObject object = res.getContents().get(0);
				if (object instanceof GenEditionContext) {
					gec = (GenEditionContext)object;
					if (gec != null) {
						return gec;
					}
				}
			}
			return null;
		}
	}
	
	public String getBasePackage() throws IOException {
		gec = getGenEditionContext();
		if (gec != null) {
			if (gec.getBasePackage() != null) 
				return gec.getBasePackage();
		}
		return "";
	}
	
	public IContainer getGenContainer() throws IOException {
		gec = getGenEditionContext();
		if (gec != null) {
			if (gec.getGenDirectory() != null) {
				final IContainer target = (IContainer) ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(gec.getGenDirectory()));
				return target;
			}
		}
		return null;
	}
	

}

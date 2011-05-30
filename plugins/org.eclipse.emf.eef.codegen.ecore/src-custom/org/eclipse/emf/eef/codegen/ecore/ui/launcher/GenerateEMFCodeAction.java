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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.eef.codegen.ecore.EMFCodegenPlugin;
import org.eclipse.emf.eef.codegen.ecore.main.GenEdit;
import org.eclipse.emf.eef.codegen.ecore.main.GenEditor;
import org.eclipse.emf.eef.codegen.flow.Step;
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
public class GenerateEMFCodeAction implements IObjectActionDelegate {

	private LinkedHashSet<IFile> selectedFiles;

	private Shell shell;

	private List<GenModel> emfGenModels;

	private IWorkspace workspace = ResourcesPlugin.getWorkspace();

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
					final Workflow flow = new Workflow("Generate EMF Edit and Editors ", shell);
					for (final GenModel emfGenModel : emfGenModels) {
						String s1 = "Generate EMF Edit code for "
								+ emfGenModel.eResource().getURI().lastSegment();
						// use this once we can add acceleo inside emf generator
						// Step emfEditCode = new GenerateEMFEditCode(s,
						// emfGenModel);
						// flow.addStep(s, emfEditCode);
						flow.addStep(s1, new Step("EMF EDIT") {

							@Override
							public IStatus execute(IProgressMonitor monitor) {
								// create the edit project
								IProject editProject = extractProject(emfGenModel.getEditProjectDirectory());
								List<IProject> referencedProjects = new UniqueEList<IProject>();
								if (!workspace.getRoot().exists(editProject.getFullPath())) {
									Generator.createEMFProject(
											new Path(emfGenModel.getEditProjectDirectory()),
											null, referencedProjects,
											new SubProgressMonitor(monitor, IProgressMonitor.UNKNOWN),
											Generator.EMF_EDIT_PROJECT_STYLE);
								} else if (!editProject.isAccessible()) {
									try {
										editProject.open(monitor);
									} catch (CoreException e) {
										return new Status(IStatus.ERROR, EMFCodegenPlugin.PLUGIN_ID, e
												.getMessage(), e);
									}
								}
								// generate using acceleo
								List<String> args = new ArrayList<String>();
								File editDirectory = editProject.getLocation().toFile();
								try {
									GenEdit generator = new GenEdit(emfGenModel, editDirectory, args);
									generator.doGenerate(BasicMonitor.toMonitor(new SubProgressMonitor(
											monitor, IProgressMonitor.UNKNOWN)));
								} catch (IOException e) {
									return new Status(IStatus.ERROR, EMFCodegenPlugin.PLUGIN_ID, e
											.getMessage(), e);
								}
								return Status.OK_STATUS;
							}
						});
						String s2 = "Generate EMF Editor code for "
								+ emfGenModel.eResource().getURI().toString();
						flow.addStep(s2, new Step("EMF EDITOR") {

							@Override
							public IStatus execute(IProgressMonitor monitor) {
								// create the editor project
								IProject editorProject = extractProject(emfGenModel
										.getEditorProjectDirectory());
								List<IProject> referencedProjects = new UniqueEList<IProject>();
								if (!workspace.getRoot().exists(editorProject.getFullPath())) {
										Generator.createEMFProject(
												new Path(emfGenModel.getEditorProjectDirectory()),
												editorProject.getLocation(), referencedProjects,
												new SubProgressMonitor(monitor, IProgressMonitor.UNKNOWN),
												Generator.EMF_EDITOR_PROJECT_STYLE);
								} else if (!editorProject.isAccessible()) {
									try {
										editorProject.open(monitor);
									} catch (CoreException e) {
										return new Status(IStatus.ERROR, EMFCodegenPlugin.PLUGIN_ID, e
												.getMessage(), e);
									}
								}
								// generate using acceleo
								List<String> args = new ArrayList<String>();
								File editorDirectory = editorProject.getLocation().toFile();
								try {
									GenEditor generator = new GenEditor(emfGenModel, editorDirectory, args);
									generator.doGenerate(BasicMonitor.toMonitor(new SubProgressMonitor(
											monitor, IProgressMonitor.UNKNOWN)));
								} catch (IOException e) {
									return new Status(IStatus.ERROR, EMFCodegenPlugin.PLUGIN_ID, e
											.getMessage(), e);
								}
								return Status.OK_STATUS;
							}
						});
						String s3 = "Refresh workspace " + emfGenModel.eResource().getURI().toString();
						flow.addStep(s3, new Step("REFRESH") {

							@Override
							public IStatus execute(IProgressMonitor monitor) {
								// refresh edit and editor
								IProject editorProject = extractProject(emfGenModel
										.getEditorProjectDirectory());
								IProject editProject = extractProject(emfGenModel.getEditProjectDirectory());
								try {
									if (!editProject.isOpen()) {
										editProject.open(monitor);
									}
									if (!editorProject.isOpen()) {
										editorProject.open(monitor);
									}
									editorProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
									editProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
								} catch (CoreException e) {
									return new Status(IStatus.ERROR, EMFCodegenPlugin.PLUGIN_ID, e
											.getMessage(), e);
								}
								return Status.OK_STATUS;
							}
						});
					}
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

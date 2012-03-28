/*******************************************************************************
 * Copyright (c) 2008, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.codegen.extended.ui.launcher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.eef.EEFGen.EEFGenModel;
import org.eclipse.emf.eef.codegen.EEFCodegenPlugin;
import org.eclipse.emf.eef.codegen.extended.flow.OverrideEMFEditorCode;
import org.eclipse.emf.eef.codegen.flow.Workflow;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author <a href="mailto:stephane.bouchet@obeo.fr">Stephane Bouchet</a>
 */
public class GenerateEEFEditorAction implements IObjectActionDelegate {

	private static final String GENERATE_EEF_EDITOR = "Generate EEF Editor for ";

	/**
	 * @deprecated see bug #370409
	 */
	private Shell shell;

	protected Set<IFile> selectedFiles;

	/**
	 * the list of eefgenmodels
	 * 
	 * @deprecated since a job is used to generates files
	 */
	protected List<EEFGenModel> eefGenModels;

	/**
	 * Constructor.
	 */
	public GenerateEEFEditorAction() {
		selectedFiles = new LinkedHashSet<IFile>();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 * @deprecated see bug #370409
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public void run(IAction action) {
		if (selectedFiles != null) {
			try {
				List<EEFGenModel> eefgenmodels = initEEFGenModel();

				final Workflow flow = new Workflow("Generate EEF Editors", shell);
				for (final EEFGenModel eefGenModel : eefgenmodels) {
					String key = GENERATE_EEF_EDITOR + eefGenModel.eResource().getURI().toString();
					OverrideEMFEditorCode eefEditorCode = new OverrideEMFEditorCode(key, eefGenModel);
					flow.addStep(key, eefEditorCode);
				}
				flow.prepare();
				Job job = new Job("EEF editors generation") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						flow.execute(monitor);
						monitor.done();
						selectedFiles.clear();
						return Status.OK_STATUS;
					}

				};
				job.setUser(true);
				// lock the workspace to avoid concurrent modification
				job.setRule(ResourcesPlugin.getWorkspace().getRoot());
				job.schedule();
			} catch (IOException e) {
				EEFCodegenPlugin.getDefault().logError(e);
			}
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		selectedFiles.clear();
		if (selection instanceof StructuredSelection) {
			StructuredSelection sSelection = (StructuredSelection)selection;
			for (Object selectedElement : sSelection.toList()) {
				if (selectedElement instanceof IFile) {
					this.selectedFiles.add((IFile)selectedElement);
				}
			}

		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.codegen.ui.generators.actions.AbstractGenerateEEFAction#inutEEFGenModel()
	 */
	protected List<EEFGenModel> initEEFGenModel() throws IOException {
		List<EEFGenModel> eefgenmodels = new ArrayList<EEFGenModel>(selectedFiles.size());
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
					if (object instanceof EEFGenModel) {
						eefgenmodels.add((EEFGenModel)object);
					}
				}
			}
		}
		return eefgenmodels;
	}

}

/**
 * 
 */
package org.eclipse.emf.eef.codegen.ecore.ui.launcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.codegen.ecore.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.eef.codegen.ecore.EMFCodegenPlugin;
import org.eclipse.emf.eef.codegen.ecore.main.GenEdit;
import org.eclipse.emf.eef.codegen.ecore.util.EEFGeneratorAdapter;
import org.eclipse.emf.eef.codegen.flow.Step;
import org.eclipse.emf.eef.codegen.flow.Workflow;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class GenerateEMFEditCodeAction extends GenerateEMFCodeAction {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.codegen.ecore.ui.launcher.GenerateEMFCodeAction#initEMFGenFlow()
	 */
	protected Workflow initEMFGenFlow() {
		final Workflow flow = new Workflow("Generate EMF edit code ", shell);
		for (final GenModel emfGenModel : emfGenModels) {
			String s1 = "Generate EMF Edit code for " + emfGenModel.eResource().getURI().lastSegment();
			// use this once we can add acceleo inside emf generator
			// Step emfEditCode = new GenerateEMFEditCode(s,
			// emfGenModel);
			// flow.addStep(s, emfEditCode);
			flow.addStep(s1, new Step("EMF EDIT") {

				@Override
				public IStatus execute(IProgressMonitor monitor) {
					// create the edit project
					IProject editProject = extractProject(emfGenModel.getEditProjectDirectory());
					if (editProject == null) {
						return Status.OK_STATUS;
					}
					IProject modelProject = workspace.getRoot().getProject(
							emfGenModel.getModelProjectDirectory());
					List<IProject> referencedProjects = new UniqueEList<IProject>();
					referencedProjects.add(modelProject);
					if (!workspace.getRoot().exists(editProject.getFullPath())) {
						Generator.createEMFProject(new Path(emfGenModel.getEditDirectory()), null,
								referencedProjects,
								new SubProgressMonitor(monitor, IProgressMonitor.UNKNOWN),
								Generator.EMF_EDIT_PROJECT_STYLE | Generator.EMF_PLUGIN_PROJECT_STYLE);
					} else if (!editProject.isAccessible()) {
						try {
							editProject.open(monitor);
						} catch (CoreException e) {
							return new Status(IStatus.ERROR, EMFCodegenPlugin.PLUGIN_ID, e.getMessage(), e);
						}
					}
					// generate using acceleo
					List<String> args = new ArrayList<String>();
					File editDirectory = editProject.getLocation().toFile();
					try {
						GenEdit generator = new GenEdit(emfGenModel, editDirectory, args);
						generator.doGenerate(BasicMonitor.toMonitor(new SubProgressMonitor(monitor,
								IProgressMonitor.UNKNOWN)));
					} catch (IOException e) {
						return new Status(IStatus.ERROR, EMFCodegenPlugin.PLUGIN_ID, e.getMessage(), e);
					}
					return Status.OK_STATUS;
				}
			});
			String s2prime = "Formatting generated files";
			flow.addStep(s2prime, new Step(s2prime) {

				@Override
				public IStatus execute(IProgressMonitor monitor) {
					EEFGeneratorAdapter eefGen = new EEFGeneratorAdapter();
					eefGen.generate(emfGenModel, GenBaseGeneratorAdapter.EDIT_PROJECT_TYPE,
							BasicMonitor.toMonitor(new SubProgressMonitor(monitor, IProgressMonitor.UNKNOWN)));
					return Status.OK_STATUS;
				}
			});

			String s3 = "Refresh workspace " + emfGenModel.eResource().getURI().toString();
			flow.addStep(s3, new Step("REFRESH") {

				@Override
				public IStatus execute(IProgressMonitor monitor) {
					// refresh edit
					IProject editProject = extractProject(emfGenModel.getEditProjectDirectory());
					if (editProject == null) {
						return Status.OK_STATUS;
					}
					try {
						if (!editProject.isOpen()) {
							editProject.open(monitor);
						}
						editProject.refreshLocal(IResource.DEPTH_INFINITE, monitor);
					} catch (CoreException e) {
						return new Status(IStatus.ERROR, EMFCodegenPlugin.PLUGIN_ID, e.getMessage(), e);
					}
					return Status.OK_STATUS;
				}
			});
		}
		return flow;
	}

}

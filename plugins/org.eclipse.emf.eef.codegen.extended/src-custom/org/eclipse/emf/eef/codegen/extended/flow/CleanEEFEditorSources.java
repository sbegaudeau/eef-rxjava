/**
 * 
 */
package org.eclipse.emf.eef.codegen.extended.flow;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.eef.codegen.flow.GenmodelHelper;
import org.eclipse.emf.eef.codegen.flow.Step;
import org.eclipse.emf.eef.runtime.ui.EEFExtendedRuntime;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class CleanEEFEditorSources extends Step {

	private static final String PLUGIN_XML = "plugin.xml";
	private static final String PLUGIN_PROPERTIES = "plugin.properties";
	private static final String BUILD_PROPERTIES = "build.properties";
	private static final String EEFGEN_FILE_EXTENSION = "eefgen";
	private static final String COMPONENTS_FILE_EXTENSION = "components";
	private static final String EEF_MODELS_FOLDER = "models";

	private Shell shell;
	private GenmodelHelper helper;
	private SourceSelectorDialog dialog;
	private int open;
	private IFile ecoreModel;
	private IContainer targetFolder;

	/**
	 * @param name task name
	 * @param activeShell the active shell
	 */
	public CleanEEFEditorSources(String name, Shell activeShell, IFile ecoreModel, IContainer targetFolder) {
		super(name);
		this.shell = activeShell;
		this.ecoreModel = ecoreModel;
		this.targetFolder = targetFolder;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.codegen.flow.Step#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public IStatus execute(IProgressMonitor monitor) {
		this.helper = new GenmodelHelper(resourceSet, ecoreModel, targetFolder);
		shell.getDisplay().syncExec(new Runnable() {



			public void run() {
				dialog = new SourceSelectorDialog(shell);
				open = dialog.open();
			}
		});
		try {
			if (open == Window.OK) {
				String modelDirectory = helper.getGenModel().getModelDirectory();
				String editDirectory = helper.getGenModel().getEditDirectory();
				String editorDirectory = helper.getGenModel().getEditorDirectory();
				if (dialog.genmodel) {
					deleteGenmodel(monitor);
				}
				if (dialog.emfModelCode) {
					deleteProject(modelDirectory, monitor);
				}
				if (dialog.emfEditCode) {
					deleteProject(editDirectory, monitor);
				}
				if (dialog.emfEditorCode) {
					deleteProject(editorDirectory, monitor);
				}
				if (dialog.eefModels) {
					deleteEEFModels(editDirectory, monitor);
					
				}
			}
		} catch (CoreException e) {
			return new Status(IStatus.ERROR, EEFExtendedRuntime.PLUGIN_ID, "Unable to delete genmodel file.", e);
		}
		return Status.OK_STATUS;
	}

	/**
	 * @param monitor
	 * @throws CoreException
	 */
	protected void deleteGenmodel(IProgressMonitor monitor) throws CoreException {
		IFile genModelFile = helper.getGenModelFile();
		if (genModelFile.isAccessible()) {
			genModelFile.delete(true, monitor);
			helper.getTargetFolder().refreshLocal(IResource.DEPTH_INFINITE, monitor);
		}
	}

	/**
	 * @param srcFolderDirectory
	 * @param monitor
	 * @throws CoreException
	 */
	protected void deleteProject(String srcFolderDirectory, IProgressMonitor monitor) throws CoreException {
		IFolder srcFolder = ecoreModel.getWorkspace().getRoot().getFolder(new Path(srcFolderDirectory));
		IProject project = srcFolder.getProject();
		IFile pluginXML = project.getFile(new Path(PLUGIN_XML));
		IFile pluginProperties = project.getFile(new Path(PLUGIN_PROPERTIES));
		IFile buildProperties = project.getFile(new Path(BUILD_PROPERTIES));
		if (srcFolder.isAccessible()) {
			srcFolder.delete(true, monitor);
		}
		if (pluginXML.isAccessible()) {
			pluginXML.delete(true, monitor);
		}
		if (pluginProperties.isAccessible()) {
			pluginProperties.delete(true, monitor);
		}
		if (buildProperties.isAccessible()) {
			buildProperties.delete(true, monitor);
		}
		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
	}

	/**
	 * @param modelDirectory
	 * @param monitor
	 * @throws CoreException
	 */
	protected void deleteEEFModels(String modelDirectory, IProgressMonitor monitor) throws CoreException {
		IFolder srcFolder = ecoreModel.getWorkspace().getRoot().getFolder(new Path(modelDirectory));
		IProject project = srcFolder.getProject();
		IFolder folder = project.getFolder(new Path(EEF_MODELS_FOLDER));
		final List<IFile> toRemove = new ArrayList<IFile>();
		if (folder.isAccessible()) {
			folder.accept(new IResourceVisitor() {

				public boolean visit(IResource resource) throws CoreException {
					if (resource instanceof IFile) {
						IFile file = (IFile) resource;
						if (file.getFileExtension().equals(COMPONENTS_FILE_EXTENSION) || file.getFileExtension().equals(EEFGEN_FILE_EXTENSION)) {
							toRemove.add(file);
						}
					}
					return true;
				}
			});
			for (IFile file : toRemove) {
				file.delete(true, monitor);
			}
			folder.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		}
	}

	private class SourceSelectorDialog extends Dialog {

		private Button genmodelButton;
		private Button emfModelCodeButton;
		private Button emfEditCodeButton;
		private Button emfEditorCodeButton;
		private Button eefModelsButton;

		private Boolean genmodel;
		private Boolean emfModelCode;
		private Boolean emfEditCode;
		private Boolean emfEditorCode;
		private Boolean eefModels;

		/**
		 * @param parentShell
		 */
		public SourceSelectorDialog(Shell parentShell) {
			super(parentShell);
		}
		
		/**
		 * {@inheritDoc}
		 * @see org.eclipse.jface.window.Window#configureShell(org.eclipse.swt.widgets.Shell)
		 */
		protected void configureShell(Shell newShell) {
			super.configureShell(newShell);
			newShell.setText("EEF Editor sources cleaning");
		}



		/**
		 * {@inheritDoc}
		 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
		 */
		protected Control createDialogArea(Composite parent) {
			Composite container = new Composite(parent, SWT.NONE);
			GridLayout layout = new GridLayout();
			container.setLayout(layout);
			Label label = new Label(container, SWT.NONE);
			label.setText("Choose actions you want to perform");
			genmodelButton = new Button(container, SWT.CHECK);
			genmodelButton.setText("Delete generated 'genmodel' file");
			genmodelButton.setSelection(true);
			emfModelCodeButton = new Button(container, SWT.CHECK);
			emfModelCodeButton.setText("Delete generated EMF model code");
			emfModelCodeButton.setSelection(true);
			emfEditCodeButton = new Button(container, SWT.CHECK);
			emfEditCodeButton.setText("Delete generated EMF edit code");
			emfEditCodeButton.setSelection(true);
			emfEditorCodeButton = new Button(container, SWT.CHECK);
			emfEditorCodeButton.setText("Delete generated EMF editor code");
			emfEditorCodeButton.setSelection(true);
			eefModelsButton = new Button(container, SWT.CHECK);
			eefModelsButton.setText("Delete generated EEF models");
			eefModelsButton.setSelection(true);
			return container;
		}

		/**
		 * {@inheritDoc}
		 * @see org.eclipse.jface.dialogs.Dialog#okPressed()
		 */
		protected void okPressed() {
			genmodel = genmodelButton.getSelection();
			emfModelCode = emfModelCodeButton.getSelection();
			emfEditCode = emfEditCodeButton.getSelection();
			emfEditorCode = emfEditorCodeButton.getSelection();
			eefModels = eefModelsButton.getSelection();
			super.okPressed();
		}
		
		

	}

}

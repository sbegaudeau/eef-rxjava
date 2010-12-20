/**
 * 
 */
package org.eclipse.emf.eef.codegen.flow.impl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.eef.codegen.EEFCodegenPlugin;
import org.eclipse.emf.eef.codegen.core.util.BundleHelper;
import org.eclipse.emf.eef.codegen.flow.Step;
import org.eclipse.emf.eef.codegen.flow.var.WorkflowVariable;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class AddDependency extends Step {
	
	private Object editProject;
	private String dependency;

	/**
	 * @param name of the step
	 */
	public AddDependency(String name, Object editProject, String dependency) {
		super(name);
		this.editProject = editProject;
		this.dependency = dependency;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.codegen.flow.Step#execute(org.eclipse.emf.common.util.Monitor)
	 */
	public IStatus execute(Monitor monitor) {
		try {
			BundleHelper bundleHelper = new BundleHelper(getEditProject());
			bundleHelper.addDependency(dependency);
			return Status.OK_STATUS;
		} catch (CoreException e) {
			return new Status(IStatus.ERROR, EEFCodegenPlugin.PLUGIN_ID, "An error occured when adding dependency.", e);
		}
	}

	private IProject getEditProject() {
		if (editProject instanceof IProject) {
			return (IProject) editProject;
		} else if (editProject instanceof WorkflowVariable) {
			return (IProject) ((WorkflowVariable)editProject).getValue();
		} else {
			return null;
		}
	}

}

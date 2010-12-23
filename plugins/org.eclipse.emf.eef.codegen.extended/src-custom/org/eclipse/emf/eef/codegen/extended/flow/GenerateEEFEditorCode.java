/**
 * 
 */
package org.eclipse.emf.eef.codegen.extended.flow;

import java.io.IOException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.eef.EEFGen.EEFGenModel;
import org.eclipse.emf.eef.codegen.extended.Activator;
import org.eclipse.emf.eef.codegen.flow.Step;
import org.eclipse.emf.eef.codegen.flow.var.WorkflowVariable;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class GenerateEEFEditorCode extends Step {

	private Object eefEditorGenModel;

	/**
	 * @param name
	 */
	public GenerateEEFEditorCode(String name, Object eefEditorGenModel) {
		super(name);
		this.eefEditorGenModel = eefEditorGenModel;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.codegen.flow.Step#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IStatus execute(IProgressMonitor monitor) {
		try {
		EEFGenModel eefEditorGenModel = getEEFEditorGenModel();
		IContainer target = getGenContainer(eefEditorGenModel);
		if (target != null) {
		}		
		return Status.OK_STATUS;
		} catch (IOException e) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An error occured during generation.", e);
		}
	}

	public EEFGenModel getEEFEditorGenModel() {
		if (eefEditorGenModel instanceof EEFGenModel) {
			return (EEFGenModel) eefEditorGenModel;	
		} else if (eefEditorGenModel instanceof WorkflowVariable) {
			return (EEFGenModel) ((WorkflowVariable)eefEditorGenModel).getValue();
		} else {
			return null;
		}
	}
	
	/**
	 * Returns the container that the EEFGenModel use as generation directory
	 * 
	 * @param eefGenModel
	 *            the eefGenModel
	 * @return the generation directory
	 * @throws IOException
	 *             an error occurred during container creation
	 */
	public IContainer getGenContainer(EEFGenModel eefGenModel) throws IOException {
		if (eefGenModel != null) {
			if (eefGenModel.getGenDirectory() != null) {
				final IContainer target = (IContainer)ResourcesPlugin.getWorkspace().getRoot().getFolder(
						new Path(eefGenModel.getGenDirectory()));
				return target;
			}
		}
		return null;
	}

}

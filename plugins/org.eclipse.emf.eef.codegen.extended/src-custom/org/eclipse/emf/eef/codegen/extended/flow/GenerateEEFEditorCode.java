/**
 * 
 */
package org.eclipse.emf.eef.codegen.extended.flow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.EEFGen.EEFGenModel;
import org.eclipse.emf.eef.codegen.core.launcher.AbstractPropertiesGeneratorLauncher;
import org.eclipse.emf.eef.codegen.core.services.PropertiesGeneratorLaunchersServices;
import org.eclipse.emf.eef.codegen.extended.Activator;
import org.eclipse.emf.eef.codegen.extended.launcher.EEFEditorLauncher;
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
	 * 
	 * @see org.eclipse.emf.eef.codegen.flow.Step#execute(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IStatus execute(IProgressMonitor monitor) {
		try {
			EEFGenModel eefEditorGenModel = getEEFEditorGenModel();
			IContainer target = getGenContainer(eefEditorGenModel);
			if (target != null) {
				monitor.beginTask("Generating EEF Editor", 1);
				Set<IContainer> generationTargets = new LinkedHashSet<IContainer>();
				generationTargets.add(target);
				final EEFEditorLauncher generator = new EEFEditorLauncher(eefEditorGenModel, target.getLocation().toFile(), new ArrayList<String>());
				generator.doGenerate(BasicMonitor.toMonitor(monitor));

				List<AbstractPropertiesGeneratorLauncher> launchers = PropertiesGeneratorLaunchersServices.getInstance().getlaunchers();
				for (AbstractPropertiesGeneratorLauncher abstractPropertiesGeneratorLauncher : launchers) {
					EObject inputModel = generator.getModel();
					if (inputModel instanceof EEFGenModel) {
						abstractPropertiesGeneratorLauncher.doGenerate(eefEditorGenModel, generator.getTargetFolder(), monitor);
						if (!abstractPropertiesGeneratorLauncher.getTargetContainer().isEmpty())
							generationTargets.addAll(abstractPropertiesGeneratorLauncher.getTargetContainer());
					}
				}
				for (Iterator<IContainer> iterator = generationTargets
						.iterator(); iterator.hasNext();) {
					IContainer nextContainer = iterator.next();
					nextContainer.refreshLocal(IResource.DEPTH_INFINITE, monitor);
				}

			}
			return Status.OK_STATUS;
		} catch (IOException e) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An error occured during generation.", e);
		} catch (CoreException e) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An error occured during generation.", e);
		}
	}

	public EEFGenModel getEEFEditorGenModel() {
		if (eefEditorGenModel instanceof EEFGenModel) {
			return (EEFGenModel) eefEditorGenModel;
		} else if (eefEditorGenModel instanceof WorkflowVariable) {
			return (EEFGenModel) ((WorkflowVariable) eefEditorGenModel).getValue();
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
				final IContainer target = (IContainer) ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(eefGenModel.getGenDirectory()));
				return target;
			}
		}
		return null;
	}

}

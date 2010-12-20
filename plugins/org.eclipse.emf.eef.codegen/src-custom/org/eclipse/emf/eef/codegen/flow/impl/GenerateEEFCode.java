/**
 * 
 */
package org.eclipse.emf.eef.codegen.flow.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.eef.EEFGen.EEFGenModel;
import org.eclipse.emf.eef.codegen.flow.Step;
import org.eclipse.emf.eef.codegen.flow.WorkflowConstants;
import org.eclipse.emf.eef.codegen.flow.var.WorkflowVariable;
import org.eclipse.emf.eef.codegen.ui.generators.callback.EEFGenerationCallback;
import org.eclipse.emf.eef.codegen.ui.generators.callback.imports.JDTImportsOrganisationCallback;
import org.eclipse.emf.eef.codegen.ui.generators.common.GenerationHelper;
import org.eclipse.ui.PlatformUI;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class GenerateEEFCode extends Step {

	private Object eefgenModel;

	/**
	 * @param name of the step
	 */
	public GenerateEEFCode(String name, Object eefgenModel) {
		super(name);
		this.eefgenModel = eefgenModel;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.codegen.flow.Step#execute(org.eclipse.emf.common.util.Monitor)
	 */
	public IStatus execute(Monitor monitor) {
		List<EEFGenModel> eefgenModels = new ArrayList<EEFGenModel>(1);
		eefgenModels.add(getEEFGenModel());
		List<EEFGenerationCallback> callbacks = new ArrayList<EEFGenerationCallback>(1);
		callbacks.add(new JDTImportsOrganisationCallback(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart().getSite()));
		GenerationHelper generationHelper = new GenerationHelper(eefgenModels, callbacks);
		generationHelper.generate((IProgressMonitor) getContext().get(WorkflowConstants.ECLIPSE_MONITOR));
		return Status.OK_STATUS;
	}

	public EEFGenModel getEEFGenModel() {
		if (eefgenModel instanceof EEFGenModel) {
			return (EEFGenModel) eefgenModel;	
		} else if (eefgenModel instanceof WorkflowVariable) {
			return (EEFGenModel) ((WorkflowVariable)eefgenModel).getValue();
		} else {
			return null;
		}
	}

}

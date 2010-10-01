/**
 * 
 */
package org.eclipse.emf.eef.runtime.policies.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.eef.runtime.impl.policies.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyWithResult;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class CreateEditingPolicy implements PropertiesEditingPolicyWithResult {

	private EReferencePropertiesEditionContext editionContext;
	private EObject result;

	/**
	 * @param editionContext
	 */
	public CreateEditingPolicy(EReferencePropertiesEditionContext editionContext) {
		this.editionContext = editionContext;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy#execute()
	 */
	public void execute() {
		PropertiesEditionWizard wizard = new PropertiesEditionWizard(null, editionContext.getEReference(), editionContext.getResourceSet());
		WizardDialog wDialog = new WizardDialog(EditingUtils.getShell(), wizard);
		int executionResult = wDialog.open();
		result = wizard.getEObject();
		ChangeDescription change = editionContext.getChangeRecorder().endRecording();
		if (executionResult == Window.CANCEL)
			change.applyAndReverse();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyWithResult#getResult()
	 */
	public Object getResult() {
		return result;
	}

}

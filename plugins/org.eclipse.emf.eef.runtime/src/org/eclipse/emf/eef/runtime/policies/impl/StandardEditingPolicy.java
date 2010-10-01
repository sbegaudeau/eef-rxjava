/**
 * 
 */
package org.eclipse.emf.eef.runtime.policies.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.eef.runtime.impl.policies.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 *
 */
public class StandardEditingPolicy implements PropertiesEditingPolicy {

	private EObjectPropertiesEditionContext context;

	/**
	 * @param propertiesEditionContext
	 */
	public StandardEditingPolicy(EObjectPropertiesEditionContext propertiesEditionContext) {
		this.context = propertiesEditionContext;
	}



	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy#execute()
	 */
	public void execute() {
		EObjectPropertiesEditionContext editionContext = (EObjectPropertiesEditionContext)context;
		EObject eObject = editionContext.getEObject();
		PropertiesEditionWizard wizard = new PropertiesEditionWizard(null, eObject, editionContext.getResourceSet());
		WizardDialog wDialog = new WizardDialog(EditingUtils.getShell(), wizard);
		int result = wDialog.open();
		ChangeDescription change = editionContext.getChangeRecorder().endRecording();
		if (result == Window.CANCEL) {
			change.applyAndReverse();
		}
	}
}

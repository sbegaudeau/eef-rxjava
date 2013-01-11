
package org.eclipse.emf.eef.runtime.ui.wizards.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.wizards.EEFWizardDialog;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy;
import org.eclipse.jface.window.Window;

/**
 * Standard policy for wizard opening.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class StandardWizardOpeningPolicy implements IWizardOpeningPolicy {

	private ChangeDescription description;

	/** (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy#openWizard(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext, org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard)
	 */
	public boolean openWizard(PropertiesEditingContext editionContext, PropertiesEditionWizard wizard) {
		EEFWizardDialog wDialog = new EEFWizardDialog(EditingUtils.getShell(), wizard);
		int open = wDialog.open();
		ChangeRecorder changeRecorder = editionContext.getChangeRecorder();
		if (changeRecorder != null) {
			description = changeRecorder.endRecording();
		}
		if (open == Window.OK) {
			return true;
		} else {
			if (description != null) {
				description.applyAndReverse();
			}
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy#getDescription()
	 */
	public ChangeDescription getDescription() {
		return description;
	}

	/** (non-Javadoc)
	 * @see org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy#provide(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provide(EObject eObject) {
		return true;
	}

}

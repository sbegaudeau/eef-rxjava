/**
 * 
 */
package org.eclipse.emf.eef.runtime.impl.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.ui.UIConstants;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Point;

/**
 * @author glefur
 *
 */
public class WizardEditingOperation extends AbstractEMFOperation {

	private PropertiesEditingContext editingContext;

	/**
	 * @param domain
	 * @param label
	 */
	public WizardEditingOperation(DomainPropertiesEditionContext editingContext) {
		super((TransactionalEditingDomain) editingContext.getEditingDomain(), "EEF Editing Operaiton");
		this.editingContext = editingContext;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.workspace.AbstractEMFOperation#doExecute(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		PropertiesEditionWizard wizard = new PropertiesEditionWizard(editingContext, editingContext.getAdapterFactory(), editingContext.getEObject());
		WizardDialog wDialog = new WizardDialog(EditingUtils.getShell(), wizard) {
			
			/**
			 * {@inheritDoc}
			 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
			 */
			@Override
			protected Point getInitialSize() {
				return UIConstants.INITIAL_WIZARD_SIZE;
			}
			
		};
		int open = wDialog.open();
		ChangeDescription description = editingContext.getChangeRecorder().endRecording();
		if (open == Window.OK) {
			return Status.OK_STATUS;
		} else {
			description.applyAndReverse();
			return Status.CANCEL_STATUS;
		}
	}

}

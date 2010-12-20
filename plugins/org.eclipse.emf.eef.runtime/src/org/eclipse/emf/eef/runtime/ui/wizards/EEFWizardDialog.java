/**
 * 
 */
package org.eclipse.emf.eef.runtime.ui.wizards;

import org.eclipse.emf.eef.runtime.ui.UIConstants;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * @author sbouchet
 */
public class EEFWizardDialog extends WizardDialog {

	private Button _finishButton;

	public EEFWizardDialog(Shell shell, IWizard wizard) {
		super(shell, wizard);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#getInitialSize()
	 */
	@Override
	protected Point getInitialSize() {
		return UIConstants.INITIAL_WIZARD_SIZE;
	}

	@Override
	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		_finishButton = super.createButton(parent, id, label, false);
		return _finishButton;
	}

	@Override
	public void updateButtons() {
		boolean canFinish = getWizard().canFinish();
		_finishButton.setEnabled(canFinish);
	}
}

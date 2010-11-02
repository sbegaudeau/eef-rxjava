/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.command;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.ui.UIConstants;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.graphics.Point;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class WizardEditingCommand extends AbstractCommand {
	
	private DomainPropertiesEditionContext editionContext;
	
	private ChangeDescription description;

	/**
	 * @param editionContext
	 */
	public WizardEditingCommand(DomainPropertiesEditionContext editionContext) {
		this.editionContext = editionContext;
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#prepare()
	 */
	@Override
	protected boolean prepare() {
		PropertiesEditionWizard wizard = new PropertiesEditionWizard(editionContext, editionContext.getAdapterFactory(), editionContext.getEObject());
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
		description = editionContext.getChangeRecorder().endRecording();
		if (open == Window.OK) {
			return true;
		} else {
			description.applyAndReverse();
			return false;
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.AbstractCommand#undo()
	 */
	@Override
	public void undo() {
		description.applyAndReverse();
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {
		description.applyAndReverse();
	}
	

}

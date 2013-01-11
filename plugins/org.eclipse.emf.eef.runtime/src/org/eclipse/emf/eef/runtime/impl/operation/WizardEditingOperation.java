/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.operation;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.WizardOpeningPolicyProviderService;
import org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;

/**
 * @author glefur
 */
public class WizardEditingOperation extends AbstractEMFOperation {

	protected PropertiesEditingContext editingContext;

	/**
	 * @param domain
	 * @param label
	 */
	public WizardEditingOperation(DomainPropertiesEditionContext editingContext) {
		super((TransactionalEditingDomain)editingContext.getEditingDomain(), "EEF Editing Operaiton");
		this.editingContext = editingContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.workspace.AbstractEMFOperation#doExecute(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		PropertiesEditionWizard wizard = new PropertiesEditionWizard(editingContext,
				editingContext.getAdapterFactory(), editingContext.getEObject());
		IWizardOpeningPolicy wizardOpeningPolicy = WizardOpeningPolicyProviderService.provide(editingContext.getEObject());
		boolean open = wizardOpeningPolicy.openWizard(editingContext, wizard);
		if (open) {
			return Status.OK_STATUS;
		} else {
			return Status.CANCEL_STATUS;
		}
	}

}

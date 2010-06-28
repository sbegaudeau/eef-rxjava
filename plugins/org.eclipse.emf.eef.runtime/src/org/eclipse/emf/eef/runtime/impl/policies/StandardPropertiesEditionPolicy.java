/*******************************************************************************
 * Copyright (c) 2008, 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.runtime.impl.policies;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.command.WizardEditingCommand;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class StandardPropertiesEditionPolicy implements IPropertiesEditionPolicy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy#getPropertiesEditionCommand(org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext)
	 */
	public Command getPropertiesEditionCommand(IPropertiesEditionContext propertiesEditionContext) {
		final DomainPropertiesEditionContext editionContext = (DomainPropertiesEditionContext)propertiesEditionContext;
		final EObject eObject = editionContext.getEObject();
		IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(
				eObject);
		if (provider != null) {
			return new WizardEditingCommand(editionContext);
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy#getPropertiesEditionObject(org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext)
	 */
	public void getPropertiesEditionObject(IPropertiesEditionContext propertiesEditionContext) {
		if (propertiesEditionContext instanceof EObjectPropertiesEditionContext) {
			EObjectPropertiesEditionContext editionContext = (EObjectPropertiesEditionContext)propertiesEditionContext;
			EObject eObject = editionContext.getEObject();
			PropertiesEditionWizard wizard = new PropertiesEditionWizard(null, eObject, editionContext.getResourceSet());
			WizardDialog wDialog = new WizardDialog(EditingUtils.getShell(), wizard);
			int result = wDialog.open();
			ChangeDescription change = editionContext.getChangeRecorder().endRecording();
			if (result == Window.CANCEL) {
				change.applyAndReverse();
			}
		} else if (propertiesEditionContext instanceof EReferencePropertiesEditionContext) {
			EReferencePropertiesEditionContext editionContext = (EReferencePropertiesEditionContext)propertiesEditionContext;
			PropertiesEditionWizard wizard = new PropertiesEditionWizard(null,
					editionContext.getEReference(), editionContext.getResourceSet());
			WizardDialog wDialog = new WizardDialog(EditingUtils.getShell(), wizard);
			int result = wDialog.open();
			ChangeDescription change = editionContext.getChangeRecorder().endRecording();
			if (result == Window.CANCEL)
				change.applyAndReverse();
		}
	}

}

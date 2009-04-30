/*******************************************************************************
 * Copyright (c) 2008-2009 Obeo.
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
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.emf.eef.runtime.ui.wizards.AbstractPropertyWizard;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;

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
		DomainPropertiesEditionContext editionContext = (DomainPropertiesEditionContext)propertiesEditionContext;
		EObject eObject = editionContext.getEObject();
		IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(
				eObject);
		if (provider != null) {
			AbstractPropertyWizard wizard = new AbstractPropertyWizard(editionContext.getEditingDomain(),
					eObject, editionContext.getEditingDomain().getResourceSet());
			WizardDialog wDialog = new WizardDialog(new Shell(), wizard);
			if (wDialog.open() == Window.OK)
				return wizard.getCommand();
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy#getPropertiesEditionObject(org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionContext)
	 */
	public EObject getPropertiesEditionObject(IPropertiesEditionContext propertiesEditionContext) {
		if (propertiesEditionContext instanceof EObjectPropertiesEditionContext) {
			EObjectPropertiesEditionContext editionContext = (EObjectPropertiesEditionContext)propertiesEditionContext;
			EObject eObject = editionContext.getEObject();
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance()
					.getProvider(eObject);
			if (provider != null) {
				AbstractPropertyWizard wizard = new AbstractPropertyWizard(null, eObject, editionContext
						.getResourceSet());
				WizardDialog wDialog = new WizardDialog(new Shell(), wizard);
				if (wDialog.open() == Window.OK)
					return wizard.getEObject();
			}
		}
		return null;
	}

}

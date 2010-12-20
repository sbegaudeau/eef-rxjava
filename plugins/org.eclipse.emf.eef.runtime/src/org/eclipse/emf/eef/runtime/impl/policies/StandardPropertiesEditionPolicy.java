/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.command.WizardEditingCommand;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.wizards.EEFWizardDialog;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.eclipse.jface.window.Window;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class StandardPropertiesEditionPolicy implements IPropertiesEditionPolicy {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy#getPropertiesEditionCommand(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext)
	 */
	public Command getPropertiesEditionCommand(PropertiesEditingContext propertiesEditionContext) {
		final DomainPropertiesEditionContext editionContext = (DomainPropertiesEditionContext)propertiesEditionContext;
		final EObject eObject = editionContext.getEObject();
		Adapter provider = editionContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
		if (provider != null) {
			return new WizardEditingCommand(editionContext);
		}

		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy#getPropertiesEditionObject(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext)
	 */
	public void getPropertiesEditionObject(PropertiesEditingContext propertiesEditionContext) {
		if (propertiesEditionContext instanceof EObjectPropertiesEditionContext) {
			EObjectPropertiesEditionContext editingContext = (EObjectPropertiesEditionContext)propertiesEditionContext;
			PropertiesEditionWizard wizard = new PropertiesEditionWizard(null,
					editingContext.getAdapterFactory(), editingContext.getEObject());
			EEFWizardDialog wDialog = new EEFWizardDialog(EditingUtils.getShell(), wizard);
			int result = wDialog.open();
			ChangeDescription change = editingContext.getChangeRecorder().endRecording();
			if (result == Window.CANCEL) {
				change.applyAndReverse();
			}
		} else if (propertiesEditionContext instanceof EReferencePropertiesEditionContext) {
			EReferencePropertiesEditionContext editionContext = (EReferencePropertiesEditionContext)propertiesEditionContext;
			PropertiesEditionWizard wizard = new PropertiesEditionWizard(null,
					editionContext.getAdapterFactory(), editionContext.getEReference());
			EEFWizardDialog wDialog = new EEFWizardDialog(EditingUtils.getShell(), wizard);
			int result = wDialog.open();
			ChangeDescription change = editionContext.getChangeRecorder().endRecording();
			if (result == Window.CANCEL)
				change.applyAndReverse();
		}
	}

}

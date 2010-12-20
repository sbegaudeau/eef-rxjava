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
package org.eclipse.emf.eef.runtime.policies.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.wizards.EEFWizardDialog;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;
import org.eclipse.jface.window.Window;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
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
	 * 
	 * @see org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy#execute()
	 */
	public void execute() {
		EObjectPropertiesEditionContext editionContext = (EObjectPropertiesEditionContext)context;
		EObject eObject = editionContext.getEObject();
		PropertiesEditionWizard wizard = new PropertiesEditionWizard(editionContext,
				editionContext.getAdapterFactory(), eObject);
		EEFWizardDialog wDialog = new EEFWizardDialog(EditingUtils.getShell(), wizard);
		int result = wDialog.open();
		ChangeDescription change = editionContext.getChangeRecorder().endRecording();
		if (result == Window.CANCEL) {
			change.applyAndReverse();
		}
	}
}

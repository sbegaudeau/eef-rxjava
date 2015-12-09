/*******************************************************************************
 * Copyright (c) 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.cdo.runtime.policies;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.util.CDOUtil;
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
 * CDO policy for wizard opening : if object is locked, no opening.
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class CDOWizardOpeningPolicy implements IWizardOpeningPolicy {

	private ChangeDescription description;

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy#openWizard(org.eclipse.emf.eef.runtime.context.PropertiesEditingContext,
	 *      org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard)
	 */
	public boolean openWizard(PropertiesEditingContext editionContext,
			PropertiesEditionWizard wizard) {
		CDOReadOnlyPolicy cdoReadOnlyPolicy = new CDOReadOnlyPolicy();
		if (!cdoReadOnlyPolicy.isReadOnly(editionContext.getEObject(), null)) {
			EEFWizardDialog wDialog = new EEFWizardDialog(
					EditingUtils.getShell(), wizard);
			int open = wDialog.open();
			ChangeRecorder changeRecorder = editionContext.getChangeRecorder();
			if (changeRecorder != null) {
				description = changeRecorder.endRecording();
			} else {
				description = null;
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
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy#getDescription()
	 */
	public ChangeDescription getDescription() {
		return description;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy#provide(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provide(EObject eObject) {
		CDOObject cdoObject = CDOUtil.getCDOObject(eObject);
		return cdoObject != null;
	}

}

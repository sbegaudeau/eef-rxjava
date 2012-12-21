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
package org.eclipse.emf.eef.runtime.ui.wizards;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

/**
 * Policy for wizard opening
 * 
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public interface IWizardOpeningPolicy {

	/**
	 * Open properties wizard.
	 * 
	 * @param context PropertiesEditingContext
	 * @param wizard PropertiesEditionWizard
	 * @return if the wizard is opend or canceled.
	 */
	boolean openWizard(PropertiesEditingContext context, PropertiesEditionWizard wizard);
	
	/**
	 * @return the {@link ChangeDescription} of changes perform during editing session.
	 */
	ChangeDescription getDescription();

	/**
	 * @param eObject EObject
	 * @return if eObject is provided by the policy.
	 */
	boolean provide(EObject eObject);
	
}

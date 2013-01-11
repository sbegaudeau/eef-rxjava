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
package org.eclipse.emf.eef.runtime.policies.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.services.WizardOpeningPolicyProviderService;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class StandardEditingPolicy implements PropertiesEditingPolicy {

	protected PropertiesEditingContext context;

	/**
	 * @param propertiesEditionContext
	 */
	public StandardEditingPolicy(PropertiesEditingContext propertiesEditionContext) {
		this.context = propertiesEditionContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy#execute()
	 */
	public void execute() {
		PropertiesEditingContext editionContext = (PropertiesEditingContext)context;
		EObject eObject = editionContext.getEObject();
		PropertiesEditionWizard wizard = new PropertiesEditionWizard(editionContext,
				editionContext.getAdapterFactory(), eObject);
		IWizardOpeningPolicy wizardOpeningPolicy = WizardOpeningPolicyProviderService.provide(eObject);
		wizardOpeningPolicy.openWizard(context, wizard);
		editionContext.dispose();
	}

}

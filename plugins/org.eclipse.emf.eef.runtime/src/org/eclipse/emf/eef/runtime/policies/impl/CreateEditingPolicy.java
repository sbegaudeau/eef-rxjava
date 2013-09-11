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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.TypedEReferencePropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.services.WizardOpeningPolicyProviderService;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyWithResult;
import org.eclipse.emf.eef.runtime.ui.wizards.IWizardOpeningPolicy;
import org.eclipse.emf.eef.runtime.ui.wizards.PropertiesEditionWizard;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class CreateEditingPolicy implements PropertiesEditingPolicyWithResult {

	protected EReferencePropertiesEditionContext editionContext;

	protected EObject result;

	/**
	 * @param editionContext
	 */
	public CreateEditingPolicy(EReferencePropertiesEditionContext editionContext) {
		this.editionContext = editionContext;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy#execute()
	 */
	public void execute() {
		editionContext.initializeRecorder();
		EClassifier eType = editionContext.getEReference().getEType();
		PropertiesEditionWizard wizard;
		if (editionContext instanceof TypedEReferencePropertiesEditingContext) {
			EObject create = EcoreUtil.create(((TypedEReferencePropertiesEditingContext)editionContext).getExpectedType()); 
			editionContext.seteObject(create);
			if (editionContext.getSettings() != null) {
				EEFUtils.putToReference(editionContext.getSettings(), create);
			}
			wizard = new PropertiesEditionWizard(editionContext, editionContext.getAdapterFactory(), create);
		} else if (eType instanceof EClass && ((EClass)eType).isAbstract()) {
			wizard = new PropertiesEditionWizard(editionContext, editionContext.getAdapterFactory(), editionContext.getEReference());
		} else {
			EObject create = EcoreUtil.create((EClass)eType);
			editionContext.seteObject(create);
			if (editionContext.getSettings() != null) {
				EEFUtils.putToReference(editionContext.getSettings(), create);
			}
			wizard = new PropertiesEditionWizard(editionContext, editionContext.getAdapterFactory(), create);
		}
		IWizardOpeningPolicy wizardOpeningPolicy = WizardOpeningPolicyProviderService.provide(editionContext.getEObject());
		boolean open = wizardOpeningPolicy.openWizard(editionContext, wizard);
		if (open) {
			result = wizard.getEObject();
		} else{
			result = null;
		}
		editionContext.dispose();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicyWithResult#getResult()
	 */
	public Object getResult() {
		return result;
	}

}

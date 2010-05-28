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
package org.eclipse.emf.eef.runtime.ui.notify;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.eef.runtime.api.policies.IPropertiesEditionPolicy;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPolicyProvider;
import org.eclipse.emf.eef.runtime.impl.policies.DomainPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionPolicyProviderService;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class OpenWizardOnDoubleClick implements IDoubleClickListener {

	private EditingDomain editingDomain;

	/**
	 * @param editingDomain
	 */
	public OpenWizardOnDoubleClick(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IDoubleClickListener#doubleClick(org.eclipse.jface.viewers.DoubleClickEvent)
	 */
	public void doubleClick(DoubleClickEvent event) {
		ISelection selection = event.getSelection();
		if (selection instanceof StructuredSelection) {
			EObject eObject = null;
			Object firstElement = ((StructuredSelection)selection).getFirstElement();
			if (firstElement instanceof EObject) {
				eObject = (EObject)firstElement;
			} else if (firstElement instanceof IAdaptable) {
				if (((IAdaptable)firstElement).getAdapter(EObject.class) != null)
					eObject = (EObject)((IAdaptable)firstElement).getAdapter(EObject.class);
			}
			if (eObject != null) {
				IPropertiesEditionPolicyProvider policyProvider = PropertiesEditionPolicyProviderService
						.getInstance().getProvider(eObject);
				if (policyProvider != null) {
					IPropertiesEditionPolicy editionPolicy = policyProvider.getEditionPolicy(eObject);
					if (editionPolicy != null) {
						Command propertiesEditionCommand = editionPolicy
								.getPropertiesEditionCommand(new DomainPropertiesEditionContext(null,
										editingDomain, eObject));
						editingDomain.getCommandStack().execute(propertiesEditionCommand);
					}
				}
			}
		}
	}

}

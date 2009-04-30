/**
 *  Copyright (c) 2008-2009 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: EMFMultiPropertiesBindingPropertiesEditionProvider.java,v 1.1 2009/04/30 17:14:43 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.providers;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

import org.eclipse.emf.eef.mapping.MappingPackage;
import org.eclipse.emf.eef.mapping.EMFMultiPropertiesBinding;
import org.eclipse.emf.eef.mapping.components.EMFMultiPropertiesBindingPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.components.EMFMultiPropertiesBindingBasePropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.parts.impl.EMFMultiPropertiesBindingPropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.EMFMultiPropertiesBindingPropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.parts.impl.DocumentationPropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.DocumentationPropertiesEditionPartForm;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EMFMultiPropertiesBindingPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof EMFMultiPropertiesBinding) && (MappingPackage.eINSTANCE.getEMFMultiPropertiesBinding() == eObject.eClass());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String mode) {
		if (eObject instanceof EMFMultiPropertiesBinding) {
			return new EMFMultiPropertiesBindingPropertiesEditionComponent(eObject, mode);
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String mode, String part) {
		if (eObject instanceof EMFMultiPropertiesBinding) {
			if (EMFMultiPropertiesBindingBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new EMFMultiPropertiesBindingBasePropertiesEditionComponent(eObject, mode);
			if (DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART.equals(part))
				return new DocumentedElementPropertiesEditionComponent(eObject, mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionPart(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent, java.lang.String,
	 *      java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(EObject eObject,
			IPropertiesEditionComponent editionComponent, String part, String kind) {
		if (eObject instanceof EMFMultiPropertiesBinding) {
			if (EMFMultiPropertiesBindingPropertiesEditionComponent.SWT_KIND.equals(kind)) {
				if (EMFMultiPropertiesBindingBasePropertiesEditionComponent.BASE_PART.equals(part))
					return new EMFMultiPropertiesBindingPropertiesEditionPartImpl(editionComponent);
				if (DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART.equals(part))
					return new DocumentationPropertiesEditionPartImpl(editionComponent);
			}
		}
		if (EMFMultiPropertiesBindingPropertiesEditionComponent.FORM_KIND.equals(kind)) {
				if (EMFMultiPropertiesBindingBasePropertiesEditionComponent.BASE_PART.equals(part))
					return new EMFMultiPropertiesBindingPropertiesEditionPartForm(editionComponent);
				if (DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART.equals(part))
					return new DocumentationPropertiesEditionPartForm(editionComponent);
		}
		return null;
	}
	
}	

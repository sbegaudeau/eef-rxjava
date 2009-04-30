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
 * $Id: ViewsRepositoryPropertiesEditionProvider.java,v 1.1 2009/04/30 17:16:51 glefur Exp $
 */
package org.eclipse.emf.eef.views.providers;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

import org.eclipse.emf.eef.views.ViewsPackage;
import org.eclipse.emf.eef.views.ViewsRepository;
import org.eclipse.emf.eef.views.components.ViewsRepositoryPropertiesEditionComponent;
import org.eclipse.emf.eef.views.components.ViewsRepositoryBasePropertiesEditionComponent;
import org.eclipse.emf.eef.views.parts.impl.ViewsRepositoryPropertiesEditionPartImpl;
import org.eclipse.emf.eef.views.parts.forms.ViewsRepositoryPropertiesEditionPartForm;
import org.eclipse.emf.eef.views.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.eef.views.parts.impl.DocumentationPropertiesEditionPartImpl;
import org.eclipse.emf.eef.views.parts.forms.DocumentationPropertiesEditionPartForm;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ViewsRepositoryPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof ViewsRepository) && (ViewsPackage.eINSTANCE.getViewsRepository() == eObject.eClass());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String mode) {
		if (eObject instanceof ViewsRepository) {
			return new ViewsRepositoryPropertiesEditionComponent(eObject, mode);
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
		if (eObject instanceof ViewsRepository) {
			if (ViewsRepositoryBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new ViewsRepositoryBasePropertiesEditionComponent(eObject, mode);
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
		if (eObject instanceof ViewsRepository) {
			if (ViewsRepositoryPropertiesEditionComponent.SWT_KIND.equals(kind)) {
				if (ViewsRepositoryBasePropertiesEditionComponent.BASE_PART.equals(part))
					return new ViewsRepositoryPropertiesEditionPartImpl(editionComponent);
				if (DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART.equals(part))
					return new DocumentationPropertiesEditionPartImpl(editionComponent);
			}
		}
		if (ViewsRepositoryPropertiesEditionComponent.FORM_KIND.equals(kind)) {
				if (ViewsRepositoryBasePropertiesEditionComponent.BASE_PART.equals(part))
					return new ViewsRepositoryPropertiesEditionPartForm(editionComponent);
				if (DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART.equals(part))
					return new DocumentationPropertiesEditionPartForm(editionComponent);
		}
		return null;
	}
	
}	

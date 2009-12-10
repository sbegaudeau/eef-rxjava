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
 * $Id: PropertiesEditionElementPropertiesEditionComponent.java,v 1.10 2009/12/10 15:51:27 sbouchet Exp $
 */
package org.eclipse.emf.eef.components.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.components.parts.ComponentsViewsRepository;
import org.eclipse.emf.eef.components.parts.PropertiesEditionElementPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class PropertiesEditionElementPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private PropertiesEditionElementPropertiesEditionPart basePart;

	/**
	 * The PropertiesEditionElementBasePropertiesEditionComponent sub component
	 */
	protected PropertiesEditionElementBasePropertiesEditionComponent propertiesEditionElementBasePropertiesEditionComponent;

	/**
	 * The DocumentedElementPropertiesEditionComponent sub component
	 */
	protected DocumentedElementPropertiesEditionComponent documentedElementPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param propertiesEditionElement
	 *            the EObject to edit
	 */
	public PropertiesEditionElementPropertiesEditionComponent(EObject propertiesEditionElement, String editing_mode) {
		super(editing_mode);
		if (propertiesEditionElement instanceof PropertiesEditionElement) {
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(propertiesEditionElement);
			propertiesEditionElementBasePropertiesEditionComponent = (PropertiesEditionElementBasePropertiesEditionComponent)provider.getPropertiesEditionComponent(propertiesEditionElement, editing_mode, PropertiesEditionElementBasePropertiesEditionComponent.BASE_PART);
			addSubComponent(propertiesEditionElementBasePropertiesEditionComponent);
			documentedElementPropertiesEditionComponent = (DocumentedElementPropertiesEditionComponent)provider.getPropertiesEditionComponent(propertiesEditionElement, editing_mode, DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART);
			addSubComponent(documentedElementPropertiesEditionComponent);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *  getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (PropertiesEditionElementBasePropertiesEditionComponent.BASE_PART.equals(key)) {
			basePart = (PropertiesEditionElementPropertiesEditionPart)propertiesEditionElementBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)basePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *  setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (ComponentsViewsRepository.PropertiesEditionElement.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (PropertiesEditionElementPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *  initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == ComponentsViewsRepository.PropertiesEditionElement.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == ComponentsViewsRepository.Documentation.class) {
			super.initPart(key, kind, element, allResource);
		
		}
	}
}

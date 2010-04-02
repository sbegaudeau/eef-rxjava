/**
 *  Copyright (c) 2008 - 2010 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 *
 */
package org.eclipse.emf.eef.components.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.components.PropertiesEditionComponent;
import org.eclipse.emf.eef.components.parts.ComponentsViewsRepository;
import org.eclipse.emf.eef.components.parts.PropertiesEditionComponentPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 * 
 */
public class PropertiesEditionComponentPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 * 
	 */
	private PropertiesEditionComponentPropertiesEditionPart basePart;

	/**
	 * The PropertiesEditionComponentBasePropertiesEditionComponent sub component
	 * 
	 */
	protected PropertiesEditionComponentBasePropertiesEditionComponent propertiesEditionComponentBasePropertiesEditionComponent;
	/**
	 * The DocumentedElementPropertiesEditionComponent sub component
	 * 
	 */
	protected DocumentedElementPropertiesEditionComponent documentedElementPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param propertiesEditionComponent the EObject to edit
	 * 
	 */
	public PropertiesEditionComponentPropertiesEditionComponent(EObject propertiesEditionComponent, String editing_mode) {
		super(editing_mode);
		if (propertiesEditionComponent instanceof PropertiesEditionComponent) {
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(propertiesEditionComponent);
			propertiesEditionComponentBasePropertiesEditionComponent = (PropertiesEditionComponentBasePropertiesEditionComponent)provider.getPropertiesEditionComponent(propertiesEditionComponent, editing_mode, PropertiesEditionComponentBasePropertiesEditionComponent.BASE_PART, PropertiesEditionComponentBasePropertiesEditionComponent.class);
			addSubComponent(propertiesEditionComponentBasePropertiesEditionComponent);
			documentedElementPropertiesEditionComponent = (DocumentedElementPropertiesEditionComponent)provider.getPropertiesEditionComponent(propertiesEditionComponent, editing_mode, DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART, DocumentedElementPropertiesEditionComponent.class);
			addSubComponent(documentedElementPropertiesEditionComponent);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      getPropertiesEditionPart(int, java.lang.String)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (PropertiesEditionComponentBasePropertiesEditionComponent.BASE_PART.equals(key)) {
			basePart = (PropertiesEditionComponentPropertiesEditionPart)propertiesEditionComponentBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)basePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      setPropertiesEditionPart(java.lang.Class, int,
	 *      org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 * 
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (ComponentsViewsRepository.PropertiesEditionComponent.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (PropertiesEditionComponentPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *      initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == ComponentsViewsRepository.PropertiesEditionComponent.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == MappingViewsRepository.Documentation.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}

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
 */
package org.eclipse.emf.eef.views.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.services.PropertiesEditionComponentService;
import org.eclipse.emf.eef.views.Category;
import org.eclipse.emf.eef.views.parts.CategoryPropertiesEditionPart;
import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class CategoryPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private CategoryPropertiesEditionPart basePart;

	/**
	 * The CategoryBasePropertiesEditionComponent sub component
	 */
	protected CategoryBasePropertiesEditionComponent categoryBasePropertiesEditionComponent;

	/**
	 * The DocumentedElementPropertiesEditionComponent sub component
	 */
	protected DocumentedElementPropertiesEditionComponent documentedElementPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param category
	 *            the EObject to edit
	 */
	public CategoryPropertiesEditionComponent(EObject category, String editing_mode) {
		super(editing_mode);
		if (category instanceof Category) {
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(category);
			categoryBasePropertiesEditionComponent = (CategoryBasePropertiesEditionComponent)provider.getPropertiesEditionComponent(category, editing_mode, CategoryBasePropertiesEditionComponent.BASE_PART);
			addSubComponent(categoryBasePropertiesEditionComponent);
			documentedElementPropertiesEditionComponent = (DocumentedElementPropertiesEditionComponent)provider.getPropertiesEditionComponent(category, editing_mode, DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART);
			addSubComponent(documentedElementPropertiesEditionComponent);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *  getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (CategoryBasePropertiesEditionComponent.BASE_PART.equals(key)) {
			basePart = (CategoryPropertiesEditionPart)categoryBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
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
		if (ViewsViewsRepository.Category.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (CategoryPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *  initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == ViewsViewsRepository.Category.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == ViewsViewsRepository.Documentation.class) {
			super.initPart(key, kind, element, allResource);
		
		}
	}
}

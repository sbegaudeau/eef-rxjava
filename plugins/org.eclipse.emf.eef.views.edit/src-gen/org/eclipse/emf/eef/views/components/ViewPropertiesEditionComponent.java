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
import org.eclipse.emf.eef.views.View;
import org.eclipse.emf.eef.views.parts.ViewPropertiesEditionPart;
import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ViewPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private ViewPropertiesEditionPart basePart;

	/**
	 * The ViewBasePropertiesEditionComponent sub component
	 */
	protected ViewBasePropertiesEditionComponent viewBasePropertiesEditionComponent;

	/**
	 * The DocumentedElementPropertiesEditionComponent sub component
	 */
	protected DocumentedElementPropertiesEditionComponent documentedElementPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param view
	 *            the EObject to edit
	 */
	public ViewPropertiesEditionComponent(EObject view, String editing_mode) {
		super(editing_mode);
		if (view instanceof View) {
			IPropertiesEditionProvider provider = PropertiesEditionComponentService.getInstance().getProvider(view);
			viewBasePropertiesEditionComponent = (ViewBasePropertiesEditionComponent)provider.getPropertiesEditionComponent(view, editing_mode, ViewBasePropertiesEditionComponent.BASE_PART);
			addSubComponent(viewBasePropertiesEditionComponent);
			documentedElementPropertiesEditionComponent = (DocumentedElementPropertiesEditionComponent)provider.getPropertiesEditionComponent(view, editing_mode, DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART);
			addSubComponent(documentedElementPropertiesEditionComponent);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *  getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if (ViewBasePropertiesEditionComponent.BASE_PART.equals(key)) {
			basePart = (ViewPropertiesEditionPart)viewBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
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
		if (ViewsViewsRepository.View.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (ViewPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 *  initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == ViewsViewsRepository.View.class) {
			super.initPart(key, kind, element, allResource);
		}
		if (key == ViewsViewsRepository.Documentation.class) {
			super.initPart(key, kind, element, allResource);
		
		}
	}
}

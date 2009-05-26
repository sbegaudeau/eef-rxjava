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
 * $Id$
 */
package org.eclipse.emf.eef.filters.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.filters.OnlyReferenceTypeFilter;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.parts.OnlyReferenceTypeFilterPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class OnlyReferenceTypeFilterPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private OnlyReferenceTypeFilterPropertiesEditionPart basePart;

	/**
	 * The OnlyReferenceTypeFilterBasePropertiesEditionComponent sub component
	 */
	protected OnlyReferenceTypeFilterBasePropertiesEditionComponent onlyReferenceTypeFilterBasePropertiesEditionComponent;

	/**
	 * The DocumentedElementPropertiesEditionComponent sub component
	 */
	protected DocumentedElementPropertiesEditionComponent documentedElementPropertiesEditionComponent;
	/**
	 * The FilterPropertiesPropertiesEditionComponent sub component
	 */
	protected FilterPropertiesPropertiesEditionComponent filterPropertiesPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param onlyReferenceTypeFilter
	 *            the EObject to edit
	 */
	public OnlyReferenceTypeFilterPropertiesEditionComponent(EObject onlyReferenceTypeFilter, String editing_mode) {
		super(editing_mode);
		if (onlyReferenceTypeFilter instanceof OnlyReferenceTypeFilter) {
			onlyReferenceTypeFilterBasePropertiesEditionComponent = new OnlyReferenceTypeFilterBasePropertiesEditionComponent(onlyReferenceTypeFilter, editing_mode); 
			addSubComponent(onlyReferenceTypeFilterBasePropertiesEditionComponent);
			documentedElementPropertiesEditionComponent = new DocumentedElementPropertiesEditionComponent(onlyReferenceTypeFilter, editing_mode); 	
			addSubComponent(documentedElementPropertiesEditionComponent);
			filterPropertiesPropertiesEditionComponent = new FilterPropertiesPropertiesEditionComponent(onlyReferenceTypeFilter, editing_mode); 	
			addSubComponent(filterPropertiesPropertiesEditionComponent);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 * 		getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if ("Base".equals(key)) {
			basePart = (OnlyReferenceTypeFilterPropertiesEditionPart)onlyReferenceTypeFilterBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
			return (IPropertiesEditionPart)basePart;
		}
		return super.getPropertiesEditionPart(kind, key);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 * setPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart)
	 */
	public void setPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionPart propertiesEditionPart) {
		if (MappingViewsRepository.OnlyReferenceTypeFilter.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (OnlyReferenceTypeFilterPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent
	 *	#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == MappingViewsRepository.OnlyReferenceTypeFilter.class) {
			super.initPart(key, kind, element, allResource);
			filterPropertiesPropertiesEditionComponent.setPropertiesEditionPart(MappingViewsRepository.FilterProperties.class, kind, basePart.getFilterPropertiesReferencedView());
			filterPropertiesPropertiesEditionComponent.initPart(MappingViewsRepository.FilterProperties.class, kind, element, allResource);			
		}
	}
}


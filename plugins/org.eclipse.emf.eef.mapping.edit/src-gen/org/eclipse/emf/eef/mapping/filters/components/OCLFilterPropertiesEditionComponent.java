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
 * $Id: OCLFilterPropertiesEditionComponent.java,v 1.1 2009/07/31 14:07:31 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.filters.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.filters.OCLFilter;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.mapping.parts.OCLFilterPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class OCLFilterPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private OCLFilterPropertiesEditionPart basePart;

	/**
	 * The OCLFilterBasePropertiesEditionComponent sub component
	 */
	protected OCLFilterBasePropertiesEditionComponent oCLFilterBasePropertiesEditionComponent;

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
	 * @param oCLFilter
	 *            the EObject to edit
	 */
	public OCLFilterPropertiesEditionComponent(EObject oCLFilter, String editing_mode) {
		super(editing_mode);
		if (oCLFilter instanceof OCLFilter) {
			oCLFilterBasePropertiesEditionComponent = new OCLFilterBasePropertiesEditionComponent(oCLFilter, editing_mode); 
			addSubComponent(oCLFilterBasePropertiesEditionComponent);
			documentedElementPropertiesEditionComponent = new DocumentedElementPropertiesEditionComponent(oCLFilter, editing_mode);
			addSubComponent(documentedElementPropertiesEditionComponent);
			filterPropertiesPropertiesEditionComponent = new FilterPropertiesPropertiesEditionComponent(oCLFilter, editing_mode);
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
			basePart = (OCLFilterPropertiesEditionPart)oCLFilterBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
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
		if (MappingViewsRepository.OCLFilter.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (OCLFilterPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent
	 *	#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == MappingViewsRepository.OCLFilter.class) {
			super.initPart(key, kind, element, allResource);
			filterPropertiesPropertiesEditionComponent.setPropertiesEditionPart(MappingViewsRepository.FilterProperties.class, kind, basePart.getFilterPropertiesReferencedView());
			filterPropertiesPropertiesEditionComponent.initPart(MappingViewsRepository.FilterProperties.class, kind, element, allResource);
		}
			if (key == MappingViewsRepository.Documentation.class) {
				super.initPart(key, kind, element, allResource);
			
			
			}
			if (key == MappingViewsRepository.FilterProperties.class) {
				super.initPart(key, kind, element, allResource);
			
			
			}
	}
}


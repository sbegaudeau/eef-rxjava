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
package org.eclipse.emf.eef.mapping.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.mapping.filters.JavaExpressionFilter;
import org.eclipse.emf.eef.mapping.parts.JavaExpressionFilterPropertiesEditionPart;
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
public class JavaExpressionFilterPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 * 
	 */
	private JavaExpressionFilterPropertiesEditionPart basePart;

	/**
	 * The JavaExpressionFilterBasePropertiesEditionComponent sub component
	 * 
	 */
	protected JavaExpressionFilterBasePropertiesEditionComponent javaExpressionFilterBasePropertiesEditionComponent;
	/**
	 * The DocumentedElementPropertiesEditionComponent sub component
	 * 
	 */
	protected DocumentedElementPropertiesEditionComponent documentedElementPropertiesEditionComponent;

	/**
	 * The FilterPropertiesPropertiesEditionComponent sub component
	 * 
	 */
	protected FilterPropertiesPropertiesEditionComponent filterPropertiesPropertiesEditionComponent;

	/**
	 * Parameterized constructor
	 * 
	 * @param javaExpressionFilter the EObject to edit
	 * 
	 */
	public JavaExpressionFilterPropertiesEditionComponent(EObject javaExpressionFilter, String editing_mode) {
		super(editing_mode);
		if (javaExpressionFilter instanceof JavaExpressionFilter) {
			IPropertiesEditionProvider provider = null;
			provider = PropertiesEditionComponentService.getInstance().getProvider(javaExpressionFilter, JavaExpressionFilterBasePropertiesEditionComponent.class);
			javaExpressionFilterBasePropertiesEditionComponent = (JavaExpressionFilterBasePropertiesEditionComponent)provider.getPropertiesEditionComponent(javaExpressionFilter, editing_mode, JavaExpressionFilterBasePropertiesEditionComponent.BASE_PART, JavaExpressionFilterBasePropertiesEditionComponent.class);
			addSubComponent(javaExpressionFilterBasePropertiesEditionComponent);
			provider = PropertiesEditionComponentService.getInstance().getProvider(javaExpressionFilter, DocumentedElementPropertiesEditionComponent.class);
			documentedElementPropertiesEditionComponent = (DocumentedElementPropertiesEditionComponent)provider.getPropertiesEditionComponent(javaExpressionFilter, editing_mode, DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART, DocumentedElementPropertiesEditionComponent.class);
			addSubComponent(documentedElementPropertiesEditionComponent);
			provider = PropertiesEditionComponentService.getInstance().getProvider(javaExpressionFilter, FilterPropertiesPropertiesEditionComponent.class);
			filterPropertiesPropertiesEditionComponent = (FilterPropertiesPropertiesEditionComponent)provider.getPropertiesEditionComponent(javaExpressionFilter, editing_mode, FilterPropertiesPropertiesEditionComponent.FILTERPROPERTIES_PART, FilterPropertiesPropertiesEditionComponent.class);
			addSubComponent(filterPropertiesPropertiesEditionComponent);
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
		if (JavaExpressionFilterBasePropertiesEditionComponent.BASE_PART.equals(key)) {
			basePart = (JavaExpressionFilterPropertiesEditionPart)javaExpressionFilterBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
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
		if (MappingViewsRepository.JavaExpressionFilter.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (JavaExpressionFilterPropertiesEditionPart)propertiesEditionPart;
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
		if (key == MappingViewsRepository.JavaExpressionFilter.class) {
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

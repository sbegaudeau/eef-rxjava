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
import org.eclipse.emf.eef.mapping.filters.JavaDeclarationFilter;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.JavaDeclarationFilterPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class JavaDeclarationFilterPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private JavaDeclarationFilterPropertiesEditionPart basePart;

	/**
	 * The JavaDeclarationFilterBasePropertiesEditionComponent sub component
	 */
	protected JavaDeclarationFilterBasePropertiesEditionComponent javaDeclarationFilterBasePropertiesEditionComponent;

	/**
	 * The DocumentedElementPropertiesEditionComponent sub component
	 */
	protected DocumentedElementPropertiesEditionComponent documentedElementPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param javaDeclarationFilter
	 *            the EObject to edit
	 */
	public JavaDeclarationFilterPropertiesEditionComponent(EObject javaDeclarationFilter, String editing_mode) {
		super(editing_mode);
		if (javaDeclarationFilter instanceof JavaDeclarationFilter) {
			javaDeclarationFilterBasePropertiesEditionComponent = new JavaDeclarationFilterBasePropertiesEditionComponent(javaDeclarationFilter, editing_mode); 
			addSubComponent(javaDeclarationFilterBasePropertiesEditionComponent);
			documentedElementPropertiesEditionComponent = new DocumentedElementPropertiesEditionComponent(javaDeclarationFilter, editing_mode); 	
			addSubComponent(documentedElementPropertiesEditionComponent);
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent#
	 * 		getPropertiesEditionPart(int, java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(int kind, String key) {
		if ("Base".equals(key)) {
			basePart = (JavaDeclarationFilterPropertiesEditionPart)javaDeclarationFilterBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
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
		if (MappingViewsRepository.JavaDeclarationFilter.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (JavaDeclarationFilterPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent
	 *	#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == MappingViewsRepository.JavaDeclarationFilter.class) {
			super.initPart(key, kind, element, allResource);
		}
	}
}


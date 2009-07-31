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
 * $Id: EMFMultiPropertiesBindingPropertiesEditionComponent.java,v 1.10 2009/07/31 14:10:32 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.mapping.EMFMultiPropertiesBinding;
import org.eclipse.emf.eef.mapping.parts.EMFMultiPropertiesBindingPropertiesEditionPart;
import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EMFMultiPropertiesBindingPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * The Base part
	 */
	private EMFMultiPropertiesBindingPropertiesEditionPart basePart;

	/**
	 * The EMFMultiPropertiesBindingBasePropertiesEditionComponent sub component
	 */
	protected EMFMultiPropertiesBindingBasePropertiesEditionComponent eMFMultiPropertiesBindingBasePropertiesEditionComponent;

	/**
	 * The DocumentedElementPropertiesEditionComponent sub component
	 */
	protected DocumentedElementPropertiesEditionComponent documentedElementPropertiesEditionComponent;
	/**
	 * Parameterized constructor
	 * 
	 * @param eMFMultiPropertiesBinding
	 *            the EObject to edit
	 */
	public EMFMultiPropertiesBindingPropertiesEditionComponent(EObject eMFMultiPropertiesBinding, String editing_mode) {
		super(editing_mode);
		if (eMFMultiPropertiesBinding instanceof EMFMultiPropertiesBinding) {
			eMFMultiPropertiesBindingBasePropertiesEditionComponent = new EMFMultiPropertiesBindingBasePropertiesEditionComponent(eMFMultiPropertiesBinding, editing_mode); 
			addSubComponent(eMFMultiPropertiesBindingBasePropertiesEditionComponent);
			documentedElementPropertiesEditionComponent = new DocumentedElementPropertiesEditionComponent(eMFMultiPropertiesBinding, editing_mode);
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
			basePart = (EMFMultiPropertiesBindingPropertiesEditionPart)eMFMultiPropertiesBindingBasePropertiesEditionComponent.getPropertiesEditionPart(kind, key);
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
		if (MappingViewsRepository.EMFMultiPropertiesBinding.class == key) {
			super.setPropertiesEditionPart(key, kind, propertiesEditionPart);
			basePart = (EMFMultiPropertiesBindingPropertiesEditionPart)propertiesEditionPart;
		}
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent
	 *	#initPart(java.lang.Class, int, org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.resource.ResourceSet)
	 */
	public void initPart(java.lang.Class key, int kind, EObject element, ResourceSet allResource) {
		if (key == MappingViewsRepository.EMFMultiPropertiesBinding.class) {
			super.initPart(key, kind, element, allResource);
		}
			if (key == MappingViewsRepository.Documentation.class) {
				super.initPart(key, kind, element, allResource);
			
			
			}
	}
}


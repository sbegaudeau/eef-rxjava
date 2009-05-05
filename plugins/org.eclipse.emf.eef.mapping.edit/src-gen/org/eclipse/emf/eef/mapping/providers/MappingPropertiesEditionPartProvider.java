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
 * $Id: MappingPropertiesEditionPartProvider.java,v 1.2 2009/05/05 12:07:31 sbouchet Exp $
 */
package org.eclipse.emf.eef.mapping.providers;

import org.eclipse.emf.eef.mapping.parts.MappingViewsRepository;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.mapping.parts.forms.DocumentationPropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.parts.impl.DocumentationPropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.EMFElementBindingPropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.parts.impl.EMFElementBindingPropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.EMFPropertyBindingPropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.parts.impl.EMFPropertyBindingPropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.StandardElementBindingPropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.parts.impl.StandardElementBindingPropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.StandardPropertyBindingPropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.parts.impl.StandardPropertyBindingPropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.CategoryPropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.parts.impl.CategoryPropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.ElementBindingReferencePropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.parts.impl.ElementBindingReferencePropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.EMFMultiPropertiesBindingPropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.parts.impl.EMFMultiPropertiesBindingPropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.ModelNavigationPropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.parts.impl.ModelNavigationPropertiesEditionPartImpl;
import org.eclipse.emf.eef.mapping.parts.forms.SimpleModelNavigationPropertiesEditionPartForm;
import org.eclipse.emf.eef.mapping.parts.impl.SimpleModelNavigationPropertiesEditionPartImpl;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class MappingPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Class)
	 */
	public boolean provides(java.lang.Class key) {
		return key == MappingViewsRepository.class;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionComponent component) {
		if (key == MappingViewsRepository.Documentation.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new DocumentationPropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new DocumentationPropertiesEditionPartForm(component);
		}
		if (key == MappingViewsRepository.EMFElementBinding.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new EMFElementBindingPropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new EMFElementBindingPropertiesEditionPartForm(component);
		}
		if (key == MappingViewsRepository.EMFPropertyBinding.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new EMFPropertyBindingPropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new EMFPropertyBindingPropertiesEditionPartForm(component);
		}
		if (key == MappingViewsRepository.StandardElementBinding.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new StandardElementBindingPropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new StandardElementBindingPropertiesEditionPartForm(component);
		}
		if (key == MappingViewsRepository.StandardPropertyBinding.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new StandardPropertyBindingPropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new StandardPropertyBindingPropertiesEditionPartForm(component);
		}
		if (key == MappingViewsRepository.Category.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new CategoryPropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new CategoryPropertiesEditionPartForm(component);
		}
		if (key == MappingViewsRepository.ElementBindingReference.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new ElementBindingReferencePropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new ElementBindingReferencePropertiesEditionPartForm(component);
		}
		if (key == MappingViewsRepository.EMFMultiPropertiesBinding.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new EMFMultiPropertiesBindingPropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new EMFMultiPropertiesBindingPropertiesEditionPartForm(component);
		}
		if (key == MappingViewsRepository.ModelNavigation.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new ModelNavigationPropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new ModelNavigationPropertiesEditionPartForm(component);
		}
		if (key == MappingViewsRepository.SimpleModelNavigation.class) {
			if (kind == MappingViewsRepository.SWT_KIND)
				return new SimpleModelNavigationPropertiesEditionPartImpl(component);
			if (kind == MappingViewsRepository.FORM_KIND)
				return new SimpleModelNavigationPropertiesEditionPartForm(component);
		}
		return null;
	}

}


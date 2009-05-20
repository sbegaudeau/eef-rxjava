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
 * $Id: ViewsPropertiesEditionPartProvider.java,v 1.4 2009/05/20 15:52:01 sbouchet Exp $
 */
package org.eclipse.emf.eef.views.providers;

import org.eclipse.emf.eef.views.parts.ViewsViewsRepository;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.views.parts.forms.DocumentationPropertiesEditionPartForm;
import org.eclipse.emf.eef.views.parts.impl.DocumentationPropertiesEditionPartImpl;
import org.eclipse.emf.eef.views.parts.forms.ViewsRepositoryPropertiesEditionPartForm;
import org.eclipse.emf.eef.views.parts.impl.ViewsRepositoryPropertiesEditionPartImpl;
import org.eclipse.emf.eef.views.parts.forms.ViewPropertiesEditionPartForm;
import org.eclipse.emf.eef.views.parts.impl.ViewPropertiesEditionPartImpl;
import org.eclipse.emf.eef.views.parts.forms.ElementEditorPropertiesEditionPartForm;
import org.eclipse.emf.eef.views.parts.impl.ElementEditorPropertiesEditionPartImpl;
import org.eclipse.emf.eef.views.parts.forms.CategoryPropertiesEditionPartForm;
import org.eclipse.emf.eef.views.parts.impl.CategoryPropertiesEditionPartImpl;
import org.eclipse.emf.eef.views.parts.forms.ContainerPropertiesEditionPartForm;
import org.eclipse.emf.eef.views.parts.impl.ContainerPropertiesEditionPartImpl;
import org.eclipse.emf.eef.views.parts.forms.SpecificElementEditorPropertiesEditionPartForm;
import org.eclipse.emf.eef.views.parts.impl.SpecificElementEditorPropertiesEditionPartImpl;
import org.eclipse.emf.eef.views.parts.forms.CustomViewPropertiesEditionPartForm;
import org.eclipse.emf.eef.views.parts.impl.CustomViewPropertiesEditionPartImpl;
import org.eclipse.emf.eef.views.parts.forms.ViewReferencePropertiesEditionPartForm;
import org.eclipse.emf.eef.views.parts.impl.ViewReferencePropertiesEditionPartImpl;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class ViewsPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Class)
	 */
	public boolean provides(java.lang.Class key) {
		return key == ViewsViewsRepository.class;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionComponent component) {
		if (key == ViewsViewsRepository.Documentation.class) {
			if (kind == ViewsViewsRepository.SWT_KIND)
				return new DocumentationPropertiesEditionPartImpl(component);
			if (kind == ViewsViewsRepository.FORM_KIND)
				return new DocumentationPropertiesEditionPartForm(component);
		}
		if (key == ViewsViewsRepository.ViewsRepository.class) {
			if (kind == ViewsViewsRepository.SWT_KIND)
				return new ViewsRepositoryPropertiesEditionPartImpl(component);
			if (kind == ViewsViewsRepository.FORM_KIND)
				return new ViewsRepositoryPropertiesEditionPartForm(component);
		}
		if (key == ViewsViewsRepository.View.class) {
			if (kind == ViewsViewsRepository.SWT_KIND)
				return new ViewPropertiesEditionPartImpl(component);
			if (kind == ViewsViewsRepository.FORM_KIND)
				return new ViewPropertiesEditionPartForm(component);
		}
		if (key == ViewsViewsRepository.ElementEditor.class) {
			if (kind == ViewsViewsRepository.SWT_KIND)
				return new ElementEditorPropertiesEditionPartImpl(component);
			if (kind == ViewsViewsRepository.FORM_KIND)
				return new ElementEditorPropertiesEditionPartForm(component);
		}
		if (key == ViewsViewsRepository.Category.class) {
			if (kind == ViewsViewsRepository.SWT_KIND)
				return new CategoryPropertiesEditionPartImpl(component);
			if (kind == ViewsViewsRepository.FORM_KIND)
				return new CategoryPropertiesEditionPartForm(component);
		}
		if (key == ViewsViewsRepository.Container.class) {
			if (kind == ViewsViewsRepository.SWT_KIND)
				return new ContainerPropertiesEditionPartImpl(component);
			if (kind == ViewsViewsRepository.FORM_KIND)
				return new ContainerPropertiesEditionPartForm(component);
		}
		if (key == ViewsViewsRepository.SpecificElementEditor.class) {
			if (kind == ViewsViewsRepository.SWT_KIND)
				return new SpecificElementEditorPropertiesEditionPartImpl(component);
			if (kind == ViewsViewsRepository.FORM_KIND)
				return new SpecificElementEditorPropertiesEditionPartForm(component);
		}
		if (key == ViewsViewsRepository.CustomView.class) {
			if (kind == ViewsViewsRepository.SWT_KIND)
				return new CustomViewPropertiesEditionPartImpl(component);
			if (kind == ViewsViewsRepository.FORM_KIND)
				return new CustomViewPropertiesEditionPartForm(component);
		}
		if (key == ViewsViewsRepository.ViewReference.class) {
			if (kind == ViewsViewsRepository.SWT_KIND)
				return new ViewReferencePropertiesEditionPartImpl(component);
			if (kind == ViewsViewsRepository.FORM_KIND)
				return new ViewReferencePropertiesEditionPartForm(component);
		}
		return null;
	}

}


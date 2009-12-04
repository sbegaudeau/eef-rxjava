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
 * $Id: ComponentsPropertiesEditionPartProvider.java,v 1.9 2009/12/04 15:49:07 sbouchet Exp $
 */
package org.eclipse.emf.eef.components.providers;

import org.eclipse.emf.eef.components.parts.ComponentsViewsRepository;
import org.eclipse.emf.eef.components.parts.forms.DocumentationPropertiesEditionPartForm;
import org.eclipse.emf.eef.components.parts.forms.PropertiesEditionComponentPropertiesEditionPartForm;
import org.eclipse.emf.eef.components.parts.forms.PropertiesEditionContextPropertiesEditionPartForm;
import org.eclipse.emf.eef.components.parts.forms.PropertiesEditionElementPropertiesEditionPartForm;
import org.eclipse.emf.eef.components.parts.forms.PropertiesMultiEditionElementPropertiesEditionPartForm;
import org.eclipse.emf.eef.components.parts.impl.DocumentationPropertiesEditionPartImpl;
import org.eclipse.emf.eef.components.parts.impl.PropertiesEditionComponentPropertiesEditionPartImpl;
import org.eclipse.emf.eef.components.parts.impl.PropertiesEditionContextPropertiesEditionPartImpl;
import org.eclipse.emf.eef.components.parts.impl.PropertiesEditionElementPropertiesEditionPartImpl;
import org.eclipse.emf.eef.components.parts.impl.PropertiesMultiEditionElementPropertiesEditionPartImpl;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class ComponentsPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Class)
	 */
	public boolean provides(java.lang.Class key) {
		return key == ComponentsViewsRepository.class;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionComponent component) {
		if (key == ComponentsViewsRepository.Documentation.class) {
			if (kind == ComponentsViewsRepository.SWT_KIND)
				return new DocumentationPropertiesEditionPartImpl(component);
			if (kind == ComponentsViewsRepository.FORM_KIND)
				return new DocumentationPropertiesEditionPartForm(component);
		}
		if (key == ComponentsViewsRepository.PropertiesEditionContext.class) {
			if (kind == ComponentsViewsRepository.SWT_KIND)
				return new PropertiesEditionContextPropertiesEditionPartImpl(component);
			if (kind == ComponentsViewsRepository.FORM_KIND)
				return new PropertiesEditionContextPropertiesEditionPartForm(component);
		}
		if (key == ComponentsViewsRepository.PropertiesEditionComponent.class) {
			if (kind == ComponentsViewsRepository.SWT_KIND)
				return new PropertiesEditionComponentPropertiesEditionPartImpl(component);
			if (kind == ComponentsViewsRepository.FORM_KIND)
				return new PropertiesEditionComponentPropertiesEditionPartForm(component);
		}
		if (key == ComponentsViewsRepository.PropertiesEditionElement.class) {
			if (kind == ComponentsViewsRepository.SWT_KIND)
				return new PropertiesEditionElementPropertiesEditionPartImpl(component);
			if (kind == ComponentsViewsRepository.FORM_KIND)
				return new PropertiesEditionElementPropertiesEditionPartForm(component);
		}
		if (key == ComponentsViewsRepository.PropertiesMultiEditionElement.class) {
			if (kind == ComponentsViewsRepository.SWT_KIND)
				return new PropertiesMultiEditionElementPropertiesEditionPartImpl(component);
			if (kind == ComponentsViewsRepository.FORM_KIND)
				return new PropertiesMultiEditionElementPropertiesEditionPartForm(component);
		}
		return null;
	}

}

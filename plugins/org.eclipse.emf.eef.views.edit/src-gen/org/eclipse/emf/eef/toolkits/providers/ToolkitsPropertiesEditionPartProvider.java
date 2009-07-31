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
 * $Id: ToolkitsPropertiesEditionPartProvider.java,v 1.7 2009/07/31 12:42:24 glefur Exp $
 */
package org.eclipse.emf.eef.toolkits.providers;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;
import org.eclipse.emf.eef.toolkits.parts.ToolkitsViewsRepository;
import org.eclipse.emf.eef.toolkits.parts.forms.ToolkitPropertiesEditionPartForm;
import org.eclipse.emf.eef.toolkits.parts.forms.WidgetPropertiesEditionPartForm;
import org.eclipse.emf.eef.toolkits.parts.impl.ToolkitPropertiesEditionPartImpl;
import org.eclipse.emf.eef.toolkits.parts.impl.WidgetPropertiesEditionPartImpl;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 *
 */
public class ToolkitsPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {
	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Class)
	 */
	public boolean provides(java.lang.Class key) {
		return key == ToolkitsViewsRepository.class;
	}

	
	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Class, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(java.lang.Class key, int kind, IPropertiesEditionComponent component) {
		if (key == ToolkitsViewsRepository.Toolkit.class) {
			if (kind == ToolkitsViewsRepository.SWT_KIND)
				return new ToolkitPropertiesEditionPartImpl(component);
			if (kind == ToolkitsViewsRepository.FORM_KIND)
				return new ToolkitPropertiesEditionPartForm(component);
		}
		if (key == ToolkitsViewsRepository.Widget.class) {
			if (kind == ToolkitsViewsRepository.SWT_KIND)
				return new WidgetPropertiesEditionPartImpl(component);
			if (kind == ToolkitsViewsRepository.FORM_KIND)
				return new WidgetPropertiesEditionPartForm(component);
		}
		return null;
	}

}


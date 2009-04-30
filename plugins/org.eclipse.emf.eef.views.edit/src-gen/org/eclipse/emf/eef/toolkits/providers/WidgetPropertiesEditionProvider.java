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
 * $Id: WidgetPropertiesEditionProvider.java,v 1.1 2009/04/30 17:16:51 glefur Exp $
 */
package org.eclipse.emf.eef.toolkits.providers;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

import org.eclipse.emf.eef.toolkits.ToolkitsPackage;
import org.eclipse.emf.eef.toolkits.Widget;
import org.eclipse.emf.eef.toolkits.components.WidgetPropertiesEditionComponent;
import org.eclipse.emf.eef.toolkits.parts.impl.WidgetPropertiesEditionPartImpl;
import org.eclipse.emf.eef.toolkits.parts.forms.WidgetPropertiesEditionPartForm;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class WidgetPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof Widget) && (ToolkitsPackage.eINSTANCE.getWidget() == eObject.eClass());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String mode) {
		if (eObject instanceof Widget) {
			return new WidgetPropertiesEditionComponent(eObject, mode);
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String mode, String part) {
		if (eObject instanceof Widget) {
			if (WidgetPropertiesEditionComponent.BASE_PART.equals(part))
				return new WidgetPropertiesEditionComponent(eObject, mode);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionPart(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent, java.lang.String,
	 *      java.lang.String)
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(EObject eObject,
			IPropertiesEditionComponent editionComponent, String part, String kind) {
		if (eObject instanceof Widget) {
			if (WidgetPropertiesEditionComponent.SWT_KIND.equals(kind)) {
				if (WidgetPropertiesEditionComponent.BASE_PART.equals(part))
					return new WidgetPropertiesEditionPartImpl(editionComponent);
			}
		}
		if (WidgetPropertiesEditionComponent.FORM_KIND.equals(kind)) {
				if (WidgetPropertiesEditionComponent.BASE_PART.equals(part))
					return new WidgetPropertiesEditionPartForm(editionComponent);
		}
		return null;
	}
	
}	

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
 * $Id: PropertiesEditionContextPropertiesEditionProvider.java,v 1.4 2009/05/18 15:33:42 sbouchet Exp $
 */
package org.eclipse.emf.eef.components.providers;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider;

import org.eclipse.emf.eef.components.ComponentsPackage;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.components.components.PropertiesEditionContextPropertiesEditionComponent;
import org.eclipse.emf.eef.components.components.PropertiesEditionContextBasePropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class PropertiesEditionContextPropertiesEditionProvider implements IPropertiesEditionProvider {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#provides(org.eclipse.emf.ecore.EObject)
	 */
	public boolean provides(EObject eObject) {
		return (eObject instanceof PropertiesEditionContext) && (ComponentsPackage.eINSTANCE.getPropertiesEditionContext() == eObject.eClass());
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode) {
		if (eObject instanceof PropertiesEditionContext) {
			return new PropertiesEditionContextPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionProvider#getPropertiesEditionComponent(org.eclipse.emf.ecore.EObject,
	 *      java.lang.String, java.lang.String)
	 */
	public IPropertiesEditionComponent getPropertiesEditionComponent(EObject eObject, String editing_mode, String part) {
		if (eObject instanceof PropertiesEditionContext) {
			if (PropertiesEditionContextBasePropertiesEditionComponent.BASE_PART.equals(part))
				return new PropertiesEditionContextBasePropertiesEditionComponent(eObject, editing_mode);
			if (DocumentedElementPropertiesEditionComponent.DOCUMENTATION_PART.equals(part))
				return new DocumentedElementPropertiesEditionComponent(eObject, editing_mode);
		}
		return null;
	}
	
}	

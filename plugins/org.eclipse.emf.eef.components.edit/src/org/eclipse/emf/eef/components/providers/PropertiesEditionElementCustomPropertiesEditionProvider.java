/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.components.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.components.components.PropertiesEditionElementBasePropertiesEditionComponent;
import org.eclipse.emf.eef.components.components.PropertiesEditionElementPropertiesEditionComponent;
import org.eclipse.emf.eef.components.parts.forms.PropertiesEditionElementCustomPropertiesEditionPartForm;
import org.eclipse.emf.eef.components.parts.impl.PropertiesEditionElementCustomPropertiesEditionPartImpl;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

/**
 * @author <a href="mailto:goulwen.lefur@obeo.fr">Goulwen Le Fur</a>
 */
public class PropertiesEditionElementCustomPropertiesEditionProvider extends PropertiesEditionElementPropertiesEditionProvider {

	@Override
	public IPropertiesEditionPart getPropertiesEditionPart(EObject eObject,
			IPropertiesEditionComponent editionComponent, String part, String kind) {
		if (eObject instanceof PropertiesEditionElement) {
			if (PropertiesEditionElementPropertiesEditionComponent.SWT_KIND.equals(kind)) {
				if (PropertiesEditionElementBasePropertiesEditionComponent.BASE_PART.equals(part))
					return new PropertiesEditionElementCustomPropertiesEditionPartImpl(editionComponent);
			}
		}
		if (PropertiesEditionElementPropertiesEditionComponent.FORM_KIND.equals(kind)) {
				if (PropertiesEditionElementBasePropertiesEditionComponent.BASE_PART.equals(part))
					return new PropertiesEditionElementCustomPropertiesEditionPartForm(editionComponent);
		}
		return super.getPropertiesEditionPart(eObject, editionComponent, part, kind);
	}

	
	
}

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
 * $Id: ElementBindingReferencePropertiesEditionComponent.java,v 1.3 2009/05/05 12:07:29 sbouchet Exp $
 */
package org.eclipse.emf.eef.mapping.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.mapping.ElementBindingReference;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ElementBindingReferencePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param elementBindingReference
	 *            the EObject to edit
	 */
	public ElementBindingReferencePropertiesEditionComponent(EObject elementBindingReference, String editing_mode) {
		super(editing_mode);
		if (elementBindingReference instanceof ElementBindingReference) {
			addSubComponent(new ElementBindingReferenceBasePropertiesEditionComponent(elementBindingReference, editing_mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(elementBindingReference, editing_mode));
		}
	}
}


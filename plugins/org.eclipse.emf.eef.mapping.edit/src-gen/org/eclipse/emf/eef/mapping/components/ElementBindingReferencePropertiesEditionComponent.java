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
 * $Id: ElementBindingReferencePropertiesEditionComponent.java,v 1.1 2009/04/30 17:14:43 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.components;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.mapping.ElementBindingReference;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ElementBindingReferencePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	public static final String SWT_KIND = "SWT";

	public static final String FORM_KIND = "Form";
		
	/**
	 * The EObject to edit
	 */
	private ElementBindingReference elementBindingReference;
	
	/**
	 * Parameterized constructor
	 * 
	 * @param elementBindingReference
	 *            the EObject to edit
	 */
	public ElementBindingReferencePropertiesEditionComponent(EObject elementBindingReference, String mode) {
		super(mode);
		if (elementBindingReference instanceof ElementBindingReference) {
			this.elementBindingReference = (ElementBindingReference)elementBindingReference;
			addSubComponent(new ElementBindingReferenceBasePropertiesEditionComponent(elementBindingReference, mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(elementBindingReference, mode));
		}
	}
}



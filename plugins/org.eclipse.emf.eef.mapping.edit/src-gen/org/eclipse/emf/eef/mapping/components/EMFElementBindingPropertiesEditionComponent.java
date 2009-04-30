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
 * $Id: EMFElementBindingPropertiesEditionComponent.java,v 1.1 2009/04/30 17:14:42 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.components;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.mapping.EMFElementBinding;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EMFElementBindingPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	public static final String SWT_KIND = "SWT";

	public static final String FORM_KIND = "Form";
		
	/**
	 * The EObject to edit
	 */
	private EMFElementBinding eMFElementBinding;
	
	/**
	 * Parameterized constructor
	 * 
	 * @param eMFElementBinding
	 *            the EObject to edit
	 */
	public EMFElementBindingPropertiesEditionComponent(EObject eMFElementBinding, String mode) {
		super(mode);
		if (eMFElementBinding instanceof EMFElementBinding) {
			this.eMFElementBinding = (EMFElementBinding)eMFElementBinding;
			addSubComponent(new EMFElementBindingBasePropertiesEditionComponent(eMFElementBinding, mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(eMFElementBinding, mode));
		}
	}
}



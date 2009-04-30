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
 * $Id: EMFPropertyBindingPropertiesEditionComponent.java,v 1.1 2009/04/30 17:14:43 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.components;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.mapping.EMFPropertyBinding;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EMFPropertyBindingPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	public static final String SWT_KIND = "SWT";

	public static final String FORM_KIND = "Form";
		
	/**
	 * The EObject to edit
	 */
	private EMFPropertyBinding eMFPropertyBinding;
	
	/**
	 * Parameterized constructor
	 * 
	 * @param eMFPropertyBinding
	 *            the EObject to edit
	 */
	public EMFPropertyBindingPropertiesEditionComponent(EObject eMFPropertyBinding, String mode) {
		super(mode);
		if (eMFPropertyBinding instanceof EMFPropertyBinding) {
			this.eMFPropertyBinding = (EMFPropertyBinding)eMFPropertyBinding;
			addSubComponent(new EMFPropertyBindingBasePropertiesEditionComponent(eMFPropertyBinding, mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(eMFPropertyBinding, mode));
		}
	}
}



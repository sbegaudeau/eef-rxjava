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
 * $Id: ViewReferencePropertiesEditionComponent.java,v 1.1 2009/04/30 17:16:51 glefur Exp $
 */
package org.eclipse.emf.eef.views.components;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.views.ViewReference;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ViewReferencePropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	public static final String SWT_KIND = "SWT";

	public static final String FORM_KIND = "Form";
		
	/**
	 * The EObject to edit
	 */
	private ViewReference viewReference;
	
	/**
	 * Parameterized constructor
	 * 
	 * @param viewReference
	 *            the EObject to edit
	 */
	public ViewReferencePropertiesEditionComponent(EObject viewReference, String mode) {
		super(mode);
		if (viewReference instanceof ViewReference) {
			this.viewReference = (ViewReference)viewReference;
			addSubComponent(new ViewReferenceBasePropertiesEditionComponent(viewReference, mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(viewReference, mode));
		}
	}
}



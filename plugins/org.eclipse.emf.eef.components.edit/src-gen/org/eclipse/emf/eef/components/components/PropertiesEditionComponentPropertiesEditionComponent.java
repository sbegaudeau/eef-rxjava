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
 * $Id: PropertiesEditionComponentPropertiesEditionComponent.java,v 1.1 2009/04/30 17:09:47 glefur Exp $
 */
package org.eclipse.emf.eef.components.components;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.components.PropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class PropertiesEditionComponentPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	public static final String SWT_KIND = "SWT";

	public static final String FORM_KIND = "Form";
		
	/**
	 * The EObject to edit
	 */
	private PropertiesEditionComponent propertiesEditionComponent;
	
	/**
	 * Parameterized constructor
	 * 
	 * @param propertiesEditionComponent
	 *            the EObject to edit
	 */
	public PropertiesEditionComponentPropertiesEditionComponent(EObject propertiesEditionComponent, String mode) {
		super(mode);
		if (propertiesEditionComponent instanceof PropertiesEditionComponent) {
			this.propertiesEditionComponent = (PropertiesEditionComponent)propertiesEditionComponent;
			addSubComponent(new PropertiesEditionComponentBasePropertiesEditionComponent(propertiesEditionComponent, mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(propertiesEditionComponent, mode));
		}
	}
}



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
 * $Id: EMFElementBindingPropertiesEditionComponent.java,v 1.3 2009/05/05 12:07:28 sbouchet Exp $
 */
package org.eclipse.emf.eef.mapping.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.mapping.EMFElementBinding;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class EMFElementBindingPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param eMFElementBinding
	 *            the EObject to edit
	 */
	public EMFElementBindingPropertiesEditionComponent(EObject eMFElementBinding, String editing_mode) {
		super(editing_mode);
		if (eMFElementBinding instanceof EMFElementBinding) {
			addSubComponent(new EMFElementBindingBasePropertiesEditionComponent(eMFElementBinding, editing_mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(eMFElementBinding, editing_mode));
		}
	}
}


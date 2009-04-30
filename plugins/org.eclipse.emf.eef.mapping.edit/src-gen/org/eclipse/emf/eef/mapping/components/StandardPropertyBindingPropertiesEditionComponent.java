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
 * $Id: StandardPropertyBindingPropertiesEditionComponent.java,v 1.2 2009/04/30 17:48:58 nlepine Exp $
 */
package org.eclipse.emf.eef.mapping.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.mapping.StandardPropertyBinding;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class StandardPropertyBindingPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param standardPropertyBinding
	 *            the EObject to edit
	 */
	public StandardPropertyBindingPropertiesEditionComponent(EObject standardPropertyBinding, String editing_mode) {
		super(editing_mode);
		if (standardPropertyBinding instanceof StandardPropertyBinding) {
			addSubComponent(new StandardPropertyBindingBasePropertiesEditionComponent(standardPropertyBinding, editing_mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(standardPropertyBinding, editing_mode));
		}
	}
}


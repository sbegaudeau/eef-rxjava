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
 * $Id: PropertiesEditionContextPropertiesEditionComponent.java,v 1.2 2009/04/30 17:49:46 nlepine Exp $
 */
package org.eclipse.emf.eef.components.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.mapping.components.DocumentedElementPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class PropertiesEditionContextPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param propertiesEditionContext
	 *            the EObject to edit
	 */
	public PropertiesEditionContextPropertiesEditionComponent(EObject propertiesEditionContext, String editing_mode) {
		super(editing_mode);
		if (propertiesEditionContext instanceof PropertiesEditionContext) {
			addSubComponent(new PropertiesEditionContextBasePropertiesEditionComponent(propertiesEditionContext, editing_mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(propertiesEditionContext, editing_mode));
		}
	}
}


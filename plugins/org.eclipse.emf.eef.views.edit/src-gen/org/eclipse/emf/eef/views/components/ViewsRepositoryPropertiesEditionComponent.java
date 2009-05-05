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
 * $Id: ViewsRepositoryPropertiesEditionComponent.java,v 1.3 2009/05/05 12:07:48 sbouchet Exp $
 */
package org.eclipse.emf.eef.views.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.views.ViewsRepository;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class ViewsRepositoryPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param viewsRepository
	 *            the EObject to edit
	 */
	public ViewsRepositoryPropertiesEditionComponent(EObject viewsRepository, String editing_mode) {
		super(editing_mode);
		if (viewsRepository instanceof ViewsRepository) {
			addSubComponent(new ViewsRepositoryBasePropertiesEditionComponent(viewsRepository, editing_mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(viewsRepository, editing_mode));
		}
	}
}


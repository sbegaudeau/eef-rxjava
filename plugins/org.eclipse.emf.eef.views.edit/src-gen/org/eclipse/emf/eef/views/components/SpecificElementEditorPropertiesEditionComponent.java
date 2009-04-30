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
 * $Id: SpecificElementEditorPropertiesEditionComponent.java,v 1.2 2009/04/30 17:49:38 nlepine Exp $
 */
package org.eclipse.emf.eef.views.components;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;
import org.eclipse.emf.eef.views.SpecificElementEditor;

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class SpecificElementEditorPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	/**
	 * Parameterized constructor
	 * 
	 * @param specificElementEditor
	 *            the EObject to edit
	 */
	public SpecificElementEditorPropertiesEditionComponent(EObject specificElementEditor, String editing_mode) {
		super(editing_mode);
		if (specificElementEditor instanceof SpecificElementEditor) {
			addSubComponent(new SpecificElementEditorBasePropertiesEditionComponent(specificElementEditor, editing_mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(specificElementEditor, editing_mode));
		}
	}
}


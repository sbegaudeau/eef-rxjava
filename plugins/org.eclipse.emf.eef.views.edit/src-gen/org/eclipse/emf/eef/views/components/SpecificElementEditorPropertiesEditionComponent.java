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
 * $Id: SpecificElementEditorPropertiesEditionComponent.java,v 1.1 2009/04/30 17:16:51 glefur Exp $
 */
package org.eclipse.emf.eef.views.components;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.views.SpecificElementEditor;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class SpecificElementEditorPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	public static final String SWT_KIND = "SWT";

	public static final String FORM_KIND = "Form";
		
	/**
	 * The EObject to edit
	 */
	private SpecificElementEditor specificElementEditor;
	
	/**
	 * Parameterized constructor
	 * 
	 * @param specificElementEditor
	 *            the EObject to edit
	 */
	public SpecificElementEditorPropertiesEditionComponent(EObject specificElementEditor, String mode) {
		super(mode);
		if (specificElementEditor instanceof SpecificElementEditor) {
			this.specificElementEditor = (SpecificElementEditor)specificElementEditor;
			addSubComponent(new SpecificElementEditorBasePropertiesEditionComponent(specificElementEditor, mode));
			addSubComponent(new DocumentedElementPropertiesEditionComponent(specificElementEditor, mode));
		}
	}
}



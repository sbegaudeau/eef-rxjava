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
 * $Id: GenEditionContextPropertiesEditionComponent.java,v 1.1 2009/04/30 17:12:36 glefur Exp $
 */
package org.eclipse.emf.eef.EEFGen.components;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.EEFGen.GenEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.ComposedPropertiesEditionComponent;

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public class GenEditionContextPropertiesEditionComponent extends ComposedPropertiesEditionComponent {

	public static final String SWT_KIND = "SWT";

	public static final String FORM_KIND = "Form";
		
	/**
	 * The EObject to edit
	 */
	private GenEditionContext genEditionContext;
	
	/**
	 * Parameterized constructor
	 * 
	 * @param genEditionContext
	 *            the EObject to edit
	 */
	public GenEditionContextPropertiesEditionComponent(EObject genEditionContext, String mode) {
		super(mode);
		if (genEditionContext instanceof GenEditionContext) {
			this.genEditionContext = (GenEditionContext)genEditionContext;
			addSubComponent(new GenEditionContextGenActivationPropertiesEditionComponent(genEditionContext, mode));
			addSubComponent(new GenEditionContextGenParametersPropertiesEditionComponent(genEditionContext, mode));
			addSubComponent(new GenEditionContextGenReferencesPropertiesEditionComponent(genEditionContext, mode));
		}
	}
}



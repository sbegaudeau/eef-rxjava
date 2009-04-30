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
 * $Id: ElementBindingReferencePropertiesEditionPart.java,v 1.1 2009/04/30 17:14:43 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
 

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface ElementBindingReferencePropertiesEditionPart {

	/**
	 * @return the binding
	 */
	public EObject getBinding();
	
	/**
	 * Defines a new binding
	 * @param newValue the new binding to set
	 */
	public void setBinding(EObject newValue);
	
	
	
	
	
	// Start of user code for additional methods
 	
	// End of user code

}


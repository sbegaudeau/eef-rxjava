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
 * $Id: SpecificElementEditorPropertiesEditionPart.java,v 1.1 2009/04/30 17:16:52 glefur Exp $
 */
package org.eclipse.emf.eef.views.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
 

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface SpecificElementEditorPropertiesEditionPart {

	/**
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 */
	public void setName(String newValue);
	
	public void setMessageForName (String msg, int msgLevel);	
	
	public void unsetMessageForName ();
	
	/**
	 * @return the representation
	 */
	public EObject getRepresentation();
	
	/**
	 * Defines a new representation
	 * @param newValue the new representation to set
	 */
	public void setRepresentation(EObject newValue);
	
	
	
	
	
	/**
	 * @return the readOnly
	 */
	public Boolean getReadOnly();
	
	/**
	 * Defines a new readOnly
	 * @param newValue the new readOnly to set
	 */
	public void setReadOnly(Boolean newValue);
	
	
	
	
	
	// Start of user code for additional methods
 	
	// End of user code

}


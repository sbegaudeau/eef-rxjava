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
 * $Id: ToolkitPropertiesEditionPart.java,v 1.5 2009/05/19 09:16:41 glefur Exp $
 */
package org.eclipse.emf.eef.toolkits.parts;

// Start of user code for imports


 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface ToolkitPropertiesEditionPart {

	/**
	 * @return the Name
	 */
	public String getName();

	/**
	 * Defines a new Name
	 * @param newValue the new Name to set
	 */
	public void setName(String newValue);

	public void setMessageForName(String msg, int msgLevel);

	public void unsetMessageForName();






	// Start of user code for additional methods
 	
	// End of user code
}


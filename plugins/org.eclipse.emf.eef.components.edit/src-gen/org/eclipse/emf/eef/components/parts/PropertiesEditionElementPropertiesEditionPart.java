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
 * $Id: PropertiesEditionElementPropertiesEditionPart.java,v 1.1 2009/04/30 17:09:47 glefur Exp $
 */
package org.eclipse.emf.eef.components.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
 

// End of user code

/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface PropertiesEditionElementPropertiesEditionPart {

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
	 * @return the helpID
	 */
	public String getHelpID();
	
	/**
	 * Defines a new helpID
	 * @param newValue the new helpID to set
	 */
	public void setHelpID(String newValue);
	
	public void setMessageForHelpID (String msg, int msgLevel);	
	
	public void unsetMessageForHelpID ();
	
	/**
	 * @return the model
	 */
	public EObject getModel();
	
	/**
	 * Defines a new model
	 * @param newValue the new model to set
	 */
	public void setModel(EObject newValue);
	
	
	
	
	
	/**
	 * @return the views to add
	 */
	public List getViewsToAdd();
	
	/**
	 * @return the views to remove
	 */
	public List getViewsToRemove();
	
	/**
	 * Update the views
	 * @param newValue the views to update
	 */
	public void updateViews(EObject newValue);
	
	
	
	
	
	// Start of user code for additional methods
 	
	// End of user code

}


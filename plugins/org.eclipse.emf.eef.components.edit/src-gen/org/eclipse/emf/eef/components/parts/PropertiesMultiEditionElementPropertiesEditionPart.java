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
 * $Id: PropertiesMultiEditionElementPropertiesEditionPart.java,v 1.2 2009/04/30 17:49:47 nlepine Exp $
 */
package org.eclipse.emf.eef.components.parts;

// Start of user code for imports

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface PropertiesMultiEditionElementPropertiesEditionPart {

	/**
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 */
	public void setName(String newValue);
	
	public void setMessageForName(String msg, int msgLevel);
	
	public void unsetMessageForName();
	
	/**
	 * @return the helpID
	 */
	public String getHelpID();
	
	/**
	 * Defines a new helpID
	 * @param newValue the new helpID to set
	 */
	public void setHelpID(String newValue);
	
	public void setMessageForHelpID(String msg, int msgLevel);
	
	public void unsetMessageForHelpID();
	
	/**
	 * @return the model to add
	 */
	public List getModelToAdd();
	
	/**
	 * @return the model to remove
	 */
	public List getModelToRemove();
	
	/**
	 * Init the model
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initModel(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the model
	 * @param newValue the model to update
	 */
	public void updateModel(EObject newValue);
	
	
	
	
	
	/**
	 * @return the views to add
	 */
	public List getViewsToAdd();
	
	/**
	 * @return the views to remove
	 */
	public List getViewsToRemove();
	
	/**
	 * Init the views
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initViews(EObject current, EReference containingFeature, EReference feature);

/**
	 * Update the views
	 * @param newValue the views to update
	 */
	public void updateViews(EObject newValue);
	
	
	
	
	





	// Start of user code for additional methods
 	
	// End of user code
}


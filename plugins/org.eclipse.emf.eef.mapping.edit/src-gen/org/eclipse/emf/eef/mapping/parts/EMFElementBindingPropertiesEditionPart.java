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
 * $Id: EMFElementBindingPropertiesEditionPart.java,v 1.2 2009/04/30 17:48:58 nlepine Exp $
 */
package org.eclipse.emf.eef.mapping.parts;

// Start of user code for imports

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface EMFElementBindingPropertiesEditionPart {

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
	 * @return the model
	 */
	public EObject getModel();
	
	/**
	 * Init the model
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initModel(ResourceSet allResources, EObject current);

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


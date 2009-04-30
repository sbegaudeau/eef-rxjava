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
 * $Id: ViewReferencePropertiesEditionPart.java,v 1.2 2009/04/30 17:49:39 nlepine Exp $
 */
package org.eclipse.emf.eef.views.parts;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface ViewReferencePropertiesEditionPart {

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
	 * @return the referencedView
	 */
	public EObject getReferencedView();
	
	/**
	 * Init the referencedView
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initReferencedView(ResourceSet allResources, EObject current);

/**
	 * Defines a new referencedView
	 * @param newValue the new referencedView to set
	 */
	public void setReferencedView(EObject newValue);
	
	
	
	
	





	// Start of user code for additional methods
 	
	// End of user code
}


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
 * $Id: ViewReferencePropertiesEditionPart.java,v 1.4 2009/05/19 08:45:28 sbouchet Exp $
 */
package org.eclipse.emf.eef.views.parts;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ViewerFilter;
 

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

	/**
	 * Adds the given filter to the referencedView edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToReferencedView(ViewerFilter filter);

	/**
	 * Adds the given filter to the referencedView edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToReferencedView(ViewerFilter filter);










	// Start of user code for additional methods
 	
	// End of user code
}


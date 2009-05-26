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
 * $Id: CustomElementEditorPropertiesEditionPart.java,v 1.1 2009/05/26 08:49:33 glefur Exp $
 */
package org.eclipse.emf.eef.views.parts;

// Start of user code for imports

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ViewerFilter;
 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface CustomElementEditorPropertiesEditionPart {

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
	 * @return the representation
	 */
	public EObject getRepresentation();

	/**
	 * Init the representation
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initRepresentation(ResourceSet allResources, EObject current);

	/**
	 * Defines a new representation
	 * @param newValue the new representation to set
	 */
	public void setRepresentation(EObject newValue);

	/**
	 * Adds the given filter to the representation edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToRepresentation(ViewerFilter filter);

	/**
	 * Adds the given filter to the representation edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToRepresentation(ViewerFilter filter);





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


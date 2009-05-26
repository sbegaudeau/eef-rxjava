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
 * $Id$
 */
package org.eclipse.emf.eef.mapping.parts;

// Start of user code for imports

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;
import org.eclipse.jface.viewers.ViewerFilter;
 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface OnlyReferenceTypeFilterPropertiesEditionPart {

	/**
	 * @return the referencedFeature
	 */
	public EObject getReferencedFeature();

	/**
	 * Init the referencedFeature
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initReferencedFeature(ResourceSet allResources, EObject current);

	/**
	 * Defines a new referencedFeature
	 * @param newValue the new referencedFeature to set
	 */
	public void setReferencedFeature(EObject newValue);

	/**
	 * Adds the given filter to the referencedFeature edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToReferencedFeature(ViewerFilter filter);

	/**
	 * Adds the given filter to the referencedFeature edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToReferencedFeature(ViewerFilter filter);








	/**
	 * @return the Filter properties referenced view
	 */
	public IPropertiesEditionPart getFilterPropertiesReferencedView();
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

	/**
	 * @return the Mandatory
	 */
	public Boolean getMandatory();

	/**
	 * Defines a new Mandatory
	 * @param newValue the new Mandatory to set
	 */
	public void setMandatory(Boolean newValue);







	// Start of user code for additional methods
	
	// End of user code
}


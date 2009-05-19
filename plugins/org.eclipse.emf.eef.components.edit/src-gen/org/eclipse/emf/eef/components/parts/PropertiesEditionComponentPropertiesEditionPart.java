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
 * $Id: PropertiesEditionComponentPropertiesEditionPart.java,v 1.5 2009/05/19 09:17:00 glefur Exp $
 */
package org.eclipse.emf.eef.components.parts;

// Start of user code for imports

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ViewerFilter;
 

// End of user code
/**
 * @author <a href="mailto:nathalie.lepine@obeo.fr">Nathalie Lepine</a>
 */
public interface PropertiesEditionComponentPropertiesEditionPart {

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
	 * @return the explicit
	 */
	public Boolean getExplicit();

	/**
	 * Defines a new explicit
	 * @param newValue the new explicit to set
	 */
	public void setExplicit(Boolean newValue);





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
	 * Adds the given filter to the model edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToModel(ViewerFilter filter);

	/**
	 * Adds the given filter to the model edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToModel(ViewerFilter filter);





	/**
	 * @return the views to add
	 */
	public List getViewsToAdd();

	/**
	 * @return the views to remove
	 */
	public List getViewsToRemove();

	/**
	 * @return the current views
	 */
	public List getViewsTable();

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

	/**
	 * Adds the given filter to the views edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addFilterToViews(ViewerFilter filter);

	/**
	 * Adds the given filter to the views edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 */
	public void addBusinessFilterToViews(ViewerFilter filter);










	// Start of user code for additional methods
 	
	// End of user code
}


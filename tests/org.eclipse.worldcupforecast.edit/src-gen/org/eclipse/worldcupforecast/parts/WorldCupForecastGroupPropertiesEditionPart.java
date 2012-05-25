/*******************************************************************************
 * Copyright (c) 2008, 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
/**
 * Generated with Acceleo
 */
package org.eclipse.worldcupforecast.parts;

// Start of user code for imports
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * 
 * 
 */
public interface WorldCupForecastGroupPropertiesEditionPart {

	/**
	 * @return the group to add
	 * 
	 */
	public List getGroupToAdd();

	/**
	 * @return the group to remove
	 * 
	 */
	public List getGroupToRemove();

	/**
	 * @return the group to move
	 * 
	 */
	public List getGroupToMove();

	/**
	 * @return the group to edit
	 * 
	 */
	public Map getGroupToEdit();

	/**
	 * @return the current group table
	 * 
	 */
	public List getGroupTable();

	/**
	 * Init the group
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initGroup(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the group
	 * @param newValue the group to update
	 * 
	 */
	public void updateGroup(EObject newValue);

	/**
	 * Adds the given filter to the group edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToGroup(ViewerFilter filter);

	/**
	 * Adds the given filter to the group edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToGroup(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the group table
	 * 
	 */
	public boolean isContainedInGroupTable(EObject element);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}

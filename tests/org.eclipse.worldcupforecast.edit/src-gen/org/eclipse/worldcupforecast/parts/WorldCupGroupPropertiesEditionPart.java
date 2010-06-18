/*******************************************************************************
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *       Obeo - initial API and implementation
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
public interface WorldCupGroupPropertiesEditionPart {

	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the teams to add
	 * 
	 */
	public List getTeamsToAdd();

	/**
	 * @return the teams to remove
	 * 
	 */
	public List getTeamsToRemove();

	/**
	 * @return the teams to move
	 * 
	 */
	public List getTeamsToMove();

	/**
	 * @return the teams to edit
	 * 
	 */
	public Map getTeamsToEdit();

	/**
	 * @return the current teams table
	 * 
	 */
	public List getTeamsTable();

	/**
	 * Init the teams
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initTeams(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the teams
	 * @param newValue the teams to update
	 * 
	 */
	public void updateTeams(EObject newValue);

	/**
	 * Adds the given filter to the teams edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTeams(ViewerFilter filter);

	/**
	 * Adds the given filter to the teams edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTeams(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the teams table
	 * 
	 */
	public boolean isContainedInTeamsTable(EObject element);





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

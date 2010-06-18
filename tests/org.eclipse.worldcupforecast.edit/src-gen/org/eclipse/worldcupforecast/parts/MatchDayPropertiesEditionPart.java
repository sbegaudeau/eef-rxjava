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
public interface MatchDayPropertiesEditionPart {

	/**
	 * @return the date
	 * 
	 */
	public String getDate();

	/**
	 * Defines a new date
	 * @param newValue the new date to set
	 * 
	 */
	public void setDate(String newValue);


	/**
	 * @return the matches to add
	 * 
	 */
	public List getMatchesToAdd();

	/**
	 * @return the matches to remove
	 * 
	 */
	public List getMatchesToRemove();

	/**
	 * @return the matches to move
	 * 
	 */
	public List getMatchesToMove();

	/**
	 * @return the matches to edit
	 * 
	 */
	public Map getMatchesToEdit();

	/**
	 * @return the current matches table
	 * 
	 */
	public List getMatchesTable();

	/**
	 * Init the matches
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initMatches(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the matches
	 * @param newValue the matches to update
	 * 
	 */
	public void updateMatches(EObject newValue);

	/**
	 * Adds the given filter to the matches edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToMatches(ViewerFilter filter);

	/**
	 * Adds the given filter to the matches edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToMatches(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the matches table
	 * 
	 */
	public boolean isContainedInMatchesTable(EObject element);





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

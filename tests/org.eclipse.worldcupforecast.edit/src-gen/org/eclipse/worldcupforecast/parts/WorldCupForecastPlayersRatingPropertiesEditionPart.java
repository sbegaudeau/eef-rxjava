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
public interface WorldCupForecastPlayersRatingPropertiesEditionPart {

	/**
	 * @return the rating to add
	 * 
	 */
	public List getRatingToAdd();

	/**
	 * @return the rating to remove
	 * 
	 */
	public List getRatingToRemove();

	/**
	 * @return the rating to move
	 * 
	 */
	public List getRatingToMove();

	/**
	 * @return the rating to edit
	 * 
	 */
	public Map getRatingToEdit();

	/**
	 * @return the current rating table
	 * 
	 */
	public List getRatingTable();

	/**
	 * Init the rating
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initRating(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the rating
	 * @param newValue the rating to update
	 * 
	 */
	public void updateRating(EObject newValue);

	/**
	 * Adds the given filter to the rating edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToRating(ViewerFilter filter);

	/**
	 * Adds the given filter to the rating edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToRating(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the rating table
	 * 
	 */
	public boolean isContainedInRatingTable(EObject element);





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

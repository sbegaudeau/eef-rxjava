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
public interface PlayerForecastDaysPropertiesEditionPart {

	/**
	 * @return the forecastDays to add
	 * 
	 */
	public List getForecastDaysToAdd();

	/**
	 * @return the forecastDays to remove
	 * 
	 */
	public List getForecastDaysToRemove();

	/**
	 * @return the forecastDays to move
	 * 
	 */
	public List getForecastDaysToMove();

	/**
	 * @return the forecastDays to edit
	 * 
	 */
	public Map getForecastDaysToEdit();

	/**
	 * @return the current forecastDays table
	 * 
	 */
	public List getForecastDaysTable();

	/**
	 * Init the forecastDays
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initForecastDays(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the forecastDays
	 * @param newValue the forecastDays to update
	 * 
	 */
	public void updateForecastDays(EObject newValue);

	/**
	 * Adds the given filter to the forecastDays edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToForecastDays(ViewerFilter filter);

	/**
	 * Adds the given filter to the forecastDays edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToForecastDays(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the forecastDays table
	 * 
	 */
	public boolean isContainedInForecastDaysTable(EObject element);





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

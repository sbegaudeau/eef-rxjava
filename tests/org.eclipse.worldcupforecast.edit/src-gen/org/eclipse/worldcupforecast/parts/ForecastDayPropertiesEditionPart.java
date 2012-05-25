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
public interface ForecastDayPropertiesEditionPart {

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
	 * @return the forecasts to add
	 * 
	 */
	public List getForecastsToAdd();

	/**
	 * @return the forecasts to remove
	 * 
	 */
	public List getForecastsToRemove();

	/**
	 * @return the forecasts to move
	 * 
	 */
	public List getForecastsToMove();

	/**
	 * @return the forecasts to edit
	 * 
	 */
	public Map getForecastsToEdit();

	/**
	 * @return the current forecasts table
	 * 
	 */
	public List getForecastsTable();

	/**
	 * Init the forecasts
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initForecasts(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the forecasts
	 * @param newValue the forecasts to update
	 * 
	 */
	public void updateForecasts(EObject newValue);

	/**
	 * Adds the given filter to the forecasts edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToForecasts(ViewerFilter filter);

	/**
	 * Adds the given filter to the forecasts edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToForecasts(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the forecasts table
	 * 
	 */
	public boolean isContainedInForecastsTable(EObject element);





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

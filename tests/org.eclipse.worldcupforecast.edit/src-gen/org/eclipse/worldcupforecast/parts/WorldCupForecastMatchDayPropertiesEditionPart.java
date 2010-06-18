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
public interface WorldCupForecastMatchDayPropertiesEditionPart {

	/**
	 * @return the game to add
	 * 
	 */
	public List getGameToAdd();

	/**
	 * @return the game to remove
	 * 
	 */
	public List getGameToRemove();

	/**
	 * @return the game to move
	 * 
	 */
	public List getGameToMove();

	/**
	 * @return the game to edit
	 * 
	 */
	public Map getGameToEdit();

	/**
	 * @return the current game table
	 * 
	 */
	public List getGameTable();

	/**
	 * Init the game
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initGame(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the game
	 * @param newValue the game to update
	 * 
	 */
	public void updateGame(EObject newValue);

	/**
	 * Adds the given filter to the game edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToGame(ViewerFilter filter);

	/**
	 * Adds the given filter to the game edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToGame(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the game table
	 * 
	 */
	public boolean isContainedInGameTable(EObject element);





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

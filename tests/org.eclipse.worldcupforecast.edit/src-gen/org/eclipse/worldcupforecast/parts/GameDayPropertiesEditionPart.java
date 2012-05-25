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
public interface GameDayPropertiesEditionPart {

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
	 * @return the games to add
	 * 
	 */
	public List getGamesToAdd();

	/**
	 * @return the games to remove
	 * 
	 */
	public List getGamesToRemove();

	/**
	 * @return the games to move
	 * 
	 */
	public List getGamesToMove();

	/**
	 * @return the games to edit
	 * 
	 */
	public Map getGamesToEdit();

	/**
	 * @return the current games table
	 * 
	 */
	public List getGamesTable();

	/**
	 * Init the games
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initGames(EObject current, EReference containingFeature, EReference feature);

	/**
	 * Update the games
	 * @param newValue the games to update
	 * 
	 */
	public void updateGames(EObject newValue);

	/**
	 * Adds the given filter to the games edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToGames(ViewerFilter filter);

	/**
	 * Adds the given filter to the games edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToGames(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the games table
	 * 
	 */
	public boolean isContainedInGamesTable(EObject element);





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

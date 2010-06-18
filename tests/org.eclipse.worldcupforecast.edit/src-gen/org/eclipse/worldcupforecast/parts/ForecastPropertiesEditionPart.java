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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * 
 * 
 */
public interface ForecastPropertiesEditionPart {

	/**
	 * @return the match
	 * 
	 */
	public EObject getMatch();

	/**
	 * Init the match
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initMatch(ResourceSet allResources, EObject current);

	/**
	 * Defines a new match
	 * @param newValue the new match to set
	 * 
	 */
	public void setMatch(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setMatchButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the match edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToMatch(ViewerFilter filter);

	/**
	 * Adds the given filter to the match edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToMatch(ViewerFilter filter);


	/**
	 * @return the scoreTeam1
	 * 
	 */
	public String getScoreTeam1();

	/**
	 * Defines a new scoreTeam1
	 * @param newValue the new scoreTeam1 to set
	 * 
	 */
	public void setScoreTeam1(String newValue);


	/**
	 * @return the scoreTeam2
	 * 
	 */
	public String getScoreTeam2();

	/**
	 * Defines a new scoreTeam2
	 * @param newValue the new scoreTeam2 to set
	 * 
	 */
	public void setScoreTeam2(String newValue);


	/**
	 * @return the winner
	 * 
	 */
	public EObject getWinner();

	/**
	 * Init the winner
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initWinner(ResourceSet allResources, EObject current);

	/**
	 * Defines a new winner
	 * @param newValue the new winner to set
	 * 
	 */
	public void setWinner(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setWinnerButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the winner edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToWinner(ViewerFilter filter);

	/**
	 * Adds the given filter to the winner edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToWinner(ViewerFilter filter);


	/**
	 * @return the score
	 * 
	 */
	public String getScore();

	/**
	 * Defines a new score
	 * @param newValue the new score to set
	 * 
	 */
	public void setScore(String newValue);





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

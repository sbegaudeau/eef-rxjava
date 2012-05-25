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
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.jface.viewers.ViewerFilter;



// End of user code

/**
 * 
 * 
 */
public interface OtherKnockoutStageGamePropertiesEditionPart {

	/**
	 * @return the hours
	 * 
	 */
	public String getHours();

	/**
	 * Defines a new hours
	 * @param newValue the new hours to set
	 * 
	 */
	public void setHours(String newValue);


	/**
	 * @return the minutes
	 * 
	 */
	public String getMinutes();

	/**
	 * Defines a new minutes
	 * @param newValue the new minutes to set
	 * 
	 */
	public void setMinutes(String newValue);


	/**
	 * @return the coefficient
	 * 
	 */
	public String getCoefficient();

	/**
	 * Defines a new coefficient
	 * @param newValue the new coefficient to set
	 * 
	 */
	public void setCoefficient(String newValue);


	/**
	 * @return the Team1 winner of match
	 * 
	 */
	public EObject getTeam1WinnerOfMatch();

	/**
	 * Init the Team1 winner of match
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initTeam1WinnerOfMatch(ResourceSet allResources, EObject current);

	/**
	 * Defines a new Team1 winner of match
	 * @param newValue the new Team1 winner of match to set
	 * 
	 */
	public void setTeam1WinnerOfMatch(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTeam1WinnerOfMatchButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the Team1 winner of match edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTeam1WinnerOfMatch(ViewerFilter filter);

	/**
	 * Adds the given filter to the Team1 winner of match edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTeam1WinnerOfMatch(ViewerFilter filter);


	/**
	 * @return the Team2 winner of match
	 * 
	 */
	public EObject getTeam2WinnerOfMatch();

	/**
	 * Init the Team2 winner of match
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initTeam2WinnerOfMatch(ResourceSet allResources, EObject current);

	/**
	 * Defines a new Team2 winner of match
	 * @param newValue the new Team2 winner of match to set
	 * 
	 */
	public void setTeam2WinnerOfMatch(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTeam2WinnerOfMatchButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the Team2 winner of match edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTeam2WinnerOfMatch(ViewerFilter filter);

	/**
	 * Adds the given filter to the Team2 winner of match edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTeam2WinnerOfMatch(ViewerFilter filter);


	/**
	 * @return the Team 1
	 * 
	 */
	public EObject getTeam1();

	/**
	 * Init the Team 1
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initTeam1(ResourceSet allResources, EObject current);

	/**
	 * Defines a new Team 1
	 * @param newValue the new Team 1 to set
	 * 
	 */
	public void setTeam1(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTeam1ButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the Team 1 edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTeam1(ViewerFilter filter);

	/**
	 * Adds the given filter to the Team 1 edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTeam1(ViewerFilter filter);


	/**
	 * @return the Team 2
	 * 
	 */
	public EObject getTeam2();

	/**
	 * Init the Team 2
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initTeam2(ResourceSet allResources, EObject current);

	/**
	 * Defines a new Team 2
	 * @param newValue the new Team 2 to set
	 * 
	 */
	public void setTeam2(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTeam2ButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the Team 2 edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTeam2(ViewerFilter filter);

	/**
	 * Adds the given filter to the Team 2 edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTeam2(ViewerFilter filter);


	/**
	 * @return the Type
	 * 
	 */
	public Enumerator getType();

	/**
	 * Init the Type
	 * @param eenum the enum to manage
	 * @param current the current value
	 */
	public void initType(EEnum eenum, Enumerator current);

	/**
	 * Defines a new Type
	 * @param newValue the new Type to set
	 * 
	 */
	public void setType(Enumerator newValue);





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

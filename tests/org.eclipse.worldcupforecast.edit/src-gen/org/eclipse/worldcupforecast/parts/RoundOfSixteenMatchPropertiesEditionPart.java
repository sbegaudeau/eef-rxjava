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
public interface RoundOfSixteenMatchPropertiesEditionPart {

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
	 * @return the Team1 winner of group
	 * 
	 */
	public EObject getTeam1WinnerOfGroup();

	/**
	 * Init the Team1 winner of group
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initTeam1WinnerOfGroup(ResourceSet allResources, EObject current);

	/**
	 * Defines a new Team1 winner of group
	 * @param newValue the new Team1 winner of group to set
	 * 
	 */
	public void setTeam1WinnerOfGroup(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTeam1WinnerOfGroupButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the Team1 winner of group edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTeam1WinnerOfGroup(ViewerFilter filter);

	/**
	 * Adds the given filter to the Team1 winner of group edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTeam1WinnerOfGroup(ViewerFilter filter);


	/**
	 * @return the Team2 runner-up of group
	 * 
	 */
	public EObject getTeam2RunnerupOfGroup();

	/**
	 * Init the Team2 runner-up of group
	 * @param allResources the ResourceSet where the widget have to process
	 * @param current the current value
	 */
	public void initTeam2RunnerupOfGroup(ResourceSet allResources, EObject current);

	/**
	 * Defines a new Team2 runner-up of group
	 * @param newValue the new Team2 runner-up of group to set
	 * 
	 */
	public void setTeam2RunnerupOfGroup(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setTeam2RunnerupOfGroupButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the Team2 runner-up of group edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToTeam2RunnerupOfGroup(ViewerFilter filter);

	/**
	 * Adds the given filter to the Team2 runner-up of group edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToTeam2RunnerupOfGroup(ViewerFilter filter);


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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}

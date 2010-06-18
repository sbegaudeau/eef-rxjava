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




// End of user code

/**
 * 
 * 
 */
public interface TeamPropertiesEditionPart {

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
	 * @return the pics
	 * 
	 */
	public String getPics();

	/**
	 * Init the pics
	 * @param key the key of the editor 
	 * @param current the new path of the pics
	 */
	public void initPics(String key, String newValue);

	/**
	 * Defines a new pics
	 * @param newValue the new pics to set
	 * 
	 */
	public void setPics(String newValue);


	/**
	 * @return the Points
	 * 
	 */
	public String getPoints();

	/**
	 * Defines a new Points
	 * @param newValue the new Points to set
	 * 
	 */
	public void setPoints(String newValue);


	/**
	 * @return the Goals For
	 * 
	 */
	public String getGoalsFor();

	/**
	 * Defines a new Goals For
	 * @param newValue the new Goals For to set
	 * 
	 */
	public void setGoalsFor(String newValue);


	/**
	 * @return the Goals Against
	 * 
	 */
	public String getGoalsAgainst();

	/**
	 * Defines a new Goals Against
	 * @param newValue the new Goals Against to set
	 * 
	 */
	public void setGoalsAgainst(String newValue);


	/**
	 * @return the Goal Difference
	 * 
	 */
	public String getGoalDifference();

	/**
	 * Defines a new Goal Difference
	 * @param newValue the new Goal Difference to set
	 * 
	 */
	public void setGoalDifference(String newValue);





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

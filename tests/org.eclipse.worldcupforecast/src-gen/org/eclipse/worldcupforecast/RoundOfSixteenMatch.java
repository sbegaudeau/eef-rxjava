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
package org.eclipse.worldcupforecast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Round Of Sixteen Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.RoundOfSixteenMatch#getTeam1WinnerOfGroup <em>Team1 Winner Of Group</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.RoundOfSixteenMatch#getTeam2RunnerUpOfGroup <em>Team2 Runner Up Of Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getRoundOfSixteenMatch()
 * @model
 * @generated
 */
public interface RoundOfSixteenMatch extends KnockoutStageMatch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Team1 Winner Of Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team1 Winner Of Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team1 Winner Of Group</em>' reference.
	 * @see #setTeam1WinnerOfGroup(WorldCupGroup)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getRoundOfSixteenMatch_Team1WinnerOfGroup()
	 * @model required="true"
	 * @generated
	 */
	WorldCupGroup getTeam1WinnerOfGroup();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.RoundOfSixteenMatch#getTeam1WinnerOfGroup <em>Team1 Winner Of Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team1 Winner Of Group</em>' reference.
	 * @see #getTeam1WinnerOfGroup()
	 * @generated
	 */
	void setTeam1WinnerOfGroup(WorldCupGroup value);

	/**
	 * Returns the value of the '<em><b>Team2 Runner Up Of Group</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team2 Runner Up Of Group</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team2 Runner Up Of Group</em>' reference.
	 * @see #setTeam2RunnerUpOfGroup(WorldCupGroup)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getRoundOfSixteenMatch_Team2RunnerUpOfGroup()
	 * @model required="true"
	 * @generated
	 */
	WorldCupGroup getTeam2RunnerUpOfGroup();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.RoundOfSixteenMatch#getTeam2RunnerUpOfGroup <em>Team2 Runner Up Of Group</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team2 Runner Up Of Group</em>' reference.
	 * @see #getTeam2RunnerUpOfGroup()
	 * @generated
	 */
	void setTeam2RunnerUpOfGroup(WorldCupGroup value);

} // RoundOfSixteenMatch

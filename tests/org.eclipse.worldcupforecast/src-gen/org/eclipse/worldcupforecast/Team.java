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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Team</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.Team#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Team#getPics <em>Pics</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Team#getPoints <em>Points</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Team#getGoalsFor <em>Goals For</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Team#getGoalsAgainst <em>Goals Against</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Team#getGoalDifference <em>Goal Difference</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Team#getPlayed <em>Played</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getTeam()
 * @model
 * @generated
 */
public interface Team extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getTeam_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Team#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Pics</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pics</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pics</em>' attribute.
	 * @see #setPics(String)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getTeam_Pics()
	 * @model
	 * @generated
	 */
	String getPics();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Team#getPics <em>Pics</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pics</em>' attribute.
	 * @see #getPics()
	 * @generated
	 */
	void setPics(String value);

	/**
	 * Returns the value of the '<em><b>Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Points</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Points</em>' attribute.
	 * @see #setPoints(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getTeam_Points()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	int getPoints();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Team#getPoints <em>Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Points</em>' attribute.
	 * @see #getPoints()
	 * @generated
	 */
	void setPoints(int value);

	/**
	 * Returns the value of the '<em><b>Goals For</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals For</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals For</em>' attribute.
	 * @see #setGoalsFor(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getTeam_GoalsFor()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	int getGoalsFor();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Team#getGoalsFor <em>Goals For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goals For</em>' attribute.
	 * @see #getGoalsFor()
	 * @generated
	 */
	void setGoalsFor(int value);

	/**
	 * Returns the value of the '<em><b>Goals Against</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goals Against</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goals Against</em>' attribute.
	 * @see #setGoalsAgainst(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getTeam_GoalsAgainst()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	int getGoalsAgainst();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Team#getGoalsAgainst <em>Goals Against</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goals Against</em>' attribute.
	 * @see #getGoalsAgainst()
	 * @generated
	 */
	void setGoalsAgainst(int value);

	/**
	 * Returns the value of the '<em><b>Goal Difference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goal Difference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goal Difference</em>' attribute.
	 * @see #setGoalDifference(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getTeam_GoalDifference()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	int getGoalDifference();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Team#getGoalDifference <em>Goal Difference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goal Difference</em>' attribute.
	 * @see #getGoalDifference()
	 * @generated
	 */
	void setGoalDifference(int value);

	/**
	 * Returns the value of the '<em><b>Played</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Played</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Played</em>' attribute.
	 * @see #setPlayed(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getTeam_Played()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	int getPlayed();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Team#getPlayed <em>Played</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Played</em>' attribute.
	 * @see #getPlayed()
	 * @generated
	 */
	void setPlayed(int value);

} // Team

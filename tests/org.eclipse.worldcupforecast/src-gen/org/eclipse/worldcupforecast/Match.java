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
 * A representation of the model object '<em><b>Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.Match#getHours <em>Hours</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Match#getMinutes <em>Minutes</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Match#getCoefficient <em>Coefficient</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Match#getScore <em>Score</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Match#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Match#getTeam1 <em>Team1</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Match#getTeam2 <em>Team2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getMatch()
 * @model abstract="true"
 * @generated
 */
public interface Match extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Hours</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hours</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hours</em>' attribute.
	 * @see #setHours(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getMatch_Hours()
	 * @model required="true"
	 * @generated
	 */
	int getHours();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Match#getHours <em>Hours</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hours</em>' attribute.
	 * @see #getHours()
	 * @generated
	 */
	void setHours(int value);

	/**
	 * Returns the value of the '<em><b>Minutes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minutes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minutes</em>' attribute.
	 * @see #setMinutes(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getMatch_Minutes()
	 * @model required="true"
	 * @generated
	 */
	int getMinutes();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Match#getMinutes <em>Minutes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minutes</em>' attribute.
	 * @see #getMinutes()
	 * @generated
	 */
	void setMinutes(int value);

	/**
	 * Returns the value of the '<em><b>Coefficient</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coefficient</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coefficient</em>' attribute.
	 * @see #setCoefficient(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getMatch_Coefficient()
	 * @model default="1"
	 * @generated
	 */
	int getCoefficient();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Match#getCoefficient <em>Coefficient</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Coefficient</em>' attribute.
	 * @see #getCoefficient()
	 * @generated
	 */
	void setCoefficient(int value);

	/**
	 * Returns the value of the '<em><b>Score</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' containment reference.
	 * @see #setScore(FinalScore)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getMatch_Score()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	FinalScore getScore();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Match#getScore <em>Score</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score</em>' containment reference.
	 * @see #getScore()
	 * @generated
	 */
	void setScore(FinalScore value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getMatch_Name()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team1</em>' reference.
	 * @see #setTeam1(Team)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getMatch_Team1()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Team getTeam1();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Match#getTeam1 <em>Team1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team1</em>' reference.
	 * @see #getTeam1()
	 * @generated
	 */
	void setTeam1(Team value);

	/**
	 * Returns the value of the '<em><b>Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team2</em>' reference.
	 * @see #setTeam2(Team)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getMatch_Team2()
	 * @model required="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Team getTeam2();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Match#getTeam2 <em>Team2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team2</em>' reference.
	 * @see #getTeam2()
	 * @generated
	 */
	void setTeam2(Team value);

} // Match

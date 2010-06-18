/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *       Obeo - initial API and implementation
 */
package org.eclipse.worldcupforecast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forecast</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.Forecast#getMatch <em>Match</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Forecast#getWinner <em>Winner</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Forecast#getScore <em>Score</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getForecast()
 * @model
 * @generated
 */
public interface Forecast extends Score {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' reference.
	 * @see #setMatch(Match)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getForecast_Match()
	 * @model required="true"
	 * @generated
	 */
	Match getMatch();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Forecast#getMatch <em>Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' reference.
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(Match value);

	/**
	 * Returns the value of the '<em><b>Winner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Winner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Winner</em>' reference.
	 * @see #setWinner(Team)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getForecast_Winner()
	 * @model
	 * @generated
	 */
	Team getWinner();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Forecast#getWinner <em>Winner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Winner</em>' reference.
	 * @see #getWinner()
	 * @generated
	 */
	void setWinner(Team value);

	/**
	 * Returns the value of the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' attribute.
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getForecast_Score()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getScore();

} // Forecast

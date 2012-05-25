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
 * A representation of the model object '<em><b>Other Knockout Stage Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getTeam1WinnerOfMatch <em>Team1 Winner Of Match</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getTeam2WinnerOfMatch <em>Team2 Winner Of Match</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getOtherKnockoutStageMatch()
 * @model
 * @generated
 */
public interface OtherKnockoutStageMatch extends KnockoutStageMatch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Team1 Winner Of Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team1 Winner Of Match</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team1 Winner Of Match</em>' reference.
	 * @see #setTeam1WinnerOfMatch(Match)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getOtherKnockoutStageMatch_Team1WinnerOfMatch()
	 * @model required="true"
	 * @generated
	 */
	Match getTeam1WinnerOfMatch();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getTeam1WinnerOfMatch <em>Team1 Winner Of Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team1 Winner Of Match</em>' reference.
	 * @see #getTeam1WinnerOfMatch()
	 * @generated
	 */
	void setTeam1WinnerOfMatch(Match value);

	/**
	 * Returns the value of the '<em><b>Team2 Winner Of Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team2 Winner Of Match</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team2 Winner Of Match</em>' reference.
	 * @see #setTeam2WinnerOfMatch(Match)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getOtherKnockoutStageMatch_Team2WinnerOfMatch()
	 * @model required="true"
	 * @generated
	 */
	Match getTeam2WinnerOfMatch();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getTeam2WinnerOfMatch <em>Team2 Winner Of Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team2 Winner Of Match</em>' reference.
	 * @see #getTeam2WinnerOfMatch()
	 * @generated
	 */
	void setTeam2WinnerOfMatch(Match value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.worldcupforecast.MatchType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.worldcupforecast.MatchType
	 * @see #setType(MatchType)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getOtherKnockoutStageMatch_Type()
	 * @model required="true"
	 * @generated
	 */
	MatchType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.OtherKnockoutStageMatch#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.worldcupforecast.MatchType
	 * @see #getType()
	 * @generated
	 */
	void setType(MatchType value);

} // OtherKnockoutStageMatch

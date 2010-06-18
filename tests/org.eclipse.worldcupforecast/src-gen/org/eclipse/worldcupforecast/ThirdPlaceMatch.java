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
 * A representation of the model object '<em><b>Third Place Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.ThirdPlaceMatch#getTeam1LooserOfMatch <em>Team1 Looser Of Match</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.ThirdPlaceMatch#getTeam2LooserOfMatch <em>Team2 Looser Of Match</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getThirdPlaceMatch()
 * @model
 * @generated
 */
public interface ThirdPlaceMatch extends KnockoutStageMatch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Team1 Looser Of Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team1 Looser Of Match</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team1 Looser Of Match</em>' reference.
	 * @see #setTeam1LooserOfMatch(Match)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getThirdPlaceMatch_Team1LooserOfMatch()
	 * @model required="true"
	 * @generated
	 */
	Match getTeam1LooserOfMatch();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.ThirdPlaceMatch#getTeam1LooserOfMatch <em>Team1 Looser Of Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team1 Looser Of Match</em>' reference.
	 * @see #getTeam1LooserOfMatch()
	 * @generated
	 */
	void setTeam1LooserOfMatch(Match value);

	/**
	 * Returns the value of the '<em><b>Team2 Looser Of Match</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Team2 Looser Of Match</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Team2 Looser Of Match</em>' reference.
	 * @see #setTeam2LooserOfMatch(Match)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getThirdPlaceMatch_Team2LooserOfMatch()
	 * @model required="true"
	 * @generated
	 */
	Match getTeam2LooserOfMatch();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.ThirdPlaceMatch#getTeam2LooserOfMatch <em>Team2 Looser Of Match</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Team2 Looser Of Match</em>' reference.
	 * @see #getTeam2LooserOfMatch()
	 * @generated
	 */
	void setTeam2LooserOfMatch(Match value);

} // ThirdPlaceMatch

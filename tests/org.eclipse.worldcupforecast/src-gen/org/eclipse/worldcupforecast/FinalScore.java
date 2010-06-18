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
 * A representation of the model object '<em><b>Final Score</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.FinalScore#getPenaltyScoreTeam1 <em>Penalty Score Team1</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.FinalScore#getPenaltyScoreTeam2 <em>Penalty Score Team2</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.FinalScore#getWinner <em>Winner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getFinalScore()
 * @model
 * @generated
 */
public interface FinalScore extends Score {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Penalty Score Team1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Penalty Score Team1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Penalty Score Team1</em>' attribute.
	 * @see #setPenaltyScoreTeam1(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getFinalScore_PenaltyScoreTeam1()
	 * @model
	 * @generated
	 */
	int getPenaltyScoreTeam1();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.FinalScore#getPenaltyScoreTeam1 <em>Penalty Score Team1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Penalty Score Team1</em>' attribute.
	 * @see #getPenaltyScoreTeam1()
	 * @generated
	 */
	void setPenaltyScoreTeam1(int value);

	/**
	 * Returns the value of the '<em><b>Penalty Score Team2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Penalty Score Team2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Penalty Score Team2</em>' attribute.
	 * @see #setPenaltyScoreTeam2(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getFinalScore_PenaltyScoreTeam2()
	 * @model
	 * @generated
	 */
	int getPenaltyScoreTeam2();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.FinalScore#getPenaltyScoreTeam2 <em>Penalty Score Team2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Penalty Score Team2</em>' attribute.
	 * @see #getPenaltyScoreTeam2()
	 * @generated
	 */
	void setPenaltyScoreTeam2(int value);

	/**
	 * Returns the value of the '<em><b>Winner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Winner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Winner</em>' reference.
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getFinalScore_Winner()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	Team getWinner();

} // FinalScore

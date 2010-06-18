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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage
 * @generated
 */
public interface WorldcupforecastFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WorldcupforecastFactory eINSTANCE = org.eclipse.worldcupforecast.impl.WorldcupforecastFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>World Cup Forecast</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>World Cup Forecast</em>'.
	 * @generated
	 */
	WorldCupForecast createWorldCupForecast();

	/**
	 * Returns a new object of class '<em>Forecast</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forecast</em>'.
	 * @generated
	 */
	Forecast createForecast();

	/**
	 * Returns a new object of class '<em>Team</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Team</em>'.
	 * @generated
	 */
	Team createTeam();

	/**
	 * Returns a new object of class '<em>World Cup Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>World Cup Group</em>'.
	 * @generated
	 */
	WorldCupGroup createWorldCupGroup();

	/**
	 * Returns a new object of class '<em>Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Player</em>'.
	 * @generated
	 */
	Player createPlayer();

	/**
	 * Returns a new object of class '<em>Validate Player</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Validate Player</em>'.
	 * @generated
	 */
	ValidatePlayer createValidatePlayer();

	/**
	 * Returns a new object of class '<em>Final Score</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Final Score</em>'.
	 * @generated
	 */
	FinalScore createFinalScore();

	/**
	 * Returns a new object of class '<em>Match Day</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Match Day</em>'.
	 * @generated
	 */
	MatchDay createMatchDay();

	/**
	 * Returns a new object of class '<em>Forecast Day</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Forecast Day</em>'.
	 * @generated
	 */
	ForecastDay createForecastDay();

	/**
	 * Returns a new object of class '<em>Group Stage Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Group Stage Match</em>'.
	 * @generated
	 */
	GroupStageMatch createGroupStageMatch();

	/**
	 * Returns a new object of class '<em>Other Knockout Stage Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Other Knockout Stage Match</em>'.
	 * @generated
	 */
	OtherKnockoutStageMatch createOtherKnockoutStageMatch();

	/**
	 * Returns a new object of class '<em>Third Place Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Third Place Match</em>'.
	 * @generated
	 */
	ThirdPlaceMatch createThirdPlaceMatch();

	/**
	 * Returns a new object of class '<em>Round Of Sixteen Match</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Round Of Sixteen Match</em>'.
	 * @generated
	 */
	RoundOfSixteenMatch createRoundOfSixteenMatch();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	WorldcupforecastPackage getWorldcupforecastPackage();

} //WorldcupforecastFactory

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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>World Cup Forecast</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.WorldCupForecast#getGroups <em>Groups</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.WorldCupForecast#getPlayers <em>Players</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.WorldCupForecast#getMatchDays <em>Match Days</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.WorldCupForecast#getValidatePlayers <em>Validate Players</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getWorldCupForecast()
 * @model
 * @generated
 */
public interface WorldCupForecast extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.worldcupforecast.WorldCupGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Groups</em>' containment reference list.
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getWorldCupForecast_Groups()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<WorldCupGroup> getGroups();

	/**
	 * Returns the value of the '<em><b>Players</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.worldcupforecast.Player}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Players</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Players</em>' containment reference list.
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getWorldCupForecast_Players()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Player> getPlayers();

	/**
	 * Returns the value of the '<em><b>Match Days</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.worldcupforecast.MatchDay}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Match Days</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match Days</em>' containment reference list.
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getWorldCupForecast_MatchDays()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<MatchDay> getMatchDays();

	/**
	 * Returns the value of the '<em><b>Validate Players</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.worldcupforecast.ValidatePlayer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validate Players</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validate Players</em>' containment reference list.
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getWorldCupForecast_ValidatePlayers()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ValidatePlayer> getValidatePlayers();

} // WorldCupForecast

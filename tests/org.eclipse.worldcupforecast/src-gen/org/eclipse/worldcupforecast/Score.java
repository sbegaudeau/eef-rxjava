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
 * A representation of the model object '<em><b>Score</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.Score#getScoreTeam1 <em>Score Team1</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.Score#getScoreTeam2 <em>Score Team2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getScore()
 * @model abstract="true"
 * @generated
 */
public interface Score extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Score Team1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score Team1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score Team1</em>' attribute.
	 * @see #setScoreTeam1(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getScore_ScoreTeam1()
	 * @model
	 * @generated
	 */
	int getScoreTeam1();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Score#getScoreTeam1 <em>Score Team1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score Team1</em>' attribute.
	 * @see #getScoreTeam1()
	 * @generated
	 */
	void setScoreTeam1(int value);

	/**
	 * Returns the value of the '<em><b>Score Team2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score Team2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score Team2</em>' attribute.
	 * @see #setScoreTeam2(int)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getScore_ScoreTeam2()
	 * @model
	 * @generated
	 */
	int getScoreTeam2();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.Score#getScoreTeam2 <em>Score Team2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Score Team2</em>' attribute.
	 * @see #getScoreTeam2()
	 * @generated
	 */
	void setScoreTeam2(int value);

} // Score

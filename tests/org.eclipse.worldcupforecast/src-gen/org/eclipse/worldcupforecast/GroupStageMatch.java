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
 * A representation of the model object '<em><b>Group Stage Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.worldcupforecast.GroupStageMatch#getManualTeam1 <em>Manual Team1</em>}</li>
 *   <li>{@link org.eclipse.worldcupforecast.GroupStageMatch#getManualTeam2 <em>Manual Team2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getGroupStageMatch()
 * @model
 * @generated
 */
public interface GroupStageMatch extends Match {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2010 Obeo.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n      Obeo - initial API and implementation";

	/**
	 * Returns the value of the '<em><b>Manual Team1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manual Team1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manual Team1</em>' reference.
	 * @see #setManualTeam1(Team)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getGroupStageMatch_ManualTeam1()
	 * @model required="true"
	 * @generated
	 */
	Team getManualTeam1();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.GroupStageMatch#getManualTeam1 <em>Manual Team1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manual Team1</em>' reference.
	 * @see #getManualTeam1()
	 * @generated
	 */
	void setManualTeam1(Team value);

	/**
	 * Returns the value of the '<em><b>Manual Team2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manual Team2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manual Team2</em>' reference.
	 * @see #setManualTeam2(Team)
	 * @see org.eclipse.worldcupforecast.WorldcupforecastPackage#getGroupStageMatch_ManualTeam2()
	 * @model required="true"
	 * @generated
	 */
	Team getManualTeam2();

	/**
	 * Sets the value of the '{@link org.eclipse.worldcupforecast.GroupStageMatch#getManualTeam2 <em>Manual Team2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manual Team2</em>' reference.
	 * @see #getManualTeam2()
	 * @generated
	 */
	void setManualTeam2(Team value);

} // GroupStageMatch

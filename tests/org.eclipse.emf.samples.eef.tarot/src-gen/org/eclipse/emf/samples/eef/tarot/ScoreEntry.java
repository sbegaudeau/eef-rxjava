/**
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 * 
 *
 * $Id: ScoreEntry.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Score Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.ScoreEntry#getGame <em>Game</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getScoreEntry()
 * @model abstract="true"
 * @generated
 */
public interface ScoreEntry extends EObject {

	/**
	 * Returns the value of the '<em><b>Game</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.samples.eef.tarot.Game#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Game</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This reference should have a lower bound to 1. This is a temporary workaround of a EEF limitation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Game</em>' container reference.
	 * @see #setGame(Game)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getScoreEntry_Game()
	 * @see org.eclipse.emf.samples.eef.tarot.Game#getEntries
	 * @model opposite="entries" transient="false"
	 * @generated
	 */
	Game getGame();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.ScoreEntry#getGame <em>Game</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Game</em>' container reference.
	 * @see #getGame()
	 * @generated
	 */
	void setGame(Game value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	int score(Player player);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	int cumulativeScore(Player player);
} // ScoreEntry

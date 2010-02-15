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
 * $Id: Game.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Game</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Game#getPlayers <em>Players</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Game#getEntries <em>Entries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getGame()
 * @model
 * @generated
 */
public interface Game extends EObject {
	/**
	 * Returns the value of the '<em><b>Players</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.samples.eef.tarot.Player}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Players</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Players</em>' containment reference list.
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getGame_Players()
	 * @model containment="true" lower="3" upper="5"
	 * @generated
	 */
	EList<Player> getPlayers();

	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.samples.eef.tarot.ScoreEntry}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.samples.eef.tarot.ScoreEntry#getGame <em>Game</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getGame_Entries()
	 * @see org.eclipse.emf.samples.eef.tarot.ScoreEntry#getGame
	 * @model opposite="game" containment="true"
	 * @generated
	 */
	EList<ScoreEntry> getEntries();

} // Game

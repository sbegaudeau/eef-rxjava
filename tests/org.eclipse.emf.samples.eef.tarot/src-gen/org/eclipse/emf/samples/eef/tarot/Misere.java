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
 * $Id: Misere.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Misere</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Misere#getDeclarer <em>Declarer</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getMisere()
 * @model
 * @generated
 */
public interface Misere extends ScoreEntry {

	/**
	 * Returns the value of the '<em><b>Declarer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarer</em>' reference.
	 * @see #setDeclarer(Player)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getMisere_Declarer()
	 * @model required="true"
	 * @generated
	 */
	Player getDeclarer();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.Misere#getDeclarer <em>Declarer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declarer</em>' reference.
	 * @see #getDeclarer()
	 * @generated
	 */
	void setDeclarer(Player value);
} // Misere

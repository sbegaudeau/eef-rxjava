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
 * $Id: Bonus.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bonus</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Bonus#getSide <em>Side</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getBonus()
 * @model abstract="true"
 * @generated
 */
public interface Bonus extends EObject {

	/**
	 * Returns the value of the '<em><b>Side</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Side</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Side</em>' attribute.
	 * @see org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE
	 * @see #setSide(PLAYER_SIDE)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getBonus_Side()
	 * @model required="true"
	 * @generated
	 */
	PLAYER_SIDE getSide();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.Bonus#getSide <em>Side</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Side</em>' attribute.
	 * @see org.eclipse.emf.samples.eef.tarot.PLAYER_SIDE
	 * @see #getSide()
	 * @generated
	 */
	void setSide(PLAYER_SIDE value);

} // Bonus

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
 * $Id: Handful.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Handful</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Handful#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getHandful()
 * @model
 * @generated
 */
public interface Handful extends Bonus {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE
	 * @see #setSize(HANDFUL_SIZE)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getHandful_Size()
	 * @model required="true"
	 * @generated
	 */
	HANDFUL_SIZE getSize();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.Handful#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see org.eclipse.emf.samples.eef.tarot.HANDFUL_SIZE
	 * @see #getSize()
	 * @generated
	 */
	void setSize(HANDFUL_SIZE value);

} // Handful

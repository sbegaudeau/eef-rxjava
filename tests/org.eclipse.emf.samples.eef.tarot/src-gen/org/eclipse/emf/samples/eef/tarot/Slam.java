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
 * $Id: Slam.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slam</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Slam#isAnnounced <em>Announced</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Slam#isAchieved <em>Achieved</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getSlam()
 * @model
 * @generated
 */
public interface Slam extends Bonus {
	/**
	 * Returns the value of the '<em><b>Announced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Announced</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Announced</em>' attribute.
	 * @see #setAnnounced(boolean)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getSlam_Announced()
	 * @model required="true"
	 * @generated
	 */
	boolean isAnnounced();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.Slam#isAnnounced <em>Announced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Announced</em>' attribute.
	 * @see #isAnnounced()
	 * @generated
	 */
	void setAnnounced(boolean value);

	/**
	 * Returns the value of the '<em><b>Achieved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Achieved</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Achieved</em>' attribute.
	 * @see #setAchieved(boolean)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getSlam_Achieved()
	 * @model required="true"
	 * @generated
	 */
	boolean isAchieved();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.Slam#isAchieved <em>Achieved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Achieved</em>' attribute.
	 * @see #isAchieved()
	 * @generated
	 */
	void setAchieved(boolean value);

} // Slam

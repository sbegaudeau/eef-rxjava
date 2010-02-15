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
 * $Id: Round.java,v 1.1 2010/02/15 14:00:38 glefur Exp $
 */
package org.eclipse.emf.samples.eef.tarot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Round</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Round#getBid <em>Bid</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Round#getTaker <em>Taker</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Round#getPartner <em>Partner</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Round#getBonuses <em>Bonuses</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Round#getExtraPoints <em>Extra Points</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Round#getScore <em>Score</em>}</li>
 *   <li>{@link org.eclipse.emf.samples.eef.tarot.Round#isWon <em>Won</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getRound()
 * @model
 * @generated
 */
public interface Round extends ScoreEntry {
	/**
	 * Returns the value of the '<em><b>Bid</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.samples.eef.tarot.BID}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bid</em>' attribute.
	 * @see org.eclipse.emf.samples.eef.tarot.BID
	 * @see #setBid(BID)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getRound_Bid()
	 * @model required="true"
	 * @generated
	 */
	BID getBid();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.Round#getBid <em>Bid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bid</em>' attribute.
	 * @see org.eclipse.emf.samples.eef.tarot.BID
	 * @see #getBid()
	 * @generated
	 */
	void setBid(BID value);

	/**
	 * Returns the value of the '<em><b>Taker</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Taker</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Taker</em>' reference.
	 * @see #setTaker(Player)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getRound_Taker()
	 * @model required="true"
	 * @generated
	 */
	Player getTaker();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.Round#getTaker <em>Taker</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Taker</em>' reference.
	 * @see #getTaker()
	 * @generated
	 */
	void setTaker(Player value);

	/**
	 * Returns the value of the '<em><b>Partner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner</em>' reference.
	 * @see #setPartner(Player)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getRound_Partner()
	 * @model
	 * @generated
	 */
	Player getPartner();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.Round#getPartner <em>Partner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner</em>' reference.
	 * @see #getPartner()
	 * @generated
	 */
	void setPartner(Player value);

	/**
	 * Returns the value of the '<em><b>Bonuses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.samples.eef.tarot.Bonus}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bonuses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bonuses</em>' containment reference list.
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getRound_Bonuses()
	 * @model containment="true"
	 * @generated
	 */
	EList<Bonus> getBonuses();

	/**
	 * Returns the value of the '<em><b>Extra Points</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extra Points</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extra Points</em>' attribute.
	 * @see #setExtraPoints(int)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getRound_ExtraPoints()
	 * @model required="true"
	 * @generated
	 */
	int getExtraPoints();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.Round#getExtraPoints <em>Extra Points</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extra Points</em>' attribute.
	 * @see #getExtraPoints()
	 * @generated
	 */
	void setExtraPoints(int value);

	/**
	 * Returns the value of the '<em><b>Score</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Score</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Score</em>' attribute.
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getRound_Score()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getScore();

	/**
	 * Returns the value of the '<em><b>Won</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Won</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Won</em>' attribute.
	 * @see #setWon(boolean)
	 * @see org.eclipse.emf.samples.eef.tarot.TarotPackage#getRound_Won()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isWon();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.samples.eef.tarot.Round#isWon <em>Won</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Won</em>' attribute.
	 * @see #isWon()
	 * @generated
	 */
	void setWon(boolean value);

} // Round

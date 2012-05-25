/*******************************************************************************
 * Copyright (c) 2008, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.eef.modelingBot;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.Sequence#getActions <em>Actions</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.Sequence#getSequences <em>Sequences</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.Sequence#getProcessings <em>Processings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.modelingBot.ModelingBotPackage#getSequence()
 * @model abstract="true"
 * @generated
 */
public interface Sequence extends DocumentedElement, Processing {
	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.modelingBot.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see org.eclipse.emf.eef.modelingBot.ModelingBotPackage#getSequence_Actions()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Sequences</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.modelingBot.Sequence}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequences</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequences</em>' containment reference list.
	 * @see org.eclipse.emf.eef.modelingBot.ModelingBotPackage#getSequence_Sequences()
	 * @model containment="true" transient="true" derived="true"
	 * @generated
	 */
	EList<Sequence> getSequences();

	/**
	 * Returns the value of the '<em><b>Processings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.modelingBot.Processing}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processings</em>' containment reference list.
	 * @see org.eclipse.emf.eef.modelingBot.ModelingBotPackage#getSequence_Processings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Processing> getProcessings();

} // Sequence

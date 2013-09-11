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

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.eef.components.PropertiesEditionContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modeling Bot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.ModelingBot#getPropertiesEditionContext <em>Properties Edition Context</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.ModelingBot#getSequences <em>Sequences</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.modelingBot.ModelingBotPackage#getModelingBot()
 * @model
 * @generated
 */
public interface ModelingBot extends EObject {
	/**
	 * Returns the value of the '<em><b>Properties Edition Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties Edition Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties Edition Context</em>' reference.
	 * @see #setPropertiesEditionContext(PropertiesEditionContext)
	 * @see org.eclipse.emf.eef.modelingBot.ModelingBotPackage#getModelingBot_PropertiesEditionContext()
	 * @model
	 * @generated
	 */
	PropertiesEditionContext getPropertiesEditionContext();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.ModelingBot#getPropertiesEditionContext <em>Properties Edition Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties Edition Context</em>' reference.
	 * @see #getPropertiesEditionContext()
	 * @generated
	 */
	void setPropertiesEditionContext(PropertiesEditionContext value);

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
	 * @see org.eclipse.emf.eef.modelingBot.ModelingBotPackage#getModelingBot_Sequences()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sequence> getSequences();

} // ModelingBot

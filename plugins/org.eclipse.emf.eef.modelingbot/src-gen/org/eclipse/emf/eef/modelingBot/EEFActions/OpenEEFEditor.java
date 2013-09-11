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
package org.eclipse.emf.eef.modelingBot.EEFActions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open EEF Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.OpenEEFEditor#getEditorName <em>Editor Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getOpenEEFEditor()
 * @model
 * @generated
 */
public interface OpenEEFEditor extends EEFAction {
	/**
	 * Returns the value of the '<em><b>Editor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor Name</em>' attribute.
	 * @see #setEditorName(String)
	 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getOpenEEFEditor_EditorName()
	 * @model
	 * @generated
	 */
	String getEditorName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.EEFActions.OpenEEFEditor#getEditorName <em>Editor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editor Name</em>' attribute.
	 * @see #getEditorName()
	 * @generated
	 */
	void setEditorName(String value);

} // OpenEEFEditor

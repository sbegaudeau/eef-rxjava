/**
 * Copyright (c) 2010 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.eclipse.emf.eef.extended.editor;

import org.eclipse.emf.eef.mapping.AbstractElementBinding;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEF Editor Contribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.extended.editor.EEFEditorContribution#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.extended.editor.EditorPackage#getEEFEditorContribution()
 * @model
 * @generated
 */
public interface EEFEditorContribution extends AbstractElementBinding {
	/**
	 * Returns the value of the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model</em>' containment reference.
	 * @see #setModel(EEFPageInput)
	 * @see org.eclipse.emf.eef.extended.editor.EditorPackage#getEEFEditorContribution_Model()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EEFPageInput getModel();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.extended.editor.EEFEditorContribution#getModel <em>Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' containment reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(EEFPageInput value);

} // EEFEditorContribution

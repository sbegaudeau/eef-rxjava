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
package org.eclipse.emf.eef.modelingBot.EEFActions.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage;
import org.eclipse.emf.eef.modelingBot.EEFActions.OpenEEFEditor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Open EEF Editor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.impl.OpenEEFEditorImpl#getEditorName <em>Editor Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpenEEFEditorImpl extends EEFActionImpl implements OpenEEFEditor {
	/**
	 * The default value of the '{@link #getEditorName() <em>Editor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorName()
	 * @generated
	 * @ordered
	 */
	protected static final String EDITOR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEditorName() <em>Editor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditorName()
	 * @generated
	 * @ordered
	 */
	protected String editorName = EDITOR_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpenEEFEditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EEFActionsPackage.Literals.OPEN_EEF_EDITOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEditorName() {
		return editorName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEditorName(String newEditorName) {
		String oldEditorName = editorName;
		editorName = newEditorName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EEFActionsPackage.OPEN_EEF_EDITOR__EDITOR_NAME, oldEditorName, editorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EEFActionsPackage.OPEN_EEF_EDITOR__EDITOR_NAME:
				return getEditorName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case EEFActionsPackage.OPEN_EEF_EDITOR__EDITOR_NAME:
				setEditorName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case EEFActionsPackage.OPEN_EEF_EDITOR__EDITOR_NAME:
				setEditorName(EDITOR_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case EEFActionsPackage.OPEN_EEF_EDITOR__EDITOR_NAME:
				return EDITOR_NAME_EDEFAULT == null ? editorName != null : !EDITOR_NAME_EDEFAULT.equals(editorName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (editorName: ");
		result.append(editorName);
		result.append(')');
		return result.toString();
	}

} //OpenEEFEditorImpl

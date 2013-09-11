/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.modelingBot.EclipseActions.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsPackage;
import org.eclipse.emf.eef.modelingBot.EclipseActions.OpenEditor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Open Editor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.OpenEditorImpl#getEditorName <em>Editor Name</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.OpenEditorImpl#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OpenEditorImpl extends EclipseActionImpl implements OpenEditor {
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
	 * The cached value of the '{@link #getRoot() <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoot()
	 * @generated
	 * @ordered
	 */
	protected EClass root;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpenEditorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EclipseActionsPackage.Literals.OPEN_EDITOR;
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
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseActionsPackage.OPEN_EDITOR__EDITOR_NAME, oldEditorName, editorName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRoot() {
		if (root != null && root.eIsProxy()) {
			InternalEObject oldRoot = (InternalEObject)root;
			root = (EClass)eResolveProxy(oldRoot);
			if (root != oldRoot) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EclipseActionsPackage.OPEN_EDITOR__ROOT, oldRoot, root));
			}
		}
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetRoot() {
		return root;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRoot(EClass newRoot) {
		EClass oldRoot = root;
		root = newRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseActionsPackage.OPEN_EDITOR__ROOT, oldRoot, root));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EclipseActionsPackage.OPEN_EDITOR__EDITOR_NAME:
				return getEditorName();
			case EclipseActionsPackage.OPEN_EDITOR__ROOT:
				if (resolve) return getRoot();
				return basicGetRoot();
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
			case EclipseActionsPackage.OPEN_EDITOR__EDITOR_NAME:
				setEditorName((String)newValue);
				return;
			case EclipseActionsPackage.OPEN_EDITOR__ROOT:
				setRoot((EClass)newValue);
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
			case EclipseActionsPackage.OPEN_EDITOR__EDITOR_NAME:
				setEditorName(EDITOR_NAME_EDEFAULT);
				return;
			case EclipseActionsPackage.OPEN_EDITOR__ROOT:
				setRoot((EClass)null);
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
			case EclipseActionsPackage.OPEN_EDITOR__EDITOR_NAME:
				return EDITOR_NAME_EDEFAULT == null ? editorName != null : !EDITOR_NAME_EDEFAULT.equals(editorName);
			case EclipseActionsPackage.OPEN_EDITOR__ROOT:
				return root != null;
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

} //OpenEditorImpl

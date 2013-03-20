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
package org.eclipse.emf.eef.modelingBot.EclipseActions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.eef.modelingBot.EclipseActions.CreateModel;
import org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsPackage;
import org.eclipse.emf.eef.modelingBot.helper.EMFHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Create Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateModelImpl#getModelName <em>Model Name</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateModelImpl#getPath <em>Path</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateModelImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateModelImpl#getComputedRoot <em>Computed Root</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EclipseActions.impl.CreateModelImpl#getRootURI <em>Root URI</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CreateModelImpl extends EclipseActionImpl implements CreateModel {
	/**
	 * The default value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelName() <em>Model Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelName()
	 * @generated
	 * @ordered
	 */
	protected String modelName = MODEL_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected static final String PATH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected String path = PATH_EDEFAULT;

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
	 * The default value of the '{@link #getRootURI() <em>Root URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootURI()
	 * @generated
	 * @ordered
	 */
	protected static final String ROOT_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRootURI() <em>Root URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootURI()
	 * @generated
	 * @ordered
	 */
	protected String rootURI = ROOT_URI_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CreateModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EclipseActionsPackage.Literals.CREATE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelName(String newModelName) {
		String oldModelName = modelName;
		modelName = newModelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseActionsPackage.CREATE_MODEL__MODEL_NAME, oldModelName, modelName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPath() {
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPath(String newPath) {
		String oldPath = path;
		path = newPath;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseActionsPackage.CREATE_MODEL__PATH, oldPath, path));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EclipseActionsPackage.CREATE_MODEL__ROOT, oldRoot, root));
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
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseActionsPackage.CREATE_MODEL__ROOT, oldRoot, root));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputedRoot() {
		EClass computedRoot = basicGetComputedRoot();
		return computedRoot != null && computedRoot.eIsProxy() ? (EClass)eResolveProxy((InternalEObject)computedRoot) : computedRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EClass basicGetComputedRoot() {
		return EMFHelper.computeEObject(this, EclipseActionsPackage.Literals.CREATE_MODEL__ROOT, EclipseActionsPackage.Literals.CREATE_MODEL__ROOT_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRootURI() {
		return rootURI;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootURI(String newRootURI) {
		String oldRootURI = rootURI;
		rootURI = newRootURI;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EclipseActionsPackage.CREATE_MODEL__ROOT_URI, oldRootURI, rootURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EclipseActionsPackage.CREATE_MODEL__MODEL_NAME:
				return getModelName();
			case EclipseActionsPackage.CREATE_MODEL__PATH:
				return getPath();
			case EclipseActionsPackage.CREATE_MODEL__ROOT:
				if (resolve) return getRoot();
				return basicGetRoot();
			case EclipseActionsPackage.CREATE_MODEL__COMPUTED_ROOT:
				if (resolve) return getComputedRoot();
				return basicGetComputedRoot();
			case EclipseActionsPackage.CREATE_MODEL__ROOT_URI:
				return getRootURI();
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
			case EclipseActionsPackage.CREATE_MODEL__MODEL_NAME:
				setModelName((String)newValue);
				return;
			case EclipseActionsPackage.CREATE_MODEL__PATH:
				setPath((String)newValue);
				return;
			case EclipseActionsPackage.CREATE_MODEL__ROOT:
				setRoot((EClass)newValue);
				return;
			case EclipseActionsPackage.CREATE_MODEL__ROOT_URI:
				setRootURI((String)newValue);
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
			case EclipseActionsPackage.CREATE_MODEL__MODEL_NAME:
				setModelName(MODEL_NAME_EDEFAULT);
				return;
			case EclipseActionsPackage.CREATE_MODEL__PATH:
				setPath(PATH_EDEFAULT);
				return;
			case EclipseActionsPackage.CREATE_MODEL__ROOT:
				setRoot((EClass)null);
				return;
			case EclipseActionsPackage.CREATE_MODEL__ROOT_URI:
				setRootURI(ROOT_URI_EDEFAULT);
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
			case EclipseActionsPackage.CREATE_MODEL__MODEL_NAME:
				return MODEL_NAME_EDEFAULT == null ? modelName != null : !MODEL_NAME_EDEFAULT.equals(modelName);
			case EclipseActionsPackage.CREATE_MODEL__PATH:
				return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals(path);
			case EclipseActionsPackage.CREATE_MODEL__ROOT:
				return root != null;
			case EclipseActionsPackage.CREATE_MODEL__COMPUTED_ROOT:
				return basicGetComputedRoot() != null;
			case EclipseActionsPackage.CREATE_MODEL__ROOT_URI:
				return ROOT_URI_EDEFAULT == null ? rootURI != null : !ROOT_URI_EDEFAULT.equals(rootURI);
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
		result.append(" (modelName: ");
		result.append(modelName);
		result.append(", path: ");
		result.append(path);
		result.append(", rootURI: ");
		result.append(rootURI);
		result.append(')');
		return result.toString();
	}

} //CreateModelImpl

/**
 *  Copyright (c) 2008 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: PropertiesEditionContextImpl.java,v 1.1 2009/04/30 17:08:52 glefur Exp $
 */
package org.eclipse.emf.eef.components.impl;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.eef.components.ComponentsPackage;
import org.eclipse.emf.eef.components.PropertiesEditionContext;
import org.eclipse.emf.eef.mapping.impl.DatabindingImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Properties Edition Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.components.impl.PropertiesEditionContextImpl#getModel <em>Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertiesEditionContextImpl extends DatabindingImpl implements
		PropertiesEditionContext {
	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected GenPackage model;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertiesEditionContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.PROPERTIES_EDITION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPackage getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject) model;
			model = (GenPackage) eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							ComponentsPackage.PROPERTIES_EDITION_CONTEXT__MODEL,
							oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenPackage basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(GenPackage newModel) {
		GenPackage oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ComponentsPackage.PROPERTIES_EDITION_CONTEXT__MODEL,
					oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ComponentsPackage.PROPERTIES_EDITION_CONTEXT__MODEL:
			if (resolve)
				return getModel();
			return basicGetModel();
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
		case ComponentsPackage.PROPERTIES_EDITION_CONTEXT__MODEL:
			setModel((GenPackage) newValue);
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
		case ComponentsPackage.PROPERTIES_EDITION_CONTEXT__MODEL:
			setModel((GenPackage) null);
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
		case ComponentsPackage.PROPERTIES_EDITION_CONTEXT__MODEL:
			return model != null;
		}
		return super.eIsSet(featureID);
	}

} //PropertiesEditionContextImpl

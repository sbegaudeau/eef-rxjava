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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseAction;
import org.eclipse.emf.eef.modelingBot.EclipseActions.EclipseActionsPackage;

import org.eclipse.emf.eef.modelingBot.impl.ActionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Eclipse Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class EclipseActionImpl extends ActionImpl implements EclipseAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EclipseActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EclipseActionsPackage.Literals.ECLIPSE_ACTION;
	}

} //EclipseActionImpl

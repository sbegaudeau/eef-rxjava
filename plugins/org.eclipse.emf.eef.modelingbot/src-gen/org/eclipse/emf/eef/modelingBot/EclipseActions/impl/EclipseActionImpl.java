/**
 * <copyright>
 * </copyright>
 *
 * $Id: EclipseActionImpl.java,v 1.1 2011/04/06 13:07:27 nlepine Exp $
 */
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

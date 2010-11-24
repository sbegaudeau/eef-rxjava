/**
 * <copyright>
 * </copyright>
 *
 * $Id: OwnerImpl.java,v 1.1 2010/11/24 21:50:53 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.navigation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.eef.eefnr.impl.AbstractSampleImpl;

import org.eclipse.emf.eef.eefnr.navigation.MultipleReferencer;
import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;
import org.eclipse.emf.eef.eefnr.navigation.Owner;
import org.eclipse.emf.eef.eefnr.navigation.SingleReferencer;
import org.eclipse.emf.eef.eefnr.navigation.Referencer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Owner</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.OwnerImpl#getMultipleReferencers <em>Multiple Referencers</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.OwnerImpl#getSingleReferencers <em>Single Referencers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OwnerImpl extends AbstractSampleImpl implements Owner {
	/**
	 * The cached value of the '{@link #getMultipleReferencers() <em>Multiple Referencers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleReferencers()
	 * @generated
	 * @ordered
	 */
	protected EList<MultipleReferencer> multipleReferencers;
	/**
	 * The cached value of the '{@link #getSingleReferencers() <em>Single Referencers</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSingleReferencers()
	 * @generated
	 * @ordered
	 */
	protected SingleReferencer singleReferencers;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OwnerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NavigationPackage.Literals.OWNER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MultipleReferencer> getMultipleReferencers() {
		if (multipleReferencers == null) {
			multipleReferencers = new EObjectContainmentEList<MultipleReferencer>(MultipleReferencer.class, this, NavigationPackage.OWNER__MULTIPLE_REFERENCERS);
		}
		return multipleReferencers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleReferencer getSingleReferencers() {
		return singleReferencers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSingleReferencers(SingleReferencer newSingleReferencers, NotificationChain msgs) {
		SingleReferencer oldSingleReferencers = singleReferencers;
		singleReferencers = newSingleReferencers;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NavigationPackage.OWNER__SINGLE_REFERENCERS, oldSingleReferencers, newSingleReferencers);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleReferencers(SingleReferencer newSingleReferencers) {
		if (newSingleReferencers != singleReferencers) {
			NotificationChain msgs = null;
			if (singleReferencers != null)
				msgs = ((InternalEObject)singleReferencers).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.OWNER__SINGLE_REFERENCERS, null, msgs);
			if (newSingleReferencers != null)
				msgs = ((InternalEObject)newSingleReferencers).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.OWNER__SINGLE_REFERENCERS, null, msgs);
			msgs = basicSetSingleReferencers(newSingleReferencers, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.OWNER__SINGLE_REFERENCERS, newSingleReferencers, newSingleReferencers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NavigationPackage.OWNER__MULTIPLE_REFERENCERS:
				return ((InternalEList<?>)getMultipleReferencers()).basicRemove(otherEnd, msgs);
			case NavigationPackage.OWNER__SINGLE_REFERENCERS:
				return basicSetSingleReferencers(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NavigationPackage.OWNER__MULTIPLE_REFERENCERS:
				return getMultipleReferencers();
			case NavigationPackage.OWNER__SINGLE_REFERENCERS:
				return getSingleReferencers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NavigationPackage.OWNER__MULTIPLE_REFERENCERS:
				getMultipleReferencers().clear();
				getMultipleReferencers().addAll((Collection<? extends MultipleReferencer>)newValue);
				return;
			case NavigationPackage.OWNER__SINGLE_REFERENCERS:
				setSingleReferencers((SingleReferencer)newValue);
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
			case NavigationPackage.OWNER__MULTIPLE_REFERENCERS:
				getMultipleReferencers().clear();
				return;
			case NavigationPackage.OWNER__SINGLE_REFERENCERS:
				setSingleReferencers((SingleReferencer)null);
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
			case NavigationPackage.OWNER__MULTIPLE_REFERENCERS:
				return multipleReferencers != null && !multipleReferencers.isEmpty();
			case NavigationPackage.OWNER__SINGLE_REFERENCERS:
				return singleReferencers != null;
		}
		return super.eIsSet(featureID);
	}

} //OwnerImpl

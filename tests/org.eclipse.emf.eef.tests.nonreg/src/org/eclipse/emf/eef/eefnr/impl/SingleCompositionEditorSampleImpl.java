/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.eefnr.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.SingleCompositionEditorSample;
import org.eclipse.emf.eef.eefnr.TextSample;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Composition Editor Sample</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.SingleCompositionEditorSampleImpl#getSinglecompositioneditorRequiredProperty <em>Singlecompositioneditor Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.SingleCompositionEditorSampleImpl#getSinglecompositioneditorOptionalProperty <em>Singlecompositioneditor Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.SingleCompositionEditorSampleImpl#getSinglecompositioneditorROPropery <em>Singlecompositioneditor RO Propery</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SingleCompositionEditorSampleImpl extends AbstractSampleImpl implements SingleCompositionEditorSample {
	/**
	 * The cached value of the '{@link #getSinglecompositioneditorRequiredProperty() <em>Singlecompositioneditor Required Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinglecompositioneditorRequiredProperty()
	 * @generated
	 * @ordered
	 */
	protected TextSample singlecompositioneditorRequiredProperty;

	/**
	 * The cached value of the '{@link #getSinglecompositioneditorOptionalProperty() <em>Singlecompositioneditor Optional Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinglecompositioneditorOptionalProperty()
	 * @generated
	 * @ordered
	 */
	protected TextSample singlecompositioneditorOptionalProperty;

	/**
	 * The cached value of the '{@link #getSinglecompositioneditorROPropery() <em>Singlecompositioneditor RO Propery</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSinglecompositioneditorROPropery()
	 * @generated
	 * @ordered
	 */
	protected TextSample singlecompositioneditorROPropery;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SingleCompositionEditorSampleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefnrPackage.Literals.SINGLE_COMPOSITION_EDITOR_SAMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample getSinglecompositioneditorRequiredProperty() {
		return singlecompositioneditorRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSinglecompositioneditorRequiredProperty(TextSample newSinglecompositioneditorRequiredProperty, NotificationChain msgs) {
		TextSample oldSinglecompositioneditorRequiredProperty = singlecompositioneditorRequiredProperty;
		singlecompositioneditorRequiredProperty = newSinglecompositioneditorRequiredProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_REQUIRED_PROPERTY, oldSinglecompositioneditorRequiredProperty, newSinglecompositioneditorRequiredProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSinglecompositioneditorRequiredProperty(TextSample newSinglecompositioneditorRequiredProperty) {
		if (newSinglecompositioneditorRequiredProperty != singlecompositioneditorRequiredProperty) {
			NotificationChain msgs = null;
			if (singlecompositioneditorRequiredProperty != null)
				msgs = ((InternalEObject)singlecompositioneditorRequiredProperty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_REQUIRED_PROPERTY, null, msgs);
			if (newSinglecompositioneditorRequiredProperty != null)
				msgs = ((InternalEObject)newSinglecompositioneditorRequiredProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_REQUIRED_PROPERTY, null, msgs);
			msgs = basicSetSinglecompositioneditorRequiredProperty(newSinglecompositioneditorRequiredProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_REQUIRED_PROPERTY, newSinglecompositioneditorRequiredProperty, newSinglecompositioneditorRequiredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample getSinglecompositioneditorOptionalProperty() {
		return singlecompositioneditorOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSinglecompositioneditorOptionalProperty(TextSample newSinglecompositioneditorOptionalProperty, NotificationChain msgs) {
		TextSample oldSinglecompositioneditorOptionalProperty = singlecompositioneditorOptionalProperty;
		singlecompositioneditorOptionalProperty = newSinglecompositioneditorOptionalProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_OPTIONAL_PROPERTY, oldSinglecompositioneditorOptionalProperty, newSinglecompositioneditorOptionalProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSinglecompositioneditorOptionalProperty(TextSample newSinglecompositioneditorOptionalProperty) {
		if (newSinglecompositioneditorOptionalProperty != singlecompositioneditorOptionalProperty) {
			NotificationChain msgs = null;
			if (singlecompositioneditorOptionalProperty != null)
				msgs = ((InternalEObject)singlecompositioneditorOptionalProperty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_OPTIONAL_PROPERTY, null, msgs);
			if (newSinglecompositioneditorOptionalProperty != null)
				msgs = ((InternalEObject)newSinglecompositioneditorOptionalProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_OPTIONAL_PROPERTY, null, msgs);
			msgs = basicSetSinglecompositioneditorOptionalProperty(newSinglecompositioneditorOptionalProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_OPTIONAL_PROPERTY, newSinglecompositioneditorOptionalProperty, newSinglecompositioneditorOptionalProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample getSinglecompositioneditorROPropery() {
		return singlecompositioneditorROPropery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSinglecompositioneditorROPropery(TextSample newSinglecompositioneditorROPropery, NotificationChain msgs) {
		TextSample oldSinglecompositioneditorROPropery = singlecompositioneditorROPropery;
		singlecompositioneditorROPropery = newSinglecompositioneditorROPropery;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_RO_PROPERY, oldSinglecompositioneditorROPropery, newSinglecompositioneditorROPropery);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSinglecompositioneditorROPropery(TextSample newSinglecompositioneditorROPropery) {
		if (newSinglecompositioneditorROPropery != singlecompositioneditorROPropery) {
			NotificationChain msgs = null;
			if (singlecompositioneditorROPropery != null)
				msgs = ((InternalEObject)singlecompositioneditorROPropery).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_RO_PROPERY, null, msgs);
			if (newSinglecompositioneditorROPropery != null)
				msgs = ((InternalEObject)newSinglecompositioneditorROPropery).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_RO_PROPERY, null, msgs);
			msgs = basicSetSinglecompositioneditorROPropery(newSinglecompositioneditorROPropery, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_RO_PROPERY, newSinglecompositioneditorROPropery, newSinglecompositioneditorROPropery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_REQUIRED_PROPERTY:
				return basicSetSinglecompositioneditorRequiredProperty(null, msgs);
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_OPTIONAL_PROPERTY:
				return basicSetSinglecompositioneditorOptionalProperty(null, msgs);
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_RO_PROPERY:
				return basicSetSinglecompositioneditorROPropery(null, msgs);
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
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_REQUIRED_PROPERTY:
				return getSinglecompositioneditorRequiredProperty();
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_OPTIONAL_PROPERTY:
				return getSinglecompositioneditorOptionalProperty();
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_RO_PROPERY:
				return getSinglecompositioneditorROPropery();
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
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_REQUIRED_PROPERTY:
				setSinglecompositioneditorRequiredProperty((TextSample)newValue);
				return;
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_OPTIONAL_PROPERTY:
				setSinglecompositioneditorOptionalProperty((TextSample)newValue);
				return;
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_RO_PROPERY:
				setSinglecompositioneditorROPropery((TextSample)newValue);
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
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_REQUIRED_PROPERTY:
				setSinglecompositioneditorRequiredProperty((TextSample)null);
				return;
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_OPTIONAL_PROPERTY:
				setSinglecompositioneditorOptionalProperty((TextSample)null);
				return;
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_RO_PROPERY:
				setSinglecompositioneditorROPropery((TextSample)null);
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
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_REQUIRED_PROPERTY:
				return singlecompositioneditorRequiredProperty != null;
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_OPTIONAL_PROPERTY:
				return singlecompositioneditorOptionalProperty != null;
			case EefnrPackage.SINGLE_COMPOSITION_EDITOR_SAMPLE__SINGLECOMPOSITIONEDITOR_RO_PROPERY:
				return singlecompositioneditorROPropery != null;
		}
		return super.eIsSet(featureID);
	}

} //SingleCompositionEditorSampleImpl

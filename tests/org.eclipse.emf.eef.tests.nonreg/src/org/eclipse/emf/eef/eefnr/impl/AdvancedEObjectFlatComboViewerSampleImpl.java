/**
 * <copyright>
 * </copyright>
 *
 * $Id: AdvancedEObjectFlatComboViewerSampleImpl.java,v 1.1 2010/02/01 13:00:43 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.eef.eefnr.AdvancedEObjectFlatComboViewerSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TotalSample;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advanced EObject Flat Combo Viewer Sample</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.AdvancedEObjectFlatComboViewerSampleImpl#getAdvancedeobjectflatcomboviewerRequiredProperty <em>Advancedeobjectflatcomboviewer Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.AdvancedEObjectFlatComboViewerSampleImpl#getAdvancedeobjectflatcomboviewerOptionalProperty <em>Advancedeobjectflatcomboviewer Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.AdvancedEObjectFlatComboViewerSampleImpl#getAdvancedeobjectflatcomboviewerROPropery <em>Advancedeobjectflatcomboviewer RO Propery</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.AdvancedEObjectFlatComboViewerSampleImpl#getAdvancedeobjectflatcomboviewerCompoRequiredProperty <em>Advancedeobjectflatcomboviewer Compo Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.AdvancedEObjectFlatComboViewerSampleImpl#getAdvancedeobjectflatcomboviewerCompoOptionalProperty <em>Advancedeobjectflatcomboviewer Compo Optional Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdvancedEObjectFlatComboViewerSampleImpl extends AbstractSampleImpl implements AdvancedEObjectFlatComboViewerSample {
	/**
	 * The cached value of the '{@link #getAdvancedeobjectflatcomboviewerRequiredProperty() <em>Advancedeobjectflatcomboviewer Required Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvancedeobjectflatcomboviewerRequiredProperty()
	 * @generated
	 * @ordered
	 */
	protected TotalSample advancedeobjectflatcomboviewerRequiredProperty;

	/**
	 * The cached value of the '{@link #getAdvancedeobjectflatcomboviewerOptionalProperty() <em>Advancedeobjectflatcomboviewer Optional Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvancedeobjectflatcomboviewerOptionalProperty()
	 * @generated
	 * @ordered
	 */
	protected TotalSample advancedeobjectflatcomboviewerOptionalProperty;

	/**
	 * The cached value of the '{@link #getAdvancedeobjectflatcomboviewerROPropery() <em>Advancedeobjectflatcomboviewer RO Propery</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvancedeobjectflatcomboviewerROPropery()
	 * @generated
	 * @ordered
	 */
	protected TotalSample advancedeobjectflatcomboviewerROPropery;

	/**
	 * The cached value of the '{@link #getAdvancedeobjectflatcomboviewerCompoRequiredProperty() <em>Advancedeobjectflatcomboviewer Compo Required Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvancedeobjectflatcomboviewerCompoRequiredProperty()
	 * @generated
	 * @ordered
	 */
	protected TotalSample advancedeobjectflatcomboviewerCompoRequiredProperty;

	/**
	 * The cached value of the '{@link #getAdvancedeobjectflatcomboviewerCompoOptionalProperty() <em>Advancedeobjectflatcomboviewer Compo Optional Property</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvancedeobjectflatcomboviewerCompoOptionalProperty()
	 * @generated
	 * @ordered
	 */
	protected TotalSample advancedeobjectflatcomboviewerCompoOptionalProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdvancedEObjectFlatComboViewerSampleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefnrPackage.Literals.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalSample getAdvancedeobjectflatcomboviewerRequiredProperty() {
		if (advancedeobjectflatcomboviewerRequiredProperty != null && advancedeobjectflatcomboviewerRequiredProperty.eIsProxy()) {
			InternalEObject oldAdvancedeobjectflatcomboviewerRequiredProperty = (InternalEObject)advancedeobjectflatcomboviewerRequiredProperty;
			advancedeobjectflatcomboviewerRequiredProperty = (TotalSample)eResolveProxy(oldAdvancedeobjectflatcomboviewerRequiredProperty);
			if (advancedeobjectflatcomboviewerRequiredProperty != oldAdvancedeobjectflatcomboviewerRequiredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY, oldAdvancedeobjectflatcomboviewerRequiredProperty, advancedeobjectflatcomboviewerRequiredProperty));
			}
		}
		return advancedeobjectflatcomboviewerRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalSample basicGetAdvancedeobjectflatcomboviewerRequiredProperty() {
		return advancedeobjectflatcomboviewerRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdvancedeobjectflatcomboviewerRequiredProperty(TotalSample newAdvancedeobjectflatcomboviewerRequiredProperty) {
		TotalSample oldAdvancedeobjectflatcomboviewerRequiredProperty = advancedeobjectflatcomboviewerRequiredProperty;
		advancedeobjectflatcomboviewerRequiredProperty = newAdvancedeobjectflatcomboviewerRequiredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY, oldAdvancedeobjectflatcomboviewerRequiredProperty, advancedeobjectflatcomboviewerRequiredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalSample getAdvancedeobjectflatcomboviewerOptionalProperty() {
		if (advancedeobjectflatcomboviewerOptionalProperty != null && advancedeobjectflatcomboviewerOptionalProperty.eIsProxy()) {
			InternalEObject oldAdvancedeobjectflatcomboviewerOptionalProperty = (InternalEObject)advancedeobjectflatcomboviewerOptionalProperty;
			advancedeobjectflatcomboviewerOptionalProperty = (TotalSample)eResolveProxy(oldAdvancedeobjectflatcomboviewerOptionalProperty);
			if (advancedeobjectflatcomboviewerOptionalProperty != oldAdvancedeobjectflatcomboviewerOptionalProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY, oldAdvancedeobjectflatcomboviewerOptionalProperty, advancedeobjectflatcomboviewerOptionalProperty));
			}
		}
		return advancedeobjectflatcomboviewerOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalSample basicGetAdvancedeobjectflatcomboviewerOptionalProperty() {
		return advancedeobjectflatcomboviewerOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdvancedeobjectflatcomboviewerOptionalProperty(TotalSample newAdvancedeobjectflatcomboviewerOptionalProperty) {
		TotalSample oldAdvancedeobjectflatcomboviewerOptionalProperty = advancedeobjectflatcomboviewerOptionalProperty;
		advancedeobjectflatcomboviewerOptionalProperty = newAdvancedeobjectflatcomboviewerOptionalProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY, oldAdvancedeobjectflatcomboviewerOptionalProperty, advancedeobjectflatcomboviewerOptionalProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalSample getAdvancedeobjectflatcomboviewerROPropery() {
		if (advancedeobjectflatcomboviewerROPropery != null && advancedeobjectflatcomboviewerROPropery.eIsProxy()) {
			InternalEObject oldAdvancedeobjectflatcomboviewerROPropery = (InternalEObject)advancedeobjectflatcomboviewerROPropery;
			advancedeobjectflatcomboviewerROPropery = (TotalSample)eResolveProxy(oldAdvancedeobjectflatcomboviewerROPropery);
			if (advancedeobjectflatcomboviewerROPropery != oldAdvancedeobjectflatcomboviewerROPropery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_RO_PROPERY, oldAdvancedeobjectflatcomboviewerROPropery, advancedeobjectflatcomboviewerROPropery));
			}
		}
		return advancedeobjectflatcomboviewerROPropery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalSample basicGetAdvancedeobjectflatcomboviewerROPropery() {
		return advancedeobjectflatcomboviewerROPropery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdvancedeobjectflatcomboviewerROPropery(TotalSample newAdvancedeobjectflatcomboviewerROPropery) {
		TotalSample oldAdvancedeobjectflatcomboviewerROPropery = advancedeobjectflatcomboviewerROPropery;
		advancedeobjectflatcomboviewerROPropery = newAdvancedeobjectflatcomboviewerROPropery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_RO_PROPERY, oldAdvancedeobjectflatcomboviewerROPropery, advancedeobjectflatcomboviewerROPropery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalSample getAdvancedeobjectflatcomboviewerCompoRequiredProperty() {
		return advancedeobjectflatcomboviewerCompoRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdvancedeobjectflatcomboviewerCompoRequiredProperty(TotalSample newAdvancedeobjectflatcomboviewerCompoRequiredProperty, NotificationChain msgs) {
		TotalSample oldAdvancedeobjectflatcomboviewerCompoRequiredProperty = advancedeobjectflatcomboviewerCompoRequiredProperty;
		advancedeobjectflatcomboviewerCompoRequiredProperty = newAdvancedeobjectflatcomboviewerCompoRequiredProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_REQUIRED_PROPERTY, oldAdvancedeobjectflatcomboviewerCompoRequiredProperty, newAdvancedeobjectflatcomboviewerCompoRequiredProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdvancedeobjectflatcomboviewerCompoRequiredProperty(TotalSample newAdvancedeobjectflatcomboviewerCompoRequiredProperty) {
		if (newAdvancedeobjectflatcomboviewerCompoRequiredProperty != advancedeobjectflatcomboviewerCompoRequiredProperty) {
			NotificationChain msgs = null;
			if (advancedeobjectflatcomboviewerCompoRequiredProperty != null)
				msgs = ((InternalEObject)advancedeobjectflatcomboviewerCompoRequiredProperty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_REQUIRED_PROPERTY, null, msgs);
			if (newAdvancedeobjectflatcomboviewerCompoRequiredProperty != null)
				msgs = ((InternalEObject)newAdvancedeobjectflatcomboviewerCompoRequiredProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_REQUIRED_PROPERTY, null, msgs);
			msgs = basicSetAdvancedeobjectflatcomboviewerCompoRequiredProperty(newAdvancedeobjectflatcomboviewerCompoRequiredProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_REQUIRED_PROPERTY, newAdvancedeobjectflatcomboviewerCompoRequiredProperty, newAdvancedeobjectflatcomboviewerCompoRequiredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TotalSample getAdvancedeobjectflatcomboviewerCompoOptionalProperty() {
		return advancedeobjectflatcomboviewerCompoOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdvancedeobjectflatcomboviewerCompoOptionalProperty(TotalSample newAdvancedeobjectflatcomboviewerCompoOptionalProperty, NotificationChain msgs) {
		TotalSample oldAdvancedeobjectflatcomboviewerCompoOptionalProperty = advancedeobjectflatcomboviewerCompoOptionalProperty;
		advancedeobjectflatcomboviewerCompoOptionalProperty = newAdvancedeobjectflatcomboviewerCompoOptionalProperty;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_OPTIONAL_PROPERTY, oldAdvancedeobjectflatcomboviewerCompoOptionalProperty, newAdvancedeobjectflatcomboviewerCompoOptionalProperty);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdvancedeobjectflatcomboviewerCompoOptionalProperty(TotalSample newAdvancedeobjectflatcomboviewerCompoOptionalProperty) {
		if (newAdvancedeobjectflatcomboviewerCompoOptionalProperty != advancedeobjectflatcomboviewerCompoOptionalProperty) {
			NotificationChain msgs = null;
			if (advancedeobjectflatcomboviewerCompoOptionalProperty != null)
				msgs = ((InternalEObject)advancedeobjectflatcomboviewerCompoOptionalProperty).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_OPTIONAL_PROPERTY, null, msgs);
			if (newAdvancedeobjectflatcomboviewerCompoOptionalProperty != null)
				msgs = ((InternalEObject)newAdvancedeobjectflatcomboviewerCompoOptionalProperty).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_OPTIONAL_PROPERTY, null, msgs);
			msgs = basicSetAdvancedeobjectflatcomboviewerCompoOptionalProperty(newAdvancedeobjectflatcomboviewerCompoOptionalProperty, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_OPTIONAL_PROPERTY, newAdvancedeobjectflatcomboviewerCompoOptionalProperty, newAdvancedeobjectflatcomboviewerCompoOptionalProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_REQUIRED_PROPERTY:
				return basicSetAdvancedeobjectflatcomboviewerCompoRequiredProperty(null, msgs);
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_OPTIONAL_PROPERTY:
				return basicSetAdvancedeobjectflatcomboviewerCompoOptionalProperty(null, msgs);
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
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY:
				if (resolve) return getAdvancedeobjectflatcomboviewerRequiredProperty();
				return basicGetAdvancedeobjectflatcomboviewerRequiredProperty();
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY:
				if (resolve) return getAdvancedeobjectflatcomboviewerOptionalProperty();
				return basicGetAdvancedeobjectflatcomboviewerOptionalProperty();
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_RO_PROPERY:
				if (resolve) return getAdvancedeobjectflatcomboviewerROPropery();
				return basicGetAdvancedeobjectflatcomboviewerROPropery();
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_REQUIRED_PROPERTY:
				return getAdvancedeobjectflatcomboviewerCompoRequiredProperty();
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_OPTIONAL_PROPERTY:
				return getAdvancedeobjectflatcomboviewerCompoOptionalProperty();
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
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY:
				setAdvancedeobjectflatcomboviewerRequiredProperty((TotalSample)newValue);
				return;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY:
				setAdvancedeobjectflatcomboviewerOptionalProperty((TotalSample)newValue);
				return;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_RO_PROPERY:
				setAdvancedeobjectflatcomboviewerROPropery((TotalSample)newValue);
				return;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_REQUIRED_PROPERTY:
				setAdvancedeobjectflatcomboviewerCompoRequiredProperty((TotalSample)newValue);
				return;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_OPTIONAL_PROPERTY:
				setAdvancedeobjectflatcomboviewerCompoOptionalProperty((TotalSample)newValue);
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
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY:
				setAdvancedeobjectflatcomboviewerRequiredProperty((TotalSample)null);
				return;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY:
				setAdvancedeobjectflatcomboviewerOptionalProperty((TotalSample)null);
				return;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_RO_PROPERY:
				setAdvancedeobjectflatcomboviewerROPropery((TotalSample)null);
				return;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_REQUIRED_PROPERTY:
				setAdvancedeobjectflatcomboviewerCompoRequiredProperty((TotalSample)null);
				return;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_OPTIONAL_PROPERTY:
				setAdvancedeobjectflatcomboviewerCompoOptionalProperty((TotalSample)null);
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
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY:
				return advancedeobjectflatcomboviewerRequiredProperty != null;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY:
				return advancedeobjectflatcomboviewerOptionalProperty != null;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_RO_PROPERY:
				return advancedeobjectflatcomboviewerROPropery != null;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_REQUIRED_PROPERTY:
				return advancedeobjectflatcomboviewerCompoRequiredProperty != null;
			case EefnrPackage.ADVANCED_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__ADVANCEDEOBJECTFLATCOMBOVIEWER_COMPO_OPTIONAL_PROPERTY:
				return advancedeobjectflatcomboviewerCompoOptionalProperty != null;
		}
		return super.eIsSet(featureID);
	}

} //AdvancedEObjectFlatComboViewerSampleImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.eefnr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.LinkEObjectFlatComboViewerSample;
import org.eclipse.emf.eef.eefnr.TextSample;
import org.eclipse.emf.eef.eefnr.TotalSample;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link EObject Flat Combo Viewer Sample</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.LinkEObjectFlatComboViewerSampleImpl#getLinkeobjectflatcomboviewerRequiredProperty <em>Linkeobjectflatcomboviewer Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.LinkEObjectFlatComboViewerSampleImpl#getLinkeobjectflatcomboviewerOptionalProperty <em>Linkeobjectflatcomboviewer Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.LinkEObjectFlatComboViewerSampleImpl#getLinkeobjectflatcomboviewerROPropery <em>Linkeobjectflatcomboviewer RO Propery</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkEObjectFlatComboViewerSampleImpl extends AbstractSampleImpl implements LinkEObjectFlatComboViewerSample {
	/**
	 * The cached value of the '{@link #getLinkeobjectflatcomboviewerRequiredProperty() <em>Linkeobjectflatcomboviewer Required Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkeobjectflatcomboviewerRequiredProperty()
	 * @generated
	 * @ordered
	 */
	protected TextSample linkeobjectflatcomboviewerRequiredProperty;

	/**
	 * The cached value of the '{@link #getLinkeobjectflatcomboviewerOptionalProperty() <em>Linkeobjectflatcomboviewer Optional Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkeobjectflatcomboviewerOptionalProperty()
	 * @generated
	 * @ordered
	 */
	protected TextSample linkeobjectflatcomboviewerOptionalProperty;

	/**
	 * The cached value of the '{@link #getLinkeobjectflatcomboviewerROPropery() <em>Linkeobjectflatcomboviewer RO Propery</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkeobjectflatcomboviewerROPropery()
	 * @generated
	 * @ordered
	 */
	protected TextSample linkeobjectflatcomboviewerROPropery;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkEObjectFlatComboViewerSampleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefnrPackage.Literals.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample getLinkeobjectflatcomboviewerRequiredProperty() {
		if (linkeobjectflatcomboviewerRequiredProperty != null && linkeobjectflatcomboviewerRequiredProperty.eIsProxy()) {
			InternalEObject oldLinkeobjectflatcomboviewerRequiredProperty = (InternalEObject)linkeobjectflatcomboviewerRequiredProperty;
			linkeobjectflatcomboviewerRequiredProperty = (TextSample)eResolveProxy(oldLinkeobjectflatcomboviewerRequiredProperty);
			if (linkeobjectflatcomboviewerRequiredProperty != oldLinkeobjectflatcomboviewerRequiredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY, oldLinkeobjectflatcomboviewerRequiredProperty, linkeobjectflatcomboviewerRequiredProperty));
			}
		}
		return linkeobjectflatcomboviewerRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample basicGetLinkeobjectflatcomboviewerRequiredProperty() {
		return linkeobjectflatcomboviewerRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkeobjectflatcomboviewerRequiredProperty(TextSample newLinkeobjectflatcomboviewerRequiredProperty) {
		TextSample oldLinkeobjectflatcomboviewerRequiredProperty = linkeobjectflatcomboviewerRequiredProperty;
		linkeobjectflatcomboviewerRequiredProperty = newLinkeobjectflatcomboviewerRequiredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY, oldLinkeobjectflatcomboviewerRequiredProperty, linkeobjectflatcomboviewerRequiredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample getLinkeobjectflatcomboviewerOptionalProperty() {
		if (linkeobjectflatcomboviewerOptionalProperty != null && linkeobjectflatcomboviewerOptionalProperty.eIsProxy()) {
			InternalEObject oldLinkeobjectflatcomboviewerOptionalProperty = (InternalEObject)linkeobjectflatcomboviewerOptionalProperty;
			linkeobjectflatcomboviewerOptionalProperty = (TextSample)eResolveProxy(oldLinkeobjectflatcomboviewerOptionalProperty);
			if (linkeobjectflatcomboviewerOptionalProperty != oldLinkeobjectflatcomboviewerOptionalProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY, oldLinkeobjectflatcomboviewerOptionalProperty, linkeobjectflatcomboviewerOptionalProperty));
			}
		}
		return linkeobjectflatcomboviewerOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample basicGetLinkeobjectflatcomboviewerOptionalProperty() {
		return linkeobjectflatcomboviewerOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkeobjectflatcomboviewerOptionalProperty(TextSample newLinkeobjectflatcomboviewerOptionalProperty) {
		TextSample oldLinkeobjectflatcomboviewerOptionalProperty = linkeobjectflatcomboviewerOptionalProperty;
		linkeobjectflatcomboviewerOptionalProperty = newLinkeobjectflatcomboviewerOptionalProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY, oldLinkeobjectflatcomboviewerOptionalProperty, linkeobjectflatcomboviewerOptionalProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample getLinkeobjectflatcomboviewerROPropery() {
		if (linkeobjectflatcomboviewerROPropery != null && linkeobjectflatcomboviewerROPropery.eIsProxy()) {
			InternalEObject oldLinkeobjectflatcomboviewerROPropery = (InternalEObject)linkeobjectflatcomboviewerROPropery;
			linkeobjectflatcomboviewerROPropery = (TextSample)eResolveProxy(oldLinkeobjectflatcomboviewerROPropery);
			if (linkeobjectflatcomboviewerROPropery != oldLinkeobjectflatcomboviewerROPropery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_RO_PROPERY, oldLinkeobjectflatcomboviewerROPropery, linkeobjectflatcomboviewerROPropery));
			}
		}
		return linkeobjectflatcomboviewerROPropery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample basicGetLinkeobjectflatcomboviewerROPropery() {
		return linkeobjectflatcomboviewerROPropery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkeobjectflatcomboviewerROPropery(TextSample newLinkeobjectflatcomboviewerROPropery) {
		TextSample oldLinkeobjectflatcomboviewerROPropery = linkeobjectflatcomboviewerROPropery;
		linkeobjectflatcomboviewerROPropery = newLinkeobjectflatcomboviewerROPropery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_RO_PROPERY, oldLinkeobjectflatcomboviewerROPropery, linkeobjectflatcomboviewerROPropery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY:
				if (resolve) return getLinkeobjectflatcomboviewerRequiredProperty();
				return basicGetLinkeobjectflatcomboviewerRequiredProperty();
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY:
				if (resolve) return getLinkeobjectflatcomboviewerOptionalProperty();
				return basicGetLinkeobjectflatcomboviewerOptionalProperty();
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_RO_PROPERY:
				if (resolve) return getLinkeobjectflatcomboviewerROPropery();
				return basicGetLinkeobjectflatcomboviewerROPropery();
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
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY:
				setLinkeobjectflatcomboviewerRequiredProperty((TextSample)newValue);
				return;
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY:
				setLinkeobjectflatcomboviewerOptionalProperty((TextSample)newValue);
				return;
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_RO_PROPERY:
				setLinkeobjectflatcomboviewerROPropery((TextSample)newValue);
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
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY:
				setLinkeobjectflatcomboviewerRequiredProperty((TextSample)null);
				return;
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY:
				setLinkeobjectflatcomboviewerOptionalProperty((TextSample)null);
				return;
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_RO_PROPERY:
				setLinkeobjectflatcomboviewerROPropery((TextSample)null);
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
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_REQUIRED_PROPERTY:
				return linkeobjectflatcomboviewerRequiredProperty != null;
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_OPTIONAL_PROPERTY:
				return linkeobjectflatcomboviewerOptionalProperty != null;
			case EefnrPackage.LINK_EOBJECT_FLAT_COMBO_VIEWER_SAMPLE__LINKEOBJECTFLATCOMBOVIEWER_RO_PROPERY:
				return linkeobjectflatcomboviewerROPropery != null;
		}
		return super.eIsSet(featureID);
	}

} //LinkEObjectFlatComboViewerSampleImpl

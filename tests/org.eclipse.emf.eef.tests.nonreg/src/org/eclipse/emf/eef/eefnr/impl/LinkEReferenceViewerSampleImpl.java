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
import org.eclipse.emf.eef.eefnr.LinkEReferenceViewerSample;
import org.eclipse.emf.eef.eefnr.TextSample;
import org.eclipse.emf.eef.eefnr.TotalSample;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Link EReference Viewer Sample</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.LinkEReferenceViewerSampleImpl#getLinkereferenceviewerRequiredProperty <em>Linkereferenceviewer Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.LinkEReferenceViewerSampleImpl#getLinkereferenceviewerOptionalProperty <em>Linkereferenceviewer Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.LinkEReferenceViewerSampleImpl#getLinkereferenceviewerROPropery <em>Linkereferenceviewer RO Propery</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LinkEReferenceViewerSampleImpl extends AbstractSampleImpl implements LinkEReferenceViewerSample {
	/**
	 * The cached value of the '{@link #getLinkereferenceviewerRequiredProperty() <em>Linkereferenceviewer Required Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkereferenceviewerRequiredProperty()
	 * @generated
	 * @ordered
	 */
	protected TextSample linkereferenceviewerRequiredProperty;

	/**
	 * The cached value of the '{@link #getLinkereferenceviewerOptionalProperty() <em>Linkereferenceviewer Optional Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkereferenceviewerOptionalProperty()
	 * @generated
	 * @ordered
	 */
	protected TextSample linkereferenceviewerOptionalProperty;

	/**
	 * The cached value of the '{@link #getLinkereferenceviewerROPropery() <em>Linkereferenceviewer RO Propery</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinkereferenceviewerROPropery()
	 * @generated
	 * @ordered
	 */
	protected TextSample linkereferenceviewerROPropery;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LinkEReferenceViewerSampleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefnrPackage.Literals.LINK_EREFERENCE_VIEWER_SAMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample getLinkereferenceviewerRequiredProperty() {
		if (linkereferenceviewerRequiredProperty != null && linkereferenceviewerRequiredProperty.eIsProxy()) {
			InternalEObject oldLinkereferenceviewerRequiredProperty = (InternalEObject)linkereferenceviewerRequiredProperty;
			linkereferenceviewerRequiredProperty = (TextSample)eResolveProxy(oldLinkereferenceviewerRequiredProperty);
			if (linkereferenceviewerRequiredProperty != oldLinkereferenceviewerRequiredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_REQUIRED_PROPERTY, oldLinkereferenceviewerRequiredProperty, linkereferenceviewerRequiredProperty));
			}
		}
		return linkereferenceviewerRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample basicGetLinkereferenceviewerRequiredProperty() {
		return linkereferenceviewerRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkereferenceviewerRequiredProperty(TextSample newLinkereferenceviewerRequiredProperty) {
		TextSample oldLinkereferenceviewerRequiredProperty = linkereferenceviewerRequiredProperty;
		linkereferenceviewerRequiredProperty = newLinkereferenceviewerRequiredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_REQUIRED_PROPERTY, oldLinkereferenceviewerRequiredProperty, linkereferenceviewerRequiredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample getLinkereferenceviewerOptionalProperty() {
		if (linkereferenceviewerOptionalProperty != null && linkereferenceviewerOptionalProperty.eIsProxy()) {
			InternalEObject oldLinkereferenceviewerOptionalProperty = (InternalEObject)linkereferenceviewerOptionalProperty;
			linkereferenceviewerOptionalProperty = (TextSample)eResolveProxy(oldLinkereferenceviewerOptionalProperty);
			if (linkereferenceviewerOptionalProperty != oldLinkereferenceviewerOptionalProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_OPTIONAL_PROPERTY, oldLinkereferenceviewerOptionalProperty, linkereferenceviewerOptionalProperty));
			}
		}
		return linkereferenceviewerOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample basicGetLinkereferenceviewerOptionalProperty() {
		return linkereferenceviewerOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkereferenceviewerOptionalProperty(TextSample newLinkereferenceviewerOptionalProperty) {
		TextSample oldLinkereferenceviewerOptionalProperty = linkereferenceviewerOptionalProperty;
		linkereferenceviewerOptionalProperty = newLinkereferenceviewerOptionalProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_OPTIONAL_PROPERTY, oldLinkereferenceviewerOptionalProperty, linkereferenceviewerOptionalProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample getLinkereferenceviewerROPropery() {
		if (linkereferenceviewerROPropery != null && linkereferenceviewerROPropery.eIsProxy()) {
			InternalEObject oldLinkereferenceviewerROPropery = (InternalEObject)linkereferenceviewerROPropery;
			linkereferenceviewerROPropery = (TextSample)eResolveProxy(oldLinkereferenceviewerROPropery);
			if (linkereferenceviewerROPropery != oldLinkereferenceviewerROPropery) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_RO_PROPERY, oldLinkereferenceviewerROPropery, linkereferenceviewerROPropery));
			}
		}
		return linkereferenceviewerROPropery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextSample basicGetLinkereferenceviewerROPropery() {
		return linkereferenceviewerROPropery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLinkereferenceviewerROPropery(TextSample newLinkereferenceviewerROPropery) {
		TextSample oldLinkereferenceviewerROPropery = linkereferenceviewerROPropery;
		linkereferenceviewerROPropery = newLinkereferenceviewerROPropery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_RO_PROPERY, oldLinkereferenceviewerROPropery, linkereferenceviewerROPropery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_REQUIRED_PROPERTY:
				if (resolve) return getLinkereferenceviewerRequiredProperty();
				return basicGetLinkereferenceviewerRequiredProperty();
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_OPTIONAL_PROPERTY:
				if (resolve) return getLinkereferenceviewerOptionalProperty();
				return basicGetLinkereferenceviewerOptionalProperty();
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_RO_PROPERY:
				if (resolve) return getLinkereferenceviewerROPropery();
				return basicGetLinkereferenceviewerROPropery();
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
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_REQUIRED_PROPERTY:
				setLinkereferenceviewerRequiredProperty((TextSample)newValue);
				return;
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_OPTIONAL_PROPERTY:
				setLinkereferenceviewerOptionalProperty((TextSample)newValue);
				return;
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_RO_PROPERY:
				setLinkereferenceviewerROPropery((TextSample)newValue);
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
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_REQUIRED_PROPERTY:
				setLinkereferenceviewerRequiredProperty((TextSample)null);
				return;
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_OPTIONAL_PROPERTY:
				setLinkereferenceviewerOptionalProperty((TextSample)null);
				return;
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_RO_PROPERY:
				setLinkereferenceviewerROPropery((TextSample)null);
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
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_REQUIRED_PROPERTY:
				return linkereferenceviewerRequiredProperty != null;
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_OPTIONAL_PROPERTY:
				return linkereferenceviewerOptionalProperty != null;
			case EefnrPackage.LINK_EREFERENCE_VIEWER_SAMPLE__LINKEREFERENCEVIEWER_RO_PROPERY:
				return linkereferenceviewerROPropery != null;
		}
		return super.eIsSet(featureID);
	}

} //LinkEReferenceViewerSampleImpl

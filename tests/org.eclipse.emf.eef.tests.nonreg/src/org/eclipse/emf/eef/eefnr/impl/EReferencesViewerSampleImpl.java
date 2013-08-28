/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.eefnr.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.eef.eefnr.EReferencesViewerSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TotalSample;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EReferences Viewer Sample</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.EReferencesViewerSampleImpl#getEreferencesviewerRequiredProperty <em>Ereferencesviewer Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.EReferencesViewerSampleImpl#getEreferencesviewerOptionalProperty <em>Ereferencesviewer Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.EReferencesViewerSampleImpl#getEreferencesviewerROProperty <em>Ereferencesviewer RO Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EReferencesViewerSampleImpl extends AbstractSampleImpl implements EReferencesViewerSample {
	/**
	 * The cached value of the '{@link #getEreferencesviewerRequiredProperty() <em>Ereferencesviewer Required Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEreferencesviewerRequiredProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<TotalSample> ereferencesviewerRequiredProperty;

	/**
	 * The cached value of the '{@link #getEreferencesviewerOptionalProperty() <em>Ereferencesviewer Optional Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEreferencesviewerOptionalProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<TotalSample> ereferencesviewerOptionalProperty;

	/**
	 * The cached value of the '{@link #getEreferencesviewerROProperty() <em>Ereferencesviewer RO Property</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEreferencesviewerROProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<TotalSample> ereferencesviewerROProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EReferencesViewerSampleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefnrPackage.Literals.EREFERENCES_VIEWER_SAMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TotalSample> getEreferencesviewerRequiredProperty() {
		if (ereferencesviewerRequiredProperty == null) {
			ereferencesviewerRequiredProperty = new EObjectResolvingEList<TotalSample>(TotalSample.class, this, EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_REQUIRED_PROPERTY);
		}
		return ereferencesviewerRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TotalSample> getEreferencesviewerOptionalProperty() {
		if (ereferencesviewerOptionalProperty == null) {
			ereferencesviewerOptionalProperty = new EObjectResolvingEList<TotalSample>(TotalSample.class, this, EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_OPTIONAL_PROPERTY);
		}
		return ereferencesviewerOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TotalSample> getEreferencesviewerROProperty() {
		if (ereferencesviewerROProperty == null) {
			ereferencesviewerROProperty = new EObjectResolvingEList<TotalSample>(TotalSample.class, this, EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_RO_PROPERTY);
		}
		return ereferencesviewerROProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_REQUIRED_PROPERTY:
				return getEreferencesviewerRequiredProperty();
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_OPTIONAL_PROPERTY:
				return getEreferencesviewerOptionalProperty();
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_RO_PROPERTY:
				return getEreferencesviewerROProperty();
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
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_REQUIRED_PROPERTY:
				getEreferencesviewerRequiredProperty().clear();
				getEreferencesviewerRequiredProperty().addAll((Collection<? extends TotalSample>)newValue);
				return;
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_OPTIONAL_PROPERTY:
				getEreferencesviewerOptionalProperty().clear();
				getEreferencesviewerOptionalProperty().addAll((Collection<? extends TotalSample>)newValue);
				return;
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_RO_PROPERTY:
				getEreferencesviewerROProperty().clear();
				getEreferencesviewerROProperty().addAll((Collection<? extends TotalSample>)newValue);
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
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_REQUIRED_PROPERTY:
				getEreferencesviewerRequiredProperty().clear();
				return;
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_OPTIONAL_PROPERTY:
				getEreferencesviewerOptionalProperty().clear();
				return;
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_RO_PROPERTY:
				getEreferencesviewerROProperty().clear();
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
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_REQUIRED_PROPERTY:
				return ereferencesviewerRequiredProperty != null && !ereferencesviewerRequiredProperty.isEmpty();
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_OPTIONAL_PROPERTY:
				return ereferencesviewerOptionalProperty != null && !ereferencesviewerOptionalProperty.isEmpty();
			case EefnrPackage.EREFERENCES_VIEWER_SAMPLE__EREFERENCESVIEWER_RO_PROPERTY:
				return ereferencesviewerROProperty != null && !ereferencesviewerROProperty.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //EReferencesViewerSampleImpl

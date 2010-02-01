/**
 * <copyright>
 * </copyright>
 *
 * $Id: AdvancedTableCompositionEditorSampleImpl.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TotalSample;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Advanced Table Composition Editor Sample</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.AdvancedTableCompositionEditorSampleImpl#getAdvancedtablecompositionRequiredProperty <em>Advancedtablecomposition Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.AdvancedTableCompositionEditorSampleImpl#getAdvancedtablecompositionOptionalProperty <em>Advancedtablecomposition Optional Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdvancedTableCompositionEditorSampleImpl extends AbstractSampleImpl implements AdvancedTableCompositionEditorSample {
	/**
	 * The cached value of the '{@link #getAdvancedtablecompositionRequiredProperty() <em>Advancedtablecomposition Required Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvancedtablecompositionRequiredProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<TotalSample> advancedtablecompositionRequiredProperty;

	/**
	 * The cached value of the '{@link #getAdvancedtablecompositionOptionalProperty() <em>Advancedtablecomposition Optional Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdvancedtablecompositionOptionalProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<TotalSample> advancedtablecompositionOptionalProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdvancedTableCompositionEditorSampleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefnrPackage.Literals.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TotalSample> getAdvancedtablecompositionRequiredProperty() {
		if (advancedtablecompositionRequiredProperty == null) {
			advancedtablecompositionRequiredProperty = new EObjectContainmentEList<TotalSample>(TotalSample.class, this, EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_REQUIRED_PROPERTY);
		}
		return advancedtablecompositionRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TotalSample> getAdvancedtablecompositionOptionalProperty() {
		if (advancedtablecompositionOptionalProperty == null) {
			advancedtablecompositionOptionalProperty = new EObjectContainmentEList<TotalSample>(TotalSample.class, this, EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_OPTIONAL_PROPERTY);
		}
		return advancedtablecompositionOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_REQUIRED_PROPERTY:
				return ((InternalEList<?>)getAdvancedtablecompositionRequiredProperty()).basicRemove(otherEnd, msgs);
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_OPTIONAL_PROPERTY:
				return ((InternalEList<?>)getAdvancedtablecompositionOptionalProperty()).basicRemove(otherEnd, msgs);
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
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_REQUIRED_PROPERTY:
				return getAdvancedtablecompositionRequiredProperty();
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_OPTIONAL_PROPERTY:
				return getAdvancedtablecompositionOptionalProperty();
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
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_REQUIRED_PROPERTY:
				getAdvancedtablecompositionRequiredProperty().clear();
				getAdvancedtablecompositionRequiredProperty().addAll((Collection<? extends TotalSample>)newValue);
				return;
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_OPTIONAL_PROPERTY:
				getAdvancedtablecompositionOptionalProperty().clear();
				getAdvancedtablecompositionOptionalProperty().addAll((Collection<? extends TotalSample>)newValue);
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
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_REQUIRED_PROPERTY:
				getAdvancedtablecompositionRequiredProperty().clear();
				return;
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_OPTIONAL_PROPERTY:
				getAdvancedtablecompositionOptionalProperty().clear();
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
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_REQUIRED_PROPERTY:
				return advancedtablecompositionRequiredProperty != null && !advancedtablecompositionRequiredProperty.isEmpty();
			case EefnrPackage.ADVANCED_TABLE_COMPOSITION_EDITOR_SAMPLE__ADVANCEDTABLECOMPOSITION_OPTIONAL_PROPERTY:
				return advancedtablecompositionOptionalProperty != null && !advancedtablecompositionOptionalProperty.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AdvancedTableCompositionEditorSampleImpl

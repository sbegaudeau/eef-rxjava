/**
 * <copyright>
 * </copyright>
 *
 * $Id: MultipleReferencerImpl.java,v 1.2 2010/11/30 08:23:18 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.navigation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.eef.eefnr.navigation.MultipleReferencer;
import org.eclipse.emf.eef.eefnr.navigation.NavigationPackage;
import org.eclipse.emf.eef.eefnr.navigation.Owner;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiple Referencer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.MultipleReferencerImpl#getMultipleSampleForTableComposition <em>Multiple Sample For Table Composition</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.MultipleReferencerImpl#getMultipleSampleForAdvancedTableComposition <em>Multiple Sample For Advanced Table Composition</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.MultipleReferencerImpl#getMultipleSampleForReferencesTable <em>Multiple Sample For References Table</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.MultipleReferencerImpl#getMultipleSampleAdvancedReferencesTable <em>Multiple Sample Advanced References Table</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.impl.MultipleReferencerImpl#getMultipleSampleForFlatReferencesTable <em>Multiple Sample For Flat References Table</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultipleReferencerImpl extends EObjectImpl implements MultipleReferencer {
	/**
	 * The cached value of the '{@link #getMultipleSampleForTableComposition() <em>Multiple Sample For Table Composition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleSampleForTableComposition()
	 * @generated
	 * @ordered
	 */
	protected Owner multipleSampleForTableComposition;

	/**
	 * The cached value of the '{@link #getMultipleSampleForAdvancedTableComposition() <em>Multiple Sample For Advanced Table Composition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleSampleForAdvancedTableComposition()
	 * @generated
	 * @ordered
	 */
	protected Owner multipleSampleForAdvancedTableComposition;

	/**
	 * The cached value of the '{@link #getMultipleSampleForReferencesTable() <em>Multiple Sample For References Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleSampleForReferencesTable()
	 * @generated
	 * @ordered
	 */
	protected Owner multipleSampleForReferencesTable;

	/**
	 * The cached value of the '{@link #getMultipleSampleAdvancedReferencesTable() <em>Multiple Sample Advanced References Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleSampleAdvancedReferencesTable()
	 * @generated
	 * @ordered
	 */
	protected Owner multipleSampleAdvancedReferencesTable;

	/**
	 * The cached value of the '{@link #getMultipleSampleForFlatReferencesTable() <em>Multiple Sample For Flat References Table</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultipleSampleForFlatReferencesTable()
	 * @generated
	 * @ordered
	 */
	protected Owner multipleSampleForFlatReferencesTable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultipleReferencerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NavigationPackage.Literals.MULTIPLE_REFERENCER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner getMultipleSampleForTableComposition() {
		return multipleSampleForTableComposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMultipleSampleForTableComposition(Owner newMultipleSampleForTableComposition, NotificationChain msgs) {
		Owner oldMultipleSampleForTableComposition = multipleSampleForTableComposition;
		multipleSampleForTableComposition = newMultipleSampleForTableComposition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_TABLE_COMPOSITION, oldMultipleSampleForTableComposition, newMultipleSampleForTableComposition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultipleSampleForTableComposition(Owner newMultipleSampleForTableComposition) {
		if (newMultipleSampleForTableComposition != multipleSampleForTableComposition) {
			NotificationChain msgs = null;
			if (multipleSampleForTableComposition != null)
				msgs = ((InternalEObject)multipleSampleForTableComposition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_TABLE_COMPOSITION, null, msgs);
			if (newMultipleSampleForTableComposition != null)
				msgs = ((InternalEObject)newMultipleSampleForTableComposition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_TABLE_COMPOSITION, null, msgs);
			msgs = basicSetMultipleSampleForTableComposition(newMultipleSampleForTableComposition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_TABLE_COMPOSITION, newMultipleSampleForTableComposition, newMultipleSampleForTableComposition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner getMultipleSampleForAdvancedTableComposition() {
		return multipleSampleForAdvancedTableComposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMultipleSampleForAdvancedTableComposition(Owner newMultipleSampleForAdvancedTableComposition, NotificationChain msgs) {
		Owner oldMultipleSampleForAdvancedTableComposition = multipleSampleForAdvancedTableComposition;
		multipleSampleForAdvancedTableComposition = newMultipleSampleForAdvancedTableComposition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION, oldMultipleSampleForAdvancedTableComposition, newMultipleSampleForAdvancedTableComposition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultipleSampleForAdvancedTableComposition(Owner newMultipleSampleForAdvancedTableComposition) {
		if (newMultipleSampleForAdvancedTableComposition != multipleSampleForAdvancedTableComposition) {
			NotificationChain msgs = null;
			if (multipleSampleForAdvancedTableComposition != null)
				msgs = ((InternalEObject)multipleSampleForAdvancedTableComposition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION, null, msgs);
			if (newMultipleSampleForAdvancedTableComposition != null)
				msgs = ((InternalEObject)newMultipleSampleForAdvancedTableComposition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION, null, msgs);
			msgs = basicSetMultipleSampleForAdvancedTableComposition(newMultipleSampleForAdvancedTableComposition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION, newMultipleSampleForAdvancedTableComposition, newMultipleSampleForAdvancedTableComposition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner getMultipleSampleForReferencesTable() {
		if (multipleSampleForReferencesTable != null && multipleSampleForReferencesTable.eIsProxy()) {
			InternalEObject oldMultipleSampleForReferencesTable = (InternalEObject)multipleSampleForReferencesTable;
			multipleSampleForReferencesTable = (Owner)eResolveProxy(oldMultipleSampleForReferencesTable);
			if (multipleSampleForReferencesTable != oldMultipleSampleForReferencesTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_REFERENCES_TABLE, oldMultipleSampleForReferencesTable, multipleSampleForReferencesTable));
			}
		}
		return multipleSampleForReferencesTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner basicGetMultipleSampleForReferencesTable() {
		return multipleSampleForReferencesTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultipleSampleForReferencesTable(Owner newMultipleSampleForReferencesTable) {
		Owner oldMultipleSampleForReferencesTable = multipleSampleForReferencesTable;
		multipleSampleForReferencesTable = newMultipleSampleForReferencesTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_REFERENCES_TABLE, oldMultipleSampleForReferencesTable, multipleSampleForReferencesTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner getMultipleSampleAdvancedReferencesTable() {
		if (multipleSampleAdvancedReferencesTable != null && multipleSampleAdvancedReferencesTable.eIsProxy()) {
			InternalEObject oldMultipleSampleAdvancedReferencesTable = (InternalEObject)multipleSampleAdvancedReferencesTable;
			multipleSampleAdvancedReferencesTable = (Owner)eResolveProxy(oldMultipleSampleAdvancedReferencesTable);
			if (multipleSampleAdvancedReferencesTable != oldMultipleSampleAdvancedReferencesTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_ADVANCED_REFERENCES_TABLE, oldMultipleSampleAdvancedReferencesTable, multipleSampleAdvancedReferencesTable));
			}
		}
		return multipleSampleAdvancedReferencesTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner basicGetMultipleSampleAdvancedReferencesTable() {
		return multipleSampleAdvancedReferencesTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultipleSampleAdvancedReferencesTable(Owner newMultipleSampleAdvancedReferencesTable) {
		Owner oldMultipleSampleAdvancedReferencesTable = multipleSampleAdvancedReferencesTable;
		multipleSampleAdvancedReferencesTable = newMultipleSampleAdvancedReferencesTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_ADVANCED_REFERENCES_TABLE, oldMultipleSampleAdvancedReferencesTable, multipleSampleAdvancedReferencesTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner getMultipleSampleForFlatReferencesTable() {
		if (multipleSampleForFlatReferencesTable != null && multipleSampleForFlatReferencesTable.eIsProxy()) {
			InternalEObject oldMultipleSampleForFlatReferencesTable = (InternalEObject)multipleSampleForFlatReferencesTable;
			multipleSampleForFlatReferencesTable = (Owner)eResolveProxy(oldMultipleSampleForFlatReferencesTable);
			if (multipleSampleForFlatReferencesTable != oldMultipleSampleForFlatReferencesTable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_FLAT_REFERENCES_TABLE, oldMultipleSampleForFlatReferencesTable, multipleSampleForFlatReferencesTable));
			}
		}
		return multipleSampleForFlatReferencesTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Owner basicGetMultipleSampleForFlatReferencesTable() {
		return multipleSampleForFlatReferencesTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultipleSampleForFlatReferencesTable(Owner newMultipleSampleForFlatReferencesTable) {
		Owner oldMultipleSampleForFlatReferencesTable = multipleSampleForFlatReferencesTable;
		multipleSampleForFlatReferencesTable = newMultipleSampleForFlatReferencesTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_FLAT_REFERENCES_TABLE, oldMultipleSampleForFlatReferencesTable, multipleSampleForFlatReferencesTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_TABLE_COMPOSITION:
				return basicSetMultipleSampleForTableComposition(null, msgs);
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION:
				return basicSetMultipleSampleForAdvancedTableComposition(null, msgs);
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
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_TABLE_COMPOSITION:
				return getMultipleSampleForTableComposition();
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION:
				return getMultipleSampleForAdvancedTableComposition();
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_REFERENCES_TABLE:
				if (resolve) return getMultipleSampleForReferencesTable();
				return basicGetMultipleSampleForReferencesTable();
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_ADVANCED_REFERENCES_TABLE:
				if (resolve) return getMultipleSampleAdvancedReferencesTable();
				return basicGetMultipleSampleAdvancedReferencesTable();
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_FLAT_REFERENCES_TABLE:
				if (resolve) return getMultipleSampleForFlatReferencesTable();
				return basicGetMultipleSampleForFlatReferencesTable();
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
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_TABLE_COMPOSITION:
				setMultipleSampleForTableComposition((Owner)newValue);
				return;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION:
				setMultipleSampleForAdvancedTableComposition((Owner)newValue);
				return;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_REFERENCES_TABLE:
				setMultipleSampleForReferencesTable((Owner)newValue);
				return;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_ADVANCED_REFERENCES_TABLE:
				setMultipleSampleAdvancedReferencesTable((Owner)newValue);
				return;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_FLAT_REFERENCES_TABLE:
				setMultipleSampleForFlatReferencesTable((Owner)newValue);
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
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_TABLE_COMPOSITION:
				setMultipleSampleForTableComposition((Owner)null);
				return;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION:
				setMultipleSampleForAdvancedTableComposition((Owner)null);
				return;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_REFERENCES_TABLE:
				setMultipleSampleForReferencesTable((Owner)null);
				return;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_ADVANCED_REFERENCES_TABLE:
				setMultipleSampleAdvancedReferencesTable((Owner)null);
				return;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_FLAT_REFERENCES_TABLE:
				setMultipleSampleForFlatReferencesTable((Owner)null);
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
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_TABLE_COMPOSITION:
				return multipleSampleForTableComposition != null;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_ADVANCED_TABLE_COMPOSITION:
				return multipleSampleForAdvancedTableComposition != null;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_REFERENCES_TABLE:
				return multipleSampleForReferencesTable != null;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_ADVANCED_REFERENCES_TABLE:
				return multipleSampleAdvancedReferencesTable != null;
			case NavigationPackage.MULTIPLE_REFERENCER__MULTIPLE_SAMPLE_FOR_FLAT_REFERENCES_TABLE:
				return multipleSampleForFlatReferencesTable != null;
		}
		return super.eIsSet(featureID);
	}

} //MultipleReferencerImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.mapping.settings.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.eef.mapping.filters.StepFilter;

import org.eclipse.emf.eef.mapping.settings.EReferenceViewerSettings;
import org.eclipse.emf.eef.mapping.settings.SettingsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EReference Viewer Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.mapping.settings.impl.EReferenceViewerSettingsImpl#getModel <em>Model</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.mapping.settings.impl.EReferenceViewerSettingsImpl#getFilter <em>Filter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EReferenceViewerSettingsImpl extends EditorSettingsImpl implements
		EReferenceViewerSettings {
	/**
	 * The cached value of the '{@link #getModel() <em>Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModel()
	 * @generated
	 * @ordered
	 */
	protected EReference model;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected StepFilter filter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EReferenceViewerSettingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SettingsPackage.Literals.EREFERENCE_VIEWER_SETTINGS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModel() {
		if (model != null && model.eIsProxy()) {
			InternalEObject oldModel = (InternalEObject) model;
			model = (EReference) eResolveProxy(oldModel);
			if (model != oldModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							SettingsPackage.EREFERENCE_VIEWER_SETTINGS__MODEL,
							oldModel, model));
			}
		}
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetModel() {
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModel(EReference newModel) {
		EReference oldModel = model;
		model = newModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					SettingsPackage.EREFERENCE_VIEWER_SETTINGS__MODEL,
					oldModel, model));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepFilter getFilter() {
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFilter(StepFilter newFilter,
			NotificationChain msgs) {
		StepFilter oldFilter = filter;
		filter = newFilter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					SettingsPackage.EREFERENCE_VIEWER_SETTINGS__FILTER,
					oldFilter, newFilter);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter(StepFilter newFilter) {
		if (newFilter != filter) {
			NotificationChain msgs = null;
			if (filter != null)
				msgs = ((InternalEObject) filter)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- SettingsPackage.EREFERENCE_VIEWER_SETTINGS__FILTER,
								null, msgs);
			if (newFilter != null)
				msgs = ((InternalEObject) newFilter)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- SettingsPackage.EREFERENCE_VIEWER_SETTINGS__FILTER,
								null, msgs);
			msgs = basicSetFilter(newFilter, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					SettingsPackage.EREFERENCE_VIEWER_SETTINGS__FILTER,
					newFilter, newFilter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case SettingsPackage.EREFERENCE_VIEWER_SETTINGS__FILTER:
			return basicSetFilter(null, msgs);
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
		case SettingsPackage.EREFERENCE_VIEWER_SETTINGS__MODEL:
			if (resolve)
				return getModel();
			return basicGetModel();
		case SettingsPackage.EREFERENCE_VIEWER_SETTINGS__FILTER:
			return getFilter();
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
		case SettingsPackage.EREFERENCE_VIEWER_SETTINGS__MODEL:
			setModel((EReference) newValue);
			return;
		case SettingsPackage.EREFERENCE_VIEWER_SETTINGS__FILTER:
			setFilter((StepFilter) newValue);
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
		case SettingsPackage.EREFERENCE_VIEWER_SETTINGS__MODEL:
			setModel((EReference) null);
			return;
		case SettingsPackage.EREFERENCE_VIEWER_SETTINGS__FILTER:
			setFilter((StepFilter) null);
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
		case SettingsPackage.EREFERENCE_VIEWER_SETTINGS__MODEL:
			return model != null;
		case SettingsPackage.EREFERENCE_VIEWER_SETTINGS__FILTER:
			return filter != null;
		}
		return super.eIsSet(featureID);
	}

} //EReferenceViewerSettingsImpl

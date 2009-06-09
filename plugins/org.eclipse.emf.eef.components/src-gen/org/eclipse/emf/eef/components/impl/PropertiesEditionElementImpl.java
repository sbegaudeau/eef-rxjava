/**
 *  Copyright (c) 2008 Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Obeo - initial API and implementation
 * 
 *
 * $Id: PropertiesEditionElementImpl.java,v 1.2 2009/06/09 15:47:24 sbouchet Exp $
 */
package org.eclipse.emf.eef.components.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.eef.components.ComponentsPackage;
import org.eclipse.emf.eef.components.EEFElement;
import org.eclipse.emf.eef.components.PropertiesEditionElement;
import org.eclipse.emf.eef.mapping.impl.EMFPropertyBindingImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Properties Edition Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.components.impl.PropertiesEditionElementImpl#getHelpID <em>Help ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertiesEditionElementImpl extends EMFPropertyBindingImpl
		implements PropertiesEditionElement {
	/**
	 * The default value of the '{@link #getHelpID() <em>Help ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelpID()
	 * @generated
	 * @ordered
	 */
	protected static final String HELP_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getHelpID() <em>Help ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelpID()
	 * @generated
	 * @ordered
	 */
	protected String helpID = HELP_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertiesEditionElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComponentsPackage.Literals.PROPERTIES_EDITION_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHelpID() {
		return helpID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHelpID(String newHelpID) {
		String oldHelpID = helpID;
		helpID = newHelpID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ComponentsPackage.PROPERTIES_EDITION_ELEMENT__HELP_ID,
					oldHelpID, helpID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ComponentsPackage.PROPERTIES_EDITION_ELEMENT__HELP_ID:
			return getHelpID();
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
		case ComponentsPackage.PROPERTIES_EDITION_ELEMENT__HELP_ID:
			setHelpID((String) newValue);
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
		case ComponentsPackage.PROPERTIES_EDITION_ELEMENT__HELP_ID:
			setHelpID(HELP_ID_EDEFAULT);
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
		case ComponentsPackage.PROPERTIES_EDITION_ELEMENT__HELP_ID:
			return HELP_ID_EDEFAULT == null ? helpID != null
					: !HELP_ID_EDEFAULT.equals(helpID);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EEFElement.class) {
			switch (derivedFeatureID) {
			case ComponentsPackage.PROPERTIES_EDITION_ELEMENT__HELP_ID:
				return ComponentsPackage.EEF_ELEMENT__HELP_ID;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EEFElement.class) {
			switch (baseFeatureID) {
			case ComponentsPackage.EEF_ELEMENT__HELP_ID:
				return ComponentsPackage.PROPERTIES_EDITION_ELEMENT__HELP_ID;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (helpID: ");
		result.append(helpID);
		result.append(')');
		return result.toString();
	}

} //PropertiesEditionElementImpl

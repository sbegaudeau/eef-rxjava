/**
 * <copyright>
 * </copyright>
 *
 * $Id: TextSampleImpl.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.eef.eefnr.EefnrPackage;
import org.eclipse.emf.eef.eefnr.TextSample;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text Sample</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.TextSampleImpl#getTextRequiredProperty <em>Text Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.TextSampleImpl#getTextOptionalProperty <em>Text Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.impl.TextSampleImpl#getTextROProperty <em>Text RO Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextSampleImpl extends AbstractSampleImpl implements TextSample {
	/**
	 * The default value of the '{@link #getTextRequiredProperty() <em>Text Required Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextRequiredProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_REQUIRED_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextRequiredProperty() <em>Text Required Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextRequiredProperty()
	 * @generated
	 * @ordered
	 */
	protected String textRequiredProperty = TEXT_REQUIRED_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTextOptionalProperty() <em>Text Optional Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextOptionalProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_OPTIONAL_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextOptionalProperty() <em>Text Optional Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextOptionalProperty()
	 * @generated
	 * @ordered
	 */
	protected String textOptionalProperty = TEXT_OPTIONAL_PROPERTY_EDEFAULT;

	/**
	 * The default value of the '{@link #getTextROProperty() <em>Text RO Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextROProperty()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_RO_PROPERTY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTextROProperty() <em>Text RO Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTextROProperty()
	 * @generated
	 * @ordered
	 */
	protected String textROProperty = TEXT_RO_PROPERTY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextSampleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EefnrPackage.Literals.TEXT_SAMPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextRequiredProperty() {
		return textRequiredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextRequiredProperty(String newTextRequiredProperty) {
		String oldTextRequiredProperty = textRequiredProperty;
		textRequiredProperty = newTextRequiredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.TEXT_SAMPLE__TEXT_REQUIRED_PROPERTY, oldTextRequiredProperty, textRequiredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextOptionalProperty() {
		return textOptionalProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextOptionalProperty(String newTextOptionalProperty) {
		String oldTextOptionalProperty = textOptionalProperty;
		textOptionalProperty = newTextOptionalProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.TEXT_SAMPLE__TEXT_OPTIONAL_PROPERTY, oldTextOptionalProperty, textOptionalProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTextROProperty() {
		return textROProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTextROProperty(String newTextROProperty) {
		String oldTextROProperty = textROProperty;
		textROProperty = newTextROProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EefnrPackage.TEXT_SAMPLE__TEXT_RO_PROPERTY, oldTextROProperty, textROProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case EefnrPackage.TEXT_SAMPLE__TEXT_REQUIRED_PROPERTY:
				return getTextRequiredProperty();
			case EefnrPackage.TEXT_SAMPLE__TEXT_OPTIONAL_PROPERTY:
				return getTextOptionalProperty();
			case EefnrPackage.TEXT_SAMPLE__TEXT_RO_PROPERTY:
				return getTextROProperty();
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
			case EefnrPackage.TEXT_SAMPLE__TEXT_REQUIRED_PROPERTY:
				setTextRequiredProperty((String)newValue);
				return;
			case EefnrPackage.TEXT_SAMPLE__TEXT_OPTIONAL_PROPERTY:
				setTextOptionalProperty((String)newValue);
				return;
			case EefnrPackage.TEXT_SAMPLE__TEXT_RO_PROPERTY:
				setTextROProperty((String)newValue);
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
			case EefnrPackage.TEXT_SAMPLE__TEXT_REQUIRED_PROPERTY:
				setTextRequiredProperty(TEXT_REQUIRED_PROPERTY_EDEFAULT);
				return;
			case EefnrPackage.TEXT_SAMPLE__TEXT_OPTIONAL_PROPERTY:
				setTextOptionalProperty(TEXT_OPTIONAL_PROPERTY_EDEFAULT);
				return;
			case EefnrPackage.TEXT_SAMPLE__TEXT_RO_PROPERTY:
				setTextROProperty(TEXT_RO_PROPERTY_EDEFAULT);
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
			case EefnrPackage.TEXT_SAMPLE__TEXT_REQUIRED_PROPERTY:
				return TEXT_REQUIRED_PROPERTY_EDEFAULT == null ? textRequiredProperty != null : !TEXT_REQUIRED_PROPERTY_EDEFAULT.equals(textRequiredProperty);
			case EefnrPackage.TEXT_SAMPLE__TEXT_OPTIONAL_PROPERTY:
				return TEXT_OPTIONAL_PROPERTY_EDEFAULT == null ? textOptionalProperty != null : !TEXT_OPTIONAL_PROPERTY_EDEFAULT.equals(textOptionalProperty);
			case EefnrPackage.TEXT_SAMPLE__TEXT_RO_PROPERTY:
				return TEXT_RO_PROPERTY_EDEFAULT == null ? textROProperty != null : !TEXT_RO_PROPERTY_EDEFAULT.equals(textROProperty);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (textRequiredProperty: ");
		result.append(textRequiredProperty);
		result.append(", textOptionalProperty: ");
		result.append(textOptionalProperty);
		result.append(", textROProperty: ");
		result.append(textROProperty);
		result.append(')');
		return result.toString();
	}

} //TextSampleImpl

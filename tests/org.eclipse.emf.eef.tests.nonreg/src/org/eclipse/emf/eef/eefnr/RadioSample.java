/**
 * <copyright>
 * </copyright>
 *
 * $Id: RadioSample.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Radio Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.RadioSample#getRadioRequiredProperty <em>Radio Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.RadioSample#getRadioOptionalProperty <em>Radio Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.RadioSample#getRadioROProperty <em>Radio RO Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getRadioSample()
 * @model
 * @generated
 */
public interface RadioSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Radio Required Property</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.eef.eefnr.ENUM_SAMPLE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radio Required Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radio Required Property</em>' attribute.
	 * @see org.eclipse.emf.eef.eefnr.ENUM_SAMPLE
	 * @see #setRadioRequiredProperty(ENUM_SAMPLE)
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getRadioSample_RadioRequiredProperty()
	 * @model required="true"
	 * @generated
	 */
	ENUM_SAMPLE getRadioRequiredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.RadioSample#getRadioRequiredProperty <em>Radio Required Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radio Required Property</em>' attribute.
	 * @see org.eclipse.emf.eef.eefnr.ENUM_SAMPLE
	 * @see #getRadioRequiredProperty()
	 * @generated
	 */
	void setRadioRequiredProperty(ENUM_SAMPLE value);

	/**
	 * Returns the value of the '<em><b>Radio Optional Property</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.eef.eefnr.ENUM_SAMPLE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radio Optional Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radio Optional Property</em>' attribute.
	 * @see org.eclipse.emf.eef.eefnr.ENUM_SAMPLE
	 * @see #setRadioOptionalProperty(ENUM_SAMPLE)
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getRadioSample_RadioOptionalProperty()
	 * @model
	 * @generated
	 */
	ENUM_SAMPLE getRadioOptionalProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.RadioSample#getRadioOptionalProperty <em>Radio Optional Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radio Optional Property</em>' attribute.
	 * @see org.eclipse.emf.eef.eefnr.ENUM_SAMPLE
	 * @see #getRadioOptionalProperty()
	 * @generated
	 */
	void setRadioOptionalProperty(ENUM_SAMPLE value);

	/**
	 * Returns the value of the '<em><b>Radio RO Property</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.eef.eefnr.ENUM_SAMPLE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Radio RO Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Radio RO Property</em>' attribute.
	 * @see org.eclipse.emf.eef.eefnr.ENUM_SAMPLE
	 * @see #setRadioROProperty(ENUM_SAMPLE)
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getRadioSample_RadioROProperty()
	 * @model
	 * @generated
	 */
	ENUM_SAMPLE getRadioROProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.RadioSample#getRadioROProperty <em>Radio RO Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Radio RO Property</em>' attribute.
	 * @see org.eclipse.emf.eef.eefnr.ENUM_SAMPLE
	 * @see #getRadioROProperty()
	 * @generated
	 */
	void setRadioROProperty(ENUM_SAMPLE value);

} // RadioSample

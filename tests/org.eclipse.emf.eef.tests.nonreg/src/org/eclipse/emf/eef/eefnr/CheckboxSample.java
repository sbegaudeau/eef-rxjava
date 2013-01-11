/**
 * <copyright>
 * </copyright>
 *
 * $Id: CheckboxSample.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Checkbox Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.CheckboxSample#isCheckboxRequiredProperty <em>Checkbox Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.CheckboxSample#isCheckboxOptionalProperty <em>Checkbox Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.CheckboxSample#isCheckboxROProperty <em>Checkbox RO Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getCheckboxSample()
 * @model
 * @generated
 */
public interface CheckboxSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Checkbox Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkbox Required Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkbox Required Property</em>' attribute.
	 * @see #setCheckboxRequiredProperty(boolean)
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getCheckboxSample_CheckboxRequiredProperty()
	 * @model required="true"
	 * @generated
	 */
	boolean isCheckboxRequiredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.CheckboxSample#isCheckboxRequiredProperty <em>Checkbox Required Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkbox Required Property</em>' attribute.
	 * @see #isCheckboxRequiredProperty()
	 * @generated
	 */
	void setCheckboxRequiredProperty(boolean value);

	/**
	 * Returns the value of the '<em><b>Checkbox Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkbox Optional Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkbox Optional Property</em>' attribute.
	 * @see #setCheckboxOptionalProperty(boolean)
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getCheckboxSample_CheckboxOptionalProperty()
	 * @model
	 * @generated
	 */
	boolean isCheckboxOptionalProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.CheckboxSample#isCheckboxOptionalProperty <em>Checkbox Optional Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkbox Optional Property</em>' attribute.
	 * @see #isCheckboxOptionalProperty()
	 * @generated
	 */
	void setCheckboxOptionalProperty(boolean value);

	/**
	 * Returns the value of the '<em><b>Checkbox RO Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checkbox RO Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checkbox RO Property</em>' attribute.
	 * @see #setCheckboxROProperty(boolean)
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getCheckboxSample_CheckboxROProperty()
	 * @model
	 * @generated
	 */
	boolean isCheckboxROProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.CheckboxSample#isCheckboxROProperty <em>Checkbox RO Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checkbox RO Property</em>' attribute.
	 * @see #isCheckboxROProperty()
	 * @generated
	 */
	void setCheckboxROProperty(boolean value);

} // CheckboxSample

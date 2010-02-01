/**
 * <copyright>
 * </copyright>
 *
 * $Id: TextSample.java,v 1.1 2010/02/01 13:00:45 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.TextSample#getTextRequiredProperty <em>Text Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.TextSample#getTextOptionalProperty <em>Text Optional Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getTextSample()
 * @model
 * @generated
 */
public interface TextSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Text Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Required Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Required Property</em>' attribute.
	 * @see #setTextRequiredProperty(String)
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getTextSample_TextRequiredProperty()
	 * @model required="true"
	 * @generated
	 */
	String getTextRequiredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.TextSample#getTextRequiredProperty <em>Text Required Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Required Property</em>' attribute.
	 * @see #getTextRequiredProperty()
	 * @generated
	 */
	void setTextRequiredProperty(String value);

	/**
	 * Returns the value of the '<em><b>Text Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text Optional Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text Optional Property</em>' attribute.
	 * @see #setTextOptionalProperty(String)
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getTextSample_TextOptionalProperty()
	 * @model
	 * @generated
	 */
	String getTextOptionalProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.TextSample#getTextOptionalProperty <em>Text Optional Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Optional Property</em>' attribute.
	 * @see #getTextOptionalProperty()
	 * @generated
	 */
	void setTextOptionalProperty(String value);

} // TextSample

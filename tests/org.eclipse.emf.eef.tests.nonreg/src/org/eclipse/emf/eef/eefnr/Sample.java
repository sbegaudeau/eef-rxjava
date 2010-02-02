/**
 * <copyright>
 * </copyright>
 *
 * $Id: Sample.java,v 1.1 2010/02/02 10:03:51 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.Sample#getTextRequiredProperty <em>Text Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.Sample#getTextOptionalProperty <em>Text Optional Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getSample()
 * @model
 * @generated
 */
public interface Sample extends AbstractSample {
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
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getSample_TextRequiredProperty()
	 * @model required="true"
	 * @generated
	 */
	String getTextRequiredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.Sample#getTextRequiredProperty <em>Text Required Property</em>}' attribute.
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
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getSample_TextOptionalProperty()
	 * @model
	 * @generated
	 */
	String getTextOptionalProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.Sample#getTextOptionalProperty <em>Text Optional Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text Optional Property</em>' attribute.
	 * @see #getTextOptionalProperty()
	 * @generated
	 */
	void setTextOptionalProperty(String value);

} // Sample

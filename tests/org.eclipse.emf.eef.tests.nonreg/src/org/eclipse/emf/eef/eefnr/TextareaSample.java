/**
 * <copyright>
 * </copyright>
 *
 * $Id: TextareaSample.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Textarea Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.TextareaSample#getTextareaRequiredProperty <em>Textarea Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.TextareaSample#getTextareaOptionalProperty <em>Textarea Optional Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getTextareaSample()
 * @model
 * @generated
 */
public interface TextareaSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Textarea Required Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textarea Required Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Textarea Required Property</em>' attribute.
	 * @see #setTextareaRequiredProperty(String)
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getTextareaSample_TextareaRequiredProperty()
	 * @model required="true"
	 * @generated
	 */
	String getTextareaRequiredProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.TextareaSample#getTextareaRequiredProperty <em>Textarea Required Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Textarea Required Property</em>' attribute.
	 * @see #getTextareaRequiredProperty()
	 * @generated
	 */
	void setTextareaRequiredProperty(String value);

	/**
	 * Returns the value of the '<em><b>Textarea Optional Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Textarea Optional Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Textarea Optional Property</em>' attribute.
	 * @see #setTextareaOptionalProperty(String)
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getTextareaSample_TextareaOptionalProperty()
	 * @model
	 * @generated
	 */
	String getTextareaOptionalProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.TextareaSample#getTextareaOptionalProperty <em>Textarea Optional Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Textarea Optional Property</em>' attribute.
	 * @see #getTextareaOptionalProperty()
	 * @generated
	 */
	void setTextareaOptionalProperty(String value);

} // TextareaSample

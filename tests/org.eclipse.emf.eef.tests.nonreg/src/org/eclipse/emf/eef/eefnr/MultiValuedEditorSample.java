/**
 * <copyright>
 * </copyright>
 *
 * $Id: MultiValuedEditorSample.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Valued Editor Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.MultiValuedEditorSample#getMultivaluededitorRequiredProperty <em>Multivaluededitor Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.MultiValuedEditorSample#getMultivaluededitorOptionalProperty <em>Multivaluededitor Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.MultiValuedEditorSample#getMultivaluededitorROProperty <em>Multivaluededitor RO Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getMultiValuedEditorSample()
 * @model
 * @generated
 */
public interface MultiValuedEditorSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Multivaluededitor Required Property</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multivaluededitor Required Property</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multivaluededitor Required Property</em>' attribute list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getMultiValuedEditorSample_MultivaluededitorRequiredProperty()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getMultivaluededitorRequiredProperty();

	/**
	 * Returns the value of the '<em><b>Multivaluededitor Optional Property</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multivaluededitor Optional Property</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multivaluededitor Optional Property</em>' attribute list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getMultiValuedEditorSample_MultivaluededitorOptionalProperty()
	 * @model
	 * @generated
	 */
	EList<String> getMultivaluededitorOptionalProperty();

	/**
	 * Returns the value of the '<em><b>Multivaluededitor RO Property</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multivaluededitor RO Property</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multivaluededitor RO Property</em>' attribute list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getMultiValuedEditorSample_MultivaluededitorROProperty()
	 * @model
	 * @generated
	 */
	EList<String> getMultivaluededitorROProperty();

} // MultiValuedEditorSample

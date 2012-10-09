/**
 * <copyright>
 * </copyright>
 *
 * $Id: FlatReferencesTableSample.java,v 1.1 2010/02/02 09:29:38 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flat References Table Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.FlatReferencesTableSample#getFlatreferencestableRequiredProperty <em>Flatreferencestable Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.FlatReferencesTableSample#getFlatreferencestableOptionalProperty <em>Flatreferencestable Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.FlatReferencesTableSample#getFlatreferencestableROProperty <em>Flatreferencestable RO Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getFlatReferencesTableSample()
 * @model
 * @generated
 */
public interface FlatReferencesTableSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Flatreferencestable Required Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flatreferencestable Required Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flatreferencestable Required Property</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getFlatReferencesTableSample_FlatreferencestableRequiredProperty()
	 * @model required="true"
	 * @generated
	 */
	EList<TotalSample> getFlatreferencestableRequiredProperty();

	/**
	 * Returns the value of the '<em><b>Flatreferencestable Optional Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flatreferencestable Optional Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flatreferencestable Optional Property</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getFlatReferencesTableSample_FlatreferencestableOptionalProperty()
	 * @model
	 * @generated
	 */
	EList<TotalSample> getFlatreferencestableOptionalProperty();

	/**
	 * Returns the value of the '<em><b>Flatreferencestable RO Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flatreferencestable RO Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flatreferencestable RO Property</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getFlatReferencesTableSample_FlatreferencestableROProperty()
	 * @model
	 * @generated
	 */
	EList<TotalSample> getFlatreferencestableROProperty();

} // FlatReferencesTableSample

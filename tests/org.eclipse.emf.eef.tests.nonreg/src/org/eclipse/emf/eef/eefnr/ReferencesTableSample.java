/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferencesTableSample.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>References Table Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.ReferencesTableSample#getReferencestableRequiredProperty <em>Referencestable Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.ReferencesTableSample#getReferencestableOptionalProperty <em>Referencestable Optional Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getReferencesTableSample()
 * @model
 * @generated
 */
public interface ReferencesTableSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Referencestable Required Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencestable Required Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencestable Required Property</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getReferencesTableSample_ReferencestableRequiredProperty()
	 * @model required="true"
	 * @generated
	 */
	EList<TotalSample> getReferencestableRequiredProperty();

	/**
	 * Returns the value of the '<em><b>Referencestable Optional Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referencestable Optional Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referencestable Optional Property</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getReferencesTableSample_ReferencestableOptionalProperty()
	 * @model
	 * @generated
	 */
	EList<TotalSample> getReferencestableOptionalProperty();

} // ReferencesTableSample

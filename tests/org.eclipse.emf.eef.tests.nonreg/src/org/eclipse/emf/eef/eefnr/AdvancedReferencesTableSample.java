/**
 * <copyright>
 * </copyright>
 *
 * $Id: AdvancedReferencesTableSample.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advanced References Table Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample#getAdvancedreferencestableRequiredProperty <em>Advancedreferencestable Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.AdvancedReferencesTableSample#getAdvancedreferencestableOptionalProperty <em>Advancedreferencestable Optional Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getAdvancedReferencesTableSample()
 * @model
 * @generated
 */
public interface AdvancedReferencesTableSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Advancedreferencestable Required Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advancedreferencestable Required Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advancedreferencestable Required Property</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getAdvancedReferencesTableSample_AdvancedreferencestableRequiredProperty()
	 * @model required="true"
	 * @generated
	 */
	EList<TotalSample> getAdvancedreferencestableRequiredProperty();

	/**
	 * Returns the value of the '<em><b>Advancedreferencestable Optional Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advancedreferencestable Optional Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advancedreferencestable Optional Property</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getAdvancedReferencesTableSample_AdvancedreferencestableOptionalProperty()
	 * @model
	 * @generated
	 */
	EList<TotalSample> getAdvancedreferencestableOptionalProperty();

} // AdvancedReferencesTableSample

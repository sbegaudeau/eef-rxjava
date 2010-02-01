/**
 * <copyright>
 * </copyright>
 *
 * $Id: TableCompositionEditorSample.java,v 1.1 2010/02/01 13:00:44 nlepine Exp $
 */
package org.eclipse.emf.eef.eefnr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Composition Editor Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.TableCompositionEditorSample#getTablecompositionRequiredProperty <em>Tablecomposition Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.TableCompositionEditorSample#getTablecompositionOptionalProperty <em>Tablecomposition Optional Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getTableCompositionEditorSample()
 * @model
 * @generated
 */
public interface TableCompositionEditorSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Tablecomposition Required Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tablecomposition Required Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tablecomposition Required Property</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getTableCompositionEditorSample_TablecompositionRequiredProperty()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TotalSample> getTablecompositionRequiredProperty();

	/**
	 * Returns the value of the '<em><b>Tablecomposition Optional Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tablecomposition Optional Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tablecomposition Optional Property</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getTableCompositionEditorSample_TablecompositionOptionalProperty()
	 * @model containment="true"
	 * @generated
	 */
	EList<TotalSample> getTablecompositionOptionalProperty();

} // TableCompositionEditorSample

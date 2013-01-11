/**
 * <copyright>
 * </copyright>
 *
 * $Id: AdvancedTableCompositionEditorSample.java,v 1.2 2010/06/03 13:49:36 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Advanced Table Composition Editor Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample#getAdvancedtablecompositionRequiredProperty <em>Advancedtablecomposition Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample#getAdvancedtablecompositionOptionalProperty <em>Advancedtablecomposition Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.AdvancedTableCompositionEditorSample#getAdvancedtablecompositionROProperty <em>Advancedtablecomposition RO Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getAdvancedTableCompositionEditorSample()
 * @model
 * @generated
 */
public interface AdvancedTableCompositionEditorSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Advancedtablecomposition Required Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.Sample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advancedtablecomposition Required Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advancedtablecomposition Required Property</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getAdvancedTableCompositionEditorSample_AdvancedtablecompositionRequiredProperty()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Sample> getAdvancedtablecompositionRequiredProperty();

	/**
	 * Returns the value of the '<em><b>Advancedtablecomposition Optional Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.Sample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advancedtablecomposition Optional Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advancedtablecomposition Optional Property</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getAdvancedTableCompositionEditorSample_AdvancedtablecompositionOptionalProperty()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sample> getAdvancedtablecompositionOptionalProperty();

	/**
	 * Returns the value of the '<em><b>Advancedtablecomposition RO Property</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.Sample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Advancedtablecomposition RO Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Advancedtablecomposition RO Property</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getAdvancedTableCompositionEditorSample_AdvancedtablecompositionROProperty()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sample> getAdvancedtablecompositionROProperty();

} // AdvancedTableCompositionEditorSample

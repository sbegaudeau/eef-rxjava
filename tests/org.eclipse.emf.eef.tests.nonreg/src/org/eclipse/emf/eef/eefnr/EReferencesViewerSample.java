/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.eefnr;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EReferences Viewer Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.EReferencesViewerSample#getEreferencesviewerRequiredProperty <em>Ereferencesviewer Required Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.EReferencesViewerSample#getEreferencesviewerOptionalProperty <em>Ereferencesviewer Optional Property</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.EReferencesViewerSample#getEreferencesviewerROProperty <em>Ereferencesviewer RO Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getEReferencesViewerSample()
 * @model
 * @generated
 */
public interface EReferencesViewerSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Ereferencesviewer Required Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ereferencesviewer Required Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ereferencesviewer Required Property</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getEReferencesViewerSample_EreferencesviewerRequiredProperty()
	 * @model required="true"
	 * @generated
	 */
	EList<TotalSample> getEreferencesviewerRequiredProperty();

	/**
	 * Returns the value of the '<em><b>Ereferencesviewer Optional Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ereferencesviewer Optional Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ereferencesviewer Optional Property</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getEReferencesViewerSample_EreferencesviewerOptionalProperty()
	 * @model
	 * @generated
	 */
	EList<TotalSample> getEreferencesviewerOptionalProperty();

	/**
	 * Returns the value of the '<em><b>Ereferencesviewer RO Property</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.TotalSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ereferencesviewer RO Property</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ereferencesviewer RO Property</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnr.EefnrPackage#getEReferencesViewerSample_EreferencesviewerROProperty()
	 * @model
	 * @generated
	 */
	EList<TotalSample> getEreferencesviewerROProperty();

} // EReferencesViewerSample

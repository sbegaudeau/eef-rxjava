/**
 * <copyright>
 * </copyright>
 *
 * $Id: FlatReferenceExtendedEditorSample.java,v 1.1 2010/04/15 12:48:58 glefur Exp $
 */
package org.eclipse.emf.eef.eefnrext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.eef.eefnr.AbstractSample;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flat Reference Extended Editor Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnrext.FlatReferenceExtendedEditorSample#getFlatReferenceEditorSample <em>Flat Reference Editor Sample</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnrext.FlatReferenceExtendedEditorSample#getDemo <em>Demo</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnrext.FlatReferenceExtendedEditorSample#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnrext.EefnrextPackage#getFlatReferenceExtendedEditorSample()
 * @model
 * @generated
 */
public interface FlatReferenceExtendedEditorSample extends CheckBoxExtendedEditorSample {

	/**
	 * Returns the value of the '<em><b>Flat Reference Editor Sample</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.AbstractSample}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Flat Reference Editor Sample</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Flat Reference Editor Sample</em>' reference list.
	 * @see org.eclipse.emf.eef.eefnrext.EefnrextPackage#getFlatReferenceExtendedEditorSample_FlatReferenceEditorSample()
	 * @model
	 * @generated
	 */
	EList<AbstractSample> getFlatReferenceEditorSample();

	/**
	 * Returns the value of the '<em><b>Demo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Demo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Demo</em>' attribute.
	 * @see #setDemo(String)
	 * @see org.eclipse.emf.eef.eefnrext.EefnrextPackage#getFlatReferenceExtendedEditorSample_Demo()
	 * @model required="true"
	 * @generated
	 */
	String getDemo();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnrext.FlatReferenceExtendedEditorSample#getDemo <em>Demo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Demo</em>' attribute.
	 * @see #getDemo()
	 * @generated
	 */
	void setDemo(String value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see org.eclipse.emf.eef.eefnrext.EefnrextPackage#getFlatReferenceExtendedEditorSample_Size()
	 * @model
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnrext.FlatReferenceExtendedEditorSample#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);
} // FlatReferenceExtendedEditorSample

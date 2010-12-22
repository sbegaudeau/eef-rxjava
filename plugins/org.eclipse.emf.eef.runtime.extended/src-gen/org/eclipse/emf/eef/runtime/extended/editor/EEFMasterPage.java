/**
 * <copyright>
 * </copyright>
 *
 * $Id: EEFMasterPage.java,v 1.1 2010/12/22 14:23:48 glefur Exp $
 */
package org.eclipse.emf.eef.runtime.extended.editor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>EEF Master Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.runtime.extended.editor.EEFMasterPage#isOrientable <em>Orientable</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.runtime.extended.editor.EEFMasterPage#isShowValidatePage <em>Show Validate Page</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.runtime.extended.editor.EditorPackage#getEEFMasterPage()
 * @model
 * @generated
 */
public interface EEFMasterPage extends MasterDetailsPage {

	/**
	 * Returns the value of the '<em><b>Orientable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orientable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orientable</em>' attribute.
	 * @see #setOrientable(boolean)
	 * @see org.eclipse.emf.eef.runtime.extended.editor.EditorPackage#getEEFMasterPage_Orientable()
	 * @model
	 * @generated
	 */
	boolean isOrientable();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.runtime.extended.editor.EEFMasterPage#isOrientable <em>Orientable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Orientable</em>' attribute.
	 * @see #isOrientable()
	 * @generated
	 */
	void setOrientable(boolean value);

	/**
	 * Returns the value of the '<em><b>Show Validate Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Show Validate Page</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Show Validate Page</em>' attribute.
	 * @see #setShowValidatePage(boolean)
	 * @see org.eclipse.emf.eef.runtime.extended.editor.EditorPackage#getEEFMasterPage_ShowValidatePage()
	 * @model
	 * @generated
	 */
	boolean isShowValidatePage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.runtime.extended.editor.EEFMasterPage#isShowValidatePage <em>Show Validate Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Show Validate Page</em>' attribute.
	 * @see #isShowValidatePage()
	 * @generated
	 */
	void setShowValidatePage(boolean value);
} // EEFMasterPage

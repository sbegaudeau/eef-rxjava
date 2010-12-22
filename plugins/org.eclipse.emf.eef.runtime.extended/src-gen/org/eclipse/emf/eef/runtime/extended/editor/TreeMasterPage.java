/**
 * <copyright>
 * </copyright>
 *
 * $Id: TreeMasterPage.java,v 1.1 2010/12/22 14:23:48 glefur Exp $
 */
package org.eclipse.emf.eef.runtime.extended.editor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Master Page</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.runtime.extended.editor.TreeMasterPage#isToolbarVisible <em>Toolbar Visible</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.runtime.extended.editor.EditorPackage#getTreeMasterPage()
 * @model
 * @generated
 */
public interface TreeMasterPage extends MasterDetailsPage {

	/**
	 * Returns the value of the '<em><b>Toolbar Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Toolbar Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Toolbar Visible</em>' attribute.
	 * @see #setToolbarVisible(boolean)
	 * @see org.eclipse.emf.eef.runtime.extended.editor.EditorPackage#getTreeMasterPage_ToolbarVisible()
	 * @model
	 * @generated
	 */
	boolean isToolbarVisible();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.runtime.extended.editor.TreeMasterPage#isToolbarVisible <em>Toolbar Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Toolbar Visible</em>' attribute.
	 * @see #isToolbarVisible()
	 * @generated
	 */
	void setToolbarVisible(boolean value);
} // TreeMasterPage

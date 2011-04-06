/**
 * <copyright>
 * </copyright>
 *
 * $Id: OpenEEFEditor.java,v 1.1 2011/04/06 13:07:28 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot.EEFActions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open EEF Editor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.OpenEEFEditor#getEditorName <em>Editor Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getOpenEEFEditor()
 * @model
 * @generated
 */
public interface OpenEEFEditor extends EEFAction {
	/**
	 * Returns the value of the '<em><b>Editor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editor Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editor Name</em>' attribute.
	 * @see #setEditorName(String)
	 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getOpenEEFEditor_EditorName()
	 * @model
	 * @generated
	 */
	String getEditorName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.EEFActions.OpenEEFEditor#getEditorName <em>Editor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Editor Name</em>' attribute.
	 * @see #getEditorName()
	 * @generated
	 */
	void setEditorName(String value);

} // OpenEEFEditor

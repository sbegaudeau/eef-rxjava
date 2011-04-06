/**
 * <copyright>
 * </copyright>
 *
 * $Id: SetReference.java,v 1.1 2011/04/06 13:07:28 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot.EEFActions;

import org.eclipse.emf.eef.extended.editor.ReferenceableObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.SetReference#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getSetReference()
 * @model
 * @generated
 */
public interface SetReference extends EditAction {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(ReferenceableObject)
	 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getSetReference_Value()
	 * @model
	 * @generated
	 */
	ReferenceableObject getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.EEFActions.SetReference#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(ReferenceableObject value);

} // SetReference

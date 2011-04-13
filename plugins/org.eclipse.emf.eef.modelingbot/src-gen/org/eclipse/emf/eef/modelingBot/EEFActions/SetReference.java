/**
 * <copyright>
 * </copyright>
 *
 * $Id: SetReference.java,v 1.2 2011/04/13 13:50:10 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot.EEFActions;

import org.eclipse.emf.ecore.EStructuralFeature;
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
 *   <li>{@link org.eclipse.emf.eef.modelingBot.EEFActions.SetReference#getEContainingFeature <em>EContaining Feature</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>EContaining Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EContaining Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EContaining Feature</em>' reference.
	 * @see #setEContainingFeature(EStructuralFeature)
	 * @see org.eclipse.emf.eef.modelingBot.EEFActions.EEFActionsPackage#getSetReference_EContainingFeature()
	 * @model
	 * @generated
	 */
	EStructuralFeature getEContainingFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.modelingBot.EEFActions.SetReference#getEContainingFeature <em>EContaining Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EContaining Feature</em>' reference.
	 * @see #getEContainingFeature()
	 * @generated
	 */
	void setEContainingFeature(EStructuralFeature value);

} // SetReference

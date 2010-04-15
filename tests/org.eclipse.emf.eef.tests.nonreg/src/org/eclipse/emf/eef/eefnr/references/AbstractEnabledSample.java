/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractEnabledSample.java,v 1.1 2010/04/15 12:48:58 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.references;

import org.eclipse.emf.eef.eefnr.AbstractSample;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Enabled Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.references.AbstractEnabledSample#isEnabled <em>Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.references.ReferencesPackage#getAbstractEnabledSample()
 * @model abstract="true"
 * @generated
 */
public interface AbstractEnabledSample extends AbstractSample {
	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enabled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.eclipse.emf.eef.eefnr.references.ReferencesPackage#getAbstractEnabledSample_Enabled()
	 * @model
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.references.AbstractEnabledSample#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

} // AbstractEnabledSample

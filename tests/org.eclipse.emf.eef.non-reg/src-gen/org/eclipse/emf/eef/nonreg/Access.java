/**
 * <copyright>
 * </copyright>
 *
 * $Id: Access.java,v 1.1 2009/05/05 10:36:44 sbouchet Exp $
 */
package org.eclipse.emf.eef.nonreg;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.nonreg.Access#getSiteAcceded <em>Site Acceded</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.nonreg.Access#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.nonreg.NonregPackage#getAccess()
 * @model
 * @generated
 */
public interface Access extends EObject {
	/**
	 * Returns the value of the '<em><b>Site Acceded</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Site Acceded</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Site Acceded</em>' reference.
	 * @see #setSiteAcceded(Site)
	 * @see org.eclipse.emf.eef.nonreg.NonregPackage#getAccess_SiteAcceded()
	 * @model required="true"
	 * @generated
	 */
	Site getSiteAcceded();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.nonreg.Access#getSiteAcceded <em>Site Acceded</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Site Acceded</em>' reference.
	 * @see #getSiteAcceded()
	 * @generated
	 */
	void setSiteAcceded(Site value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #setPeriod(double)
	 * @see org.eclipse.emf.eef.nonreg.NonregPackage#getAccess_Period()
	 * @model
	 * @generated
	 */
	double getPeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.nonreg.Access#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(double value);

} // Access

/**
 * <copyright>
 * </copyright>
 *
 * $Id: StrictTypingFilter.java,v 1.1 2011/01/31 13:16:32 glefur Exp $
 */
package org.eclipse.emf.eef.mapping.filters;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Strict Typing Filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.mapping.filters.StrictTypingFilter#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.mapping.filters.FiltersPackage#getStrictTypingFilter()
 * @model
 * @generated
 */
public interface StrictTypingFilter extends BusinessFilter {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClassifier)
	 * @see org.eclipse.emf.eef.mapping.filters.FiltersPackage#getStrictTypingFilter_Type()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.mapping.filters.StrictTypingFilter#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClassifier value);

} // StrictTypingFilter

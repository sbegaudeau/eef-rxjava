/**
 * <copyright>
 * </copyright>
 *
 * $Id: DocumentedElement.java,v 1.1 2009/05/05 10:14:50 sbouchet Exp $
 */
package org.eclipse.emf.eef.ab.abstractnonreg;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Documented Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.ab.abstractnonreg.DocumentedElement#getDocumentation <em>Documentation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.ab.abstractnonreg.AbstractnonregPackage#getDocumentedElement()
 * @model
 * @generated
 */
public interface DocumentedElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Documentation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation</em>' attribute.
	 * @see #setDocumentation(String)
	 * @see org.eclipse.emf.eef.ab.abstractnonreg.AbstractnonregPackage#getDocumentedElement_Documentation()
	 * @model required="true"
	 * @generated
	 */
	String getDocumentation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.ab.abstractnonreg.DocumentedElement#getDocumentation <em>Documentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' attribute.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(String value);

} // DocumentedElement

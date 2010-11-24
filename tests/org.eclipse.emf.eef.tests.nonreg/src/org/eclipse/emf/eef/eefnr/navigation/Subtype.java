/**
 * <copyright>
 * </copyright>
 *
 * $Id: Subtype.java,v 1.1 2010/11/24 21:50:53 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.navigation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subtype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.Subtype#isSpecialisedElement <em>Specialised Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getSubtype()
 * @model
 * @generated
 */
public interface Subtype extends Owner {
	/**
	 * Returns the value of the '<em><b>Specialised Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialised Element</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialised Element</em>' attribute.
	 * @see #setSpecialisedElement(boolean)
	 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getSubtype_SpecialisedElement()
	 * @model
	 * @generated
	 */
	boolean isSpecialisedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.navigation.Subtype#isSpecialisedElement <em>Specialised Element</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specialised Element</em>' attribute.
	 * @see #isSpecialisedElement()
	 * @generated
	 */
	void setSpecialisedElement(boolean value);

} // Subtype

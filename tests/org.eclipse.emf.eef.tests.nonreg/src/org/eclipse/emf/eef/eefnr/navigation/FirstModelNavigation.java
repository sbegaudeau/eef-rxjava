/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.eefnr.navigation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.eef.eefnr.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>First Model Navigation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation#getSecondModelNavigation <em>Second Model Navigation</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation#getSeveralSecondModelNavigation <em>Several Second Model Navigation</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation#isFilter1 <em>Filter1</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation#isFilter2 <em>Filter2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getFirstModelNavigation()
 * @model
 * @generated
 */
public interface FirstModelNavigation extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Second Model Navigation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Model Navigation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Model Navigation</em>' containment reference.
	 * @see #setSecondModelNavigation(SecondModelNavigation)
	 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getFirstModelNavigation_SecondModelNavigation()
	 * @model containment="true"
	 * @generated
	 */
	SecondModelNavigation getSecondModelNavigation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation#getSecondModelNavigation <em>Second Model Navigation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Model Navigation</em>' containment reference.
	 * @see #getSecondModelNavigation()
	 * @generated
	 */
	void setSecondModelNavigation(SecondModelNavigation value);

	/**
	 * Returns the value of the '<em><b>Several Second Model Navigation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.navigation.SecondModelNavigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Several Second Model Navigation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Several Second Model Navigation</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getFirstModelNavigation_SeveralSecondModelNavigation()
	 * @model containment="true"
	 * @generated
	 */
	EList<SecondModelNavigation> getSeveralSecondModelNavigation();

	/**
	 * Returns the value of the '<em><b>Filter1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter1</em>' attribute.
	 * @see #setFilter1(boolean)
	 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getFirstModelNavigation_Filter1()
	 * @model
	 * @generated
	 */
	boolean isFilter1();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation#isFilter1 <em>Filter1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter1</em>' attribute.
	 * @see #isFilter1()
	 * @generated
	 */
	void setFilter1(boolean value);

	/**
	 * Returns the value of the '<em><b>Filter2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter2</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter2</em>' attribute.
	 * @see #setFilter2(boolean)
	 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getFirstModelNavigation_Filter2()
	 * @model
	 * @generated
	 */
	boolean isFilter2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation#isFilter2 <em>Filter2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter2</em>' attribute.
	 * @see #isFilter2()
	 * @generated
	 */
	void setFilter2(boolean value);

} // FirstModelNavigation

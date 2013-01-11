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
 * A representation of the model object '<em><b>Smart Model Navigation Sample</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample#getFirstModelNavigation <em>First Model Navigation</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample#getSeveralFirstModelNavigation <em>Several First Model Navigation</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample#getFirstModelNavigation2 <em>First Model Navigation2</em>}</li>
 *   <li>{@link org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample#getSeveralFirstModelNavigation2 <em>Several First Model Navigation2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getSmartModelNavigationSample()
 * @model
 * @generated
 */
public interface SmartModelNavigationSample extends NamedElement {
	/**
	 * Returns the value of the '<em><b>First Model Navigation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Model Navigation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Model Navigation</em>' containment reference.
	 * @see #setFirstModelNavigation(FirstModelNavigation)
	 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getSmartModelNavigationSample_FirstModelNavigation()
	 * @model containment="true"
	 * @generated
	 */
	FirstModelNavigation getFirstModelNavigation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample#getFirstModelNavigation <em>First Model Navigation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Model Navigation</em>' containment reference.
	 * @see #getFirstModelNavigation()
	 * @generated
	 */
	void setFirstModelNavigation(FirstModelNavigation value);

	/**
	 * Returns the value of the '<em><b>Several First Model Navigation</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Several First Model Navigation</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Several First Model Navigation</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getSmartModelNavigationSample_SeveralFirstModelNavigation()
	 * @model containment="true"
	 * @generated
	 */
	EList<FirstModelNavigation> getSeveralFirstModelNavigation();

	/**
	 * Returns the value of the '<em><b>First Model Navigation2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Model Navigation2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Model Navigation2</em>' containment reference.
	 * @see #setFirstModelNavigation2(FirstModelNavigation)
	 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getSmartModelNavigationSample_FirstModelNavigation2()
	 * @model containment="true"
	 * @generated
	 */
	FirstModelNavigation getFirstModelNavigation2();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.eef.eefnr.navigation.SmartModelNavigationSample#getFirstModelNavigation2 <em>First Model Navigation2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Model Navigation2</em>' containment reference.
	 * @see #getFirstModelNavigation2()
	 * @generated
	 */
	void setFirstModelNavigation2(FirstModelNavigation value);

	/**
	 * Returns the value of the '<em><b>Several First Model Navigation2</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.eef.eefnr.navigation.FirstModelNavigation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Several First Model Navigation2</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Several First Model Navigation2</em>' containment reference list.
	 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage#getSmartModelNavigationSample_SeveralFirstModelNavigation2()
	 * @model containment="true"
	 * @generated
	 */
	EList<FirstModelNavigation> getSeveralFirstModelNavigation2();

} // SmartModelNavigationSample

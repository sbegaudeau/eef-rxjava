/**
 * <copyright>
 * </copyright>
 *
 * $Id: NavigationFactory.java,v 1.1 2010/04/16 08:00:57 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.navigation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.eefnr.navigation.NavigationPackage
 * @generated
 */
public interface NavigationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NavigationFactory eINSTANCE = org.eclipse.emf.eef.eefnr.navigation.impl.NavigationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Defered Flat Reference Table Editor Sample</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Defered Flat Reference Table Editor Sample</em>'.
	 * @generated
	 */
	DeferedFlatReferenceTableEditorSample createDeferedFlatReferenceTableEditorSample();

	/**
	 * Returns a new object of class '<em>Defered Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Defered Reference</em>'.
	 * @generated
	 */
	DeferedReference createDeferedReference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	NavigationPackage getNavigationPackage();

} //NavigationFactory

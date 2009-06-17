/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.nonreg.modelNavigation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.nonreg.modelNavigation.ModelNavigationPackage
 * @generated
 */
public interface ModelNavigationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelNavigationFactory eINSTANCE = org.eclipse.emf.eef.nonreg.modelNavigation.impl.ModelNavigationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source</em>'.
	 * @generated
	 */
	Source createSource();

	/**
	 * Returns a new object of class '<em>Real Cible</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Cible</em>'.
	 * @generated
	 */
	RealCible createRealCible();

	/**
	 * Returns a new object of class '<em>Concrete Cible</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Cible</em>'.
	 * @generated
	 */
	ConcreteCible createConcreteCible();

	/**
	 * Returns a new object of class '<em>model Nav Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>model Nav Root</em>'.
	 * @generated
	 */
	modelNavRoot createmodelNavRoot();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelNavigationPackage getModelNavigationPackage();

} //ModelNavigationFactory

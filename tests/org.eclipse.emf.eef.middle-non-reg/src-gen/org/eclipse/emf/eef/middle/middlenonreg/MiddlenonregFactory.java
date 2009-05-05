/**
 * <copyright>
 * </copyright>
 *
 * $Id: MiddlenonregFactory.java,v 1.1 2009/05/05 10:26:12 sbouchet Exp $
 */
package org.eclipse.emf.eef.middle.middlenonreg;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.middle.middlenonreg.MiddlenonregPackage
 * @generated
 */
public interface MiddlenonregFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MiddlenonregFactory eINSTANCE = org.eclipse.emf.eef.middle.middlenonreg.impl.MiddlenonregFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Element</em>'.
	 * @generated
	 */
	NamedElement createNamedElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MiddlenonregPackage getMiddlenonregPackage();

} //MiddlenonregFactory

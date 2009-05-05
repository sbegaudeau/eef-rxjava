/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbstractnonregFactory.java,v 1.1 2009/05/05 10:14:50 sbouchet Exp $
 */
package org.eclipse.emf.eef.ab.abstractnonreg;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.ab.abstractnonreg.AbstractnonregPackage
 * @generated
 */
public interface AbstractnonregFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AbstractnonregFactory eINSTANCE = org.eclipse.emf.eef.ab.abstractnonreg.impl.AbstractnonregFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Documented Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Documented Element</em>'.
	 * @generated
	 */
	DocumentedElement createDocumentedElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AbstractnonregPackage getAbstractnonregPackage();

} //AbstractnonregFactory

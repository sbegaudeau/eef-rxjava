/**
 * <copyright>
 * </copyright>
 *
 * $Id: FiltersFactory.java,v 1.1 2011/02/01 09:54:39 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.filters;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.eefnr.filters.FiltersPackage
 * @generated
 */
public interface FiltersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FiltersFactory eINSTANCE = org.eclipse.emf.eef.eefnr.filters.impl.FiltersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Concrete Reference Owner Sample</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Reference Owner Sample</em>'.
	 * @generated
	 */
	ConcreteReferenceOwnerSample createConcreteReferenceOwnerSample();

	/**
	 * Returns a new object of class '<em>Concrete Reference Target Sample1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Reference Target Sample1</em>'.
	 * @generated
	 */
	ConcreteReferenceTargetSample1 createConcreteReferenceTargetSample1();

	/**
	 * Returns a new object of class '<em>Concrete Reference Target Sample2</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Reference Target Sample2</em>'.
	 * @generated
	 */
	ConcreteReferenceTargetSample2 createConcreteReferenceTargetSample2();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FiltersPackage getFiltersPackage();

} //FiltersFactory

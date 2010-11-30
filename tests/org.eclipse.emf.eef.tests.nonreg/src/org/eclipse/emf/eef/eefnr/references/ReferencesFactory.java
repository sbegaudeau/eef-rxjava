/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReferencesFactory.java,v 1.2 2010/11/30 08:23:18 glefur Exp $
 */
package org.eclipse.emf.eef.eefnr.references;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.eefnr.references.ReferencesPackage
 * @generated
 */
public interface ReferencesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReferencesFactory eINSTANCE = org.eclipse.emf.eef.eefnr.references.impl.ReferencesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Reference Enabled Sample</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Enabled Sample</em>'.
	 * @generated
	 */
	ReferenceEnabledSample createReferenceEnabledSample();

	/**
	 * Returns a new object of class '<em>Tests</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tests</em>'.
	 * @generated
	 */
	Tests createTests();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ReferencesPackage getReferencesPackage();

} //ReferencesFactory

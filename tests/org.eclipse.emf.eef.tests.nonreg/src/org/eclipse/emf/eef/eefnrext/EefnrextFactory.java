/**
 * <copyright>
 * </copyright>
 *
 * $Id: EefnrextFactory.java,v 1.1 2010/04/15 12:48:58 glefur Exp $
 */
package org.eclipse.emf.eef.eefnrext;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.eefnrext.EefnrextPackage
 * @generated
 */
public interface EefnrextFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EefnrextFactory eINSTANCE = org.eclipse.emf.eef.eefnrext.impl.EefnrextFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Table Composition Target Extension Editor Sample</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Table Composition Target Extension Editor Sample</em>'.
	 * @generated
	 */
	TableCompositionTargetExtensionEditorSample createTableCompositionTargetExtensionEditorSample();

	/**
	 * Returns a new object of class '<em>Flat Reference Extended Editor Sample</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flat Reference Extended Editor Sample</em>'.
	 * @generated
	 */
	FlatReferenceExtendedEditorSample createFlatReferenceExtendedEditorSample();

	/**
	 * Returns a new object of class '<em>Check Box Extended Editor Sample</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check Box Extended Editor Sample</em>'.
	 * @generated
	 */
	CheckBoxExtendedEditorSample createCheckBoxExtendedEditorSample();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EefnrextPackage getEefnrextPackage();

} //EefnrextFactory

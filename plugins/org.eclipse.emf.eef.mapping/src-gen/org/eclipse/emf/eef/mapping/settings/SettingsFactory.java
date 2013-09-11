/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.emf.eef.mapping.settings;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.mapping.settings.SettingsPackage
 * @generated
 */
public interface SettingsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SettingsFactory eINSTANCE = org.eclipse.emf.eef.mapping.settings.impl.SettingsFactoryImpl
			.init();

	/**
	 * Returns a new object of class '<em>EReference Viewer Settings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>EReference Viewer Settings</em>'.
	 * @generated
	 */
	EReferenceViewerSettings createEReferenceViewerSettings();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SettingsPackage getSettingsPackage();

} //SettingsFactory

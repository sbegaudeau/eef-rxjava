/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelingBotFactory.java,v 1.1 2011/04/06 13:07:28 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.modelingBot.ModelingBotPackage
 * @generated
 */
public interface ModelingBotFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelingBotFactory eINSTANCE = org.eclipse.emf.eef.modelingBot.impl.ModelingBotFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Scenario</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scenario</em>'.
	 * @generated
	 */
	Scenario createScenario();

	/**
	 * Returns a new object of class '<em>Wizard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wizard</em>'.
	 * @generated
	 */
	Wizard createWizard();

	/**
	 * Returns a new object of class '<em>Modeling Bot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modeling Bot</em>'.
	 * @generated
	 */
	ModelingBot createModelingBot();

	/**
	 * Returns a new object of class '<em>Details Page</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Details Page</em>'.
	 * @generated
	 */
	DetailsPage createDetailsPage();

	/**
	 * Returns a new object of class '<em>Properties View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Properties View</em>'.
	 * @generated
	 */
	PropertiesView createPropertiesView();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ModelingBotPackage getModelingBotPackage();

} //ModelingBotFactory

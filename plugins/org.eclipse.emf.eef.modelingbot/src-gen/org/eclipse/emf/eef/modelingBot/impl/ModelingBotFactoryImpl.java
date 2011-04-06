/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelingBotFactoryImpl.java,v 1.1 2011/04/06 13:07:28 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.eef.modelingBot.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelingBotFactoryImpl extends EFactoryImpl implements ModelingBotFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelingBotFactory init() {
		try {
			ModelingBotFactory theModelingBotFactory = (ModelingBotFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/emf/eef/mbot/1.0.0"); 
			if (theModelingBotFactory != null) {
				return theModelingBotFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelingBotFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelingBotFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ModelingBotPackage.SCENARIO: return createScenario();
			case ModelingBotPackage.WIZARD: return createWizard();
			case ModelingBotPackage.MODELING_BOT: return createModelingBot();
			case ModelingBotPackage.DETAILS_PAGE: return createDetailsPage();
			case ModelingBotPackage.PROPERTIES_VIEW: return createPropertiesView();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scenario createScenario() {
		ScenarioImpl scenario = new ScenarioImpl();
		return scenario;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Wizard createWizard() {
		WizardImpl wizard = new WizardImpl();
		return wizard;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelingBot createModelingBot() {
		ModelingBotImpl modelingBot = new ModelingBotImpl();
		return modelingBot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DetailsPage createDetailsPage() {
		DetailsPageImpl detailsPage = new DetailsPageImpl();
		return detailsPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertiesView createPropertiesView() {
		PropertiesViewImpl propertiesView = new PropertiesViewImpl();
		return propertiesView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelingBotPackage getModelingBotPackage() {
		return (ModelingBotPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelingBotPackage getPackage() {
		return ModelingBotPackage.eINSTANCE;
	}

} //ModelingBotFactoryImpl

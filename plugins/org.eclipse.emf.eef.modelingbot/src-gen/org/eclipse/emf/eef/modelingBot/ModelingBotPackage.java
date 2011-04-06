/**
 * <copyright>
 * </copyright>
 *
 * $Id: ModelingBotPackage.java,v 1.1 2011/04/06 13:07:27 nlepine Exp $
 */
package org.eclipse.emf.eef.modelingBot;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.modelingBot.ModelingBotFactory
 * @model kind="package"
 * @generated
 */
public interface ModelingBotPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "modelingBot";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/eef/mbot/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "eef-mbot";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelingBotPackage eINSTANCE = org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.impl.DocumentedElementImpl <em>Documented Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.impl.DocumentedElementImpl
	 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getDocumentedElement()
	 * @generated
	 */
	int DOCUMENTED_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTED_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTED_ELEMENT__DOCUMENTATION = 1;

	/**
	 * The number of structural features of the '<em>Documented Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENTED_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.impl.SequenceImpl
	 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__NAME = DOCUMENTED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__DOCUMENTATION = DOCUMENTED_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__ACTIONS = DOCUMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__SEQUENCES = DOCUMENTED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Processings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__PROCESSINGS = DOCUMENTED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = DOCUMENTED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.impl.ScenarioImpl <em>Scenario</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.impl.ScenarioImpl
	 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getScenario()
	 * @generated
	 */
	int SCENARIO = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__NAME = SEQUENCE__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__DOCUMENTATION = SEQUENCE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__ACTIONS = SEQUENCE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__SEQUENCES = SEQUENCE__SEQUENCES;

	/**
	 * The feature id for the '<em><b>Processings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO__PROCESSINGS = SEQUENCE__PROCESSINGS;

	/**
	 * The number of structural features of the '<em>Scenario</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENARIO_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.impl.ActionImpl
	 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = DOCUMENTED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__DOCUMENTATION = DOCUMENTED_ELEMENT__DOCUMENTATION;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = DOCUMENTED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.impl.WizardImpl <em>Wizard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.impl.WizardImpl
	 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getWizard()
	 * @generated
	 */
	int WIZARD = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__NAME = SEQUENCE__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__DOCUMENTATION = SEQUENCE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__ACTIONS = SEQUENCE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__SEQUENCES = SEQUENCE__SEQUENCES;

	/**
	 * The feature id for the '<em><b>Processings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD__PROCESSINGS = SEQUENCE__PROCESSINGS;

	/**
	 * The number of structural features of the '<em>Wizard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIZARD_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.impl.ModelingBotImpl <em>Modeling Bot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotImpl
	 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getModelingBot()
	 * @generated
	 */
	int MODELING_BOT = 5;

	/**
	 * The feature id for the '<em><b>Properties Edition Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODELING_BOT__PROPERTIES_EDITION_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODELING_BOT__SEQUENCES = 1;

	/**
	 * The number of structural features of the '<em>Modeling Bot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODELING_BOT_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.impl.DetailsPageImpl <em>Details Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.impl.DetailsPageImpl
	 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getDetailsPage()
	 * @generated
	 */
	int DETAILS_PAGE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_PAGE__NAME = SEQUENCE__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_PAGE__DOCUMENTATION = SEQUENCE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_PAGE__ACTIONS = SEQUENCE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_PAGE__SEQUENCES = SEQUENCE__SEQUENCES;

	/**
	 * The feature id for the '<em><b>Processings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_PAGE__PROCESSINGS = SEQUENCE__PROCESSINGS;

	/**
	 * The number of structural features of the '<em>Details Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DETAILS_PAGE_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.impl.PropertiesViewImpl <em>Properties View</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.impl.PropertiesViewImpl
	 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getPropertiesView()
	 * @generated
	 */
	int PROPERTIES_VIEW = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_VIEW__NAME = SEQUENCE__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_VIEW__DOCUMENTATION = SEQUENCE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_VIEW__ACTIONS = SEQUENCE__ACTIONS;

	/**
	 * The feature id for the '<em><b>Sequences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_VIEW__SEQUENCES = SEQUENCE__SEQUENCES;

	/**
	 * The feature id for the '<em><b>Processings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_VIEW__PROCESSINGS = SEQUENCE__PROCESSINGS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_VIEW__ID = SEQUENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Properties View</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTIES_VIEW_FEATURE_COUNT = SEQUENCE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.eef.modelingBot.Processing <em>Processing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.eef.modelingBot.Processing
	 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getProcessing()
	 * @generated
	 */
	int PROCESSING = 8;

	/**
	 * The number of structural features of the '<em>Processing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.Scenario <em>Scenario</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scenario</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.Scenario
	 * @generated
	 */
	EClass getScenario();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.modelingBot.Sequence#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.Sequence#getActions()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Actions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.modelingBot.Sequence#getSequences <em>Sequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequences</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.Sequence#getSequences()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Sequences();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.modelingBot.Sequence#getProcessings <em>Processings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processings</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.Sequence#getProcessings()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Processings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.Wizard <em>Wizard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wizard</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.Wizard
	 * @generated
	 */
	EClass getWizard();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.DocumentedElement <em>Documented Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Documented Element</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.DocumentedElement
	 * @generated
	 */
	EClass getDocumentedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.DocumentedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.DocumentedElement#getName()
	 * @see #getDocumentedElement()
	 * @generated
	 */
	EAttribute getDocumentedElement_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.DocumentedElement#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Documentation</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.DocumentedElement#getDocumentation()
	 * @see #getDocumentedElement()
	 * @generated
	 */
	EAttribute getDocumentedElement_Documentation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.ModelingBot <em>Modeling Bot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Modeling Bot</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.ModelingBot
	 * @generated
	 */
	EClass getModelingBot();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.eef.modelingBot.ModelingBot#getPropertiesEditionContext <em>Properties Edition Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Properties Edition Context</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.ModelingBot#getPropertiesEditionContext()
	 * @see #getModelingBot()
	 * @generated
	 */
	EReference getModelingBot_PropertiesEditionContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.eef.modelingBot.ModelingBot#getSequences <em>Sequences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequences</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.ModelingBot#getSequences()
	 * @see #getModelingBot()
	 * @generated
	 */
	EReference getModelingBot_Sequences();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.DetailsPage <em>Details Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Details Page</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.DetailsPage
	 * @generated
	 */
	EClass getDetailsPage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.PropertiesView <em>Properties View</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Properties View</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.PropertiesView
	 * @generated
	 */
	EClass getPropertiesView();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.eef.modelingBot.PropertiesView#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.PropertiesView#getId()
	 * @see #getPropertiesView()
	 * @generated
	 */
	EAttribute getPropertiesView_Id();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.eef.modelingBot.Processing <em>Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing</em>'.
	 * @see org.eclipse.emf.eef.modelingBot.Processing
	 * @generated
	 */
	EClass getProcessing();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelingBotFactory getModelingBotFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.impl.ScenarioImpl <em>Scenario</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.impl.ScenarioImpl
		 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getScenario()
		 * @generated
		 */
		EClass SCENARIO = eINSTANCE.getScenario();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.impl.ActionImpl
		 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.impl.SequenceImpl
		 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__ACTIONS = eINSTANCE.getSequence_Actions();

		/**
		 * The meta object literal for the '<em><b>Sequences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__SEQUENCES = eINSTANCE.getSequence_Sequences();

		/**
		 * The meta object literal for the '<em><b>Processings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__PROCESSINGS = eINSTANCE.getSequence_Processings();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.impl.WizardImpl <em>Wizard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.impl.WizardImpl
		 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getWizard()
		 * @generated
		 */
		EClass WIZARD = eINSTANCE.getWizard();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.impl.DocumentedElementImpl <em>Documented Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.impl.DocumentedElementImpl
		 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getDocumentedElement()
		 * @generated
		 */
		EClass DOCUMENTED_ELEMENT = eINSTANCE.getDocumentedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTED_ELEMENT__NAME = eINSTANCE.getDocumentedElement_Name();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENTED_ELEMENT__DOCUMENTATION = eINSTANCE.getDocumentedElement_Documentation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.impl.ModelingBotImpl <em>Modeling Bot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotImpl
		 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getModelingBot()
		 * @generated
		 */
		EClass MODELING_BOT = eINSTANCE.getModelingBot();

		/**
		 * The meta object literal for the '<em><b>Properties Edition Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODELING_BOT__PROPERTIES_EDITION_CONTEXT = eINSTANCE.getModelingBot_PropertiesEditionContext();

		/**
		 * The meta object literal for the '<em><b>Sequences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODELING_BOT__SEQUENCES = eINSTANCE.getModelingBot_Sequences();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.impl.DetailsPageImpl <em>Details Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.impl.DetailsPageImpl
		 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getDetailsPage()
		 * @generated
		 */
		EClass DETAILS_PAGE = eINSTANCE.getDetailsPage();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.impl.PropertiesViewImpl <em>Properties View</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.impl.PropertiesViewImpl
		 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getPropertiesView()
		 * @generated
		 */
		EClass PROPERTIES_VIEW = eINSTANCE.getPropertiesView();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTIES_VIEW__ID = eINSTANCE.getPropertiesView_Id();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.eef.modelingBot.Processing <em>Processing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.eef.modelingBot.Processing
		 * @see org.eclipse.emf.eef.modelingBot.impl.ModelingBotPackageImpl#getProcessing()
		 * @generated
		 */
		EClass PROCESSING = eINSTANCE.getProcessing();

	}

} //ModelingBotPackage

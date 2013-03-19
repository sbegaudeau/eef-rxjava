/**
 */
package org.eclipse.emf.eef.modelingBot.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.eef.modelingBot.*;
import org.eclipse.emf.eef.modelingBot.Action;
import org.eclipse.emf.eef.modelingBot.DetailsPage;
import org.eclipse.emf.eef.modelingBot.DocumentedElement;
import org.eclipse.emf.eef.modelingBot.ModelingBot;
import org.eclipse.emf.eef.modelingBot.ModelingBotPackage;
import org.eclipse.emf.eef.modelingBot.Processing;
import org.eclipse.emf.eef.modelingBot.PropertiesView;
import org.eclipse.emf.eef.modelingBot.Scenario;
import org.eclipse.emf.eef.modelingBot.Sequence;
import org.eclipse.emf.eef.modelingBot.SequenceType;
import org.eclipse.emf.eef.modelingBot.Wizard;
import org.eclipse.emf.eef.modelingBot.validation.ModelingBotValidationUtils;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc -->
 * @see org.eclipse.emf.eef.modelingBot.ModelingBotPackage
 * @generated
 */
public class ModelingBotValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final ModelingBotValidator INSTANCE = new ModelingBotValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipse.emf.eef.modelingBot";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ModelingBotValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return ModelingBotPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		switch (classifierID) {
			case ModelingBotPackage.SCENARIO:
				return validateScenario((Scenario)value, diagnostics, context);
			case ModelingBotPackage.ACTION:
				return validateAction((Action)value, diagnostics, context);
			case ModelingBotPackage.SEQUENCE:
				return validateSequence((Sequence)value, diagnostics, context);
			case ModelingBotPackage.WIZARD:
				return validateWizard((Wizard)value, diagnostics, context);
			case ModelingBotPackage.DOCUMENTED_ELEMENT:
				return validateDocumentedElement((DocumentedElement)value, diagnostics, context);
			case ModelingBotPackage.MODELING_BOT:
				return validateModelingBot((ModelingBot)value, diagnostics, context);
			case ModelingBotPackage.DETAILS_PAGE:
				return validateDetailsPage((DetailsPage)value, diagnostics, context);
			case ModelingBotPackage.PROPERTIES_VIEW:
				return validatePropertiesView((PropertiesView)value, diagnostics, context);
			case ModelingBotPackage.PROCESSING:
				return validateProcessing((Processing)value, diagnostics, context);
			case ModelingBotPackage.SEQUENCE_TYPE:
				return validateSequenceType((SequenceType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScenario(Scenario scenario, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(scenario, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(scenario, diagnostics, context);
		if (result || diagnostics != null) result &= validateScenario_JavaTestExistsForScenarioConstraint(scenario, diagnostics, context);
		return result;
	}

	/**
	 * Validates the JavaTestExistsForScenarioConstraint constraint of '<em>Scenario</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateScenario_JavaTestExistsForScenarioConstraint(Scenario scenario,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (diagnostics != null) {
			if (!ModelingBotValidationUtils.isAssociatedToTest(scenario)) {
				diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
						"_UI_GenericConstraint_diagnostic", new Object[] {"JavaTestExistsConstraint",
								getObjectLabel(scenario, context)
						}, new Object[] {scenario
						}, context));
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAction(Action action, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(action, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequence(Sequence sequence, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(sequence, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWizard(Wizard wizard, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(wizard, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDocumentedElement(DocumentedElement documentedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(documentedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModelingBot(ModelingBot modelingBot, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(modelingBot, diagnostics, context);
	}

	/**
	 * Validates the JavaTestExistsConstraint constraint of '<em>Modeling Bot</em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateModelingBot_JavaTestExistsConstraint(ModelingBot modelingBot,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (diagnostics != null) {
			diagnostics.add(createDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
					"_UI_GenericConstraint_diagnostic", new Object[] {"JavaTestExistsConstraint",
							getObjectLabel(modelingBot, context)
					}, new Object[] {modelingBot
					}, context));
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDetailsPage(DetailsPage detailsPage, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(detailsPage, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePropertiesView(PropertiesView propertiesView, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(propertiesView, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProcessing(Processing processing, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(processing, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSequenceType(SequenceType sequenceType, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} // ModelingBotValidator

/**
 */
package org.eclipse.sirius.expression.dsl.expressionDSL.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLFactory;
import org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage;
import org.eclipse.sirius.expression.dsl.expressionDSL.Parameter;
import org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass;
import org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription;
import org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage;
import org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionDSLPackageImpl extends EPackageImpl implements ExpressionDSLPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass siriusExpressionPackageEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass siriusExpressionClassEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass siriusVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass siriusExpressionDescriptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ExpressionDSLPackageImpl()
  {
    super(eNS_URI, ExpressionDSLFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link ExpressionDSLPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ExpressionDSLPackage init()
  {
    if (isInited) return (ExpressionDSLPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionDSLPackage.eNS_URI);

    // Obtain or create and register package
    ExpressionDSLPackageImpl theExpressionDSLPackage = (ExpressionDSLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ExpressionDSLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ExpressionDSLPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theExpressionDSLPackage.createPackageContents();

    // Initialize created meta-data
    theExpressionDSLPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theExpressionDSLPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ExpressionDSLPackage.eNS_URI, theExpressionDSLPackage);
    return theExpressionDSLPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSiriusExpressionPackage()
  {
    return siriusExpressionPackageEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSiriusExpressionPackage_EPackage()
  {
    return (EReference)siriusExpressionPackageEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSiriusExpressionPackage_ExpressionClasses()
  {
    return (EReference)siriusExpressionPackageEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSiriusExpressionClass()
  {
    return siriusExpressionClassEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSiriusExpressionClass_EClass()
  {
    return (EReference)siriusExpressionClassEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSiriusExpressionClass_Variables()
  {
    return (EReference)siriusExpressionClassEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSiriusExpressionClass_ExpressionDescriptions()
  {
    return (EReference)siriusExpressionClassEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSiriusVariable()
  {
    return siriusVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSiriusVariable_Documentation()
  {
    return (EAttribute)siriusVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSiriusVariable_Name()
  {
    return (EAttribute)siriusVariableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSiriusVariable_EType()
  {
    return (EReference)siriusVariableEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSiriusExpressionDescription()
  {
    return siriusExpressionDescriptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSiriusExpressionDescription_Expression()
  {
    return (EReference)siriusExpressionDescriptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSiriusExpressionDescription_Parameters()
  {
    return (EReference)siriusExpressionDescriptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSiriusExpressionDescription_Type()
  {
    return (EReference)siriusExpressionDescriptionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSiriusExpressionDescription_LowerBound()
  {
    return (EAttribute)siriusExpressionDescriptionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSiriusExpressionDescription_UpperBound()
  {
    return (EAttribute)siriusExpressionDescriptionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSiriusExpressionDescription_ContextableElements()
  {
    return (EReference)siriusExpressionDescriptionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameter()
  {
    return parameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameter_Optional()
  {
    return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameter_Variable()
  {
    return (EReference)parameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionDSLFactory getExpressionDSLFactory()
  {
    return (ExpressionDSLFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    siriusExpressionPackageEClass = createEClass(SIRIUS_EXPRESSION_PACKAGE);
    createEReference(siriusExpressionPackageEClass, SIRIUS_EXPRESSION_PACKAGE__EPACKAGE);
    createEReference(siriusExpressionPackageEClass, SIRIUS_EXPRESSION_PACKAGE__EXPRESSION_CLASSES);

    siriusExpressionClassEClass = createEClass(SIRIUS_EXPRESSION_CLASS);
    createEReference(siriusExpressionClassEClass, SIRIUS_EXPRESSION_CLASS__ECLASS);
    createEReference(siriusExpressionClassEClass, SIRIUS_EXPRESSION_CLASS__VARIABLES);
    createEReference(siriusExpressionClassEClass, SIRIUS_EXPRESSION_CLASS__EXPRESSION_DESCRIPTIONS);

    siriusVariableEClass = createEClass(SIRIUS_VARIABLE);
    createEAttribute(siriusVariableEClass, SIRIUS_VARIABLE__DOCUMENTATION);
    createEAttribute(siriusVariableEClass, SIRIUS_VARIABLE__NAME);
    createEReference(siriusVariableEClass, SIRIUS_VARIABLE__ETYPE);

    siriusExpressionDescriptionEClass = createEClass(SIRIUS_EXPRESSION_DESCRIPTION);
    createEReference(siriusExpressionDescriptionEClass, SIRIUS_EXPRESSION_DESCRIPTION__EXPRESSION);
    createEReference(siriusExpressionDescriptionEClass, SIRIUS_EXPRESSION_DESCRIPTION__PARAMETERS);
    createEReference(siriusExpressionDescriptionEClass, SIRIUS_EXPRESSION_DESCRIPTION__TYPE);
    createEAttribute(siriusExpressionDescriptionEClass, SIRIUS_EXPRESSION_DESCRIPTION__LOWER_BOUND);
    createEAttribute(siriusExpressionDescriptionEClass, SIRIUS_EXPRESSION_DESCRIPTION__UPPER_BOUND);
    createEReference(siriusExpressionDescriptionEClass, SIRIUS_EXPRESSION_DESCRIPTION__CONTEXTABLE_ELEMENTS);

    parameterEClass = createEClass(PARAMETER);
    createEAttribute(parameterEClass, PARAMETER__OPTIONAL);
    createEReference(parameterEClass, PARAMETER__VARIABLE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(siriusExpressionPackageEClass, SiriusExpressionPackage.class, "SiriusExpressionPackage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSiriusExpressionPackage_EPackage(), theEcorePackage.getEPackage(), null, "ePackage", null, 0, 1, SiriusExpressionPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSiriusExpressionPackage_ExpressionClasses(), this.getSiriusExpressionClass(), null, "expressionClasses", null, 0, -1, SiriusExpressionPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(siriusExpressionClassEClass, SiriusExpressionClass.class, "SiriusExpressionClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSiriusExpressionClass_EClass(), theEcorePackage.getEClass(), null, "eClass", null, 0, 1, SiriusExpressionClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSiriusExpressionClass_Variables(), this.getSiriusVariable(), null, "variables", null, 0, -1, SiriusExpressionClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSiriusExpressionClass_ExpressionDescriptions(), this.getSiriusExpressionDescription(), null, "expressionDescriptions", null, 0, -1, SiriusExpressionClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(siriusVariableEClass, SiriusVariable.class, "SiriusVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSiriusVariable_Documentation(), theEcorePackage.getEString(), "documentation", null, 0, 1, SiriusVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSiriusVariable_Name(), theEcorePackage.getEString(), "name", null, 0, 1, SiriusVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSiriusVariable_EType(), theEcorePackage.getEClassifier(), null, "eType", null, 0, 1, SiriusVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(siriusExpressionDescriptionEClass, SiriusExpressionDescription.class, "SiriusExpressionDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSiriusExpressionDescription_Expression(), theEcorePackage.getEAttribute(), null, "expression", null, 0, 1, SiriusExpressionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSiriusExpressionDescription_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, SiriusExpressionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSiriusExpressionDescription_Type(), theEcorePackage.getEClassifier(), null, "type", null, 0, 1, SiriusExpressionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSiriusExpressionDescription_LowerBound(), theEcorePackage.getEInt(), "lowerBound", null, 0, 1, SiriusExpressionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSiriusExpressionDescription_UpperBound(), theEcorePackage.getEInt(), "upperBound", null, 0, 1, SiriusExpressionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSiriusExpressionDescription_ContextableElements(), theEcorePackage.getEClass(), null, "contextableElements", null, 0, -1, SiriusExpressionDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParameter_Optional(), theEcorePackage.getEBoolean(), "optional", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParameter_Variable(), this.getSiriusVariable(), null, "variable", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ExpressionDSLPackageImpl

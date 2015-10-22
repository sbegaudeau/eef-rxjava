/**
 */
package org.eclipse.sirius.expression.dsl.expressionDSL;

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
 * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionDSLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "expressionDSL";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/sirius/expression/dsl/ExpressionDSL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "expressionDSL";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExpressionDSLPackage eINSTANCE = org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionPackageImpl <em>Sirius Expression Package</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionPackageImpl
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl#getSiriusExpressionPackage()
   * @generated
   */
  int SIRIUS_EXPRESSION_PACKAGE = 0;

  /**
   * The feature id for the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_PACKAGE__EPACKAGE = 0;

  /**
   * The feature id for the '<em><b>Expression Classes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_PACKAGE__EXPRESSION_CLASSES = 1;

  /**
   * The number of structural features of the '<em>Sirius Expression Package</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_PACKAGE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionClassImpl <em>Sirius Expression Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionClassImpl
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl#getSiriusExpressionClass()
   * @generated
   */
  int SIRIUS_EXPRESSION_CLASS = 1;

  /**
   * The feature id for the '<em><b>EClass</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_CLASS__ECLASS = 0;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_CLASS__VARIABLES = 1;

  /**
   * The feature id for the '<em><b>Expression Descriptions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_CLASS__EXPRESSION_DESCRIPTIONS = 2;

  /**
   * The number of structural features of the '<em>Sirius Expression Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_CLASS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusVariableImpl <em>Sirius Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusVariableImpl
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl#getSiriusVariable()
   * @generated
   */
  int SIRIUS_VARIABLE = 2;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_VARIABLE__DOCUMENTATION = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_VARIABLE__NAME = 1;

  /**
   * The feature id for the '<em><b>EType</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_VARIABLE__ETYPE = 2;

  /**
   * The number of structural features of the '<em>Sirius Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_VARIABLE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionDescriptionImpl <em>Sirius Expression Description</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionDescriptionImpl
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl#getSiriusExpressionDescription()
   * @generated
   */
  int SIRIUS_EXPRESSION_DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Expression</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_DESCRIPTION__EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_DESCRIPTION__PARAMETERS = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_DESCRIPTION__TYPE = 2;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_DESCRIPTION__LOWER_BOUND = 3;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_DESCRIPTION__UPPER_BOUND = 4;

  /**
   * The feature id for the '<em><b>Contextable Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_DESCRIPTION__CONTEXTABLE_ELEMENTS = 5;

  /**
   * The number of structural features of the '<em>Sirius Expression Description</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIRIUS_EXPRESSION_DESCRIPTION_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ParameterImpl
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 4;

  /**
   * The feature id for the '<em><b>Optional</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__OPTIONAL = 0;

  /**
   * The feature id for the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__VARIABLE = 1;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage <em>Sirius Expression Package</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sirius Expression Package</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage
   * @generated
   */
  EClass getSiriusExpressionPackage();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage#getEPackage <em>EPackage</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EPackage</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage#getEPackage()
   * @see #getSiriusExpressionPackage()
   * @generated
   */
  EReference getSiriusExpressionPackage_EPackage();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage#getExpressionClasses <em>Expression Classes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Classes</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage#getExpressionClasses()
   * @see #getSiriusExpressionPackage()
   * @generated
   */
  EReference getSiriusExpressionPackage_ExpressionClasses();

  /**
   * Returns the meta object for class '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass <em>Sirius Expression Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sirius Expression Class</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass
   * @generated
   */
  EClass getSiriusExpressionClass();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass#getEClass <em>EClass</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EClass</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass#getEClass()
   * @see #getSiriusExpressionClass()
   * @generated
   */
  EReference getSiriusExpressionClass_EClass();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass#getVariables <em>Variables</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variables</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass#getVariables()
   * @see #getSiriusExpressionClass()
   * @generated
   */
  EReference getSiriusExpressionClass_Variables();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass#getExpressionDescriptions <em>Expression Descriptions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Descriptions</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass#getExpressionDescriptions()
   * @see #getSiriusExpressionClass()
   * @generated
   */
  EReference getSiriusExpressionClass_ExpressionDescriptions();

  /**
   * Returns the meta object for class '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable <em>Sirius Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sirius Variable</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable
   * @generated
   */
  EClass getSiriusVariable();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable#getDocumentation <em>Documentation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Documentation</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable#getDocumentation()
   * @see #getSiriusVariable()
   * @generated
   */
  EAttribute getSiriusVariable_Documentation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable#getName()
   * @see #getSiriusVariable()
   * @generated
   */
  EAttribute getSiriusVariable_Name();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable#getEType <em>EType</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>EType</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable#getEType()
   * @see #getSiriusVariable()
   * @generated
   */
  EReference getSiriusVariable_EType();

  /**
   * Returns the meta object for class '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription <em>Sirius Expression Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sirius Expression Description</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription
   * @generated
   */
  EClass getSiriusExpressionDescription();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Expression</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getExpression()
   * @see #getSiriusExpressionDescription()
   * @generated
   */
  EReference getSiriusExpressionDescription_Expression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getParameters()
   * @see #getSiriusExpressionDescription()
   * @generated
   */
  EReference getSiriusExpressionDescription_Parameters();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getType()
   * @see #getSiriusExpressionDescription()
   * @generated
   */
  EReference getSiriusExpressionDescription_Type();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getLowerBound()
   * @see #getSiriusExpressionDescription()
   * @generated
   */
  EAttribute getSiriusExpressionDescription_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getUpperBound()
   * @see #getSiriusExpressionDescription()
   * @generated
   */
  EAttribute getSiriusExpressionDescription_UpperBound();

  /**
   * Returns the meta object for the reference list '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getContextableElements <em>Contextable Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Contextable Elements</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getContextableElements()
   * @see #getSiriusExpressionDescription()
   * @generated
   */
  EReference getSiriusExpressionDescription_ContextableElements();

  /**
   * Returns the meta object for class '{@link org.eclipse.sirius.expression.dsl.expressionDSL.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.sirius.expression.dsl.expressionDSL.Parameter#isOptional <em>Optional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Optional</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.Parameter#isOptional()
   * @see #getParameter()
   * @generated
   */
  EAttribute getParameter_Optional();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.sirius.expression.dsl.expressionDSL.Parameter#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Variable</em>'.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.Parameter#getVariable()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Variable();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ExpressionDSLFactory getExpressionDSLFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionPackageImpl <em>Sirius Expression Package</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionPackageImpl
     * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl#getSiriusExpressionPackage()
     * @generated
     */
    EClass SIRIUS_EXPRESSION_PACKAGE = eINSTANCE.getSiriusExpressionPackage();

    /**
     * The meta object literal for the '<em><b>EPackage</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIRIUS_EXPRESSION_PACKAGE__EPACKAGE = eINSTANCE.getSiriusExpressionPackage_EPackage();

    /**
     * The meta object literal for the '<em><b>Expression Classes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIRIUS_EXPRESSION_PACKAGE__EXPRESSION_CLASSES = eINSTANCE.getSiriusExpressionPackage_ExpressionClasses();

    /**
     * The meta object literal for the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionClassImpl <em>Sirius Expression Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionClassImpl
     * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl#getSiriusExpressionClass()
     * @generated
     */
    EClass SIRIUS_EXPRESSION_CLASS = eINSTANCE.getSiriusExpressionClass();

    /**
     * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIRIUS_EXPRESSION_CLASS__ECLASS = eINSTANCE.getSiriusExpressionClass_EClass();

    /**
     * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIRIUS_EXPRESSION_CLASS__VARIABLES = eINSTANCE.getSiriusExpressionClass_Variables();

    /**
     * The meta object literal for the '<em><b>Expression Descriptions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIRIUS_EXPRESSION_CLASS__EXPRESSION_DESCRIPTIONS = eINSTANCE.getSiriusExpressionClass_ExpressionDescriptions();

    /**
     * The meta object literal for the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusVariableImpl <em>Sirius Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusVariableImpl
     * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl#getSiriusVariable()
     * @generated
     */
    EClass SIRIUS_VARIABLE = eINSTANCE.getSiriusVariable();

    /**
     * The meta object literal for the '<em><b>Documentation</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIRIUS_VARIABLE__DOCUMENTATION = eINSTANCE.getSiriusVariable_Documentation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIRIUS_VARIABLE__NAME = eINSTANCE.getSiriusVariable_Name();

    /**
     * The meta object literal for the '<em><b>EType</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIRIUS_VARIABLE__ETYPE = eINSTANCE.getSiriusVariable_EType();

    /**
     * The meta object literal for the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionDescriptionImpl <em>Sirius Expression Description</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionDescriptionImpl
     * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl#getSiriusExpressionDescription()
     * @generated
     */
    EClass SIRIUS_EXPRESSION_DESCRIPTION = eINSTANCE.getSiriusExpressionDescription();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIRIUS_EXPRESSION_DESCRIPTION__EXPRESSION = eINSTANCE.getSiriusExpressionDescription_Expression();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIRIUS_EXPRESSION_DESCRIPTION__PARAMETERS = eINSTANCE.getSiriusExpressionDescription_Parameters();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIRIUS_EXPRESSION_DESCRIPTION__TYPE = eINSTANCE.getSiriusExpressionDescription_Type();

    /**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIRIUS_EXPRESSION_DESCRIPTION__LOWER_BOUND = eINSTANCE.getSiriusExpressionDescription_LowerBound();

    /**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIRIUS_EXPRESSION_DESCRIPTION__UPPER_BOUND = eINSTANCE.getSiriusExpressionDescription_UpperBound();

    /**
     * The meta object literal for the '<em><b>Contextable Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SIRIUS_EXPRESSION_DESCRIPTION__CONTEXTABLE_ELEMENTS = eINSTANCE.getSiriusExpressionDescription_ContextableElements();

    /**
     * The meta object literal for the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ParameterImpl
     * @see org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER__OPTIONAL = eINSTANCE.getParameter_Optional();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__VARIABLE = eINSTANCE.getParameter_Variable();

  }

} //ExpressionDSLPackage

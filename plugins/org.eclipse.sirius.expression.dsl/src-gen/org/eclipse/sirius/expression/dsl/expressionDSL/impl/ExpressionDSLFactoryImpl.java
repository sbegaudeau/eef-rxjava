/**
 */
package org.eclipse.sirius.expression.dsl.expressionDSL.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.sirius.expression.dsl.expressionDSL.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionDSLFactoryImpl extends EFactoryImpl implements ExpressionDSLFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ExpressionDSLFactory init()
  {
    try
    {
      ExpressionDSLFactory theExpressionDSLFactory = (ExpressionDSLFactory)EPackage.Registry.INSTANCE.getEFactory(ExpressionDSLPackage.eNS_URI);
      if (theExpressionDSLFactory != null)
      {
        return theExpressionDSLFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ExpressionDSLFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionDSLFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE: return createSiriusExpressionPackage();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS: return createSiriusExpressionClass();
      case ExpressionDSLPackage.SIRIUS_VARIABLE: return createSiriusVariable();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION: return createSiriusExpressionDescription();
      case ExpressionDSLPackage.PARAMETER: return createParameter();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SiriusExpressionPackage createSiriusExpressionPackage()
  {
    SiriusExpressionPackageImpl siriusExpressionPackage = new SiriusExpressionPackageImpl();
    return siriusExpressionPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SiriusExpressionClass createSiriusExpressionClass()
  {
    SiriusExpressionClassImpl siriusExpressionClass = new SiriusExpressionClassImpl();
    return siriusExpressionClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SiriusVariable createSiriusVariable()
  {
    SiriusVariableImpl siriusVariable = new SiriusVariableImpl();
    return siriusVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SiriusExpressionDescription createSiriusExpressionDescription()
  {
    SiriusExpressionDescriptionImpl siriusExpressionDescription = new SiriusExpressionDescriptionImpl();
    return siriusExpressionDescription;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionDSLPackage getExpressionDSLPackage()
  {
    return (ExpressionDSLPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ExpressionDSLPackage getPackage()
  {
    return ExpressionDSLPackage.eINSTANCE;
  }

} //ExpressionDSLFactoryImpl

/**
 */
package org.eclipse.sirius.expression.dsl.expressionDSL;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage
 * @generated
 */
public interface ExpressionDSLFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExpressionDSLFactory eINSTANCE = org.eclipse.sirius.expression.dsl.expressionDSL.impl.ExpressionDSLFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Sirius Expression Package</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sirius Expression Package</em>'.
   * @generated
   */
  SiriusExpressionPackage createSiriusExpressionPackage();

  /**
   * Returns a new object of class '<em>Sirius Expression Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sirius Expression Class</em>'.
   * @generated
   */
  SiriusExpressionClass createSiriusExpressionClass();

  /**
   * Returns a new object of class '<em>Sirius Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sirius Variable</em>'.
   * @generated
   */
  SiriusVariable createSiriusVariable();

  /**
   * Returns a new object of class '<em>Sirius Expression Description</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sirius Expression Description</em>'.
   * @generated
   */
  SiriusExpressionDescription createSiriusExpressionDescription();

  /**
   * Returns a new object of class '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter</em>'.
   * @generated
   */
  Parameter createParameter();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ExpressionDSLPackage getExpressionDSLPackage();

} //ExpressionDSLFactory

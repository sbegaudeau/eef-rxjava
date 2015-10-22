/**
 */
package org.eclipse.sirius.expression.dsl.expressionDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sirius Expression Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass#getEClass <em>EClass</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass#getExpressionDescriptions <em>Expression Descriptions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionClass()
 * @model
 * @generated
 */
public interface SiriusExpressionClass extends EObject
{
  /**
   * Returns the value of the '<em><b>EClass</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>EClass</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>EClass</em>' reference.
   * @see #setEClass(EClass)
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionClass_EClass()
   * @model
   * @generated
   */
  EClass getEClass();

  /**
   * Sets the value of the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass#getEClass <em>EClass</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>EClass</em>' reference.
   * @see #getEClass()
   * @generated
   */
  void setEClass(EClass value);

  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionClass_Variables()
   * @model containment="true"
   * @generated
   */
  EList<SiriusVariable> getVariables();

  /**
   * Returns the value of the '<em><b>Expression Descriptions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression Descriptions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression Descriptions</em>' containment reference list.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionClass_ExpressionDescriptions()
   * @model containment="true"
   * @generated
   */
  EList<SiriusExpressionDescription> getExpressionDescriptions();

} // SiriusExpressionClass

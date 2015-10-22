/**
 */
package org.eclipse.sirius.expression.dsl.expressionDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sirius Expression Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage#getEPackage <em>EPackage</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage#getExpressionClasses <em>Expression Classes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionPackage()
 * @model
 * @generated
 */
public interface SiriusExpressionPackage extends EObject
{
  /**
   * Returns the value of the '<em><b>EPackage</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>EPackage</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>EPackage</em>' reference.
   * @see #setEPackage(EPackage)
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionPackage_EPackage()
   * @model
   * @generated
   */
  EPackage getEPackage();

  /**
   * Sets the value of the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage#getEPackage <em>EPackage</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>EPackage</em>' reference.
   * @see #getEPackage()
   * @generated
   */
  void setEPackage(EPackage value);

  /**
   * Returns the value of the '<em><b>Expression Classes</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression Classes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression Classes</em>' containment reference list.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionPackage_ExpressionClasses()
   * @model containment="true"
   * @generated
   */
  EList<SiriusExpressionClass> getExpressionClasses();

} // SiriusExpressionPackage

/**
 */
package org.eclipse.sirius.expression.dsl.expressionDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sirius Expression Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getContextableElements <em>Contextable Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionDescription()
 * @model
 * @generated
 */
public interface SiriusExpressionDescription extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' reference.
   * @see #setExpression(EAttribute)
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionDescription_Expression()
   * @model
   * @generated
   */
  EAttribute getExpression();

  /**
   * Sets the value of the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getExpression <em>Expression</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(EAttribute value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.sirius.expression.dsl.expressionDSL.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionDescription_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClassifier)
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionDescription_Type()
   * @model
   * @generated
   */
  EClassifier getType();

  /**
   * Sets the value of the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClassifier value);

  /**
   * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Bound</em>' attribute.
   * @see #setLowerBound(int)
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionDescription_LowerBound()
   * @model
   * @generated
   */
  int getLowerBound();

  /**
   * Sets the value of the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getLowerBound <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Bound</em>' attribute.
   * @see #getLowerBound()
   * @generated
   */
  void setLowerBound(int value);

  /**
   * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper Bound</em>' attribute.
   * @see #setUpperBound(int)
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionDescription_UpperBound()
   * @model
   * @generated
   */
  int getUpperBound();

  /**
   * Sets the value of the '{@link org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription#getUpperBound <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Bound</em>' attribute.
   * @see #getUpperBound()
   * @generated
   */
  void setUpperBound(int value);

  /**
   * Returns the value of the '<em><b>Contextable Elements</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Contextable Elements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Contextable Elements</em>' reference list.
   * @see org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage#getSiriusExpressionDescription_ContextableElements()
   * @model
   * @generated
   */
  EList<EClass> getContextableElements();

} // SiriusExpressionDescription

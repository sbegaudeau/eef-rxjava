/**
 */
package org.eclipse.sirius.expression.dsl.expressionDSL.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage;
import org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass;
import org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription;
import org.eclipse.sirius.expression.dsl.expressionDSL.SiriusVariable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sirius Expression Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionClassImpl#getEClass <em>EClass</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionClassImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionClassImpl#getExpressionDescriptions <em>Expression Descriptions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SiriusExpressionClassImpl extends MinimalEObjectImpl.Container implements SiriusExpressionClass
{
  /**
   * The cached value of the '{@link #getEClass() <em>EClass</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEClass()
   * @generated
   * @ordered
   */
  protected EClass eClass;

  /**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected EList<SiriusVariable> variables;

  /**
   * The cached value of the '{@link #getExpressionDescriptions() <em>Expression Descriptions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionDescriptions()
   * @generated
   * @ordered
   */
  protected EList<SiriusExpressionDescription> expressionDescriptions;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SiriusExpressionClassImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ExpressionDSLPackage.Literals.SIRIUS_EXPRESSION_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEClass()
  {
    if (eClass != null && eClass.eIsProxy())
    {
      InternalEObject oldEClass = (InternalEObject)eClass;
      eClass = (EClass)eResolveProxy(oldEClass);
      if (eClass != oldEClass)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__ECLASS, oldEClass, eClass));
      }
    }
    return eClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass basicGetEClass()
  {
    return eClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEClass(EClass newEClass)
  {
    EClass oldEClass = eClass;
    eClass = newEClass;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__ECLASS, oldEClass, eClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SiriusVariable> getVariables()
  {
    if (variables == null)
    {
      variables = new EObjectContainmentEList<SiriusVariable>(SiriusVariable.class, this, ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__VARIABLES);
    }
    return variables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SiriusExpressionDescription> getExpressionDescriptions()
  {
    if (expressionDescriptions == null)
    {
      expressionDescriptions = new EObjectContainmentEList<SiriusExpressionDescription>(SiriusExpressionDescription.class, this, ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__EXPRESSION_DESCRIPTIONS);
    }
    return expressionDescriptions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__EXPRESSION_DESCRIPTIONS:
        return ((InternalEList<?>)getExpressionDescriptions()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__ECLASS:
        if (resolve) return getEClass();
        return basicGetEClass();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__VARIABLES:
        return getVariables();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__EXPRESSION_DESCRIPTIONS:
        return getExpressionDescriptions();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__ECLASS:
        setEClass((EClass)newValue);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends SiriusVariable>)newValue);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__EXPRESSION_DESCRIPTIONS:
        getExpressionDescriptions().clear();
        getExpressionDescriptions().addAll((Collection<? extends SiriusExpressionDescription>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__ECLASS:
        setEClass((EClass)null);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__VARIABLES:
        getVariables().clear();
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__EXPRESSION_DESCRIPTIONS:
        getExpressionDescriptions().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__ECLASS:
        return eClass != null;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__VARIABLES:
        return variables != null && !variables.isEmpty();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_CLASS__EXPRESSION_DESCRIPTIONS:
        return expressionDescriptions != null && !expressionDescriptions.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SiriusExpressionClassImpl

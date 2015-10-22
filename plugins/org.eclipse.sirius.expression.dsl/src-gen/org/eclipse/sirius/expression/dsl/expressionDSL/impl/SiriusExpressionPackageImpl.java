/**
 */
package org.eclipse.sirius.expression.dsl.expressionDSL.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage;
import org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionClass;
import org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sirius Expression Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionPackageImpl#getEPackage <em>EPackage</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionPackageImpl#getExpressionClasses <em>Expression Classes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SiriusExpressionPackageImpl extends MinimalEObjectImpl.Container implements SiriusExpressionPackage
{
  /**
   * The cached value of the '{@link #getEPackage() <em>EPackage</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEPackage()
   * @generated
   * @ordered
   */
  protected EPackage ePackage;

  /**
   * The cached value of the '{@link #getExpressionClasses() <em>Expression Classes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionClasses()
   * @generated
   * @ordered
   */
  protected EList<SiriusExpressionClass> expressionClasses;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SiriusExpressionPackageImpl()
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
    return ExpressionDSLPackage.Literals.SIRIUS_EXPRESSION_PACKAGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage getEPackage()
  {
    if (ePackage != null && ePackage.eIsProxy())
    {
      InternalEObject oldEPackage = (InternalEObject)ePackage;
      ePackage = (EPackage)eResolveProxy(oldEPackage);
      if (ePackage != oldEPackage)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EPACKAGE, oldEPackage, ePackage));
      }
    }
    return ePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EPackage basicGetEPackage()
  {
    return ePackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEPackage(EPackage newEPackage)
  {
    EPackage oldEPackage = ePackage;
    ePackage = newEPackage;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EPACKAGE, oldEPackage, ePackage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SiriusExpressionClass> getExpressionClasses()
  {
    if (expressionClasses == null)
    {
      expressionClasses = new EObjectContainmentEList<SiriusExpressionClass>(SiriusExpressionClass.class, this, ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EXPRESSION_CLASSES);
    }
    return expressionClasses;
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
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EXPRESSION_CLASSES:
        return ((InternalEList<?>)getExpressionClasses()).basicRemove(otherEnd, msgs);
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
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EPACKAGE:
        if (resolve) return getEPackage();
        return basicGetEPackage();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EXPRESSION_CLASSES:
        return getExpressionClasses();
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
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EPACKAGE:
        setEPackage((EPackage)newValue);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EXPRESSION_CLASSES:
        getExpressionClasses().clear();
        getExpressionClasses().addAll((Collection<? extends SiriusExpressionClass>)newValue);
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
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EPACKAGE:
        setEPackage((EPackage)null);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EXPRESSION_CLASSES:
        getExpressionClasses().clear();
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
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EPACKAGE:
        return ePackage != null;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_PACKAGE__EXPRESSION_CLASSES:
        return expressionClasses != null && !expressionClasses.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SiriusExpressionPackageImpl

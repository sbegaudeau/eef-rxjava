/**
 */
package org.eclipse.sirius.expression.dsl.expressionDSL.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.sirius.expression.dsl.expressionDSL.ExpressionDSLPackage;
import org.eclipse.sirius.expression.dsl.expressionDSL.Parameter;
import org.eclipse.sirius.expression.dsl.expressionDSL.SiriusExpressionDescription;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sirius Expression Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionDescriptionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionDescriptionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionDescriptionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionDescriptionImpl#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionDescriptionImpl#getUpperBound <em>Upper Bound</em>}</li>
 *   <li>{@link org.eclipse.sirius.expression.dsl.expressionDSL.impl.SiriusExpressionDescriptionImpl#getContextableElements <em>Contextable Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SiriusExpressionDescriptionImpl extends MinimalEObjectImpl.Container implements SiriusExpressionDescription
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected EAttribute expression;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<Parameter> parameters;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected EClassifier type;

  /**
   * The default value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
  protected static final int LOWER_BOUND_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getLowerBound() <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLowerBound()
   * @generated
   * @ordered
   */
  protected int lowerBound = LOWER_BOUND_EDEFAULT;

  /**
   * The default value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
  protected static final int UPPER_BOUND_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getUpperBound() <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUpperBound()
   * @generated
   * @ordered
   */
  protected int upperBound = UPPER_BOUND_EDEFAULT;

  /**
   * The cached value of the '{@link #getContextableElements() <em>Contextable Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContextableElements()
   * @generated
   * @ordered
   */
  protected EList<EClass> contextableElements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SiriusExpressionDescriptionImpl()
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
    return ExpressionDSLPackage.Literals.SIRIUS_EXPRESSION_DESCRIPTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpression()
  {
    if (expression != null && expression.eIsProxy())
    {
      InternalEObject oldExpression = (InternalEObject)expression;
      expression = (EAttribute)eResolveProxy(oldExpression);
      if (expression != oldExpression)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__EXPRESSION, oldExpression, expression));
      }
    }
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute basicGetExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(EAttribute newExpression)
  {
    EAttribute oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__EXPRESSION, oldExpression, expression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Parameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (EClassifier)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(EClassifier newType)
  {
    EClassifier oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getLowerBound()
  {
    return lowerBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLowerBound(int newLowerBound)
  {
    int oldLowerBound = lowerBound;
    lowerBound = newLowerBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__LOWER_BOUND, oldLowerBound, lowerBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getUpperBound()
  {
    return upperBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUpperBound(int newUpperBound)
  {
    int oldUpperBound = upperBound;
    upperBound = newUpperBound;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__UPPER_BOUND, oldUpperBound, upperBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EClass> getContextableElements()
  {
    if (contextableElements == null)
    {
      contextableElements = new EObjectResolvingEList<EClass>(EClass.class, this, ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__CONTEXTABLE_ELEMENTS);
    }
    return contextableElements;
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
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__EXPRESSION:
        if (resolve) return getExpression();
        return basicGetExpression();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__PARAMETERS:
        return getParameters();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__LOWER_BOUND:
        return getLowerBound();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__UPPER_BOUND:
        return getUpperBound();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__CONTEXTABLE_ELEMENTS:
        return getContextableElements();
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
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__EXPRESSION:
        setExpression((EAttribute)newValue);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends Parameter>)newValue);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__TYPE:
        setType((EClassifier)newValue);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__LOWER_BOUND:
        setLowerBound((Integer)newValue);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__UPPER_BOUND:
        setUpperBound((Integer)newValue);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__CONTEXTABLE_ELEMENTS:
        getContextableElements().clear();
        getContextableElements().addAll((Collection<? extends EClass>)newValue);
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
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__EXPRESSION:
        setExpression((EAttribute)null);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__PARAMETERS:
        getParameters().clear();
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__TYPE:
        setType((EClassifier)null);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__LOWER_BOUND:
        setLowerBound(LOWER_BOUND_EDEFAULT);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__UPPER_BOUND:
        setUpperBound(UPPER_BOUND_EDEFAULT);
        return;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__CONTEXTABLE_ELEMENTS:
        getContextableElements().clear();
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
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__EXPRESSION:
        return expression != null;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__TYPE:
        return type != null;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__LOWER_BOUND:
        return lowerBound != LOWER_BOUND_EDEFAULT;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__UPPER_BOUND:
        return upperBound != UPPER_BOUND_EDEFAULT;
      case ExpressionDSLPackage.SIRIUS_EXPRESSION_DESCRIPTION__CONTEXTABLE_ELEMENTS:
        return contextableElements != null && !contextableElements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (lowerBound: ");
    result.append(lowerBound);
    result.append(", upperBound: ");
    result.append(upperBound);
    result.append(')');
    return result.toString();
  }

} //SiriusExpressionDescriptionImpl

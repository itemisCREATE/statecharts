/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.ConditionalExpressionCase;
import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expression Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionCaseImpl#getConditionExpression <em>Condition Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionCaseImpl#getThenExpression <em>Then Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalExpressionCaseImpl extends MinimalEObjectImpl.Container implements ConditionalExpressionCase
{
  /**
   * The cached value of the '{@link #getConditionExpression() <em>Condition Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConditionExpression()
   * @generated
   * @ordered
   */
  protected Expression conditionExpression;

  /**
   * The cached value of the '{@link #getThenExpression() <em>Then Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getThenExpression()
   * @generated
   * @ordered
   */
  protected Expression thenExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalExpressionCaseImpl()
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
    return AstPackage.Literals.CONDITIONAL_EXPRESSION_CASE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getConditionExpression()
  {
    return conditionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConditionExpression(Expression newConditionExpression, NotificationChain msgs)
  {
    Expression oldConditionExpression = conditionExpression;
    conditionExpression = newConditionExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION, oldConditionExpression, newConditionExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConditionExpression(Expression newConditionExpression)
  {
    if (newConditionExpression != conditionExpression)
    {
      NotificationChain msgs = null;
      if (conditionExpression != null)
        msgs = ((InternalEObject)conditionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION, null, msgs);
      if (newConditionExpression != null)
        msgs = ((InternalEObject)newConditionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION, null, msgs);
      msgs = basicSetConditionExpression(newConditionExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION, newConditionExpression, newConditionExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getThenExpression()
  {
    return thenExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetThenExpression(Expression newThenExpression, NotificationChain msgs)
  {
    Expression oldThenExpression = thenExpression;
    thenExpression = newThenExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION, oldThenExpression, newThenExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setThenExpression(Expression newThenExpression)
  {
    if (newThenExpression != thenExpression)
    {
      NotificationChain msgs = null;
      if (thenExpression != null)
        msgs = ((InternalEObject)thenExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION, null, msgs);
      if (newThenExpression != null)
        msgs = ((InternalEObject)newThenExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION, null, msgs);
      msgs = basicSetThenExpression(newThenExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION, newThenExpression, newThenExpression));
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
      case AstPackage.CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION:
        return basicSetConditionExpression(null, msgs);
      case AstPackage.CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION:
        return basicSetThenExpression(null, msgs);
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
      case AstPackage.CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION:
        return getConditionExpression();
      case AstPackage.CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION:
        return getThenExpression();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AstPackage.CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION:
        setConditionExpression((Expression)newValue);
        return;
      case AstPackage.CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION:
        setThenExpression((Expression)newValue);
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
      case AstPackage.CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION:
        setConditionExpression((Expression)null);
        return;
      case AstPackage.CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION:
        setThenExpression((Expression)null);
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
      case AstPackage.CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION:
        return conditionExpression != null;
      case AstPackage.CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION:
        return thenExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionalExpressionCaseImpl

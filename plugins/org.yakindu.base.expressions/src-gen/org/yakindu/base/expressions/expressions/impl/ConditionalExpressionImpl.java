/**
 */
package org.yakindu.base.expressions.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.expressions.expressions.ConditionalExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.ConditionalExpressionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.ConditionalExpressionImpl#getTrueCase <em>True Case</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.ConditionalExpressionImpl#getFalseCase <em>False Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalExpressionImpl extends ExpressionImpl implements ConditionalExpression
{
  /**
   * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCondition()
   * @generated
   * @ordered
   */
  protected Expression condition;

  /**
   * The cached value of the '{@link #getTrueCase() <em>True Case</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrueCase()
   * @generated
   * @ordered
   */
  protected Expression trueCase;

  /**
   * The cached value of the '{@link #getFalseCase() <em>False Case</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFalseCase()
   * @generated
   * @ordered
   */
  protected Expression falseCase;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalExpressionImpl()
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
    return ExpressionsPackage.Literals.CONDITIONAL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getCondition()
  {
    return condition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs)
  {
    Expression oldCondition = condition;
    condition = newCondition;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION, oldCondition, newCondition);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCondition(Expression newCondition)
  {
    if (newCondition != condition)
    {
      NotificationChain msgs = null;
      if (condition != null)
        msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION, null, msgs);
      if (newCondition != null)
        msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION, null, msgs);
      msgs = basicSetCondition(newCondition, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION, newCondition, newCondition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getTrueCase()
  {
    return trueCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTrueCase(Expression newTrueCase, NotificationChain msgs)
  {
    Expression oldTrueCase = trueCase;
    trueCase = newTrueCase;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITIONAL_EXPRESSION__TRUE_CASE, oldTrueCase, newTrueCase);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrueCase(Expression newTrueCase)
  {
    if (newTrueCase != trueCase)
    {
      NotificationChain msgs = null;
      if (trueCase != null)
        msgs = ((InternalEObject)trueCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITIONAL_EXPRESSION__TRUE_CASE, null, msgs);
      if (newTrueCase != null)
        msgs = ((InternalEObject)newTrueCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITIONAL_EXPRESSION__TRUE_CASE, null, msgs);
      msgs = basicSetTrueCase(newTrueCase, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITIONAL_EXPRESSION__TRUE_CASE, newTrueCase, newTrueCase));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getFalseCase()
  {
    return falseCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFalseCase(Expression newFalseCase, NotificationChain msgs)
  {
    Expression oldFalseCase = falseCase;
    falseCase = newFalseCase;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITIONAL_EXPRESSION__FALSE_CASE, oldFalseCase, newFalseCase);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFalseCase(Expression newFalseCase)
  {
    if (newFalseCase != falseCase)
    {
      NotificationChain msgs = null;
      if (falseCase != null)
        msgs = ((InternalEObject)falseCase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITIONAL_EXPRESSION__FALSE_CASE, null, msgs);
      if (newFalseCase != null)
        msgs = ((InternalEObject)newFalseCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CONDITIONAL_EXPRESSION__FALSE_CASE, null, msgs);
      msgs = basicSetFalseCase(newFalseCase, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CONDITIONAL_EXPRESSION__FALSE_CASE, newFalseCase, newFalseCase));
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
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
        return basicSetCondition(null, msgs);
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__TRUE_CASE:
        return basicSetTrueCase(null, msgs);
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__FALSE_CASE:
        return basicSetFalseCase(null, msgs);
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
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
        return getCondition();
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__TRUE_CASE:
        return getTrueCase();
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__FALSE_CASE:
        return getFalseCase();
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
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
        setCondition((Expression)newValue);
        return;
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__TRUE_CASE:
        setTrueCase((Expression)newValue);
        return;
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__FALSE_CASE:
        setFalseCase((Expression)newValue);
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
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
        setCondition((Expression)null);
        return;
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__TRUE_CASE:
        setTrueCase((Expression)null);
        return;
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__FALSE_CASE:
        setFalseCase((Expression)null);
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
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__CONDITION:
        return condition != null;
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__TRUE_CASE:
        return trueCase != null;
      case ExpressionsPackage.CONDITIONAL_EXPRESSION__FALSE_CASE:
        return falseCase != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionalExpressionImpl

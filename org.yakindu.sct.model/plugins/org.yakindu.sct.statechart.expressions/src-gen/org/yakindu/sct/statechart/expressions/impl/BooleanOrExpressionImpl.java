/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.yakindu.sct.statechart.expressions.BooleanAndExpression;
import org.yakindu.sct.statechart.expressions.BooleanOrExpression;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Or Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.BooleanOrExpressionImpl#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.BooleanOrExpressionImpl#getOperand2 <em>Operand2</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanOrExpressionImpl extends MinimalEObjectImpl.Container implements BooleanOrExpression
{
  /**
   * The cached value of the '{@link #getOperand1() <em>Operand1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand1()
   * @generated
   * @ordered
   */
  protected BooleanAndExpression operand1;

  /**
   * The cached value of the '{@link #getOperand2() <em>Operand2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand2()
   * @generated
   * @ordered
   */
  protected BooleanAndExpression operand2;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected BooleanOrExpressionImpl()
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
    return ExpressionsPackage.Literals.BOOLEAN_OR_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanAndExpression getOperand1()
  {
    return operand1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperand1(BooleanAndExpression newOperand1, NotificationChain msgs)
  {
    BooleanAndExpression oldOperand1 = operand1;
    operand1 = newOperand1;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND1, oldOperand1, newOperand1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperand1(BooleanAndExpression newOperand1)
  {
    if (newOperand1 != operand1)
    {
      NotificationChain msgs = null;
      if (operand1 != null)
        msgs = ((InternalEObject)operand1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND1, null, msgs);
      if (newOperand1 != null)
        msgs = ((InternalEObject)newOperand1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND1, null, msgs);
      msgs = basicSetOperand1(newOperand1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND1, newOperand1, newOperand1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanAndExpression getOperand2()
  {
    return operand2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOperand2(BooleanAndExpression newOperand2, NotificationChain msgs)
  {
    BooleanAndExpression oldOperand2 = operand2;
    operand2 = newOperand2;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND2, oldOperand2, newOperand2);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperand2(BooleanAndExpression newOperand2)
  {
    if (newOperand2 != operand2)
    {
      NotificationChain msgs = null;
      if (operand2 != null)
        msgs = ((InternalEObject)operand2).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND2, null, msgs);
      if (newOperand2 != null)
        msgs = ((InternalEObject)newOperand2).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND2, null, msgs);
      msgs = basicSetOperand2(newOperand2, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND2, newOperand2, newOperand2));
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
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND1:
        return basicSetOperand1(null, msgs);
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND2:
        return basicSetOperand2(null, msgs);
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
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND1:
        return getOperand1();
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND2:
        return getOperand2();
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
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND1:
        setOperand1((BooleanAndExpression)newValue);
        return;
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND2:
        setOperand2((BooleanAndExpression)newValue);
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
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND1:
        setOperand1((BooleanAndExpression)null);
        return;
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND2:
        setOperand2((BooleanAndExpression)null);
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
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND1:
        return operand1 != null;
      case ExpressionsPackage.BOOLEAN_OR_EXPRESSION__OPERAND2:
        return operand2 != null;
    }
    return super.eIsSet(featureID);
  }

} //BooleanOrExpressionImpl

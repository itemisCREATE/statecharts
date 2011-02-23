/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.yakindu.model.sct.statechart.Event;

import org.yakindu.model.sct.statechart.impl.TransitionExpressionImpl;

import org.yakindu.sct.statechart.expressions.CustomTransitionExpression;
import org.yakindu.sct.statechart.expressions.Expression;
import org.yakindu.sct.statechart.expressions.ExpressionRule;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Transition Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.CustomTransitionExpressionImpl#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.CustomTransitionExpressionImpl#getGuardExpression <em>Guard Expression</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.CustomTransitionExpressionImpl#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomTransitionExpressionImpl extends TransitionExpressionImpl implements CustomTransitionExpression
{
  /**
   * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggers()
   * @generated
   * @ordered
   */
  protected EList<Event> triggers;

  /**
   * The cached value of the '{@link #getGuardExpression() <em>Guard Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuardExpression()
   * @generated
   * @ordered
   */
  protected Expression guardExpression;

  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected ExpressionRule action;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CustomTransitionExpressionImpl()
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
    return ExpressionsPackage.Literals.CUSTOM_TRANSITION_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Event> getTriggers()
  {
    if (triggers == null)
    {
      triggers = new EObjectResolvingEList<Event>(Event.class, this, ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__TRIGGERS);
    }
    return triggers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getGuardExpression()
  {
    return guardExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuardExpression(Expression newGuardExpression, NotificationChain msgs)
  {
    Expression oldGuardExpression = guardExpression;
    guardExpression = newGuardExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION, oldGuardExpression, newGuardExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuardExpression(Expression newGuardExpression)
  {
    if (newGuardExpression != guardExpression)
    {
      NotificationChain msgs = null;
      if (guardExpression != null)
        msgs = ((InternalEObject)guardExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION, null, msgs);
      if (newGuardExpression != null)
        msgs = ((InternalEObject)newGuardExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION, null, msgs);
      msgs = basicSetGuardExpression(newGuardExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION, newGuardExpression, newGuardExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionRule getAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAction(ExpressionRule newAction, NotificationChain msgs)
  {
    ExpressionRule oldAction = action;
    action = newAction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__ACTION, oldAction, newAction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAction(ExpressionRule newAction)
  {
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__ACTION, null, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__ACTION, null, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__ACTION, newAction, newAction));
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
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION:
        return basicSetGuardExpression(null, msgs);
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__ACTION:
        return basicSetAction(null, msgs);
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
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__TRIGGERS:
        return getTriggers();
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION:
        return getGuardExpression();
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__ACTION:
        return getAction();
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
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__TRIGGERS:
        getTriggers().clear();
        getTriggers().addAll((Collection<? extends Event>)newValue);
        return;
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION:
        setGuardExpression((Expression)newValue);
        return;
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__ACTION:
        setAction((ExpressionRule)newValue);
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
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__TRIGGERS:
        getTriggers().clear();
        return;
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION:
        setGuardExpression((Expression)null);
        return;
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__ACTION:
        setAction((ExpressionRule)null);
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
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__TRIGGERS:
        return triggers != null && !triggers.isEmpty();
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION:
        return guardExpression != null;
      case ExpressionsPackage.CUSTOM_TRANSITION_EXPRESSION__ACTION:
        return action != null;
    }
    return super.eIsSet(featureID);
  }

} //CustomTransitionExpressionImpl

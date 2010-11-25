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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.sct.statechart.expressions.Event;
import org.yakindu.sct.statechart.expressions.ExpressionRule;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;
import org.yakindu.sct.statechart.expressions.TransitionDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.TransitionDefinitionImpl#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.TransitionDefinitionImpl#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionDefinitionImpl extends StatementImpl implements TransitionDefinition
{
  /**
   * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' containment reference list.
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
  protected ExpressionRule guardExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransitionDefinitionImpl()
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
    return ExpressionsPackage.Literals.TRANSITION_DEFINITION;
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
      triggers = new EObjectContainmentEList<Event>(Event.class, this, ExpressionsPackage.TRANSITION_DEFINITION__TRIGGERS);
    }
    return triggers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionRule getGuardExpression()
  {
    return guardExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetGuardExpression(ExpressionRule newGuardExpression, NotificationChain msgs)
  {
    ExpressionRule oldGuardExpression = guardExpression;
    guardExpression = newGuardExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TRANSITION_DEFINITION__GUARD_EXPRESSION, oldGuardExpression, newGuardExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuardExpression(ExpressionRule newGuardExpression)
  {
    if (newGuardExpression != guardExpression)
    {
      NotificationChain msgs = null;
      if (guardExpression != null)
        msgs = ((InternalEObject)guardExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TRANSITION_DEFINITION__GUARD_EXPRESSION, null, msgs);
      if (newGuardExpression != null)
        msgs = ((InternalEObject)newGuardExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.TRANSITION_DEFINITION__GUARD_EXPRESSION, null, msgs);
      msgs = basicSetGuardExpression(newGuardExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.TRANSITION_DEFINITION__GUARD_EXPRESSION, newGuardExpression, newGuardExpression));
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
      case ExpressionsPackage.TRANSITION_DEFINITION__TRIGGERS:
        return ((InternalEList<?>)getTriggers()).basicRemove(otherEnd, msgs);
      case ExpressionsPackage.TRANSITION_DEFINITION__GUARD_EXPRESSION:
        return basicSetGuardExpression(null, msgs);
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
      case ExpressionsPackage.TRANSITION_DEFINITION__TRIGGERS:
        return getTriggers();
      case ExpressionsPackage.TRANSITION_DEFINITION__GUARD_EXPRESSION:
        return getGuardExpression();
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
      case ExpressionsPackage.TRANSITION_DEFINITION__TRIGGERS:
        getTriggers().clear();
        getTriggers().addAll((Collection<? extends Event>)newValue);
        return;
      case ExpressionsPackage.TRANSITION_DEFINITION__GUARD_EXPRESSION:
        setGuardExpression((ExpressionRule)newValue);
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
      case ExpressionsPackage.TRANSITION_DEFINITION__TRIGGERS:
        getTriggers().clear();
        return;
      case ExpressionsPackage.TRANSITION_DEFINITION__GUARD_EXPRESSION:
        setGuardExpression((ExpressionRule)null);
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
      case ExpressionsPackage.TRANSITION_DEFINITION__TRIGGERS:
        return triggers != null && !triggers.isEmpty();
      case ExpressionsPackage.TRANSITION_DEFINITION__GUARD_EXPRESSION:
        return guardExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //TransitionDefinitionImpl

/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.sct.model.sgraph.impl.TriggerImpl;

import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reaction Trigger</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.ReactionTriggerImpl#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.ReactionTriggerImpl#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReactionTriggerImpl extends TriggerImpl implements ReactionTrigger
{
  /**
   * The cached value of the '{@link #getTriggers() <em>Triggers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTriggers()
   * @generated
   * @ordered
   */
  protected EList<EventSpec> triggers;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReactionTriggerImpl()
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
    return StextPackage.Literals.REACTION_TRIGGER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EventSpec> getTriggers()
  {
    if (triggers == null)
    {
      triggers = new EObjectContainmentEList<EventSpec>(EventSpec.class, this, StextPackage.REACTION_TRIGGER__TRIGGERS);
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.REACTION_TRIGGER__GUARD_EXPRESSION, oldGuardExpression, newGuardExpression);
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
        msgs = ((InternalEObject)guardExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.REACTION_TRIGGER__GUARD_EXPRESSION, null, msgs);
      if (newGuardExpression != null)
        msgs = ((InternalEObject)newGuardExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.REACTION_TRIGGER__GUARD_EXPRESSION, null, msgs);
      msgs = basicSetGuardExpression(newGuardExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.REACTION_TRIGGER__GUARD_EXPRESSION, newGuardExpression, newGuardExpression));
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
      case StextPackage.REACTION_TRIGGER__TRIGGERS:
        return ((InternalEList<?>)getTriggers()).basicRemove(otherEnd, msgs);
      case StextPackage.REACTION_TRIGGER__GUARD_EXPRESSION:
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
      case StextPackage.REACTION_TRIGGER__TRIGGERS:
        return getTriggers();
      case StextPackage.REACTION_TRIGGER__GUARD_EXPRESSION:
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
      case StextPackage.REACTION_TRIGGER__TRIGGERS:
        getTriggers().clear();
        getTriggers().addAll((Collection<? extends EventSpec>)newValue);
        return;
      case StextPackage.REACTION_TRIGGER__GUARD_EXPRESSION:
        setGuardExpression((Expression)newValue);
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
      case StextPackage.REACTION_TRIGGER__TRIGGERS:
        getTriggers().clear();
        return;
      case StextPackage.REACTION_TRIGGER__GUARD_EXPRESSION:
        setGuardExpression((Expression)null);
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
      case StextPackage.REACTION_TRIGGER__TRIGGERS:
        return triggers != null && !triggers.isEmpty();
      case StextPackage.REACTION_TRIGGER__GUARD_EXPRESSION:
        return guardExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //ReactionTriggerImpl

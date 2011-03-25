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

import org.yakindu.sct.statechart.expressions.Action;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;
import org.yakindu.sct.statechart.expressions.Reaction;
import org.yakindu.sct.statechart.expressions.ReactionProperties;
import org.yakindu.sct.statechart.expressions.ReactionTrigger;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.ReactionImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.ReactionImpl#getAction <em>Action</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.ReactionImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReactionImpl extends TransitionStatementImpl implements Reaction
{
  /**
   * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTrigger()
   * @generated
   * @ordered
   */
  protected ReactionTrigger trigger;

  /**
   * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAction()
   * @generated
   * @ordered
   */
  protected Action action;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected ReactionProperties properties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ReactionImpl()
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
    return ExpressionsPackage.Literals.REACTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionTrigger getTrigger()
  {
    return trigger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTrigger(ReactionTrigger newTrigger, NotificationChain msgs)
  {
    ReactionTrigger oldTrigger = trigger;
    trigger = newTrigger;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.REACTION__TRIGGER, oldTrigger, newTrigger);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTrigger(ReactionTrigger newTrigger)
  {
    if (newTrigger != trigger)
    {
      NotificationChain msgs = null;
      if (trigger != null)
        msgs = ((InternalEObject)trigger).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.REACTION__TRIGGER, null, msgs);
      if (newTrigger != null)
        msgs = ((InternalEObject)newTrigger).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.REACTION__TRIGGER, null, msgs);
      msgs = basicSetTrigger(newTrigger, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.REACTION__TRIGGER, newTrigger, newTrigger));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Action getAction()
  {
    return action;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAction(Action newAction, NotificationChain msgs)
  {
    Action oldAction = action;
    action = newAction;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.REACTION__ACTION, oldAction, newAction);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAction(Action newAction)
  {
    if (newAction != action)
    {
      NotificationChain msgs = null;
      if (action != null)
        msgs = ((InternalEObject)action).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.REACTION__ACTION, null, msgs);
      if (newAction != null)
        msgs = ((InternalEObject)newAction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.REACTION__ACTION, null, msgs);
      msgs = basicSetAction(newAction, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.REACTION__ACTION, newAction, newAction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReactionProperties getProperties()
  {
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetProperties(ReactionProperties newProperties, NotificationChain msgs)
  {
    ReactionProperties oldProperties = properties;
    properties = newProperties;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.REACTION__PROPERTIES, oldProperties, newProperties);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProperties(ReactionProperties newProperties)
  {
    if (newProperties != properties)
    {
      NotificationChain msgs = null;
      if (properties != null)
        msgs = ((InternalEObject)properties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.REACTION__PROPERTIES, null, msgs);
      if (newProperties != null)
        msgs = ((InternalEObject)newProperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.REACTION__PROPERTIES, null, msgs);
      msgs = basicSetProperties(newProperties, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.REACTION__PROPERTIES, newProperties, newProperties));
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
      case ExpressionsPackage.REACTION__TRIGGER:
        return basicSetTrigger(null, msgs);
      case ExpressionsPackage.REACTION__ACTION:
        return basicSetAction(null, msgs);
      case ExpressionsPackage.REACTION__PROPERTIES:
        return basicSetProperties(null, msgs);
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
      case ExpressionsPackage.REACTION__TRIGGER:
        return getTrigger();
      case ExpressionsPackage.REACTION__ACTION:
        return getAction();
      case ExpressionsPackage.REACTION__PROPERTIES:
        return getProperties();
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
      case ExpressionsPackage.REACTION__TRIGGER:
        setTrigger((ReactionTrigger)newValue);
        return;
      case ExpressionsPackage.REACTION__ACTION:
        setAction((Action)newValue);
        return;
      case ExpressionsPackage.REACTION__PROPERTIES:
        setProperties((ReactionProperties)newValue);
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
      case ExpressionsPackage.REACTION__TRIGGER:
        setTrigger((ReactionTrigger)null);
        return;
      case ExpressionsPackage.REACTION__ACTION:
        setAction((Action)null);
        return;
      case ExpressionsPackage.REACTION__PROPERTIES:
        setProperties((ReactionProperties)null);
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
      case ExpressionsPackage.REACTION__TRIGGER:
        return trigger != null;
      case ExpressionsPackage.REACTION__ACTION:
        return action != null;
      case ExpressionsPackage.REACTION__PROPERTIES:
        return properties != null;
    }
    return super.eIsSet(featureID);
  }

} //ReactionImpl

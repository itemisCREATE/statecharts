/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.types.Type;

import org.yakindu.sct.model.sgraph.impl.EventImpl;

import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventDerivation;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl#getDerivation <em>Derivation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventDefinitionImpl extends EventImpl implements EventDefinition
{
  /**
   * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected static final Direction DIRECTION_EDEFAULT = Direction.LOCAL;

  /**
   * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected Direction direction = DIRECTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected Type type;

  /**
   * The cached value of the '{@link #getDerivation() <em>Derivation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDerivation()
   * @generated
   * @ordered
   */
  protected EventDerivation derivation;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EventDefinitionImpl()
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
    return StextPackage.Literals.EVENT_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Direction getDirection()
  {
    return direction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDirection(Direction newDirection)
  {
    Direction oldDirection = direction;
    direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.EVENT_DEFINITION__DIRECTION, oldDirection, direction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type getType()
  {
    if (type != null && type.eIsProxy())
    {
      InternalEObject oldType = (InternalEObject)type;
      type = (Type)eResolveProxy(oldType);
      if (type != oldType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.EVENT_DEFINITION__TYPE, oldType, type));
      }
    }
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type basicGetType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(Type newType)
  {
    Type oldType = type;
    type = newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.EVENT_DEFINITION__TYPE, oldType, type));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EventDerivation getDerivation()
  {
    return derivation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDerivation(EventDerivation newDerivation, NotificationChain msgs)
  {
    EventDerivation oldDerivation = derivation;
    derivation = newDerivation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.EVENT_DEFINITION__DERIVATION, oldDerivation, newDerivation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDerivation(EventDerivation newDerivation)
  {
    if (newDerivation != derivation)
    {
      NotificationChain msgs = null;
      if (derivation != null)
        msgs = ((InternalEObject)derivation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.EVENT_DEFINITION__DERIVATION, null, msgs);
      if (newDerivation != null)
        msgs = ((InternalEObject)newDerivation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.EVENT_DEFINITION__DERIVATION, null, msgs);
      msgs = basicSetDerivation(newDerivation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.EVENT_DEFINITION__DERIVATION, newDerivation, newDerivation));
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
      case StextPackage.EVENT_DEFINITION__DERIVATION:
        return basicSetDerivation(null, msgs);
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
      case StextPackage.EVENT_DEFINITION__DIRECTION:
        return getDirection();
      case StextPackage.EVENT_DEFINITION__TYPE:
        if (resolve) return getType();
        return basicGetType();
      case StextPackage.EVENT_DEFINITION__DERIVATION:
        return getDerivation();
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
      case StextPackage.EVENT_DEFINITION__DIRECTION:
        setDirection((Direction)newValue);
        return;
      case StextPackage.EVENT_DEFINITION__TYPE:
        setType((Type)newValue);
        return;
      case StextPackage.EVENT_DEFINITION__DERIVATION:
        setDerivation((EventDerivation)newValue);
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
      case StextPackage.EVENT_DEFINITION__DIRECTION:
        setDirection(DIRECTION_EDEFAULT);
        return;
      case StextPackage.EVENT_DEFINITION__TYPE:
        setType((Type)null);
        return;
      case StextPackage.EVENT_DEFINITION__DERIVATION:
        setDerivation((EventDerivation)null);
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
      case StextPackage.EVENT_DEFINITION__DIRECTION:
        return direction != DIRECTION_EDEFAULT;
      case StextPackage.EVENT_DEFINITION__TYPE:
        return type != null;
      case StextPackage.EVENT_DEFINITION__DERIVATION:
        return derivation != null;
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
    result.append(" (direction: ");
    result.append(direction);
    result.append(')');
    return result.toString();
  }

} //EventDefinitionImpl

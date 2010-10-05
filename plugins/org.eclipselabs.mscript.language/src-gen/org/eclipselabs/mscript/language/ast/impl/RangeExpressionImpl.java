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

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.RangeExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Range Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.RangeExpressionImpl#getBegin <em>Begin</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.RangeExpressionImpl#getEnd <em>End</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.RangeExpressionImpl#getIncrement <em>Increment</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RangeExpressionImpl extends ExpressionImpl implements RangeExpression
{
  /**
   * The cached value of the '{@link #getBegin() <em>Begin</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBegin()
   * @generated
   * @ordered
   */
  protected Expression begin;

  /**
   * The cached value of the '{@link #getEnd() <em>End</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnd()
   * @generated
   * @ordered
   */
  protected Expression end;

  /**
   * The cached value of the '{@link #getIncrement() <em>Increment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIncrement()
   * @generated
   * @ordered
   */
  protected RangeExpression increment;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RangeExpressionImpl()
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
    return AstPackage.Literals.RANGE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getBegin()
  {
    return begin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBegin(Expression newBegin, NotificationChain msgs)
  {
    Expression oldBegin = begin;
    begin = newBegin;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.RANGE_EXPRESSION__BEGIN, oldBegin, newBegin);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBegin(Expression newBegin)
  {
    if (newBegin != begin)
    {
      NotificationChain msgs = null;
      if (begin != null)
        msgs = ((InternalEObject)begin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.RANGE_EXPRESSION__BEGIN, null, msgs);
      if (newBegin != null)
        msgs = ((InternalEObject)newBegin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.RANGE_EXPRESSION__BEGIN, null, msgs);
      msgs = basicSetBegin(newBegin, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.RANGE_EXPRESSION__BEGIN, newBegin, newBegin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getEnd()
  {
    return end;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEnd(Expression newEnd, NotificationChain msgs)
  {
    Expression oldEnd = end;
    end = newEnd;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.RANGE_EXPRESSION__END, oldEnd, newEnd);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnd(Expression newEnd)
  {
    if (newEnd != end)
    {
      NotificationChain msgs = null;
      if (end != null)
        msgs = ((InternalEObject)end).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.RANGE_EXPRESSION__END, null, msgs);
      if (newEnd != null)
        msgs = ((InternalEObject)newEnd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.RANGE_EXPRESSION__END, null, msgs);
      msgs = basicSetEnd(newEnd, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.RANGE_EXPRESSION__END, newEnd, newEnd));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RangeExpression getIncrement()
  {
    return increment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetIncrement(RangeExpression newIncrement, NotificationChain msgs)
  {
    RangeExpression oldIncrement = increment;
    increment = newIncrement;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.RANGE_EXPRESSION__INCREMENT, oldIncrement, newIncrement);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIncrement(RangeExpression newIncrement)
  {
    if (newIncrement != increment)
    {
      NotificationChain msgs = null;
      if (increment != null)
        msgs = ((InternalEObject)increment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.RANGE_EXPRESSION__INCREMENT, null, msgs);
      if (newIncrement != null)
        msgs = ((InternalEObject)newIncrement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.RANGE_EXPRESSION__INCREMENT, null, msgs);
      msgs = basicSetIncrement(newIncrement, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.RANGE_EXPRESSION__INCREMENT, newIncrement, newIncrement));
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
      case AstPackage.RANGE_EXPRESSION__BEGIN:
        return basicSetBegin(null, msgs);
      case AstPackage.RANGE_EXPRESSION__END:
        return basicSetEnd(null, msgs);
      case AstPackage.RANGE_EXPRESSION__INCREMENT:
        return basicSetIncrement(null, msgs);
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
      case AstPackage.RANGE_EXPRESSION__BEGIN:
        return getBegin();
      case AstPackage.RANGE_EXPRESSION__END:
        return getEnd();
      case AstPackage.RANGE_EXPRESSION__INCREMENT:
        return getIncrement();
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
      case AstPackage.RANGE_EXPRESSION__BEGIN:
        setBegin((Expression)newValue);
        return;
      case AstPackage.RANGE_EXPRESSION__END:
        setEnd((Expression)newValue);
        return;
      case AstPackage.RANGE_EXPRESSION__INCREMENT:
        setIncrement((RangeExpression)newValue);
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
      case AstPackage.RANGE_EXPRESSION__BEGIN:
        setBegin((Expression)null);
        return;
      case AstPackage.RANGE_EXPRESSION__END:
        setEnd((Expression)null);
        return;
      case AstPackage.RANGE_EXPRESSION__INCREMENT:
        setIncrement((RangeExpression)null);
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
      case AstPackage.RANGE_EXPRESSION__BEGIN:
        return begin != null;
      case AstPackage.RANGE_EXPRESSION__END:
        return end != null;
      case AstPackage.RANGE_EXPRESSION__INCREMENT:
        return increment != null;
    }
    return super.eIsSet(featureID);
  }

} //RangeExpressionImpl

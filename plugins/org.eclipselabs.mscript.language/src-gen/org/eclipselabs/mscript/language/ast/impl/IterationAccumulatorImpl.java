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
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.IterationAccumulator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration Accumulator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.IterationAccumulatorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.IterationAccumulatorImpl#getInitialExpression <em>Initial Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IterationAccumulatorImpl extends MinimalEObjectImpl.Container implements IterationAccumulator
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getInitialExpression() <em>Initial Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitialExpression()
   * @generated
   * @ordered
   */
  protected Expression initialExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IterationAccumulatorImpl()
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
    return AstPackage.Literals.ITERATION_ACCUMULATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ITERATION_ACCUMULATOR__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getInitialExpression()
  {
    return initialExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInitialExpression(Expression newInitialExpression, NotificationChain msgs)
  {
    Expression oldInitialExpression = initialExpression;
    initialExpression = newInitialExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ITERATION_ACCUMULATOR__INITIAL_EXPRESSION, oldInitialExpression, newInitialExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInitialExpression(Expression newInitialExpression)
  {
    if (newInitialExpression != initialExpression)
    {
      NotificationChain msgs = null;
      if (initialExpression != null)
        msgs = ((InternalEObject)initialExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ITERATION_ACCUMULATOR__INITIAL_EXPRESSION, null, msgs);
      if (newInitialExpression != null)
        msgs = ((InternalEObject)newInitialExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ITERATION_ACCUMULATOR__INITIAL_EXPRESSION, null, msgs);
      msgs = basicSetInitialExpression(newInitialExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ITERATION_ACCUMULATOR__INITIAL_EXPRESSION, newInitialExpression, newInitialExpression));
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
      case AstPackage.ITERATION_ACCUMULATOR__INITIAL_EXPRESSION:
        return basicSetInitialExpression(null, msgs);
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
      case AstPackage.ITERATION_ACCUMULATOR__NAME:
        return getName();
      case AstPackage.ITERATION_ACCUMULATOR__INITIAL_EXPRESSION:
        return getInitialExpression();
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
      case AstPackage.ITERATION_ACCUMULATOR__NAME:
        setName((String)newValue);
        return;
      case AstPackage.ITERATION_ACCUMULATOR__INITIAL_EXPRESSION:
        setInitialExpression((Expression)newValue);
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
      case AstPackage.ITERATION_ACCUMULATOR__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AstPackage.ITERATION_ACCUMULATOR__INITIAL_EXPRESSION:
        setInitialExpression((Expression)null);
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
      case AstPackage.ITERATION_ACCUMULATOR__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AstPackage.ITERATION_ACCUMULATOR__INITIAL_EXPRESSION:
        return initialExpression != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //IterationAccumulatorImpl

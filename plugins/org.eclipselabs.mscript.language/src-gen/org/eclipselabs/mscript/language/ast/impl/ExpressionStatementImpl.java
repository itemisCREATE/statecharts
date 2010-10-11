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
import org.eclipselabs.mscript.language.ast.ExpressionStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ExpressionStatementImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ExpressionStatementImpl#getAssignedValue <em>Assigned Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressionStatementImpl extends StatementImpl implements ExpressionStatement
{
  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The cached value of the '{@link #getAssignedValue() <em>Assigned Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAssignedValue()
   * @generated
   * @ordered
   */
  protected Expression assignedValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressionStatementImpl()
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
    return AstPackage.Literals.EXPRESSION_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.EXPRESSION_STATEMENT__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.EXPRESSION_STATEMENT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.EXPRESSION_STATEMENT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.EXPRESSION_STATEMENT__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getAssignedValue()
  {
    return assignedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetAssignedValue(Expression newAssignedValue, NotificationChain msgs)
  {
    Expression oldAssignedValue = assignedValue;
    assignedValue = newAssignedValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.EXPRESSION_STATEMENT__ASSIGNED_VALUE, oldAssignedValue, newAssignedValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignedValue(Expression newAssignedValue)
  {
    if (newAssignedValue != assignedValue)
    {
      NotificationChain msgs = null;
      if (assignedValue != null)
        msgs = ((InternalEObject)assignedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.EXPRESSION_STATEMENT__ASSIGNED_VALUE, null, msgs);
      if (newAssignedValue != null)
        msgs = ((InternalEObject)newAssignedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.EXPRESSION_STATEMENT__ASSIGNED_VALUE, null, msgs);
      msgs = basicSetAssignedValue(newAssignedValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.EXPRESSION_STATEMENT__ASSIGNED_VALUE, newAssignedValue, newAssignedValue));
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
      case AstPackage.EXPRESSION_STATEMENT__EXPRESSION:
        return basicSetExpression(null, msgs);
      case AstPackage.EXPRESSION_STATEMENT__ASSIGNED_VALUE:
        return basicSetAssignedValue(null, msgs);
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
      case AstPackage.EXPRESSION_STATEMENT__EXPRESSION:
        return getExpression();
      case AstPackage.EXPRESSION_STATEMENT__ASSIGNED_VALUE:
        return getAssignedValue();
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
      case AstPackage.EXPRESSION_STATEMENT__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case AstPackage.EXPRESSION_STATEMENT__ASSIGNED_VALUE:
        setAssignedValue((Expression)newValue);
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
      case AstPackage.EXPRESSION_STATEMENT__EXPRESSION:
        setExpression((Expression)null);
        return;
      case AstPackage.EXPRESSION_STATEMENT__ASSIGNED_VALUE:
        setAssignedValue((Expression)null);
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
      case AstPackage.EXPRESSION_STATEMENT__EXPRESSION:
        return expression != null;
      case AstPackage.EXPRESSION_STATEMENT__ASSIGNED_VALUE:
        return assignedValue != null;
    }
    return super.eIsSet(featureID);
  }

} //ExpressionStatementImpl

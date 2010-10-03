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
import org.eclipselabs.mscript.language.ast.FeatureCallStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Call Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallStatementImpl#getFeatureCall <em>Feature Call</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallStatementImpl#isAssignment <em>Assignment</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallStatementImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureCallStatementImpl extends StatementImpl implements FeatureCallStatement
{
  /**
   * The cached value of the '{@link #getFeatureCall() <em>Feature Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeatureCall()
   * @generated
   * @ordered
   */
  protected Expression featureCall;

  /**
   * The default value of the '{@link #isAssignment() <em>Assignment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAssignment()
   * @generated
   * @ordered
   */
  protected static final boolean ASSIGNMENT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAssignment() <em>Assignment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAssignment()
   * @generated
   * @ordered
   */
  protected boolean assignment = ASSIGNMENT_EDEFAULT;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected FeatureCallStatementImpl()
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
    return AstPackage.Literals.FEATURE_CALL_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getFeatureCall()
  {
    return featureCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFeatureCall(Expression newFeatureCall, NotificationChain msgs)
  {
    Expression oldFeatureCall = featureCall;
    featureCall = newFeatureCall;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL, oldFeatureCall, newFeatureCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeatureCall(Expression newFeatureCall)
  {
    if (newFeatureCall != featureCall)
    {
      NotificationChain msgs = null;
      if (featureCall != null)
        msgs = ((InternalEObject)featureCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL, null, msgs);
      if (newFeatureCall != null)
        msgs = ((InternalEObject)newFeatureCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL, null, msgs);
      msgs = basicSetFeatureCall(newFeatureCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL, newFeatureCall, newFeatureCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAssignment()
  {
    return assignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAssignment(boolean newAssignment)
  {
    boolean oldAssignment = assignment;
    assignment = newAssignment;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL_STATEMENT__ASSIGNMENT, oldAssignment, assignment));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL_STATEMENT__EXPRESSION, oldExpression, newExpression);
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
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FEATURE_CALL_STATEMENT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FEATURE_CALL_STATEMENT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL_STATEMENT__EXPRESSION, newExpression, newExpression));
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
      case AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL:
        return basicSetFeatureCall(null, msgs);
      case AstPackage.FEATURE_CALL_STATEMENT__EXPRESSION:
        return basicSetExpression(null, msgs);
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
      case AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL:
        return getFeatureCall();
      case AstPackage.FEATURE_CALL_STATEMENT__ASSIGNMENT:
        return isAssignment();
      case AstPackage.FEATURE_CALL_STATEMENT__EXPRESSION:
        return getExpression();
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
      case AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL:
        setFeatureCall((Expression)newValue);
        return;
      case AstPackage.FEATURE_CALL_STATEMENT__ASSIGNMENT:
        setAssignment((Boolean)newValue);
        return;
      case AstPackage.FEATURE_CALL_STATEMENT__EXPRESSION:
        setExpression((Expression)newValue);
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
      case AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL:
        setFeatureCall((Expression)null);
        return;
      case AstPackage.FEATURE_CALL_STATEMENT__ASSIGNMENT:
        setAssignment(ASSIGNMENT_EDEFAULT);
        return;
      case AstPackage.FEATURE_CALL_STATEMENT__EXPRESSION:
        setExpression((Expression)null);
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
      case AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL:
        return featureCall != null;
      case AstPackage.FEATURE_CALL_STATEMENT__ASSIGNMENT:
        return assignment != ASSIGNMENT_EDEFAULT;
      case AstPackage.FEATURE_CALL_STATEMENT__EXPRESSION:
        return expression != null;
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
    result.append(" (assignment: ");
    result.append(assignment);
    result.append(')');
    return result.toString();
  }

} //FeatureCallStatementImpl

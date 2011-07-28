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
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.AssignmentImpl#getVarRef <em>Var Ref</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.AssignmentImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignmentImpl extends StatementImpl implements Assignment
{
  /**
   * The cached value of the '{@link #getVarRef() <em>Var Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarRef()
   * @generated
   * @ordered
   */
  protected Variable varRef;

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
  protected AssignmentImpl()
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
    return StextPackage.Literals.ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable getVarRef()
  {
    if (varRef != null && varRef.eIsProxy())
    {
      InternalEObject oldVarRef = (InternalEObject)varRef;
      varRef = (Variable)eResolveProxy(oldVarRef);
      if (varRef != oldVarRef)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.ASSIGNMENT__VAR_REF, oldVarRef, varRef));
      }
    }
    return varRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable basicGetVarRef()
  {
    return varRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVarRef(Variable newVarRef)
  {
    Variable oldVarRef = varRef;
    varRef = newVarRef;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.ASSIGNMENT__VAR_REF, oldVarRef, varRef));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.ASSIGNMENT__EXPRESSION, oldExpression, newExpression);
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
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.ASSIGNMENT__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.ASSIGNMENT__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.ASSIGNMENT__EXPRESSION, newExpression, newExpression));
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
      case StextPackage.ASSIGNMENT__EXPRESSION:
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
      case StextPackage.ASSIGNMENT__VAR_REF:
        if (resolve) return getVarRef();
        return basicGetVarRef();
      case StextPackage.ASSIGNMENT__EXPRESSION:
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
      case StextPackage.ASSIGNMENT__VAR_REF:
        setVarRef((Variable)newValue);
        return;
      case StextPackage.ASSIGNMENT__EXPRESSION:
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
      case StextPackage.ASSIGNMENT__VAR_REF:
        setVarRef((Variable)null);
        return;
      case StextPackage.ASSIGNMENT__EXPRESSION:
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
      case StextPackage.ASSIGNMENT__VAR_REF:
        return varRef != null;
      case StextPackage.ASSIGNMENT__EXPRESSION:
        return expression != null;
    }
    return super.eIsSet(featureID);
  }

} //AssignmentImpl

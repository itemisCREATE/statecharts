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
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallStatementImpl#getAssignedValue <em>Assigned Value</em>}</li>
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL_STATEMENT__ASSIGNED_VALUE, oldAssignedValue, newAssignedValue);
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
        msgs = ((InternalEObject)assignedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FEATURE_CALL_STATEMENT__ASSIGNED_VALUE, null, msgs);
      if (newAssignedValue != null)
        msgs = ((InternalEObject)newAssignedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FEATURE_CALL_STATEMENT__ASSIGNED_VALUE, null, msgs);
      msgs = basicSetAssignedValue(newAssignedValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FEATURE_CALL_STATEMENT__ASSIGNED_VALUE, newAssignedValue, newAssignedValue));
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
      case AstPackage.FEATURE_CALL_STATEMENT__ASSIGNED_VALUE:
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
      case AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL:
        return getFeatureCall();
      case AstPackage.FEATURE_CALL_STATEMENT__ASSIGNED_VALUE:
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
      case AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL:
        setFeatureCall((Expression)newValue);
        return;
      case AstPackage.FEATURE_CALL_STATEMENT__ASSIGNED_VALUE:
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
      case AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL:
        setFeatureCall((Expression)null);
        return;
      case AstPackage.FEATURE_CALL_STATEMENT__ASSIGNED_VALUE:
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
      case AstPackage.FEATURE_CALL_STATEMENT__FEATURE_CALL:
        return featureCall != null;
      case AstPackage.FEATURE_CALL_STATEMENT__ASSIGNED_VALUE:
        return assignedValue != null;
    }
    return super.eIsSet(featureID);
  }

} //FeatureCallStatementImpl

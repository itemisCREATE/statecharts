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

import org.yakindu.sct.statechart.expressions.AssignmentOperator;
import org.yakindu.sct.statechart.expressions.ConditionalExpression;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;
import org.yakindu.sct.statechart.expressions.VariableAssignment;
import org.yakindu.sct.statechart.expressions.VariableReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.VariableAssignmentImpl#getVariableReference <em>Variable Reference</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.VariableAssignmentImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.VariableAssignmentImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableAssignmentImpl extends StatementImpl implements VariableAssignment
{
  /**
   * The cached value of the '{@link #getVariableReference() <em>Variable Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariableReference()
   * @generated
   * @ordered
   */
  protected VariableReference variableReference;

  /**
   * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected static final AssignmentOperator OPERATOR_EDEFAULT = AssignmentOperator.ASSIGN;

  /**
   * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperator()
   * @generated
   * @ordered
   */
  protected AssignmentOperator operator = OPERATOR_EDEFAULT;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected ConditionalExpression value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableAssignmentImpl()
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
    return ExpressionsPackage.Literals.VARIABLE_ASSIGNMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableReference getVariableReference()
  {
    return variableReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVariableReference(VariableReference newVariableReference, NotificationChain msgs)
  {
    VariableReference oldVariableReference = variableReference;
    variableReference = newVariableReference;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE, oldVariableReference, newVariableReference);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVariableReference(VariableReference newVariableReference)
  {
    if (newVariableReference != variableReference)
    {
      NotificationChain msgs = null;
      if (variableReference != null)
        msgs = ((InternalEObject)variableReference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE, null, msgs);
      if (newVariableReference != null)
        msgs = ((InternalEObject)newVariableReference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE, null, msgs);
      msgs = basicSetVariableReference(newVariableReference, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE, newVariableReference, newVariableReference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentOperator getOperator()
  {
    return operator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperator(AssignmentOperator newOperator)
  {
    AssignmentOperator oldOperator = operator;
    operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_ASSIGNMENT__OPERATOR, oldOperator, operator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConditionalExpression getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(ConditionalExpression newValue, NotificationChain msgs)
  {
    ConditionalExpression oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_ASSIGNMENT__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(ConditionalExpression newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.VARIABLE_ASSIGNMENT__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.VARIABLE_ASSIGNMENT__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.VARIABLE_ASSIGNMENT__VALUE, newValue, newValue));
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
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE:
        return basicSetVariableReference(null, msgs);
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__VALUE:
        return basicSetValue(null, msgs);
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
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE:
        return getVariableReference();
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__OPERATOR:
        return getOperator();
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__VALUE:
        return getValue();
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
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE:
        setVariableReference((VariableReference)newValue);
        return;
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__OPERATOR:
        setOperator((AssignmentOperator)newValue);
        return;
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__VALUE:
        setValue((ConditionalExpression)newValue);
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
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE:
        setVariableReference((VariableReference)null);
        return;
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__OPERATOR:
        setOperator(OPERATOR_EDEFAULT);
        return;
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__VALUE:
        setValue((ConditionalExpression)null);
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
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__VARIABLE_REFERENCE:
        return variableReference != null;
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__OPERATOR:
        return operator != OPERATOR_EDEFAULT;
      case ExpressionsPackage.VARIABLE_ASSIGNMENT__VALUE:
        return value != null;
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
    result.append(" (operator: ");
    result.append(operator);
    result.append(')');
    return result.toString();
  }

} //VariableAssignmentImpl

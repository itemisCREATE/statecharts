/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.damos.scripting.mscript.Expression;
import org.eclipselabs.damos.scripting.mscript.LogicalOrExpression;
import org.eclipselabs.damos.scripting.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Or Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.LogicalOrExpressionImpl#getOperands <em>Operands</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogicalOrExpressionImpl extends ExpressionImpl implements LogicalOrExpression
{
  /**
   * The cached value of the '{@link #getOperands() <em>Operands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperands()
   * @generated
   * @ordered
   */
  protected EList<Expression> operands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LogicalOrExpressionImpl()
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
    return MscriptPackage.Literals.LOGICAL_OR_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getOperands()
  {
    if (operands == null)
    {
      operands = new EObjectContainmentEList<Expression>(Expression.class, this, MscriptPackage.LOGICAL_OR_EXPRESSION__OPERANDS);
    }
    return operands;
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
      case MscriptPackage.LOGICAL_OR_EXPRESSION__OPERANDS:
        return ((InternalEList<?>)getOperands()).basicRemove(otherEnd, msgs);
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
      case MscriptPackage.LOGICAL_OR_EXPRESSION__OPERANDS:
        return getOperands();
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
      case MscriptPackage.LOGICAL_OR_EXPRESSION__OPERANDS:
        getOperands().clear();
        getOperands().addAll((Collection<? extends Expression>)newValue);
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
      case MscriptPackage.LOGICAL_OR_EXPRESSION__OPERANDS:
        getOperands().clear();
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
      case MscriptPackage.LOGICAL_OR_EXPRESSION__OPERANDS:
        return operands != null && !operands.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //LogicalOrExpressionImpl

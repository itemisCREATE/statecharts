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

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.damos.scripting.mscript.AddSubtractExpression;
import org.eclipselabs.damos.scripting.mscript.AddSubtractOperator;
import org.eclipselabs.damos.scripting.mscript.Expression;
import org.eclipselabs.damos.scripting.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Subtract Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.AddSubtractExpressionImpl#getOperands <em>Operands</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.AddSubtractExpressionImpl#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AddSubtractExpressionImpl extends ExpressionImpl implements AddSubtractExpression
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
   * The cached value of the '{@link #getOperators() <em>Operators</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperators()
   * @generated
   * @ordered
   */
  protected EList<AddSubtractOperator> operators;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AddSubtractExpressionImpl()
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
    return MscriptPackage.Literals.ADD_SUBTRACT_EXPRESSION;
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
      operands = new EObjectContainmentEList<Expression>(Expression.class, this, MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERANDS);
    }
    return operands;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AddSubtractOperator> getOperators()
  {
    if (operators == null)
    {
      operators = new EDataTypeEList<AddSubtractOperator>(AddSubtractOperator.class, this, MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERATORS);
    }
    return operators;
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
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERANDS:
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
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERANDS:
        return getOperands();
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERATORS:
        return getOperators();
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
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERANDS:
        getOperands().clear();
        getOperands().addAll((Collection<? extends Expression>)newValue);
        return;
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERATORS:
        getOperators().clear();
        getOperators().addAll((Collection<? extends AddSubtractOperator>)newValue);
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
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERANDS:
        getOperands().clear();
        return;
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERATORS:
        getOperators().clear();
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
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERANDS:
        return operands != null && !operands.isEmpty();
      case MscriptPackage.ADD_SUBTRACT_EXPRESSION__OPERATORS:
        return operators != null && !operators.isEmpty();
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
    result.append(" (operators: ");
    result.append(operators);
    result.append(')');
    return result.toString();
  }

} //AddSubtractExpressionImpl

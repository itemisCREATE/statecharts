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

import org.eclipselabs.damos.scripting.mscript.ExpressionList;
import org.eclipselabs.damos.scripting.mscript.MatrixConstructionOperator;
import org.eclipselabs.damos.scripting.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Matrix Construction Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.MatrixConstructionOperatorImpl#getExpressionLists <em>Expression Lists</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MatrixConstructionOperatorImpl extends ExpressionImpl implements MatrixConstructionOperator
{
  /**
   * The cached value of the '{@link #getExpressionLists() <em>Expression Lists</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionLists()
   * @generated
   * @ordered
   */
  protected EList<ExpressionList> expressionLists;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MatrixConstructionOperatorImpl()
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
    return MscriptPackage.Literals.MATRIX_CONSTRUCTION_OPERATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExpressionList> getExpressionLists()
  {
    if (expressionLists == null)
    {
      expressionLists = new EObjectContainmentEList<ExpressionList>(ExpressionList.class, this, MscriptPackage.MATRIX_CONSTRUCTION_OPERATOR__EXPRESSION_LISTS);
    }
    return expressionLists;
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
      case MscriptPackage.MATRIX_CONSTRUCTION_OPERATOR__EXPRESSION_LISTS:
        return ((InternalEList<?>)getExpressionLists()).basicRemove(otherEnd, msgs);
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
      case MscriptPackage.MATRIX_CONSTRUCTION_OPERATOR__EXPRESSION_LISTS:
        return getExpressionLists();
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
      case MscriptPackage.MATRIX_CONSTRUCTION_OPERATOR__EXPRESSION_LISTS:
        getExpressionLists().clear();
        getExpressionLists().addAll((Collection<? extends ExpressionList>)newValue);
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
      case MscriptPackage.MATRIX_CONSTRUCTION_OPERATOR__EXPRESSION_LISTS:
        getExpressionLists().clear();
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
      case MscriptPackage.MATRIX_CONSTRUCTION_OPERATOR__EXPRESSION_LISTS:
        return expressionLists != null && !expressionLists.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //MatrixConstructionOperatorImpl

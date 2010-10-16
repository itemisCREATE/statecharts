/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Additive Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionImpl#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionImpl#getRightParts <em>Right Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AdditiveExpressionImpl extends ExpressionImpl implements AdditiveExpression
{
  /**
   * The cached value of the '{@link #getLeftOperand() <em>Left Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLeftOperand()
   * @generated
   * @ordered
   */
  protected Expression leftOperand;

  /**
   * The cached value of the '{@link #getRightParts() <em>Right Parts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRightParts()
   * @generated
   * @ordered
   */
  protected EList<AdditiveExpressionPart> rightParts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AdditiveExpressionImpl()
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
    return AstPackage.Literals.ADDITIVE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getLeftOperand()
  {
    return leftOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLeftOperand(Expression newLeftOperand, NotificationChain msgs)
  {
    Expression oldLeftOperand = leftOperand;
    leftOperand = newLeftOperand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ADDITIVE_EXPRESSION__LEFT_OPERAND, oldLeftOperand, newLeftOperand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLeftOperand(Expression newLeftOperand)
  {
    if (newLeftOperand != leftOperand)
    {
      NotificationChain msgs = null;
      if (leftOperand != null)
        msgs = ((InternalEObject)leftOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ADDITIVE_EXPRESSION__LEFT_OPERAND, null, msgs);
      if (newLeftOperand != null)
        msgs = ((InternalEObject)newLeftOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ADDITIVE_EXPRESSION__LEFT_OPERAND, null, msgs);
      msgs = basicSetLeftOperand(newLeftOperand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ADDITIVE_EXPRESSION__LEFT_OPERAND, newLeftOperand, newLeftOperand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AdditiveExpressionPart> getRightParts()
  {
    if (rightParts == null)
    {
      rightParts = new EObjectContainmentEList<AdditiveExpressionPart>(AdditiveExpressionPart.class, this, AstPackage.ADDITIVE_EXPRESSION__RIGHT_PARTS);
    }
    return rightParts;
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
      case AstPackage.ADDITIVE_EXPRESSION__LEFT_OPERAND:
        return basicSetLeftOperand(null, msgs);
      case AstPackage.ADDITIVE_EXPRESSION__RIGHT_PARTS:
        return ((InternalEList<?>)getRightParts()).basicRemove(otherEnd, msgs);
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
      case AstPackage.ADDITIVE_EXPRESSION__LEFT_OPERAND:
        return getLeftOperand();
      case AstPackage.ADDITIVE_EXPRESSION__RIGHT_PARTS:
        return getRightParts();
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
      case AstPackage.ADDITIVE_EXPRESSION__LEFT_OPERAND:
        setLeftOperand((Expression)newValue);
        return;
      case AstPackage.ADDITIVE_EXPRESSION__RIGHT_PARTS:
        getRightParts().clear();
        getRightParts().addAll((Collection<? extends AdditiveExpressionPart>)newValue);
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
      case AstPackage.ADDITIVE_EXPRESSION__LEFT_OPERAND:
        setLeftOperand((Expression)null);
        return;
      case AstPackage.ADDITIVE_EXPRESSION__RIGHT_PARTS:
        getRightParts().clear();
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
      case AstPackage.ADDITIVE_EXPRESSION__LEFT_OPERAND:
        return leftOperand != null;
      case AstPackage.ADDITIVE_EXPRESSION__RIGHT_PARTS:
        return rightParts != null && !rightParts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AdditiveExpressionImpl

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
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.language.ast.UnitExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Construction Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.UnitConstructionOperatorImpl#getUnitExpression <em>Unit Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitConstructionOperatorImpl extends ExpressionImpl implements UnitConstructionOperator
{
  /**
   * The cached value of the '{@link #getUnitExpression() <em>Unit Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnitExpression()
   * @generated
   * @ordered
   */
  protected UnitExpression unitExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnitConstructionOperatorImpl()
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
    return AstPackage.Literals.UNIT_CONSTRUCTION_OPERATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpression getUnitExpression()
  {
    return unitExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnitExpression(UnitExpression newUnitExpression, NotificationChain msgs)
  {
    UnitExpression oldUnitExpression = unitExpression;
    unitExpression = newUnitExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION, oldUnitExpression, newUnitExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnitExpression(UnitExpression newUnitExpression)
  {
    if (newUnitExpression != unitExpression)
    {
      NotificationChain msgs = null;
      if (unitExpression != null)
        msgs = ((InternalEObject)unitExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION, null, msgs);
      if (newUnitExpression != null)
        msgs = ((InternalEObject)newUnitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION, null, msgs);
      msgs = basicSetUnitExpression(newUnitExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION, newUnitExpression, newUnitExpression));
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
      case AstPackage.UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION:
        return basicSetUnitExpression(null, msgs);
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
      case AstPackage.UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION:
        return getUnitExpression();
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
      case AstPackage.UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION:
        setUnitExpression((UnitExpression)newValue);
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
      case AstPackage.UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION:
        setUnitExpression((UnitExpression)null);
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
      case AstPackage.UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION:
        return unitExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //UnitConstructionOperatorImpl

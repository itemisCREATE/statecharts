/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.UnitExpressionFactor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Expression Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionFactorImpl#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionFactorImpl#getExponent <em>Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitExpressionFactorImpl extends MinimalEObjectImpl.Container implements UnitExpressionFactor
{
  /**
   * The default value of the '{@link #getOperand() <em>Operand</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand()
   * @generated
   * @ordered
   */
  protected static final String OPERAND_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOperand() <em>Operand</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperand()
   * @generated
   * @ordered
   */
  protected String operand = OPERAND_EDEFAULT;

  /**
   * The default value of the '{@link #getExponent() <em>Exponent</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExponent()
   * @generated
   * @ordered
   */
  protected static final int EXPONENT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getExponent() <em>Exponent</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExponent()
   * @generated
   * @ordered
   */
  protected int exponent = EXPONENT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnitExpressionFactorImpl()
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
    return AstPackage.Literals.UNIT_EXPRESSION_FACTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOperand()
  {
    return operand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperand(String newOperand)
  {
    String oldOperand = operand;
    operand = newOperand;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_EXPRESSION_FACTOR__OPERAND, oldOperand, operand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getExponent()
  {
    return exponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExponent(int newExponent)
  {
    int oldExponent = exponent;
    exponent = newExponent;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_EXPRESSION_FACTOR__EXPONENT, oldExponent, exponent));
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
      case AstPackage.UNIT_EXPRESSION_FACTOR__OPERAND:
        return getOperand();
      case AstPackage.UNIT_EXPRESSION_FACTOR__EXPONENT:
        return getExponent();
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
      case AstPackage.UNIT_EXPRESSION_FACTOR__OPERAND:
        setOperand((String)newValue);
        return;
      case AstPackage.UNIT_EXPRESSION_FACTOR__EXPONENT:
        setExponent((Integer)newValue);
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
      case AstPackage.UNIT_EXPRESSION_FACTOR__OPERAND:
        setOperand(OPERAND_EDEFAULT);
        return;
      case AstPackage.UNIT_EXPRESSION_FACTOR__EXPONENT:
        setExponent(EXPONENT_EDEFAULT);
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
      case AstPackage.UNIT_EXPRESSION_FACTOR__OPERAND:
        return OPERAND_EDEFAULT == null ? operand != null : !OPERAND_EDEFAULT.equals(operand);
      case AstPackage.UNIT_EXPRESSION_FACTOR__EXPONENT:
        return exponent != EXPONENT_EDEFAULT;
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
    result.append(" (operand: ");
    result.append(operand);
    result.append(", exponent: ");
    result.append(exponent);
    result.append(')');
    return result.toString();
  }

} //UnitExpressionFactorImpl

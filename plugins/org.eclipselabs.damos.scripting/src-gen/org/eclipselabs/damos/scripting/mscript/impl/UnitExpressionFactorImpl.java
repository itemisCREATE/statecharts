/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipselabs.damos.scripting.mscript.MscriptPackage;
import org.eclipselabs.damos.scripting.mscript.UnitExpressionExponent;
import org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Expression Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionFactorImpl#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionFactorImpl#getExponent <em>Exponent</em>}</li>
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
   * The cached value of the '{@link #getExponent() <em>Exponent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExponent()
   * @generated
   * @ordered
   */
  protected UnitExpressionExponent exponent;

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
    return MscriptPackage.Literals.UNIT_EXPRESSION_FACTOR;
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
      eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.UNIT_EXPRESSION_FACTOR__OPERAND, oldOperand, operand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpressionExponent getExponent()
  {
    return exponent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExponent(UnitExpressionExponent newExponent, NotificationChain msgs)
  {
    UnitExpressionExponent oldExponent = exponent;
    exponent = newExponent;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MscriptPackage.UNIT_EXPRESSION_FACTOR__EXPONENT, oldExponent, newExponent);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExponent(UnitExpressionExponent newExponent)
  {
    if (newExponent != exponent)
    {
      NotificationChain msgs = null;
      if (exponent != null)
        msgs = ((InternalEObject)exponent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.UNIT_EXPRESSION_FACTOR__EXPONENT, null, msgs);
      if (newExponent != null)
        msgs = ((InternalEObject)newExponent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MscriptPackage.UNIT_EXPRESSION_FACTOR__EXPONENT, null, msgs);
      msgs = basicSetExponent(newExponent, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.UNIT_EXPRESSION_FACTOR__EXPONENT, newExponent, newExponent));
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
      case MscriptPackage.UNIT_EXPRESSION_FACTOR__EXPONENT:
        return basicSetExponent(null, msgs);
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
      case MscriptPackage.UNIT_EXPRESSION_FACTOR__OPERAND:
        return getOperand();
      case MscriptPackage.UNIT_EXPRESSION_FACTOR__EXPONENT:
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
      case MscriptPackage.UNIT_EXPRESSION_FACTOR__OPERAND:
        setOperand((String)newValue);
        return;
      case MscriptPackage.UNIT_EXPRESSION_FACTOR__EXPONENT:
        setExponent((UnitExpressionExponent)newValue);
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
      case MscriptPackage.UNIT_EXPRESSION_FACTOR__OPERAND:
        setOperand(OPERAND_EDEFAULT);
        return;
      case MscriptPackage.UNIT_EXPRESSION_FACTOR__EXPONENT:
        setExponent((UnitExpressionExponent)null);
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
      case MscriptPackage.UNIT_EXPRESSION_FACTOR__OPERAND:
        return OPERAND_EDEFAULT == null ? operand != null : !OPERAND_EDEFAULT.equals(operand);
      case MscriptPackage.UNIT_EXPRESSION_FACTOR__EXPONENT:
        return exponent != null;
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
    result.append(')');
    return result.toString();
  }

} //UnitExpressionFactorImpl

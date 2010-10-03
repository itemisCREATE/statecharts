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
import org.eclipselabs.mscript.language.ast.NumericalLiteral;
import org.eclipselabs.mscript.language.ast.UnitExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numerical Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.NumericalLiteralImpl#isImaginary <em>Imaginary</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.NumericalLiteralImpl#getUnit <em>Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumericalLiteralImpl extends LiteralImpl implements NumericalLiteral
{
  /**
   * The default value of the '{@link #isImaginary() <em>Imaginary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isImaginary()
   * @generated
   * @ordered
   */
  protected static final boolean IMAGINARY_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isImaginary() <em>Imaginary</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isImaginary()
   * @generated
   * @ordered
   */
  protected boolean imaginary = IMAGINARY_EDEFAULT;

  /**
   * The cached value of the '{@link #getUnit() <em>Unit</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUnit()
   * @generated
   * @ordered
   */
  protected UnitExpression unit;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NumericalLiteralImpl()
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
    return AstPackage.Literals.NUMERICAL_LITERAL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isImaginary()
  {
    return imaginary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImaginary(boolean newImaginary)
  {
    boolean oldImaginary = imaginary;
    imaginary = newImaginary;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.NUMERICAL_LITERAL__IMAGINARY, oldImaginary, imaginary));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpression getUnit()
  {
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetUnit(UnitExpression newUnit, NotificationChain msgs)
  {
    UnitExpression oldUnit = unit;
    unit = newUnit;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.NUMERICAL_LITERAL__UNIT, oldUnit, newUnit);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnit(UnitExpression newUnit)
  {
    if (newUnit != unit)
    {
      NotificationChain msgs = null;
      if (unit != null)
        msgs = ((InternalEObject)unit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.NUMERICAL_LITERAL__UNIT, null, msgs);
      if (newUnit != null)
        msgs = ((InternalEObject)newUnit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.NUMERICAL_LITERAL__UNIT, null, msgs);
      msgs = basicSetUnit(newUnit, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.NUMERICAL_LITERAL__UNIT, newUnit, newUnit));
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
      case AstPackage.NUMERICAL_LITERAL__UNIT:
        return basicSetUnit(null, msgs);
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
      case AstPackage.NUMERICAL_LITERAL__IMAGINARY:
        return isImaginary();
      case AstPackage.NUMERICAL_LITERAL__UNIT:
        return getUnit();
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
      case AstPackage.NUMERICAL_LITERAL__IMAGINARY:
        setImaginary((Boolean)newValue);
        return;
      case AstPackage.NUMERICAL_LITERAL__UNIT:
        setUnit((UnitExpression)newValue);
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
      case AstPackage.NUMERICAL_LITERAL__IMAGINARY:
        setImaginary(IMAGINARY_EDEFAULT);
        return;
      case AstPackage.NUMERICAL_LITERAL__UNIT:
        setUnit((UnitExpression)null);
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
      case AstPackage.NUMERICAL_LITERAL__IMAGINARY:
        return imaginary != IMAGINARY_EDEFAULT;
      case AstPackage.NUMERICAL_LITERAL__UNIT:
        return unit != null;
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
    result.append(" (imaginary: ");
    result.append(imaginary);
    result.append(')');
    return result.toString();
  }

} //NumericalLiteralImpl

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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.UnitExpression;
import org.eclipselabs.mscript.language.ast.UnitExpressionDenominator;
import org.eclipselabs.mscript.language.ast.UnitExpressionNumerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl#isUnspecified <em>Unspecified</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl#getNumerator <em>Numerator</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl#getDenominator <em>Denominator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitExpressionImpl extends MinimalEObjectImpl.Container implements UnitExpression
{
  /**
   * The default value of the '{@link #isUnspecified() <em>Unspecified</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnspecified()
   * @generated
   * @ordered
   */
  protected static final boolean UNSPECIFIED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUnspecified() <em>Unspecified</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUnspecified()
   * @generated
   * @ordered
   */
  protected boolean unspecified = UNSPECIFIED_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpression()
   * @generated
   * @ordered
   */
  protected Expression expression;

  /**
   * The cached value of the '{@link #getNumerator() <em>Numerator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNumerator()
   * @generated
   * @ordered
   */
  protected UnitExpressionNumerator numerator;

  /**
   * The cached value of the '{@link #getDenominator() <em>Denominator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDenominator()
   * @generated
   * @ordered
   */
  protected UnitExpressionDenominator denominator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnitExpressionImpl()
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
    return AstPackage.Literals.UNIT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUnspecified()
  {
    return unspecified;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUnspecified(boolean newUnspecified)
  {
    boolean oldUnspecified = unspecified;
    unspecified = newUnspecified;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_EXPRESSION__UNSPECIFIED, oldUnspecified, unspecified));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getExpression()
  {
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
    Expression oldExpression = expression;
    expression = newExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_EXPRESSION__EXPRESSION, oldExpression, newExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpression(Expression newExpression)
  {
    if (newExpression != expression)
    {
      NotificationChain msgs = null;
      if (expression != null)
        msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.UNIT_EXPRESSION__EXPRESSION, null, msgs);
      if (newExpression != null)
        msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.UNIT_EXPRESSION__EXPRESSION, null, msgs);
      msgs = basicSetExpression(newExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_EXPRESSION__EXPRESSION, newExpression, newExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpressionNumerator getNumerator()
  {
    return numerator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNumerator(UnitExpressionNumerator newNumerator, NotificationChain msgs)
  {
    UnitExpressionNumerator oldNumerator = numerator;
    numerator = newNumerator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_EXPRESSION__NUMERATOR, oldNumerator, newNumerator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setNumerator(UnitExpressionNumerator newNumerator)
  {
    if (newNumerator != numerator)
    {
      NotificationChain msgs = null;
      if (numerator != null)
        msgs = ((InternalEObject)numerator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.UNIT_EXPRESSION__NUMERATOR, null, msgs);
      if (newNumerator != null)
        msgs = ((InternalEObject)newNumerator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.UNIT_EXPRESSION__NUMERATOR, null, msgs);
      msgs = basicSetNumerator(newNumerator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_EXPRESSION__NUMERATOR, newNumerator, newNumerator));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitExpressionDenominator getDenominator()
  {
    return denominator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDenominator(UnitExpressionDenominator newDenominator, NotificationChain msgs)
  {
    UnitExpressionDenominator oldDenominator = denominator;
    denominator = newDenominator;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_EXPRESSION__DENOMINATOR, oldDenominator, newDenominator);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDenominator(UnitExpressionDenominator newDenominator)
  {
    if (newDenominator != denominator)
    {
      NotificationChain msgs = null;
      if (denominator != null)
        msgs = ((InternalEObject)denominator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.UNIT_EXPRESSION__DENOMINATOR, null, msgs);
      if (newDenominator != null)
        msgs = ((InternalEObject)newDenominator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.UNIT_EXPRESSION__DENOMINATOR, null, msgs);
      msgs = basicSetDenominator(newDenominator, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.UNIT_EXPRESSION__DENOMINATOR, newDenominator, newDenominator));
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
      case AstPackage.UNIT_EXPRESSION__EXPRESSION:
        return basicSetExpression(null, msgs);
      case AstPackage.UNIT_EXPRESSION__NUMERATOR:
        return basicSetNumerator(null, msgs);
      case AstPackage.UNIT_EXPRESSION__DENOMINATOR:
        return basicSetDenominator(null, msgs);
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
      case AstPackage.UNIT_EXPRESSION__UNSPECIFIED:
        return isUnspecified();
      case AstPackage.UNIT_EXPRESSION__EXPRESSION:
        return getExpression();
      case AstPackage.UNIT_EXPRESSION__NUMERATOR:
        return getNumerator();
      case AstPackage.UNIT_EXPRESSION__DENOMINATOR:
        return getDenominator();
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
      case AstPackage.UNIT_EXPRESSION__UNSPECIFIED:
        setUnspecified((Boolean)newValue);
        return;
      case AstPackage.UNIT_EXPRESSION__EXPRESSION:
        setExpression((Expression)newValue);
        return;
      case AstPackage.UNIT_EXPRESSION__NUMERATOR:
        setNumerator((UnitExpressionNumerator)newValue);
        return;
      case AstPackage.UNIT_EXPRESSION__DENOMINATOR:
        setDenominator((UnitExpressionDenominator)newValue);
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
      case AstPackage.UNIT_EXPRESSION__UNSPECIFIED:
        setUnspecified(UNSPECIFIED_EDEFAULT);
        return;
      case AstPackage.UNIT_EXPRESSION__EXPRESSION:
        setExpression((Expression)null);
        return;
      case AstPackage.UNIT_EXPRESSION__NUMERATOR:
        setNumerator((UnitExpressionNumerator)null);
        return;
      case AstPackage.UNIT_EXPRESSION__DENOMINATOR:
        setDenominator((UnitExpressionDenominator)null);
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
      case AstPackage.UNIT_EXPRESSION__UNSPECIFIED:
        return unspecified != UNSPECIFIED_EDEFAULT;
      case AstPackage.UNIT_EXPRESSION__EXPRESSION:
        return expression != null;
      case AstPackage.UNIT_EXPRESSION__NUMERATOR:
        return numerator != null;
      case AstPackage.UNIT_EXPRESSION__DENOMINATOR:
        return denominator != null;
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
    result.append(" (unspecified: ");
    result.append(unspecified);
    result.append(')');
    return result.toString();
  }

} //UnitExpressionImpl

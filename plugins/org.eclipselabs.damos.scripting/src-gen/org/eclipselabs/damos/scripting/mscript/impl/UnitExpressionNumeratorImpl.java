/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.damos.scripting.mscript.MscriptPackage;
import org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor;
import org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Expression Numerator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionNumeratorImpl#getOne <em>One</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionNumeratorImpl#getFactors <em>Factors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitExpressionNumeratorImpl extends MinimalEObjectImpl.Container implements UnitExpressionNumerator
{
  /**
   * The default value of the '{@link #getOne() <em>One</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOne()
   * @generated
   * @ordered
   */
  protected static final long ONE_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getOne() <em>One</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOne()
   * @generated
   * @ordered
   */
  protected long one = ONE_EDEFAULT;

  /**
   * The cached value of the '{@link #getFactors() <em>Factors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFactors()
   * @generated
   * @ordered
   */
  protected EList<UnitExpressionFactor> factors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UnitExpressionNumeratorImpl()
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
    return MscriptPackage.Literals.UNIT_EXPRESSION_NUMERATOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getOne()
  {
    return one;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOne(long newOne)
  {
    long oldOne = one;
    one = newOne;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, MscriptPackage.UNIT_EXPRESSION_NUMERATOR__ONE, oldOne, one));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<UnitExpressionFactor> getFactors()
  {
    if (factors == null)
    {
      factors = new EObjectContainmentEList<UnitExpressionFactor>(UnitExpressionFactor.class, this, MscriptPackage.UNIT_EXPRESSION_NUMERATOR__FACTORS);
    }
    return factors;
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
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR__FACTORS:
        return ((InternalEList<?>)getFactors()).basicRemove(otherEnd, msgs);
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
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR__ONE:
        return getOne();
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR__FACTORS:
        return getFactors();
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
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR__ONE:
        setOne((Long)newValue);
        return;
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR__FACTORS:
        getFactors().clear();
        getFactors().addAll((Collection<? extends UnitExpressionFactor>)newValue);
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
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR__ONE:
        setOne(ONE_EDEFAULT);
        return;
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR__FACTORS:
        getFactors().clear();
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
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR__ONE:
        return one != ONE_EDEFAULT;
      case MscriptPackage.UNIT_EXPRESSION_NUMERATOR__FACTORS:
        return factors != null && !factors.isEmpty();
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
    result.append(" (one: ");
    result.append(one);
    result.append(')');
    return result.toString();
  }

} //UnitExpressionNumeratorImpl

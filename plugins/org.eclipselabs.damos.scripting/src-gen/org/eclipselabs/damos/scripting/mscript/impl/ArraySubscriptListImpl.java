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

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.damos.scripting.mscript.ArraySubscriptList;
import org.eclipselabs.damos.scripting.mscript.MscriptPackage;
import org.eclipselabs.damos.scripting.mscript.Subscript;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Subscript List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.impl.ArraySubscriptListImpl#getSubscripts <em>Subscripts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArraySubscriptListImpl extends MinimalEObjectImpl.Container implements ArraySubscriptList
{
  /**
   * The cached value of the '{@link #getSubscripts() <em>Subscripts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSubscripts()
   * @generated
   * @ordered
   */
  protected EList<Subscript> subscripts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArraySubscriptListImpl()
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
    return MscriptPackage.Literals.ARRAY_SUBSCRIPT_LIST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Subscript> getSubscripts()
  {
    if (subscripts == null)
    {
      subscripts = new EObjectContainmentEList<Subscript>(Subscript.class, this, MscriptPackage.ARRAY_SUBSCRIPT_LIST__SUBSCRIPTS);
    }
    return subscripts;
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
      case MscriptPackage.ARRAY_SUBSCRIPT_LIST__SUBSCRIPTS:
        return ((InternalEList<?>)getSubscripts()).basicRemove(otherEnd, msgs);
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
      case MscriptPackage.ARRAY_SUBSCRIPT_LIST__SUBSCRIPTS:
        return getSubscripts();
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
      case MscriptPackage.ARRAY_SUBSCRIPT_LIST__SUBSCRIPTS:
        getSubscripts().clear();
        getSubscripts().addAll((Collection<? extends Subscript>)newValue);
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
      case MscriptPackage.ARRAY_SUBSCRIPT_LIST__SUBSCRIPTS:
        getSubscripts().clear();
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
      case MscriptPackage.ARRAY_SUBSCRIPT_LIST__SUBSCRIPTS:
        return subscripts != null && !subscripts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ArraySubscriptListImpl

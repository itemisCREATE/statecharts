/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipselabs.mscript.language.ast.ArrayElementReference;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Subscript;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Element Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ArrayElementReferenceImpl#getSubscripts <em>Subscripts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayElementReferenceImpl extends FeatureCallPartImpl implements ArrayElementReference
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
  protected ArrayElementReferenceImpl()
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
    return AstPackage.Literals.ARRAY_ELEMENT_REFERENCE;
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
      subscripts = new EObjectContainmentEList<Subscript>(Subscript.class, this, AstPackage.ARRAY_ELEMENT_REFERENCE__SUBSCRIPTS);
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
      case AstPackage.ARRAY_ELEMENT_REFERENCE__SUBSCRIPTS:
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
      case AstPackage.ARRAY_ELEMENT_REFERENCE__SUBSCRIPTS:
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
      case AstPackage.ARRAY_ELEMENT_REFERENCE__SUBSCRIPTS:
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
      case AstPackage.ARRAY_ELEMENT_REFERENCE__SUBSCRIPTS:
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
      case AstPackage.ARRAY_ELEMENT_REFERENCE__SUBSCRIPTS:
        return subscripts != null && !subscripts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ArrayElementReferenceImpl

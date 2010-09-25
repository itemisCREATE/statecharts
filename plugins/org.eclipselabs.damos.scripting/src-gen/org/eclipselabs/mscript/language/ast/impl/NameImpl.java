/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Name;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.NameImpl#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NameImpl extends MinimalEObjectImpl.Container implements Name
{
  /**
   * The cached value of the '{@link #getIdentifiers() <em>Identifiers</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIdentifiers()
   * @generated
   * @ordered
   */
  protected EList<String> identifiers;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NameImpl()
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
    return AstPackage.Literals.NAME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getIdentifiers()
  {
    if (identifiers == null)
    {
      identifiers = new EDataTypeEList<String>(String.class, this, AstPackage.NAME__IDENTIFIERS);
    }
    return identifiers;
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
      case AstPackage.NAME__IDENTIFIERS:
        return getIdentifiers();
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
      case AstPackage.NAME__IDENTIFIERS:
        getIdentifiers().clear();
        getIdentifiers().addAll((Collection<? extends String>)newValue);
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
      case AstPackage.NAME__IDENTIFIERS:
        getIdentifiers().clear();
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
      case AstPackage.NAME__IDENTIFIERS:
        return identifiers != null && !identifiers.isEmpty();
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
    result.append(" (identifiers: ");
    result.append(identifiers);
    result.append(')');
    return result.toString();
  }

} //NameImpl

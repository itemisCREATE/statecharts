/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.statechart.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.sct.statechart.expressions.DefinitionScope;
import org.yakindu.sct.statechart.expressions.ElementDefinition;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.ElementDefinitionImpl#getDefinitionScopes <em>Definition Scopes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementDefinitionImpl extends MinimalEObjectImpl.Container implements ElementDefinition
{
  /**
   * The cached value of the '{@link #getDefinitionScopes() <em>Definition Scopes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinitionScopes()
   * @generated
   * @ordered
   */
  protected EList<DefinitionScope> definitionScopes;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementDefinitionImpl()
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
    return ExpressionsPackage.Literals.ELEMENT_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DefinitionScope> getDefinitionScopes()
  {
    if (definitionScopes == null)
    {
      definitionScopes = new EObjectContainmentEList<DefinitionScope>(DefinitionScope.class, this, ExpressionsPackage.ELEMENT_DEFINITION__DEFINITION_SCOPES);
    }
    return definitionScopes;
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
      case ExpressionsPackage.ELEMENT_DEFINITION__DEFINITION_SCOPES:
        return ((InternalEList<?>)getDefinitionScopes()).basicRemove(otherEnd, msgs);
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
      case ExpressionsPackage.ELEMENT_DEFINITION__DEFINITION_SCOPES:
        return getDefinitionScopes();
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
      case ExpressionsPackage.ELEMENT_DEFINITION__DEFINITION_SCOPES:
        getDefinitionScopes().clear();
        getDefinitionScopes().addAll((Collection<? extends DefinitionScope>)newValue);
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
      case ExpressionsPackage.ELEMENT_DEFINITION__DEFINITION_SCOPES:
        getDefinitionScopes().clear();
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
      case ExpressionsPackage.ELEMENT_DEFINITION__DEFINITION_SCOPES:
        return definitionScopes != null && !definitionScopes.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ElementDefinitionImpl

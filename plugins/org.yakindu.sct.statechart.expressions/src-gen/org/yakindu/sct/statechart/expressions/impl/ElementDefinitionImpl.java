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

import org.yakindu.sct.statechart.expressions.ElementDefinition;
import org.yakindu.sct.statechart.expressions.EventDefinition;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;
import org.yakindu.sct.statechart.expressions.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.ElementDefinitionImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.ElementDefinitionImpl#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementDefinitionImpl extends MinimalEObjectImpl.Container implements ElementDefinition
{
  /**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected EList<VariableDefinition> variables;

  /**
   * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEvents()
   * @generated
   * @ordered
   */
  protected EList<EventDefinition> events;

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
  public EList<VariableDefinition> getVariables()
  {
    if (variables == null)
    {
      variables = new EObjectContainmentEList<VariableDefinition>(VariableDefinition.class, this, ExpressionsPackage.ELEMENT_DEFINITION__VARIABLES);
    }
    return variables;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EventDefinition> getEvents()
  {
    if (events == null)
    {
      events = new EObjectContainmentEList<EventDefinition>(EventDefinition.class, this, ExpressionsPackage.ELEMENT_DEFINITION__EVENTS);
    }
    return events;
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
      case ExpressionsPackage.ELEMENT_DEFINITION__VARIABLES:
        return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
      case ExpressionsPackage.ELEMENT_DEFINITION__EVENTS:
        return ((InternalEList<?>)getEvents()).basicRemove(otherEnd, msgs);
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
      case ExpressionsPackage.ELEMENT_DEFINITION__VARIABLES:
        return getVariables();
      case ExpressionsPackage.ELEMENT_DEFINITION__EVENTS:
        return getEvents();
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
      case ExpressionsPackage.ELEMENT_DEFINITION__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends VariableDefinition>)newValue);
        return;
      case ExpressionsPackage.ELEMENT_DEFINITION__EVENTS:
        getEvents().clear();
        getEvents().addAll((Collection<? extends EventDefinition>)newValue);
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
      case ExpressionsPackage.ELEMENT_DEFINITION__VARIABLES:
        getVariables().clear();
        return;
      case ExpressionsPackage.ELEMENT_DEFINITION__EVENTS:
        getEvents().clear();
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
      case ExpressionsPackage.ELEMENT_DEFINITION__VARIABLES:
        return variables != null && !variables.isEmpty();
      case ExpressionsPackage.ELEMENT_DEFINITION__EVENTS:
        return events != null && !events.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ElementDefinitionImpl

/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.ElementDefinition#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.ElementDefinition#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getElementDefinition()
 * @model
 * @generated
 */
public interface ElementDefinition extends EObject
{
  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.statechart.expressions.VariableDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getElementDefinition_Variables()
   * @model containment="true"
   * @generated
   */
  EList<VariableDefinition> getVariables();

  /**
   * Returns the value of the '<em><b>Events</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.statechart.expressions.EventDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Events</em>' containment reference list.
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getElementDefinition_Events()
   * @model containment="true"
   * @generated
   */
  EList<EventDefinition> getEvents();

} // ElementDefinition

/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.TransitionDefinition#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.TransitionDefinition#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getTransitionDefinition()
 * @model
 * @generated
 */
public interface TransitionDefinition extends Statement
{
  /**
   * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.statechart.expressions.Event}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Triggers</em>' containment reference list.
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getTransitionDefinition_Triggers()
   * @model containment="true"
   * @generated
   */
  EList<Event> getTriggers();

  /**
   * Returns the value of the '<em><b>Guard Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Guard Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Guard Expression</em>' containment reference.
   * @see #setGuardExpression(ExpressionRule)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getTransitionDefinition_GuardExpression()
   * @model containment="true"
   * @generated
   */
  ExpressionRule getGuardExpression();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.TransitionDefinition#getGuardExpression <em>Guard Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard Expression</em>' containment reference.
   * @see #getGuardExpression()
   * @generated
   */
  void setGuardExpression(ExpressionRule value);

} // TransitionDefinition

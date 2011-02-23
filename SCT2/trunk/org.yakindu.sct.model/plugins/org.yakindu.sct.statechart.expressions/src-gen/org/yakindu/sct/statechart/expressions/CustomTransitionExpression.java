/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.common.util.EList;

import org.yakindu.model.sct.statechart.Event;
import org.yakindu.model.sct.statechart.TransitionExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Transition Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getGuardExpression <em>Guard Expression</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getAction <em>Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getCustomTransitionExpression()
 * @model
 * @generated
 */
public interface CustomTransitionExpression extends TransitionExpression
{
  /**
   * Returns the value of the '<em><b>Triggers</b></em>' reference list.
   * The list contents are of type {@link org.yakindu.model.sct.statechart.Event}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Triggers</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Triggers</em>' reference list.
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getCustomTransitionExpression_Triggers()
   * @model
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
   * @see #setGuardExpression(Expression)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getCustomTransitionExpression_GuardExpression()
   * @model containment="true"
   * @generated
   */
  Expression getGuardExpression();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getGuardExpression <em>Guard Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Guard Expression</em>' containment reference.
   * @see #getGuardExpression()
   * @generated
   */
  void setGuardExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Action</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Action</em>' containment reference.
   * @see #setAction(ExpressionRule)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getCustomTransitionExpression_Action()
   * @model containment="true"
   * @generated
   */
  ExpressionRule getAction();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getAction <em>Action</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Action</em>' containment reference.
   * @see #getAction()
   * @generated
   */
  void setAction(ExpressionRule value);

} // CustomTransitionExpression

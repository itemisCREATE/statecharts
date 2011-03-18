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
 * A representation of the model object '<em><b>State Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.StateExpression#getEntryExpression <em>Entry Expression</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.StateExpression#getExitExpression <em>Exit Expression</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.StateExpression#getOntickExpression <em>Ontick Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getStateExpression()
 * @model
 * @generated
 */
public interface StateExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Entry Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.statechart.expressions.EntryExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entry Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entry Expression</em>' containment reference list.
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getStateExpression_EntryExpression()
   * @model containment="true"
   * @generated
   */
  EList<EntryExpression> getEntryExpression();

  /**
   * Returns the value of the '<em><b>Exit Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.statechart.expressions.ExitExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exit Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exit Expression</em>' containment reference list.
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getStateExpression_ExitExpression()
   * @model containment="true"
   * @generated
   */
  EList<ExitExpression> getExitExpression();

  /**
   * Returns the value of the '<em><b>Ontick Expression</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.statechart.expressions.OnTickExpression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ontick Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ontick Expression</em>' containment reference list.
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getStateExpression_OntickExpression()
   * @model containment="true"
   * @generated
   */
  EList<OnTickExpression> getOntickExpression();

} // StateExpression

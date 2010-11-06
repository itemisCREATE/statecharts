/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.UnaryExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.UnaryExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.yakindu.sct.statechart.expressions.UnaryOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.UnaryOperator
   * @see #setOperator(UnaryOperator)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getUnaryExpression_Operator()
   * @model
   * @generated
   */
  UnaryOperator getOperator();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.UnaryExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.UnaryOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(UnaryOperator value);

  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(PrimaryExpression)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getUnaryExpression_Operand()
   * @model containment="true"
   * @generated
   */
  PrimaryExpression getOperand();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.UnaryExpression#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(PrimaryExpression value);

} // UnaryExpression

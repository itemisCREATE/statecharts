/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shift Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.ShiftExpression#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.ShiftExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.ShiftExpression#getOperand2 <em>Operand2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getShiftExpression()
 * @model
 * @generated
 */
public interface ShiftExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand1</em>' containment reference.
   * @see #setOperand1(AdditiveExpression)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getShiftExpression_Operand1()
   * @model containment="true"
   * @generated
   */
  AdditiveExpression getOperand1();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.ShiftExpression#getOperand1 <em>Operand1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand1</em>' containment reference.
   * @see #getOperand1()
   * @generated
   */
  void setOperand1(AdditiveExpression value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.yakindu.sct.statechart.expressions.ShiftOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.ShiftOperator
   * @see #setOperator(ShiftOperator)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getShiftExpression_Operator()
   * @model
   * @generated
   */
  ShiftOperator getOperator();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.ShiftExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.ShiftOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(ShiftOperator value);

  /**
   * Returns the value of the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand2</em>' containment reference.
   * @see #setOperand2(AdditiveExpression)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getShiftExpression_Operand2()
   * @model containment="true"
   * @generated
   */
  AdditiveExpression getOperand2();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.ShiftExpression#getOperand2 <em>Operand2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand2</em>' containment reference.
   * @see #getOperand2()
   * @generated
   */
  void setOperand2(AdditiveExpression value);

} // ShiftExpression

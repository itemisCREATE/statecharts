/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bitwise And Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.BitwiseAndExpression#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.BitwiseAndExpression#getOperand2 <em>Operand2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getBitwiseAndExpression()
 * @model
 * @generated
 */
public interface BitwiseAndExpression extends EObject
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
   * @see #setOperand1(EqualityExpression)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getBitwiseAndExpression_Operand1()
   * @model containment="true"
   * @generated
   */
  EqualityExpression getOperand1();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.BitwiseAndExpression#getOperand1 <em>Operand1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand1</em>' containment reference.
   * @see #getOperand1()
   * @generated
   */
  void setOperand1(EqualityExpression value);

  /**
   * Returns the value of the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand2</em>' containment reference.
   * @see #setOperand2(EqualityExpression)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getBitwiseAndExpression_Operand2()
   * @model containment="true"
   * @generated
   */
  EqualityExpression getOperand2();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.BitwiseAndExpression#getOperand2 <em>Operand2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand2</em>' containment reference.
   * @see #getOperand2()
   * @generated
   */
  void setOperand2(EqualityExpression value);

} // BitwiseAndExpression

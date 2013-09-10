/**
 */
package org.yakindu.sct.model.stext.stext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bitwise Xor Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.BitwiseXorExpression#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.BitwiseXorExpression#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getBitwiseXorExpression()
 * @model
 * @generated
 */
public interface BitwiseXorExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Operand</em>' containment reference.
   * @see #setLeftOperand(Expression)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getBitwiseXorExpression_LeftOperand()
   * @model containment="true"
   * @generated
   */
  Expression getLeftOperand();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.BitwiseXorExpression#getLeftOperand <em>Left Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Operand</em>' containment reference.
   * @see #getLeftOperand()
   * @generated
   */
  void setLeftOperand(Expression value);

  /**
   * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Operand</em>' containment reference.
   * @see #setRightOperand(Expression)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getBitwiseXorExpression_RightOperand()
   * @model containment="true"
   * @generated
   */
  Expression getRightOperand();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.BitwiseXorExpression#getRightOperand <em>Right Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Operand</em>' containment reference.
   * @see #getRightOperand()
   * @generated
   */
  void setRightOperand(Expression value);

} // BitwiseXorExpression

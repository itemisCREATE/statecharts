/**
 */
package org.yakindu.sct.model.stext.stext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.NumericalUnaryExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.NumericalUnaryExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getNumericalUnaryExpression()
 * @model
 * @generated
 */
public interface NumericalUnaryExpression extends Expression
{
  /**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.sct.model.stext.stext.UnaryOperator}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.UnaryOperator
	 * @see #setOperator(UnaryOperator)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getNumericalUnaryExpression_Operator()
	 * @model
	 * @generated
	 */
  UnaryOperator getOperator();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.NumericalUnaryExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.UnaryOperator
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
	 * @see #setOperand(Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getNumericalUnaryExpression_Operand()
	 * @model containment="true"
	 * @generated
	 */
  Expression getOperand();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.NumericalUnaryExpression#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
  void setOperand(Expression value);

} // NumericalUnaryExpression

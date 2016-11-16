/**
 */
package org.yakindu.base.expressions.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Multiply Divide Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getNumericalMultiplyDivideExpression()
 * @model
 * @generated
 */
public interface NumericalMultiplyDivideExpression extends BinaryExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.base.expressions.expressions.MultiplicativeOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.base.expressions.expressions.MultiplicativeOperator
	 * @see #setOperator(MultiplicativeOperator)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getNumericalMultiplyDivideExpression_Operator()
	 * @model
	 * @generated
	 */
	MultiplicativeOperator getOperator();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.base.expressions.expressions.MultiplicativeOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(MultiplicativeOperator value);

} // NumericalMultiplyDivideExpression

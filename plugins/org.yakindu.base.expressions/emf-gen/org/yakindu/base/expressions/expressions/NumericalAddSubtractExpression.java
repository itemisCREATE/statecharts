/**
 */
package org.yakindu.base.expressions.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Numerical Add Subtract Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getNumericalAddSubtractExpression()
 * @model
 * @generated
 */
public interface NumericalAddSubtractExpression extends BinaryExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.base.expressions.expressions.AdditiveOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.base.expressions.expressions.AdditiveOperator
	 * @see #setOperator(AdditiveOperator)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getNumericalAddSubtractExpression_Operator()
	 * @model
	 * @generated
	 */
	AdditiveOperator getOperator();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.base.expressions.expressions.AdditiveOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(AdditiveOperator value);

} // NumericalAddSubtractExpression

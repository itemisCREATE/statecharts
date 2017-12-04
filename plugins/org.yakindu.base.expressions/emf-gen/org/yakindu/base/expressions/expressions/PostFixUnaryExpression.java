/**
 */
package org.yakindu.base.expressions.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Post Fix Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.PostFixUnaryExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getPostFixUnaryExpression()
 * @model
 * @generated
 */
public interface PostFixUnaryExpression extends UnaryExpression {

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.base.expressions.expressions.PostFixOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.base.expressions.expressions.PostFixOperator
	 * @see #setOperator(PostFixOperator)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getPostFixUnaryExpression_Operator()
	 * @model
	 * @generated
	 */
	PostFixOperator getOperator();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.PostFixUnaryExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.base.expressions.expressions.PostFixOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(PostFixOperator value);
} // PostFixUnaryExpression

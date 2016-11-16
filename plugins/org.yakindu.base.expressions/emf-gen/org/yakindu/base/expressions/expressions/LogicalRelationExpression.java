/**
 */
package org.yakindu.base.expressions.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Relation Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.LogicalRelationExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getLogicalRelationExpression()
 * @model
 * @generated
 */
public interface LogicalRelationExpression extends BinaryExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.base.expressions.expressions.RelationalOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.base.expressions.expressions.RelationalOperator
	 * @see #setOperator(RelationalOperator)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getLogicalRelationExpression_Operator()
	 * @model
	 * @generated
	 */
	RelationalOperator getOperator();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.LogicalRelationExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.yakindu.base.expressions.expressions.RelationalOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(RelationalOperator value);

} // LogicalRelationExpression

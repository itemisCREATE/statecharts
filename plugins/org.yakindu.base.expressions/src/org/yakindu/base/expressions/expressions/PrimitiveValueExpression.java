/**
 */
package org.yakindu.base.expressions.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Value Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.PrimitiveValueExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getPrimitiveValueExpression()
 * @model
 * @generated
 */
public interface PrimitiveValueExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Literal)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getPrimitiveValueExpression_Value()
	 * @model containment="true"
	 * @generated
	 */
	Literal getValue();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.PrimitiveValueExpression#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Literal value);

} // PrimitiveValueExpression

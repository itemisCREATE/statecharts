/**
 */
package org.yakindu.base.expressions.expressions;

import org.yakindu.base.types.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Value Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.EventValueReferenceExpression#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getEventValueReferenceExpression()
 * @model
 * @generated
 */
public interface EventValueReferenceExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Expression)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getEventValueReferenceExpression_Value()
	 * @model containment="true"
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.EventValueReferenceExpression#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

} // EventValueReferenceExpression

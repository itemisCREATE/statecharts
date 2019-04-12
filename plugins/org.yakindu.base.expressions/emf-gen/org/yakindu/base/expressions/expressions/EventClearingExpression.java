/**
 */
package org.yakindu.base.expressions.expressions;

import org.yakindu.base.types.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Clearing Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.EventClearingExpression#getEvent <em>Event</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getEventClearingExpression()
 * @model
 * @generated
 */
public interface EventClearingExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' containment reference.
	 * @see #setEvent(Expression)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getEventClearingExpression_Event()
	 * @model containment="true"
	 * @generated
	 */
	Expression getEvent();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.EventClearingExpression#getEvent <em>Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' containment reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(Expression value);

} // EventClearingExpression

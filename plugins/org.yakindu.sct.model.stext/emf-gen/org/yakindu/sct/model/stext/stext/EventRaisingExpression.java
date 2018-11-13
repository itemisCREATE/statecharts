/**
 */
package org.yakindu.sct.model.stext.stext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Raising Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.EventRaisingExpression#getEvent <em>Event</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.EventRaisingExpression#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEventRaisingExpression()
 * @model
 * @generated
 */
public interface EventRaisingExpression extends org.yakindu.base.types.Expression {
	/**
	 * Returns the value of the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' containment reference.
	 * @see #setEvent(org.yakindu.base.types.Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEventRaisingExpression_Event()
	 * @model containment="true"
	 * @generated
	 */
	org.yakindu.base.types.Expression getEvent();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.EventRaisingExpression#getEvent <em>Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' containment reference.
	 * @see #getEvent()
	 * @generated
	 */
	void setEvent(org.yakindu.base.types.Expression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(org.yakindu.base.types.Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEventRaisingExpression_Value()
	 * @model containment="true"
	 * @generated
	 */
	org.yakindu.base.types.Expression getValue();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.EventRaisingExpression#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(org.yakindu.base.types.Expression value);

} // EventRaisingExpression

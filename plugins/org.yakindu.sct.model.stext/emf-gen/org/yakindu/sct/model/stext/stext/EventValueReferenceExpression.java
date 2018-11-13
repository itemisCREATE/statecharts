/**
 */
package org.yakindu.sct.model.stext.stext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Value Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.EventValueReferenceExpression#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEventValueReferenceExpression()
 * @model
 * @generated
 */
public interface EventValueReferenceExpression extends org.yakindu.base.types.Expression {
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
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEventValueReferenceExpression_Value()
	 * @model containment="true"
	 * @generated
	 */
	org.yakindu.base.types.Expression getValue();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.EventValueReferenceExpression#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(org.yakindu.base.types.Expression value);

} // EventValueReferenceExpression

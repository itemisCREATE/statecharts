/**
 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.base.expressions.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Event Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.TimeEventSpec#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.TimeEventSpec#getValue <em>Value</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.TimeEventSpec#getUnit <em>Unit</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getTimeEventSpec()
 * @model
 * @generated
 */
public interface TimeEventSpec extends EventSpec {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.sct.model.stext.stext.TimeEventType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.TimeEventType
	 * @see #setType(TimeEventType)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getTimeEventSpec_Type()
	 * @model
	 * @generated
	 */
	TimeEventType getType();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.TimeEventSpec#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.TimeEventType
	 * @see #getType()
	 * @generated
	 */
	void setType(TimeEventType value);

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
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getTimeEventSpec_Value()
	 * @model containment="true"
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.TimeEventSpec#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

	/**
	 * Returns the value of the '<em><b>Unit</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.sct.model.stext.stext.TimeUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.TimeUnit
	 * @see #setUnit(TimeUnit)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getTimeEventSpec_Unit()
	 * @model
	 * @generated
	 */
	TimeUnit getUnit();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.TimeEventSpec#getUnit <em>Unit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unit</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.TimeUnit
	 * @see #getUnit()
	 * @generated
	 */
	void setUnit(TimeUnit value);

} // TimeEventSpec

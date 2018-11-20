/**
 */
package org.yakindu.sct.model.sexec;

import org.yakindu.base.types.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Return</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.Return#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getReturn()
 * @model
 * @generated
 */
public interface Return extends Step {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(Expression)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getReturn_Value()
	 * @model
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.Return#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

} // Return

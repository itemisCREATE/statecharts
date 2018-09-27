/**
 */
package org.yakindu.sct.model.sexec;

import org.yakindu.base.types.Operation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.Method#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Operation {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getMethod_Body()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getBody();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.Method#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Sequence value);

} // Method

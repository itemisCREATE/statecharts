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
 *   <li>{@link org.yakindu.sct.model.sexec.Method#getBodySequence <em>Body Sequence</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Operation {
	/**
	 * Returns the value of the '<em><b>Body Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Sequence</em>' containment reference.
	 * @see #setBodySequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getMethod_BodySequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getBodySequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.Method#getBodySequence <em>Body Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Sequence</em>' containment reference.
	 * @see #getBodySequence()
	 * @generated
	 */
	void setBodySequence(Sequence value);

} // Method

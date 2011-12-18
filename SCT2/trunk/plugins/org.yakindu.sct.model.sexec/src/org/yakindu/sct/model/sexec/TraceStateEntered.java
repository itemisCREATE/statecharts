/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace State Entered</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.TraceStateEntered#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getTraceStateEntered()
 * @model
 * @generated
 */
public interface TraceStateEntered extends Trace {

	/**
	 * Returns the value of the '<em><b>State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' reference.
	 * @see #setState(ExecutionState)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getTraceStateEntered_State()
	 * @model
	 * @generated
	 */
	ExecutionState getState();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.TraceStateEntered#getState <em>State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' reference.
	 * @see #getState()
	 * @generated
	 */
	void setState(ExecutionState value);
} // TraceStateEntered

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionRegion#getHistoryStateVector <em>History State Vector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionRegion()
 * @model
 * @generated
 */
public interface ExecutionRegion extends ExecutionScope {

	/**
	 * Returns the value of the '<em><b>History State Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>History State Vector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>History State Vector</em>' containment reference.
	 * @see #setHistoryStateVector(StateVector)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionRegion_HistoryStateVector()
	 * @model containment="true"
	 * @generated
	 */
	StateVector getHistoryStateVector();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionRegion#getHistoryStateVector <em>History State Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>History State Vector</em>' containment reference.
	 * @see #getHistoryStateVector()
	 * @generated
	 */
	void setHistoryStateVector(StateVector value);
} // ExecutionRegion

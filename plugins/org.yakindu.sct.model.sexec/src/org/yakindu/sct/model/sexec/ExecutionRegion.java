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
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionRegion#getDeepEnterSequence <em>Deep Enter Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionRegion#getShallowEnterSequence <em>Shallow Enter Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionRegion#getHistoryVector <em>History Vector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionRegion()
 * @model
 * @generated
 */
public interface ExecutionRegion extends ExecutionScope {

	/**
	 * Returns the value of the '<em><b>Deep Enter Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deep Enter Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deep Enter Sequence</em>' containment reference.
	 * @see #setDeepEnterSequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionRegion_DeepEnterSequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getDeepEnterSequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionRegion#getDeepEnterSequence <em>Deep Enter Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deep Enter Sequence</em>' containment reference.
	 * @see #getDeepEnterSequence()
	 * @generated
	 */
	void setDeepEnterSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>Shallow Enter Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shallow Enter Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shallow Enter Sequence</em>' containment reference.
	 * @see #setShallowEnterSequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionRegion_ShallowEnterSequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getShallowEnterSequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionRegion#getShallowEnterSequence <em>Shallow Enter Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shallow Enter Sequence</em>' containment reference.
	 * @see #getShallowEnterSequence()
	 * @generated
	 */
	void setShallowEnterSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>History Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>History Vector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>History Vector</em>' containment reference.
	 * @see #setHistoryVector(StateVector)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionRegion_HistoryVector()
	 * @model containment="true"
	 * @generated
	 */
	StateVector getHistoryVector();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionRegion#getHistoryVector <em>History Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>History Vector</em>' containment reference.
	 * @see #getHistoryVector()
	 * @generated
	 */
	void setHistoryVector(StateVector value);
} // ExecutionRegion

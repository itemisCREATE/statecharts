/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;

import org.eclipse.emf.common.util.EList;
import org.yakindu.sct.model.sgraph.ScopedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getStates <em>States</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getEnterSequence <em>Enter Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getStateVector <em>State Vector</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getExitSequence <em>Exit Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow()
 * @model
 * @generated
 */
public interface ExecutionFlow extends ScopedElement, NamedElement {
	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sexec.ExecutionState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>States</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionState> getStates();

	/**
	 * Returns the value of the '<em><b>Enter Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enter Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enter Sequence</em>' containment reference.
	 * @see #setEnterSequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow_EnterSequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getEnterSequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getEnterSequence <em>Enter Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enter Sequence</em>' containment reference.
	 * @see #getEnterSequence()
	 * @generated
	 */
	void setEnterSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>State Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Vector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Vector</em>' containment reference.
	 * @see #setStateVector(StateVector)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow_StateVector()
	 * @model containment="true"
	 * @generated
	 */
	StateVector getStateVector();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getStateVector <em>State Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Vector</em>' containment reference.
	 * @see #getStateVector()
	 * @generated
	 */
	void setStateVector(StateVector value);

	/**
	 * Returns the value of the '<em><b>Exit Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Sequence</em>' containment reference.
	 * @see #setExitSequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow_ExitSequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getExitSequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getExitSequence <em>Exit Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Sequence</em>' containment reference.
	 * @see #getExitSequence()
	 * @generated
	 */
	void setExitSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sexec.ExecutionNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nodes</em>' containment reference list.
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow_Nodes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionNode> getNodes();

} // ExecutionFlow

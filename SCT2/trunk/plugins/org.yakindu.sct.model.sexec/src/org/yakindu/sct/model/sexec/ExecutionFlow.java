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
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getRegions <em>Regions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getHistoryVector <em>History Vector</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getEntryAction <em>Entry Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getExitAction <em>Exit Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionFlow#getStaticInitSequence <em>Static Init Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow()
 * @model
 * @generated
 */
public interface ExecutionFlow extends ScopedElement, ExecutionScope, ExecutionNode {
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

	/**
	 * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sexec.ExecutionRegion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' containment reference list.
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow_Regions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExecutionRegion> getRegions();

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
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow_HistoryVector()
	 * @model containment="true"
	 * @generated
	 */
	StateVector getHistoryVector();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getHistoryVector <em>History Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>History Vector</em>' containment reference.
	 * @see #getHistoryVector()
	 * @generated
	 */
	void setHistoryVector(StateVector value);

	/**
	 * Returns the value of the '<em><b>Entry Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Action</em>' containment reference.
	 * @see #setEntryAction(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow_EntryAction()
	 * @model containment="true"
	 * @generated
	 */
	Step getEntryAction();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getEntryAction <em>Entry Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Action</em>' containment reference.
	 * @see #getEntryAction()
	 * @generated
	 */
	void setEntryAction(Step value);

	/**
	 * Returns the value of the '<em><b>Exit Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Action</em>' containment reference.
	 * @see #setExitAction(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow_ExitAction()
	 * @model containment="true"
	 * @generated
	 */
	Step getExitAction();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getExitAction <em>Exit Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Action</em>' containment reference.
	 * @see #getExitAction()
	 * @generated
	 */
	void setExitAction(Step value);

	/**
	 * Returns the value of the '<em><b>Static Init Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Static Init Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Static Init Sequence</em>' containment reference.
	 * @see #setStaticInitSequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionFlow_StaticInitSequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getStaticInitSequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionFlow#getStaticInitSequence <em>Static Init Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Static Init Sequence</em>' containment reference.
	 * @see #getStaticInitSequence()
	 * @generated
	 */
	void setStaticInitSequence(Sequence value);

} // ExecutionFlow

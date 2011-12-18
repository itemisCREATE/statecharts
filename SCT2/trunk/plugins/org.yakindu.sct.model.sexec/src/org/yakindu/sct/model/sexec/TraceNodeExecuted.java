/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Node Executed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.TraceNodeExecuted#getNode <em>Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getTraceNodeExecuted()
 * @model
 * @generated
 */
public interface TraceNodeExecuted extends Trace {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(ExecutionNode)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getTraceNodeExecuted_Node()
	 * @model
	 * @generated
	 */
	ExecutionNode getNode();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.TraceNodeExecuted#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(ExecutionNode value);

} // TraceNodeExecuted

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getCycle <em>Cycle</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState()
 * @model
 * @generated
 */
public interface ExecutionState extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name</em>' attribute.
	 * @see #setSimpleName(String)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

	/**
	 * Returns the value of the '<em><b>Cycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cycle</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cycle</em>' containment reference.
	 * @see #setCycle(Cycle)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_Cycle()
	 * @model containment="true"
	 * @generated
	 */
	Cycle getCycle();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getCycle <em>Cycle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cycle</em>' containment reference.
	 * @see #getCycle()
	 * @generated
	 */
	void setCycle(Cycle value);

} // ExecutionState

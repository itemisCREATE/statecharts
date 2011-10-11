/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.If#getCheck <em>Check</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.If#getThenStep <em>Then Step</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.If#getElseStep <em>Else Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getIf()
 * @model
 * @generated
 */
public interface If extends Step {
	/**
	 * Returns the value of the '<em><b>Check</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check</em>' containment reference.
	 * @see #setCheck(Check)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getIf_Check()
	 * @model containment="true"
	 * @generated
	 */
	Check getCheck();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.If#getCheck <em>Check</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check</em>' containment reference.
	 * @see #getCheck()
	 * @generated
	 */
	void setCheck(Check value);

	/**
	 * Returns the value of the '<em><b>Then Step</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Step</em>' containment reference.
	 * @see #setThenStep(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getIf_ThenStep()
	 * @model containment="true"
	 * @generated
	 */
	Step getThenStep();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.If#getThenStep <em>Then Step</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Step</em>' containment reference.
	 * @see #getThenStep()
	 * @generated
	 */
	void setThenStep(Step value);

	/**
	 * Returns the value of the '<em><b>Else Step</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Step</em>' containment reference.
	 * @see #setElseStep(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getIf_ElseStep()
	 * @model containment="true"
	 * @generated
	 */
	Step getElseStep();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.If#getElseStep <em>Else Step</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Step</em>' containment reference.
	 * @see #getElseStep()
	 * @generated
	 */
	void setElseStep(Step value);

} // If

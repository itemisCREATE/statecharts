/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;

import org.yakindu.sct.model.sgraph.Statement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.If#getCondition <em>Condition</em>}</li>
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
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Statement)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getIf_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Statement getCondition();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.If#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Statement value);

	/**
	 * Returns the value of the '<em><b>Then Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Step</em>' reference.
	 * @see #setThenStep(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getIf_ThenStep()
	 * @model
	 * @generated
	 */
	Step getThenStep();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.If#getThenStep <em>Then Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Step</em>' reference.
	 * @see #getThenStep()
	 * @generated
	 */
	void setThenStep(Step value);

	/**
	 * Returns the value of the '<em><b>Else Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Step</em>' reference.
	 * @see #setElseStep(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getIf_ElseStep()
	 * @model
	 * @generated
	 */
	Step getElseStep();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.If#getElseStep <em>Else Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Step</em>' reference.
	 * @see #getElseStep()
	 * @generated
	 */
	void setElseStep(Step value);

} // If

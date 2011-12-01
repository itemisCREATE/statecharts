/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.Call#getStep <em>Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getCall()
 * @model
 * @generated
 */
public interface Call extends Step {
	/**
	 * Returns the value of the '<em><b>Step</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.sexec.Step#getCaller <em>Caller</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' reference.
	 * @see #setStep(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getCall_Step()
	 * @see org.yakindu.sct.model.sexec.Step#getCaller
	 * @model opposite="caller"
	 * @generated
	 */
	Step getStep();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.Call#getStep <em>Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step</em>' reference.
	 * @see #getStep()
	 * @generated
	 */
	void setStep(Step value);

} // Call

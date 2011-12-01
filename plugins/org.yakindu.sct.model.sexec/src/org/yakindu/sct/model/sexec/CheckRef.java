/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.CheckRef#getCheck <em>Check</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getCheckRef()
 * @model
 * @generated
 */
public interface CheckRef extends Check {
	/**
	 * Returns the value of the '<em><b>Check</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.sexec.Check#getRefs <em>Refs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check</em>' reference.
	 * @see #setCheck(Check)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getCheckRef_Check()
	 * @see org.yakindu.sct.model.sexec.Check#getRefs
	 * @model opposite="refs"
	 * @generated
	 */
	Check getCheck();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.CheckRef#getCheck <em>Check</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check</em>' reference.
	 * @see #getCheck()
	 * @generated
	 */
	void setCheck(Check value);

} // CheckRef

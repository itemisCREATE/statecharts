/**
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Do While</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.DoWhile#getCheck <em>Check</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.DoWhile#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getDoWhile()
 * @model
 * @generated
 */
public interface DoWhile extends Step {
	/**
	 * Returns the value of the '<em><b>Check</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check</em>' containment reference.
	 * @see #setCheck(Check)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getDoWhile_Check()
	 * @model containment="true"
	 * @generated
	 */
	Check getCheck();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.DoWhile#getCheck <em>Check</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check</em>' containment reference.
	 * @see #getCheck()
	 * @generated
	 */
	void setCheck(Check value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getDoWhile_Body()
	 * @model containment="true"
	 * @generated
	 */
	Step getBody();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.DoWhile#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Step value);

} // DoWhile

/**
 */
package org.yakindu.sct.model.sexec;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.Statement#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getStatement()
 * @model
 * @generated
 */
public interface Statement extends Step {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(org.yakindu.base.types.Expression)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getStatement_Expression()
	 * @model containment="true"
	 * @generated
	 */
	org.yakindu.base.types.Expression getExpression();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.Statement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(org.yakindu.base.types.Expression value);

} // Statement

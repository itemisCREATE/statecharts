/**
 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.base.types.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Submachine Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.SubmachineReferenceExpression#getSubmachine <em>Submachine</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getSubmachineReferenceExpression()
 * @model
 * @generated
 */
public interface SubmachineReferenceExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Submachine</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Submachine</em>' containment reference.
	 * @see #setSubmachine(Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getSubmachineReferenceExpression_Submachine()
	 * @model containment="true"
	 * @generated
	 */
	Expression getSubmachine();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.SubmachineReferenceExpression#getSubmachine <em>Submachine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Submachine</em>' containment reference.
	 * @see #getSubmachine()
	 * @generated
	 */
	void setSubmachine(Expression value);

} // SubmachineReferenceExpression

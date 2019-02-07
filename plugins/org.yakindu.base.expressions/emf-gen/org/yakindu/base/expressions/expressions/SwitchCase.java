/**
 */
package org.yakindu.base.expressions.expressions;

import org.yakindu.base.types.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.SwitchCase#getCase <em>Case</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.SwitchCase#getThen <em>Then</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getSwitchCase()
 * @model
 * @generated
 */
public interface SwitchCase extends Expression {
	/**
	 * Returns the value of the '<em><b>Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case</em>' containment reference.
	 * @see #setCase(Expression)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getSwitchCase_Case()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCase();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.SwitchCase#getCase <em>Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case</em>' containment reference.
	 * @see #getCase()
	 * @generated
	 */
	void setCase(Expression value);

	/**
	 * Returns the value of the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then</em>' containment reference.
	 * @see #setThen(Expression)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getSwitchCase_Then()
	 * @model containment="true"
	 * @generated
	 */
	Expression getThen();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.SwitchCase#getThen <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then</em>' containment reference.
	 * @see #getThen()
	 * @generated
	 */
	void setThen(Expression value);

} // SwitchCase

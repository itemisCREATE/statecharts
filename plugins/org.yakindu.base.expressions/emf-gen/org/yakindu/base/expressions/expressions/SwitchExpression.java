/**
 */
package org.yakindu.base.expressions.expressions;

import org.eclipse.emf.common.util.EList;
import org.yakindu.base.types.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.SwitchExpression#getSwitch <em>Switch</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.SwitchExpression#getCases <em>Cases</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.SwitchExpression#getDefault <em>Default</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getSwitchExpression()
 * @model
 * @generated
 */
public interface SwitchExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch</em>' containment reference.
	 * @see #setSwitch(Expression)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getSwitchExpression_Switch()
	 * @model containment="true"
	 * @generated
	 */
	Expression getSwitch();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.SwitchExpression#getSwitch <em>Switch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch</em>' containment reference.
	 * @see #getSwitch()
	 * @generated
	 */
	void setSwitch(Expression value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.expressions.expressions.SwitchCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getSwitchExpression_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<SwitchCase> getCases();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(Expression)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getSwitchExpression_Default()
	 * @model containment="true"
	 * @generated
	 */
	Expression getDefault();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.SwitchExpression#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(Expression value);

} // SwitchExpression

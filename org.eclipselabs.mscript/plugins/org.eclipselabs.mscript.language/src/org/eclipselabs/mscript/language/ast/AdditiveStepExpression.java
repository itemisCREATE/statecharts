/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Step Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getAdditiveStepExpression()
 * @model
 * @generated
 */
public interface AdditiveStepExpression extends StepExpression {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.mscript.language.ast.AdditiveOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveOperator
	 * @see #setOperator(AdditiveOperator)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getAdditiveStepExpression_Operator()
	 * @model
	 * @generated
	 */
	AdditiveOperator getOperator();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(AdditiveOperator value);

	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(StepExpression)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getAdditiveStepExpression_LeftOperand()
	 * @model containment="true"
	 * @generated
	 */
	StepExpression getLeftOperand();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(StepExpression value);

	/**
	 * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Operand</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operand</em>' containment reference.
	 * @see #setRightOperand(StepExpression)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getAdditiveStepExpression_RightOperand()
	 * @model containment="true"
	 * @generated
	 */
	StepExpression getRightOperand();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getRightOperand <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' containment reference.
	 * @see #getRightOperand()
	 * @generated
	 */
	void setRightOperand(StepExpression value);

} // AdditiveStepExpression

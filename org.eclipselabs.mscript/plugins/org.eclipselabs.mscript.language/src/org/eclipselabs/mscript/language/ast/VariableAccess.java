/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.VariableAccess#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.VariableAccess#getStepExpression <em>Step Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableAccess()
 * @model
 * @generated
 */
public interface VariableAccess extends Expression {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(CallableElement)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableAccess_Variable()
	 * @model
	 * @generated
	 */
	CallableElement getVariable();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.VariableAccess#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(CallableElement value);

	/**
	 * Returns the value of the '<em><b>Step Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Expression</em>' containment reference.
	 * @see #setStepExpression(Expression)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableAccess_StepExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getStepExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.VariableAccess#getStepExpression <em>Step Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Expression</em>' containment reference.
	 * @see #getStepExpression()
	 * @generated
	 */
	void setStepExpression(Expression value);

} // VariableAccess

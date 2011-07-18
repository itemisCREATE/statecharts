/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionCall#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionCall#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionCall()
 * @model
 * @generated
 */
public interface FunctionCall extends Expression {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(CallableElement)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionCall_Function()
	 * @model
	 * @generated
	 */
	CallableElement getFunction();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FunctionCall#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(CallableElement value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.typesystem.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionCall_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArguments();

} // FunctionCall

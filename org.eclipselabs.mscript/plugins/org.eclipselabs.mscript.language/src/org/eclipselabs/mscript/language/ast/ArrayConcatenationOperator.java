/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Concatenation Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayConcatenationOperator()
 * @model
 * @generated
 */
public interface ArrayConcatenationOperator extends Expression {
	/**
	 * Returns the value of the '<em><b>Rows</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ExpressionList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rows</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rows</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayConcatenationOperator_Rows()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExpressionList> getRows();

} // ArrayConcatenationOperator

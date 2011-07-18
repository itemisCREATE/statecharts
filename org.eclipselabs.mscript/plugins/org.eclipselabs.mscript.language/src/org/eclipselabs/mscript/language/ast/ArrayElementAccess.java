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
 * A representation of the model object '<em><b>Array Element Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayElementAccess#getArray <em>Array</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayElementAccess#getSubscripts <em>Subscripts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayElementAccess()
 * @model
 * @generated
 */
public interface ArrayElementAccess extends Expression {
	/**
	 * Returns the value of the '<em><b>Array</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array</em>' containment reference.
	 * @see #setArray(Expression)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayElementAccess_Array()
	 * @model containment="true"
	 * @generated
	 */
	Expression getArray();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArrayElementAccess#getArray <em>Array</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array</em>' containment reference.
	 * @see #getArray()
	 * @generated
	 */
	void setArray(Expression value);

	/**
	 * Returns the value of the '<em><b>Subscripts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ArraySubscript}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscripts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscripts</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayElementAccess_Subscripts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ArraySubscript> getSubscripts();

} // ArrayElementAccess

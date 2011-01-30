/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.il.VariableReference#getArrayIndices <em>Array Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.il.ILPackage#getVariableReference()
 * @model
 * @generated
 */
public interface VariableReference extends VariableAccess, Expression {
	/**
	 * Returns the value of the '<em><b>Array Indices</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Indices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Indices</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getVariableReference_ArrayIndices()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArrayIndices();

} // VariableReference

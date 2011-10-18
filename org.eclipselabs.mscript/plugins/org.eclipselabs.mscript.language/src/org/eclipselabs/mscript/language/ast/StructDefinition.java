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
 * A representation of the model object '<em><b>Struct Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.StructDefinition#getMemberDeclarations <em>Member Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getStructDefinition()
 * @model
 * @generated
 */
public interface StructDefinition extends DataTypeDefinition {
	/**
	 * Returns the value of the '<em><b>Member Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.StructMemberDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getStructDefinition_MemberDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<StructMemberDeclaration> getMemberDeclarations();

} // StructDefinition

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
 * A representation of the model object '<em><b>Enumeration Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.EnumerationDefinition#getLiteralDeclarations <em>Literal Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getEnumerationDefinition()
 * @model
 * @generated
 */
public interface EnumerationDefinition extends DataTypeDefinition {
	/**
	 * Returns the value of the '<em><b>Literal Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getEnumerationDefinition_LiteralDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<EnumerationLiteralDeclaration> getLiteralDeclarations();

} // EnumerationDefinition

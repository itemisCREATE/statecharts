/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typedef Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.TypedefDeclaration#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getTypedefDeclaration()
 * @model
 * @generated
 */
public interface TypedefDeclaration extends DataTypeDefinition {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(DataTypeSpecifier)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getTypedefDeclaration_Type()
	 * @model containment="true"
	 * @generated
	 */
	DataTypeSpecifier getType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.TypedefDeclaration#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataTypeSpecifier value);

} // TypedefDeclaration

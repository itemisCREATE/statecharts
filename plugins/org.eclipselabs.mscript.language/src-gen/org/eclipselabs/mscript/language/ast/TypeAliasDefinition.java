/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Alias Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.TypeAliasDefinition#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getTypeAliasDefinition()
 * @model
 * @generated
 */
public interface TypeAliasDefinition extends DataTypeDefinition
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(PrimitiveTypeSpecifier)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getTypeAliasDefinition_Type()
   * @model containment="true"
   * @generated
   */
  PrimitiveTypeSpecifier getType();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.TypeAliasDefinition#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(PrimitiveTypeSpecifier value);

} // TypeAliasDefinition

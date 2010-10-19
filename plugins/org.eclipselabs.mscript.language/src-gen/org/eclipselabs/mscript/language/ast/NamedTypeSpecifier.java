/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.NamedTypeSpecifier#getTypeReference <em>Type Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getNamedTypeSpecifier()
 * @model
 * @generated
 */
public interface NamedTypeSpecifier extends DataTypeSpecifier
{
  /**
   * Returns the value of the '<em><b>Type Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Reference</em>' containment reference.
   * @see #setTypeReference(QualifiedName)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getNamedTypeSpecifier_TypeReference()
   * @model containment="true"
   * @generated
   */
  QualifiedName getTypeReference();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.NamedTypeSpecifier#getTypeReference <em>Type Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Reference</em>' containment reference.
   * @see #getTypeReference()
   * @generated
   */
  void setTypeReference(QualifiedName value);

} // NamedTypeSpecifier

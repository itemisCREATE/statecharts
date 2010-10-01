/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.VariableDeclaration#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.VariableDeclaration#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableDeclaration()
 * @model
 * @generated
 */
public interface VariableDeclaration extends PackageDefinitionElement, Statement
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
   * @see #setType(DataTypeSpecifier)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableDeclaration_Type()
   * @model containment="true"
   * @generated
   */
  DataTypeSpecifier getType();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.VariableDeclaration#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(DataTypeSpecifier value);

  /**
   * Returns the value of the '<em><b>Items</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.VariableDeclarationItem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Items</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableDeclaration_Items()
   * @model containment="true"
   * @generated
   */
  EList<VariableDeclarationItem> getItems();

} // VariableDeclaration

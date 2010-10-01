/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.VariableDeclarationItem#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.VariableDeclarationItem#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableDeclarationItem()
 * @model
 * @generated
 */
public interface VariableDeclarationItem extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableDeclarationItem_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.VariableDeclarationItem#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Initial Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial Value</em>' containment reference.
   * @see #setInitialValue(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getVariableDeclarationItem_InitialValue()
   * @model containment="true"
   * @generated
   */
  Expression getInitialValue();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.VariableDeclarationItem#getInitialValue <em>Initial Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial Value</em>' containment reference.
   * @see #getInitialValue()
   * @generated
   */
  void setInitialValue(Expression value);

} // VariableDeclarationItem

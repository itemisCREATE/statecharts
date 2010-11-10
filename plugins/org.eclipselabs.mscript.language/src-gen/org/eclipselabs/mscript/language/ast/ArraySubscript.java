/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Subscript</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArraySubscript#isSlice <em>Slice</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArraySubscript#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArraySubscript()
 * @model
 * @generated
 */
public interface ArraySubscript extends EObject
{
  /**
   * Returns the value of the '<em><b>Slice</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Slice</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Slice</em>' attribute.
   * @see #setSlice(boolean)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArraySubscript_Slice()
   * @model
   * @generated
   */
  boolean isSlice();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArraySubscript#isSlice <em>Slice</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Slice</em>' attribute.
   * @see #isSlice()
   * @generated
   */
  void setSlice(boolean value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArraySubscript_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ArraySubscript#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // ArraySubscript

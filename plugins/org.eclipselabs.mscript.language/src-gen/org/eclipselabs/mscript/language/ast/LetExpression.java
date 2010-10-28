/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.LetExpression#getVariables <em>Variables</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.LetExpression#getTargetExpression <em>Target Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getLetExpression()
 * @model
 * @generated
 */
public interface LetExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.LetExpressionVariable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variables</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getLetExpression_Variables()
   * @model containment="true"
   * @generated
   */
  EList<LetExpressionVariable> getVariables();

  /**
   * Returns the value of the '<em><b>Target Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Expression</em>' containment reference.
   * @see #setTargetExpression(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getLetExpression_TargetExpression()
   * @model containment="true"
   * @generated
   */
  Expression getTargetExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.LetExpression#getTargetExpression <em>Target Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Expression</em>' containment reference.
   * @see #getTargetExpression()
   * @generated
   */
  void setTargetExpression(Expression value);

} // LetExpression

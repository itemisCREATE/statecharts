/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.IfStatement#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.IfStatement#getElseBody <em>Else Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.IfCase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cases</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getIfStatement_Cases()
   * @model containment="true"
   * @generated
   */
  EList<IfCase> getCases();

  /**
   * Returns the value of the '<em><b>Else Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Body</em>' containment reference.
   * @see #setElseBody(Block)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getIfStatement_ElseBody()
   * @model containment="true"
   * @generated
   */
  Block getElseBody();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.IfStatement#getElseBody <em>Else Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Body</em>' containment reference.
   * @see #getElseBody()
   * @generated
   */
  void setElseBody(Block value);

} // IfStatement

/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.SwitchStatement#getControlExpression <em>Control Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.SwitchStatement#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.SwitchStatement#getDefaultStatements <em>Default Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getSwitchStatement()
 * @model
 * @generated
 */
public interface SwitchStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Control Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Control Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Control Expression</em>' containment reference.
   * @see #setControlExpression(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getSwitchStatement_ControlExpression()
   * @model containment="true"
   * @generated
   */
  Expression getControlExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.SwitchStatement#getControlExpression <em>Control Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Control Expression</em>' containment reference.
   * @see #getControlExpression()
   * @generated
   */
  void setControlExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.SwitchCase}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cases</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getSwitchStatement_Cases()
   * @model containment="true"
   * @generated
   */
  EList<SwitchCase> getCases();

  /**
   * Returns the value of the '<em><b>Default Statements</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Statement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default Statements</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getSwitchStatement_DefaultStatements()
   * @model containment="true"
   * @generated
   */
  EList<Statement> getDefaultStatements();

} // SwitchStatement

/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ForStatement#getInitializers <em>Initializers</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ForStatement#getTestExpression <em>Test Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ForStatement#getCountExpressions <em>Count Expressions</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ForStatement#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement
{
  /**
   * Returns the value of the '<em><b>Initializers</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ForStatementInitializer}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initializers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initializers</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement_Initializers()
   * @model containment="true"
   * @generated
   */
  EList<ForStatementInitializer> getInitializers();

  /**
   * Returns the value of the '<em><b>Test Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Test Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Test Expression</em>' containment reference.
   * @see #setTestExpression(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement_TestExpression()
   * @model containment="true"
   * @generated
   */
  Expression getTestExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ForStatement#getTestExpression <em>Test Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Test Expression</em>' containment reference.
   * @see #getTestExpression()
   * @generated
   */
  void setTestExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Count Expressions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Count Expressions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Count Expressions</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement_CountExpressions()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getCountExpressions();

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(BlockStatement)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement_Body()
   * @model containment="true"
   * @generated
   */
  BlockStatement getBody();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ForStatement#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(BlockStatement value);

} // ForStatement

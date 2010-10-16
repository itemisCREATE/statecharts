/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ConditionalExpression#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ConditionalExpression#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ConditionalExpression#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getConditionalExpression()
 * @model
 * @generated
 */
public interface ConditionalExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getConditionalExpression_Condition()
   * @model containment="true"
   * @generated
   */
  Expression getCondition();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ConditionalExpression#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expression value);

  /**
   * Returns the value of the '<em><b>Then Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Expression</em>' containment reference.
   * @see #setThenExpression(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getConditionalExpression_ThenExpression()
   * @model containment="true"
   * @generated
   */
  Expression getThenExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ConditionalExpression#getThenExpression <em>Then Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Expression</em>' containment reference.
   * @see #getThenExpression()
   * @generated
   */
  void setThenExpression(Expression value);

  /**
   * Returns the value of the '<em><b>Else Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Expression</em>' containment reference.
   * @see #setElseExpression(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getConditionalExpression_ElseExpression()
   * @model containment="true"
   * @generated
   */
  Expression getElseExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ConditionalExpression#getElseExpression <em>Else Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Expression</em>' containment reference.
   * @see #getElseExpression()
   * @generated
   */
  void setElseExpression(Expression value);

} // ConditionalExpression

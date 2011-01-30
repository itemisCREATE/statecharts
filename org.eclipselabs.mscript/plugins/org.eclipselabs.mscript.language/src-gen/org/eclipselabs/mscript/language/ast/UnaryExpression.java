/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.UnaryExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.UnaryExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipselabs.mscript.language.ast.UnaryOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.UnaryOperator
   * @see #setOperator(UnaryOperator)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getUnaryExpression_Operator()
   * @model
   * @generated
   */
  UnaryOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.UnaryExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.UnaryOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(UnaryOperator value);

  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getUnaryExpression_Operand()
   * @model containment="true"
   * @generated
   */
  Expression getOperand();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.UnaryExpression#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(Expression value);

} // UnaryExpression

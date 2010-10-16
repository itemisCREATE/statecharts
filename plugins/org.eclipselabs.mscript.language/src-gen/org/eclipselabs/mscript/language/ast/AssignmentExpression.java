/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AssignmentExpression#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AssignmentExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AssignmentExpression#getRightHandSide <em>Right Hand Side</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getAssignmentExpression()
 * @model
 * @generated
 */
public interface AssignmentExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Left Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Left Hand Side</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left Hand Side</em>' containment reference.
   * @see #setLeftHandSide(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getAssignmentExpression_LeftHandSide()
   * @model containment="true"
   * @generated
   */
  Expression getLeftHandSide();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AssignmentExpression#getLeftHandSide <em>Left Hand Side</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left Hand Side</em>' containment reference.
   * @see #getLeftHandSide()
   * @generated
   */
  void setLeftHandSide(Expression value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipselabs.mscript.language.ast.AssignmentOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.AssignmentOperator
   * @see #setOperator(AssignmentOperator)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getAssignmentExpression_Operator()
   * @model
   * @generated
   */
  AssignmentOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AssignmentExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.AssignmentOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(AssignmentOperator value);

  /**
   * Returns the value of the '<em><b>Right Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Right Hand Side</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right Hand Side</em>' containment reference.
   * @see #setRightHandSide(Expression)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getAssignmentExpression_RightHandSide()
   * @model containment="true"
   * @generated
   */
  Expression getRightHandSide();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AssignmentExpression#getRightHandSide <em>Right Hand Side</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right Hand Side</em>' containment reference.
   * @see #getRightHandSide()
   * @generated
   */
  void setRightHandSide(Expression value);

} // AssignmentExpression

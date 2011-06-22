/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.yakindu.model.sct.statechart.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.Assignment#getVarRef <em>Var Ref</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.Assignment#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getAssignment()
 * @model
 * @generated
 */
public interface Assignment extends Statement
{
  /**
   * Returns the value of the '<em><b>Var Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Var Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Ref</em>' reference.
   * @see #setVarRef(Variable)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getAssignment_VarRef()
   * @model
   * @generated
   */
  Variable getVarRef();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.Assignment#getVarRef <em>Var Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Ref</em>' reference.
   * @see #getVarRef()
   * @generated
   */
  void setVarRef(Variable value);

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
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getAssignment_Expression()
   * @model containment="true"
   * @generated
   */
  Expression getExpression();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.Assignment#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(Expression value);

} // Assignment

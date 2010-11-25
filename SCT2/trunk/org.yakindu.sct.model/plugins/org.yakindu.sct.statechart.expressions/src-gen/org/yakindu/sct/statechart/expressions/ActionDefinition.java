/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.ActionDefinition#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getActionDefinition()
 * @model
 * @generated
 */
public interface ActionDefinition extends Statement
{
  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(ExpressionRule)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getActionDefinition_Expression()
   * @model containment="true"
   * @generated
   */
  ExpressionRule getExpression();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.ActionDefinition#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(ExpressionRule value);

} // ActionDefinition

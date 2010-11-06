/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.VariableAssignment#getVariableReference <em>Variable Reference</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.VariableAssignment#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.VariableAssignment#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getVariableAssignment()
 * @model
 * @generated
 */
public interface VariableAssignment extends Statement
{
  /**
   * Returns the value of the '<em><b>Variable Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Reference</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable Reference</em>' containment reference.
   * @see #setVariableReference(VariableReference)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getVariableAssignment_VariableReference()
   * @model containment="true"
   * @generated
   */
  VariableReference getVariableReference();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.VariableAssignment#getVariableReference <em>Variable Reference</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Reference</em>' containment reference.
   * @see #getVariableReference()
   * @generated
   */
  void setVariableReference(VariableReference value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.yakindu.sct.statechart.expressions.AssignmentOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.AssignmentOperator
   * @see #setOperator(AssignmentOperator)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getVariableAssignment_Operator()
   * @model
   * @generated
   */
  AssignmentOperator getOperator();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.VariableAssignment#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.AssignmentOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(AssignmentOperator value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ConditionalExpression)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getVariableAssignment_Value()
   * @model containment="true"
   * @generated
   */
  ConditionalExpression getValue();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.VariableAssignment#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ConditionalExpression value);

} // VariableAssignment

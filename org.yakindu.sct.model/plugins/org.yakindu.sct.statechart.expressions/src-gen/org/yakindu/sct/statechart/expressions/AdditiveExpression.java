/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.AdditiveExpression#getOperand1 <em>Operand1</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.AdditiveExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.AdditiveExpression#getOperand2 <em>Operand2</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getAdditiveExpression()
 * @model
 * @generated
 */
public interface AdditiveExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Operand1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand1</em>' containment reference.
   * @see #setOperand1(MultiplicativeExpression)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getAdditiveExpression_Operand1()
   * @model containment="true"
   * @generated
   */
  MultiplicativeExpression getOperand1();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.AdditiveExpression#getOperand1 <em>Operand1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand1</em>' containment reference.
   * @see #getOperand1()
   * @generated
   */
  void setOperand1(MultiplicativeExpression value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.yakindu.sct.statechart.expressions.AdditiveOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.AdditiveOperator
   * @see #setOperator(AdditiveOperator)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getAdditiveExpression_Operator()
   * @model
   * @generated
   */
  AdditiveOperator getOperator();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.AdditiveExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.AdditiveOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(AdditiveOperator value);

  /**
   * Returns the value of the '<em><b>Operand2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operand2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand2</em>' containment reference.
   * @see #setOperand2(MultiplicativeExpression)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getAdditiveExpression_Operand2()
   * @model containment="true"
   * @generated
   */
  MultiplicativeExpression getOperand2();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.AdditiveExpression#getOperand2 <em>Operand2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand2</em>' containment reference.
   * @see #getOperand2()
   * @generated
   */
  void setOperand2(MultiplicativeExpression value);

} // AdditiveExpression

/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiply Divide Expression Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.MultiplyDivideExpressionPart#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.MultiplyDivideExpressionPart#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getMultiplyDivideExpressionPart()
 * @model
 * @generated
 */
public interface MultiplyDivideExpressionPart extends EObject
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipselabs.mscript.language.ast.MultiplyDivideOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.MultiplyDivideOperator
   * @see #setOperator(MultiplyDivideOperator)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getMultiplyDivideExpressionPart_Operator()
   * @model
   * @generated
   */
  MultiplyDivideOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideExpressionPart#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.MultiplyDivideOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(MultiplyDivideOperator value);

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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getMultiplyDivideExpressionPart_Operand()
   * @model containment="true"
   * @generated
   */
  Expression getOperand();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideExpressionPart#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(Expression value);

} // MultiplyDivideExpressionPart

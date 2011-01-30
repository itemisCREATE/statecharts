/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Expression Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AdditiveExpressionPart#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AdditiveExpressionPart#getOperand <em>Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getAdditiveExpressionPart()
 * @model
 * @generated
 */
public interface AdditiveExpressionPart extends EObject
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipselabs.mscript.language.ast.AdditiveOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.AdditiveOperator
   * @see #setOperator(AdditiveOperator)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getAdditiveExpressionPart_Operator()
   * @model
   * @generated
   */
  AdditiveOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AdditiveExpressionPart#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipselabs.mscript.language.ast.AdditiveOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(AdditiveOperator value);

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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getAdditiveExpressionPart_Operand()
   * @model containment="true"
   * @generated
   */
  Expression getOperand();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.AdditiveExpressionPart#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(Expression value);

} // AdditiveExpressionPart

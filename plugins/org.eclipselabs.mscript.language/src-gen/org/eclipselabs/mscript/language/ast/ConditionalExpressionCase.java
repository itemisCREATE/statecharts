/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Expression Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ConditionalExpressionCase#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ConditionalExpressionCase#getThenExpression <em>Then Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getConditionalExpressionCase()
 * @model
 * @generated
 */
public interface ConditionalExpressionCase extends EObject
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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getConditionalExpressionCase_Condition()
   * @model containment="true"
   * @generated
   */
  Expression getCondition();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ConditionalExpressionCase#getCondition <em>Condition</em>}' containment reference.
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
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getConditionalExpressionCase_ThenExpression()
   * @model containment="true"
   * @generated
   */
  Expression getThenExpression();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ConditionalExpressionCase#getThenExpression <em>Then Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Expression</em>' containment reference.
   * @see #getThenExpression()
   * @generated
   */
  void setThenExpression(Expression value);

} // ConditionalExpressionCase

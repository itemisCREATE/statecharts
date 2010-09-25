/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Subtract Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AddSubtractExpression#getOperands <em>Operands</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.AddSubtractExpression#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getAddSubtractExpression()
 * @model
 * @generated
 */
public interface AddSubtractExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operands</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getAddSubtractExpression_Operands()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getOperands();

  /**
   * Returns the value of the '<em><b>Operators</b></em>' attribute list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.AddSubtractOperator}.
   * The literals are from the enumeration {@link org.eclipselabs.mscript.language.ast.AddSubtractOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operators</em>' attribute list.
   * @see org.eclipselabs.mscript.language.ast.AddSubtractOperator
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getAddSubtractExpression_Operators()
   * @model unique="false"
   * @generated
   */
  EList<AddSubtractOperator> getOperators();

} // AddSubtractExpression

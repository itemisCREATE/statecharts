/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiply Divide Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression#getOperands <em>Operands</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getMultiplyDivideExpression()
 * @model
 * @generated
 */
public interface MultiplyDivideExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operands</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getMultiplyDivideExpression_Operands()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getOperands();

  /**
   * Returns the value of the '<em><b>Operators</b></em>' attribute list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator}.
   * The literals are from the enumeration {@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operators</em>' attribute list.
   * @see org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getMultiplyDivideExpression_Operators()
   * @model unique="false"
   * @generated
   */
  EList<MultiplyDivideOperator> getOperators();

} // MultiplyDivideExpression

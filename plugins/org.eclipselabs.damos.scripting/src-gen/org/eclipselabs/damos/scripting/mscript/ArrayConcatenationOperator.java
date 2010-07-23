/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Concatenation Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.ArrayConcatenationOperator#getExpressionLists <em>Expression Lists</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getArrayConcatenationOperator()
 * @model
 * @generated
 */
public interface ArrayConcatenationOperator extends Expression
{
  /**
   * Returns the value of the '<em><b>Expression Lists</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.ExpressionList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression Lists</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression Lists</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getArrayConcatenationOperator_ExpressionLists()
   * @model containment="true"
   * @generated
   */
  EList<ExpressionList> getExpressionLists();

} // ArrayConcatenationOperator

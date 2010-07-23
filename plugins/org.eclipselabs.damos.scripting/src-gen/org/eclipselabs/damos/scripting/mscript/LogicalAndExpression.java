/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical And Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.LogicalAndExpression#getOperands <em>Operands</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getLogicalAndExpression()
 * @model
 * @generated
 */
public interface LogicalAndExpression extends Expression
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
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getLogicalAndExpression_Operands()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getOperands();

} // LogicalAndExpression

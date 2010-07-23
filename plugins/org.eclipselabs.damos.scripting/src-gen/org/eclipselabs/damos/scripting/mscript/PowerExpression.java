/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.PowerExpression#getOperands <em>Operands</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.PowerExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.PowerExpression#getExponent <em>Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getPowerExpression()
 * @model
 * @generated
 */
public interface PowerExpression extends Expression
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
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getPowerExpression_Operands()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getOperands();

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipselabs.damos.scripting.mscript.PowerOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operator</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.eclipselabs.damos.scripting.mscript.PowerOperator
   * @see #setOperator(PowerOperator)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getPowerExpression_Operator()
   * @model
   * @generated
   */
  PowerOperator getOperator();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.PowerExpression#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.eclipselabs.damos.scripting.mscript.PowerOperator
   * @see #getOperator()
   * @generated
   */
  void setOperator(PowerOperator value);

  /**
   * Returns the value of the '<em><b>Exponent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exponent</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exponent</em>' containment reference.
   * @see #setExponent(Expression)
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getPowerExpression_Exponent()
   * @model containment="true"
   * @generated
   */
  Expression getExponent();

  /**
   * Sets the value of the '{@link org.eclipselabs.damos.scripting.mscript.PowerExpression#getExponent <em>Exponent</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exponent</em>' containment reference.
   * @see #getExponent()
   * @generated
   */
  void setExponent(Expression value);

} // PowerExpression

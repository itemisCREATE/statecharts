/**
 */
package org.yakindu.base.expressions.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bool Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.BoolLiteral#isValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getBoolLiteral()
 * @model
 * @generated
 */
public interface BoolLiteral extends Literal
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(boolean)
   * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getBoolLiteral_Value()
   * @model
   * @generated
   */
  boolean isValue();

  /**
   * Sets the value of the '{@link org.yakindu.base.expressions.expressions.BoolLiteral#isValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #isValue()
   * @generated
   */
  void setValue(boolean value);

} // BoolLiteral

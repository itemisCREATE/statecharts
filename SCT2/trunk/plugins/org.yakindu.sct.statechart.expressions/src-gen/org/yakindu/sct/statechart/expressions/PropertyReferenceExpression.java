/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;

import org.yakindu.model.sct.statechart.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.PropertyReferenceExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getPropertyReferenceExpression()
 * @model
 * @generated
 */
public interface PropertyReferenceExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' reference.
   * @see #setValue(Variable)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getPropertyReferenceExpression_Value()
   * @model
   * @generated
   */
  Variable getValue();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.PropertyReferenceExpression#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Variable value);

} // PropertyReferenceExpression

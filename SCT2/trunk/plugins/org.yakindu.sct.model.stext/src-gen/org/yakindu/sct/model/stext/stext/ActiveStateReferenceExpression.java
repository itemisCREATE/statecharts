/**
 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.sct.model.sgraph.State;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Active State Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getActiveStateReferenceExpression()
 * @model
 * @generated
 */
public interface ActiveStateReferenceExpression extends Expression
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
   * @see #setValue(State)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getActiveStateReferenceExpression_Value()
   * @model
   * @generated
   */
  State getValue();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(State value);

} // ActiveStateReferenceExpression

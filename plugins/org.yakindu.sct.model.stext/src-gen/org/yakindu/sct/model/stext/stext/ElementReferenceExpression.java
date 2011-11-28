/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.sct.model.sgraph.Declaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getElementReferenceExpression()
 * @model
 * @generated
 */
public interface ElementReferenceExpression extends Expression
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
   * @see #setValue(Declaration)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getElementReferenceExpression_Value()
   * @model
   * @generated
   */
  Declaration getValue();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getValue <em>Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Declaration value);

} // ElementReferenceExpression

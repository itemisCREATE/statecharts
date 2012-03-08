/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.base.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Element Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getTypedElementReferenceExpression()
 * @model
 * @generated
 */
public interface TypedElementReferenceExpression extends Expression
{
  /**
   * Returns the value of the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Reference</em>' reference.
   * @see #setReference(NamedElement)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getTypedElementReferenceExpression_Reference()
   * @model
   * @generated
   */
  NamedElement getReference();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression#getReference <em>Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Reference</em>' reference.
   * @see #getReference()
   * @generated
   */
  void setReference(NamedElement value);

} // TypedElementReferenceExpression

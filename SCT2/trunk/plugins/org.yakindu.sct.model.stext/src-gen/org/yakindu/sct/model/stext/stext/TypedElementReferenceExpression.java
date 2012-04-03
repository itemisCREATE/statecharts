/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;

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
 *   <li>{@link org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression#isOperationCall <em>Operation Call</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression#getArgs <em>Args</em>}</li>
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

  /**
   * Returns the value of the '<em><b>Operation Call</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation Call</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation Call</em>' attribute.
   * @see #setOperationCall(boolean)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getTypedElementReferenceExpression_OperationCall()
   * @model
   * @generated
   */
  boolean isOperationCall();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression#isOperationCall <em>Operation Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Call</em>' attribute.
   * @see #isOperationCall()
   * @generated
   */
  void setOperationCall(boolean value);

  /**
   * Returns the value of the '<em><b>Args</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.model.stext.stext.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Args</em>' containment reference list.
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getTypedElementReferenceExpression_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // TypedElementReferenceExpression

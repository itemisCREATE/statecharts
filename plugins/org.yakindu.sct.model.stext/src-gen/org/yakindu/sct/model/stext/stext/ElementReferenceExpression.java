/**
 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getReference <em>Reference</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#isOperationCall <em>Operation Call</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getArgs <em>Args</em>}</li>
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
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(EObject)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getElementReferenceExpression_Reference()
	 * @model
	 * @generated
	 */
  EObject getReference();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
  void setReference(EObject value);

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
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getElementReferenceExpression_OperationCall()
	 * @model
	 * @generated
	 */
  boolean isOperationCall();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#isOperationCall <em>Operation Call</em>}' attribute.
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
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getElementReferenceExpression_Args()
	 * @model containment="true"
	 * @generated
	 */
  EList<Expression> getArgs();

} // ElementReferenceExpression

/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.OperationCall#getOperation <em>Operation</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.OperationCall#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperationCall()
 * @model
 * @generated
 */
public interface OperationCall extends Expression
{
  /**
   * Returns the value of the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation</em>' reference.
   * @see #setOperation(Operation)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperationCall_Operation()
   * @model
   * @generated
   */
  Operation getOperation();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.OperationCall#getOperation <em>Operation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation</em>' reference.
   * @see #getOperation()
   * @generated
   */
  void setOperation(Operation value);

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
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperationCall_Args()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArgs();

} // OperationCall

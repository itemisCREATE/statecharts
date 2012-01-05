/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;

import org.yakindu.base.types.Type;

import org.yakindu.sct.model.sgraph.Declaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.Operation#getParamTypes <em>Param Types</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.Operation#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends Declaration
{
  /**
   * Returns the value of the '<em><b>Param Types</b></em>' reference list.
   * The list contents are of type {@link org.yakindu.base.types.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param Types</em>' reference list.
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperation_ParamTypes()
   * @model
   * @generated
   */
  EList<Type> getParamTypes();

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(Type)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperation_Type()
   * @model
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.Operation#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(Type value);

} // Operation

/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;

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
   * Returns the value of the '<em><b>Param Types</b></em>' attribute list.
   * The list contents are of type {@link org.yakindu.sct.model.stext.stext.Type}.
   * The literals are from the enumeration {@link org.yakindu.sct.model.stext.stext.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param Types</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Param Types</em>' attribute list.
   * @see org.yakindu.sct.model.stext.stext.Type
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperation_ParamTypes()
   * @model unique="false"
   * @generated
   */
  EList<Type> getParamTypes();

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.yakindu.sct.model.stext.stext.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.yakindu.sct.model.stext.stext.Type
   * @see #setType(Type)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperation_Type()
   * @model
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.Operation#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.yakindu.sct.model.stext.stext.Type
   * @see #getType()
   * @generated
   */
  void setType(Type value);

} // Operation

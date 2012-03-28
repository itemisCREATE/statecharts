/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.sct.model.sgraph.Declaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.OperationDefinition#getParams <em>Params</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperationDefinition()
 * @model
 * @generated
 */
public interface OperationDefinition extends Declaration, Operation
{
  /**
   * Returns the value of the '<em><b>Params</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.base.types.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Params</em>' containment reference list.
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getOperationDefinition_Params()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParams();

} // OperationDefinition

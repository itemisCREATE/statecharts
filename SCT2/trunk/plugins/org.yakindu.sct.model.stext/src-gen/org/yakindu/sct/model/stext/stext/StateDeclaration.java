/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.sct.model.sgraph.Scope;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.StateDeclaration#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getStateDeclaration()
 * @model
 * @generated
 */
public interface StateDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Scope</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scope</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Scope</em>' containment reference.
   * @see #setScope(Scope)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getStateDeclaration_Scope()
   * @model containment="true"
   * @generated
   */
  Scope getScope();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.StateDeclaration#getScope <em>Scope</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Scope</em>' containment reference.
   * @see #getScope()
   * @generated
   */
  void setScope(Scope value);

} // StateDeclaration

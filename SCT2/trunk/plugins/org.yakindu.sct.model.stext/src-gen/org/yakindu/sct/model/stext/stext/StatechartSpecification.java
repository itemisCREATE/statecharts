/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.sct.model.sgraph.Scope;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statechart Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.StatechartSpecification#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.StatechartSpecification#getDefinitionScopes <em>Definition Scopes</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getStatechartSpecification()
 * @model
 * @generated
 */
public interface StatechartSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Namespace</em>' attribute.
   * @see #setNamespace(String)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getStatechartSpecification_Namespace()
   * @model
   * @generated
   */
  String getNamespace();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.StatechartSpecification#getNamespace <em>Namespace</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Namespace</em>' attribute.
   * @see #getNamespace()
   * @generated
   */
  void setNamespace(String value);

  /**
   * Returns the value of the '<em><b>Definition Scopes</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.model.sgraph.Scope}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definition Scopes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definition Scopes</em>' containment reference list.
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getStatechartSpecification_DefinitionScopes()
   * @model containment="true"
   * @generated
   */
  EList<Scope> getDefinitionScopes();

} // StatechartSpecification

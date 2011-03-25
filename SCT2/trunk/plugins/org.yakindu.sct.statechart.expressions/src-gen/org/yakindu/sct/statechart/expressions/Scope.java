/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.Scope#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getScope()
 * @model
 * @generated
 */
public interface Scope extends EObject
{
  /**
   * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.statechart.expressions.Definition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definitions</em>' containment reference list.
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getScope_Definitions()
   * @model containment="true"
   * @generated
   */
  EList<Definition> getDefinitions();

} // Scope

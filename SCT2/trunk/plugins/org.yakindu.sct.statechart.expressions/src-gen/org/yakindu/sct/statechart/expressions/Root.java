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
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.Root#getRoots <em>Roots</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject
{
  /**
   * Returns the value of the '<em><b>Roots</b></em>' containment reference list.
   * The list contents are of type {@link org.yakindu.sct.statechart.expressions.DefRoot}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Roots</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Roots</em>' containment reference list.
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getRoot_Roots()
   * @model containment="true"
   * @generated
   */
  EList<DefRoot> getRoots();

} // Root

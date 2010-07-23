/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Subscript List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.ArraySubscriptList#getSubscripts <em>Subscripts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getArraySubscriptList()
 * @model
 * @generated
 */
public interface ArraySubscriptList extends EObject
{
  /**
   * Returns the value of the '<em><b>Subscripts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.Subscript}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subscripts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subscripts</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getArraySubscriptList_Subscripts()
   * @model containment="true"
   * @generated
   */
  EList<Subscript> getSubscripts();

} // ArraySubscriptList

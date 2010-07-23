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
 * A representation of the model object '<em><b>Function Argument List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.FunctionArgumentList#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipselabs.damos.scripting.mscript.FunctionArgumentList#getNamedArguments <em>Named Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getFunctionArgumentList()
 * @model
 * @generated
 */
public interface FunctionArgumentList extends EObject
{
  /**
   * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Arguments</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getFunctionArgumentList_Arguments()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getArguments();

  /**
   * Returns the value of the '<em><b>Named Arguments</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.damos.scripting.mscript.NamedArgument}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Named Arguments</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Named Arguments</em>' containment reference list.
   * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage#getFunctionArgumentList_NamedArguments()
   * @model containment="true"
   * @generated
   */
  EList<NamedArgument> getNamedArguments();

} // FunctionArgumentList

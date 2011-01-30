/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.Module#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getModule()
 * @model
 * @generated
 */
public interface Module extends EObject
{
  /**
   * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Definition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definitions</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getModule_Definitions()
   * @model containment="true"
   * @generated
   */
  EList<Definition> getDefinitions();

} // Module

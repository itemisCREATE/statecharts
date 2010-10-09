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
 * A representation of the model object '<em><b>Precondition Chain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.PreconditionChain#getPreconditions <em>Preconditions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getPreconditionChain()
 * @model
 * @generated
 */
public interface PreconditionChain extends EObject
{
  /**
   * Returns the value of the '<em><b>Preconditions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Preconditions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Preconditions</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getPreconditionChain_Preconditions()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getPreconditions();

} // PreconditionChain

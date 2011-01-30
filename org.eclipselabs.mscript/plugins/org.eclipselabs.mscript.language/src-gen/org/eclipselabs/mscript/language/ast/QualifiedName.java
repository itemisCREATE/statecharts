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
 * A representation of the model object '<em><b>Qualified Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.QualifiedName#getIdentifiers <em>Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getQualifiedName()
 * @model
 * @generated
 */
public interface QualifiedName extends EObject
{
  /**
   * Returns the value of the '<em><b>Identifiers</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifiers</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifiers</em>' attribute list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getQualifiedName_Identifiers()
   * @model unique="false"
   * @generated
   */
  EList<String> getIdentifiers();

} // QualifiedName

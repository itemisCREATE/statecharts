/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Element Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ArrayElementReference#getSubscripts <em>Subscripts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayElementReference()
 * @model
 * @generated
 */
public interface ArrayElementReference extends FeatureCallPart
{
  /**
   * Returns the value of the '<em><b>Subscripts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Subscript}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subscripts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subscripts</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getArrayElementReference_Subscripts()
   * @model containment="true"
   * @generated
   */
  EList<Subscript> getSubscripts();

} // ArrayElementReference

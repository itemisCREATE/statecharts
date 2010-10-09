/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.CheckDefinition#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.CheckDefinition#getPreconditionChain <em>Precondition Chain</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.CheckDefinition#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getCheckDefinition()
 * @model
 * @generated
 */
public interface CheckDefinition extends TypeDefinition
{
  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ParameterDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getCheckDefinition_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<ParameterDeclaration> getParameters();

  /**
   * Returns the value of the '<em><b>Precondition Chain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Precondition Chain</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Precondition Chain</em>' containment reference.
   * @see #setPreconditionChain(PreconditionChain)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getCheckDefinition_PreconditionChain()
   * @model containment="true"
   * @generated
   */
  PreconditionChain getPreconditionChain();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.CheckDefinition#getPreconditionChain <em>Precondition Chain</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Precondition Chain</em>' containment reference.
   * @see #getPreconditionChain()
   * @generated
   */
  void setPreconditionChain(PreconditionChain value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(Block)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getCheckDefinition_Body()
   * @model containment="true"
   * @generated
   */
  Block getBody();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.CheckDefinition#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(Block value);

} // CheckDefinition

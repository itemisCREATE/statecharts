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
 * A representation of the model object '<em><b>Functor Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctorDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctorDeclaration#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctorDeclaration#getTemplateArgumentDeclarations <em>Template Argument Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctorDeclaration()
 * @model
 * @generated
 */
public interface FunctorDeclaration extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctorDeclaration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FunctorDeclaration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Function Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Name</em>' containment reference.
   * @see #setFunctionName(QualifiedName)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctorDeclaration_FunctionName()
   * @model containment="true"
   * @generated
   */
  QualifiedName getFunctionName();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FunctorDeclaration#getFunctionName <em>Function Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Function Name</em>' containment reference.
   * @see #getFunctionName()
   * @generated
   */
  void setFunctionName(QualifiedName value);

  /**
   * Returns the value of the '<em><b>Template Argument Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ArgumentDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template Argument Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template Argument Declarations</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctorDeclaration_TemplateArgumentDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<ArgumentDeclaration> getTemplateArgumentDeclarations();

} // FunctorDeclaration

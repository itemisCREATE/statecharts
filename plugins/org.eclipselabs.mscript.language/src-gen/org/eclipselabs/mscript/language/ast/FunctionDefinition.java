/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#isStateful <em>Stateful</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getTemplateParameterDeclarations <em>Template Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getInputParameterDeclarations <em>Input Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getOutputParameterDeclarations <em>Output Parameter Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getAssertionDeclarations <em>Assertion Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getFunctorDeclarations <em>Functor Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getEquations <em>Equations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition()
 * @model
 * @generated
 */
public interface FunctionDefinition extends TypeDefinition
{
  /**
   * Returns the value of the '<em><b>Stateful</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stateful</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Stateful</em>' attribute.
   * @see #setStateful(boolean)
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_Stateful()
   * @model
   * @generated
   */
  boolean isStateful();

  /**
   * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#isStateful <em>Stateful</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Stateful</em>' attribute.
   * @see #isStateful()
   * @generated
   */
  void setStateful(boolean value);

  /**
   * Returns the value of the '<em><b>Template Parameter Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ParameterDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template Parameter Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template Parameter Declarations</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_TemplateParameterDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<ParameterDeclaration> getTemplateParameterDeclarations();

  /**
   * Returns the value of the '<em><b>Input Parameter Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ParameterDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Input Parameter Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input Parameter Declarations</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_InputParameterDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<ParameterDeclaration> getInputParameterDeclarations();

  /**
   * Returns the value of the '<em><b>Output Parameter Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ParameterDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output Parameter Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output Parameter Declarations</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_OutputParameterDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<ParameterDeclaration> getOutputParameterDeclarations();

  /**
   * Returns the value of the '<em><b>Assertion Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.AssertionDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assertion Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assertion Declarations</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_AssertionDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<AssertionDeclaration> getAssertionDeclarations();

  /**
   * Returns the value of the '<em><b>Functor Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.FunctorDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Functor Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functor Declarations</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_FunctorDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<FunctorDeclaration> getFunctorDeclarations();

  /**
   * Returns the value of the '<em><b>State Variable Declarations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.StateVariableDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Variable Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Variable Declarations</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_StateVariableDeclarations()
   * @model containment="true"
   * @generated
   */
  EList<StateVariableDeclaration> getStateVariableDeclarations();

  /**
   * Returns the value of the '<em><b>Equations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.EquationDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Equations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Equations</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_Equations()
   * @model containment="true"
   * @generated
   */
  EList<EquationDefinition> getEquations();

} // FunctionDefinition

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
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getTemplateParameters <em>Template Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getInputParameters <em>Input Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getOutputParameters <em>Output Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getFunctors <em>Functors</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getStateVariables <em>State Variables</em>}</li>
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
   * Returns the value of the '<em><b>Template Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ParameterDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Template Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Template Parameters</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_TemplateParameters()
   * @model containment="true"
   * @generated
   */
  EList<ParameterDeclaration> getTemplateParameters();

  /**
   * Returns the value of the '<em><b>Input Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ParameterDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Input Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input Parameters</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_InputParameters()
   * @model containment="true"
   * @generated
   */
  EList<ParameterDeclaration> getInputParameters();

  /**
   * Returns the value of the '<em><b>Output Parameters</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.ParameterDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output Parameters</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_OutputParameters()
   * @model containment="true"
   * @generated
   */
  EList<ParameterDeclaration> getOutputParameters();

  /**
   * Returns the value of the '<em><b>Assertions</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.AssertionDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assertions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assertions</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_Assertions()
   * @model containment="true"
   * @generated
   */
  EList<AssertionDeclaration> getAssertions();

  /**
   * Returns the value of the '<em><b>Functors</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.FunctorDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Functors</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functors</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_Functors()
   * @model containment="true"
   * @generated
   */
  EList<FunctorDeclaration> getFunctors();

  /**
   * Returns the value of the '<em><b>State Variables</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipselabs.mscript.language.ast.VariableDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Variables</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Variables</em>' containment reference list.
   * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_StateVariables()
   * @model containment="true"
   * @generated
   */
  EList<VariableDeclaration> getStateVariables();

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

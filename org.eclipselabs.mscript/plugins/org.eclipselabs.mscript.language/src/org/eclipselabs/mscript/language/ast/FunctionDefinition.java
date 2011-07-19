/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getTests <em>Tests</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getAssertions <em>Assertions</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getFunctionObjectDeclarations <em>Function Object Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getEquations <em>Equations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition()
 * @model
 * @generated
 */
public interface FunctionDefinition extends Definition, CallableElement {
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
	 * Returns the value of the '<em><b>Tests</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Test}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tests</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tests</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_Tests()
	 * @model containment="true"
	 * @generated
	 */
	EList<Test> getTests();

	/**
	 * Returns the value of the '<em><b>Assertions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Assertion}.
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
	EList<Assertion> getAssertions();

	/**
	 * Returns the value of the '<em><b>Function Object Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Object Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Object Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getFunctionDefinition_FunctionObjectDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<FunctionObjectDeclaration> getFunctionObjectDeclarations();

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
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Equation}.
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
	EList<Equation> getEquations();

} // FunctionDefinition

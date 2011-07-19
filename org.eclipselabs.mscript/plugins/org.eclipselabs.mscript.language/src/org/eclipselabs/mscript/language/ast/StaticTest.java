/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;

import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.StaticTest#getTemplateArguments <em>Template Arguments</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.StaticTest#getInputParameterTypes <em>Input Parameter Types</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.StaticTest#getOutputParameterTypes <em>Output Parameter Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getStaticTest()
 * @model
 * @generated
 */
public interface StaticTest extends Test {
	/**
	 * Returns the value of the '<em><b>Template Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.typesystem.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Arguments</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getStaticTest_TemplateArguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getTemplateArguments();

	/**
	 * Returns the value of the '<em><b>Input Parameter Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Parameter Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Parameter Types</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getStaticTest_InputParameterTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataTypeSpecifier> getInputParameterTypes();

	/**
	 * Returns the value of the '<em><b>Output Parameter Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Parameter Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Parameter Types</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getStaticTest_OutputParameterTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataTypeSpecifier> getOutputParameterTypes();

} // StaticTest

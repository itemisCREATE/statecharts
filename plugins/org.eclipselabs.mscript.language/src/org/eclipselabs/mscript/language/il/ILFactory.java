/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.il.ILPackage
 * @generated
 */
public interface ILFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ILFactory eINSTANCE = org.eclipselabs.mscript.language.il.impl.ILFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Definition</em>'.
	 * @generated
	 */
	ILFunctionDefinition createILFunctionDefinition();

	/**
	 * Returns a new object of class '<em>Compound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound</em>'.
	 * @generated
	 */
	Compound createCompound();

	/**
	 * Returns a new object of class '<em>Computation Compound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computation Compound</em>'.
	 * @generated
	 */
	ComputationCompound createComputationCompound();

	/**
	 * Returns a new object of class '<em>Template Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Variable Declaration</em>'.
	 * @generated
	 */
	TemplateVariableDeclaration createTemplateVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Input Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Variable Declaration</em>'.
	 * @generated
	 */
	InputVariableDeclaration createInputVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Output Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Variable Declaration</em>'.
	 * @generated
	 */
	OutputVariableDeclaration createOutputVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Instance Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Variable Declaration</em>'.
	 * @generated
	 */
	InstanceVariableDeclaration createInstanceVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Local Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Variable Declaration</em>'.
	 * @generated
	 */
	LocalVariableDeclaration createLocalVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Compound Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound Statement</em>'.
	 * @generated
	 */
	CompoundStatement createCompoundStatement();

	/**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
	Assignment createAssignment();

	/**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
	IfStatement createIfStatement();

	/**
	 * Returns a new object of class '<em>Foreach Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Foreach Statement</em>'.
	 * @generated
	 */
	ForeachStatement createForeachStatement();

	/**
	 * Returns a new object of class '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Reference</em>'.
	 * @generated
	 */
	VariableReference createVariableReference();

	/**
	 * Returns a new object of class '<em>Builtin Function Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Function Call</em>'.
	 * @generated
	 */
	BuiltinFunctionCall createBuiltinFunctionCall();

	/**
	 * Returns a new object of class '<em>Invalid Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Expression</em>'.
	 * @generated
	 */
	InvalidExpression createInvalidExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ILPackage getILPackage();

} //ILFactory

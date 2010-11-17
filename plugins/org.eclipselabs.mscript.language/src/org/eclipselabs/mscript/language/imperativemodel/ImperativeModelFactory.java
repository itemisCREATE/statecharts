/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage
 * @generated
 */
public interface ImperativeModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImperativeModelFactory eINSTANCE = org.eclipselabs.mscript.language.imperativemodel.impl.ImperativeModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Imperative Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Imperative Function</em>'.
	 * @generated
	 */
	ImperativeFunction createImperativeFunction();

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
	 * Returns a new object of class '<em>Constant Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constant Declaration</em>'.
	 * @generated
	 */
	ConstantDeclaration createConstantDeclaration();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ImperativeModelPackage getImperativeModelPackage();

} //ImperativeModelFactory

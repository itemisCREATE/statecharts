/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage
 * @generated
 */
public interface FunctionModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctionModelFactory eINSTANCE = org.eclipselabs.mscript.language.functionmodel.impl.FunctionModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Function Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Descriptor</em>'.
	 * @generated
	 */
	FunctionDescriptor createFunctionDescriptor();

	/**
	 * Returns a new object of class '<em>Equation Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equation Descriptor</em>'.
	 * @generated
	 */
	EquationDescriptor createEquationDescriptor();

	/**
	 * Returns a new object of class '<em>Equation Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equation Side</em>'.
	 * @generated
	 */
	EquationSide createEquationSide();

	/**
	 * Returns a new object of class '<em>Equation Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equation Part</em>'.
	 * @generated
	 */
	EquationPart createEquationPart();

	/**
	 * Returns a new object of class '<em>Variable Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Descriptor</em>'.
	 * @generated
	 */
	VariableDescriptor createVariableDescriptor();

	/**
	 * Returns a new object of class '<em>Variable Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Step</em>'.
	 * @generated
	 */
	VariableStep createVariableStep();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FunctionModelPackage getFunctionModelPackage();

} //FunctionModelFactory

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage
 * @generated
 */
public interface ComputationModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComputationModelFactory eINSTANCE = org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Floating Point Format</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Floating Point Format</em>'.
	 * @generated
	 */
	FloatingPointFormat createFloatingPointFormat();

	/**
	 * Returns a new object of class '<em>Fixed Point Format</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Point Format</em>'.
	 * @generated
	 */
	FixedPointFormat createFixedPointFormat();

	/**
	 * Returns a new object of class '<em>Fixed Point Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Point Operation</em>'.
	 * @generated
	 */
	FixedPointOperation createFixedPointOperation();

	/**
	 * Returns a new object of class '<em>Computation Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computation Model</em>'.
	 * @generated
	 */
	ComputationModel createComputationModel();

	/**
	 * Returns a new object of class '<em>Number Format Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Format Mapping</em>'.
	 * @generated
	 */
	NumberFormatMapping createNumberFormatMapping();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComputationModelPackage getComputationModelPackage();

} //ComputationModelFactory

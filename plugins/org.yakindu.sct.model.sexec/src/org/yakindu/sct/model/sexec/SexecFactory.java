/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.sexec.SexecPackage
 * @generated
 */
public interface SexecFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SexecFactory eINSTANCE = org.yakindu.sct.model.sexec.impl.SexecFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Execution Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Flow</em>'.
	 * @generated
	 */
	ExecutionFlow createExecutionFlow();

	/**
	 * Returns a new object of class '<em>Execution State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution State</em>'.
	 * @generated
	 */
	ExecutionState createExecutionState();

	/**
	 * Returns a new object of class '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Named Element</em>'.
	 * @generated
	 */
	NamedElement createNamedElement();

	/**
	 * Returns a new object of class '<em>Cycle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cycle</em>'.
	 * @generated
	 */
	Cycle createCycle();

	/**
	 * Returns a new object of class '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence</em>'.
	 * @generated
	 */
	Sequence createSequence();

	/**
	 * Returns a new object of class '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If</em>'.
	 * @generated
	 */
	If createIf();

	/**
	 * Returns a new object of class '<em>Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution</em>'.
	 * @generated
	 */
	Execution createExecution();

	/**
	 * Returns a new object of class '<em>Enter State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enter State</em>'.
	 * @generated
	 */
	EnterState createEnterState();

	/**
	 * Returns a new object of class '<em>Exit State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exit State</em>'.
	 * @generated
	 */
	ExitState createExitState();

	/**
	 * Returns a new object of class '<em>Sequence Execution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequence Execution</em>'.
	 * @generated
	 */
	SequenceExecution createSequenceExecution();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SexecPackage getSexecPackage();

} //SexecFactory

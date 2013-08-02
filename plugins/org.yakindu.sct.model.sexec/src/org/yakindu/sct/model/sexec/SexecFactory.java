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
	 * Returns a new object of class '<em>Execution Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Node</em>'.
	 * @generated
	 */
	ExecutionNode createExecutionNode();

	/**
	 * Returns a new object of class '<em>Execution State</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution State</em>'.
	 * @generated
	 */
	ExecutionState createExecutionState();

	/**
	 * Returns a new object of class '<em>Execution Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Scope</em>'.
	 * @generated
	 */
	ExecutionScope createExecutionScope();

	/**
	 * Returns a new object of class '<em>Execution Region</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Region</em>'.
	 * @generated
	 */
	ExecutionRegion createExecutionRegion();

	/**
	 * Returns a new object of class '<em>Execution Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Entry</em>'.
	 * @generated
	 */
	ExecutionEntry createExecutionEntry();

	/**
	 * Returns a new object of class '<em>Execution Exit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Exit</em>'.
	 * @generated
	 */
	ExecutionExit createExecutionExit();

	/**
	 * Returns a new object of class '<em>Execution Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Choice</em>'.
	 * @generated
	 */
	ExecutionChoice createExecutionChoice();

	/**
	 * Returns a new object of class '<em>Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reaction</em>'.
	 * @generated
	 */
	Reaction createReaction();

	/**
	 * Returns a new object of class '<em>Mapped Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapped Element</em>'.
	 * @generated
	 */
	MappedElement createMappedElement();

	/**
	 * Returns a new object of class '<em>Check</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check</em>'.
	 * @generated
	 */
	Check createCheck();

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
	 * Returns a new object of class '<em>Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Call</em>'.
	 * @generated
	 */
	Call createCall();

	/**
	 * Returns a new object of class '<em>Schedule Time Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Schedule Time Event</em>'.
	 * @generated
	 */
	ScheduleTimeEvent createScheduleTimeEvent();

	/**
	 * Returns a new object of class '<em>Unschedule Time Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unschedule Time Event</em>'.
	 * @generated
	 */
	UnscheduleTimeEvent createUnscheduleTimeEvent();

	/**
	 * Returns a new object of class '<em>State Switch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Switch</em>'.
	 * @generated
	 */
	StateSwitch createStateSwitch();

	/**
	 * Returns a new object of class '<em>State Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Case</em>'.
	 * @generated
	 */
	StateCase createStateCase();

	/**
	 * Returns a new object of class '<em>Trace Node Executed</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Node Executed</em>'.
	 * @generated
	 */
	TraceNodeExecuted createTraceNodeExecuted();

	/**
	 * Returns a new object of class '<em>Reaction Fired</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reaction Fired</em>'.
	 * @generated
	 */
	ReactionFired createReactionFired();

	/**
	 * Returns a new object of class '<em>Trace Reaction Will Fire</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Reaction Will Fire</em>'.
	 * @generated
	 */
	TraceReactionWillFire createTraceReactionWillFire();

	/**
	 * Returns a new object of class '<em>Trace State Entered</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace State Entered</em>'.
	 * @generated
	 */
	TraceStateEntered createTraceStateEntered();

	/**
	 * Returns a new object of class '<em>Trace State Exited</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace State Exited</em>'.
	 * @generated
	 */
	TraceStateExited createTraceStateExited();

	/**
	 * Returns a new object of class '<em>Trace Begin Run Cycle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace Begin Run Cycle</em>'.
	 * @generated
	 */
	TraceBeginRunCycle createTraceBeginRunCycle();

	/**
	 * Returns a new object of class '<em>Trace End Run Cycle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Trace End Run Cycle</em>'.
	 * @generated
	 */
	TraceEndRunCycle createTraceEndRunCycle();

	/**
	 * Returns a new object of class '<em>Save History</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Save History</em>'.
	 * @generated
	 */
	SaveHistory createSaveHistory();

	/**
	 * Returns a new object of class '<em>History Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>History Entry</em>'.
	 * @generated
	 */
	HistoryEntry createHistoryEntry();

	/**
	 * Returns a new object of class '<em>Execution Synchronization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Synchronization</em>'.
	 * @generated
	 */
	ExecutionSynchronization createExecutionSynchronization();

	/**
	 * Returns a new object of class '<em>Check Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check Ref</em>'.
	 * @generated
	 */
	CheckRef createCheckRef();

	/**
	 * Returns a new object of class '<em>State Vector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Vector</em>'.
	 * @generated
	 */
	StateVector createStateVector();

	/**
	 * Returns a new object of class '<em>Time Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Event</em>'.
	 * @generated
	 */
	TimeEvent createTimeEvent();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SexecPackage getSexecPackage();

} //SexecFactory

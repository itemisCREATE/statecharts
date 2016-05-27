/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.PackageMember;
import org.yakindu.base.types.TypedElement;
import org.yakindu.sct.model.sexec.*;
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionChoice;
import org.yakindu.sct.model.sexec.ExecutionEntry;
import org.yakindu.sct.model.sexec.ExecutionExit;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionNode;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.ExecutionScope;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExecutionSynchronization;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.HistoryEntry;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.MappedElement;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.SaveHistory;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.model.sexec.TraceBeginRunCycle;
import org.yakindu.sct.model.sexec.TraceEndRunCycle;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceReactionWillFire;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;
import org.yakindu.sct.model.sgraph.ScopedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.sexec.SexecPackage
 * @generated
 */
public class SexecSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SexecPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SexecSwitch() {
		if (modelPackage == null) {
			modelPackage = SexecPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SexecPackage.MAPPED_ELEMENT: {
				MappedElement mappedElement = (MappedElement)theEObject;
				T result = caseMappedElement(mappedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXECUTION_FLOW: {
				ExecutionFlow executionFlow = (ExecutionFlow)theEObject;
				T result = caseExecutionFlow(executionFlow);
				if (result == null) result = caseScopedElement(executionFlow);
				if (result == null) result = caseExecutionScope(executionFlow);
				if (result == null) result = caseExecutionNode(executionFlow);
				if (result == null) result = caseMappedElement(executionFlow);
				if (result == null) result = caseNamedElement(executionFlow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXECUTION_NODE: {
				ExecutionNode executionNode = (ExecutionNode)theEObject;
				T result = caseExecutionNode(executionNode);
				if (result == null) result = caseMappedElement(executionNode);
				if (result == null) result = caseNamedElement(executionNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXECUTION_STATE: {
				ExecutionState executionState = (ExecutionState)theEObject;
				T result = caseExecutionState(executionState);
				if (result == null) result = caseExecutionNode(executionState);
				if (result == null) result = caseExecutionScope(executionState);
				if (result == null) result = caseMappedElement(executionState);
				if (result == null) result = caseNamedElement(executionState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXECUTION_SCOPE: {
				ExecutionScope executionScope = (ExecutionScope)theEObject;
				T result = caseExecutionScope(executionScope);
				if (result == null) result = caseMappedElement(executionScope);
				if (result == null) result = caseNamedElement(executionScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXECUTION_REGION: {
				ExecutionRegion executionRegion = (ExecutionRegion)theEObject;
				T result = caseExecutionRegion(executionRegion);
				if (result == null) result = caseExecutionScope(executionRegion);
				if (result == null) result = caseMappedElement(executionRegion);
				if (result == null) result = caseNamedElement(executionRegion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXECUTION_ENTRY: {
				ExecutionEntry executionEntry = (ExecutionEntry)theEObject;
				T result = caseExecutionEntry(executionEntry);
				if (result == null) result = caseExecutionNode(executionEntry);
				if (result == null) result = caseMappedElement(executionEntry);
				if (result == null) result = caseNamedElement(executionEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXECUTION_EXIT: {
				ExecutionExit executionExit = (ExecutionExit)theEObject;
				T result = caseExecutionExit(executionExit);
				if (result == null) result = caseExecutionNode(executionExit);
				if (result == null) result = caseMappedElement(executionExit);
				if (result == null) result = caseNamedElement(executionExit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXECUTION_CHOICE: {
				ExecutionChoice executionChoice = (ExecutionChoice)theEObject;
				T result = caseExecutionChoice(executionChoice);
				if (result == null) result = caseExecutionNode(executionChoice);
				if (result == null) result = caseMappedElement(executionChoice);
				if (result == null) result = caseNamedElement(executionChoice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXECUTION_SYNCHRONIZATION: {
				ExecutionSynchronization executionSynchronization = (ExecutionSynchronization)theEObject;
				T result = caseExecutionSynchronization(executionSynchronization);
				if (result == null) result = caseExecutionNode(executionSynchronization);
				if (result == null) result = caseMappedElement(executionSynchronization);
				if (result == null) result = caseNamedElement(executionSynchronization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.REACTION: {
				Reaction reaction = (Reaction)theEObject;
				T result = caseReaction(reaction);
				if (result == null) result = caseMappedElement(reaction);
				if (result == null) result = caseNamedElement(reaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.STATE_VECTOR: {
				StateVector stateVector = (StateVector)theEObject;
				T result = caseStateVector(stateVector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.TIME_EVENT: {
				TimeEvent timeEvent = (TimeEvent)theEObject;
				T result = caseTimeEvent(timeEvent);
				if (result == null) result = caseEvent(timeEvent);
				if (result == null) result = caseDeclaration(timeEvent);
				if (result == null) result = caseTypedElement(timeEvent);
				if (result == null) result = casePackageMember(timeEvent);
				if (result == null) result = caseNamedElement(timeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.STEP: {
				Step step = (Step)theEObject;
				T result = caseStep(step);
				if (result == null) result = caseNamedElement(step);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.SEQUENCE: {
				Sequence sequence = (Sequence)theEObject;
				T result = caseSequence(sequence);
				if (result == null) result = caseStep(sequence);
				if (result == null) result = caseNamedElement(sequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.CHECK: {
				Check check = (Check)theEObject;
				T result = caseCheck(check);
				if (result == null) result = caseStep(check);
				if (result == null) result = caseNamedElement(check);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.CHECK_REF: {
				CheckRef checkRef = (CheckRef)theEObject;
				T result = caseCheckRef(checkRef);
				if (result == null) result = caseCheck(checkRef);
				if (result == null) result = caseStep(checkRef);
				if (result == null) result = caseNamedElement(checkRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.IF: {
				If if_ = (If)theEObject;
				T result = caseIf(if_);
				if (result == null) result = caseStep(if_);
				if (result == null) result = caseNamedElement(if_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXECUTION: {
				Execution execution = (Execution)theEObject;
				T result = caseExecution(execution);
				if (result == null) result = caseStep(execution);
				if (result == null) result = caseNamedElement(execution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.ENTER_STATE: {
				EnterState enterState = (EnterState)theEObject;
				T result = caseEnterState(enterState);
				if (result == null) result = caseStep(enterState);
				if (result == null) result = caseNamedElement(enterState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.EXIT_STATE: {
				ExitState exitState = (ExitState)theEObject;
				T result = caseExitState(exitState);
				if (result == null) result = caseStep(exitState);
				if (result == null) result = caseNamedElement(exitState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.CALL: {
				Call call = (Call)theEObject;
				T result = caseCall(call);
				if (result == null) result = caseStep(call);
				if (result == null) result = caseNamedElement(call);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.SCHEDULE_TIME_EVENT: {
				ScheduleTimeEvent scheduleTimeEvent = (ScheduleTimeEvent)theEObject;
				T result = caseScheduleTimeEvent(scheduleTimeEvent);
				if (result == null) result = caseStep(scheduleTimeEvent);
				if (result == null) result = caseNamedElement(scheduleTimeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.UNSCHEDULE_TIME_EVENT: {
				UnscheduleTimeEvent unscheduleTimeEvent = (UnscheduleTimeEvent)theEObject;
				T result = caseUnscheduleTimeEvent(unscheduleTimeEvent);
				if (result == null) result = caseStep(unscheduleTimeEvent);
				if (result == null) result = caseNamedElement(unscheduleTimeEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.STATE_SWITCH: {
				StateSwitch stateSwitch = (StateSwitch)theEObject;
				T result = caseStateSwitch(stateSwitch);
				if (result == null) result = caseStep(stateSwitch);
				if (result == null) result = caseNamedElement(stateSwitch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.STATE_CASE: {
				StateCase stateCase = (StateCase)theEObject;
				T result = caseStateCase(stateCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.SAVE_HISTORY: {
				SaveHistory saveHistory = (SaveHistory)theEObject;
				T result = caseSaveHistory(saveHistory);
				if (result == null) result = caseStep(saveHistory);
				if (result == null) result = caseNamedElement(saveHistory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.HISTORY_ENTRY: {
				HistoryEntry historyEntry = (HistoryEntry)theEObject;
				T result = caseHistoryEntry(historyEntry);
				if (result == null) result = caseStep(historyEntry);
				if (result == null) result = caseNamedElement(historyEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.TRACE: {
				Trace trace = (Trace)theEObject;
				T result = caseTrace(trace);
				if (result == null) result = caseStep(trace);
				if (result == null) result = caseNamedElement(trace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.TRACE_NODE_EXECUTED: {
				TraceNodeExecuted traceNodeExecuted = (TraceNodeExecuted)theEObject;
				T result = caseTraceNodeExecuted(traceNodeExecuted);
				if (result == null) result = caseTrace(traceNodeExecuted);
				if (result == null) result = caseStep(traceNodeExecuted);
				if (result == null) result = caseNamedElement(traceNodeExecuted);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.REACTION_FIRED: {
				ReactionFired reactionFired = (ReactionFired)theEObject;
				T result = caseReactionFired(reactionFired);
				if (result == null) result = caseTrace(reactionFired);
				if (result == null) result = caseStep(reactionFired);
				if (result == null) result = caseNamedElement(reactionFired);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.TRACE_REACTION_WILL_FIRE: {
				TraceReactionWillFire traceReactionWillFire = (TraceReactionWillFire)theEObject;
				T result = caseTraceReactionWillFire(traceReactionWillFire);
				if (result == null) result = caseTrace(traceReactionWillFire);
				if (result == null) result = caseStep(traceReactionWillFire);
				if (result == null) result = caseNamedElement(traceReactionWillFire);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.TRACE_STATE_ENTERED: {
				TraceStateEntered traceStateEntered = (TraceStateEntered)theEObject;
				T result = caseTraceStateEntered(traceStateEntered);
				if (result == null) result = caseTrace(traceStateEntered);
				if (result == null) result = caseStep(traceStateEntered);
				if (result == null) result = caseNamedElement(traceStateEntered);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.TRACE_STATE_EXITED: {
				TraceStateExited traceStateExited = (TraceStateExited)theEObject;
				T result = caseTraceStateExited(traceStateExited);
				if (result == null) result = caseTrace(traceStateExited);
				if (result == null) result = caseStep(traceStateExited);
				if (result == null) result = caseNamedElement(traceStateExited);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.TRACE_BEGIN_RUN_CYCLE: {
				TraceBeginRunCycle traceBeginRunCycle = (TraceBeginRunCycle)theEObject;
				T result = caseTraceBeginRunCycle(traceBeginRunCycle);
				if (result == null) result = caseTrace(traceBeginRunCycle);
				if (result == null) result = caseStep(traceBeginRunCycle);
				if (result == null) result = caseNamedElement(traceBeginRunCycle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SexecPackage.TRACE_END_RUN_CYCLE: {
				TraceEndRunCycle traceEndRunCycle = (TraceEndRunCycle)theEObject;
				T result = caseTraceEndRunCycle(traceEndRunCycle);
				if (result == null) result = caseTrace(traceEndRunCycle);
				if (result == null) result = caseStep(traceEndRunCycle);
				if (result == null) result = caseNamedElement(traceEndRunCycle);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Flow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Flow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionFlow(ExecutionFlow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionNode(ExecutionNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionState(ExecutionState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionScope(ExecutionScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Region</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Region</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionRegion(ExecutionRegion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionEntry(ExecutionEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Exit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Exit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionExit(ExecutionExit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionChoice(ExecutionChoice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReaction(Reaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageMember(PackageMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaration(Declaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappedElement(MappedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Check</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheck(Check object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStep(Step object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequence(Sequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIf(If object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecution(Execution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enter State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enter State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnterState(EnterState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exit State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exit State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExitState(ExitState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCall(Call object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Schedule Time Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Schedule Time Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScheduleTimeEvent(ScheduleTimeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unschedule Time Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unschedule Time Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnscheduleTimeEvent(UnscheduleTimeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Switch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Switch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateSwitch(StateSwitch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateCase(StateCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrace(Trace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Node Executed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Node Executed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceNodeExecuted(TraceNodeExecuted object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reaction Fired</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reaction Fired</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReactionFired(ReactionFired object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Reaction Will Fire</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Reaction Will Fire</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceReactionWillFire(TraceReactionWillFire object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace State Entered</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace State Entered</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceStateEntered(TraceStateEntered object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace State Exited</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace State Exited</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceStateExited(TraceStateExited object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace Begin Run Cycle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace Begin Run Cycle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceBeginRunCycle(TraceBeginRunCycle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trace End Run Cycle</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trace End Run Cycle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraceEndRunCycle(TraceEndRunCycle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Save History</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Save History</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSaveHistory(SaveHistory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>History Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>History Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHistoryEntry(HistoryEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Execution Synchronization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execution Synchronization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExecutionSynchronization(ExecutionSynchronization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Check Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckRef(CheckRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Vector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Vector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateVector(StateVector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeEvent(TimeEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scoped Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scoped Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopedElement(ScopedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SexecSwitch

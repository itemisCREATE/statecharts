/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.base.NamedElement;
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
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.ScopedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.sexec.SexecPackage
 * @generated
 */
public class SexecAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SexecPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SexecAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SexecPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SexecSwitch<Adapter> modelSwitch =
		new SexecSwitch<Adapter>() {
			@Override
			public Adapter caseMappedElement(MappedElement object) {
				return createMappedElementAdapter();
			}
			@Override
			public Adapter caseExecutionFlow(ExecutionFlow object) {
				return createExecutionFlowAdapter();
			}
			@Override
			public Adapter caseExecutionNode(ExecutionNode object) {
				return createExecutionNodeAdapter();
			}
			@Override
			public Adapter caseExecutionState(ExecutionState object) {
				return createExecutionStateAdapter();
			}
			@Override
			public Adapter caseExecutionScope(ExecutionScope object) {
				return createExecutionScopeAdapter();
			}
			@Override
			public Adapter caseExecutionRegion(ExecutionRegion object) {
				return createExecutionRegionAdapter();
			}
			@Override
			public Adapter caseExecutionEntry(ExecutionEntry object) {
				return createExecutionEntryAdapter();
			}
			@Override
			public Adapter caseExecutionExit(ExecutionExit object) {
				return createExecutionExitAdapter();
			}
			@Override
			public Adapter caseExecutionChoice(ExecutionChoice object) {
				return createExecutionChoiceAdapter();
			}
			@Override
			public Adapter caseExecutionSynchronization(ExecutionSynchronization object) {
				return createExecutionSynchronizationAdapter();
			}
			@Override
			public Adapter caseReaction(Reaction object) {
				return createReactionAdapter();
			}
			@Override
			public Adapter caseStateVector(StateVector object) {
				return createStateVectorAdapter();
			}
			@Override
			public Adapter caseTimeEvent(TimeEvent object) {
				return createTimeEventAdapter();
			}
			@Override
			public Adapter caseStep(Step object) {
				return createStepAdapter();
			}
			@Override
			public Adapter caseSequence(Sequence object) {
				return createSequenceAdapter();
			}
			@Override
			public Adapter caseCheck(Check object) {
				return createCheckAdapter();
			}
			@Override
			public Adapter caseCheckRef(CheckRef object) {
				return createCheckRefAdapter();
			}
			@Override
			public Adapter caseIf(If object) {
				return createIfAdapter();
			}
			@Override
			public Adapter caseExecution(Execution object) {
				return createExecutionAdapter();
			}
			@Override
			public Adapter caseEnterState(EnterState object) {
				return createEnterStateAdapter();
			}
			@Override
			public Adapter caseExitState(ExitState object) {
				return createExitStateAdapter();
			}
			@Override
			public Adapter caseCall(Call object) {
				return createCallAdapter();
			}
			@Override
			public Adapter caseScheduleTimeEvent(ScheduleTimeEvent object) {
				return createScheduleTimeEventAdapter();
			}
			@Override
			public Adapter caseUnscheduleTimeEvent(UnscheduleTimeEvent object) {
				return createUnscheduleTimeEventAdapter();
			}
			@Override
			public Adapter caseStateSwitch(StateSwitch object) {
				return createStateSwitchAdapter();
			}
			@Override
			public Adapter caseStateCase(StateCase object) {
				return createStateCaseAdapter();
			}
			@Override
			public Adapter caseSaveHistory(SaveHistory object) {
				return createSaveHistoryAdapter();
			}
			@Override
			public Adapter caseHistoryEntry(HistoryEntry object) {
				return createHistoryEntryAdapter();
			}
			@Override
			public Adapter caseTrace(Trace object) {
				return createTraceAdapter();
			}
			@Override
			public Adapter caseTraceNodeExecuted(TraceNodeExecuted object) {
				return createTraceNodeExecutedAdapter();
			}
			@Override
			public Adapter caseReactionFired(ReactionFired object) {
				return createReactionFiredAdapter();
			}
			@Override
			public Adapter caseTraceReactionWillFire(TraceReactionWillFire object) {
				return createTraceReactionWillFireAdapter();
			}
			@Override
			public Adapter caseTraceStateEntered(TraceStateEntered object) {
				return createTraceStateEnteredAdapter();
			}
			@Override
			public Adapter caseTraceStateExited(TraceStateExited object) {
				return createTraceStateExitedAdapter();
			}
			@Override
			public Adapter caseTraceBeginRunCycle(TraceBeginRunCycle object) {
				return createTraceBeginRunCycleAdapter();
			}
			@Override
			public Adapter caseTraceEndRunCycle(TraceEndRunCycle object) {
				return createTraceEndRunCycleAdapter();
			}
			@Override
			public Adapter caseScopedElement(ScopedElement object) {
				return createScopedElementAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseDeclaration(Declaration object) {
				return createDeclarationAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ExecutionFlow <em>Execution Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ExecutionFlow
	 * @generated
	 */
	public Adapter createExecutionFlowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ExecutionNode <em>Execution Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ExecutionNode
	 * @generated
	 */
	public Adapter createExecutionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ExecutionState <em>Execution State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ExecutionState
	 * @generated
	 */
	public Adapter createExecutionStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ExecutionScope <em>Execution Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ExecutionScope
	 * @generated
	 */
	public Adapter createExecutionScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ExecutionRegion <em>Execution Region</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ExecutionRegion
	 * @generated
	 */
	public Adapter createExecutionRegionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ExecutionEntry <em>Execution Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ExecutionEntry
	 * @generated
	 */
	public Adapter createExecutionEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ExecutionExit <em>Execution Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ExecutionExit
	 * @generated
	 */
	public Adapter createExecutionExitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ExecutionChoice <em>Execution Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ExecutionChoice
	 * @generated
	 */
	public Adapter createExecutionChoiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.Reaction <em>Reaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.Reaction
	 * @generated
	 */
	public Adapter createReactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.base.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.base.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.MappedElement <em>Mapped Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.MappedElement
	 * @generated
	 */
	public Adapter createMappedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.Check <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.Check
	 * @generated
	 */
	public Adapter createCheckAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.Step <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.Step
	 * @generated
	 */
	public Adapter createStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.Sequence
	 * @generated
	 */
	public Adapter createSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.If
	 * @generated
	 */
	public Adapter createIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.Execution <em>Execution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.Execution
	 * @generated
	 */
	public Adapter createExecutionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.EnterState <em>Enter State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.EnterState
	 * @generated
	 */
	public Adapter createEnterStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ExitState <em>Exit State</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ExitState
	 * @generated
	 */
	public Adapter createExitStateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.Call
	 * @generated
	 */
	public Adapter createCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ScheduleTimeEvent <em>Schedule Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ScheduleTimeEvent
	 * @generated
	 */
	public Adapter createScheduleTimeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.UnscheduleTimeEvent <em>Unschedule Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.UnscheduleTimeEvent
	 * @generated
	 */
	public Adapter createUnscheduleTimeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.StateSwitch <em>State Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.StateSwitch
	 * @generated
	 */
	public Adapter createStateSwitchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.StateCase <em>State Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.StateCase
	 * @generated
	 */
	public Adapter createStateCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.Trace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.Trace
	 * @generated
	 */
	public Adapter createTraceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.TraceNodeExecuted <em>Trace Node Executed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.TraceNodeExecuted
	 * @generated
	 */
	public Adapter createTraceNodeExecutedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ReactionFired <em>Reaction Fired</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ReactionFired
	 * @generated
	 */
	public Adapter createReactionFiredAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.TraceReactionWillFire <em>Trace Reaction Will Fire</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.TraceReactionWillFire
	 * @generated
	 */
	public Adapter createTraceReactionWillFireAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.TraceStateEntered <em>Trace State Entered</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.TraceStateEntered
	 * @generated
	 */
	public Adapter createTraceStateEnteredAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.TraceStateExited <em>Trace State Exited</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.TraceStateExited
	 * @generated
	 */
	public Adapter createTraceStateExitedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.TraceBeginRunCycle <em>Trace Begin Run Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.TraceBeginRunCycle
	 * @generated
	 */
	public Adapter createTraceBeginRunCycleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.TraceEndRunCycle <em>Trace End Run Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.TraceEndRunCycle
	 * @generated
	 */
	public Adapter createTraceEndRunCycleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.SaveHistory <em>Save History</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.SaveHistory
	 * @generated
	 */
	public Adapter createSaveHistoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.HistoryEntry <em>History Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.HistoryEntry
	 * @generated
	 */
	public Adapter createHistoryEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.ExecutionSynchronization <em>Execution Synchronization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.ExecutionSynchronization
	 * @generated
	 */
	public Adapter createExecutionSynchronizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.CheckRef <em>Check Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.CheckRef
	 * @generated
	 */
	public Adapter createCheckRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.StateVector <em>State Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.StateVector
	 * @generated
	 */
	public Adapter createStateVectorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sexec.TimeEvent <em>Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sexec.TimeEvent
	 * @generated
	 */
	public Adapter createTimeEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.ScopedElement <em>Scoped Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.ScopedElement
	 * @generated
	 */
	public Adapter createScopedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.Declaration
	 * @generated
	 */
	public Adapter createDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SexecAdapterFactory

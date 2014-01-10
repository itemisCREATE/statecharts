/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
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
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.TraceBeginRunCycle;
import org.yakindu.sct.model.sexec.TraceEndRunCycle;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceReactionWillFire;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SexecFactoryImpl extends EFactoryImpl implements SexecFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SexecFactory init() {
		try {
			SexecFactory theSexecFactory = (SexecFactory)EPackage.Registry.INSTANCE.getEFactory(SexecPackage.eNS_URI);
			if (theSexecFactory != null) {
				return theSexecFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SexecFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SexecFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SexecPackage.MAPPED_ELEMENT: return createMappedElement();
			case SexecPackage.EXECUTION_FLOW: return createExecutionFlow();
			case SexecPackage.EXECUTION_NODE: return createExecutionNode();
			case SexecPackage.EXECUTION_STATE: return createExecutionState();
			case SexecPackage.EXECUTION_SCOPE: return createExecutionScope();
			case SexecPackage.EXECUTION_REGION: return createExecutionRegion();
			case SexecPackage.EXECUTION_ENTRY: return createExecutionEntry();
			case SexecPackage.EXECUTION_EXIT: return createExecutionExit();
			case SexecPackage.EXECUTION_CHOICE: return createExecutionChoice();
			case SexecPackage.EXECUTION_SYNCHRONIZATION: return createExecutionSynchronization();
			case SexecPackage.REACTION: return createReaction();
			case SexecPackage.STATE_VECTOR: return createStateVector();
			case SexecPackage.TIME_EVENT: return createTimeEvent();
			case SexecPackage.SEQUENCE: return createSequence();
			case SexecPackage.CHECK: return createCheck();
			case SexecPackage.CHECK_REF: return createCheckRef();
			case SexecPackage.IF: return createIf();
			case SexecPackage.EXECUTION: return createExecution();
			case SexecPackage.ENTER_STATE: return createEnterState();
			case SexecPackage.EXIT_STATE: return createExitState();
			case SexecPackage.CALL: return createCall();
			case SexecPackage.SCHEDULE_TIME_EVENT: return createScheduleTimeEvent();
			case SexecPackage.UNSCHEDULE_TIME_EVENT: return createUnscheduleTimeEvent();
			case SexecPackage.STATE_SWITCH: return createStateSwitch();
			case SexecPackage.STATE_CASE: return createStateCase();
			case SexecPackage.SAVE_HISTORY: return createSaveHistory();
			case SexecPackage.HISTORY_ENTRY: return createHistoryEntry();
			case SexecPackage.TRACE_NODE_EXECUTED: return createTraceNodeExecuted();
			case SexecPackage.REACTION_FIRED: return createReactionFired();
			case SexecPackage.TRACE_REACTION_WILL_FIRE: return createTraceReactionWillFire();
			case SexecPackage.TRACE_STATE_ENTERED: return createTraceStateEntered();
			case SexecPackage.TRACE_STATE_EXITED: return createTraceStateExited();
			case SexecPackage.TRACE_BEGIN_RUN_CYCLE: return createTraceBeginRunCycle();
			case SexecPackage.TRACE_END_RUN_CYCLE: return createTraceEndRunCycle();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionFlow createExecutionFlow() {
		ExecutionFlowImpl executionFlow = new ExecutionFlowImpl();
		return executionFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionNode createExecutionNode() {
		ExecutionNodeImpl executionNode = new ExecutionNodeImpl();
		return executionNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionState createExecutionState() {
		ExecutionStateImpl executionState = new ExecutionStateImpl();
		return executionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionScope createExecutionScope() {
		ExecutionScopeImpl executionScope = new ExecutionScopeImpl();
		return executionScope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionRegion createExecutionRegion() {
		ExecutionRegionImpl executionRegion = new ExecutionRegionImpl();
		return executionRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionEntry createExecutionEntry() {
		ExecutionEntryImpl executionEntry = new ExecutionEntryImpl();
		return executionEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionExit createExecutionExit() {
		ExecutionExitImpl executionExit = new ExecutionExitImpl();
		return executionExit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionChoice createExecutionChoice() {
		ExecutionChoiceImpl executionChoice = new ExecutionChoiceImpl();
		return executionChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reaction createReaction() {
		ReactionImpl reaction = new ReactionImpl();
		return reaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedElement createMappedElement() {
		MappedElementImpl mappedElement = new MappedElementImpl();
		return mappedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Check createCheck() {
		CheckImpl check = new CheckImpl();
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence createSequence() {
		SequenceImpl sequence = new SequenceImpl();
		return sequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Execution createExecution() {
		ExecutionImpl execution = new ExecutionImpl();
		return execution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnterState createEnterState() {
		EnterStateImpl enterState = new EnterStateImpl();
		return enterState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExitState createExitState() {
		ExitStateImpl exitState = new ExitStateImpl();
		return exitState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Call createCall() {
		CallImpl call = new CallImpl();
		return call;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleTimeEvent createScheduleTimeEvent() {
		ScheduleTimeEventImpl scheduleTimeEvent = new ScheduleTimeEventImpl();
		return scheduleTimeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnscheduleTimeEvent createUnscheduleTimeEvent() {
		UnscheduleTimeEventImpl unscheduleTimeEvent = new UnscheduleTimeEventImpl();
		return unscheduleTimeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateSwitch createStateSwitch() {
		StateSwitchImpl stateSwitch = new StateSwitchImpl();
		return stateSwitch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateCase createStateCase() {
		StateCaseImpl stateCase = new StateCaseImpl();
		return stateCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceNodeExecuted createTraceNodeExecuted() {
		TraceNodeExecutedImpl traceNodeExecuted = new TraceNodeExecutedImpl();
		return traceNodeExecuted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReactionFired createReactionFired() {
		ReactionFiredImpl reactionFired = new ReactionFiredImpl();
		return reactionFired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceReactionWillFire createTraceReactionWillFire() {
		TraceReactionWillFireImpl traceReactionWillFire = new TraceReactionWillFireImpl();
		return traceReactionWillFire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceStateEntered createTraceStateEntered() {
		TraceStateEnteredImpl traceStateEntered = new TraceStateEnteredImpl();
		return traceStateEntered;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceStateExited createTraceStateExited() {
		TraceStateExitedImpl traceStateExited = new TraceStateExitedImpl();
		return traceStateExited;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceBeginRunCycle createTraceBeginRunCycle() {
		TraceBeginRunCycleImpl traceBeginRunCycle = new TraceBeginRunCycleImpl();
		return traceBeginRunCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceEndRunCycle createTraceEndRunCycle() {
		TraceEndRunCycleImpl traceEndRunCycle = new TraceEndRunCycleImpl();
		return traceEndRunCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaveHistory createSaveHistory() {
		SaveHistoryImpl saveHistory = new SaveHistoryImpl();
		return saveHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HistoryEntry createHistoryEntry() {
		HistoryEntryImpl historyEntry = new HistoryEntryImpl();
		return historyEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionSynchronization createExecutionSynchronization() {
		ExecutionSynchronizationImpl executionSynchronization = new ExecutionSynchronizationImpl();
		return executionSynchronization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckRef createCheckRef() {
		CheckRefImpl checkRef = new CheckRefImpl();
		return checkRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVector createStateVector() {
		StateVectorImpl stateVector = new StateVectorImpl();
		return stateVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeEvent createTimeEvent() {
		TimeEventImpl timeEvent = new TimeEventImpl();
		return timeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SexecPackage getSexecPackage() {
		return (SexecPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SexecPackage getPackage() {
		return SexecPackage.eINSTANCE;
	}

} //SexecFactoryImpl

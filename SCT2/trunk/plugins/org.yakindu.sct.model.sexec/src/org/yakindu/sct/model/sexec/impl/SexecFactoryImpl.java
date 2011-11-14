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
import org.yakindu.sct.model.sexec.Cycle;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.NamedElement;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecFactory;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.StateVector;
import org.yakindu.sct.model.sexec.TimeEvent;
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
			SexecFactory theSexecFactory = (SexecFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.yakindu.org/sct/sexec/1.0.0"); 
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
			case SexecPackage.EXECUTION_FLOW: return createExecutionFlow();
			case SexecPackage.NAMED_ELEMENT: return createNamedElement();
			case SexecPackage.STATE_VECTOR: return createStateVector();
			case SexecPackage.TIME_EVENT: return createTimeEvent();
			case SexecPackage.EXECUTION_STATE: return createExecutionState();
			case SexecPackage.REACTION: return createReaction();
			case SexecPackage.SEQUENCE: return createSequence();
			case SexecPackage.CYCLE: return createCycle();
			case SexecPackage.CHECK: return createCheck();
			case SexecPackage.CHECK_REF: return createCheckRef();
			case SexecPackage.IF: return createIf();
			case SexecPackage.EXECUTION: return createExecution();
			case SexecPackage.ENTER_STATE: return createEnterState();
			case SexecPackage.EXIT_STATE: return createExitState();
			case SexecPackage.CALL: return createCall();
			case SexecPackage.SCHEDULE_TIME_EVENT: return createScheduleTimeEvent();
			case SexecPackage.UNSCHEDULE_TIME_EVENT: return createUnscheduleTimeEvent();
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
	public ExecutionState createExecutionState() {
		ExecutionStateImpl executionState = new ExecutionStateImpl();
		return executionState;
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
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Cycle createCycle() {
		CycleImpl cycle = new CycleImpl();
		return cycle;
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

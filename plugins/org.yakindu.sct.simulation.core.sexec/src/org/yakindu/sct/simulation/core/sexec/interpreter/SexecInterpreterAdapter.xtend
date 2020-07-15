package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.Trace
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.simulation.core.sexec.container.EventDrivenSimulationEngine.EventDrivenCycleAdapter
import org.yakindu.sct.simulation.core.util.ExecutionContextExtensions

class SexecInterpreterAdapter implements IExecutionFlowInterpreter, IEventRaiser {
	
	
	@Inject protected extension SexecInterpreter interpreter

	protected CompositeSlot stateMachine

	@Inject(optional=true)
	ITraceStepInterpreter traceInterpreter
	
	@Inject protected extension ExecutionContextExtensions
	@Inject
	protected StateVectorExtensions stateVectorExtensions;
	@Inject
	protected extension StatechartAnnotations

	protected ExecutionFlow flow

	protected static final Trace beginRunCycleTrace = SexecFactory.eINSTANCE.createTraceBeginRunCycle
	protected static final Trace endRunCycleTrace = SexecFactory.eINSTANCE.createTraceEndRunCycle

	override initialize(ExecutionFlow flow, ExecutionContext context) {
		initialize(flow, context, false)
	}

	override initialize(ExecutionFlow flow, ExecutionContext context, boolean useInternalEventQueue) {

		interpreter.heap = context
		this.flow = flow
		
		stateMachine = interpreter.newInstance(flow)

		init		
	}

	override ExecutionContext getExecutionContext(){
		interpreter.heap	
	}
	

	def init() {
		stateMachine._invoke("init")		
	}
	
	override enter() {
		stateMachine._invoke("enter")
	}

	override exit() {
		stateMachine._invoke("exit")
	}


	override runCycle() {
		
		// TODO Should not care about cycle adapter here - move to simulation engine where it is defined.  
		val cycleAdapter = EcoreUtil.getExistingAdapter(executionContext,
			EventDrivenCycleAdapter) as EventDrivenCycleAdapter
		try {
			if (cycleAdapter !== null)
				executionContext.eAdapters.remove(cycleAdapter)

			stateMachine._invoke("runCycle")
			
		} finally {

			if (cycleAdapter !== null)
				executionContext.eAdapters.add(cycleAdapter)
			
		}
	}

	def ExecutionState toExecutionState(RegularState state) {
		return flow.eAllContents.filter(ExecutionState).findFirst [
			EcoreUtil.equals(sourceElement, state)
		]
	}


	override tearDown() {
	}


	override raise(ExecutionEvent ev, Object value) {
		ev._raise(value)		
	}

	/**
	 * TODO: move to instance delegate
	 */
	override boolean isActive() {
		return executionContext.getAllActiveStates().size > 0
	}
	
	/**
	 * TODO: move to instance delegate
	 */
	override boolean isFinal() {
		var List<ExecutionState>[] list = stateVectorExtensions.finalStateImpactVector(flow);
		var boolean isCompletlyCovered = stateVectorExtensions.isCompletelyCovered(list);
		if (!isCompletlyCovered) {
			return false;
		} else {
			var List<RegularState> activeStates = executionContext.getAllActiveStates();
			if (activeStates.isEmpty) {
				return false;
			}
			for (RegularState regularState : activeStates) {
				if (!(regularState instanceof FinalState)) {
					return false;
				}
			}
			return true;
		}
	}
	
	override isStateActive(String stateName) {
		return stateMachine._invoke("isStateActive", stateName) == true
	}

	override getExecutionFlow() {
		flow
	}
	
		
}
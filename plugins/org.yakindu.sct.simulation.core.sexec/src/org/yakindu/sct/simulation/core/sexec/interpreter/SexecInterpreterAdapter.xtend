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
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler.TimeTask
import org.eclipse.xtend.lib.annotations.Accessors

class SexecInterpreterAdapter implements IExecutionFlowInterpreter, IEventRaiser {
	
	
	@Inject protected extension SexecInterpreter interpreter

	protected CompositeSlot stateMachine
	
	@Inject(optional=true)
	ITraceStepInterpreter traceInterpreter
	TimerTaskSchedulerAdapter timeTaskSchedulerAdapter
	
	(()=>Object)=>Object executeWithoutContextAdapter = [ f | 

			val cycleAdapter = EcoreUtil.getExistingAdapter(executionContext,
				EventDrivenCycleAdapter) as EventDrivenCycleAdapter
	
			try {
				if (cycleAdapter !== null) executionContext.eAdapters.remove(cycleAdapter)

				f.apply
				
			} finally {
				if (cycleAdapter !== null) executionContext.eAdapters.add(cycleAdapter)
			}
	]
	
	@Inject protected extension ExecutionContextExtensions
	@Inject
	protected StateVectorExtensions stateVectorExtensions;
	@Inject
	protected extension StatechartAnnotations

	@Inject protected ITimeTaskScheduler timingService

	protected ExecutionFlow flow

	protected static final Trace beginRunCycleTrace = SexecFactory.eINSTANCE.createTraceBeginRunCycle
	protected static final Trace endRunCycleTrace = SexecFactory.eINSTANCE.createTraceEndRunCycle

	
	override initialize(ExecutionFlow flow, ExecutionContext context) {
		initialize(flow, context, false)
	}

	override initialize(ExecutionFlow flow, ExecutionContext context, boolean useInternalEventQueue) {

		timeTaskSchedulerAdapter = new TimerTaskSchedulerAdapter
		timeTaskSchedulerAdapter.timeTaskAdapter = [ task |
			executeWithoutContextAdapter.apply([ 
				task.run 
				return null
			])			
		]
		
		interpreter.heap = context
		timeTaskSchedulerAdapter.original = interpreter.timingService
		interpreter.timingService = timeTaskSchedulerAdapter
		
		this.flow = flow
		
		stateMachine = interpreter.newInstance(flow)

		init		
	}

	override ExecutionContext getExecutionContext(){
		interpreter.heap	
	}
	

	def init() {
		
		executeWithoutContextAdapter.apply([
			
			stateMachine._invoke("init")				
		])
	}
	
	override enter() {
		executeWithoutContextAdapter.apply([	
			
			stateMachine._invoke("enter")
		])
	}

	override exit() {
		
		executeWithoutContextAdapter.apply([

			stateMachine._invoke("exit")		
		])
	}


	override runCycle() {
		
		executeWithoutContextAdapter.apply([
			
			stateMachine._invoke("runCycle")
		])
						
	}

	def ExecutionState toExecutionState(RegularState state) {
		return flow.eAllContents.filter(ExecutionState).findFirst [
			EcoreUtil.equals(sourceElement, state)
		]
	}


	override tearDown() {
	}


	override raise(ExecutionEvent ev, Object value) {
				
		executeWithoutContextAdapter.apply([

			ev._raise(value)					
		])
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
		
		executeWithoutContextAdapter.apply([
			stateMachine._invoke("isStateActive", stateName)
		])  == true
	}

	override getExecutionFlow() {
		flow
	}
	
		
	protected static class TimerTaskSchedulerAdapter implements ITimeTaskScheduler {
		
		@Accessors protected ITimeTaskScheduler original
		@Accessors protected (Runnable)=>void timeTaskAdapter
		
		override getCurrentTime() {
			original?.currentTime
		}
		
		override resume() {
			original?.resume
		}
		
		override scheduleTimeTask(TimeTask task, boolean isPeriodical, long duration) {
			original?.scheduleTimeTask( 
										if (timeTaskAdapter === null) 
											task 
				                        else
											 new TimeTask(task.name, [
												timeTaskAdapter.apply(task)
					 					]), 
					 					isPeriodical, 
					 					duration)
		}
		
		override start() {
			original?.start
		}
		
		override step() {
			original?.step
		}
		
		override suspend() {
			original?.suspend
		}
		
		override terminate() {
			original?.terminate
		}
		
		override timeLeap(long ms) {
			original?.timeLeap(ms)
		}
		
		override unscheduleTimeTask(String eventName) {
			original?.unscheduleTimeTask(eventName)
		}
		
	}
		
}
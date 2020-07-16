package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.Trace
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler
import org.yakindu.sct.simulation.core.sexec.container.EventDrivenSimulationEngine.EventDrivenCycleAdapter

@Singleton
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
		
		execute([	
			stateMachine._invoke("init")				
		])
	}
	
	override enter() {
		execute([	
			stateMachine._invoke("enter")
		])
	}

	override exit() {
		
		execute([
			stateMachine._invoke("exit")		
		])
	}


	override runCycle() {
		
		execute([
			stateMachine._invoke("runCycle")
		])
						
	}

	override raise(ExecutionEvent ev, Object value) {
		execute([ ev._raise(value) ])
	}

	override boolean isActive() {
		execute([ stateMachine._invoke("isActive") ]) == true
	}
	
	override boolean isFinal() {
		execute([ stateMachine._invoke("isFinal") ]) == true
	}
	
	override isStateActive(String stateName) {
		execute([ stateMachine._invoke("isStateActive", stateName) ]) == true
	}

	override tearDown() {}

	override getExecutionFlow() {
		flow
	}
	
	protected def Object execute(()=>Object action) {
		executeWithoutContextAdapter.apply(action)
	} 
		
	protected static class TimerTaskSchedulerAdapter implements ITimeTaskScheduler {
		
		@Accessors protected ITimeTaskScheduler original
		@Accessors protected (Runnable)=>void timeTaskAdapter
		
		override getCurrentTime() {
			if (original !== null) original.currentTime else 0
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
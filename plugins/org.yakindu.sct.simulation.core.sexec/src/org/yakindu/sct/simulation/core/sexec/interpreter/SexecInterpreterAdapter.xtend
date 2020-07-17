/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
 
package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler
import org.yakindu.sct.simulation.core.sexec.container.EventDrivenSimulationEngine.EventDrivenCycleAdapter

import static org.yakindu.sct.simulation.core.sexec.interpreter.SexecInterpreter.*

/**
 * Adapts an SexecInterpreter to the legacy IExecutionFlowInterpreter and IEventRaiser interfaces
 * 
 * The implementation delegates all provided methods to an SexecInterpreter instance. It cares about 
 * deactivating and reactivating EventDrivenCycleAdapter during processing and also intercepts the 
 * timer service for the same purpose.
 * 
 * @author axel terfloth
 */
@Singleton
class SexecInterpreterAdapter implements IExecutionFlowInterpreter, IEventRaiser {
	
	@Inject protected extension SexecInterpreter interpreter
	@Inject protected ITimeTaskScheduler timingService

	protected ExecutionFlow flow
	protected Object stateMachine
	protected SexecInterpreterAdapter.TimerTaskSchedulerInterceptor timeTaskSchedulerAdapter
	protected (()=>Object)=>Object executeWithoutContextAdapter = [ f | 

			val cycleAdapter = EcoreUtil.getExistingAdapter(executionContext,
				EventDrivenCycleAdapter) as EventDrivenCycleAdapter
	
			try {
				if (cycleAdapter !== null) executionContext.eAdapters.remove(cycleAdapter)

				f.apply
				
			} finally {
				if (cycleAdapter !== null) executionContext.eAdapters.add(cycleAdapter)
			}
	]
	

	override initialize(ExecutionFlow flow, ExecutionContext context) {
		initialize(flow, context, false)
	}

	override initialize(ExecutionFlow flow, ExecutionContext context, boolean useInternalEventQueue) {

		timeTaskSchedulerAdapter = new TimerTaskSchedulerInterceptor
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
		
		stateMachine = flow.newInstance

		init		
	}

	override ExecutionContext getExecutionContext(){
		interpreter.heap	
	}
	

	def init() {
		
		execute([	
			stateMachine.invokeOperation(INIT)				
		])
	}
	
	override enter() {
		execute([	
			stateMachine.invokeOperation(ENTER)
		])
	}

	override exit() {
		
		execute([
			stateMachine.invokeOperation(EXIT)		
		])
	}


	override runCycle() {
		
		execute([
			stateMachine.invokeOperation(RUN_CYCLE)
		])
						
	}

	override raise(ExecutionEvent ev, Object value) {
		execute([ 
			ev.raiseEvent(value) 
			return null
		])
	} 

	override boolean isActive() {
		execute([ stateMachine.invokeOperation(IS_ACTIVE) ]) == true
	}
	
	override boolean isFinal() {
		execute([ stateMachine.invokeOperation(IS_FINAL) ]) == true
	}
	
	override isStateActive(String stateName) {
		execute([ stateMachine.invokeOperation(IS_STATE_ACTIVE, stateName) ]) == true
	}

	override tearDown() {}

	override getExecutionFlow() {
		flow
	}
	
	protected def Object execute(()=>Object action) {
		executeWithoutContextAdapter.apply(action)
	} 
		
	/**
	 * Used to intercept the communication between interpreter and timer service.
	 */
	protected static class TimerTaskSchedulerInterceptor implements ITimeTaskScheduler {
		
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
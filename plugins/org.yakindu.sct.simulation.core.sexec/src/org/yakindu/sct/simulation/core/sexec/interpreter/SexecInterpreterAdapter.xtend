package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import java.util.LinkedList
import java.util.List
import java.util.Map
import java.util.Queue
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Data
import org.yakindu.base.types.Direction
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.Trace
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler.TimeTask
import org.yakindu.sct.simulation.core.sexec.container.EventDrivenSimulationEngine.EventDrivenCycleAdapter
import org.yakindu.sct.simulation.core.util.ExecutionContextExtensions

class SexecInterpreterAdapter implements IExecutionFlowInterpreter, IEventRaiser {
	

	@Data static class Event {

		public ExecutionEvent event;
		public Object value;

		new(ExecutionEvent ev, Object value) {
			this.event = ev
			this.value = value
		}
	}

	@Inject protected extension SexecInterpreter interpreter

	protected CompositeSlot stateMachine
	protected Queue<Event> internalEventQueue = new LinkedList<Event>()
	protected Queue<Event> inEventQueue = new LinkedList<Event>()


	

	
	@Inject
	ITimeTaskScheduler timingService

	@Inject(optional=true)
	ITraceStepInterpreter traceInterpreter
	@Inject protected extension ExecutionContextExtensions
	@Inject
	protected StateVectorExtensions stateVectorExtensions;
	@Inject
	protected extension StatechartAnnotations

	protected ExecutionFlow flow
	protected ExecutionState[] activeStateConfiguration
	protected Map<Integer, ExecutionState> historyStateConfiguration
	protected List<Step> executionStack
	protected int activeStateIndex
	protected boolean useInternalEventQueue
	protected boolean useInEventQueue

//	protected boolean useSuperStep
	protected boolean stateVectorChanged

	protected boolean isRunning = false

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


	def dispatch Object execute(SaveHistory action) {
		var region = action.region
		historyStateConfiguration.put(region.historyVector.offset,
			activeStateConfiguration.get(region.stateVector.offset))
	}

	def dispatch Object execute(HistoryEntry entry) {
		if (historyStateConfiguration.get(entry.region.historyVector.offset) !== null) {
			entry.historyStep?.execute
		} else {
			entry.initialStep?.execute
		}
		null
	}

	def dispatch Object execute(StateSwitch stateSwitch) {
		val historyRegion = stateSwitch.historyRegion
		if (historyRegion !== null) {
//			val historyState = historyStateConfiguration.get(historyRegion.historyVector.offset)
//			stateSwitch.cases.filter[it.state == historyState].forEach[step.schedule]
		} else {
//			stateSwitch.cases.filter[activeStateConfiguration.contains(state)].forEach[step.schedule]
		}
		null
	}

	def dispatch Object execute(ScheduleTimeEvent scheduleTimeEvent) {
		val timeEvent = scheduleTimeEvent.timeEvent
		val duration = interpreter.evaluate(scheduleTimeEvent.timeValue)
		timingService.scheduleTimeTask(new TimeTask(timeEvent.name, [
			executionContext.getEvent(timeEvent.name).raised = true
		]), timeEvent.periodic, duration as Long)
		null
	}

	def dispatch Object execute(UnscheduleTimeEvent timeEvent) {
		timingService.unscheduleTimeTask(timeEvent.timeEvent.name)
		null
	}

	override raise(ExecutionEvent ev, Object value) {
		if (useInternalEventQueue && ev.direction == Direction::LOCAL) {
			internalEventQueue.add(new Event(ev, value));
		} else if (useInEventQueue && ev.direction == Direction::IN) {
			inEventQueue.add(new Event(ev, value));
			runCycle
		} else {
			ev.value = value
			ev.raised = true
		}
	}

	override boolean isActive() {
		return executionContext.getAllActiveStates().size > 0
	}

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
		return if(stateName === null){
			activeStateConfiguration.exists[it === null]
		} else
			activeStateConfiguration.filterNull.exists[(it.sourceElement as RegularState).name == stateName]
	}

	override getExecutionFlow() {
		flow
	}
	
		
}
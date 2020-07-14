package org.yakindu.sct.simulation.core.sexec.interpreter

import java.util.ArrayDeque
import java.util.LinkedList
import java.util.Map
import java.util.Queue
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.expressions.interpreter.base.BaseExecution
import org.yakindu.base.expressions.interpreter.base.IInterpreter
import org.yakindu.base.expressions.interpreter.base.SRuntimeInterpreter.EventInstance
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionNode
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.concepts.EnterMethod
import org.yakindu.sct.model.sexec.concepts.EventProcessing
import org.yakindu.sct.model.sexec.concepts.ExitMethod
import org.yakindu.sct.model.sexec.concepts.InitializedCheck
import org.yakindu.sct.model.sexec.concepts.RunCycleMethod
import org.yakindu.sct.model.sexec.concepts.StateMachineBehaviorConcept
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.model.sruntime.ExecutionSlot
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.simulation.core.util.ExecutionContextExtensions
import org.yakindu.base.types.Direction

class ExecutionFlowInstanceDelegate extends BaseExecution implements IInterpreter.Resolver, IInterpreter.Instance {
	
	protected CompositeSlot instance
	protected ExecutionFlow type
	
	protected ExecutionState[] activeStateConfiguration
	protected Map<Integer, ExecutionState> historyStateConfiguration
	protected int activeStateIndex
	
	protected Queue<EventInstance> internalEventQueue = null 
	protected Queue<EventInstance> inEventQueue = null
	
	extension StateMachineBehaviorConcept = new StateMachineBehaviorConcept // TODO: Inject!!!
	extension ExecutionContextExtensions = new ExecutionContextExtensions // TODO: Inject!!
	extension StatechartAnnotations = new StatechartAnnotations // TODO: Inject!!
	
	def setUp(CompositeSlot instance, ExecutionFlow type, IInterpreter.Context context) {
		this.instance = instance	
		this.type = type
		this.context = context
		
		if (( type.sourceElement as Statechart).isEventDriven ) {
			this.internalEventQueue = new ArrayDeque<EventInstance>
			this.inEventQueue = new ArrayDeque<EventInstance>
		}
	}
	
	def _executeNamedSequence(Step it) {
		instance._executeOperation('_' + name + '_', #[],[
			_delegate			
		])		
	}	
	
	// TODO: 
	override provideExecution(Object program) {
		switch (program) {

			EnterState : program.execution
			ExitState : program.execution
			StateSwitch : program.execution
			SaveHistory : program.execution
			HistoryEntry : program.execution
			ActiveStateReferenceExpression : program.execution
			
			Call : _executeNamedSequence(program.step)				

			Sequence case program.name == RunCycleMethod.MICRO_STEP : microStep			
			Sequence case program.name == EventProcessing.CLEAR_EVENT : clearEvent(program.expression )			
			Sequence case program.name == EventProcessing.MOVE_EVENT : moveEvent(program.expression, program.getExpression(1))			
			Sequence case program.name == EventProcessing.NEXT_EVENT : nextEvent		
			Sequence case program.name == EnterMethod.TRACE_ENTER : _execute[]		// TODO
			Sequence case program.name == ExitMethod.TRACE_EXIT : _execute[]		// TODO	
			Sequence case program.name == InitializedCheck.INIT_CHECK : _execute[]	// do nothing so far ...		
			 
			Method case type.allMethods.contains(program): program.invoke 
						
			String case program.hasMethod : program.lookupMethod.invoke 
			
			case 'init': init
			case 'isStateActive': isStateActive

			default : 
				throw new IllegalArgumentException("Cannot execute '" + program +"'")
		}
	}


	def void init() {
		
		instance._executeOperation( "init", #[], [
			activeStateConfiguration = newArrayOfSize(type.stateVector.size)
			activeStateIndex = 0
			historyStateConfiguration = newHashMap()		

			//	this.useInternalEventQueue = useInternalEventQueue
			//	useInEventQueue = (flow.sourceElement as Statechart).isEventDriven

			_executeNamedSequence( type.staticInitSequence )
			_executeNamedSequence( type.initSequence )			
		])
		
	}
	

	def void isStateActive() {
		
		
		instance._executeOperation( "isStateActive", #["stateName"], [

			val stateName = resolve("stateName")
			val isActive =  if(stateName === null)
								activeStateConfiguration.exists[it === null]
							else
								activeStateConfiguration
								.filterNull
								.exists[(it.sourceElement as RegularState).name == stateName]

			exitCall(isActive)			
		])
	}
	
	


	def protected dispatch void execution(Object it) {
		throw new IllegalArgumentException("Cannot execute '" + it + "'")
	}

	def protected dispatch void execution(EnterState enterState) {
		_execute ("enter(" + enterState.state.name + ")", [
			activeStateConfiguration.set(enterState.state.stateVector.offset, enterState.state)
			executionContext.activeStates += enterState.state.sourceElement as RegularState
			activeStateIndex = enterState.state.stateVector.offset // mark all state vector elements up to this as processed ...			
		])
	}

	def protected dispatch void execution(ExitState exitState) {
		_execute ("exit(" + exitState.state.name + ")", [
			activeStateConfiguration.set(exitState.state.stateVector.offset, null)
			var exitStates = executionContext.activeStates.filter[EcoreUtil::equals(it, exitState.state.sourceElement)]
			executionContext.activeStates.removeAll(exitStates)
		])
	}

	def protected dispatch void execution(StateSwitch stateSwitch) {
		_execute ("stateSwitch", [
			val historyRegion = stateSwitch.historyRegion
			if (historyRegion !== null) {
				val historyState = historyStateConfiguration.get(historyRegion.historyVector.offset)
				stateSwitch.cases.filter[it.state == historyState].forEach[step._delegate]
			} else {
				stateSwitch.cases.filter[activeStateConfiguration.contains(state)].forEach[step._delegate]
			}
		])
	}

	def protected dispatch void execution(SaveHistory it) {
		_execute ("saveHistory(" + it.region.name + ")", [
			var region = it.region
			historyStateConfiguration.put(region.historyVector.offset,
				activeStateConfiguration.get(region.stateVector.offset))
		])
	}

	def dispatch void execution(HistoryEntry entry) {
		_execute("histoiryEntry", [
			if (historyStateConfiguration.get(entry.region.historyVector.offset) !== null) {
				entry.historyStep?._executeNamedSequence
			} else {
				entry.initialStep?._executeNamedSequence
			}			
		])
	}


	def dispatch void execution(ActiveStateReferenceExpression it) {
		_return("isActive(" + value.name + ")", [
			val state = it.value			
			return executionContext.allActiveStates.contains(state)
		])
	}


	def protected void microStep() {

		_execute("@microStep(init)",[
			activeStateIndex = 0
			// TODO : check if neccessary
			if(executionContext.executedElements.size > 0) executionContext.executedElements.clear 
		])
		for(var int i = 0; i<activeStateConfiguration.size; i++ ) {
			val j = i
			_execute("@microStep("+j+")", [
				if(activeStateIndex <= j) {
					var state = activeStateConfiguration.get(j)
					_return[ true ]
					state?.reactMethod?.invoke
					_execute[ activeStateIndex = activeStateIndex + 1 ]					
				}
			])
		}			
	}
	
	
	def protected void clearEvent(Expression event) {
		event._delegate
		_execute("@clearEvent()", [
			val Object eventSlot = popValue()
			(eventSlot as ExecutionEvent).raised = false
		])		
	}
	
	
	def protected void moveEvent(Expression from, Expression to) {
		from._delegate
		to._delegate
		_execute("@moveEvent()", [
			val Object toSlot = popValue()
			val Object fromSlot = popValue()
			
			(toSlot as ExecutionEvent).raised = (fromSlot as ExecutionEvent).isRaised()
			(toSlot as ExecutionEvent).value = (fromSlot as ExecutionEvent).getValue()
			(fromSlot as ExecutionEvent).raised = false
		])		
	}
		
		
	def protected void nextEvent() {
		_execute("@nextEvent()", [
			var EventInstance event = internalEventQueue?.poll ?: inEventQueue?.poll
			if ( event !== null ){
				event.event.raised = true
				event.event.value = event.getValue()				
			}
		])		
	}
		

	// TODO remove and use sexecexteion instead
	
	def Method reactMethod(ExecutionNode it) {
		features.filter( typeof(Method) ).filter( m | m.name == "react").head
	}
	

	/** TODO: DIRTY HACK - remove activeStates from ExecutionContext */
	def protected executionContext(){
		return EcoreUtil2.getContainerOfType(instance, ExecutionContext)	
	}
	
	def protected boolean hasMethod(String name) {
		lookupMethod(name) !== null
	}	
	
	def lookupMethod(String name) {
		type.features.filter(Method).filter[it.name == name].head
	}
	
	def void invoke(Method it) {
		_executeOperation(instance, name, parameters.map[name], [
			body._delegate
		])
	}
	
	
	override raise(Object slot, Object value) {
		if (slot instanceof ExecutionEvent) {
			_execute('''raise «slot.name»''', [
				if (slot.direction == Direction::LOCAL && internalEventQueue !== null) {
					_execute('''internalEventQueue.add(«slot.name»)''', [
						internalEventQueue.add(new EventInstance(slot, value));
					])
				} else if (slot.direction == Direction::IN && inEventQueue !== null) {
					_execute('''inEventQueue.add(«slot.name»)''', [
						inEventQueue.add(new EventInstance(slot, value));
					])
					"runCycle"._exec
				} else {
					slot.value = value
					slot.raised = true
				}				
			])	
		}	
	}
	
	override resolve(Object owner, Object symbol) {
		
		if (owner === instance) {
			owner.resolveSlot(symbol)
		}
	}

	def dispatch resolveSlot(Object slot, Object symbol) {
		null
	}	

	def dispatch ExecutionSlot resolveSlot(CompositeSlot slot, String symbol) {
		var ExecutionSlot s = null
		 
		if (s === null) {
			if (defaultInterface !== null && slot !== defaultInterface) {
				s = defaultInterface.slotByName(symbol)
			}	
		}
		if ( s === null ) {
			if (internalScope !== null && slot !== internalScope) {
				s = internalScope.slotByName(symbol)
			}
		}	
		if ( s === null ) {
			if (timeEventScope !== null && slot !== timeEventScope) {
				s = timeEventScope.slotByName(symbol)
			}
		}	
		if (s !== null) s = slot.slotByName(symbol)
		
		return s
	}	

	def  defaultInterface() {
		instance.slotByName("default") as CompositeSlot
	}
	
	def internalScope() {
		instance.slotByName("internal") as CompositeSlot
	}
	
	def timeEventScope() {
		instance.slotByName("time events") as CompositeSlot
	}
	
	def protected slotByName(CompositeSlot slot, String symbol) {
		slot.slots.findFirst[ s | s.name == symbol || s.fqName == symbol] 
	}
	
	def protected allMethods(ExecutionFlow it) {
		val allMethods = features.filter(Method).toList
		allMethods.addAll(states.map[features.filter(Method)].flatten)
		
		allMethods
	}
	
	
}
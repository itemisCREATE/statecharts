/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.interpreter.impl

import com.google.inject.Inject
import com.google.inject.name.Named
import org.yakindu.base.types.Type
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.SexecFactory
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.Trace
import org.yakindu.sct.model.sexec.TraceBeginRunCycle
import org.yakindu.sct.model.sexec.TraceEndRunCycle
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sexec.interpreter.IExecutionFlowInterpreter
import org.yakindu.sct.model.sexec.interpreter.IStatementInterpreter
import org.yakindu.sct.model.sexec.interpreter.ITimingService
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.simulation.core.runtime.AbstractExecutionFacade
import org.yakindu.sct.simulation.core.runtime.IExecutionContext
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable
import java.util.List
import java.util.Map
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.simulation.core.runtime.ISlot
import java.util.HashMap
import org.yakindu.sct.simulation.core.runtime.IEventSlot
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.types.ISTextTypeSystem
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.Direction
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class ExecutionFlowInterpreter extends AbstractExecutionFacade implements IExecutionFlowInterpreter {
	
	
	@Inject
	IStatementInterpreter interpreter
	@Inject
	IExecutionContext executionContext
	@Inject
	StextNameProvider provider
	@Inject 
	ITimingService timingService
	@Inject extension ISTextTypeSystem 
	@Inject extension ISTextTypeInferrer
	 
	@Inject
	@Named("InterpreterName")
	String interpreterName
	
	ExecutionFlow flow
	List<EventDefinition> inEvents
	List<EventDefinition> outEvents
	List<EventDefinition> localEvents
	List<TimeEvent> timeEvents
	
	Map<Declaration, ISlot> slotMap 
	
	int nextSVIdx
	
	TraceBeginRunCycle brc  
	TraceEndRunCycle erc  

	override initialize(ExecutionFlow flow) {
		this.flow = flow;
		
		slotMap = new HashMap<Declaration, ISlot>();
		
		for(scope : flow.scopes){
			scope.declareContents
		} 
		
		executionContext.initStateConfigurationVector(flow.stateVector.size)
		interpreter.setOperationCallbacks(super.callbacks)
		brc = SexecFactory::eINSTANCE.createTraceBeginRunCycle
		erc = SexecFactory::eINSTANCE.createTraceEndRunCycle
		
		inEvents = flow.scopes.map( s | s.declarations.filter( typeof(EventDefinition) ).filter( e | e.direction == Direction::IN) ).flatten.toList
		outEvents = flow.scopes.map( s | s.declarations.filter( typeof(EventDefinition) ).filter( e | e.direction == Direction::OUT) ).flatten.toList
		localEvents = flow.scopes.map( s | s.declarations.filter( typeof(EventDefinition) ).filter( e | e.direction == Direction::LOCAL) ).flatten.toList
		timeEvents = flow.scopes.map( s | s.declarations.filter( typeof(TimeEvent) )).flatten.toList
		
		flow.initSequence.execute
		
	}
	
	override tearDown(){
		timingService.stop
	}
	
	override getName(){
		interpreterName
	}
	
	def dispatch declareContents(InternalScope scope) {
		for(declaration : scope.declarations){
				declaration.addToScope
		}
	} 
	
	def dispatch declareContents(Scope scope){
		for(declaration : scope.declarations){
				declaration.addToScope
		}
	}
	
	def dispatch declareContents(InterfaceScope scope){
		for(declaration : scope.declarations){
				declaration.addToScope
		}
	}
	
	override runCycle() {
		executionContext.flush
		
		nextSVIdx = 0; // this is a member that can be manipulated during state reactions in case of orthogonality
		
		brc.execute
		
		clearOutEvents()
		
		while (nextSVIdx < executionContext.stateConfiguration.size) {
			var state = executionContext.stateConfiguration.get(nextSVIdx)
			if (state != null) state.reactSequence.execute			
			nextSVIdx = nextSVIdx + 1
		}  
		
		//executionContext.resetRaisedEvents

		clearEvents()
		
		erc.execute		
	} 


	def clearOutEvents() {
		// val outEvents = flow.scopes.map( s | s.declarations.filter( typeof(EventDefinition) ).filter( e | e.direction == Direction::OUT) ).flatten
//		outEvents.forEach( e | executionContext.unraiseEvent(provider.qualifiedName(e).toString))
		outEvents.forEach( e | e.unraise)
	}
	
	
	def clearEvents() {
		//val events = flow.scopes.map( s | s.declarations.filter( typeof(EventDefinition) ).filter( e | e.direction != Direction::OUT) ).flatten
		//val timeEvents = flow.scopes.map( s | s.declarations.filter( typeof(TimeEvent) )).flatten
//		inEvents.forEach( e | executionContext.unraiseEvent(provider.qualifiedName(e).toString))
//		localEvents.forEach( e | executionContext.unraiseEvent(provider.qualifiedName(e).toString))
//		timeEvents.forEach( e | executionContext.unraiseEvent(provider.qualifiedName(e).toString))
		inEvents.forEach( e | e.unraise)
		localEvents.forEach( e | e.unraise)
		timeEvents.forEach( e | e.unraise)
	}
	
	
	def unraise(Event it) {
		(slotMap.get(it) as IEventSlot).unraise
	}

	def dispatch void addToScope(VariableDefinition variable){
		var fqName = provider.qualifiedName(variable).toString
		var ExecutionVariable varSlot 
		
		if(variable.inferType.type.booleanType){
			varSlot = new ExecutionVariable(fqName ,typeof(Boolean),false)
		} 
		else if (variable.inferType.type.integerType){
			varSlot = new ExecutionVariable(fqName,typeof(Integer),0)
		}
		else if(variable.inferType.type.realType){
			varSlot = new ExecutionVariable(fqName,typeof(Float),0.0f)
		}
		else if (variable.inferType.type.stringType){
			varSlot = new ExecutionVariable(fqName,typeof(String),"")
		}
		
		executionContext.declareVariable(varSlot);
		slotMap.put(variable, varSlot);
	}  
	
	def dispatch void addToScope(EventDefinition event){
		var fqName = provider.qualifiedName(event).toString
		var ExecutionEvent eventSlot
		
		if(event.inferType.type.booleanType){
			eventSlot = new ExecutionEvent(fqName,typeof(Boolean),false)
		}
		else if(event.inferType.type.integerType){
			eventSlot = new ExecutionEvent(fqName,typeof(Integer),0)
		}
		else if(event.inferType.type.realType){
			eventSlot = new ExecutionEvent(fqName,typeof(Float),0.0f)
		}
		else if(event.inferType.type.voidType){
			eventSlot = new ExecutionEvent(fqName,typeof(Void))
		}
		else if (event.inferType.type.stringType){
			eventSlot = new ExecutionEvent(fqName,typeof(String),"")
		}
		 
		executionContext.declareEvent(eventSlot)
		slotMap.put(event, eventSlot)
	}
	
	
	def dispatch void addToScope(OperationDefinition op){
		var fqName = provider.qualifiedName(op).toString
		var type = op.type.mappedType
		val opSlot = new ExecutionVariable(fqName, type, type.defaultValue);
		
		executionContext.declareVariable(opSlot)
		slotMap.put(op, opSlot)
	}
	
	def Class<?> mappedType(Type it) {
		if(it.booleanType)		{ typeof(Boolean) } 
		else if(it.integerType)	{ typeof(Integer) }
		else if(it.realType)	{ typeof(Float) }
		else if(it.voidType)	{ typeof(Void)	}
		else if(it.stringType)	{ typeof(String) }
		else null 
	} 
	
	def Object defaultValue(Class<?> type) {
		switch (type) {
			case typeof(Boolean) : true
			case typeof(Integer) : 0
			case typeof(Float) : 0.0
			case typeof(Void) : null
			case typeof(String) : ""
		}
	}
	
	def dispatch void addToScope(TimeEvent event){
		val eventSlot = new ExecutionEvent(event.name, typeof(Long))
		executionContext.declareEvent(eventSlot) 
		slotMap.put(event, eventSlot)
	}

	override enter() {
		for(step : flow.enterSequence.steps){
			step.execute
		} 
	}
	
	override exit() {
		for(step : flow.exitSequence.steps){
			step.execute
		} 
	}
	
	def dispatch execute(Step step){
		println("Missing dispatch function for " + step)
	}
	def dispatch execute(Call call){
		call.step.execute
		null
	}
	
	def dispatch execute(Trace trace){
		notifyTraceStepEntered(trace)
		null
	}
	
	def dispatch execute(Check check){
		if(check.condition == null)
			return true
		var interpreterResult =  interpreter.evaluateStatement(check.condition, executionContext)
		return interpreterResult
		
	}
	
	def dispatch execute(EnterState enterState){
		executionContext.stateConfiguration.set(enterState.state.stateVector.offset, enterState.state)
		nextSVIdx = enterState.state.stateVector.offset // mark all state vector elements up to this as processed ...		
		null
	}

	def dispatch execute(HistoryEntry entry){
		if (executionContext.getHistoryStateConfiguration(entry.region) != null) {
			entry.historyStep.execute
		} else {
			if (entry.initialStep == null) {
				//TODO handle model error
				println("Missing initial transition " + entry)
			} else {
				entry.initialStep.execute
			}
		}
		null
	}
	
	def dispatch execute(Execution execution){ 
		interpreter.evaluateStatement(execution.statement, executionContext)
	}
	
	def dispatch execute(ExitState exitState){
		executionContext.stateConfiguration.set(exitState.state.stateVector.offset, null)
		null
	}
	
	def dispatch execute(If ifStep){
		var check  = execute(ifStep.check)
		if(check as Boolean){
			execute(ifStep.thenStep)
		}
		else if(ifStep.elseStep != null){
			execute(ifStep.elseStep)
		}
		null
	}
	
	def dispatch execute(Sequence sequence){
		for(step : sequence.steps){
			step.execute
		}
		null
	}
	
	def dispatch execute(SaveHistory action){
		executionContext.saveHistoryStateConfiguration(action.region);
		null
	} 
	
	def dispatch execute(StateSwitch stateSwitch){
		val historyRegion = stateSwitch.historyRegion
		if (historyRegion != null) {
			val historyState = executionContext.getHistoryStateConfiguration(historyRegion)
			for(stateCase : stateSwitch.cases) {
				if(historyState == stateCase.state){
					stateCase.step.execute
				}
			}
			
		} else {			
			for(stateCase : stateSwitch.cases)
				if(executionContext.stateConfiguration.contains(stateCase.state)){
					stateCase.step.execute
				} 
		}
		null 
	}
	
	def dispatch execute(ScheduleTimeEvent scheduleTimeEvent){
		var timeEvent = scheduleTimeEvent.timeEvent
		var duration = interpreter.evaluateStatement(scheduleTimeEvent.timeValue, executionContext)
		timingService.scheduleTimeEvent(executionContext,timeEvent.name,timeEvent.periodic, duration as Integer)
		null
	}
	
	def dispatch execute(UnscheduleTimeEvent timeEvent){
		timingService.unscheduleTimeEvent(timeEvent.timeEvent.name)
		null
	}
	
	
	override getExecutionContext() {
		return executionContext;
	}
	
}
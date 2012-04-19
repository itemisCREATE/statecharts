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
import org.yakindu.base.types.ITypeSystemAccess
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
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.simulation.core.runtime.AbstractExecutionFacade
import org.yakindu.sct.simulation.core.runtime.IExecutionContext
import org.yakindu.sct.simulation.core.runtime.IExecutionContextListener
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionEvent
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class ExecutionFlowInterpreter extends AbstractExecutionFacade implements IExecutionFlowInterpreter,IExecutionContextListener {
	
	@Inject
	IStatementInterpreter interpreter
	@Inject
	IExecutionContext executionContext
	BufferingExecutionContext externalExecutionContext
	@Inject
	StextNameProvider provider
	@Inject 
	ITimingService timingService
	@Inject extension
	ITypeSystemAccess ts
	 
	@Inject
	@Named("InterpreterName")
	String interpreterName
	
	ExecutionFlow flow
	int nextSVIdx
	
	TraceBeginRunCycle brc  
	TraceEndRunCycle erc  

	override initialize(ExecutionFlow flow) {
		this.flow = flow;
		externalExecutionContext = new BufferingExecutionContext(executionContext)
		for(scope : flow.scopes){
			scope.declareContents
		} 
		executionContext.initStateConfigurationVector(flow.stateVector.size)
		executionContext.addExecutionContextListener(this);
	
		timingService.init(executionContext.virtualClock)
		executionContext.virtualClock.start
		
		brc = SexecFactory::eINSTANCE.createTraceBeginRunCycle
		erc = SexecFactory::eINSTANCE.createTraceEndRunCycle
		
	}
	
	override tearDown(){
		timingService.stop
	}
	
	override getName(){
		interpreterName
	}
	
	override getExecutionContext(){
		return externalExecutionContext
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
		
		externalExecutionContext.flush
		
		nextSVIdx = 0; // this is a member that can be manipulated during state reactions in case of orthogonality
		
		brc.execute
		
		while (nextSVIdx < executionContext.stateConfiguration.size) {
			var state = executionContext.stateConfiguration.get(nextSVIdx)
			if (state != null) state.reactSequence.execute			
			nextSVIdx = nextSVIdx + 1
		}  
		
		executionContext.resetRaisedEvents

		erc.execute		
	} 



	def dispatch addToScope(VariableDefinition variable){
		var fqName = provider.qualifiedName(variable).toString
		if(variable.type.^boolean){
			executionContext.declareVariable(new ExecutionVariable(fqName ,typeof(Boolean),false))
		} 
		else if (variable.type.integer){
			executionContext.declareVariable(new ExecutionVariable(fqName,typeof(Integer),0))
		}
		else if(variable.type.real){
			executionContext.declareVariable(new ExecutionVariable(fqName,typeof(Float),Float::parseFloat("0.0")))
		}
		else if (variable.type.string){
			executionContext.declareVariable(new ExecutionVariable(fqName,typeof(String),""))
		}
		null 
	}  
	
	def dispatch addToScope(EventDefinition event){
		var fqName = provider.qualifiedName(event).toString
		if(event.type.^boolean){
				executionContext.declareEvent(new ExecutionEvent(fqName,typeof(Boolean),null))
		}
		else if(event.type.integer){
			executionContext.declareEvent(new ExecutionEvent(fqName,typeof(Integer),null))
		}
		else if(event.type.real){
			executionContext.declareEvent(new ExecutionEvent(fqName,typeof(Float),null))
		}
		else if(event.type.^void){
				executionContext.declareEvent(new ExecutionEvent(fqName,typeof(Void)))
		}
		else if (event.type.string){
			executionContext.declareEvent(new ExecutionEvent(fqName,typeof(String),""))
		}
		null 
	} 
	
	def dispatch addToScope(TimeEvent event){
		executionContext.declareEvent(new ExecutionEvent(event.name, typeof(Long)))
		null 
	}
	
	
	override enter() {
		for(step : flow.enterSequence.steps){
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
		timingService.scheduleTimeEvent(externalExecutionContext,timeEvent.name,timeEvent.periodic, duration as Integer)
		null
	}
	
	def dispatch execute(UnscheduleTimeEvent timeEvent){
		timingService.unscheduleTimeEvent(timeEvent.timeEvent.name)
		null
	}
	
	override void eventRaised(ExecutionEvent event){
		
	}

	override void variableValueChanged(ExecutionVariable variable){
		
	}

	override void timeScaleFactorChanged(double oldFactor, double newFactor){
		timingService.setTimeScaleFactor(newFactor)
	}
}
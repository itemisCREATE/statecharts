package org.yakindu.sct.simulation.core.sexec.interpreter

import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.DoWhile
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.LocalVariableDefinition
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.Return
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Statement
import org.yakindu.sct.model.sexec.Trace
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent
import org.yakindu.sct.model.sexec.concepts.StateMachineBehaviorConcept
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.InterfaceScope
import com.google.inject.Inject

class SexecExecution extends StextExecution  {
	
//	@Inject(optional=true) ITraceStepInterpreter traceInterpreter
	 
	@Inject extension StateMachineBehaviorConcept smbc

	def dispatch void execution(Call it) { _delegate }

	def dispatch void execution(Return it) {
		if (value !== null) {
			value._exec
			_value
		}
		_execute("return statement", [
			exitCall( if(it.value === null) null else popValue)
		])
	}

	def dispatch void execution(Check it) {
		if (condition === null ) {
			_return[true]	
		}
		else {
			condition._exec
			_value			
		}
	}

	def dispatch void execution(Execution it) {
		statement._exec
	}

	def dispatch void execution(DoWhile loop) {
		loop.body._exec
		loop.check._exec
		_value
		_execute[
			val checkResult = popValue
			if (checkResult == true) loop._exec
		]
	}
	
	def dispatch void execution(If it) {
		check._exec
		_value
		_execute ('if', [
			val checkResult = (popValue == true)
			if (checkResult) thenStep._exec
			else if (elseStep !== null) elseStep._exec
		])
	}
	
	def dispatch void execution(Sequence it) {
		if (it.isStateMachineConcept)
			_delegate 
		else 
			steps.forEach[ step | step._exec ]
	}
	
	def dispatch void execution(Statement it) {
		it.expression._exec
	}

	def dispatch void execution(LocalVariableDefinition it) {
		if ( initialValue !== null) {
			initialValue._exec
			_execute('''var «it.variable.name»''', [ 
				val value = popValue
				defineVariable(it.variable.name, value)
			]) 
		}
	}

	def dispatch void execution(Trace it) { /*_delegate*/ }
	
	def dispatch void execution(EnterState it) { _delegate }

	def dispatch void execution(ExitState it) { _delegate }

	def dispatch void execution(SaveHistory it) { _delegate }

	def dispatch void execution(HistoryEntry it) { _delegate	}

	def dispatch void execution(StateSwitch it) { _delegate } 
	
	def dispatch void execution(ScheduleTimeEvent it) { 
		it.timeValue._exec
		_value
		_return [
			resolve(null, it.timeEvent.symbol)
		]
		_execute('''schedule «it.timeEvent.name»''', [
			val timeEventSlot = popValue
			val duration = popValue as Long
			_schedule(it.timeEvent.name, duration, it.timeEvent.periodic, [
				raise(timeEventSlot, null)
			])	
		])		
	}

	def dispatch void execution (UnscheduleTimeEvent it) { 
		_execute('''unschedule «it.timeEvent.name»''', [
			_unschedule(it.timeEvent.name)
		])		
	}
	
	
	override dispatch void execution(ElementReferenceExpression expr) {
		
		val refParent = expr.reference.eContainer
		if (refParent instanceof InterfaceScope) {
			val scopeName = if (refParent.name.nullOrEmpty) 
				"default"  // TODO :use some extension
			else 
				refParent.name
				
			_return [
				resolve(null, scopeName).resolve(expr.reference.symbol)
			]
		} else super._execution(expr)		
	}
	

	def dispatch void executionCall(Method it) {

		_delegate
				
//		_executeOperation(null, it.name, parameters.map[name], [
//			body._exec
//		])
	}
	
}
package org.yakindu.sct.simulation.core.sexec.interpreter

import org.yakindu.base.expressions.interpreter.base.ExpressionExecution
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.DoWhile
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.Statement
import org.yakindu.sct.model.sexec.Trace
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent

class SexecExecution extends ExpressionExecution  {
	
//	@Inject(optional=true) ITraceStepInterpreter traceInterpreter
	 
	def dispatch void execution(Call it) {
		step._exec // TODO : add frame
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
		_execute[
			popValue // TODO : check if this is always correct (if expression is void)
		] 
	}

	def dispatch void execution(DoWhile loop) {
		loop.body._exec
		loop.check._exec
		_value
		_execute[
			val checkResult = popValue
			if (checkResult == true) loop._exec
			null
		]
	}
	
	def dispatch void execution(If it) {
		check._exec
		_value
		_execute[
			val checkResult = (popValue == true)
			if (checkResult) thenStep._exec
			else if (elseStep !== null) elseStep._exec
			null
		]
	}
	
	def dispatch void execution(Sequence it) {
		steps.forEach[ step | step._exec ]
	}
	
	def dispatch void execution(Statement it) {
		it.expression._exec
	}

	def dispatch void execution(Trace it) {
//		traceInterpreter?.evaluate(it, context) 
	}
	

	def dispatch void execution(EnterState loop) {
		// TODO
	}

	def dispatch void execution(ExitState loop) {
		// TODO
	}

	def dispatch void execution(SaveHistory loop) {
		// TODO
	}

	def dispatch Object execute(HistoryEntry entry) {
		// TODO
	}

	def dispatch Object execute(StateSwitch stateSwitch) {
		// TODO
	}
	
	def dispatch Object execute(ScheduleTimeEvent stateSwitch) {
		// TODO
	}

	def dispatch Object execute(UnscheduleTimeEvent stateSwitch) {
		// TODO
	}
	
	
}
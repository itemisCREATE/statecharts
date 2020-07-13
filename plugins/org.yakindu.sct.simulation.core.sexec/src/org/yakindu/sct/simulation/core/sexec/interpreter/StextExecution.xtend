package org.yakindu.sct.simulation.core.sexec.interpreter

import org.yakindu.base.expressions.interpreter.base.ExpressionExecution
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.sruntime.ExecutionEvent

class StextExecution extends ExpressionExecution {
	
	def dispatch void execution(EventRaisingExpression it) {
		
		it.event._exec
		if(it.value !== null) {
			it.value._exec
			_value
		}
		
		_execute[
			val value = if (it.value !== null) popValue else null
			val slot = popValue
			
			if (slot instanceof ExecutionEvent) {
				// TODO: dispatch to right instance
//				val eventRaiser = it.event.eventRaiser
//				if (eventRaiser !== null) eventRaiser.raise(event, value)				
				slot.raised = true
				slot.value = value
			}			
		]		
	}
	
}
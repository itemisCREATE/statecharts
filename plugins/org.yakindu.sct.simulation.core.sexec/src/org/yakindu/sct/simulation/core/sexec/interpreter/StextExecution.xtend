package org.yakindu.sct.simulation.core.sexec.interpreter

import org.yakindu.base.expressions.interpreter.base.ExpressionExecution
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression

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
			raise(slot, value)			
		]		
	}
	
	
	def dispatch void execution(EventValueReferenceExpression expression) {
		
		expression.value._exec
		_return[
			val eventSlot = popValue()
			(eventSlot as ExecutionEvent).value
		]
		
//		for (event : context.raisedEvents) {
//			val slot = context.resolve(expression.value)
//				.orElseThrow(SlotResolutionExceptionSupplier.forContext(expression.value))
//			if (slot instanceof ExecutionEvent && slot.fqName == event.fqName) {
//				return event.getValue;
//			}
//		}
//		throw new UndefinedValueException("Undefined value of event '" + expression.value.eventName + "'\n" +
//			"Event values only exist in the same cycle in which the event was raised.")
	}
	
	
	def dispatch void execution(ActiveStateReferenceExpression expression) { _delegate }
	
}
package org.yakindu.sct.simulation.core.sexec.interpreter

import org.yakindu.base.expressions.interpreter.base.ExpressionInterpreter
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.ExecutionVariable
import org.yakindu.sct.model.sruntime.SRuntimeFactory
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.yakindu.sct.model.sruntime.ExecutionSlot

class SexecInterpreter extends ExpressionInterpreter {
	
	protected ExecutionContext context = SRuntimeFactory.eINSTANCE.createExecutionContext
	
	new() {
		this.execution = new SexecExecution	
		this.execution.executionContext = this
	}
	
	def getExecutionContext(){
		return context
	}
	
	def setExecutionContext(ExecutionContext context){
		this.context = context
	}
	
	override setValue(Object slot, Object value) {
		setSlotValue(slot, value)
	}
		

	def dispatch setSlotValue(Object o, Object value) {
		throw new UnsupportedOperationException("Cannot assign value to slot of type " + value.class.name);		
	}
	
	def dispatch setSlotValue(ExecutionVariable it, Object value) {
		it.value = value
	}
	 

	override getValue(Object slot) {
		slot.asValue
	}

	def dispatch Object asValue(Object slot) {
		slot
	}

	def dispatch Object asValue(ExecutionSlot slot) {
		slot.value
	}
	
	override resolve(Object owner, Object symbol) {
		if (owner === null) context.resolveSlot(symbol)
		else owner.resolveSlot(symbol)
	}

	def dispatch resolveSlot(Object slot, Object symbol) {
		throw new UnsupportedOperationException("Cannot resolve symbol '" + symbol + "' on slot '" + slot + "'!")	
	}

	def dispatch resolveSlot(CompositeSlot slot, String symbol) {
		return slot.slots.findFirst[ s | s.name == symbol]
	}	
}
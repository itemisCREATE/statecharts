package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import java.util.List
import org.yakindu.base.expressions.interpreter.base.BaseExecution
import org.yakindu.base.expressions.interpreter.base.ExpressionInterpreter
import org.yakindu.base.expressions.interpreter.base.IInterpreter
import org.yakindu.base.types.Type
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.yakindu.sct.model.sruntime.ExecutionVariable
import org.yakindu.sct.model.sruntime.SRuntimeFactory
import org.yakindu.sct.simulation.core.sexec.container.IExecutionContextInitializer
import org.yakindu.sct.model.sruntime.ExecutionEvent

class SexecInterpreter extends ExpressionInterpreter {

	protected extension SRuntimeFactory runtimeFactory = SRuntimeFactory.eINSTANCE
	@Inject protected IExecutionContextInitializer contextInitializer
	
	protected List<Type> types

	new() {
		this.heap = createExecutionContext // TODO : tidy up context creation ...
		this.execution = new SexecExecution	
		this.execution.executionContext = this
	}
	
	
	def newInstance(ExecutionFlow flow) {
		val instance = contextInitializer.newInstance(flow) => [
			name = flow.name + "#"+ (heap.slots.size + 1)	
			heap.slots += it
		]
		val delegate = new ExecutionFlowInstanceDelegate =>[
			it.setUp(instance, flow, this)
		]
		createExecutionVariable => [
			name = "_delegate_"
			visible = true
			value = delegate
			instance.slots += it	
		]
	
		return instance
	}
	
	
	def _invoke(CompositeSlot receiver, String operation) {
		stack.clear
		nextExecutions.clear
		
		enterCall("_invoke_(" + operation + ")")
		
		receiver.delegate.provideExecution(operation)

		process
	} 
	
	
	override _requestExecution(Object program, Execution requester) {
		if (requester === this.execution) {
			SELF?.delegate?.provideExecution(program)
		} else {
			this.execution.provideExecution(program)
		}
	}
	
	
	def delegate(CompositeSlot it) {
		slots.findFirst[name == "_delegate_"]?.value as IInterpreter.Execution
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

	def dispatch Object asValue(ExecutionVariable slot) {
		slot.value
	}
	
	def dispatch Object asValue(ExecutionEvent slot) {
		slot.raised
	}
	
	
	override resolve(Object owner, Object symbol) {
		if (owner === null) {
			val slot = localScope?.resolveSlot(symbol)
			if (slot !== null) return slot
			
			heap.resolveSlot(symbol)		
		}
		else owner.resolveSlot(symbol)
	}

	def dispatch Object resolveSlot(Object slot, Object symbol) {
		throw new IllegalArgumentException("Cannot resolve symbol '" + symbol + "' on slot '" + slot + "'!")	
	}

	def dispatch Object resolveSlot(CompositeSlot slot, String symbol) {
		
		// 
		var Object resolvedSlot = slot.slots.findFirst[ s | s.name == symbol]
		if (resolvedSlot !== null) return resolvedSlot
		
		val delegate = slot.delegate 
		if (delegate !== null && delegate instanceof IInterpreter.Resolver) {
			resolvedSlot = (delegate as IInterpreter.Resolver).resolve(slot, symbol)
		}
		if (resolvedSlot !== null) return resolvedSlot
		
		// TODO extract getThisor rename to self
		val selfSlot = slot.slots.findFirst[ s | s.name == BaseExecution.SELF_NAME]
		if (selfSlot !== null ) {
			val SELF = selfSlot.value
			if (SELF !== slot)	resolvedSlot = SELF.resolve(symbol) 
		}
		
		return resolvedSlot
	}	
	
	
	def CompositeSlot SELF() {
		localScope?.resolve(BaseExecution.SELF_NAME).value as CompositeSlot
	}
	
	
	
	
	
	
}
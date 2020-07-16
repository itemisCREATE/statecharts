package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.expressions.interpreter.base.BaseExecution
import org.yakindu.base.expressions.interpreter.base.IInterpreter
import org.yakindu.base.expressions.interpreter.base.SRuntimeInterpreter
import org.yakindu.base.types.Type
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.model.sruntime.ExecutionVariable
import org.yakindu.sct.model.sruntime.SRuntimeFactory
import org.yakindu.sct.model.stext.stext.StextFactory
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler.TimeTask
import org.yakindu.sct.simulation.core.sexec.container.IExecutionContextInitializer

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*
import com.google.inject.Injector

class SexecInterpreter extends SRuntimeInterpreter {

	protected extension SRuntimeFactory runtimeFactory = SRuntimeFactory.eINSTANCE
	protected extension StextFactory stextFactory = StextFactory.eINSTANCE

	@Inject protected IExecutionContextInitializer contextInitializer
	@Inject protected extension Injector injector
	@Inject @Accessors protected ITimeTaskScheduler timingService
	
	
	protected IInterpreter.Execution execution 	


	static class ExecutionFlowInstanceDelegateAdapter extends AdapterImpl {
		@Accessors
		ExecutionFlowInstanceDelegate instance

		override isAdapterForType(Object type) {
			return type == ExecutionFlowInstanceDelegateAdapter
		}

	}

	@Inject new(SexecExecution exec) {
		this.heap = createExecutionContext // TODO : tidy up context creation ...
		this.execution = exec
		this.execution.executionContext = this
	}
	
	def newInstance(ExecutionFlow flow) {
		val instance = heap
		contextInitializer.initialize(heap, flow)

//		val instance = contextInitializer.newInstance(flow) => [
//			name = flow.name + "#"+ (heap.slots.size + 1)	
//			heap.slots += it
//		]		
		instance.eAdapters += new ExecutionFlowInstanceDelegateAdapter() => [
			
			instance = new ExecutionFlowInstanceDelegate => [
				it.injectMembers
				it.setUp(instance, flow, this)
			]
		]
		instance
	}
	
	
	
	
	override void prepareExecution(Object program) {
		execution.provideExecution(program)
	}
	
	

	def _invoke(CompositeSlot receiver, String operation, Object... args) {
		
		process("_invoke_(" + operation + ")", [
			args.forEach[ pushValue ]
			receiver.delegate.provideExecution(operation)
		])
				
	}

	def _raise(ExecutionEvent e, Object value) {
		
		process("_raise_(" + e.name + ")", [
			_execute("raise " + e.name, [
				e.raise(value)
			])		
		])		
	}

	override _requestExecution(Object program, Execution requester) {
		if (requester === this.execution) {
			SELF?.delegate?.provideExecution(program)
		} else {
			this.execution.provideExecution(program)
		}
	}


	override _schedule(String jobId, long duration, boolean periodic, Runnable action) {
		timingService.scheduleTimeTask(new TimeTask(jobId, [
			process('''scheduled(«jobId»)''', action)
		]), periodic, duration) 
	}
	
	override _unschedule(String jobId) {
		timingService.unscheduleTimeTask(jobId)
	}


	def IInterpreter.Instance instance(EObject it) {
		eContainer?.delegate as Instance 
	}

	def dispatch IInterpreter.Execution delegate(EObject it) {
		eContainer?.delegate
	}

	def dispatch IInterpreter.Execution delegate(CompositeSlot it) {
		val del = it.getExistingAdapter(ExecutionFlowInstanceDelegateAdapter)
		if(del !== null) 
			(del as ExecutionFlowInstanceDelegateAdapter).instance as IInterpreter.Execution 
		else 
			eContainer?.delegate
	}

	override setValue(Object slot, Object value) {
		setSlotValue(slot, value)
	}

	def dispatch setSlotValue(Object o, Object value) {
		throw new UnsupportedOperationException("Cannot assign value to slot of type " + o.class.name);
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

	override raise(Object o, Object value) {
			raiseSlot(o, value)
	}

	def dispatch raiseSlot(Object o, Object value) {
		throw new UnsupportedOperationException("Cannot raise on slot of type " + o.class.name);
	}

	def dispatch raiseSlot(ExecutionEvent it, Object value) {
		if (it.instance !== null) {
			it.instance.raise(it, value)
		} else {
			it.raised = true
			it.value = value
		}
	}

	override resolve(Object owner, Object symbol) {
		if (owner === null) {
			val slot = localScope?.resolveSlot(symbol)
			if(slot !== null) return slot

			heap.resolveSlot(symbol)
		} else
			owner.resolveSlot(symbol)
	}

	def dispatch Object resolveSlot(Object slot, Object symbol) {
		throw new IllegalArgumentException("Cannot resolve symbol '" + symbol + "' on slot '" + slot + "'!")
	}

	def dispatch Object resolveSlot(CompositeSlot slot, String symbol) {

		//
		var Object resolvedSlot = slot.slots.findFirst[s|s.name == symbol]
		if(resolvedSlot !== null) return resolvedSlot

		val delegate = slot.delegate
		if (delegate !== null && delegate instanceof IInterpreter.Resolver) {
			resolvedSlot = (delegate as IInterpreter.Resolver).resolve(slot, symbol)
		}
		if(resolvedSlot !== null) return resolvedSlot

		// TODO extract getThis or rename to self
		val selfSlot = slot.slots.findFirst[s|s.name == BaseExecution.SELF_NAME]
		if (selfSlot !== null) {
			val SELF = selfSlot.value
			if(SELF !== slot) resolvedSlot = SELF.resolve(symbol)
		}

		return resolvedSlot
	}

	def CompositeSlot SELF() {
		localScope?.resolve(BaseExecution.SELF_NAME).value as CompositeSlot
	}
	
}

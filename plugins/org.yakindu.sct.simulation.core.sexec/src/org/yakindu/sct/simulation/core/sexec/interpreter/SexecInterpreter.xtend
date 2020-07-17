/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */

package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import com.google.inject.Injector
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.expressions.interpreter.base.BaseExecution
import org.yakindu.base.expressions.interpreter.base.IInterpreter
import org.yakindu.base.expressions.interpreter.base.SRuntimeInterpreter
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
import org.yakindu.base.expressions.interpreter.base.InterpreterException

/**
 * Interpreter implementation for execution flow models which provides the interpreter facade.
 * 
 * TODO: The implementation is prepared to execute multiple instances. 
 * 		 Nevertheless the setup currently assumes a single instance.
 * 		 This should be changed in the next step.
 * 
 * 
 * @author axel terfloth
 */
class SexecInterpreter extends SRuntimeInterpreter {

	public static final String INIT = "init"
	public static final String ENTER = "enter"
	public static final String EXIT = "exit"
	public static final String RUN_CYCLE = "runCycle"
	public static final String IS_ACTIVE = "isActive"
	public static final String IS_STATE_ACTIVE = "isStateActive"
	public static final String IS_FINAL = "isFinal"
	
	protected extension SRuntimeFactory runtimeFactory = SRuntimeFactory.eINSTANCE
	protected extension StextFactory stextFactory = StextFactory.eINSTANCE

	@Inject protected IExecutionContextInitializer contextInitializer
	@Inject protected extension Injector injector
	@Inject @Accessors protected ITimeTaskScheduler timingService
	
		
	protected IInterpreter.Execution execution 	


	static class ExecutionFlowInstanceDelegateAdapter extends AdapterImpl {
		@Accessors
		ExecutionFlowInstance instance

		override isAdapterForType(Object type) {
			return type == ExecutionFlowInstanceDelegateAdapter
		}

	}
	
	
	@Inject new(SexecExecution exec) {
		this.heap = createExecutionContext // TODO : tidy up context creation ...
		this.execution = exec
		this.execution.executionContext = this
	}
	
	
	override newInstance(Object type) {
		type.createNewInstance
	}
	
	protected def dispatch Object createNewInstance(Object type) {
		throw new InterpreterException('''Don't know how to create new instance of type «type?.class.name» ! ''')
	}
	
	protected def dispatch Object createNewInstance(ExecutionFlow flow) {
		val instance = heap
		contextInitializer.initialize(heap, flow)

		instance.eAdapters += new ExecutionFlowInstanceDelegateAdapter() => [
			
			instance = new ExecutionFlowInstance => [
				it.injectMembers
				it.setUp(instance, flow, this)
			]
		]
		instance
	}
	
	
	
	override void prepareExecution(Object program) {
		execution.provideExecution(program)
	}
	
	

	override invokeOperation(Object receiver, String operation, Object... args) {		
		receiver.doInvoke(operation, args)
	}


	protected def dispatch Object doInvoke(Object receiver, String operation, Object... args) {
		throw new InterpreterException('''Don't know how to invoke operation for receiver of type «receiver?.class.name» ! ''')
	}
	
	protected def dispatch Object doInvoke(CompositeSlot receiver, String operation, Object... args) {
		process("_invoke_(" + operation + ")", [
			args.forEach[ pushValue ]
			receiver.instance.provideExecution(operation)
		])				
	}


	override void raiseEvent(Object e, Object value) {
		doRaise(e, value)
	}
	
	def dispatch void doRaise(Object e, Object value) {
		throw new InterpreterException('''Don't know how to raise event of type «e?.class.name» ! ''')
	}
	
	def dispatch void doRaise(ExecutionEvent e, Object value) {
		
		process("_raise_(" + e.name + ")", [
			_execute("raise " + e.name, [
				e.raise(value)
			])		
		])		
	}

	override _requestExecution(Object program, Execution requester) {
		if (requester === this.execution) {
			SELF?.instance?.provideExecution(program)
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


	def dispatch IInterpreter.Instance instance(EObject it) {
		eContainer?.instance
	}

	def dispatch IInterpreter.Instance instance(CompositeSlot it) {
		val inst = it.getExistingAdapter(ExecutionFlowInstanceDelegateAdapter)
		if(inst !== null) 
			(inst as ExecutionFlowInstanceDelegateAdapter).instance as IInterpreter.Instance 
		else 
			eContainer?.instance
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

		val inst = slot.instance
		if (inst !== null && inst instanceof IInterpreter.Resolver) {
			resolvedSlot = (inst as IInterpreter.Resolver).resolve(slot, symbol)
		}
		if(resolvedSlot !== null) return resolvedSlot

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

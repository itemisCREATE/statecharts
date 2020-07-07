package org.yakindu.base.expressions.interpreter.base

import java.util.List
import java.util.Deque
import java.util.LinkedList
import java.util.ArrayDeque
import org.eclipse.xtext.xbase.lib.Functions.Function0

abstract class BaseInterpreter implements IInterpreter, IInterpreter.Control, IInterpreter.Context {

	protected List<Promise> workQueue = new LinkedList<Promise>
	protected Deque<Object> stack = new ArrayDeque<Object>
	protected boolean suspended = false

	override evaluate(Object program) {
		
		stack.clear
		program.prepareExecution
		workQueue.process
		return stack.peek 
	}
	
	
	def abstract void prepareExecution(Object program);

	
	override resume() {
		suspended = false
	}
	
	override suspend() {
		suspended = true
	}
	
	
	
	def void process( List<Promise> queue ) {
		while (! (queue.empty || suspended)) {
			val head = queue.head
			queue.remove(0)
			head.execute
		}
	}
	
	
	override popValue() {
		stack.pop
	}

	override pushValue(Object value) {
		stack.push(value)
	}


	override void _execute(()=>Object f) {
		workQueue.add(_promise(f))
	}
		
	override void _return(()=>Object f) {
		workQueue.add( _promise(f)._then[ v | 
			stack.push(v)
		] )
	}
	
	
	def _promise(Function0<Object> f) {
		new Promise => [
			execution = f
		]
	}

	def _then(Promise it, (Object)=>void then) {
		it.then = then
		return it
	}
	
	
	static class Promise {

		protected extension (Object)=>void then = null;
		protected ()=>Object execution = null;

		def void setThen((Object)=>void then) {
			this.then = then
		}		

		def (Object)=>void getThen() {
			return this.then
		}		
		

		def void setExecution(()=>Object execution) {
			this.execution = execution
		}		

		def ()=>Object getExecution() {
			return this.execution
		}		

		def execute() {
			val result = execution.apply
			if (then !== null) then.apply(result)
		}		
		
	}
	
}
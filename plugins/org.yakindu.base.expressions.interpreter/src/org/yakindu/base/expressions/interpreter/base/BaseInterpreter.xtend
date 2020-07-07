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
//		System.out.println("--- START ---")
		while (! (queue.empty || suspended)) {
			val head = queue.head
			queue.remove(0)
//			System.out.println(head.description)
			head.execute
		}
//		System.out.println("--- END ---")
	}
	
	
	override popValue() {
		stack.pop
	}

	override pushValue(Object value) {
		stack.push(value)
	}


	override void _execute(String description, ()=>Object f) {
		workQueue.add(_promise(description, f))
	}
		
	override void _return(String description, ()=>Object f) {
		workQueue.add( _promise(description, f)._then[ v | 
			stack.push(v)
		] )
	}
	
	
	def _promise(String desc, Function0<Object> f) {
		new Promise => [
			execution = f
			description = desc
		]
	}

	def _then(Promise it, (Object)=>void then) {
		it.then = then
		return it
	}
	
	
	static class Promise {

		protected extension (Object)=>void then = null
		protected ()=>Object execution = null
		protected String description
		
		def String getDescription() {
			description
		}
		
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
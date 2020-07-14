package org.yakindu.base.expressions.interpreter.base

import java.util.List
import java.util.Deque
import java.util.LinkedList
import java.util.ArrayDeque
import org.eclipse.xtext.xbase.lib.Functions.Function0
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.SRuntimeFactory
import org.yakindu.sct.model.sruntime.ExecutionVariable
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.eclipse.xtend.lib.annotations.Data

abstract class SRuntimeInterpreter implements IInterpreter, IInterpreter.Control, IInterpreter.Context {

	protected extension SRuntimeFactory runtimeFactory = SRuntimeFactory.eINSTANCE

	protected Deque<Object> stack = new ArrayDeque<Object>
	protected ExecutionContext heap
	protected List<Promise> nextExecutions = new LinkedList<Promise>
	
	protected boolean suspended = false
	protected boolean debug = true


	@Data public static class EventInstance {

		public ExecutionEvent event;
		public Object value;

		new(ExecutionEvent ev, Object value) {
			this.event = ev
			this.value = value
		}
	}

	

	def getHeap(){
		return heap
	}

	def setHeap(ExecutionContext ctx){
		heap = ctx
	}	
		
	override evaluate(Object program) {
		
		stack.clear
		nextExecutions.clear

		enterCall("_evaluate_")

		program.prepareExecution
		process				// TODO process may be suspended and resumed
			
		return stack.peek // TODO clear stack ... 
	}
	
	
	def abstract void prepareExecution(Object program);

	
	override resume() {
		suspended = false
	}
	
	override suspend() {
		suspended = true
	}
	
	def void process() {
		logDebug["--- START ---"]
		
		activateNexteExecutions
		while ( currentFrame !== null ) {
			while (! (currentFrame.executionQueue.empty || suspended)) {
				val head = currentFrame.executionQueue.head
				currentFrame.executionQueue.remove(0)
				logDebug['''«head.description» «currentFrame.executionQueue.map[description]»''']
				head.execute
				activateNexteExecutions
			}
			if (currentFrame !== null) 
				exitCall(if (stack.peek instanceof StackFrame) null else popValue)
		}
		logDebug["--- END ---"]
	}
	
	protected def void activateNexteExecutions() {
		currentFrame.executionQueue.addAll(0, nextExecutions)
		nextExecutions.clear	
	}
	
	override popValue() {
		val v = stack.pop
		logDebug['''    < «v.description» «stack.map[description]»''']
		v 
	}

	override pushValue(Object value) {
		stack.push(value)
		logDebug['''    > «value.description»  «stack.map[description]»''']
	}

 	
	override void _execute(String description, Runnable r) {
		nextExecutions.add(_promise(description, [ 
			r.run 
			null
		]))
	}
		
	override void _return(String description, ()=>Object f) {
		nextExecutions.add( _promise(description, f)._then[ v | 
			v.pushValue 		
		] )
	}
	
	
	def dispatch description(Object it) {
		toString
	}
	
	def dispatch description(StackFrame it) {
		'''frame<«name»>'''
	}
	
	def dispatch description(ExecutionVariable it) {
		'''variable<«name»>'''
	}
	
	def dispatch description(ExecutionEvent it) {
		'''event<«name»>'''
	}
	
	def dispatch description(CompositeSlot it) {
		'''object<«name»>'''
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
	
	
	override  defineVariable(String name, Object value) {
		_variable(name, value) => [
			localScope.slots.add(it)
		]
	}
	
	def ExecutionContext localScope()  {
		currentFrame?.variables	
	}
	
	def StackFrame currentFrame()  {
		(stack.findFirst[ it instanceof StackFrame ] as StackFrame)	
	}
	
	def ExecutionVariable _variable(String name, Object value) {
		createExecutionVariable => [ v |
			v.name = name
			v.value = value
		]
	}
	
	
	override enterCall(String opName) {
		val frame = new StackFrame
		frame.name = opName
		pushValue(frame)
	}
	
	override exitCall(Object returnValue) {
		do {} while (! (popValue instanceof StackFrame))
		if (returnValue !== null) pushValue(returnValue)
	}
	
	
	static class StackFrame {
		public String name
		public ExecutionContext variables = SRuntimeFactory.eINSTANCE.createExecutionContext 
		protected List<Promise> executionQueue = new LinkedList<Promise>
	}
	
	def void logDebug(()=>Object it) {
		if(debug) System.out.println(it.apply
		)		
	}
}
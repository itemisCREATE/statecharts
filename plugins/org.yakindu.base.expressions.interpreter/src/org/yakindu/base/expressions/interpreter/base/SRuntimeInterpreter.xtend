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
import java.nio.CharBuffer

abstract class SRuntimeInterpreter implements IInterpreter, IInterpreter.Control, IInterpreter.Context {

	protected extension SRuntimeFactory runtimeFactory = SRuntimeFactory.eINSTANCE

	protected Deque<Object> stack = new ArrayDeque<Object>
	protected ExecutionContext heap
	protected List<Promise> nextExecutions = new LinkedList<Promise>
	
	protected boolean debug = true

	protected boolean suspended = false
	protected boolean isProcessing = false
	
	protected int frameCount = 0

	@Data static class EventInstance {

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
//		logDebug["--- START ---"]
		
		activateNexteExecutions
		while ( currentFrame !== null ) {
			while (! (currentFrame ===null || currentFrame.executionQueue.empty || suspended)) {
				val head = currentFrame.executionQueue.head
				currentFrame.executionQueue.remove(0)
				logDebug['''«ident»«head.description»''']
				head.execute
				activateNexteExecutions
			}
			if (currentFrame !== null) 
				exitCall(if (stack.peek instanceof StackFrame) null else popValue)
		}
//		logDebug["--- END ---"]
	}
	
	
	def Object process(String name, Runnable action) {
			
		val wasProcessing = isProcessing
		
		try {
			isProcessing = true

			if ( ! wasProcessing ) {
				stack.clear
				nextExecutions.clear
				frameCount = 0				
			}
			
			enterCall('''process<«name»>''')
			action.run
			process
			
			return stack.peek // TODO clear stack ...
			
		} finally {
			isProcessing = wasProcessing
		}
	}
	
	
	protected def void activateNexteExecutions() {
		logDebug[ if (nextExecutions.empty) null else '''«ident»    «nextExecutions.map[description]» + «currentFrame.executionQueue.map[description]»''']

		currentFrame?.executionQueue?.addAll(0, nextExecutions)
		nextExecutions.clear	
	}
	
	override popValue() {
		val v = stack.pop

		if(v instanceof StackFrame) {
			frameCount--
			logDebug['''«ident»<< «v.description» «stack.map[description]»''']
		} else {
			logDebug['''«ident»    < «v.description» «stack.map[description]»''']		
		}
		
		v 
	}

	override pushValue(Object value) {
		stack.push(value)

		if(value instanceof StackFrame) {
			logDebug['''«ident»>> «value.description»  «stack.map[description]»''']
			frameCount++
		} else {
			logDebug['''«ident»    > «value.description»  «stack.map[description]»''']		
		}

		 
	}

	def ident() {
		ident(frameCount)
	} 
 	
 	def create new StringBuffer ident(int n) {
 		for(i : 0..<n) it.append('''    ''')	
 	}
 	
	override void _execute(()=>CharSequence description, Runnable action) {
		nextExecutions.add(_promise(description, [ 
			action.run 
			null
		]))
	}
		
	override void _return(()=>CharSequence description, ()=>Object f) {
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
	
	
	def _promise(()=>CharSequence desc, Function0<Object> f) {
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
		protected ()=>CharSequence description
		
		def String getDescription() {
			description.apply.toString
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
		if(debug) {
			val output = it.apply
			if (output !== null) System.out.println(it.apply)
		}
	}
}
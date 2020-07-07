package org.yakindu.base.expressions.interpreter.base

abstract class BaseExecution implements IInterpreter.Execution  {

	protected extension IInterpreter.Context context
		
	override setExecutionContext(IInterpreter.Context context) {
		this.context = context
	}
	
	protected def void _exec(Object o) {
		o.provideExecution	
	}

	def void _value() {
		_return("value", [
			popValue.getValue
		])
	}

	def void _return(()=>Object f) {
		_return("return", f)
	}
	
	def void _execute(()=>Object f) {
		_execute("execute", f)
	}
	
	
}
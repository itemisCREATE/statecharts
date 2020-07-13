package org.yakindu.base.expressions.interpreter.base

import java.util.ArrayList
import java.util.List

abstract class BaseExecution implements IInterpreter.Execution  {

	public static String SELF_NAME = "_self_" // TODO: move to concept
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
	
	def void _execute(Runnable f) {
		_execute("execute", f)
	}
	
	def void _executeOperation(Object owner, String name, List<String> parameters, Runnable body) {
		_execute ('''«name»''', [ 
			val paramValues = new ArrayList<Object>
			parameters.forEach[paramValues.add(popValue)]
			enterCall(name)
			if(owner !== null) defineVariable(SELF_NAME, owner)
			parameters.reverseView.forEach[ p, i | 
				defineVariable(p, paramValues.get(i))
			]
			body.run
		])
	}
	
	def void _delegate(Object program) {
		program._requestExecution(this)
	}
	
}
package org.yakindu.base.expressions.interpreter.base

class ExpressionInterpreter extends BaseInterpreter  {

	
	protected extension IInterpreter.Execution execution // TODO: injection ...
	
	new() {
		this.execution = new ExpressionExecution	
		this.execution.executionContext = this
	}
	
	
	override void prepareExecution(Object program) {
		program.provideExecution
	}
	
	override resolve(Object owner, Object symbol) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	
}
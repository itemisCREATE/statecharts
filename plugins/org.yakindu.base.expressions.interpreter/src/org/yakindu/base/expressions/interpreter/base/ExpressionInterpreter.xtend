package org.yakindu.base.expressions.interpreter.base

class ExpressionInterpreter extends BaseInterpreter  {

	
	protected IInterpreter.Execution execution // TODO: injection ...
	
	new() {
		this.execution = new ExpressionExecution	
		this.execution.executionContext = this
	}
	
	
	override void prepareExecution(Object program) {
		execution.provideExecution(program)
	}
	
	override resolve(Object owner, Object symbol) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
		
	override getValue(Object slot) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override setValue(Object slot, Object value) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	
}
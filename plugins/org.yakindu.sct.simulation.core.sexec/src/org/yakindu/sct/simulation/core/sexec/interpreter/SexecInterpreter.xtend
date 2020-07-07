package org.yakindu.sct.simulation.core.sexec.interpreter

import org.yakindu.base.expressions.interpreter.base.ExpressionInterpreter
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.SRuntimeFactory

class SexecInterpreter extends ExpressionInterpreter {
	
	protected ExecutionContext context = SRuntimeFactory.eINSTANCE.createExecutionContext
	
	def getExecutionContext(){
		return context
	}
	
}
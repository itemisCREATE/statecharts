package org.yakindu.sct.model.sexec.interpreter.test

import org.yakindu.base.expressions.interpreter.base.BaseExecution
import org.yakindu.sct.model.sexec.Sequence

class SexecExecution extends BaseExecution  {
	
	
	override provideExecution(Object program) {
		program.execution
	}
	
	def dispatch void execution(Object it) {
	}
	
	
	def dispatch void execution(Sequence it) {
		steps.forEach[ step | step._exec ]
	}
	
	
}
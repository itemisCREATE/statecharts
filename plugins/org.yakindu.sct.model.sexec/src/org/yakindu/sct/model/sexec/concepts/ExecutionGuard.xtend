package org.yakindu.sct.model.sexec.concepts

import org.yakindu.sct.model.sexec.ExecutionFlow
import com.google.inject.Inject
import org.yakindu.base.types.Property
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.extensions.SexecBuilder
import org.yakindu.sct.model.sexec.Step

class ExecutionGuard {

	public static val IS_EXECUTING = "isExecuting"
	 
	@Inject extension TypeBuilder
	@Inject extension ExpressionBuilder
	@Inject extension SexecBuilder


	def defineFeatures (ExecutionFlow it) {
		it.features += _variable(org.yakindu.sct.model.sexec.concepts.ExecutionGuard.IS_EXECUTING, _boolean)
	}
	

	def Step _guardExecution(ExecutionFlow it, Step body){
		_sequence(
			_if(isExecutingProperty._ref)._then(_return(null)),
			isExecutingProperty._assign(_true),
				
			body,
			
			isExecutingProperty._assign(_false)	
		)
	}
	
	def _initIsExecuting(ExecutionFlow it) {
		if (isExecutingProperty !== null) 
			isExecutingProperty._assign(_false)
		else
			_empty
	}	

	def Property isExecutingProperty(ExecutionFlow it) {
		features.filter( typeof(Property) ).filter( m | m.name == org.yakindu.sct.model.sexec.concepts.ExecutionGuard.IS_EXECUTING).head
	}
	
	
}
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.sexec.transformation.TypeBuilder

@Singleton class ExitSequence {
	
	@Inject extension TypeBuilder tBuilder
	
	def create op : _op exitSequence(ComplexType it){
		features += op
		op.name = exitSequenceOperationName
	}
	
	def resolveExitSequence(ComplexType it) {
		features.filter(Operation).findFirst[name == exitSequenceOperationName]
	}

	def exitSequenceOperationName() {
		"exitSequence"
	}
}
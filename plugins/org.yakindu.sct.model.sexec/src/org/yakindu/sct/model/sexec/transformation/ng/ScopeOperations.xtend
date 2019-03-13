package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.model.sexec.ExecutionScope
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.sexec.transformation.SexecExtensions

@Singleton class ScopeOperations {

	@Inject extension TypeBuilder tBuilder
	
	def create op : _op createEnterSequenceOperation(ExecutionScope it, String entryName){
		features += op
		op.name = enterSequenceOperationName(entryName)
	}
	
	def resolveEnterSequenceOperation(ExecutionScope it, String entryName) {
		val op = getEnterSequenceOperation(entryName)
		
		return 
			if (op !== null) op 
			else getEnterSequenceOperation(SexecExtensions.DEFAULT_SEQUENCE_NAME)
	}

	def getEnterSequenceOperation(ExecutionScope it, String entryName) {
		features.filter(Operation).findFirst[name == enterSequenceOperationName(entryName)]
	}

	def enterSequenceOperationName(String entryName) {
		"enter_" + entryName
	}
}
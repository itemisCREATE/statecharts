package org.yakindu.sct.model.sexec.transformation.ng

import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionState
import com.google.inject.Singleton

@Singleton class StateOperations {
	
	@Inject extension TypeBuilder tBuilder
	
	def create op : _op entryActionOperation(ExecutionState it){
		features += op
	}
	
}
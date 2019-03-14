package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.RegularState

@Singleton class StateOperations {
	
	@Inject extension TypeBuilder tBuilder
	@Inject extension StateType stateType
	
	def create op : _op entryAction(RegularState it) {
		
		op.name = "entryAction"
		type.features += op
	}
	
}
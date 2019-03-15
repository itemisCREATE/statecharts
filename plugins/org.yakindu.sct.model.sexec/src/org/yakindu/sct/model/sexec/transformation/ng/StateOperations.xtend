/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder

@Singleton class StateOperations {
	
	@Inject extension TypeBuilder tBuilder
	@Inject extension StateType stateType
	@Inject extension ExpressionBuilder eBuilder
	
	def create op : _op entryAction(RegularState it) {
		
		op.name = "entryAction"
		_comment = "Entry action for state '" + name + "'."
		type.features += op
	}
	
}
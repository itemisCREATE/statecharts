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
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.FinalState

@Singleton class StateOperations {
	
	@Inject extension TypeBuilder tBuilder
	@Inject extension StateType stateType
	@Inject extension ExpressionBuilder eBuilder
	
	def dispatch create op : _op entryAction(State it) {
		
		op.name = "entryAction"
		_comment = "Entry action for state '" + name + "'."
		type.features += op
	}
	
	def dispatch entryAction(FinalState it) {
		null // final states don't have entry actions
	}
	
	def dispatch create op : _op exitAction(State it) {
		
		op.name = "exitAction"
		_comment = "Exit action for state '" + name + "'."
		type.features += op
	}
	
	def dispatch exitAction(FinalState it) {
		null // final states don't have exit actions
	}
	
}

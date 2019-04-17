package org.yakindu.sct.model.sexec.transformation.ng.operations

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.ng.StateType
import org.yakindu.sct.model.sexec.transformation.ng.expressions.StatemachineExpressionBuilder
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart

@Singleton
class ExitActionOperation {
	
	@Inject extension TypeBuilder
	@Inject extension StateType
	@Inject extension ExpressionBuilder
	@Inject extension StatechartExtensions
	@Inject extension StatemachineExpressionBuilder
	
	// TODO: exit actions for statemachine itself
	def declareExitActionOperations(Statechart sc) {
		sc.eAllContents.filter(State).forEach[exitActionOperation]
	}
	
	def defineExitActionOperations(Statechart sc) {
		sc.eAllContents.filter(State).forEach[defineExitActionOperation]
	}
	
	def protected dispatch create op : _op exitActionOperation(State state) {
		op.name = exitActionOperationName
		op._comment = "Exit action for state '" + state.name + "'."
		state.type.features += op
	}
	
	def protected dispatch exitActionOperation(FinalState state) {
		null
	}
	
	def resolveExitActionOperation(RegularState state) {
		state.type.features.filter(Operation).findFirst[name == exitActionOperationName]
	}
	
	def defineExitActionOperation(State state) {
		state.exitActionOperation.body = _block => [
			
			for (tes : state.timeEventSpecs ) {
				expressions += _unscheduleTimeEvent(tes)
			}
			
			state.exitReactions.forEach[ lr | expressions += lr._exitReaction]
		]
	}
	
	def protected exitActionOperationName() {
		"exitAction"
	}
	
}

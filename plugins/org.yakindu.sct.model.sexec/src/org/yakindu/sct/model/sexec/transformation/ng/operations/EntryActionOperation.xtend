package org.yakindu.sct.model.sexec.transformation.ng.operations

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.StatechartExtensions
import org.yakindu.sct.model.sexec.transformation.ng.StateType
import org.yakindu.sct.model.sexec.transformation.ng.expressions.StatemachineExpressionBuilder
import org.yakindu.sct.model.sgraph.FinalState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Statechart

@Singleton
class EntryActionOperation {
	
	@Inject extension TypeBuilder
	@Inject extension StateType
	@Inject extension ExpressionBuilder
	@Inject extension StatechartExtensions
	@Inject extension StatemachineExpressionBuilder
	
	// TODO: entry actions for statemachine itself
	def declareEntryActionOperations(Statechart sc) {
		sc.eAllContents.filter(State).forEach[entryActionOperation]
	}
	
	def defineEntryActionOperations(Statechart sc) {
		sc.eAllContents.filter(State).forEach[defineEntryActionOperation]
	}
	
	def dispatch create op : _op entryActionOperation(State state) {
		op.name = "entryAction"
		op._comment = "Entry action for state '" + state.name + "'."
		state.type.features += op
	}
	
	def dispatch entryActionOperation(FinalState state) {
		null
	}
	
	def protected defineEntryActionOperation(State state) {
		state.entryActionOperation.body = _block => [
			
			for (tes : state.timeEventSpecs ) {
				expressions += _unscheduleTimeEvent(tes)
			}
			state.entryReactions.forEach[ lr | expressions += lr._entryReaction]
		]
	}
	
	
	
}

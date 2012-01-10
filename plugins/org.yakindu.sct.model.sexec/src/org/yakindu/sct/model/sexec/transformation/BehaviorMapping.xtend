package org.yakindu.sct.model.sexec.transformation

import org.yakindu.sct.model.sgraph.State
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.stext.stext.ReactionEffect
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.TimeUnit
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sgraph.Effect
import org.yakindu.sct.model.sexec.Execution
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Statechart
 

class BehaviorMapping {

	@Inject extension StatechartExtensions sc
	@Inject extension StextExtensions stext
	@Inject extension SexecExtensions sexec
	@Inject extension SexecElementMapping factory



	def ExecutionFlow mapEntryActions(Statechart statechart, ExecutionFlow r){
		val allStates = statechart.allRegularStates.filter(typeof(State))
		allStates.forEach( s | { s.create.entryAction = s.mapEntryAction() null } )
		return r
	}

	/** 
	 * The entry action sequence of a state consist all action that are specified with the 'entry' pseudo trigger within local reactions
	 * and all scheduling actions for time triggers.
	 */
	def Step mapEntryAction(State state) {
		val seq = sexec.factory.createSequence
		seq.name = "entryAction"
		seq.comment = "Entry action for state '" + state.name + "'."
		
		for (tes : state.timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			val scheduleStep = timeEvent.newScheduleTimeEvent(tes.buildValueExpression)
			seq.steps.add(scheduleStep)
		}	
		
		state.entryReactions
			.map([lr | if (lr.effect != null) { (lr.effect as ReactionEffect).mapEffect } else null])
			.forEach(e | if (e != null) { seq.steps.add(e) })
		
		if (seq.steps.size > 0) seq else null
	}	





	def ExecutionFlow mapExitActions(Statechart statechart, ExecutionFlow r){
		val allStates = statechart.allRegularStates.filter(typeof(State))
		allStates.forEach( s | { s.create.exitAction = s.mapExitAction() null } )
		return r
	}



	/** 
	 * The exit action sequence of a state consist all action that are specified with the 'exit' pseudo trigger within local reactions
	 * and all unscheduling actions for time triggers.
	 */
	def Step mapExitAction(State state) {
		val seq = sexec.factory.createSequence
		seq.name = "exitAction"
		seq.comment = "Exit action for state '" + state.name + "'."
		
		
		for (tes : state.timeEventSpecs ) {
			val timeEvent = tes.createDerivedEvent
			val unscheduleStep = timeEvent.newUnscheduleTimeEvent()
			seq.steps.add(unscheduleStep)
		}	
		
		state.exitReactions
			.map([lr | if (lr.effect != null) { (lr.effect as ReactionEffect).mapEffect } else null])
			.forEach(e | if (e != null) { seq.steps.add(e) })
		
		if (seq.steps.size > 0) seq else null
	}
	


	def Statement buildValueExpression(TimeEventSpec tes) {
		val PrimitiveValueExpression pve = stext.factory.createPrimitiveValueExpression 
		val IntLiteral intLit = stext.factory.createIntLiteral
		intLit.value = tes.value
		pve.value = intLit
	
		switch (tes.unit) {
			case TimeUnit::MILLISECOND : pve
			case TimeUnit::NANOSECOND  : pve.divide(1000000)
			case TimeUnit::SECOND      : pve.multiply(1000)
			default : pve
		} 
	}
	
	def Statement divide(Expression stmnt, long divisor) {
		val NumericalMultiplyDivideExpression div = stext.factory.createNumericalMultiplyDivideExpression
		val PrimitiveValueExpression pve = stext.factory.createPrimitiveValueExpression 
		val IntLiteral intLit = stext.factory.createIntLiteral
		intLit.value = divisor.intValue
		pve.value = intLit
		
		div.operator = MultiplicativeOperator::DIV
		div.leftOperand = stmnt
		div.rightOperand = pve
		
		div
	}
	
	def Statement multiply(Expression stmnt, long factor) {
		val NumericalMultiplyDivideExpression div = stext.factory.createNumericalMultiplyDivideExpression
		val PrimitiveValueExpression pve = stext.factory.createPrimitiveValueExpression 
		val IntLiteral intLit = stext.factory.createIntLiteral
		intLit.value = factor.intValue
		pve.value = intLit
		
		div.operator = MultiplicativeOperator::MUL
		div.leftOperand = stmnt
		div.rightOperand = pve
		
		div
	}
	
		
	def dispatch Sequence mapEffect(Effect effect) {}
	
	def dispatch Sequence mapEffect(ReactionEffect effect) {
		if ( ! effect.actions.empty) {
			val sequence = sexec.factory.createSequence
			sequence.name = "reaction_action"
			sequence.steps.addAll( effect.actions.map( stmnt | stmnt.mapToExecution))
			return sequence	
		}	
	}
	
	def Execution mapToExecution(Statement stmnt) {
		val exec = sexec.factory.createExecution
		exec.statement = EcoreUtil::copy(stmnt)
		exec	
	}
	
	
	
}
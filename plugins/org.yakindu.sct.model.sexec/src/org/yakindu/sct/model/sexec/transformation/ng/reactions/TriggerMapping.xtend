package org.yakindu.sct.model.sexec.transformation.ng.reactions

import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sexec.transformation.ng.StextToExpressionMapper
import org.yakindu.sct.model.sgraph.Trigger
import org.yakindu.sct.model.stext.stext.AlwaysEvent
import org.yakindu.sct.model.stext.stext.EventSpec
import org.yakindu.sct.model.stext.stext.ReactionTrigger
import org.yakindu.sct.model.stext.stext.RegularEventSpec
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions

class TriggerMapping {
	
	@Inject extension ExpressionBuilder
	@Inject extension StextToExpressionMapper
	@Inject extension ExpressionExtensions
	@Inject extension SgraphExtensions
	
	def dispatch Expression toCheckExpression (Void t) { _true }
	
	def dispatch Expression toCheckExpression (Trigger t) { _true }
	
	def dispatch Expression toCheckExpression (ReactionTrigger t) {
		
		val hasTriggers = ! t.triggers.empty
		val triggersAreAlwaysTrue = t.triggers.filter(AlwaysEvent).size > 0 
		val triggerCheck = if (hasTriggers && !triggersAreAlwaysTrue) t.toTriggerCheck else null;
		
		val guard = t.buildGuard
		
		if ( triggerCheck !== null && guard !== null ) _parenthesized(triggerCheck)._and(_parenthesized(guard))
		else if ( triggerCheck !== null ) triggerCheck
		else if ( guard !== null ) guard
		else if ( triggersAreAlwaysTrue ) _true
		else _true
	}
	
	
	def protected toTriggerCheck(ReactionTrigger t) {
		t.triggers.reverseView.fold(null as Expression,
			[s,e | {
				val Expression raised = e.isRaised?._ref
				
				if (raised === null) s
				else if (s===null) raised  
				else raised._or(s)
			}])		
	}
	
	
	def protected dispatch Expression buildGuard( Trigger t) {null}
	
	def protected dispatch Expression buildGuard( ReactionTrigger t) {
		if ( t.guard !== null ) EcoreUtil::copy(t.guard.expression).replaceStextExpressions(t.statechart) else null
	}
	
	def protected dispatch isRaised(RegularEventSpec e) {
		e.event.featureOrReference
	}
	
	def protected dispatch isRaised(TimeEventSpec e) {
		null // TODO: transform time events into properties
	}
	
	def protected dispatch isRaised(EventSpec e) {
		null
	}
	
}
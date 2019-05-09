/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sequencer.expressions

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.IfExpression
import org.yakindu.base.expressions.util.ExpressionBuilder
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sequencer.util.SgraphExtensions
import org.yakindu.sct.model.sequencer.vectors.StateVector
import org.yakindu.sct.model.sgraph.Choice
import org.yakindu.sct.model.sgraph.Reaction
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.sgraph.Synchronization
import org.yakindu.sct.model.sgraph.Transition
import org.yakindu.sct.model.sgraph.Vertex

/**
 * Most things are copied from BehaviorMapping and rewritten to work on sgraph and expressions instead of sexec.
 * 
 * Basically this implements a mapping from sgraph transitions or local reactions to corresponding if-then expressions.
 */
class ReactionToExpression {
	
	@Inject extension ExpressionBuilder
	@Inject extension SgraphExtensions
	@Inject extension StateVector
	@Inject extension StatemachineExpressionBuilder
	
	@Inject extension TriggerToExpression
	@Inject extension EffectToExpression
	
	def IfExpression mapLocalReaction(Reaction lr) {
		_if(lr.trigger.toCheckExpression)._then(_block(lr.effect.toEffectExpressions))
	}
	
	def IfExpression mapTransition(Transition t) {
		mapTransition(t, t.source, t.target)
	}
	
	def protected dispatch IfExpression mapTransition(Transition t, Vertex source, Vertex target) {
		_if(t.trigger.toCheckExpression)
		._then(_block(toEffectExpressions(#[t])))
	}
	
	def protected dispatch IfExpression mapTransition(Transition t, Choice source, Vertex target) {
		_if(t.trigger.toCheckExpression)
		._then(_block(toEffectExpressions(#[t])))
	}
	
	def protected dispatch IfExpression mapTransition(Transition t, State source, Synchronization target) {
		val sc = t.statechart
		// build the condition
		var Expression condition = if (t.trigger !== null) t.trigger.toCheckExpression
		
		val joinTransitions = target.incomingTransitions
			.filter( jt | jt.source instanceof State)
			.sortBy( jt | (jt.source as State).stateVector.offset )
		
		for ( trans : joinTransitions.filter( trans | trans != t )) { 
			if (trans.source instanceof State) { 
				condition = condition.conjunct(sc._isStateActive(trans.source as State))
				if (trans.trigger !== null) condition = condition.conjunct(trans.trigger.toCheckExpression)
			}
		}
		// map effects of all transitions as a compound effect
		val effects = joinTransitions.toEffectExpressions
		
		return _if(condition)._then(_block(effects))
	}
	
	def protected Expression conjunct(Expression c1, Expression c2) {
		if (c1 !== null && c2 !== null ) c1._and(c2)
		else if (c1 !== null) c1
		else c2
	}
	
}

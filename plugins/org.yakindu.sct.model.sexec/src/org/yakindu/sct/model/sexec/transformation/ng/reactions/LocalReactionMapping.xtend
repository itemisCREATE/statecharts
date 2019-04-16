package org.yakindu.sct.model.sexec.transformation.ng.reactions

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sgraph.Reaction

class LocalReactionMapping {
	
	@Inject extension ExpressionBuilder
	
	@Inject extension TriggerMapping
	@Inject extension EffectMapping
	
	def mapLocalReaction(Reaction lr) {
		_if(lr.trigger.toCheckExpression)._then(_block(lr.effect.toEffectExpressions))
	}
	
}
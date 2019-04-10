package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression

class StextToExpressionMapper {
	
	@Inject protected extension StatemachineMethods
	@Inject protected extension StatemachinePublic
	@Inject protected extension ExpressionBuilder
	
	def dispatch mapToExpression(Expression exp, Statechart sc) { exp }
	
	def dispatch mapToExpression(ActiveStateReferenceExpression asr, Statechart sc) {
		sc.createIsStateActiveMethod._call(sc.statesEnumeration._ref._fc(asr.value.enumerator))
	}
}

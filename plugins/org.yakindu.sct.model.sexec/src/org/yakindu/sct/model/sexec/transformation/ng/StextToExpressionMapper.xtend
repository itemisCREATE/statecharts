package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil

class StextToExpressionMapper {
	
	@Inject protected extension StatemachineMethods
	@Inject protected extension StatemachinePublic
	@Inject protected extension ExpressionBuilder
	@Inject protected extension StatemachineExpressionBuilder
	
	def dispatch replaceStextExpressions(Expression exp, Statechart sc) { 
		exp.eAllContents.forEach[doReplace(sc)]
		exp
	}
	
	def dispatch replaceStextExpressions(ActiveStateReferenceExpression asr, Statechart sc) { 
		sc._isStateActive(asr.value)
	}
	
	protected def dispatch doReplace(EObject e, Statechart sc) { }
	
	protected def dispatch doReplace(ActiveStateReferenceExpression asr, Statechart sc) {
		EcoreUtil.replace(asr, sc._isStateActive(asr.value))
	}
}

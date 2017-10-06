package org.yakindu.sct.generator.c.extensions

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.sct.generator.c.CExpressionsGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow

class ExpressionsChecker {

	@Inject protected extension CExpressionsGenerator

	def modOnReal(ExecutionFlow it) {
		!eAllContents.filter(NumericalMultiplyDivideExpression).filter[operator == MultiplicativeOperator.MOD].filter [
			it.haveCommonTypeReal
		].isEmpty || !eAllContents.filter(AssignmentExpression).filter[operator == AssignmentOperator.MOD_ASSIGN].filter [
			it.haveCommonTypeReal
		].isEmpty
	}
}

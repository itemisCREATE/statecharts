package org.yakindu.sct.generator.cpp

import javax.inject.Inject
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.c.CExpressionsGenerator
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition

class CppExpressionsGenerator extends CExpressionsGenerator {

	@Inject protected extension CppNaming
	@Inject protected extension Navigation
	@Inject protected extension ITypeSystem
	@Inject protected extension ITypeSystemInferrer
	@Inject protected extension INamingService
	@Inject protected extension ICodegenTypeSystemAccess

	/* Expressions */
	def dispatch CharSequence code(Expression it) '''#error TODO: generate code for «getClass().name»'''

	override dispatch CharSequence code(ElementReferenceExpression it,
		OperationDefinition target) '''«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.
		code»«ENDFOR»)'''

	override dispatch CharSequence code(EventRaisingExpression it) '''
	«IF value != null»
		«event.definition.event.valueAccess» = «value.code»;
	«ENDIF»
	«event.definition.event.access» = true'''

	override dispatch CharSequence code(
		ActiveStateReferenceExpression it) '''«flow.stateActiveFctID»(«value.shortName»)'''

	/* Feature Call */
	override dispatch CharSequence code(FeatureCall it,
		OperationDefinition target) '''«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.code»«ENDFOR»)'''

	/* Literals */
	override dispatch CharSequence code(BoolLiteral it) '''«IF value»true«ELSE»false«ENDIF»'''

}

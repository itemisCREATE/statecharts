package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.Literal
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RealLiteral
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.types.ITypeSystem
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer
import org.yakindu.base.expressions.expressions.NullLiteral

class ExpressionCode {

	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension ITypeSystem
	@Inject extension ISTextTypeInferrer
	@Inject extension INamingService

	/* Refering to declared elements */
	def dispatch CharSequence code(ElementReferenceExpression it) {
		it.code(it.definition)
	}

	def dispatch CharSequence code(FeatureCall it) {
		it.code(it.definition)
	}

	def dispatch CharSequence code(Expression it, Event target) '''«target.access»'''

	def dispatch CharSequence code(Expression it, VariableDefinition target) '''«target.access»'''

	def dispatch CharSequence code(ElementReferenceExpression it, OperationDefinition target) '''«target.access»(«FOR arg : args SEPARATOR ', '»«arg.
		code»«ENDFOR»)'''

	def dispatch CharSequence code(FeatureCall it, OperationDefinition target) '''«target.access»(«FOR arg : args SEPARATOR ', '»«arg.
		code»«ENDFOR»)'''

	def dispatch CharSequence code(Expression it) '''#error TODO: generate code for «getClass().name»'''

	/* HANDLING LITERALS */
	def dispatch CharSequence code(Literal it) '''#error unknown literal type «getClass().name» '''
	
	def dispatch CharSequence code(NullLiteral it) '''«Naming::NULL_STRING»'''
	
	def dispatch CharSequence code(StringLiteral it) '''"«value.escaped»"'''

	def String escaped(String it) {
		return it.replace("\"", "\\\"");
	}

	def dispatch CharSequence code(BoolLiteral it) '''«IF value»true«ELSE»false«ENDIF»'''

	def dispatch CharSequence code(IntLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(RealLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(HexLiteral it) '''0x«Integer::toHexString(value)»'''

	def dispatch CharSequence code(PrimitiveValueExpression it) '''«value.code»'''

	/* Statements */
	def dispatch CharSequence code(AssignmentExpression it) '''«varRef.code» «operator.literal» «expression.code»'''

	def dispatch CharSequence code(EventRaisingExpression it) '''
	«IF value != null»
		«event.definition.event.valueAccess» = «value.code»;
	«ENDIF»
	«event.definition.event.access» = true'''

	/* Logical Expressions */
	def dispatch CharSequence code(LogicalOrExpression it) '''«leftOperand.code» || «rightOperand.code»'''

	def dispatch CharSequence code(LogicalAndExpression it) '''«leftOperand.code» && «rightOperand.code»'''

	def dispatch CharSequence code(LogicalNotExpression it) '''! «operand.code»'''

	def dispatch CharSequence code(LogicalRelationExpression it) '''
	«IF leftOperand.inferType.type.stringType»
		(«leftOperand.code».compare(«rightOperand.code») «operator.literal» 0)
	«ELSE»«leftOperand.code» «operator.literal» «rightOperand.code»«ENDIF»'''

	/* Bitwise Operations */
	def dispatch CharSequence code(BitwiseAndExpression it) '''«leftOperand.code» & «rightOperand.code»'''

	def dispatch CharSequence code(BitwiseOrExpression it) '''«leftOperand.code» | «rightOperand.code»'''

	def dispatch CharSequence code(BitwiseXorExpression it) '''«leftOperand.code» ^ «rightOperand.code»'''

	def dispatch CharSequence code(ShiftExpression it) '''«leftOperand.code» «operator.literal» «rightOperand.code»'''

	/* Numerical operations */
	def dispatch CharSequence code(NumericalAddSubtractExpression it) '''«leftOperand.code» «operator.literal» «rightOperand.
		code»'''

	def dispatch CharSequence code(NumericalMultiplyDivideExpression it) '''«leftOperand.code» «operator.literal» «rightOperand.
		code»'''

	def dispatch CharSequence code(NumericalUnaryExpression it) '''«operator.literal» «operand.code»'''

	/* TODO: check if event is active */
	def dispatch CharSequence code(EventValueReferenceExpression it) '''«value.definition.event.valueAccess»'''

	def dispatch CharSequence code(ActiveStateReferenceExpression it) '''«flow.activeFctID»(«value.shortName»)'''

	def dispatch CharSequence code(ParenthesizedExpression it) '''(«expression.code»)'''
}

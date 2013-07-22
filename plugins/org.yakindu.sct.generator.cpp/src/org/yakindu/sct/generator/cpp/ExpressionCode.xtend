package org.yakindu.sct.generator.cpp

import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import com.google.inject.Inject
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.AssignmentExpression
import org.yakindu.sct.model.stext.stext.LogicalOrExpression
import org.yakindu.sct.model.stext.stext.LogicalAndExpression
import org.yakindu.sct.model.stext.stext.LogicalNotExpression
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression
import org.yakindu.sct.model.stext.stext.ShiftExpression
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression
import org.yakindu.sct.model.stext.stext.ParenthesizedExpression
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer
import org.yakindu.sct.model.stext.types.ISTextTypeSystem
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.Literal
import org.yakindu.sct.model.stext.stext.StringLiteral
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.RealLiteral
import org.yakindu.sct.model.stext.stext.HexLiteral

class ExpressionCode {
	
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension ISTextTypeSystem
	@Inject extension ISTextTypeInferrer
	
	/* Refering to declared elements */
	
	def dispatch CharSequence code (ElementReferenceExpression it) {
		it.code(it.definition)
	}
		
	def dispatch CharSequence code (FeatureCall it) {
		it.code(it.definition)
	}
		
	def dispatch CharSequence code (Expression it, Event target) 
		'''«target.access»'''
		
	def dispatch CharSequence code (Expression it, VariableDefinition target) 
		'''«target.access»'''
	
	def dispatch CharSequence code (ElementReferenceExpression it, OperationDefinition target) 
		'''«target.access»(«FOR arg:args SEPARATOR ', '»«arg.code»«ENDFOR»)'''
	
	def dispatch CharSequence code (FeatureCall it, OperationDefinition target) 
		'''«target.access»(«FOR arg:args SEPARATOR ', '»«arg.code»«ENDFOR»)'''
	
	
	def dispatch CharSequence code (Statement it) 
		'''#error TODO: generate code for «getClass().name»'''

	
	/* HANDLING LITERALS */
	def dispatch CharSequence code (Literal it)
		'''#error unknown literal type «getClass().name» '''
	
	
	def dispatch CharSequence code (StringLiteral it) 
		'''"«value.escaped»"'''	
		
	def String escaped(String it) {
		return it.replace("\"", "\\\"");
	}
	

	def dispatch CharSequence code (BoolLiteral it) 
		'''«IF value»true«ELSE»false«ENDIF»'''	

	def dispatch CharSequence code (IntLiteral it) 
		'''«value.toString»'''	

	def dispatch CharSequence code (RealLiteral it) 
		'''«value.toString»'''	
		
	def dispatch CharSequence code (HexLiteral it) 
		'''0x«Integer::toHexString(value)»'''	

	def dispatch CharSequence code (PrimitiveValueExpression it) 
		'''«value.code»'''	

		
	/* Statements */
	
	def dispatch CharSequence code (AssignmentExpression it)
		'''«varRef.code» «operator.literal» «expression.code»'''
		
	def dispatch CharSequence code (EventRaisingExpression it)
		'''
		«IF value != null»
			«event.definition.event.valueAccess» = «value.code»;
		«ENDIF»
		«event.definition.event.access» = true'''	


	/* Logical Expressions */
	
	def dispatch CharSequence code (LogicalOrExpression it)
		'''«rightOperand.code» || «leftOperand.code»'''
		
	def dispatch CharSequence code (LogicalAndExpression it)
		'''«rightOperand.code» && «leftOperand.code»'''
	 	
	def dispatch CharSequence code (LogicalNotExpression it)
		'''! «operand.code»'''
		
	def dispatch CharSequence code (LogicalRelationExpression it) '''
		«IF leftOperand.inferType.type.stringType»
			(«leftOperand.code».compare(«rightOperand.code») «operator.literal» 0)
		«ELSE»«leftOperand.code» «operator.literal» «rightOperand.code»«ENDIF»'''
	
	/* Bitwise Operations */
	
	def dispatch CharSequence code (BitwiseAndExpression it)
		'''«leftOperand.code» & «rightOperand.code»'''
	
	def dispatch CharSequence code (BitwiseOrExpression it)
		'''«leftOperand.code» | «rightOperand.code»'''
	
	def dispatch CharSequence code (BitwiseXorExpression it)
		'''«leftOperand.code» ^ «rightOperand.code»'''
	
	def dispatch CharSequence code (ShiftExpression it)
		'''«leftOperand.code» «operator.literal» «rightOperand.code»'''

	/* Numerical operations */
	
	def dispatch CharSequence code (NumericalAddSubtractExpression it)
		'''«leftOperand.code» «operator.literal» «rightOperand.code»'''
	
	def dispatch CharSequence code (NumericalMultiplyDivideExpression it)
		'''«leftOperand.code» «operator.literal» «rightOperand.code»'''
	
	def dispatch CharSequence code (NumericalUnaryExpression it)
		'''«operator.literal» «operand.code»'''
	
	/* TODO: check if event is active */
	def dispatch CharSequence code (EventValueReferenceExpression it)
		'''«value.definition.event.valueAccess»'''
	
	def dispatch CharSequence code (ActiveStateReferenceExpression it)
		'''«flow.nameOfIsActiveFunction»(«value.fullyQualifiedName»)'''
	
	def dispatch CharSequence code (ParenthesizedExpression it)
		'''(«expression.code»)'''
}
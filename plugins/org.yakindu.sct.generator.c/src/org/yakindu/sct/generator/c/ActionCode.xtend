package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.base.types.ITypeSystemAccess
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.AssignmentExpression
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.Expression
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.stext.HexLiteral
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.Literal
import org.yakindu.sct.model.stext.stext.LogicalAndExpression
import org.yakindu.sct.model.stext.stext.LogicalNotExpression
import org.yakindu.sct.model.stext.stext.LogicalOrExpression
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.RealLiteral
import org.yakindu.sct.model.stext.stext.StringLiteral
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.validation.ITypeInferrer
import org.yakindu.sct.model.stext.stext.ShiftExpression
import org.yakindu.sct.model.stext.stext.ParenthesizedExpression

class ActionCode {
	
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension ITypeInferrer
	@Inject extension ITypeSystemAccess
	
	/* Refering to declared elements */
	
	def dispatch code (ElementReferenceExpression it) {
		code(it.definition)
	}
		
	def dispatch code (FeatureCall it) {
		code(it.definition)
	}
		
	def dispatch code (Expression it, Event target) 
		'''«target.access»'''
		
	def dispatch code (Expression it, VariableDefinition target) 
		'''«target.access»'''
	
	def dispatch code (ElementReferenceExpression it, OperationDefinition target) 
		'''«target.access»(«FOR arg:args SEPARATOR ', '»«arg.code»«ENDFOR»)'''
	
	def dispatch code (FeatureCall it, OperationDefinition target) 
		'''«target.access»(«FOR arg:args SEPARATOR ', '»«arg.code»«ENDFOR»)'''
	
	/*  */
	
	def dispatch code (Statement it) 
		'''#error TODO: generate code for «getClass().name»'''

	
	/* HANDLING LITERALS */
	def dispatch code (Literal it)
		'''#error unknown literal type «getClass().name» '''
	
	def dispatch code (StringLiteral it) 
		'''"«value»"'''	

	def dispatch code (BoolLiteral it) 
		'''«IF value»bool_true«ELSE»bool_false«ENDIF»'''	

	def dispatch code (IntLiteral it) 
		'''«value.toString»'''	

	def dispatch code (RealLiteral it) 
		'''«value.toString»'''	
		
	def dispatch code (HexLiteral it) 
		'''0x«Integer::toHexString(value)»'''	

	def dispatch code (PrimitiveValueExpression it) 
		'''«value.code»'''	

		
	/* Statements */
	
	def dispatch code (AssignmentExpression it)
		'''«varRef.code» «operator.literal» «expression.code»'''
		
	def dispatch code (EventRaisingExpression it)
		'''
		«IF value != null»
			«event.definition.event.valueAccess» = «value.code»;
		«ENDIF»
		«event.definition.event.access» = bool_true'''	


	/* Logical Expressions */
	
	def dispatch code (LogicalOrExpression it)
		'''«rightOperand.code» || «leftOperand.code»'''
		
	def dispatch code (LogicalAndExpression it)
		'''«rightOperand.code» && «leftOperand.code»'''
	 	
	def dispatch code (LogicalNotExpression it)
		'''! «operand.code»'''
		
	def dispatch code (LogicalRelationExpression it) '''
		«IF leftOperand.type.isString»
			(strcmp(«leftOperand.code», «rightOperand.code») «operator.literal» 0)
		«ELSE»«leftOperand.code» «operator.literal» «rightOperand.code»«ENDIF»'''
	
	/* Bitwise Operations */
	
	def dispatch code (BitwiseAndExpression it)
		'''«leftOperand.code» & «rightOperand.code»'''
	
	def dispatch code (BitwiseOrExpression it)
		'''«leftOperand.code» | «rightOperand.code»'''
	
	def dispatch code (BitwiseXorExpression it)
		'''«leftOperand.code» ^ «rightOperand.code»'''
	
	def dispatch code (ShiftExpression it)
		'''«leftOperand.code» «operator.literal» «rightOperand.code»'''

	/* Numerical operations */
	
	def dispatch code (NumericalAddSubtractExpression it)
		'''«leftOperand.code» «operator.literal» «rightOperand.code»'''
	
	def dispatch code (NumericalMultiplyDivideExpression it)
		'''«leftOperand.code» «operator.literal» «rightOperand.code»'''
	
	def dispatch code (NumericalUnaryExpression it)
		'''«operator.literal» «operand.code»'''
	
	/* TODO: check if event is active */
	def dispatch code (EventValueReferenceExpression it)
		'''«value.definition.event.valueAccess»'''
	
	def dispatch code (ActiveStateReferenceExpression it)
		'''«flow.nameOfIsActiveFunction»(«scHandle», «value.fullyQualifiedName»)'''
	
	def dispatch code (ParenthesizedExpression it)
		'''(«expression.code»)'''
	
}
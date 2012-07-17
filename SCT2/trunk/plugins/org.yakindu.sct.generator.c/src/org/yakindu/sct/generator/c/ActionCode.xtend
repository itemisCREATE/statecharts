package org.yakindu.sct.generator.c

import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.Literal
import org.yakindu.sct.model.stext.stext.StringLiteral
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.RealLiteral
import org.yakindu.sct.model.stext.stext.HexLiteral
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.AssignmentExpression
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.eclipse.emf.ecore.EObject
import com.google.inject.Inject
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.LogicalOrExpression
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.LogicalAndExpression
import org.yakindu.sct.model.stext.stext.LogicalNotExpression
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression
import org.yakindu.sct.model.stext.validation.ITypeInferrer
import org.yakindu.base.types.ITypeSystemAccess
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.FeatureCall

class ActionCode {
	
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension ITypeInferrer
	@Inject extension ITypeSystemAccess
	
	
		/** todo externalize */
	def dispatch access (VariableDefinition it) 
		'''«scHandle»->«scope.instance».«name.asIdentifier»'''
		
	/** todo externalize */
	def dispatch access (EventDefinition it) 
		'''«scHandle»->«scope.instance».«name.asIdentifier»'''
		
	/** todo externalize */
	def dispatch access (TimeEvent it) 
		'''«scHandle»->«scope.instance».«name.asIdentifier»'''
		
	def dispatch access (EObject it) 
		'''#warning can't access elements of type «getClass().name»'''
		
	
	
	def dispatch code (Statement it) 
		'''#error TODO: generate code for «getClass().name»'''

	
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
		'''«value.toString»'''	

	def dispatch code (PrimitiveValueExpression it) 
		'''«value.code»'''	

	/* Refering to declared elements */
	
	def dispatch code (ElementReferenceExpression it) 
		'''«reference.access.raised»'''
		
	def dispatch code (FeatureCall it) 
		'''«feature.access.raised»'''
		
		
	/* Statements */
	
	def dispatch code (AssignmentExpression it)
		'''«varRef.code» «operator.literal» «expression.code»'''
		
	def dispatch code (EventRaisingExpression it)
		'''
		«IF value != null»
			«event.definition.access.value» = «value.code»;
		«ENDIF»
		«event.definition.access.raised» = bool_true'''	


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
		«ELSE»
			«leftOperand.code»«operator.literal»«rightOperand.code»
		«ENDIF»
		'''
	
	/* Bitwise Operations */
	
	def dispatch code (BitwiseAndExpression it)
		'''«rightOperand.code» & «leftOperand.code»'''
	
	def dispatch code (BitwiseOrExpression it)
		'''«rightOperand.code» | «leftOperand.code»'''
	
	def dispatch code (BitwiseXorExpression it)
		'''«rightOperand.code» ^ «leftOperand.code»'''
	

	/* Numerical operations */
	
	def dispatch code (NumericalAddSubtractExpression it)
		'''«rightOperand.code» «operator.literal» «leftOperand.code»'''
	
	def dispatch code (NumericalMultiplyDivideExpression it)
		'''«rightOperand.code» «operator.literal» «leftOperand.code»'''
	
	def dispatch code (NumericalUnaryExpression it)
		'''«operator.literal» «operand.code»'''
	
	/* TODO: check if event is active */
	def dispatch code (EventValueReferenceExpression it)
		'''«value.definition.code.value»'''
	
	def dispatch code (ActiveStateReferenceExpression it)
		'''isActive(«value.name.asIdentifier»)'''
	
}
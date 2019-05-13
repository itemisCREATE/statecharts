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
package org.yakindu.sct.types.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.BinaryExpression
import org.yakindu.base.expressions.expressions.BinaryLiteral
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.ForExpression
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IfExpression
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.ReturnExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.SwitchCase
import org.yakindu.base.expressions.expressions.SwitchExpression
import org.yakindu.base.expressions.expressions.ThrowExpression
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.expressions.expressions.UnaryExpression
import org.yakindu.base.expressions.expressions.WhileExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.Package
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem

import static org.yakindu.base.expressions.expressions.util.ArgumentSorter.*

class Expressions {

	@Inject protected extension ITypeSystemInferrer
	
	def dispatch String code(Void it) {
		println("Null type")
	}

	def dispatch String code(BinaryExpression it) 
		'''(«leftOperand.code.toString.trim» «operator.literal.toString.trim» «rightOperand.code»)'''

	def dispatch String code(UnaryExpression it) 
		'''«operator.literal»«operand.code»'''

	def dispatch String code(PostFixUnaryExpression it) 
		'''«operand.code»«operator.literal»'''

	def dispatch String code(AssignmentExpression it) 
		'''«varRef.code» «operator.literal» «expression.code»'''

	def dispatch String code(ConditionalExpression it) 
		'''«condition.code» ? «trueCase.code» : «falseCase.code»'''

	def dispatch String code(PrimitiveValueExpression it) 
		'''«value.code»'''

	def dispatch String code(ParenthesizedExpression it) 
		'''(«expression.code»)'''

	def dispatch String code(TypeCastExpression it) 
		'''((«type.code») «operand.code»)'''
		
	def dispatch String code(ElementReferenceExpression it)
		'''«argumentCall(reference)»«FOR arrSel : arraySelector»[«arrSel.code»]«ENDFOR»''' 

	def dispatch String code(FeatureCall it) {
		if(featureOrReference instanceof Enumerator) {
			'''«feature.code»'''
		} else {
			'''«it.owner.code».«it.argumentCall(feature)»«FOR arrSel : arraySelector»[«arrSel.code»]«ENDFOR»'''
		}
	}
	
	def protected argumentCall(ArgumentExpression it, EObject reference){
		if(reference !== null) {
			return '''«((reference as NamedElement).name)»«IF reference instanceof Operation»«argumentList(reference as Operation)»«ENDIF»'''
		}
		else {
			return '''null; //Reference from «it» is null'''
		}
	}
	
	def protected argumentList(ArgumentExpression it, Operation operation)
		'''(«FOR exp : getOrderedExpressions(arguments, operation)  SEPARATOR ','»«exp.code»«ENDFOR»)'''
	
	def dispatch String code(BlockExpression it) 
		'''
		{
			«FOR exp : expressions SEPARATOR '\n'»«exp.code»«exp.terminator»«ENDFOR»
		}
	'''

	def dispatch String code(IfExpression it) 
	'''
		if(«condition.code»)«then.code»«IF ^else !== null»else«^else.code»«ENDIF»
	'''

	def dispatch String code(SwitchExpression it) '''
		switch(«^switch.code») {
			«FOR _case : cases»
				«_case.code(^switch.infer.type)»
			«ENDFOR»
			«IF it.^default !== null»
				default:
					«^default.code»«^default.terminator»
			«ENDIF»
			
		} 
	'''

	def String code(SwitchCase it, Type switchType) ''' 
		«IF switchType instanceof EnumerationType»
			case «(^case as ArgumentExpression).featureOrReference.code»:
				«then.code»«then.terminator»
		«ELSE»
			case «^case.code»:
				«then.code»«then.terminator»
		«ENDIF»
			«IF !then.isReturnStatement»break;«ENDIF»
	'''
	
	def protected dispatch boolean isReturnStatement(Void e) { false }
	def protected dispatch boolean isReturnStatement(Expression e) { false }
	def protected dispatch boolean isReturnStatement(ReturnExpression e) { true }
	def protected dispatch boolean isReturnStatement(BlockExpression e) { e.expressions.last.isReturnStatement }

	def dispatch String code(Enumerator it) {
		'''«name»'''
	}

	def dispatch String code(ForExpression it)
		'''
		for(«FOR v : varInits SEPARATOR ', '»«v.code»«ENDFOR»;«condition?.code»;«FOR u:varUpdates SEPARATOR ', '»«u.code»«ENDFOR»)«body.code»
	'''

	def dispatch String code(WhileExpression it) 
		'''
		while(«condition.code»)«body.code»
	'''

	def dispatch String code(ReturnExpression it) 
		'''return «it.expression.code»'''

	def dispatch String code(ThrowExpression it) 
		'''throw «it.expression.code»''' // TODO implement

	def dispatch String code(Property it)
		'''
	«IF static»static«ENDIF»«typeSpecifier.code» «name»«IF initialValue !== null»= «initialValue.code»«ENDIF»«terminator»'''
	
	def dispatch String code(TypeSpecifier it) {
		type.code
	}
	
	def dispatch String code(Type it) {
		'''«name»'''
	}
	
	def dispatch String code(StringLiteral it) 
		'''"«value.escaped»"'''

	def protected String escaped(String it) {
		return it.replace("\"", "\\\"");
	}
	
	def dispatch String code(IntLiteral it) '''«value.toString»'''

	def dispatch String code(DoubleLiteral it) '''«value.toString»'''

	def dispatch String code(FloatLiteral it) '''«value.toString»'''

	def dispatch String code(HexLiteral it) '''0x«Integer::toHexString(value)»'''

	def dispatch String code(BinaryLiteral it) '''0b«Integer::toBinaryString(value)»'''

	def dispatch String code(BoolLiteral it) '''«value.toString»'''

	def dispatch String code(NullLiteral it) '''null'''

	def dispatch String code(Expression it) '''//unhandeled expression «it»'''
	
	def dispatch featureOrReference(FeatureCall it) {
		feature
	}
	
	def dispatch featureOrReference(ElementReferenceExpression it) {
		reference
	}
	
	def protected isArray(Type type) {
		return ITypeSystem.ARRAY.equals(type.name)
	}

	def dispatch terminator(Expression it) {
		if ((eContainer instanceof BlockExpression) || 
			(eContainer instanceof ComplexType) ||
			(eContainer instanceof SwitchCase) ||
			(eContainer instanceof SwitchExpression) || 
			(eContainer instanceof Package)
			)
			''';''' 
		else 
			''''''
	}
	
	def dispatch terminator(ForExpression it) ''''''
	def dispatch terminator(WhileExpression it) ''''''
	def dispatch terminator(IfExpression it) ''''''
	def dispatch terminator(SwitchExpression it) ''''''
	def dispatch terminator(BlockExpression it) ''''''


}

/** 
 * Copyright (c) 2017-2018 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Parameter
import org.yakindu.base.types.Property
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.c.extensions.ExpressionsChecker
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.submodules.EventCode
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.generator.core.multism.MultiStatemachineHelper
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.TypedDeclaration
import org.yakindu.base.expressions.util.ExpressionExtensions

/**
 * @author axel terfloth
 */
class CExpressionsGenerator extends ExpressionsGenerator {

	@Inject protected extension Naming
	@Inject protected extension SExecExtensions

	@Inject protected extension ITypeSystem
	@Inject protected extension ITypeSystemInferrer
	@Inject protected extension INamingService
	@Inject protected extension CLiterals
	
	@Inject protected extension EventCode
	@Inject protected extension ExpressionsChecker
	
	@Inject protected extension CMultiStatemachine
	@Inject protected extension MultiStatemachineHelper
	
	@Inject extension ExpressionExtensions
		
	/* Referring to declared elements */
	def dispatch CharSequence code(ElementReferenceExpression it) {
		val target = it.definition
		if ( target !== null)
			it.code(target)
		else 
			it.code(it.reference)
	}
	

	/* Expressions */
	def dispatch CharSequence code(Expression it, Event target) '''«target.access»'''

	def dispatch CharSequence code(Expression it, VariableDefinition target) '''«target.access»'''

	/* TODO: check if event is active */
	def dispatch CharSequence code(EventValueReferenceExpression it) '''«value.definition.event.valueAccess»'''

	def dispatch CharSequence code(ElementReferenceExpression it, VariableDefinition target) '''«target.access»'''

	def dispatch CharSequence code(ElementReferenceExpression it, OperationDefinition target) 
		'''«target.access»(«scHandle»«FOR arg : expressions BEFORE ', ' SEPARATOR ', '»«arg.code»«ENDFOR»)'''


	def dispatch CharSequence code(ElementReferenceExpression it, Method target) 
		'''«target.access»(«scHandle»«FOR arg : expressions BEFORE ', ' SEPARATOR ', '»«arg.code»«ENDFOR»)'''


	def dispatch CharSequence code(ElementReferenceExpression it, Operation target) 
		'''«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.code»«ENDFOR»)'''

	def dispatch CharSequence code(ElementReferenceExpression it, Property target) 
		'''«target.access»'''

	def dispatch CharSequence code(ElementReferenceExpression it, Parameter target) 
		'''«target.name»'''
	
	def dispatch CharSequence code(ElementReferenceExpression it, ComplexType target) {
		'''«target.name» //new'''
	}

	def dispatch CharSequence code(EventRaisingExpression it) {
		val event = event
		if (event instanceof FeatureCall) {
			val feature = event.feature
			if (feature instanceof EventDefinition) {
				val type = feature.eContainer
				if (type instanceof ComplexType) {
					return '''«type.name.toFirstLower»Iface«getSeparator»raise«getSeparator»«feature.name.asIdentifier.toFirstLower»(&«event.owner.code»«IF value !== null», «value.code»«ENDIF»)'''
				}
			}
		}
		eventRaisingCode(this)
	}

	def dispatch CharSequence code(
		ActiveStateReferenceExpression it) '''«flow.stateActiveFctID»(«scHandle», «value.shortName»)'''

	def dispatch CharSequence code(LogicalRelationExpression it) '''
	«IF leftOperand.infer.type.isString»
		(strcmp(«leftOperand.code», «rightOperand.code») «operator.literal» 0)
	«ELSE»(«leftOperand.code») «operator.literal» («rightOperand.code»)«ENDIF»'''


	def dispatch CharSequence code(LogicalAndExpression it) '''(«leftOperand.sc_boolean_code») && («rightOperand.sc_boolean_code»)'''
	
	def dispatch CharSequence code(LogicalOrExpression it) '''(«leftOperand.sc_boolean_code») || («rightOperand.sc_boolean_code»)'''
	
	override dispatch CharSequence code(AssignmentExpression it) {
		if (it.operator.equals(AssignmentOperator.MOD_ASSIGN) && haveCommonTypeReal(it)) {
			'''«varRef.code» = «varRef.castToReciever»fmod(«varRef.code»,«expression.code»)'''
		} else
			super._code(it)
	}

	def dispatch CharSequence code(NumericalMultiplyDivideExpression expression) {
		if (expression.operator == MultiplicativeOperator.MOD && haveCommonTypeReal(expression)) {
			'''«expression.eContainer.castToReciever»fmod(«expression.leftOperand.code.toString.trim»,«expression.rightOperand.code»)'''
		} else {
			super._code(expression);
		}
	}

	/* Feature call */
	def dispatch CharSequence code(FeatureCall it) {
		it.code(it.definition)
	}
	
	def dispatch CharSequence code(FeatureCall it, VariableDefinition target) {
		val container = target.eContainer
		if(container instanceof ComplexType) {
			print("First")
			val fcontainer = it.eContainer
			if(fcontainer instanceof FeatureCall) {
				val x = fcontainer.accessComplexType(target)
				print(x)
			}
			return '''«owner.accessComplexType(target)».«target.name»'''
		}
		return '''Second: «target.access»'''
	}
	
	protected def CharSequence accessComplexType(Expression owner, VariableDefinition target) {
		if(owner instanceof FeatureCall) {
			return '''«owner.code(owner.feature)»«target.accessUnnamedIface»'''
		} else if (owner instanceof ElementReferenceExpression) {
			return '''«owner.code»«target.accessUnnamedIface»'''
		}
		return '''Cannot access ComplexType for Expression '«owner»' with target '«target»'.'''
	}
	
	
	protected def CharSequence accessUnnamedIface(VariableDefinition target)
		'''«IF !(target.getAnnotationOfType("unnamedInterface") === null)».iface«ENDIF»'''
	
	def dispatch CharSequence code(FeatureCall it, OperationDefinition target) {
		val type = target.eContainer
		if (type instanceof ComplexType) {
			return '''«type.name.toFirstLower»Iface«getSeparator»«target.name.asIdentifier.toFirstLower»(&«it.owner.code»«IF !expressions.nullOrEmpty», «ENDIF»«FOR arg : expressions SEPARATOR ', '»«arg.code»«ENDFOR»)'''
		}
		return '''«target.access»(«scHandle»«FOR arg : expressions BEFORE ', ' SEPARATOR ', '»«arg.code»«ENDFOR»)'''
	}

	def dispatch CharSequence code(FeatureCall it, Operation target) {
		if(target.eContainer instanceof ComplexType) {
			return '''«target.getFunctionId(owner.featureOrReference)»(&«owner.code»)'''
		} 
		return '''«it.owner.code».«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.
		code»«ENDFOR»)'''
				
	}
	

	def dispatch CharSequence code(FeatureCall it, Property target) '''«it.owner.code».«IF target.eContainer instanceof ComplexType»iface«target.access.toString.toFirstUpper»«ELSE»«target.access»«ENDIF»'''

	def dispatch CharSequence code(FeatureCall it, Enumerator target) '''«target.access»'''

	/* Literals */
	override dispatch CharSequence code(BoolLiteral it) '''«IF value»«TRUE_LITERAL»«ELSE»«FALSE_LITERAL»«ENDIF»'''
	
	override dispatch CharSequence code(NullLiteral it) '''«NULL_LITERAL»'''

	// ensure we obtain an expression of type sc_boolean
	def dispatch CharSequence sc_boolean_code(Expression it) '''«it.code» == «TRUE_LITERAL»'''

	def dispatch CharSequence sc_boolean_code(LogicalOrExpression it) {code}

	def dispatch CharSequence sc_boolean_code(LogicalAndExpression it) {code}
	
	def dispatch CharSequence sc_boolean_code(BoolLiteral it) {code}

	def dispatch CharSequence sc_boolean_code(LogicalNotExpression it) '''«operand.code» == «FALSE_LITERAL»'''

	def dispatch CharSequence sc_boolean_code(LogicalRelationExpression it) {code}
	
	
	def CharSequence ternaryGuard(Expression it) '''(«it.code») ? «TRUE_LITERAL» : «FALSE_LITERAL»'''
	
	override dispatch CharSequence code(FloatLiteral it) '''«value.toString»f'''
}

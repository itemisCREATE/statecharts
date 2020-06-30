/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
 
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.Event
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.sct.generator.c.CExpressionsGenerator
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.types.ComplexType

class CppExpressionsGenerator extends CExpressionsGenerator {

	@Inject protected extension CppNaming
	@Inject protected extension ExpressionExtensions
	@Inject protected extension EventRaisingCode
	@Inject protected extension FeatureCallSeparator

	override dispatch CharSequence code(ElementReferenceExpression it, Operation target) '''«target.access»(«argumentsCode»)'''
	
	override dispatch CharSequence code(ElementReferenceExpression it, OperationDefinition target) '''«target.access»(«argumentsCode»)'''
	
	override dispatch CharSequence code(ElementReferenceExpression it, Method target) '''«target.access»(«argumentsCode»)'''
	
	def dispatch CharSequence code(ElementReferenceExpression it, Event target) '''«target.access»'''
	
	override dispatch CharSequence code(ElementReferenceExpression it, Property target) '''«target.access»'''

	override dispatch CharSequence code(EventRaisingExpression it) '''«raiseEvent(it, value?.code)»'''

	override dispatch CharSequence code(ActiveStateReferenceExpression it) '''«flow.stateActiveFctID»(«value.shortName»)'''
	
	override dispatch CharSequence code(EventValueReferenceExpression it) {
		val fc = value
		if (fc instanceof FeatureCall) {
			if (fc.feature.isExternal) {
				return '''«fc.context»«fc.feature.asGetter»()'''
			}
		}
		return '''«fc.featureOrReference.valueAccess»'''
	}
	
	override dispatch CharSequence code(AssignmentExpression it) {
		val varRef = varRef
		if(varRef instanceof FeatureCall){
			val container = varRef.feature.eContainer
			if (container instanceof ComplexType && container.isMultiSM) {
				return '''«varRef.owner.code»->«varRef.feature.asSetter»(«expression.code»)'''
			}
		}
		return super._code(it)
	}
	
	/* Feature Call */
	override dispatch CharSequence code(FeatureCall it, Operation target) '''«context»«target.access»(«argumentsCode»)'''
	
	override dispatch CharSequence code(FeatureCall it, OperationDefinition target) '''«context»«target.access»(«argumentsCode»)'''
	
	override dispatch CharSequence code(FeatureCall it, EventDefinition target) '''«context»«target.access»'''
	
	override dispatch CharSequence code(FeatureCall it, VariableDefinition target) '''«context»«target.access»'''
	
	override dispatch CharSequence code(FeatureCall it, Property target) '''«context»«target.access»'''
	
	override dispatch CharSequence metaCode(ElementReferenceExpression it, EventDefinition owner, Property feature)
		'''«owner.scope.instance».«owner.name.asEscapedIdentifier»_«feature.name.asEscapedIdentifier»'''
	
	protected def dispatch context(FeatureCall it) {
		val ownerCode = owner.code.toString
		if (ownerCode.isEmpty) ownerCode else ownerCode + owner.callSep
	}
	
	protected def dispatch context(ElementReferenceExpression it) {
		val refCode = code.toString
		if (refCode.isEmpty) refCode else refCode + callSep
	}
	
	protected def dispatch context(Expression it) ''''''

	/* Literals */
	override dispatch CharSequence code(BoolLiteral it) '''«IF value»true«ELSE»false«ENDIF»'''
	
	/** Don't use bool_true for C++ code */
	override dispatch CharSequence sc_boolean_code(Expression it) {code}
	
	/** Don't use bool_false for C++ code */
	override dispatch CharSequence sc_boolean_code(LogicalNotExpression it) {code}
	
	protected def argumentsCode(ArgumentExpression it) '''«FOR arg : expressions SEPARATOR ', '»«arg.code»«ENDFOR»'''
		
}

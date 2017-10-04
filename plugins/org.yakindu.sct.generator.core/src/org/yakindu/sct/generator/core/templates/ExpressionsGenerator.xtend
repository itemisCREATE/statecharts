/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.sct.generator.core.templates

import javax.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.BinaryExpression
import org.yakindu.base.expressions.expressions.BinaryLiteral
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.Literal
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.expressions.expressions.UnaryExpression
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.naming.INamingService

/**
 * 
 * @author Rene Beckmann - Initial contribution and API
 */
class ExpressionsGenerator {
	
	@Inject protected extension ITypeSystem
	@Inject protected extension ITypeSystemInferrer
	@Inject protected extension INamingService
	@Inject protected extension ICodegenTypeSystemAccess
	
	def dispatch CharSequence code(BinaryExpression expression) {
		expression.leftOperand.code.toString.trim + " " + expression.operator.literal.toString.trim + " " + expression.rightOperand.code
	}

	def dispatch CharSequence code(UnaryExpression expression) {
		expression.operator.literal + expression.operand.code
	}
	
	def dispatch CharSequence code(EObject it) {
		throw new IllegalStateException("No dispatch function for " + getClass().name)
	}
	
	def dispatch CharSequence code(ConditionalExpression it) '''«condition.code» ? «trueCase.code» : «falseCase.code»'''

	/* Literals */
	def dispatch CharSequence code(Literal it) '''#error unknown literal type «getClass().name» '''

	def String escaped(String it) {
		return it.replace("\"", "\\\"");
	}

	def dispatch CharSequence code(StringLiteral it) '''"«value.escaped»"'''

	def dispatch CharSequence code(IntLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(DoubleLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(FloatLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(HexLiteral it) '''0x«Integer::toHexString(value)»'''

	def dispatch CharSequence code(BinaryLiteral it) '''0b«Integer::toBinaryString(value)»'''

	def dispatch CharSequence code(PrimitiveValueExpression it) '''«value.code»'''
	
	def dispatch CharSequence code(BoolLiteral it) '''«value.toString»'''
	
	def dispatch CharSequence code(NullLiteral expression) {
		'null'
	}
	
	/* Statements */
	def dispatch CharSequence code(AssignmentExpression it) '''«varRef.code» «operator.literal» «expression.code»'''

	def dispatch CharSequence code(LogicalRelationExpression it) '''
	«IF isSame(leftOperand.infer.type, getType(GenericTypeSystem.STRING))»
		(strcmp(«leftOperand.code», «rightOperand.code») «operator.literal» 0)
	«ELSE»«leftOperand.code» «operator.literal» «rightOperand.code»«ENDIF»'''

	def dispatch CharSequence code(ParenthesizedExpression it) '''(«expression.code»)'''

	def dispatch CharSequence code(TypeCastExpression it) '''((«type.getTargetLanguageName») «operand.code»)'''
}

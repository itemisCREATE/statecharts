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

import com.google.inject.Inject
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
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.expressions.expressions.UnaryExpression
import org.yakindu.base.types.Expression
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.expressions.expressions.IfExpression
import org.yakindu.base.expressions.expressions.SwitchExpression
import org.yakindu.base.expressions.expressions.ReturnExpression

/**
 * 
 * @author Rene Beckmann - Initial contribution and API
 */
class ExpressionsGenerator {

	@Inject protected extension ICodegenTypeSystemAccess
	
	def dispatch CharSequence code(Expression it) {
		throw new IllegalStateException("No dispatch function for " + getClass().name)
	}
	def dispatch CharSequence code(Literal it) {
		throw new IllegalStateException("No dispatch function for " + getClass().name)
	}

	/* Expressions */
	def dispatch CharSequence code(BinaryExpression it) {
		'''(«leftOperand.code.toString.trim» «operator.literal.toString.trim» «rightOperand.code»)'''
	}

	def dispatch CharSequence code(UnaryExpression it) {
		operator.literal + operand.code
	}

	def dispatch CharSequence code(PostFixUnaryExpression it) {
		operand.code + operator.literal
	}

	def dispatch CharSequence code(AssignmentExpression it) '''«varRef.code» «operator.literal» «expression.code»'''

	def dispatch CharSequence code(ConditionalExpression it) '''«condition.code» ? «trueCase.code» : «falseCase.code»'''

	def dispatch CharSequence code(PrimitiveValueExpression it) '''«value.code»'''

	def dispatch CharSequence code(ParenthesizedExpression it) '''(«expression.code»)'''

	def dispatch CharSequence code(TypeCastExpression it) '''((«type.name») «operand.code»)'''
	
	def dispatch CharSequence code(BlockExpression it) 
	'''
	{
		«FOR exp : expressions SEPARATOR '\n' AFTER ';' »«exp.code»«ENDFOR»
	}'''
	
	def dispatch CharSequence code(IfExpression it)
	'''
	if(«condition.code») {
		«then.code»
	} «IF ^else !== null»else {
		«^else.code»
	}
	«ENDIF»'''
	
	def dispatch CharSequence code(SwitchExpression it)
	'''
	switch(«^switch.code») {
		«FOR _case : cases SEPARATOR '\n'»
			case «_case.^case.code» : «_case.then.code»
			break;
		«ENDFOR»
	} 
	'''
	
	def dispatch CharSequence code(ReturnExpression it) '''return «it.expression.code»'''
	

	def dispatch CharSequence code(StringLiteral it) '''"«value.escaped»"'''

	def protected String escaped(String it) {
		return it.replace("\"", "\\\"");
	}

	def dispatch CharSequence code(IntLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(DoubleLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(FloatLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(HexLiteral it) '''0x«Integer::toHexString(value)»'''

	def dispatch CharSequence code(BinaryLiteral it) '''0b«Integer::toBinaryString(value)»'''

	def dispatch CharSequence code(BoolLiteral it) '''«value.toString»'''

	def dispatch CharSequence code(NullLiteral expression) {
		'null'
	}

}

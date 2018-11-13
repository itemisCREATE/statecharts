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
package org.yakindu.sct.model.sexec.transformation

import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.StextFactory

/**
 * @author Axel Terfloth added 'active' extension
 */
class StextExtensions {
	
	def expfactory() { ExpressionsFactory::eINSTANCE }
	def factory() { StextFactory::eINSTANCE }

	def Expression or(Expression left, Expression right) {
		val or = expfactory.createLogicalOrExpression
		or.leftOperand = left
		or.rightOperand = right
		or
	}
	
	def Expression and(Expression left, Expression right) {
		val and = expfactory.createLogicalAndExpression
		and.leftOperand = left
		and.rightOperand = right
		and
	}

	def Expression parenthesis(Expression exp) {
		val p = expfactory.createParenthesizedExpression
		p.expression = exp
		p
	}


	def Expression active(State state) {
		val active = factory.createActiveStateReferenceExpression
		active.value = state
		active
	}

} 
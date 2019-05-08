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
package org.yakindu.sct.model.sequencer.expressions

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.IfExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Package
import org.yakindu.sct.model.sequencer.util.ContainmentExtensions

class ExpressionOptimizer {
	
	@Inject extension ContainmentExtensions
	
	def Package optimize(Package p) {
		
		p.simplifyIfTrueExpressions
		p.simplifyBlockInBlockExpressions
		
		p
	}
	
	def protected simplifyBlockInBlockExpressions(Package p) {
		p.eAllContents.filter(BlockExpression)
			.filter[eContainer instanceof BlockExpression]
			.toList.forEach[innerBlock | innerBlock.replaceBy(innerBlock.expressions)]
	}
	
	def protected simplifyIfTrueExpressions(Package p) {
		p.eAllContents.filter(IfExpression)
			.filter[condition.isTrue]
			.forEach[ifExp | ifExp.replaceBy(ifExp.then)]
	}
	
	def protected isTrue(Expression exp) {
		if (exp instanceof PrimitiveValueExpression) {
			val value = exp.getValue
			if (value instanceof BoolLiteral) {
				return value.value
			}
		}
		return false
	}
}

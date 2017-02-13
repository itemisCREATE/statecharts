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

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.BinaryExpression
import org.yakindu.base.expressions.expressions.UnaryExpression

/**
 * 
 * @author Rene Beckmann - Initial contribution and API
 */
class Expressions {
	
	def dispatch CharSequence code(BinaryExpression expression) {
		expression.leftOperand.code.toString.trim + " " + expression.operator.literal.toString.trim + " " + expression.rightOperand.code
	}

	def dispatch CharSequence code(UnaryExpression expression) {
		expression.operator.literal + expression.operand.code
	}
	
	def dispatch CharSequence code(EObject it) {
		throw new IllegalStateException("No dispatch function for " + getClass().name)
	}
}

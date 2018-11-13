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
package org.yakindu.sct.generator.c

import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.types.Expression
import org.yakindu.sct.model.stext.stext.VariableDefinition

class ConstantInitializationResolver extends CExpressionsGenerator {
	
	def CharSequence resolveConstants(Expression it) {
		code
	}
	
	override dispatch String code(Expression it, VariableDefinition target) {
		target.initialValue.code.toString
	}
		
	override dispatch String code(FeatureCall it, VariableDefinition target) {
		target.initialValue.code.toString
	}
		
	override dispatch String code(ElementReferenceExpression it, VariableDefinition target) {
		target.initialValue.code.toString
	}
		
}
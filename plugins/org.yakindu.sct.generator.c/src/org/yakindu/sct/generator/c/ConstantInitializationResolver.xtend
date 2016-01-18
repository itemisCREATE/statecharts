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

import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.sct.model.stext.stext.VariableDefinition

class ConstantInitializationResolver extends ExpressionCode {
	
	def CharSequence resolveConstants(Expression it) {
		code
	}
	
	override dispatch CharSequence code(Expression it, VariableDefinition target) {
		target.initialValue.code
	}
		
}
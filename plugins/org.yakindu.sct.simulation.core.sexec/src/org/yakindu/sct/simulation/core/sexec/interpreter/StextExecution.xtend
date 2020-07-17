/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
 
package org.yakindu.sct.simulation.core.sexec.interpreter

import org.yakindu.base.expressions.interpreter.base.ExpressionExecution
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression

/**
 * Provides executions for expressions defined by stext.
 * 
 * @author axel terfloth
 */
class StextExecution extends ExpressionExecution {
	
	def dispatch void execution(EventRaisingExpression it) {
		
		it.event._exec
		if(it.value !== null) {
			it.value._exec
			_value
		}
		
		_execute[
			val value = if (it.value !== null) popValue else null
			val slot = popValue			
			raise(slot, value)			
		]		
	}
	
	
	def dispatch void execution(EventValueReferenceExpression expression) {
		
		expression.value._exec
		_return[
			val eventSlot = popValue()
			(eventSlot as ExecutionEvent).value
		]		
	}
	
	
	def dispatch void execution(ActiveStateReferenceExpression it) { _delegate }
	
}
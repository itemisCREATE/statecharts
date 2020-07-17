/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.expressions.interpreter.base

import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Data

/**
 * Defines a set of methods which can be used by concrete Execution implementations. 
 * 
 * @author axel terfloth
 */
abstract class BaseExecution implements IInterpreter.Execution  {

	public static String SELF_NAME = "_self_" // TODO: move to concept
	protected extension IInterpreter.Context context
		
	override setExecutionContext(IInterpreter.Context context) {
		this.context = context
	}
	
	protected def void _exec(Object o) {
		o.provideExecution	
	}

	def void _value() {
		_return("value", [
			popValue.getValue
		])
	}

	def void _return(()=>Object f) {
		_return("return", f)
	}
	
	def void _execute(Runnable f) {
		_execute("execute", f)
	}
	
	def void _executeOperation(Object owner, String name, List<String> parameters, Runnable body) {
		_execute ('''«name»''', [ 
			val paramValues = new ArrayList<Object>
			parameters.forEach[paramValues.add(popValue)]
			enterCall(name)
			if(owner !== null) defineVariable(SELF_NAME, owner)
			parameters.reverseView.forEach[ p, i | 
				defineVariable(p, paramValues.get(i))
			]
			body.run
		])
	}
	
	def void _delegate(Object program) {
		program._requestExecution(this)
	}
	
	@Data static class Invokation {
		
		protected Object caller
		protected Object operation
		
	}
}
/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.sgraph;

import org.yakindu.sct.simulation.runtime.ExecutionScope;
import org.yakindu.sct.simulation.runtime.sgraph.RTGuard;
import org.yakindu.sct.simulation.runtime.stext.RTExpression;


public class GuardExpression extends RTGuard {

	private RTExpression expression;
	private ExecutionScope scope;
	
	public GuardExpression() {
		super();
	}

	public GuardExpression(RTExpression expression, ExecutionScope scope) {
		super();
		this.expression = expression;
		this.scope = scope;
	}	


	
	public RTExpression getExpression() {
		return expression;
	}

	public void setExpression(RTExpression expression) {
		this.expression = expression;
	}

	public ExecutionScope getScope() {
		return scope;
	}

	public void setScope(ExecutionScope scope) {
		this.scope = scope;
	}

	public boolean evaluate() {
		Object result = expression.execute(scope);
		
		if (result instanceof Boolean)
			return ((Boolean) result).booleanValue();
		
		throw new StatechartRuntimeException();
	}

}

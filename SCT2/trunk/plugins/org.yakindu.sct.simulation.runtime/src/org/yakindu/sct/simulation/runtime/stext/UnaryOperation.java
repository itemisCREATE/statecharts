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
package org.yakindu.sct.simulation.runtime.stext;

import org.yakindu.sct.simulation.runtime.EvaluationException;
import org.yakindu.sct.simulation.runtime.ExecutionScope;

public class UnaryOperation implements Expression {

	
	protected Expression expression;
	protected String operator;
	
	public UnaryOperation() {
	}
	
	public UnaryOperation(String operator, Expression expr) {
		super();
		this.expression = expr;
		this.operator = operator;
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expr) {
		this.expression = expr;
	}


	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object execute(ExecutionScope scope) {
		Object[] operands = new Object[1];
		operands[0] = expression.execute(scope);
	
		Function func = Function.lookup(CoreFunction.class, operator, operands);
		
		if (func == null) throw new EvaluationException("Can't resolve function '" + operator + "' for type " + operands[0].getClass().getName() + " !");
		
		return func.execute(operands);
	}
	
}

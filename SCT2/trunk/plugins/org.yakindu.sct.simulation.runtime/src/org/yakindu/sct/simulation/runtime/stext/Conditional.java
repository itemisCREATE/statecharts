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

import org.yakindu.sct.simulation.runtime.ExecutionScope;

public class Conditional implements Expression {

	protected Expression condition;
	protected Expression trueValue;
	protected Expression falseValue;
	
	
	public Conditional() {
	}
	
	
	public Conditional(Expression condition, Expression trueValue, Expression falseValue) {
		super();
		this.condition = condition;
		this.trueValue = trueValue;
		this.falseValue = falseValue;
	}


	
	public Expression getCondition() {
		return condition;
	}


	public void setCondition(Expression condition) {
		this.condition = condition;
	}


	public Expression getTrueValue() {
		return trueValue;
	}


	public void setTrueValue(Expression trueValue) {
		this.trueValue = trueValue;
	}


	public Expression getFalseValue() {
		return falseValue;
	}


	public void setFalseValue(Expression falseValue) {
		this.falseValue = falseValue;
	}


	public Object execute(ExecutionScope scope) {
		
		Object conditionResult = condition.execute(scope);
		
		if (! (conditionResult instanceof Boolean)) {
			throw new RuntimeException("Evaluation Error: condition must be boolean.");
		}
		
		return ((Boolean) conditionResult).booleanValue() ? 
				trueValue.execute(scope) : 
				falseValue.execute(scope);
	}

}

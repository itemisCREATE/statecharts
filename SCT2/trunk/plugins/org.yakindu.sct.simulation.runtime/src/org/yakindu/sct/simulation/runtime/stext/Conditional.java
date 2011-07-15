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

public class Conditional implements RTExpression {

	protected RTExpression condition;
	protected RTExpression trueValue;
	protected RTExpression falseValue;
	
	
	public Conditional() {
	}
	
	
	public Conditional(RTExpression condition, RTExpression trueValue, RTExpression falseValue) {
		super();
		this.condition = condition;
		this.trueValue = trueValue;
		this.falseValue = falseValue;
	}


	
	public RTExpression getCondition() {
		return condition;
	}


	public void setCondition(RTExpression condition) {
		this.condition = condition;
	}


	public RTExpression getTrueValue() {
		return trueValue;
	}


	public void setTrueValue(RTExpression trueValue) {
		this.trueValue = trueValue;
	}


	public RTExpression getFalseValue() {
		return falseValue;
	}


	public void setFalseValue(RTExpression falseValue) {
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

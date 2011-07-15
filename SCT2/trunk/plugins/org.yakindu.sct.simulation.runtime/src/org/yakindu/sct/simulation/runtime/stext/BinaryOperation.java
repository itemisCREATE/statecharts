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

public class BinaryOperation implements RTExpression {

	
	protected RTExpression expr1;
	protected RTExpression expr2;
	protected Operator   operator;
	
	public BinaryOperation() {
	}
	
	public BinaryOperation(Operator operator, RTExpression expr1, RTExpression expr2) {
		super();
		this.expr1 = expr1;
		this.expr2 = expr2;
		this.operator = operator;
	}

	public BinaryOperation(String operator, RTExpression expr1, RTExpression expr2) {
		this(new Operator(operator), expr1, expr2);
	}

	public RTExpression getExpr1() {
		return expr1;
	}

	public void setExpr1(RTExpression expr1) {
		this.expr1 = expr1;
	}

	public RTExpression getExpr2() {
		return expr2;
	}

	public void setExpr2(RTExpression expr2) {
		this.expr2 = expr2;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Object execute(ExecutionScope scope) {
		return operator.execute(this, scope);
	}

		
	public static class Operator{

		protected String function = null;
		
		
		public Operator() {
			super();
		}

		public Operator(String function) {
			super();
			this.function = function;
		}

		public Object execute(BinaryOperation operation, ExecutionScope scope) {
			Object[] operands = new Object[2];
			operands[0] = operation.expr1.execute(scope);
			operands[1] = operation.expr2.execute(scope);
		
			Function func = Function.lookup(CoreFunction.class, function, operands);
			if (func == null) 
				throw new EvaluationException("Can't resolve function '" + function 
						+ "' for types (" + operands[0].getClass().getName() + ", " 
						+  operands[1].getClass().getName() + ") !");

			return func.execute(operands);
		}		
	}
	
	
	public static Operator OR = new Operator() {
		public Object execute(BinaryOperation operation, ExecutionScope scope) {
			return Assert.filterBoolean( operation.expr1.execute(scope)).booleanValue() 
					? Boolean.TRUE
					: Assert.filterBoolean( operation.expr2.execute(scope) ) ; 
		}
	};

	public static Operator AND = new Operator() {
		public Object execute(BinaryOperation operation, ExecutionScope scope) {
			return Assert.filterBoolean( operation.expr1.execute(scope)).booleanValue() 
					? Assert.filterBoolean( operation.expr2.execute(scope) )
					: Boolean.FALSE ; 
		}
	};

	
}

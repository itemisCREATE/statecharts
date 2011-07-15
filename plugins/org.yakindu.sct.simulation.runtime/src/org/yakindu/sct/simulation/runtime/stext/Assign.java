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

/**
 * 
 * @author terfloth@itemis.de
 *
 */
public class Assign implements Statement {
	
	protected VariableRef varRef;
	protected RTExpression expression;
	
	
	public Assign() {
		super();
	}

	public Assign(VariableRef varRef, RTExpression expression) {
		this();
		this.varRef = varRef;
		this.expression = expression;
	}
	
	public VariableRef getVarRef() {
		return varRef;
	}
	
	public void setVarRef(VariableRef varRef) {
		this.varRef = varRef;
	}

	public RTExpression getExpression() {
		return expression;
	}

	public void setExpression(RTExpression expression) {
		this.expression = expression;
	}

	public void execute(ExecutionScope scope) {
		varRef.getVariable(scope).setValue(expression.execute(scope));
	}

}

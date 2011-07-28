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

public class VariableRef implements RTExpression {

	protected String name;
	
	
	public VariableRef() {
		super();
	}

	public VariableRef(String name) {
		this();
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public RTVariable getVariable(ExecutionScope scope) {
		return scope.getVariable(name);
	}
	
	
	public Object execute(ExecutionScope scope) {
		return getVariable(scope).getValue();
	}

}

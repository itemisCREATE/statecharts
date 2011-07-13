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
import org.yakindu.sct.simulation.runtime.sgraph.Action;
import org.yakindu.sct.simulation.runtime.stext.Statement;


public class ActionStatement extends Action {

	protected Statement statement;
	protected ExecutionScope scope;
	
	
	public ActionStatement(Statement statement, ExecutionScope scope) {
		super();
		this.statement = statement;
		this.scope = scope;
	}
	
	

	public Statement getStatement() {
		return statement;
	}



	public void setStatement(Statement statement) {
		this.statement = statement;
	}



	public ExecutionScope getScope() {
		return scope;
	}



	public void setScope(ExecutionScope scope) {
		this.scope = scope;
	}



	@Override
	public void execute() {
		statement.execute(scope);
	}

}

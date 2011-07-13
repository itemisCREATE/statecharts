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

public class Raise implements Statement {

	protected String signal;
	
	
	public Raise() {
		super();
	}
	

	public Raise(String signal) {
		this();
		this.signal = signal;
	}


	public String getSignal() {
		return signal;
	}


	public void setSignal(String signal) {
		this.signal = signal;
	}


	public void execute(ExecutionScope scope) {
		scope.raise(signal);
	}

}

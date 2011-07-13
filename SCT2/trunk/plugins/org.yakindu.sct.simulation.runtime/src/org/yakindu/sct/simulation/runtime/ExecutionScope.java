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
package org.yakindu.sct.simulation.runtime;

import org.yakindu.sct.simulation.runtime.stext.Variable;

public interface ExecutionScope {

	public abstract Object getValue(String varName);

	public abstract Variable getVariable(String varName);

	public abstract void addVariable(Variable var);

	public abstract void call(String procedureId);

	public abstract void raise(String signal);

}
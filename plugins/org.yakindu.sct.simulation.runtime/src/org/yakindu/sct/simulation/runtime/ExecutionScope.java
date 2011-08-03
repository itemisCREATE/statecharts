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

import java.util.Collection;
import java.util.List;

import org.yakindu.sct.simulation.runtime.sgraph.RTEvent;
import org.yakindu.sct.simulation.runtime.sgraph.RTSignalEvent;
import org.yakindu.sct.simulation.runtime.stext.RTVariable;

public interface ExecutionScope {

	Object getValue(String varName);

	RTVariable getVariable(String varName);

	void addVariable(RTVariable var);

	void call(String procedureId);

	void raise(String signal);

	void setVariableValue(RTVariable variable, Object object);
	
	Collection<RTVariable> getVariables();

	List<RTSignalEvent> getEvents();

}
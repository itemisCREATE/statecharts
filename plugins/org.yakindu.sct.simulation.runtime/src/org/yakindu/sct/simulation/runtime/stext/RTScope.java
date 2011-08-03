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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yakindu.sct.simulation.runtime.ExecutionScope;
import org.yakindu.sct.simulation.runtime.sgraph.RTSignalEvent;


/**
 * 
 * @author terfloth@itemis.de
 */
public class RTScope implements ExecutionScope {

	protected Map<String, RTVariable> variables = new HashMap<String, RTVariable>();
	
	/* (non-Javadoc)
	 * @see com.yakindu.statechart.model.expressions.runtime.ExecutionScope#getValue(java.lang.String)
	 */
	public Object getValue(String varName) {
		RTVariable var = getVariable(varName);
		
		// TODO : handle not existing variables.
		return (var != null) ? var.getValue() : null ;
	}

	/* (non-Javadoc)
	 * @see com.yakindu.statechart.model.expressions.runtime.ExecutionScope#getVariable(java.lang.String)
	 */
	public RTVariable getVariable(String varName) {
		return variables.get(varName);
	}
		
	/* (non-Javadoc)
	 * @see com.yakindu.statechart.model.expressions.runtime.ExecutionScope#addVariable(com.yakindu.statechart.model.expressions.runtime.Variable)
	 */
	public void addVariable(RTVariable var) {
		// TODO : check for exceptions etc...
		variables.put(var.getName(), var);
	}


	/* (non-Javadoc)
	 * @see com.yakindu.statechart.model.expressions.runtime.ExecutionScope#call(java.lang.String)
	 */
	public void call(String procedureId) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.yakindu.statechart.model.expressions.runtime.ExecutionScope#raise(java.lang.String)
	 */
	public void raise(String signal) {
		// TODO Auto-generated method stub		
	}

	public void setVariableValue(RTVariable variable, Object object) {
		variable.setValue(object);
		
	}

	public Collection<RTVariable> getVariables() {
		return variables.values();
	}

	public List<RTSignalEvent> getEvents() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

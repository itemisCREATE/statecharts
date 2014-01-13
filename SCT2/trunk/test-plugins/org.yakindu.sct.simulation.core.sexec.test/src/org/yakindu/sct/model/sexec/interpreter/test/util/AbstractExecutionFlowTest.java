/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.interpreter.test.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.simulation.core.sexec.container.IExecutionContextInitializer;
import org.yakindu.sct.simulation.core.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionVariable;
import org.yakindu.sct.test.models.SCTUnitTestModels;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractExecutionFlowTest {
	@Inject
	protected IExecutionFlowInterpreter interpreter;
	@Inject
	protected SCTUnitTestModels models;
	@Inject
	protected ExecutionContext context;
	@Inject
	protected IExecutionContextInitializer initializer;

	protected ExecutionContext context() {
		return context;
	}

	protected void initInterpreter(ExecutionFlow flow) {
		initializer.initialize(context, flow);
		interpreter.initialize(flow, context);
	}

	protected int getInteger(String varName) {
		ExecutionVariable variable = context().getVariable(varName);
		return (Integer) variable.getValue();
	}

	protected boolean getBoolean(String varName) {
		ExecutionVariable variable = context().getVariable(varName);
		return (Boolean) variable.getValue();
	}

	protected Float getReal(String varName) {
		ExecutionVariable variable = context().getVariable(varName);
		return (Float) variable.getValue();
	}

	protected String getString(String varName) {
		ExecutionVariable variable = context().getVariable(varName);
		return (String) variable.getValue();
	}

	protected int setInteger(String varName, int v) {
		context().getVariable(varName).setValue((Integer) v);
		return v;
	}

	protected boolean setBoolean(String varName, boolean v) {
		context().getVariable(varName).setValue((Boolean) v);
		return v;
	}

	protected double setReal(String varName, double v) {
		context().getVariable(varName).setValue((Double) v);
		return v;
	}

	protected String setString(String varName, String v) {
		context().getVariable(varName).setValue((String) v);
		return v;
	}

	// -> Assertion methods...
	protected void assertVarValue(String variableName, Object value) {
		ExecutionVariable variable = context().getVariable(variableName);
		assertNotNull("Variable '" + variableName + "' is not defined", variable);
		assertEquals(value, variable.getValue());
	}

	protected boolean isActive(String stateName) {
		List<RegularState> allActiveStates = context().getAllActiveStates();
		for (RegularState regularState : allActiveStates) {
			if (regularState.getName().equals(stateName)) {
				return true;
			}
		}
		return false;
	}

	protected void raiseEvent(String eventName) {
		context().getEvent(eventName).setRaised(true);
	}

	protected void raiseEvent(String eventName, Object value) {
		context().getEvent(eventName).setValue(value);
		context().getEvent(eventName).setRaised(true);
		
	}

	protected boolean isRaised(String eventName) {
		return context().getEvent(eventName).isRaised();
	}

}

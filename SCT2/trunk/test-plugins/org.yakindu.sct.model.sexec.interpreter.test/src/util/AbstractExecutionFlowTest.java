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
package util;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.fail;

import java.util.Set;

import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.model.sexec.interpreter.InterpreterModule;
import org.yakindu.sct.model.sexec.transformation.SequencerModule;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.impl.ExecutionVariable;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class AbstractExecutionFlowTest {
	@Inject
	protected IExecutionFlowInterpreter interpreter;
	@Inject
	protected TestModels models;

	public AbstractExecutionFlowTest() {
		Guice.createInjector(
				Modules.override(new SequencerModule()).with(
						new InterpreterModule())).injectMembers(this);
	}

	protected IExecutionContext context() {
		return interpreter.getExecutionContext();
	}

	protected void loadAndconfigureInterpreter(ExecutionFlow flow) {
		interpreter.initialize(flow);
		interpreter.enter();
	}

	//
	// -> Assertion methods...
	//

	protected void assertVarValue(String variableName, Object value) {
		ExecutionVariable variable = context().getVariable(variableName);
		assertNotNull("Variable '" + variableName + "' is not defined",
				variable);
		assertEquals(variable.getValue(), value);
	}

	protected void assertIsActive(String stateName) {
		Set<RegularState> allActiveStates = context().getAllActiveStates();
		for (RegularState regularState : allActiveStates) {
			if (regularState.getName().equals(stateName)) {
				return;
			}
		}
		fail("Expected active state " + stateName + " but was "
				+ allActiveStates);
	}

}

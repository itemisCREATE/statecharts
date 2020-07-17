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

import org.eclipse.core.runtime.Assert;
import org.yakindu.base.expressions.interpreter.IExpressionInterpreter;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.model.sruntime.ExecutionEvent;
import org.yakindu.sct.model.sruntime.ExecutionVariable;
import org.yakindu.sct.model.stext.lib.StatechartAnnotations;
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler;
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler.TimeTask;
import org.yakindu.sct.simulation.core.engine.scheduling.ITimeTaskScheduler.TimeTask.Priority;
import org.yakindu.sct.simulation.core.sexec.container.EventDrivenSimulationEngine.EventDrivenCycleAdapter;
import org.yakindu.sct.simulation.core.sexec.container.IExecutionContextInitializer;
import org.yakindu.sct.simulation.core.sexec.interpreter.IEventRaiser;
import org.yakindu.sct.simulation.core.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.simulation.core.util.ExecutionContextExtensions;
import org.yakindu.sct.test.models.SCTUnitTestModels;

import com.google.inject.Inject;

/**
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public abstract class AbstractExecutionFlowTest {

	public static final long DEFAULT_CYCLE_PERIOD = 200;
	@Inject
	protected ITimeTaskScheduler timer;
	@Inject
	protected IExecutionFlowInterpreter interpreter;
	@Inject
	protected SCTUnitTestModels models;
	@Inject
	protected ExecutionContext context;
	@Inject
	protected IExecutionContextInitializer initializer;
	@Inject
	protected IExpressionInterpreter stmtInterpreter;
	@Inject
	protected ExecutionContextExtensions contextExtensions;
	@Inject
	protected StatechartAnnotations stateChartAnnotations;

	protected ExecutionFlow flow;

	protected ExecutionContext context() {
		return context;
	}

	protected ExecutionFlow flow() {
		return flow;
	}

	protected void initInterpreter(ExecutionFlow flow) {
		initInterpreter(flow, false);
	}

	protected void initInterpreter(ExecutionFlow flow, boolean useInternalEventQueue) {
		// initializer.initialize(context, flow);
		interpreter.initialize(flow, context, useInternalEventQueue);
		this.flow = flow;
		if (flow.getSourceElement() instanceof Statechart) {
			Statechart statechart = (Statechart) flow.getSourceElement();
			if (stateChartAnnotations.isEventDriven(statechart)) {
				context.eAdapters().add(new EventDrivenCycleAdapter(interpreter));
			} else {
				Long cyclePeriod = getCyclePeriod();
				TimeTask cycleTask = new TimeTask("$cycle", () -> {
					interpreter.runCycle();
				}, Priority.LOW);
				timer.scheduleTimeTask(cycleTask, true, cyclePeriod);
			}
		}
	}

	protected long getInteger(String varName) {
		ExecutionVariable variable = context().getVariable(varName);
		return (Long) variable.getValue();
	}

	protected boolean getBoolean(String varName) {
		ExecutionVariable variable = context().getVariable(varName);
		return (Boolean) variable.getValue();
	}

	protected Double getReal(String varName) {
		ExecutionVariable variable = context().getVariable(varName);
		return (Double) variable.getValue();
	}

	protected String getString(String varName) {
		ExecutionVariable variable = context().getVariable(varName);
		return (String) variable.getValue();
	}

	protected long setInteger(String varName, long v) {
		context().getVariable(varName).setValue((Long) v);
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

	protected boolean isStateActive(String stateName) {
		Assert.isNotNull(stateName);
		List<RegularState> allActiveStates = contextExtensions.getAllActiveStates((context()));
		for (RegularState regularState : allActiveStates) {
			if (stateName.equals(regularState.getName())) {
				return true;
			}
		}
		return false;
	}

	protected void raiseEvent(String eventName) {
		raiseEvent(eventName, null);
	}

	protected void raiseEvent(String eventName, Object value) {
		
		
		if (isEventDriven()) {
			ExecutionEvent event = context().getEvent(eventName);
			event.setValue(value);
			event.setRaised(true);
		} else {
			if (interpreter instanceof IEventRaiser) {
				((IEventRaiser) interpreter).raise(context().getEvent(eventName), value);
			} else {
				context().getEvent(eventName).setValue(value);
				context().getEvent(eventName).setRaised(true);
			}
		}

	}

	protected boolean isRaised(String eventName) {
		return context().getEvent(eventName).isRaised();
	}
	
	protected Object valueOf(String eventName) {
		return context().getEvent(eventName).getValue();
	}

	protected boolean isEventDriven() {
		StatechartAnnotations annotations = new StatechartAnnotations();
		return annotations.isEventDriven((Statechart) this.flow.getSourceElement());
	}

	protected long getCyclePeriod() {
		return stateChartAnnotations.getCyclePeriod((Statechart) flow.getSourceElement());
	}
}

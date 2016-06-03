/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.sct.simulation.core.sexec.container;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.emf.common.util.WrappedException;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ListBasedValidationIssueAcceptor;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.Activator;
import org.yakindu.sct.simulation.core.engine.IExecutionControl;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

import com.google.inject.Inject;

/**
 * Abstract implementation if the {@link ISimulationEngine} interface.
 * transforms a {@link Statechart} to an {@link ExecutionFlow} and holds an
 * {@link ExecutionContext}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractExecutionFlowSimulationEngine implements ISimulationEngine, IExecutionControl {

	public static final int ERROR_DURING_SIMULATION = 765;

	@Inject
	protected ExecutionContext context;
	@Inject
	private IModelSequencer sequencer;
	@Inject
	protected IExecutionFlowInterpreter interpreter;
	@Inject
	private IExecutionContextInitializer contextInitializer;

	protected boolean terminated = false;
	protected boolean suspended = false;

	private Statechart statechart;

	public AbstractExecutionFlowSimulationEngine(Statechart statechart) {
		this.statechart = statechart;
	}

	protected void runCycle() {
		try {
			interpreter.runCycle();
		} catch (Exception e) {
			handleException(e);
		}
	}

	private void handleException(Exception e) {
		if (e instanceof WrappedException) {
			WrappedException e1 = (WrappedException)e;
			handleException(e1.getCause().getMessage(), e1.getCause());
		} else handleException(e.getMessage(), e);
	}
	
	private void handleException(String message, Throwable t) {
		Status errorStatus = new Status(Status.ERROR, Activator.PLUGIN_ID, ERROR_DURING_SIMULATION,
				message, t);
		IStatusHandler statusHandler = DebugPlugin.getDefault().getStatusHandler(errorStatus);
		try {
			statusHandler.handleStatus(errorStatus, getDebugTarget());
			interpreter.suspend();
			interpreter.tearDown();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	protected Object getDebugTarget() {
		IDebugTarget[] debugTargets = DebugPlugin.getDefault().getLaunchManager().getDebugTargets();
		for (IDebugTarget iDebugTarget : debugTargets) {
			if (iDebugTarget.isTerminated())
				continue;
			if (iDebugTarget.getAdapter(ISimulationEngine.class) == this)
				return iDebugTarget;
		}
		return null;
	}

	@Override
	public void init() {
		ListBasedValidationIssueAcceptor acceptor = new ListBasedValidationIssueAcceptor();
		ExecutionFlow flow = sequencer.transform(statechart, acceptor);
		if (acceptor.getTraces(Severity.ERROR).size() > 0) {
			Status errorStatus = new Status(Status.ERROR, Activator.PLUGIN_ID, ERROR_DURING_SIMULATION,
					acceptor.getTraces(Severity.ERROR).iterator().next().toString(), null);
			IStatusHandler statusHandler = DebugPlugin.getDefault().getStatusHandler(errorStatus);
			try {
				statusHandler.handleStatus(errorStatus, getDebugTarget());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		if (!context.isSnapshot()) {
			contextInitializer.initialize(context, flow);
		}
		interpreter.initialize(flow, context);
	}

	public void start() {
		try {
			interpreter.enter();
		} catch (Exception ex) {
			handleException(ex);
		}
	}

	public void suspend() {
		suspended = true;
		interpreter.suspend();
	}

	public void resume() {
		try {
			suspended = false;
			interpreter.resume();
		} catch (Exception ex) {
			handleException(ex);
		}
	}

	public void terminate() {
		terminated = true;
		interpreter.tearDown();
	}

	public void stepForward() {
		try {
			interpreter.resume();
			interpreter.runCycle();
			interpreter.suspend();
		} catch (Exception ex) {
			handleException(ex);
		}
	}

	public void stepBackward() {

	}

	@Override
	public ExecutionContext getExecutionContext() {
		return context;
	}

	public void setExecutionContext(ExecutionContext context) {
		this.context = context;
	}

	@Override
	public IExecutionControl getExecutionControl() {
		return this;
	}

}

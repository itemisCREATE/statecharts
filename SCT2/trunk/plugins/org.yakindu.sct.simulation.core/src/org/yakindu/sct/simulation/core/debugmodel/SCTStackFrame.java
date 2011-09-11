/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.debugmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sgraph.NamedElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.ISGraphExecutionFacade;
import org.yakindu.sct.simulation.core.SGraphSimulationSession;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTStackFrame extends SCTDebugElement implements IStackFrame {

	private final SCTDebugThread thread;
	// the active state that is entered
	private final Vertex state;

	public SCTStackFrame(SCTDebugThread thread, Vertex state,
			String resourceString) {
		super(resourceString);
		this.thread = thread;
		this.state = state;
	}

	public String getModelIdentifier() {
		return IDebugConstants.ID_DEBUG_MODEL;
	}

	public boolean canStepInto() {
		return thread.canStepInto();
	}

	public boolean canStepOver() {
		return thread.canStepOver();
	}

	public boolean canStepReturn() {
		return thread.canStepReturn();
	}

	
	public boolean isStepping() {
		return thread.isStepping();
	}

	
	public void stepInto() throws DebugException {
		thread.stepInto();
	}

	
	public void stepOver() throws DebugException {
		thread.stepOver();
	}

	
	public void stepReturn() throws DebugException {
		thread.stepReturn();
	}

	
	public boolean canResume() {
		return thread.canResume();
	}

	
	public boolean canSuspend() {
		return thread.canSuspend();
	}

	
	public boolean isSuspended() {
		return thread.isSuspended();
	}

	
	public void resume() throws DebugException {
		thread.resume();

	}

	
	public void suspend() throws DebugException {
		thread.suspend();
	}

	
	public boolean canTerminate() {
		return thread.canTerminate();
	}

	
	public boolean isTerminated() {
		return thread.isTerminated();
	}

	
	public void terminate() throws DebugException {
		thread.terminate();
	}

	
	public SCTDebugThread getThread() {
		return thread;
	}

	
	public IVariable[] getVariables() throws DebugException {
		return new IVariable[] {};
	}

	
	public boolean hasVariables() throws DebugException {
		return false;
	}

	
	public int getLineNumber() throws DebugException {
		return -1;
	}

	
	public int getCharStart() throws DebugException {
		return -1;
	}

	
	public int getCharEnd() throws DebugException {
		return -1;
	}

	
	public String getName() throws DebugException {
		List<String> qfnFragments = new ArrayList<String>();
		qfnFragments.add(state.getName());
		EObject current = state;
		while (!(current.eContainer() instanceof Statechart)) {
			current = current.eContainer();
			if (current instanceof NamedElement) {
				String name = ((NamedElement) current).getName();
				if (name != null) {
					qfnFragments.add(name.replaceAll(" ", ""));
				} else {
					qfnFragments.add("<name>");
				}
			}
		}
		Collections.reverse(qfnFragments);
		StringBuilder sb = new StringBuilder();

		sb.append(state.getName());
		sb.append("  (");
		String sep = "";
		for (String s : qfnFragments) {
			sb.append(sep).append(s);
			sep = ".";
		}
		sb.append(")");

		sb.append(" resource: ");
		sb.append(state.eResource().getURI().lastSegment());
		return sb.toString();

	}

	
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return new IRegisterGroup[] {};
	}

	
	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}

	public SCTDebugTarget getDebugTarget() {
		return (SCTDebugTarget) thread.getDebugTarget();
	}

	
	public ILaunch getLaunch() {
		return thread.getLaunch();
	}

	public Vertex getState() {
		return state;
	}

	
	public String getResourceString() {
		return state.eResource().getURI().toPlatformString(true);
	}

	
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == SGraphSimulationSession.class)
			return thread.getAdapter(SGraphSimulationSession.class);
		if (adapter == ISGraphExecutionFacade.class)
			return getDebugTarget().getAdapter(ISGraphExecutionFacade.class);
		return super.getAdapter(adapter);
	}

}

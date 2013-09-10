/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.debugmodel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDebugThread extends SCTDebugElement implements IThread {

	private final Region region;
	private List<SCTStackFrame> stateStack;
	private Vertex lastActiveState;
	private ISimulationEngine container;

	public SCTDebugThread(SCTDebugTarget target, ISimulationEngine container, String resourceString, Region region) {
		super(target, resourceString);
		Assert.isNotNull(region);
		this.container = container;
		this.region = region;
	}

	public int getPriority() throws DebugException {
		return 0;
	}

	public IStackFrame[] getStackFrames() throws DebugException {
		List<RegularState> activeLeafStates = container.getExecutionContext().getActiveStates();
		Vertex activeState = null;
		for (Vertex vertex : activeLeafStates) {
			if (vertex.getParentRegion() == region) {
				activeState = vertex;
				break;
			}
		}

		if (activeState != null && lastActiveState != activeState) {
			lastActiveState = activeState;
			EObject container = activeState;
			stateStack = new ArrayList<SCTStackFrame>();
			while (container != null) {
				if (container instanceof RegularState) {
					stateStack.add(new SCTStackFrame(this, (RegularState) container, getResourceString()));
				}
				container = container.eContainer();
			}
		}
		return stateStack.toArray(new IStackFrame[] {});
	}

	public boolean hasStackFrames() throws DebugException {
		return true;
	}

	public String getName() throws DebugException {
		return fullQfn(region);
	}

	public IBreakpoint[] getBreakpoints() {
		return new IBreakpoint[0];
	}

	public boolean canResume() {
		return getDebugTarget().canResume();
	}

	public boolean canSuspend() {
		return getDebugTarget().canSuspend();
	}

	public boolean isSuspended() {
		return getDebugTarget().isSuspended();
	}

	public void resume() throws DebugException {
		getDebugTarget().resume();
	}

	public void suspend() throws DebugException {
		getDebugTarget().suspend();
	}

	public boolean canStepInto() {
		return false;
	}

	public boolean canStepOver() {
		return getDebugTarget().canStepOver();
	}

	public boolean canStepReturn() {
		return false;
	}

	public boolean isStepping() {
		return getDebugTarget().isStepping();
	}

	public void stepInto() throws DebugException {
	}

	public void stepOver() throws DebugException {
		getDebugTarget().stepOver();
	}

	public void stepReturn() throws DebugException {
	}

	public boolean canTerminate() {
		return getDebugTarget().canTerminate();
	}

	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	public void terminate() throws DebugException {
		getDebugTarget().terminate();
	}

	public IStackFrame getTopStackFrame() throws DebugException {
		return null;
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if(adapter == ISimulationEngine.class)
			return container;
		if (adapter == EObject.class)
			return region;
		return super.getAdapter(adapter);
	}

	public SCTDebugTarget getDebugTarget() {
		return (SCTDebugTarget) super.getDebugTarget();
	}

	public Region getRegion() {
		return region;
	}

}

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
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.engine.IExecutionControl;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDebugTarget extends SCTDebugElement implements IDebugTarget {

	private ILaunch launch;

	private boolean stepping = false;
	private boolean terminated = false;
	private boolean suspended = false;

	private final Statechart statechart;
	private List<SCTDebugThread> threads;

	private ISimulationEngine container;

	private IExecutionControl executionControl;

	public SCTDebugTarget(ILaunch launch, Statechart statechart, ISimulationEngine container) throws CoreException {
		super(null, statechart.eResource().getURI().toPlatformString(true));
		Assert.isNotNull(statechart);
		this.launch = launch;
		this.statechart = statechart;
		this.container = container;
		init();
	}

	private void init() {
		threads = new ArrayList<SCTDebugThread>();
		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
		executionControl = container.getExecutionControl();
		executionControl.start();
	}

	public IProcess getProcess() {
		return null;
	}

	public void stepOver() {
		fireEvent(new DebugEvent(getDebugTarget(), DebugEvent.STEP_OVER));
		container.getExecutionControl().stepForward();
	}

	public IThread[] getThreads() throws DebugException {
		// Collect all active regions
		List<RegularState> activeLeafStates = container.getExecutionContext().getActiveStates();
		List<Region> activeRegions = new ArrayList<Region>();
		for (RegularState vertex : activeLeafStates) {
			activeRegions.add(vertex.getParentRegion());
		}
		// Remove orphaned debug threads
		Iterator<SCTDebugThread> iterator = threads.iterator();
		while (iterator.hasNext()) {
			SCTDebugThread next = iterator.next();
			if (!activeRegions.contains(next.getRegion())) {
				iterator.remove();
			}
		}
		// Add new debug threads
		for (Region region : activeRegions) {
			boolean found = false;
			for (SCTDebugThread thread : threads) {
				if (thread.getRegion() == region) {
					found = true;
				}
			}
			if (!found) {
				threads.add(new SCTDebugThread(this, container, getResourceString(), region));
			}
		}
		return threads.toArray(new IThread[] {});
	}

	public boolean hasThreads() throws DebugException {
		return true;
	}

	public String getName() throws DebugException {
		return statechart.getName();
	}

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return true;
	}

	public boolean canTerminate() {
		return !terminated;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() throws DebugException {
		fireEvent(new DebugEvent(getDebugTarget(), DebugEvent.TERMINATE));
		terminated = true;
		executionControl.terminate();
	}

	public boolean canResume() {
		return suspended && !terminated;
	}

	public boolean canSuspend() {
		return !suspended && !terminated;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void resume() throws DebugException {
		fireEvent(new DebugEvent(this, DebugEvent.RESUME));
		fireChangeEvent(DebugEvent.CONTENT);
		suspended = false;
		executionControl.resume();
	}

	public void suspend() throws DebugException {
		fireEvent(new DebugEvent(this, DebugEvent.SUSPEND));
		fireChangeEvent(DebugEvent.CONTENT);
		suspended = true;
		executionControl.suspend();
	}

	public void breakpointAdded(IBreakpoint breakpoint) {
	}

	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
	}

	public boolean canDisconnect() {
		return false;
	}

	public void disconnect() throws DebugException {

	}

	public boolean isDisconnected() {
		return false;
	}

	public boolean supportsStorageRetrieval() {
		return false;
	}

	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return null;
	}

	public ILaunch getLaunch() {
		return launch;
	}

	public IDebugTarget getDebugTarget() {
		return this;
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == ISimulationEngine.class)
			return container;
		if (adapter == IExecutionControl.class) {
			return container.getExecutionControl();
		}
		if (adapter == ExecutionContext.class) {
			return container.getExecutionContext();
		}
		if (adapter == EObject.class) {
			return statechart;
		}
		return super.getAdapter(adapter);
	}

	public boolean canStepOver() {
		return isSuspended() && !isTerminated();
	}

	public boolean isStepping() {
		return stepping;
	}
}

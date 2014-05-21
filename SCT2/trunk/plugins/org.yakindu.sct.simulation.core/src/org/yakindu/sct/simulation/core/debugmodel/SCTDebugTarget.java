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
import org.eclipse.debug.core.model.IStep;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.simulation.core.engine.IExecutionControl;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.SRuntimePackage;
import org.yakindu.sct.simulation.core.sruntime.util.CrossDocumentContentAdapter;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - extensions
 * 
 */
public class SCTDebugTarget extends SCTDebugElement implements IDebugTarget, IStep {

	private ILaunch launch;

	private boolean stepping = false;
	private boolean terminated = false;
	private boolean suspended = false;

	private final NamedElement element;
	protected List<SCTDebugThread> threads;

	protected ISimulationEngine engine;

	private IExecutionControl executionControl;

	private AdapterImpl updater;

	public SCTDebugTarget(ILaunch launch, NamedElement element, ISimulationEngine engine) throws CoreException {
		super(null, element.eResource().getURI().toPlatformString(true));
		Assert.isNotNull(element);
		this.launch = launch;
		this.element = element;
		this.engine = engine;
	}

	public void init() {
		threads = new ArrayList<SCTDebugThread>();
		executionControl = engine.getExecutionControl();
		executionControl.init();
		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
		engine.getExecutionContext().eAdapters().add(updater = createUpdater());
	}

	protected AdapterImpl createUpdater() {
		return new UpdateTreeAdapter();
	}

	public void start() {
		executionControl.start();
	}

	public IProcess getProcess() {
		return null;
	}

	public void stepOver() {
		fireEvent(new DebugEvent(getDebugTarget(), DebugEvent.STEP_OVER));
		engine.getExecutionControl().stepForward();
	}

	public IThread[] getThreads() throws DebugException {
		// Collect all active regions
		List<RegularState> activeLeafStates = engine.getExecutionContext().getActiveStates();
		List<Region> activeRegions = new ArrayList<Region>();
		for (RegularState vertex : activeLeafStates) {
			activeRegions.add(vertex.getParentRegion());
		}
		// Remove orphaned debug threads
		Iterator<SCTDebugThread> iterator = threads.iterator();
		while (iterator.hasNext()) {
			SCTDebugThread next = iterator.next();
			if (!activeRegions.contains(next.getElement())) {
				iterator.remove();
			}
		}
		// Add new debug threads
		for (Region region : activeRegions) {
			boolean found = false;
			for (SCTDebugThread thread : threads) {
				if (thread.getElement() == region) {
					found = true;
				}
			}
			if (!found) {
				threads.add(new SCTDebugThread(this, engine, getResourceString(), region));
			}
		}
		return threads.toArray(new IThread[] {});
	}

	public boolean hasThreads() throws DebugException {
		return true;
	}

	public String getName() throws DebugException {
		return element.getName();
	}

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return breakpoint.getModelIdentifier().startsWith("com.yakindu.sct.simulation");
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
		engine.getExecutionContext().eAdapters().remove(updater);
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
			return engine;
		if (adapter == IExecutionControl.class) {
			return engine.getExecutionControl();
		}
		if (adapter == ExecutionContext.class) {
			return engine.getExecutionContext();
		}
		if (adapter == EObject.class) {
			return element;
		}
		return super.getAdapter(adapter);
	}

	public boolean canStepOver() {
		return isSuspended() && !isTerminated();
	}

	public boolean isStepping() {
		return stepping;
	}

	public ISimulationEngine getSimulationEngine() {
		return engine;
	}

	// Fires fireChangeEvents to refresh the DebugUI TreeViewer with the active
	// states
	public class UpdateTreeAdapter extends CrossDocumentContentAdapter {

		@Override
		protected boolean shouldAdapt(EStructuralFeature feature) {
			return feature == SRuntimePackage.Literals.EXECUTION_CONTEXT__ACTIVE_STATES;
		}

		@Override
		public void notifyChanged(Notification notification) {
			if (notification.getFeature() == SRuntimePackage.Literals.EXECUTION_CONTEXT__ACTIVE_STATES) {
				fireChangeEvent(DebugEvent.CONTENT);
			}
			super.notifyChanged(notification);
		}
	}

	public boolean canStepInto() {
		// Not used
		return false;
	}

	public boolean canStepReturn() {
		// Not used
		return false;
	}

	public void stepInto() throws DebugException {

	}

	public void stepReturn() throws DebugException {

	}

}

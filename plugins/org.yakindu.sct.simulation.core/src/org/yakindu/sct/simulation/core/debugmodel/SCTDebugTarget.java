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
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.engine.IExecutionControl;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;

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
	private String name;
	protected ISimulationEngine engine;
	private IExecutionControl executionControl;
	private AdapterImpl updater;

	public SCTDebugTarget(ILaunch launch, NamedElement element, ISimulationEngine engine) throws CoreException {
		this(launch, element,element.getName(), engine);
	}
	
	public SCTDebugTarget(ILaunch launch, NamedElement element, String name, ISimulationEngine engine) throws CoreException {
		super(null, element.eResource().getURI().toPlatformString(true));
		Assert.isNotNull(element);
		this.launch = launch;
		this.element = element;
		this.engine = engine;
		this.name = name;
	}

	public void init() {
		executionControl = engine.getExecutionControl();
		executionControl.init();
		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
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

	public synchronized IThread[] getThreads() throws DebugException {
		return new IThread[] {};
	}

	public boolean hasThreads() throws DebugException {
		return false;
	}

	public String getName() throws DebugException {
		return name;
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
		if(engine.getExecutionContext() != null)
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

	@SuppressWarnings("unchecked")
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

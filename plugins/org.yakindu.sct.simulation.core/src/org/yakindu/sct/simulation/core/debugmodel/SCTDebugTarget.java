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
import java.util.Set;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.yakindu.sct.commons.WorkspaceClassLoaderFactory;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.extensions.ExecutionFactoryExtensions;
import org.yakindu.sct.simulation.core.extensions.ExecutionFactoryExtensions.ExecutionFactoryDescriptor;
import org.yakindu.sct.simulation.core.launch.IStatechartLaunchParameters;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacadeController;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacadeFactory;
import org.yakindu.sct.simulation.core.runtime.IExecutionTraceListener;
import org.yakindu.sct.simulation.core.runtime.impl.CycleBasedExecutionFacadeController;
import org.yakindu.sct.simulation.core.runtime.impl.EventDrivenExecutionFacadeController;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDebugTarget extends SCTDebugElement implements IDebugTarget,
		IStatechartLaunchParameters, IExecutionTraceListener {

	private ILaunch launch;

	protected IExecutionFacade facade;

	private boolean stepping = false;
	private boolean terminated = false;
	private boolean suspended = false;

	private final Statechart statechart;

	private List<SCTDebugThread> threads;

	private IExecutionFacadeController controller;

	public SCTDebugTarget(ILaunch launch, Statechart statechart)
			throws CoreException {
		super(null, statechart.eResource().getURI().toPlatformString(true));
		this.launch = launch;
		this.statechart = statechart;
		threads = new ArrayList<SCTDebugThread>();
		DebugPlugin.getDefault().getBreakpointManager()
				.addBreakpointListener(this);
		createExecutionModel(statechart);
	}

	private void createExecutionModel(Statechart statechart)
			throws CoreException {
		IExecutionFacadeFactory factory = getExecutionFacadeFactory(statechart);
		facade = factory.createExecutionFacade(statechart);
		facade.addTraceListener(this);
		initFacadeCallbacks(WorkspaceSynchronizer.getFile(
				statechart.eResource()).getProject());
		initFacadeController();
	}

	private void initFacadeCallbacks(IProject project) {
		ClassLoader classLoader = new WorkspaceClassLoaderFactory()
				.createClassLoader(project);
		ILaunchConfiguration config = launch.getLaunchConfiguration();
		try {
			String clazz = config.getAttribute(OPERATION_CLASS, "");
			if (clazz != null && clazz.trim().length() > 0) {
				Class<?> loadClass = classLoader.loadClass(clazz);
				facade.addCallbackObject(loadClass.newInstance());
			}
		} catch (CoreException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private void initFacadeController() throws CoreException {
		boolean isCycleBased = launch.getLaunchConfiguration().getAttribute(
				IS_CYCLE_BASED, DEFAULT_IS_CYCLE_BASED);
		if (isCycleBased) {
			long cyclePeriod = launch.getLaunchConfiguration().getAttribute(
					CYCLE_PERIOD, DEFAULT_CYCLE_PERIOD);
			controller = new CycleBasedExecutionFacadeController(facade,
					cyclePeriod);
		} else {
			controller = new EventDrivenExecutionFacadeController(facade);
		}
		controller.start();
	}

	protected IExecutionFacadeFactory getExecutionFacadeFactory(Statechart sc) {
		Iterable<ExecutionFactoryDescriptor> executionFactoryDescriptor = ExecutionFactoryExtensions
				.getExecutionFactoryDescriptor();

		for (ExecutionFactoryDescriptor desc : executionFactoryDescriptor) {
			IExecutionFacadeFactory f = desc.createExecutableExtensionFactory();
			if (f.isApplicable(sc))
				return f;
		}
		return null;
	}

	public IProcess getProcess() {
		return null;
	}

	public void stepOver() {
		fireEvent(new DebugEvent(getDebugTarget(), DebugEvent.STEP_OVER));
	}

	public IThread[] getThreads() throws DebugException {
		// Collect all active regions
		Set<RegularState> activeLeafStates = facade.getExecutionContext()
				.getActiveLeafStates();
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
				threads.add(new SCTDebugThread(this, facade,
						getResourceString(), region));
			}
		}
		return threads.toArray(new IThread[] {});
	}

	public boolean hasThreads() throws DebugException {
		return true;
	}

	public String getName() throws DebugException {
		return facade.getName();
	}

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return false;
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
		facade.removeTraceListener(this);
		controller.terminate();
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
		controller.resume();
	}

	public void suspend() throws DebugException {
		fireEvent(new DebugEvent(this, DebugEvent.SUSPEND));
		fireChangeEvent(DebugEvent.CONTENT);
		suspended = true;
		controller.suspend();
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

	public IMemoryBlock getMemoryBlock(long startAddress, long length)
			throws DebugException {
		return null;
	}

	public ILaunch getLaunch() {
		return launch;
	}

	public IDebugTarget getDebugTarget() {
		return this;
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		if (adapter == IExecutionFacade.class)
			return facade;
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

	public void traceStepExecuted(Trace trace) {
		if (trace instanceof TraceStateEntered
				|| trace instanceof TraceStateExited)
			fireChangeEvent(DebugEvent.CONTENT);
	}

	public Statechart getStatechart() {
		return statechart;
	}

}

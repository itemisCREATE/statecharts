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
package org.yakindu.sct.simulation.core.hmr;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchListener;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugElement;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.util.ResourceUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTHotModelReplacementManager implements IResourceChangeListener, IResourceDeltaVisitor, ILaunchListener,
		IDebugEventSetListener {

	public static final SCTHotModelReplacementManager INSTANCE = new SCTHotModelReplacementManager();

	private List<IDebugTarget> activeTargets;

	private List<IHotModelReplacementListener> listeners;

	private SCTHotModelReplacementManager() {
		activeTargets = new ArrayList<IDebugTarget>();
		listeners = new ArrayList<IHotModelReplacementListener>();
	}

	public synchronized void addReplacementListener(IHotModelReplacementListener listener) {
		listeners.add(listener);
	}

	public synchronized void removeReplacementListener(IHotModelReplacementListener listener) {
		listeners.remove(listener);
	}

	public void startup() {
		DebugPlugin.getDefault().addDebugEventListener(this);
		DebugPlugin.getDefault().getLaunchManager().addLaunchListener(this);
	}

	public void tearDown() {
		DebugPlugin.getDefault().removeDebugEventListener(this);
		DebugPlugin.getDefault().getLaunchManager().removeLaunchListener(this);
	}

	public void handleDebugEvents(DebugEvent[] events) {
		for (DebugEvent debugEvent : events) {
			if (debugEvent.getKind() == DebugEvent.TERMINATE) {
				Object source = debugEvent.getSource();
				if (source instanceof IAdaptable) {
					Object adapter = ((IAdaptable) source).getAdapter(IDebugTarget.class);
					if (adapter instanceof SCTDebugTarget) {
						unregisterSCTTarget((SCTDebugTarget) adapter);
					}
				}
			}
		}
	}

	public void launchRemoved(ILaunch launch) {
		IDebugTarget[] debugTargets = launch.getDebugTargets();
		for (IDebugTarget debugTarget : debugTargets) {
			if (debugTarget instanceof SCTDebugTarget) {
				unregisterSCTTarget((SCTDebugTarget) debugTarget);
			}
		}
	}

	public void launchAdded(ILaunch launch) {
		IDebugTarget[] debugTargets = launch.getDebugTargets();
		for (IDebugTarget debugTarget : debugTargets) {
			if (debugTarget instanceof SCTDebugTarget) {
				registerSCTTarget((SCTDebugTarget) debugTarget);
			}
		}
	}

	protected void registerSCTTarget(SCTDebugTarget target) {
		synchronized (this) {
			// start listening to resource changes if an SCtDebugTarget is
			// active
			if (activeTargets.isEmpty()) {
				ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
			}
			if (!activeTargets.contains(target))
				activeTargets.add(target);
		}
	}

	protected void unregisterSCTTarget(SCTDebugTarget target) {
		synchronized (this) {
			if (activeTargets.contains(target)) {
				activeTargets.remove((SCTDebugTarget) target);
			}
			// Stop listening to resource changes if no SCTDebugTarget is active
			if (activeTargets.isEmpty()) {
				ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
			}
		}
	}

	public void launchChanged(ILaunch launch) {
		launchAdded(launch);
	}

	private List<IFile> changedFiles = new ArrayList<IFile>();

	public synchronized void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.PRE_CLOSE)
			handleCloseEvent(event);

		IResourceDelta delta = event.getDelta();
		try {
			changedFiles.clear();
			if (delta != null)
				delta.accept(this);
			if (changedFiles.size() > 0) {
				handleHotModelReplacement();
			}

		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	private void handleCloseEvent(IResourceChangeEvent event) {
		if (event.getResource() instanceof IProject) {
			IProject project = ((IProject) event.getResource());
			for (IDebugTarget target : activeTargets) {
				EObject object = (EObject) target.getAdapter(EObject.class);
				IFile file = WorkspaceSynchronizer.getFile(object.eResource());
				if (project.equals(file.getProject())) {
					try {
						target.terminate();
					} catch (DebugException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private void handleHotModelReplacement() {
		// first implementation: If the underlying model does not change
		// semantically, no notification is required...

		List<IDebugTarget> targets = getAffectedTargets();
		List<IDebugTarget> modelReplacementFailedTargets = new ArrayList<IDebugTarget>();
		for (IDebugTarget sctDebugTarget : targets) {
			// Reload the Statechart form the changes resource
			Statechart newStatechart = ResourceUtil.loadStatechart(((SCTDebugElement) sctDebugTarget)
					.getResourceString());
			if (!EcoreUtil.equals(newStatechart, (EObject) sctDebugTarget.getAdapter(EObject.class))) {
				// The model semantically changed, we have to create a
				// notificiation for that....
				modelReplacementFailedTargets.add(sctDebugTarget);
			}
		}

		if (modelReplacementFailedTargets.size() > 0) {
			notifyHotModelReplacementFailed(targets);
		}

	}

	protected void notifyHotModelReplacementFailed(List<IDebugTarget> affectedTargets) {
		synchronized (listeners) {
			for (IHotModelReplacementListener listener : listeners) {
				listener.hotCodeReplaceFailed(affectedTargets);
			}
		}
	}

	private List<IDebugTarget> getAffectedTargets() {
		List<IDebugTarget> targets = new ArrayList<IDebugTarget>();
		synchronized (activeTargets) {
			for (IDebugTarget debugTarget : activeTargets) {
				if (debugTarget instanceof SCTDebugTarget) {
					String resourceString = ((SCTDebugElement) debugTarget).getResourceString();
					IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(resourceString);
					if (changedFiles.contains(resource)) {
						targets.add(debugTarget);
					}
				}
			}
		}
		return targets;

	}

	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if ((delta.getFlags() & IResourceDelta.CONTENT) != 0) {
			if (resource.getType() == IResource.FILE) {
				IFile file = (IFile) resource;
				changedFiles.add(file);
			}
		}
		return true;
	}

}

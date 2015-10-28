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
package org.yakindu.sct.simulation.ui.model.presenter;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.sourcelookup.ISourceDisplay;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.ui.editor.partitioning.DiagramEditorInput;

/**
 * Creates a {@link SCTSourceDisplay} for each {@link IDebugTarget} and
 * registeres itself as a {@link IDebugEventSetListener}. Terminate events are
 * deleged to the coresponding {@link IDebugTarget}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTSourceDisplayDispatcher implements ISourceDisplay, IDebugEventSetListener, IPartListener {

	private Map<IDebugTarget, SCTSourceDisplay> target2Display;
	private SCTSourceDisplay activeSourceDisplay;
	private DebugElement activeDebugTarget;

	public SCTSourceDisplayDispatcher() {
		target2Display = new HashMap<IDebugTarget, SCTSourceDisplay>();
		DebugPlugin.getDefault().addDebugEventListener(this);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(this);
	}

	public void displaySource(Object element, IWorkbenchPage page, boolean forceSourceLookup) {
		activeDebugTarget = (DebugElement) element;
		if (activeDebugTarget.getDebugTarget().isTerminated())
			return;
		activeSourceDisplay = target2Display.get(activeDebugTarget.getDebugTarget());
		if (activeSourceDisplay == null) {
			activeSourceDisplay = new SCTSourceDisplay(
					(ISimulationEngine) activeDebugTarget.getAdapter(ISimulationEngine.class));
			target2Display.put(activeDebugTarget.getDebugTarget(), activeSourceDisplay);
		}
		activeSourceDisplay.displaySource(activeDebugTarget, page, forceSourceLookup);
	}

	public void handleDebugEvents(DebugEvent[] events) {
		for (DebugEvent debugEvent : events) {
			handleDebugEvent(debugEvent);
		}
	}

	protected void handleDebugEvent(DebugEvent debugEvent) {
		switch (debugEvent.getKind()) {
		case DebugEvent.TERMINATE:
			handleDebugTargetTerminated(debugEvent);
			break;
		}
	}

	protected void handleDebugTargetTerminated(DebugEvent debugEvent) {
		Object source = debugEvent.getSource();
		if (source instanceof IDebugTarget) {
			IDebugTarget target = (IDebugTarget) source;
			SCTSourceDisplay sourceDisplay = target2Display.get(target);
			if (sourceDisplay != null) {
				sourceDisplay.terminate();
				target2Display.remove(sourceDisplay);
			}
		}
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		highlightState(part);
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
		highlightState(part);
	}

	protected void highlightState(IWorkbenchPart part) {
		if (part instanceof DiagramEditor) {
			IEditorInput editorInput = ((DiagramEditor) part).getEditorInput();
			if (editorInput instanceof DiagramEditorInput) {
				if (activeSourceDisplay != null && activeDebugTarget != null) {
					activeSourceDisplay.displaySource((IEditorPart) part);
				}
			}
		}
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		// Nothing to do
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
		// Nothing to do
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
		//Nothing to do
	}

}

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
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.sourcelookup.ISourceDisplay;
import org.eclipse.ui.IWorkbenchPage;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugElement;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;

/**
 * Creates a {@link SCTSourceDisplay} for each {@link SCTDebugTarget} and
 * registeres itself as a {@link IDebugEventSetListener}. Terminate events are
 * deleged to the coresponding {@link SCTDebugTarget}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTSourceDisplayDispatcher implements ISourceDisplay, IDebugEventSetListener {

	private Map<IDebugTarget, SCTSourceDisplay> target2Display;

	public SCTSourceDisplayDispatcher() {
		target2Display = new HashMap<IDebugTarget, SCTSourceDisplay>();
		DebugPlugin.getDefault().addDebugEventListener(this);
	}

	public void displaySource(Object element, IWorkbenchPage page, boolean forceSourceLookup) {
		SCTDebugElement debugElement = (SCTDebugElement) element;
		if (debugElement.getDebugTarget().isTerminated())
			return;
		SCTSourceDisplay sourceDisplay = target2Display.get(debugElement.getDebugTarget());
		if (sourceDisplay == null) {
			sourceDisplay = new SCTSourceDisplay((IExecutionFacade) debugElement.getAdapter(IExecutionFacade.class));
			target2Display.put(debugElement.getDebugTarget(), sourceDisplay);
		}
		sourceDisplay.displaySource(debugElement, page, forceSourceLookup);
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
		if (source instanceof SCTDebugTarget) {
			SCTDebugTarget target = (SCTDebugTarget) source;
			SCTSourceDisplay sourceDisplay = target2Display.get(target);
			if (sourceDisplay != null) {
				sourceDisplay.terminate();
				target2Display.remove(sourceDisplay);
			}
		}
	}
}

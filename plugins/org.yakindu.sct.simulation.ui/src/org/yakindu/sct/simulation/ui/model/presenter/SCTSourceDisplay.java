/**
 * Copyright (c) 2020 committers of YAKINDU and others.
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

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.sourcelookup.ISourceDisplay;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.yakindu.base.gmf.runtime.highlighting.IHighlightingSupport;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.partitioning.SubmachineEditorInput;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTSourceDisplay implements ISourceDisplay, IDebugEventSetListener, IPartListener {

	private Map<IEditorInput, IDynamicNotationHandler> handler = null;
	private ILaunch activeLaunch;

	public SCTSourceDisplay() {
		handler = new HashMap<IEditorInput, IDynamicNotationHandler>();
	}

	@Override
	public void displaySource(Object element, IWorkbenchPage page, boolean forceSourceLookup) {
		IDebugTarget debugTarget = unwrapTarget(element);
		if (debugTarget == null)
			return;
		setActiveLaunch(debugTarget);
		IEditorPart editorPart = openEditor(debugTarget, page);
		IDynamicNotationHandler notationHandler = getHandler(editorPart);
		notationHandler.display(debugTarget.getAdapter(ExecutionContext.class));

	}

	private void setActiveLaunch(IDebugTarget debugTarget) {
		ILaunch currentLaunch = debugTarget.getLaunch();
		if (activeLaunch != currentLaunch) {
			for (IDynamicNotationHandler current : handler.values()) {
				current.terminate();
			}
			handler.clear();
			activeLaunch = currentLaunch;
		}
	}

	protected IDynamicNotationHandler getHandler(IEditorPart editorPart) {
		IDynamicNotationHandler notationHandler = handler.get(editorPart.getEditorInput());
		if (notationHandler == null) {
			notationHandler = new DefaultDynamicNotationHandler();
			IHighlightingSupport support = editorPart.getAdapter(IHighlightingSupport.class);
			if (support != null) {
				notationHandler.setHighlightingSupport(support);
			}
			if (support.isLocked()) {
				support.releaseEditor();
			}
			support.lockEditor();
			handler.put(editorPart.getEditorInput(), notationHandler);
		}
		return notationHandler;
	}

	protected IDebugTarget unwrapTarget(Object element) {
		if (element instanceof ILaunch) {
			return ((ILaunch) element).getDebugTarget();
		}
		if (element instanceof PlatformObject) {
			return ((PlatformObject) element).getAdapter(IDebugTarget.class);
		}
		return null;
	}

	public IEditorPart openEditor(IDebugTarget debugTarget, IWorkbenchPage page) {
		ExecutionContext context = debugTarget.getAdapter(ExecutionContext.class);
		EObject semanticObject = (EObject) debugTarget.getAdapter(EObject.class);
		Diagram diagram = DiagramPartitioningUtil.getDiagramContaining(semanticObject);
		diagram = (Diagram) DiagramPartitioningUtil.getSharedDomain().getResourceSet()
				.getEObject(EcoreUtil.getURI(diagram), true);
		if (context.getContextFqn() != null) {
			return DiagramPartitioningUtil.openSubmachineEditor((Diagram) diagram, context.getContextFqn());
		} else {
			return DiagramPartitioningUtil.openEditor((Diagram) diagram);
		}
	}

	@Override
	public void handleDebugEvents(DebugEvent[] events) {
		for (DebugEvent event : events) {
			if (event.getKind() == DebugEvent.TERMINATE) {
				handleDebugTargetTerminated(event);
			}
		}
	}

	protected void handleDebugTargetTerminated(DebugEvent debugEvent) {
		Object source = debugEvent.getSource();
		if (source instanceof IDebugTarget) {
			IDebugTarget target = (IDebugTarget) source;
			if (activeLaunch == target.getLaunch()) {
				for (IDynamicNotationHandler current : handler.values()) {
					current.terminate();
				}
				activeLaunch = null;
				handler.clear();
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
		if (activeLaunch == null)
			return;
		if (part instanceof DiagramEditor) {
			IEditorInput editorInput = ((DiagramEditor) part).getEditorInput();
			// Only highlight top level Statechart on open, not clear which session
			// otherwise
			if (!(editorInput instanceof SubmachineEditorInput)) {
				IDynamicNotationHandler notationHandler = getHandler((IEditorPart) part);
				notationHandler.display(activeLaunch.getDebugTarget().getAdapter(ExecutionContext.class));
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
		// Nothing to do
	}

}
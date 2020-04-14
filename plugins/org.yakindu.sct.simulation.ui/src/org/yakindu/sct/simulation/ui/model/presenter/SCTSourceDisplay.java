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
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.yakindu.base.gmf.runtime.highlighting.IHighlightingSupport;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.partitioning.SubmachineEditorInput;

import com.google.common.collect.Lists;

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
	public synchronized void displaySource(Object element, IWorkbenchPage page, boolean forceSourceLookup) {
		IDebugTarget debugTarget = unwrapTarget(element);
		if (debugTarget == null || getDiagram(debugTarget) == null)
			return;
		setActiveLaunch(debugTarget);
		IEditorPart editorPart = openEditor(debugTarget, page);
		IDynamicNotationHandler notationHandler = getHandler(editorPart);
		notationHandler.display(debugTarget.getAdapter(ExecutionContext.class));
		restoreActiveEditors();

	}

	protected void setActiveLaunch(IDebugTarget debugTarget) {
		ILaunch currentLaunch = debugTarget.getLaunch();
		if (activeLaunch != currentLaunch) {
			for (IDynamicNotationHandler current : handler.values()) {
				current.terminate();
			}
			handler.clear();
			activeLaunch = currentLaunch;
		}
	}

	// Restores session for all open submachine editors
	protected void restoreActiveEditors() {
		List<DiagramEditor> editors = getAllOpenSubmachineEditors();
		for (DiagramEditor diagramEditor : editors) {
			Optional<ExecutionContext> contextOptional = findExecutionContext(diagramEditor);
			if (contextOptional.isPresent()) {
				IDynamicNotationHandler notationHandler = getHandler(diagramEditor);
				notationHandler.display(contextOptional.get());
			}
		}
	}

	protected Optional<ExecutionContext> findExecutionContext(DiagramEditor editor) {
		IDebugTarget[] debugTargets = activeLaunch.getDebugTargets();
		for (IDebugTarget debugTarget : debugTargets) {
			ExecutionContext context = debugTarget.getAdapter(ExecutionContext.class);
			Diagram diagram = getDiagram(debugTarget);
			if (context.getContextFqn() != null) {
				if (new SubmachineEditorInput(diagram, context.getContextFqn()).equals(editor.getEditorInput())) {
					return Optional.of(context);
				}
			}
		}
		return Optional.empty();
	}

	protected Diagram getDiagram(IDebugTarget debugTarget) {
		EObject semanticObject = (EObject) debugTarget.getAdapter(EObject.class);
		Diagram diagram = DiagramPartitioningUtil.getDiagramContaining(semanticObject);
		if (diagram == null) 
			return null;
		
		return (Diagram) DiagramPartitioningUtil.getSharedDomain().getResourceSet()
				.getEObject(EcoreUtil.getURI(diagram), true);
	}

	protected List<DiagramEditor> getAllOpenSubmachineEditors() {
		List<DiagramEditor> result = Lists.newArrayList();
		IEditorReference[] editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getEditorReferences();
		for (IEditorReference iEditorReference : editorReferences) {
			IEditorPart editor = iEditorReference.getEditor(false);
			if (editor instanceof DiagramEditor) {
				IEditorInput editorInput = editor.getEditorInput();
				if (editorInput instanceof SubmachineEditorInput) {
					result.add((DiagramEditor) editor);
				}
			}
		}
		return result;
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

	protected IEditorPart openEditor(IDebugTarget debugTarget, IWorkbenchPage page) {
		ExecutionContext context = debugTarget.getAdapter(ExecutionContext.class);
		Diagram diagram = getDiagram(debugTarget);
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
				activeLaunch = null;
				for (IDynamicNotationHandler current : handler.values()) {
					current.terminate();
				}
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
		if (part instanceof DiagramEditor) {
			IEditorInput input = ((DiagramEditor) part).getEditorInput();
			IDynamicNotationHandler notationHandler = handler.get(input);
			if (notationHandler != null) {
				notationHandler.terminate();
				handler.remove(input);
			}
		}
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
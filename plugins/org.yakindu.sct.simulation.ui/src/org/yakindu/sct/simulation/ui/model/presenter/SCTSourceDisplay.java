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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.ui.sourcelookup.ISourceDisplay;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugElement;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;
import de.itemis.gmf.runtime.commons.util.EditPartUtils;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTSourceDisplay implements ISourceDisplay, IDebugEventSetListener {

	private DiagramDocumentEditor prevEditor;
	private SCTDebugTarget lastActiveTarget;
	private Map<IExecutionFacade, IDynamicNotationHandler> _handler;

	public SCTSourceDisplay() {
		_handler = new HashMap<IExecutionFacade, IDynamicNotationHandler>();
		DebugPlugin.getDefault().addDebugEventListener(this);
	}

	public void displaySource(Object element, IWorkbenchPage page,
			boolean forceSourceLookup) {
		SCTDebugElement debugElement = (SCTDebugElement) element;
		if (debugElement.getDebugTarget().isTerminated())
			return;
		DiagramDocumentEditor editor = openEditorAndSelectElements(
				debugElement, page);
		if (debugElement.getDebugTarget() == lastActiveTarget
				&& prevEditor == editor) {
			return;
		}
		prevEditor = editor;
		lastActiveTarget = (SCTDebugTarget) debugElement.getDebugTarget();

		IExecutionFacade facade = (IExecutionFacade) debugElement
				.getAdapter(IExecutionFacade.class);
		IDynamicNotationHandler handler = _handler.get(facade);
		if (handler == null) {
			handler = createNotationHandler(facade);

		}
		IHighlightingSupport support = (IHighlightingSupport) editor
				.getAdapter(IHighlightingSupport.class);
		handler.setHighlightingSupport(support);
		if (support.isLocked())
			support.releaseEditor();
		support.lockEditor();
		handler.restoreNotationState(facade.getExecutionContext());
	}

	private IDynamicNotationHandler createNotationHandler(
			IExecutionFacade facade) {
		IDynamicNotationHandler handler = new DefaultDynamicNotationHandler();
		facade.addTraceListener(handler);
		_handler.put(facade, handler);
		return handler;
	}

	public void handleDebugEvents(DebugEvent[] events) {
		for (DebugEvent debugEvent : events) {
			handleDebugEvent(debugEvent);
		}
	}

	private void handleDebugEvent(DebugEvent debugEvent) {
		switch (debugEvent.getKind()) {
		case DebugEvent.TERMINATE:
			handleDebugTargetTerminated(debugEvent);
			break;
		}
	}

	private void handleDebugTargetTerminated(DebugEvent debugEvent) {
		Object source = debugEvent.getSource();
		if (source instanceof SCTDebugTarget) {
			SCTDebugTarget target = (SCTDebugTarget) source;
			IExecutionFacade facade = (IExecutionFacade) target
					.getAdapter(IExecutionFacade.class);
			if (_handler.containsKey(facade)) {
				IDynamicNotationHandler handler = _handler.get(facade);
				handler.getHighlightingSupport().releaseEditor();
				facade.removeTraceListener(handler);
				System.out.println("Removing handler");
				_handler.remove(facade);
			}
		}
	}

	private DiagramDocumentEditor openEditorAndSelectElements(
			SCTDebugElement debugElement, IWorkbenchPage page) {
		String platformString = debugElement.getResourceString();
		IResource resource = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(platformString);
		DiagramDocumentEditor editor = null;
		try {
			editor = (DiagramDocumentEditor) page.openEditor(
					new FileEditorInput(((IFile) resource)),
					StatechartDiagramEditor.ID);
			IGraphicalEditPart editPart = EditPartUtils
					.findEditPartForSemanticElement(editor
							.getDiagramGraphicalViewer().getRootEditPart(),
							(EObject) debugElement.getAdapter(EObject.class));
			if (editPart != null) {
				editor.getDiagramGraphicalViewer().select(editPart);
				editor.getDiagramGraphicalViewer().reveal(editPart);
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return editor;
	}

}

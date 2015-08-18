/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.model.presenter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.ui.sourcelookup.ISourceDisplay;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.yakindu.gmf.runtime.highlighting.IHighlightingSupport;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * One SCTSourceDisplay is responsible for n {@link IDynamicNotationHandler}s.
 * Each {@link IDynamicNotationHandler} controls the
 * {@link IHighlightingSupport} of an {@link IEditorPart}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTSourceDisplay implements ISourceDisplay {

	private Map<IEditorPart, IDynamicNotationHandler> handler = null;
	private ISimulationEngine container = null;
	private DebugElement debugElement;

	public SCTSourceDisplay(ISimulationEngine container) {
		this.container = container;
		handler = new HashMap<IEditorPart, IDynamicNotationHandler>();
	}

	public void displaySource(Object element, IWorkbenchPage page, boolean forceSourceLookup) {
		debugElement = (DebugElement) element;
		IEditorPart editor = openEditor(debugElement, page);
		displaySource(editor);
	}

	private void displaySource(IEditorPart editor) {
		IDynamicNotationHandler notationHandler = handler.get(editor);
		if (notationHandler == null) {
			notationHandler = new DefaultDynamicNotationHandler();
			IHighlightingSupport support = (IHighlightingSupport) editor.getAdapter(IHighlightingSupport.class);
			if (support == null)
				return;
			notationHandler.setHighlightingSupport(support);
			handler.put(editor, notationHandler);
		}
		if (notationHandler.getHighlightingSupport().isLocked()) {
			notationHandler.getHighlightingSupport().releaseEditor();
		}
		notationHandler.getHighlightingSupport().lockEditor();
		notationHandler.updateExecutionContext(container.getExecutionContext());
	}

	public void terminate() {
		container = null;
		debugElement = null;
		Collection<IDynamicNotationHandler> values = handler.values();
		for (IDynamicNotationHandler notationHandler : values) {
			if (notationHandler.getHighlightingSupport().isLocked())
				notationHandler.getHighlightingSupport().releaseEditor();
		}
		handler.clear();
	}

	private IEditorPart openEditor(DebugElement debugElement, IWorkbenchPage page) {
		EObject semanticObject = (EObject) debugElement.getAdapter(EObject.class);
		IFile file = (IFile) debugElement.getAdapter(IFile.class);
		if (file == null)
			file = WorkspaceSynchronizer.getFile(semanticObject.eResource());

		// check if an editor for the resource is already open, the return the
		// opened editor.
		// This is important for simulating subdiagrams
		IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();
		if (activeEditor != null) {
			IEditorInput editorInput = activeEditor.getEditorInput();
			if (editorInput instanceof IFileEditorInput) {
				if (((IFileEditorInput) editorInput).getFile().equals(file))
					return activeEditor;
			}
		}
		// check if a Diagram is available and open the editor for the
		// corresponding diagram
		Diagram diagram = DiagramPartitioningUtil.getDiagramContaining(semanticObject);
		if (diagram != null) {
			if (URIConverter.INSTANCE.exists(semanticObject.eResource().getURI(), null)) {
				Resource sharedDomainResource = DiagramPartitioningUtil.getSharedDomain().getResourceSet()
						.getResource(semanticObject.eResource().getURI(), true);

				Collection<Diagram> contents = EcoreUtil.getObjectsByType(sharedDomainResource.getContents(),
						NotationPackage.Literals.DIAGRAM);
				for (Diagram diag : contents) {
					if (EcoreUtil.getURI(diag.getElement()).equals(EcoreUtil.getURI(diagram.getElement()))) {
						return DiagramPartitioningUtil.openEditor((Diagram) diag);
					}
				}
			}
			// No diagram for the semantic element -> open the default editor
			// for the file
		} else {
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			try {
				return page.openEditor(new FileEditorInput(file), desc.getId());
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		// No editor found
		throw new RuntimeException("No editor found for semantic element " + semanticObject);
	}
}
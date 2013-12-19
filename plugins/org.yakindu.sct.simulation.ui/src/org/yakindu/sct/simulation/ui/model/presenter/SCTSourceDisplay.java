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
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;

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

	public SCTSourceDisplay(ISimulationEngine container) {
		this.container = container;
		handler = new HashMap<IEditorPart, IDynamicNotationHandler>();
	}

	public void displaySource(Object element, IWorkbenchPage page, boolean forceSourceLookup) {
		DebugElement debugElement = (DebugElement) element;
		IEditorPart editor = openEditor(debugElement, page);
		IDynamicNotationHandler notationHandler = handler.get(editor);
		if (notationHandler == null) {
			notationHandler = new DefaultDynamicNotationHandler();
			IHighlightingSupport support = (IHighlightingSupport) editor.getAdapter(IHighlightingSupport.class);
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
		Collection<IDynamicNotationHandler> values = handler.values();
		for (IDynamicNotationHandler notationHandler : values) {
			if (notationHandler.getHighlightingSupport().isLocked())
				notationHandler.getHighlightingSupport().releaseEditor();
		}
	}

	private IEditorPart openEditor(DebugElement debugElement, IWorkbenchPage page) {
		EObject semanticObject = (EObject) debugElement.getAdapter(EObject.class);

		Diagram diagram = DiagramPartitioningUtil.getDiagramContaining(semanticObject);
		if (diagram != null) {
			if (URIConverter.INSTANCE.exists(semanticObject.eResource().getURI(), null)) {
				Resource sharedDomainResource = DiagramPartitioningUtil.getSharedDomain().getResourceSet()
						.getResource(semanticObject.eResource().getURI(), true);

				Collection<Diagram> contents = EcoreUtil.getObjectsByType(sharedDomainResource.getContents(),
						NotationPackage.Literals.DIAGRAM);
				for (Diagram diag : contents) {
					if (EcoreUtil.equals(diag.getElement(), diagram.getElement())) {
						return DiagramPartitioningUtil.openEditor((Diagram) diag);
					}
				}
			}
			// No diagram for the semantic element -> open the default editor
			// for the file
		} else {
			IFile file = (IFile) debugElement.getAdapter(IFile.class);
			if (file == null)
				file = WorkspaceSynchronizer.getFile(semanticObject.eResource());
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			try {
				return page.openEditor(new FileEditorInput(file), desc.getId());
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException("No editor found for semantic element " + semanticObject);
	}

}
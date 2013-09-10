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

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.ui.sourcelookup.ISourceDisplay;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
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
		Resource sharedDomainResource = DiagramPartitioningUtil.getSharedDomain().getResourceSet()
				.getResource(semanticObject.eResource().getURI(), true);
		Collection<Diagram> contents = EcoreUtil.getObjectsByType(sharedDomainResource.getContents(),
				NotationPackage.Literals.DIAGRAM);
		for (Diagram diag : contents) {
			if (EcoreUtil.equals(diag.getElement(), diagram.getElement())) {
				return DiagramPartitioningUtil.openEditor((Diagram) diag);
			}
		}
		throw new RuntimeException("No Diagram found for semantic object " + semanticObject);
	}

}
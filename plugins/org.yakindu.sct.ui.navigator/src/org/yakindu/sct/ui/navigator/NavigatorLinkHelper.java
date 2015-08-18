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
package org.yakindu.sct.ui.navigator;

import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;
import org.yakindu.base.xtext.utils.jface.viewers.util.ActiveEditorTracker;
import org.yakindu.sct.ui.navigator.utils.ComposedAdapterFactoryUtil;

/**
 * 
 * @author m.muehlbrandt
 * 
 */
public class NavigatorLinkHelper implements ILinkHelper {

	private AdapterFactoryContentProvider myAdapterFctoryContentProvier;

	public NavigatorLinkHelper() {
		myAdapterFctoryContentProvier = new AdapterFactoryContentProvider(
				ComposedAdapterFactoryUtil.FACTORY);
	}

	private static IEditorInput getEditorInput(Diagram diagram) {
		Resource diagramResource = diagram.eResource();
		for (Iterator<EObject> it = diagramResource.getContents().iterator(); it
				.hasNext();) {
			EObject nextEObject = (EObject) it.next();
			if (nextEObject == diagram) {
				return new FileEditorInput(
						WorkspaceSynchronizer.getFile(diagramResource));
			}
			if (nextEObject instanceof Diagram) {
				break;
			}
		}
		URI uri = EcoreUtil.getURI(diagram);
		String editorName = uri.lastSegment() + "#"
				+ diagram.eResource().getContents().indexOf(diagram);
		IEditorInput editorInput = new URIEditorInput(uri, editorName);
		return editorInput;
	}

	public IStructuredSelection findSelection(IEditorInput anInput) {
		IEditorPart activeEditor = ActiveEditorTracker.getLastActiveEditor();
		if (activeEditor instanceof DiagramDocumentEditor) {
			Diagram diagram = ((DiagramDocumentEditor) activeEditor)
					.getDiagram();
			IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
			if (file != null) {
				DomainNavigatorItem item = new DomainNavigatorItem(diagram,
						file, myAdapterFctoryContentProvier);
				return new StructuredSelection(item);
			}
		}
		return StructuredSelection.EMPTY;
	}

	public void activateEditor(IWorkbenchPage aPage,
			IStructuredSelection aSelection) {

		if (aSelection == null || aSelection.isEmpty()) {
			return;
		}
		if (false == aSelection.getFirstElement() instanceof DomainNavigatorItem) {
			return;
		}

		DomainNavigatorItem abstractNavigatorItem = (DomainNavigatorItem) aSelection
				.getFirstElement();

		View navigatorView = abstractNavigatorItem.getView();
		if (navigatorView == null) {
			return;
		}
		IEditorInput editorInput = getEditorInput(navigatorView.getDiagram());
		IEditorPart editor = aPage.findEditor(editorInput);
		if (editor == null) {
			return;
		}
		aPage.bringToTop(editor);
		if (editor instanceof DiagramEditor) {
			DiagramEditor diagramEditor = (DiagramEditor) editor;
			ResourceSet diagramEditorResourceSet = diagramEditor
					.getEditingDomain().getResourceSet();
			EObject selectedView = diagramEditorResourceSet.getEObject(
					EcoreUtil.getURI(navigatorView), true);
			if (selectedView == null) {
				return;
			}
			GraphicalViewer graphicalViewer = (GraphicalViewer) diagramEditor
					.getAdapter(GraphicalViewer.class);
			EditPart selectedEditPart = (EditPart) graphicalViewer
					.getEditPartRegistry().get(selectedView);
			if (selectedEditPart != null) {
				graphicalViewer.select(selectedEditPart);
				graphicalViewer.reveal(selectedEditPart);
			}
		}
	}
}
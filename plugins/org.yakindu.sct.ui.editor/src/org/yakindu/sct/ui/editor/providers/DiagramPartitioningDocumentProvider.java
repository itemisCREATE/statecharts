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
package org.yakindu.sct.ui.editor.providers;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileEditorInputProxy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.yakindu.sct.ui.editor.breadcrumb.DiagramEditorInput;
import org.yakindu.sct.ui.editor.breadcrumb.DiagramPartitioningUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DiagramPartitioningDocumentProvider extends FileDiagramDocumentProvider {

	public IEditorInput createInputWithEditingDomain(IEditorInput editorInput, TransactionalEditingDomain domain) {
		if (editorInput instanceof DiagramEditorInput) {
			return editorInput;
		}
		return super.createInputWithEditingDomain(editorInput, DiagramPartitioningUtil.getSharedDomain());
	}

	@Override
	protected IDocument createEmptyDocument() {
		DiagramDocument diagramDocument = new DiagramDocument();
		diagramDocument.setEditingDomain(DiagramPartitioningUtil.getSharedDomain());
		return diagramDocument;
	}

	@Override
	protected ElementInfo createElementInfo(Object element) throws CoreException {
		ElementInfo info = super.createElementInfo(element);
		info.fCanBeSaved = isDirty(DiagramPartitioningUtil.getSharedDomain());
		return info;
	}

	protected boolean isDirty(TransactionalEditingDomain domain) {
		for (final Resource resource : domain.getResourceSet().getResources()) {
			if (resource.isLoaded() && !domain.isReadOnly(resource) && resource.isModified()) {
				return true;
			}
		}
		return false;
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput) throws CoreException {
		if (editorInput instanceof DiagramEditorInput) {
			Diagram diagram = ((IDiagramEditorInput) editorInput).getDiagram();
			document.setContent(diagram);
			return true;
		} else if (editorInput instanceof FileEditorInputProxy) {
			setDocumentContentFromStorage(document, ((FileEditorInputProxy) editorInput).getFile());
			return true;
		}
		return super.setDocumentContent(document, editorInput);
	}

	@Override
	protected void disposeElementInfo(Object element, ElementInfo info) {
		Object content = info.fDocument.getContent();
		info.fDocument.setContent(null);
		// Unset the content first to avoid call to DiagramIOUtil.unload
		super.disposeElementInfo(element, info);
		info.fDocument.setContent(content);
	}

}

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
package org.yakindu.sct.ui.editor.partitioning;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramModificationListener;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileDiagramModificationListener;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileEditorInputProxy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;

/**
 * Implementation of the {@link IDiagramDocumentProvider} interface that extends
 * a {@link FileDiagramDocumentProvider}.
 * 
 * In addition to the {@link FileDiagramDocumentProvider}, this implementation
 * acts on a shared editing domain and can handle custom
 * {@link DiagramEditorInput}. It also unloads non used resources with help of
 * the {@link ResourceUnloadingTool}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DiagramPartitioningDocumentProvider extends FileDiagramDocumentProvider {

	/**
	 * Extension of {@link DiagramFileInfo} that stores the given
	 * {@link IEditorInput} which is required for the
	 * {@link ResourceUnloadingTool}
	 */
	protected class InputDiagramFileInfo extends DiagramFileInfo {

		private final IEditorInput editorInput;

		public InputDiagramFileInfo(IDocument document, FileSynchronizer fileSynchronizer,
				DiagramModificationListener listener, IEditorInput editorInput) {
			super(document, fileSynchronizer, listener);
			this.editorInput = editorInput;
		}

		public IEditorInput getEditorInput() {
			return editorInput;
		}
	}

	public IEditorInput createInputWithEditingDomain(IEditorInput editorInput, TransactionalEditingDomain domain) {
		if (editorInput instanceof DiagramEditorInput) {
			return editorInput;
		}
		return super.createInputWithEditingDomain(editorInput, DiagramPartitioningUtil.getSharedDomain());
	}

	/**
	 * Sets the {@link EditingDomain} to the shared instance
	 */
	@Override
	protected IDocument createEmptyDocument() {
		DiagramDocument diagramDocument = new DiagramDocument();
		diagramDocument.setEditingDomain(DiagramPartitioningUtil.getSharedDomain());
		return diagramDocument;
	}

	@Override
	protected ElementInfo createElementInfo(Object element) throws CoreException {
		ElementInfo info = super.createElementInfo(element);
		if (element instanceof IDiagramEditorInput) {
			Resource eResource = ((IDiagramEditorInput) element).getDiagram().eResource();
			TransactionalEditingDomain sharedDomain = DiagramPartitioningUtil.getSharedDomain();
			if (eResource.isLoaded() && !sharedDomain.isReadOnly(eResource) && eResource.isModified()) {
				info.fCanBeSaved = true;
			}
		}
		return info;
	}

	protected FileInfo createFileInfo(IDocument document, FileSynchronizer synchronizer, IFileEditorInput input) {
		assert document instanceof DiagramDocument;

		DiagramModificationListener diagramListener = null;
		if (((DiagramDocument) document).getDiagram() != null) {
			diagramListener = new FileDiagramModificationListener(this, (DiagramDocument) document, input);
		}
		InputDiagramFileInfo info = new InputDiagramFileInfo(document, synchronizer, diagramListener, input);
		if (diagramListener != null)
			diagramListener.startListening();
		return info;
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput) throws CoreException {
		if (editorInput instanceof IDiagramEditorInput) {
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
		if (content instanceof Diagram && info instanceof InputDiagramFileInfo) {
			// Unload non needed resources
			ResourceUnloadingTool.unloadEditorInput(DiagramPartitioningUtil.getSharedDomain().getResourceSet(),
					((InputDiagramFileInfo) info).getEditorInput());
		}
	}

}

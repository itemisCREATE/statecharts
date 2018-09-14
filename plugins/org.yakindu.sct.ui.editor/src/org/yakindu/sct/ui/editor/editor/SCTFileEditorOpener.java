/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.ui.editor.editor;

import java.util.Arrays;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * Opens <code>.sct</code> files in corresponding statechart diagramm editor.
 * 
 * @author thomas kutz - Initial contribution and API
 *
 */
public class SCTFileEditorOpener implements IURIEditorOpener {

	@Override
	public IEditorPart open(URI uri, boolean select) {
		try {
			IFile fileToOpen = toFile(uri);
			if (fileToOpen != null) {
				IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
						.openEditor(new FileEditorInput(fileToOpen), getEditorID());

				if (editor instanceof DiagramEditor) {
					DiagramEditor diagramEditor = (DiagramEditor) editor;
					EObject targetElement = (EObject) diagramEditor.getDiagram().eResource().getEObject(uri.fragment());
					if (targetElement == null) {
						return editor;
					}
					View view = DiagramPartitioningUtil.findNotationView(targetElement);
					if (view == null) {
						return editor;
					}
					Diagram element = DiagramPartitioningUtil.getDiagramContaining(view.getElement());
					diagramEditor = (DiagramEditor) DiagramPartitioningUtil.openEditor(element);
					@SuppressWarnings("rawtypes")
					Map editPartRegistry = diagramEditor.getDiagramGraphicalViewer().getEditPartRegistry();
					EditPart targetEditPart = (EditPart) editPartRegistry.get(view);
					if (targetEditPart != null) {
						DiagramPartitioningUtil.selectElementsInDiagram(diagramEditor,
								Arrays.asList(new EditPart[] { targetEditPart }));
					}
					return diagramEditor;
				}
				return editor;
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected String getEditorID() {
		return StatechartDiagramEditor.ID;
	}

	@Override
	public IEditorPart open(URI referenceOwnerURI, EReference reference, int indexInList, boolean select) {
		return open(referenceOwnerURI, select);
	}

	public IFile toFile(URI uri) {
		if (uri.isPlatformResource()) {
			String platformString = uri.toPlatformString(true);
			return (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		}
		return null;
	}

}

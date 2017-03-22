/**
 * Copyright (c) 2010 - 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.providers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.ui.providers.marker.AbstractModelMarkerNavigationProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.xtext.utils.gmf.directedit.IXtextAwareEditPart;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.validation.IMarkerType;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartMarkerNavigationProvider extends AbstractModelMarkerNavigationProvider implements IMarkerType {

	@Override
	@SuppressWarnings("rawtypes")
	protected void doGotoMarker(IMarker marker) {

		String elementId = marker.getAttribute(org.eclipse.gmf.runtime.common.core.resources.IMarker.ELEMENT_ID, null);
		if (elementId == null || !(getEditor() instanceof DiagramEditor)) {
			return;
		}
		DiagramEditor editor = (DiagramEditor) getEditor();
		EObject targetElement = (EObject) editor.getDiagram().eResource().getEObject(elementId);
		if (targetElement == null) {
			return;
		}
		View view = findNotationView(targetElement);
		if (view == null) {
			return;
		}
		Diagram element = DiagramPartitioningUtil.getDiagramContaining(view.getElement());
		editor = (DiagramEditor) DiagramPartitioningUtil.openEditor(element);
		Map editPartRegistry = editor.getDiagramGraphicalViewer().getEditPartRegistry();

		EditPart targetEditPart = (EditPart) editPartRegistry.get(view);
		if (targetEditPart != null) {
			selectElementsInDiagram(editor, Arrays.asList(new EditPart[] { targetEditPart }));
		}

		try {
			String type = marker.getType();
			if (type.equals(SCT_MARKER_TYPE)) {
				final DirectEditRequest request = new DirectEditRequest();
				request.setDirectEditFeature(SGraphPackage.eINSTANCE.getSpecificationElement_Specification());
				List<EObject> allNotationElements = EcoreUtil2.eAllContentsAsList(view);
				for (EObject eObject : allNotationElements) {
					if (eObject instanceof View) {
						IGraphicalEditPart editPart = (IGraphicalEditPart) editPartRegistry.get(eObject);
						if (editPart instanceof IXtextAwareEditPart) {
							editPart.performRequest(request);
						}
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	protected View findNotationView(EObject semanticElement) {
		Collection<Diagram> objects = EcoreUtil.getObjectsByType(semanticElement.eResource().getContents(),
				NotationPackage.Literals.DIAGRAM);
		for (Diagram diagram : objects) {
			TreeIterator<EObject> eAllContents = diagram.eAllContents();
			while (eAllContents.hasNext()) {
				EObject next = eAllContents.next();
				if (next instanceof View) {
					if (((View) next).getElement() == semanticElement) {
						return ((View) next);
					}
				}
			}
		}
		return null;
	}

	public void selectElementsInDiagram(IDiagramWorkbenchPart diagramPart, List<EditPart> editParts) {
		diagramPart.getDiagramGraphicalViewer().deselectAll();

		EditPart firstPrimary = null;
		for (Iterator<EditPart> it = editParts.iterator(); it.hasNext();) {
			EditPart nextPart = it.next();
			diagramPart.getDiagramGraphicalViewer().appendSelection(nextPart);
			if (firstPrimary == null && nextPart instanceof IPrimaryEditPart) {
				firstPrimary = nextPart;
			}
		}
		if (!editParts.isEmpty()) {
			diagramPart.getDiagramGraphicalViewer()
					.reveal(firstPrimary != null ? firstPrimary : (EditPart) editParts.get(0));
		}
	}

}

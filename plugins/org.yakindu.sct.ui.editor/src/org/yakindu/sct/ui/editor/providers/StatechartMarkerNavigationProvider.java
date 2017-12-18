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
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.ui.providers.marker.AbstractModelMarkerNavigationProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.xtext.utils.gmf.directedit.IXtextAwareEditPart;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerType;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartMarkerNavigationProvider extends AbstractModelMarkerNavigationProvider {

	@Override
	@SuppressWarnings("rawtypes")
	protected void doGotoMarker(IMarker marker) {

		String elementId = marker.getAttribute(SCTMarkerType.SEMANTIC_ELEMENT_ID, null);
		if (elementId == null || !(getEditor() instanceof DiagramEditor)) {
			return;
		}
		DiagramEditor editor = (DiagramEditor) getEditor();
		EObject targetElement = (EObject) editor.getDiagram().eResource().getEObject(elementId);
		if (targetElement == null) {
			return;
		}
		View view = DiagramPartitioningUtil.findNotationView(targetElement);
		if (view == null) {
			return;
		}
		Diagram element = DiagramPartitioningUtil.getDiagramContaining(view.getElement());
		editor = (DiagramEditor) DiagramPartitioningUtil.openEditor(element);
		Map editPartRegistry = editor.getDiagramGraphicalViewer().getEditPartRegistry();

		EditPart targetEditPart = (EditPart) editPartRegistry.get(view);
		if (targetEditPart != null) {
			if(!targetEditPart.isSelectable()) return;
			DiagramPartitioningUtil.selectElementsInDiagram(editor, Arrays.asList(new EditPart[] { targetEditPart }));
		}

		try {
			if (marker.isSubtypeOf(SCTMarkerType.SUPERTYPE)) {
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

}

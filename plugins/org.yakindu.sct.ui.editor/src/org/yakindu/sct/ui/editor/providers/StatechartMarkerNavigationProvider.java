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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.ui.providers.marker.AbstractModelMarkerNavigationProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.gmf.runtime.editparts.TextAwareLabelEditPart;
import org.yakindu.base.xtext.utils.gmf.directedit.IXtextAwareEditPart;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.ui.validation.SCTMarkerType;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;

/**
 *
 * @author andreas muelder
 *
 */
public class StatechartMarkerNavigationProvider extends AbstractModelMarkerNavigationProvider {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.gmf.runtime.common.ui.services.marker.
	 * AbstractMarkerNavigationProvider#doGotoMarker(org.eclipse.core.resources.
	 * IMarker)
	 */
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
			if (!targetEditPart.isSelectable())
				return;
			DiagramPartitioningUtil.selectElementsInDiagram(editor, Arrays.asList(new EditPart[]{targetEditPart}));
		}

		try {
			if (marker.isSubtypeOf(SCTMarkerType.SUPERTYPE)) {
				final DirectEditRequest request = new DirectEditRequest();
				request.setDirectEditFeature(getEditFeature(targetElement, marker));
				List<IGraphicalEditPart> allEditParts = getEditParts(editPartRegistry,
						EcoreUtil2.eAllContentsAsList(view));

				for (IGraphicalEditPart editPart : allEditParts) {
					if (editPart instanceof IXtextAwareEditPart
							|| (editPart instanceof TextAwareLabelEditPart) && ((TextAwareLabelEditPart) editPart)
									.getFeature().equals(request.getDirectEditFeature())) {
						editPart.performRequest(request);
						break;
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	protected List<IGraphicalEditPart> getEditParts(Map<?, ?> editPartRegistry, Iterable<EObject> eObjects) {
		List<IGraphicalEditPart> editParts = new ArrayList<>();
		for (EObject e : eObjects) {
			if (e instanceof View) {
				editParts.add((IGraphicalEditPart) editPartRegistry.get(e));
			}
		}
		return editParts;
	}

	protected EAttribute getEditFeature(EObject targetObject, IMarker marker) {
		EAttribute defaultAttr = SGraphPackage.eINSTANCE.getSpecificationElement_Specification();
		if (targetObject == null) {
			return defaultAttr;
		}
		if (targetObject instanceof Vertex && isReasonNamedElementName(marker)) {
			return BasePackage.eINSTANCE.getNamedElement_Name();
		} else {
			return defaultAttr;
		}
	}

	protected boolean isReasonNamedElementName(IMarker marker) {
		return containsAttribute(marker, SCTMarkerType.NAMEDELEMENT_NAME);
	}

	protected boolean isReasonSpecificationElementSpecification(IMarker marker) {
		return containsAttribute(marker, SCTMarkerType.SPECIFICATIONELMENT_SPECIFICATION);
	}

	protected boolean containsAttribute(IMarker marker, String attributeName) {
		try {
			Object attribute = marker.getAttribute(attributeName);
			return attribute != null;
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return false;
	}

}

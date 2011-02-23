package org.yakindu.sct.statechart.diagram.providers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.ui.providers.marker.AbstractModelMarkerNavigationProvider;
/**
 * 
 * @author muelder
 *
 */
public class StatechartMarkerNavigationProvider extends
		AbstractModelMarkerNavigationProvider {

	@SuppressWarnings("rawtypes")
	protected void doGotoMarker(IMarker marker) {
		String elementId = marker
				.getAttribute(
						org.eclipse.gmf.runtime.common.core.resources.IMarker.ELEMENT_ID,
						null);
		if (elementId == null || !(getEditor() instanceof DiagramEditor)) {
			return;
		}
		DiagramEditor editor = (DiagramEditor) getEditor();
		Map editPartRegistry = editor.getDiagramGraphicalViewer()
				.getEditPartRegistry();
		EObject targetView = editor.getDiagram().eResource()
				.getEObject(elementId);
		if (targetView == null) {
			return;
		}
		EditPart targetEditPart = (EditPart) editPartRegistry.get(targetView);
		if (targetEditPart != null) {
			selectElementsInDiagram(editor,
					Arrays.asList(new EditPart[] { targetEditPart }));
		}
	}

	public static void selectElementsInDiagram(
			IDiagramWorkbenchPart diagramPart, List<EditPart> editParts) {
		diagramPart.getDiagramGraphicalViewer().deselectAll();

		EditPart firstPrimary = null;
		for (Iterator<EditPart> it = editParts.iterator(); it.hasNext();) {
			EditPart nextPart = (EditPart) it.next();
			diagramPart.getDiagramGraphicalViewer().appendSelection(nextPart);
			if (firstPrimary == null && nextPart instanceof IPrimaryEditPart) {
				firstPrimary = nextPart;
			}
		}
		if (!editParts.isEmpty()) {
			diagramPart.getDiagramGraphicalViewer().reveal(
					firstPrimary != null ? firstPrimary : (EditPart) editParts
							.get(0));
		}
	}

}

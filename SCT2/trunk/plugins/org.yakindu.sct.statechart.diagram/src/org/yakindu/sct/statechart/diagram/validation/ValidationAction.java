package org.yakindu.sct.statechart.diagram.validation;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

/**
 * 
 * @author muelder
 * 
 */
public class ValidationAction implements IMarkerType {

	public static void validate(DiagramEditPart diagramEditPart, Diagram view) {
		IFile target = GMFMarkerUtil.getTargetFile(view);
		if (target != null) {
			try {
				target.deleteMarkers(DIAGRAM_MARKER_TYPE, true,
						IResource.DEPTH_ZERO);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		// // Ecore constraints
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(view
				.getElement());
		List<Diagnostic> children = diagnostic.getChildren();
		for (Diagnostic child : children) {
			GMFMarkerUtil.createMarker(target,
					BasicDiagnostic.toIStatus(child), view,
					DIAGRAM_MARKER_TYPE, (EObject) child.getData().get(0));
		}

		InjectMembersResource resource = (InjectMembersResource) view
				.eResource();
		List<Diagnostic> diagnostics = resource.getDiagnostics();
		for (Diagnostic child : diagnostics) {
			GMFMarkerUtil.createMarker(target,
					BasicDiagnostic.toIStatus(child), view,
					DIAGRAM_MARKER_TYPE, (EObject) child.getData().get(0));
		}

	}

}
